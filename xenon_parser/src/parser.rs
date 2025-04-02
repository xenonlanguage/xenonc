use either::Either;
use xenon_ast::ast::{Block, Expression, FunctionDeclaration, ModuleDeclaration, ModuleMember, Parameter, Path, Program, ProgramMember, Statement, StructDeclaration, TraitDeclaration, Type, UseDeclaration, VariableDeclaration};
use xenon_ast::{Safety, Visibility};
use xenon_lexer::token::{Token, TokenKind};

pub struct ParseError {
    pub message: String,
}

pub struct Parser {
    pub tokens: Vec<Token>,
    pub position: usize,
}
impl Parser {
    pub fn new(tokens: Vec<Token>) -> Self {
        Self { tokens, position: 0 }
    }

    pub fn parse_program(&mut self, file_name: String) -> Result<Program, ParseError> {
        let mut program = Program {
            file_name,
            members: vec![]
        };

        while self.peek(0).is_ok() {
            program.members.push(self.parse_program_member()?);
        }

        Ok(program)
    }

    pub fn parse_modifiers(&mut self) -> Result<Vec<TokenKind>, ParseError> {
        let mut modifiers = vec![];

        while let Ok(token) = self.peek(0) {
            match token.kind {
                TokenKind::ConstKw
                | TokenKind::ExternKw
                | TokenKind::PublicKw
                | TokenKind::PrivateKw
                | TokenKind::UnsafeKw
                | TokenKind::AsyncKw
                | TokenKind::AbstractKw
                | TokenKind::OverrideKw
                | TokenKind::VirtualKw
                | TokenKind::SafeKw
                => {
                    modifiers.push(token.kind);
                    self.consume()?;
                },
                _ => break
            }
        }

        Ok(modifiers)
    }

    pub fn parse_program_member(&mut self) -> Result<ProgramMember, ParseError> {
        let modifiers = self.parse_modifiers()?;

        let token = self.peek(0)?;

        match token.kind {
            TokenKind::FnKw => {
                Ok(ProgramMember::FunctionDeclaration(self.parse_function_declaration(modifiers)?))
            }
            TokenKind::LetKw => {
                Ok(ProgramMember::VariableDeclaration(self.parse_variable_declaration(modifiers)?))
            }
            TokenKind::StructKw => {
                Ok(ProgramMember::StructDeclaration(self.parse_struct_declaration(modifiers)?))
            }
            TokenKind::TraitKw => {
                Ok(ProgramMember::TraitDeclaration(self.parse_trait_declaration(modifiers)?))
            }
            TokenKind::UseKw => {
                Ok(ProgramMember::UseDeclaration(self.parse_use_declaration(modifiers)?))
            }
            TokenKind::ModuleKw => {
                Ok(ProgramMember::ModuleDeclaration(self.parse_module_declaration(modifiers)?))
            }
            _ => {
                Err(self.gen_error("Unexpected token. Expected Program member.".to_string()))
            }
        }
    }

    pub fn parse_function_declaration(&mut self, modifiers: Vec<TokenKind>) -> Result<FunctionDeclaration, ParseError> {
        let mut function = FunctionDeclaration {
            body: None,
            is_async: false,
            is_override: false,
            is_virtual: false,
            is_extern: false,
            name: "".to_string(),
            parameters: vec![],
            safety: Safety::Safe,
            r#type: None,
            visibility: Visibility::Public
        };

        for modifier in modifiers {
            if modifier == TokenKind::AsyncKw {
                function.is_async = true;
            }
            else if modifier == TokenKind::OverrideKw {
                function.is_override = true;
            }
            else if modifier == TokenKind::VirtualKw {
                function.is_virtual = true;
            }
            else if modifier == TokenKind::ExternKw {
                function.is_extern = true;
            }
            else if modifier == TokenKind::UnsafeKw {
                function.safety = Safety::Unsafe;
            }
            else if modifier == TokenKind::SafeKw {
                function.safety = Safety::Safe;
            }
            else if modifier == TokenKind::PublicKw {
                function.visibility = Visibility::Public;
            }
            else if modifier == TokenKind::PrivateKw {
                function.visibility = Visibility::Private;
            }
            else {
                return Err(self.gen_error(format!("Modifier {:#?} is not valid for function declaration", modifier)));
            }
        }

        self.consume()?; // Skip 'fn'

        function.name = self.consume()?.value;

        self.consume()?; // Skip '('

        while !self.match_token(TokenKind::CloseParen, 0)? {
            function.parameters.push(self.parse_parameter()?);
        }

        if self.match_token(TokenKind::Minus, 0)? {
            self.consume()?; // Skip '-'
            self.consume()?; // Skip '>'
            function.r#type = Some(self.parse_type()?);
        }

        if self.match_token(TokenKind::OpenBrace, 0)? {
            function.body = Some(self.parse_block()?);
        }
        else {
            self.consume()?; // Skip ';'
        }

        Ok(function)
    }

    pub fn parse_block(&mut self) -> Result<Block, ParseError> {
        let mut block = Block {
            statements: vec![]
        };
        self.consume()?; // SKip '{'

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            block.statements.push(self.parse_statement()?);
        }

        self.consume()?; // Skip '}'


        return Ok(block);
    }

    pub fn parse_type(&mut self) -> Result<Type, ParseError> {
        if self.match_token(TokenKind::Star, 0)? {
            self.consume()?; // Skip '*'
            return Ok(Type::PointerType(Box::new(self.parse_type()?)))
        }
        else if self.match_token(TokenKind::RefKw, 0)? {
            self.consume()?; // Skip 'ref'
            return Ok(Type::ReferenceType(Box::new(self.parse_type()?)))
        }
        else if self.match_token(TokenKind::OpenParen, 0)? {
            return Ok(self.parse_tuple_type()?);
        }
        else if self.match_token(TokenKind::Name, 0)? {
            return Ok(Type::PathType(self.parse_path()?));
        }
        else if self.match_token_array(&[TokenKind::I8Kw, TokenKind::I16Kw, TokenKind::I32Kw, TokenKind::I64Kw, TokenKind::U8Kw, TokenKind::U16Kw, TokenKind::U32Kw, TokenKind::U64Kw, TokenKind::F16Kw, TokenKind::F32Kw, TokenKind::F64Kw, TokenKind::BoolKw, TokenKind::CharKw], 0)? {
            return Ok(Type::PrimativeType(self.consume()?.value));
        }
        else {
            return Err(self.gen_error("Unexpected token. Expected type.".to_string()));
        }
    }

    pub fn parse_tuple_type(&mut self) -> Result<Type, ParseError> {
        let mut tuple = vec![];

        while !self.match_token(TokenKind::CloseParen, 0)? {
            tuple.push(self.parse_type()?);
            self.consume()?; // Skip ','
        }

        return Ok(Type::TupleType(tuple));
    }

    pub fn parse_variable_declaration(&mut self, modifiers: Vec<TokenKind>) -> Result<VariableDeclaration, ParseError> {
        let mut variable = VariableDeclaration {
            is_extern: false,
            is_const: false,
            name: "".to_string(),
            safety: Safety::Safe,
            r#type: None,
            visibility: Visibility::Public,
            value: None,
        };

        for modifier in modifiers {
            if modifier == TokenKind::ExternKw {
                variable.is_extern = true;
            }
            else if modifier == TokenKind::ConstKw {
                variable.is_const = true;
            }
            else if modifier == TokenKind::UnsafeKw {
                variable.safety = Safety::Unsafe;
            }
            else if modifier == TokenKind::SafeKw {
                variable.safety = Safety::Safe;
            }
            else if modifier == TokenKind::PublicKw {
                variable.visibility = Visibility::Public;
            }
            else if modifier == TokenKind::PrivateKw {
                variable.visibility = Visibility::Private;
            }
            else {
                return Err(self.gen_error(format!("Modifier {:#?} is not valid for variable declaration", modifier)));
            }
        }

        self.consume()?; // Skip 'let'

        variable.name = self.consume()?.value;

        if self.match_token(TokenKind::Colon, 0)? {
            self.consume()?; // Skip ':'
            variable.r#type = Some(self.parse_type()?);
        }

        if self.match_token(TokenKind::Equal, 0)? {
            self.consume()?; // Skip '='
            variable.value = self.parse_expression();
        }

        self.consume()?; // Skip ';'

        Ok(variable)
    }

    pub fn parse_expression(&mut self) -> Result<Expression, ParseError> {

    }

    pub fn parse_struct_declaration(&mut self, modifiers: Vec<TokenKind>) -> Result<StructDeclaration, ParseError> {
        let mut struc = StructDeclaration {
            items: vec![],
            inherits: vec![],
            is_abstract: false,
            name: "".to_string(),
            safety: Safety::Safe,
            visibility: Visibility::Public
        };

        for modifier in modifiers {
            if modifier == TokenKind::AbstractKw {
                struc.is_abstract = true;
            }
            else if modifier == TokenKind::UnsafeKw {
                struc.safety = Safety::Unsafe;
            }
            else if modifier == TokenKind::SafeKw {
                struc.safety = Safety::Safe;
            }
            else if modifier == TokenKind::PublicKw {
                struc.visibility = Visibility::Public;
            }
            else if modifier == TokenKind::PrivateKw {
                struc.visibility = Visibility::Private;
            }
            else {
                return Err(self.gen_error(format!("Modifier {:#?} is not valid for struct declaration", modifier)));
            }
        }

        self.consume()?; // Skip 'struct' keyword

        struc.name = self.consume()?.value;

        if self.match_token(TokenKind::Colon, 0)? {
            self.consume()?; // Skip ':'

            while !self.match_token(TokenKind::OpenBrace, 0)? {
                struc.inherits.push(self.parse_path()?);
            }
        }

        self.consume()?; // Skip '{'

        let mut modifiers = self.parse_modifiers()?;

        while !self.match_token(TokenKind::CloseBrace, 0)? {

            match self.peek(0)?.kind {
                TokenKind::FnKw => {
                    struc.items.push(Either::Left(self.parse_function_declaration(modifiers.clone())?));
                }
                TokenKind::LetKw => {
                    struc.items.push(Either::Right(self.parse_variable_declaration(modifiers.clone())?));
                }
                _ => {
                    return Err(self.gen_error("Unexpected token. Expected Struct item.".to_string()));
                }
            }

            modifiers.clear();
        }

        self.consume()?; // Skip '}'

        Ok(struc)
    }

    pub fn parse_parameter(&mut self) -> Result<Parameter, ParseError> {
        let mut param = Parameter {
            name: "".to_string(),
            r#type: Type::PrimativeType("void".to_string())
        };

        param.name = self.consume()?.value;

        self.consume()?; // SKip ':'

        param.r#type = self.parse_type()?;

        Ok(param)
    }

    pub fn parse_statement(&mut self) -> Result<Statement, ParseError> {
        if self.match_token(TokenKind::Name, 0)? {
            if self.is_variable_assignment()? {
                Ok(Statement::VariableAssignment(self.parse_variable_assignment()?))
            }
            else {
                Ok(Statement::FunctionCall(self.parse_identifier()?))
            }
        }
        else if self.match_token(TokenKind::LetKw, 0)? {
            Ok(Statement::VariableDeclaration(self.parse_variable_declaration(vec![])?))
        }
        else if self.match_token(TokenKind::ForKw, 0)? {
            Ok(Statement::ForLoop(self.parse_for_loop()?))
        }
        else if self.match_token(TokenKind::IfKw, 0)? {
            Ok(Statement::IfStatement(self.parse_if_statement()?))
        }
        else if self.match_token(TokenKind::LoopKw, 0)? {
            Ok(Statement::LoopStatement(self.parse_loop_statement()?));
        }
        else if self.match_token(TokenKind::SwitchKw, 0)? {
            Ok(Statement::SwitchStatement(self.parse_switch_statement()?));
        }
        else if self.match_token(TokenKind::UnsafeKw, 0)? {
            Ok(Statement::UnsafeBlock(self.parse_unsafe_block()?))
        }
        else if self.match_token(TokenKind::WhileKw, 0)? {
            Ok(Statement::WhileLoop(self.parse_while_loop()?))
        }
        else if self.match_token(TokenKind::ReturnKw, 0)? {
            Ok(Statement::ReturnStatement(self.parse_return_statement()?))
        }
        else if self.match_token(TokenKind::ContinueKw, 0)? {
            self.consume()?;
            Ok(Statement::ContinueStatement)
        }
        else if self.match_token(TokenKind::BreakKw, 0)? {
            self.consume()?;
            Ok(Statement::BreakStatement)
        }
        else {
            Err(self.gen_error("Unexpected token. Expected statement.".to_string()))
        }
    }

    pub fn parse_path(&mut self) -> Result<Path, ParseError> {
        let mut path = Path {
            segments: vec![]
        };
        while self.match_token(TokenKind::Name, 0)? {
            path.segments.push(self.consume()?.value);
            self.consume()?; // Skip ':' x2
            self.consume()?;
        }
        Ok(path)
    }

    pub fn is_variable_assignment(&self) -> Result<bool, ParseError> {
        let mut offset = 0;

        while !self.match_token_array(&[TokenKind::Plus, TokenKind::Minus, TokenKind::Star, TokenKind::Slash, TokenKind::Percent, TokenKind::Equal], offset)? {
            if self.match_token(TokenKind::Semicolon, offset)? { // hit semicolon before assignmentt operator
                return Ok(false);
            }
            offset += 1;
        }

        return Ok(true);
    }

    pub fn parse_trait_declaration(&mut self, modifiers: Vec<TokenKind>) -> Result<TraitDeclaration, ParseError> {
        let mut r#trait = TraitDeclaration {
            items: vec![],
            name: "".to_string(),
            visibility: Visibility::Public
        };

        for modifier in modifiers {
            if modifier == TokenKind::PublicKw {
                r#trait.visibility = Visibility::Public;
            }
            else if modifier == TokenKind::PrivateKw {
                r#trait.visibility = Visibility::Private;
            }
            else {
                return Err(self.gen_error(format!("Modifier {:#?} is not valid for trait declaration", modifier)));
            }
        }

        self.consume()?; // Skip 'trait'

        r#trait.name = self.consume()?.value;

        self.consume()?; // Skip '{'

        let mut modifiers = vec![];

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            while let Ok(token) = self.peek(0) {
                match token.kind {
                    TokenKind::ConstKw
                    | TokenKind::ExternKw
                    | TokenKind::PublicKw
                    | TokenKind::PrivateKw
                    | TokenKind::UnsafeKw
                    | TokenKind::AsyncKw
                    | TokenKind::AbstractKw
                    | TokenKind::OverrideKw
                    | TokenKind::VirtualKw
                    | TokenKind::SafeKw
                    => {
                        modifiers.push(token.kind);
                        self.consume()?;
                    },
                    _ => break
                }
            }

            match self.peek(0)?.kind {
                TokenKind::FnKw => {
                    r#trait.items.push(Either::Left(self.parse_function_declaration(modifiers.clone())?));
                }
                TokenKind::LetKw => {
                    r#trait.items.push(Either::Right(self.parse_variable_declaration(modifiers.clone())?));
                }
                _ => {
                    return Err(self.gen_error("Unexpected token. Expected Struct item.".to_string()));
                }
            }

            modifiers.clear();
        }

        self.consume()?; // SKip '}'

        Ok(r#trait)
    }

    pub fn parse_use_declaration(&mut self, modifiers: Vec<TokenKind>) -> Result<UseDeclaration, ParseError> {
        if !modifiers.is_empty() {
            return Err(self.gen_error("Use declaration cannot have modifiers".to_string()));
        }

        self.consume()?; // Skip 'use'

        Ok(UseDeclaration {
            path: self.parse_path()?
        })
    }

    pub fn parse_module_declaration(&mut self, modifiers: Vec<TokenKind>) -> Result<ModuleDeclaration, ParseError> {
        let mut module = ModuleDeclaration {
            items: vec![],
            name: "".to_string(),
            visibility: Visibility::Public
        };

        for modifier in modifiers {
            if modifier == TokenKind::PublicKw {
                module.visibility = Visibility::Public;
            }
            else if modifier == TokenKind::PrivateKw {
                module.visibility = Visibility::Private;
            }
            else {
                return Err(self.gen_error(format!("Modifier {:#?} is not valid for module declaration", modifier)));
            }
        }

        self.consume()?; // Skip 'module'

        self.consume()?; // Skip '{'

        let mut modifiers = self.parse_modifiers()?;

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            match self.peek(0)?.kind {
                TokenKind::LetKw => {
                    module.items.push(ModuleMember::VariableDeclaration(self.parse_variable_declaration(modifiers.clone())?));
                }
                TokenKind::FnKw => {
                    module.items.push(ModuleMember::FunctionDeclaration(self.parse_function_declaration(modifiers.clone())?));
                }
                TokenKind::ModuleKw => {
                    module.items.push(ModuleMember::ModuleDeclaration(self.parse_module_declaration(modifiers.clone())?));
                }
                TokenKind::StructKw => {
                    module.items.push(ModuleMember::StructDeclaration(self.parse_struct_declaration(modifiers.clone())?));
                }
                TokenKind::TraitKw => {
                    module.items.push(ModuleMember::TraitDeclaration(self.parse_trait_declaration(modifiers.clone())?));
                }
                TokenKind::UseKw => {
                    module.items.push(ModuleMember::UseDeclaration(self.parse_use_declaration(modifiers.clone())?));
                }
                _ => {
                    return Err(self.gen_error("Unexpected token. Expected Struct item.".to_string()));
                }
            }

            modifiers.clear();
        }

        Ok(module)
    }

    pub fn match_token_array(&self, kinds: &[TokenKind], offset: usize) -> Result<bool, ParseError> {
        for kind in kinds {
            if self.match_token(*kind, offset)? {
                return Ok(true);
            }
        }
        return Ok(false);
    }

    pub fn match_token(&self, kind: TokenKind, offset: usize) -> Result<bool, ParseError> {
        Ok(self.peek(offset)?.kind == kind)
    }

    pub fn consume(&mut self) -> Result<Token, ParseError> {
        let res = self.peek(0);
        self.position += 1;
        res
    }

    pub fn peek(&self, offset: usize) -> Result<Token, ParseError> {
        if self.position + offset >= self.tokens.len() {
            Err(self.gen_error("Unexpected end of file".to_string()))
        }
        else {
            Ok(self.tokens[self.position + offset].clone())
        }
    }

    pub fn gen_error(&self, message: String) -> ParseError {
        ParseError {
            message
        }
    }
}