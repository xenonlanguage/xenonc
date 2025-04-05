mod mod_new;

use std::{error, fmt};
use std::fmt::format;
use crate::ast::{
    BinOp, Block, Case, Cast, Expression, ForLoop, FunctionDeclaration, IfStatement,
    Literal, LoopStatement, ModuleDeclaration, ModuleMember, Parameter, Path, Program,
    ProgramMember, Statement, StructDeclaration, SwitchStatement, TraitDeclaration, Type,
    UnaryOperation, UseDeclaration, VariableAssignment, VariableDeclaration, WhileLoop,
};
use crate::ast::{Safety, Visibility};
use crate::lexer::token::{Token, TokenKind};
use either::Either;
use function_name;
use crate::lexer::token::TokenKind::ElseKw;

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct ParseError {
    pub message: String,
    pub line: u32,
    pub code_line: usize,
}
impl fmt::Display for ParseError {
    fn fmt(&self, fmt: &mut fmt::Formatter<'_>) -> fmt::Result {
        write!(fmt, "Parse Error at line {}: {}", self.code_line, self.message)?;
        if cfg!(debug_assertions) {
            write!(fmt, "\nDEBUG: at line {}", self.line)?;
        }
        Ok(())
    }
}

pub struct Parser {
    pub tokens: Vec<Token>,
    pub position: usize,
}
impl Parser {
    pub fn new(tokens: Vec<Token>) -> Self {
        Self {
            tokens,
            position: 0,
        }
    }

    pub fn parse_program(&mut self, file_name: String) -> Result<Program, ParseError> {
        let mut program = Program {
            file_name,
            members: vec![],
        };

        while self.position < self.tokens.len() {
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
                | TokenKind::SafeKw => {
                    modifiers.push(token.kind);
                    self.consume()?;
                }
                _ => break,
            }
        }

        Ok(modifiers)
    }

    pub fn  parse_program_member(&mut self) -> Result<ProgramMember, ParseError> {
        let modifiers = self.parse_modifiers()?;

        let token = self.peek(0)?;

        match token.kind {
            TokenKind::FnKw => Ok(ProgramMember::FunctionDeclaration(
                self.parse_function_declaration(modifiers)?,
            )),
            TokenKind::LetKw => Ok(ProgramMember::VariableDeclaration(
                self.parse_variable_declaration(modifiers)?,
            )),
            TokenKind::StructKw => Ok(ProgramMember::StructDeclaration(
                self.parse_struct_declaration(modifiers)?,
            )),
            TokenKind::TraitKw => Ok(ProgramMember::TraitDeclaration(
                self.parse_trait_declaration(modifiers)?,
            )),
            TokenKind::UseKw => Ok(ProgramMember::UseDeclaration(
                self.parse_use_declaration(modifiers)?,
            )),
            TokenKind::ModuleKw => Ok(ProgramMember::ModuleDeclaration(
                self.parse_module_declaration(modifiers)?,
            )),
            _ => Err(self.gen_error(format!("While Parsing Program Member: Expected Program Member, found {:#?}", token.kind), line!())),
        }
    }

    pub fn parse_function_declaration(
        &mut self,
        modifiers: Vec<TokenKind>,
    ) -> Result<FunctionDeclaration, ParseError> {
        let mut function = FunctionDeclaration {
            body: None,
            is_async: false,
            is_override: false,
            is_virtual: false,
            is_extern: false,
            name: Path {
                name: "".to_string(),
                seperator: None,
                arguments: None,
                type_arguments: None,
                accessor: Box::new(None),
                child: None,
            },
            parameters: vec![],
            safety: Safety::Safe,
            r#type: None,
            visibility: Visibility::Public,
        };

        for modifier in modifiers {
            if modifier == TokenKind::AsyncKw {
                function.is_async = true;
            } else if modifier == TokenKind::OverrideKw {
                function.is_override = true;
            } else if modifier == TokenKind::VirtualKw {
                function.is_virtual = true;
            } else if modifier == TokenKind::ExternKw {
                function.is_extern = true;
            } else if modifier == TokenKind::UnsafeKw {
                function.safety = Safety::Unsafe;
            } else if modifier == TokenKind::SafeKw {
                function.safety = Safety::Safe;
            } else if modifier == TokenKind::PublicKw {
                function.visibility = Visibility::Public;
            } else if modifier == TokenKind::PrivateKw {
                function.visibility = Visibility::Private;
            } else {
                return Err(self.gen_error(format!(
                    "Modifier {:#?} is not valid for function declaration",
                    modifier
                ), line!()));
            }
        }

        self.consume()?; // Skip 'fn'
        
        function.name = self.parse_path_no_args()?;

        self.consume()?; // Skip '('

        while !self.match_token(TokenKind::CloseParen, 0)? {
            function.parameters.push(self.parse_parameter()?);
        }

        self.consume()?;

        if self.match_token(TokenKind::Minus, 0)? {
            self.consume()?; // Skip '-'
            self.consume()?; // Skip '>'
            function.r#type = Some(self.parse_type()?);
        }

        if self.match_token(TokenKind::OpenBrace, 0)? {
            function.body = Some(self.parse_block()?);
        } else {
            self.consume()?; // Skip ';'
        }

        Ok(function)
    }

    pub fn parse_block(&mut self) -> Result<Block, ParseError> {
        let mut block = Block { statements: vec![] };
        self.consume()?; // SKip '{'

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            block.statements.push(self.parse_statement()?);
        }

        self.consume()?; // Skip '}'

        Ok(block)
    }

    pub fn parse_type(&mut self) -> Result<Type, ParseError> {
        if self.match_token(TokenKind::Star, 0)? {
            self.consume()?; // Skip '*'
            Ok(Type::PointerType(Box::new(self.parse_type()?)))
        } else if self.match_token(TokenKind::RefKw, 0)? {
            self.consume()?; // Skip 'ref'
            Ok(Type::ReferenceType(Box::new(self.parse_type()?)))
        } else if self.match_token(TokenKind::OpenParen, 0)? {
            Ok(self.parse_tuple_type()?)
        } else if self.match_token(TokenKind::Name, 0)? {
            let path = self.parse_path_type() ?;
            if self.match_token(TokenKind::OpenBracket, 0)? {
                self.consume()?;
                let literal: Option<Literal>;
                if !self.match_token(TokenKind::CloseBracket, 0)? {
                    literal = Some(self.parse_literal()?);
                }
                else {
                    literal = None;
                }
                self.consume()?;
                return Ok(Type::ArrayType(Box::new(Type::PathType(path)), literal));
            }
            else {
                return Ok(Type::PathType(path));
            }
        } else if self.match_token_array(
            &[
                TokenKind::I8Kw,
                TokenKind::I16Kw,
                TokenKind::I32Kw,
                TokenKind::I64Kw,
                TokenKind::U8Kw,
                TokenKind::U16Kw,
                TokenKind::U32Kw,
                TokenKind::U64Kw,
                TokenKind::F16Kw,
                TokenKind::F32Kw,
                TokenKind::F64Kw,
                TokenKind::BoolKw,
                TokenKind::CharKw,
                TokenKind::VoidKw,
            ],
            0,
        )? {
            Ok(Type::PrimativeType(self.consume()?.value))
        } else {
            Err(self.gen_error("Unexpected token. Expected type.".to_string(), line!()))
        }
    }

    pub fn parse_tuple_type(&mut self) -> Result<Type, ParseError> {
        let mut tuple = vec![];

        while !self.match_token(TokenKind::CloseParen, 0)? {
            tuple.push(self.parse_type()?);
            self.consume()?; // Skip ','
        }

        Ok(Type::TupleType(tuple))
    }

    pub fn parse_variable_declaration(
        &mut self,
        modifiers: Vec<TokenKind>,
    ) -> Result<VariableDeclaration, ParseError> {
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
            } else if modifier == TokenKind::ConstKw {
                variable.is_const = true;
            } else if modifier == TokenKind::UnsafeKw {
                variable.safety = Safety::Unsafe;
            } else if modifier == TokenKind::SafeKw {
                variable.safety = Safety::Safe;
            } else if modifier == TokenKind::PublicKw {
                variable.visibility = Visibility::Public;
            } else if modifier == TokenKind::PrivateKw {
                variable.visibility = Visibility::Private;
            } else {
                return Err(self.gen_error(format!(
                    "Modifier {:#?} is not valid for variable declaration",
                    modifier
                ), line!()));
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
            variable.value = Some(self.parse_expression()?);
        }

        self.consume()?; // Skip ';'

        Ok(variable)
    }

    pub fn parse_expression(&mut self) -> Result<Expression, ParseError> {
        self.parse_or_expr()
    }

    pub fn parse_or_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_and_expr()?;
        if !self.match_token(TokenKind::Or, 0)? && !self.match_token(TokenKind::Or, 1)? {
            return Ok(left);
        }
        self.consume()?; // SKip '|' x2
        self.consume()?;
        let right = self.parse_or_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: "||".to_string(),
            right: Box::new(right),
        }))
    }

    pub fn parse_and_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_cmp_expr()?;
        if !self.match_token(TokenKind::And, 0)? && !self.match_token(TokenKind::And, 1)? {
            return Ok(left);
        }
        self.consume()?; // SKip '&' x2
        self.consume()?;
        let right = self.parse_and_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: "&&".to_string(),
            right: Box::new(right),
        }))
    }

    pub fn parse_cmp_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_bit_or_expr()?;
        if !self.match_comparison_operator()? {
            return Ok(left);
        }
        let op = self.parse_comparison_operator()?;
        let right = self.parse_bit_or_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: op,
            right: Box::new(right),
        }))
    }

    pub fn parse_comparison_operator(&mut self) -> Result<String, ParseError> {
        if self.match_token(TokenKind::Equal, 0)? && self.match_token(TokenKind::Equal, 1)? {
            self.consume()?;
            self.consume()?;
            Ok("==".to_string())
        } else if self.match_token(TokenKind::Bang, 0)? && self.match_token(TokenKind::Equal, 0)? {
            self.consume()?;
            self.consume()?;
            Ok("!=".to_string())
        } else if self.match_token(TokenKind::LessThan, 0)? {
            if self.match_token(TokenKind::Equal, 1)? {
                self.consume()?;
                self.consume()?;
                return Ok("<=".to_string());
            }
            self.consume()?;
            Ok("<".to_string())
        } else if self.match_token(TokenKind::GreaterThan, 0)? {
            if self.match_token(TokenKind::Equal, 1)? {
                self.consume()?;
                self.consume()?;
                return Ok(">=".to_string());
            }
            self.consume()?;
            Ok(">".to_string())
        } else {
            Err(
                self.gen_error("Unexpected token. Expected comparison operator.".to_string(), line!())
            )
        }
    }

    pub fn parse_bit_or_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_bit_xor_expr()?;
        if !self.match_token(TokenKind::Or, 0)? {
            return Ok(left);
        }
        self.consume()?; // SKip '|'
        let right = self.parse_bit_or_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: "|".to_string(),
            right: Box::new(right),
        }))
    }

    pub fn parse_bit_xor_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_bit_and_expr()?;
        if !self.match_token(TokenKind::Carat, 0)? {
            return Ok(left);
        }
        self.consume()?; // SKip '^'
        let right = self.parse_bit_xor_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: "^".to_string(),
            right: Box::new(right),
        }))
    }

    pub fn parse_bit_and_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_shift_expr()?;
        if !self.match_token(TokenKind::And, 0)? {
            return Ok(left);
        }
        self.consume()?; // SKip '&'
        let right = self.parse_bit_and_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: "&".to_string(),
            right: Box::new(right),
        }))
    }

    pub fn parse_shift_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_add_expr()?;
        let op: &str;
        if self.match_token(TokenKind::LessThan, 0)? && self.match_token(TokenKind::LessThan, 1)? {
            op = "<<";
        } else if self.match_token(TokenKind::GreaterThan, 0)?
            && self.match_token(TokenKind::GreaterThan, 1)?
        {
            op = ">>";
        } else {
            return Ok(left);
        }
        self.consume()?; // Skip '|'
        let right = self.parse_shift_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: op.to_string(),
            right: Box::new(right),
        }))
    }

    pub fn parse_add_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_mul_expr()?;
        if !self.match_token_array(&[TokenKind::Plus, TokenKind::Minus], 0)? {
            return Ok(left);
        }
        let op = self.consume()?.value;
        let right = self.parse_add_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: op,
            right: Box::new(right),
        }))
    }

    pub fn parse_mul_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_cast_expr()?;
        if !self.match_token_array(&[TokenKind::Star, TokenKind::Slash, TokenKind::Percent], 0)? {
            return Ok(left);
        }
        let op = self.consume()?.value;
        let right = self.parse_cast_expr()?;
        Ok(Expression::BinOp(BinOp {
            left: Box::new(left),
            operator: op,
            right: Box::new(right),
        }))
    }

    pub fn parse_cast_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_unary_operation()?;
        if !self.match_token(TokenKind::AsKw, 0)? {
            return Ok(left);
        }
        self.consume()?; // Skip 'as'
        let right = self.parse_type()?;
        Ok(Expression::Cast(Cast {
            left: Box::new(left),
            right,
        }))
    }

    pub fn parse_unary_operation(&mut self) -> Result<Expression, ParseError> {
        if self.match_token_array(
            &[
                TokenKind::Plus,
                TokenKind::Minus,
                TokenKind::Bang,
                TokenKind::And,
                TokenKind::Star,
            ],
            0,
        )? {
            Ok(Expression::UnaryOperation(UnaryOperation {
                operator: self.consume()?.value,
                expression: Box::new(self.parse_primary()?),
            }))
        } else {
            Ok(self.parse_primary()?)
        }
    }

    pub fn parse_primary(&mut self) -> Result<Expression, ParseError> {
        if self.match_token(TokenKind::Name, 0)? {
            Ok(Expression::Identifier(self.parse_path_no_generic()?))
        } else if self.match_token(TokenKind::OpenParen, 0)? {
            self.consume()?;
            let exp = self.parse_expression()?;
            self.consume()?;
            Ok(exp)
        } else {
            Ok(Expression::Literal(self.parse_literal()?))
        }
    }

    pub fn parse_literal(&mut self) -> Result<Literal, ParseError> {
        if self.match_token(TokenKind::String, 0)? {
            Ok(Literal::StringLiteral(self.consume()?.value))
        } else if self.match_token(TokenKind::Number, 0)? {
            let val = self.consume()?;
            if val.value.contains('.') {
                Ok(Literal::FloatLiteral(val.value))
            } else {
                Ok(Literal::IntegerLiteral(val.value))
            }
        } else if self.match_token(TokenKind::Char, 0)? {
            Ok(Literal::CharLiteral(
                self.consume()?.value.chars().nth(1).unwrap(),
            ))
        } else if self.match_token_array(&[TokenKind::TrueKw, TokenKind::FalseKw], 0)? {
            Ok(Literal::BooleanLiteral(self.consume()?.value == "true"))
        } else {
            Err(self.gen_error("Unexpected token. Expected literal.".to_string(), line!()))
        }
    }

    pub fn parse_struct_declaration(
        &mut self,
        modifiers: Vec<TokenKind>,
    ) -> Result<StructDeclaration, ParseError> {
        let mut struc = StructDeclaration {
            items: vec![],
            inherits: vec![],
            is_abstract: false,
            name: "".to_string(),
            type_arguments: vec![],
            safety: Safety::Safe,
            visibility: Visibility::Public,
        };

        for modifier in modifiers {
            if modifier == TokenKind::AbstractKw {
                struc.is_abstract = true;
            } else if modifier == TokenKind::UnsafeKw {
                struc.safety = Safety::Unsafe;
            } else if modifier == TokenKind::SafeKw {
                struc.safety = Safety::Safe;
            } else if modifier == TokenKind::PublicKw {
                struc.visibility = Visibility::Public;
            } else if modifier == TokenKind::PrivateKw {
                struc.visibility = Visibility::Private;
            } else {
                return Err(self.gen_error(format!(
                    "Modifier {:#?} is not valid for struct declaration",
                    modifier
                ), line!()));
            }
        }

        self.consume()?; // Skip 'struct' keyword

        struc.name = self.consume()?.value;

        if self.match_token(TokenKind::LessThan, 0)? {
            self.consume()?;

            while !self.match_token(TokenKind::GreaterThan, 0)? {
                struc.type_arguments.push(self.consume()?.value);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }

            self.consume()?;
        }

        if self.match_token(TokenKind::Colon, 0)? {
            self.consume()?; // Skip ':'

            while !self.match_token(TokenKind::OpenBrace, 0)? {
                struc.inherits.push(self.parse_path()?);
            }
        }

        self.consume()?; // Skip '{'

        let mut modifiers: Vec<TokenKind>;

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            modifiers = self.parse_modifiers()?;
            match self.peek(0)?.kind {
                TokenKind::FnKw => {
                    struc.items.push(Either::Left(
                        self.parse_function_declaration(modifiers.clone())?,
                    ));
                }
                TokenKind::LetKw => {
                    struc.items.push(Either::Right(
                        self.parse_variable_declaration(modifiers.clone())?,
                    ));
                }
                _ => {
                    return Err(
                        self.gen_error("Unexpected token. Expected Struct item.".to_string(), line!())
                    );
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
            r#type: Type::PrimativeType("void".to_string()),
        };

        param.name = self.consume()?.value;

        self.consume()?; // SKip ':'

        param.r#type = self.parse_type()?;

        Ok(param)
    }

    pub fn parse_variable_assignment(&mut self) -> Result<VariableAssignment, ParseError> {
        let name = self.parse_path()?;
        let operator = self.parse_assignment_operator()?;
        let value = self.parse_expression()?;
        self.consume()?; // Skip ';'
        Ok(VariableAssignment {
            name,
            operator,
            value,
        })
    }

    pub fn parse_for_loop(&mut self) -> Result<ForLoop, ParseError> {
        self.consume()?; // SKip 'for'
        let name = self.consume()?.value;
        self.consume()?; // Skip 'in'
        let iterator = self.parse_path()?;
        Ok(ForLoop {
            name,
            iterator,
            body: Box::new(self.parse_statement()?),
        })
    }

    pub fn parse_if_statement(&mut self) -> Result<IfStatement, ParseError> {
        self.consume()?; // SKip 'if'
        let condition = self.parse_expression()?;
        let body = self.parse_statement()?;
        if self.match_token(TokenKind::ElseKw, 0)? {
            self.consume()?; // Skip 'else'
            let else_body = self.parse_statement()?;
            Ok(IfStatement {
                condition,
                body: Box::new(body),
                else_body: Some(Box::new(else_body)),
            })
        } else {
            Ok(IfStatement {
                condition,
                body: Box::new(body),
                else_body: None,
            })
        }
    }

    pub fn parse_loop_statement(&mut self) -> Result<LoopStatement, ParseError> {
        self.consume()?; // SKip 'loop'
        Ok(LoopStatement {
            body: Box::new(self.parse_statement()?),
        })
    }

    pub fn parse_assignment_operator(&mut self) -> Result<String, ParseError> {
        if self.match_token(TokenKind::Equal, 0)? {
            self.consume()?;
            Ok("=".to_string())
        } else if self.match_token(TokenKind::Plus, 0)? {
            self.consume()?;
            self.consume()?;
            Ok("+=".to_string())
        } else if self.match_token(TokenKind::Minus, 0)? {
            self.consume()?;
            self.consume()?;
            Ok("-=".to_string())
        } else if self.match_token(TokenKind::Star, 0)? {
            self.consume()?;
            self.consume()?;
            Ok("*=".to_string())
        } else if self.match_token(TokenKind::Slash, 0)? {
            self.consume()?;
            self.consume()?;
            Ok("/=".to_string())
        } else if self.match_token(TokenKind::Percent, 0)? {
            self.consume()?;
            self.consume()?;
            Ok("%=".to_string())
        } else {
            Err(
                self.gen_error("Unexpected token. Expected assignment operator.".to_string(), line!())
            )
        }
    }

    pub fn parse_statement(&mut self) -> Result<Statement, ParseError> {
        if self.match_token(TokenKind::OpenBrace, 0)? { 
            Ok(Statement::Block(self.parse_block()?))
        } 
        else if self.match_token(TokenKind::Name, 0)? {
            if self.is_variable_assignment()? {
                Ok(Statement::VariableAssignment(
                    self.parse_variable_assignment()?,
                ))
            } else {
                let res = Ok(Statement::FunctionCall(self.parse_path()?));
                self.consume()?; // SKip ';'
                res
            }
        } else if self.match_token(TokenKind::LetKw, 0)? {
            Ok(Statement::VariableDeclaration(
                self.parse_variable_declaration(vec![])?,
            ))
        } else if self.match_token(TokenKind::ForKw, 0)? {
            Ok(Statement::ForLoop(self.parse_for_loop()?))
        } else if self.match_token(TokenKind::IfKw, 0)? {
            Ok(Statement::IfStatement(self.parse_if_statement()?))
        } else if self.match_token(TokenKind::LoopKw, 0)? {
            Ok(Statement::LoopStatement(self.parse_loop_statement()?))
        } else if self.match_token(TokenKind::SwitchKw, 0)? {
            Ok(Statement::SwitchStatement(self.parse_switch_statement()?))
        } else if self.match_token(TokenKind::UnsafeKw, 0)? {
            Ok(Statement::UnsafeBlock(self.parse_unsafe_block()?))
        } else if self.match_token(TokenKind::WhileKw, 0)? {
            Ok(Statement::WhileLoop(self.parse_while_loop()?))
        } else if self.match_token(TokenKind::ReturnKw, 0)? {
            let ret = Ok(Statement::ReturnStatement(self.parse_return_statement()?));
            self.consume()?;
            ret
        } else if self.match_token(TokenKind::ContinueKw, 0)? {
            self.consume()?;
            self.consume()?;
            Ok(Statement::ContinueStatement)
        } else if self.match_token(TokenKind::BreakKw, 0)? {
            self.consume()?;
            self.consume()?; // Skip ';'
            Ok(Statement::BreakStatement)
        } else {
            Err(self.gen_error("Unexpected token. Expected statement.".to_string(), line!()))
        }
    }

    pub fn parse_return_statement(&mut self) -> Result<Option<Expression>, ParseError> {
        self.consume()?;
        if !self.match_token(TokenKind::Semicolon, 0)? {
            Ok(Some(self.parse_expression()?))
        }
        else {
            Ok(None)
        }
    }

    pub fn parse_switch_statement(&mut self) -> Result<SwitchStatement, ParseError> {
        self.consume()?; // Skip 'switch'
        let condition = self.parse_expression()?;
        self.consume()?; // Skip '{'
        let mut cases = vec![];
        while !self.match_token(TokenKind::CloseBrace, 0)? {
            cases.push(self.parse_case()?);
        }
        self.consume()?; // SKip '}'
        Ok(SwitchStatement { condition, cases })
    }

    pub fn parse_case(&mut self) -> Result<Case, ParseError> {
        self.consume()?; // Skip 'case'
        let case = self.parse_expression()?;
        let body = self.parse_block()?;
        Ok(Case { case, body })
    }

    pub fn parse_unsafe_block(&mut self) -> Result<Block, ParseError> {
        self.consume()?; // Skip 'unsafe'
        self.parse_block()
    }

    pub fn parse_while_loop(&mut self) -> Result<WhileLoop, ParseError> {
        self.consume()?; // Skip 'while'
        let condition = self.parse_expression()?;
        Ok(WhileLoop {
            condition,
            body: Box::new(self.parse_statement()?),
        })
    }

    pub fn parse_path(&mut self) -> Result<Path, ParseError> {
        let name = self.consume()?.value;
        
        let mut targs: Option<Vec<Type>> = None;

        if self.match_token(TokenKind::LessThan, 0)? {
            self.consume()?;

            let mut args = vec![];
            
            while !self.match_token(TokenKind::GreaterThan, 0)? {
                args.push(self.parse_type()?);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }
            
            targs = Some(args);

            self.consume()?;
        }

        let arguments;
        if self.match_token(TokenKind::OpenParen, 0)? {
            let mut args = vec![];
            self.consume()?;
            while !self.match_token(TokenKind::CloseParen, 0)? {
                args.push(self.parse_expression()?);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }
            self.consume()?;
            arguments = Some(args);
        }
        else {
            arguments = None;
        }
        
        let accessor: Option<Expression>;
        if self.match_token(TokenKind::OpenBracket, 0)? {
            self.consume()?;
            accessor = Some(self.parse_expression()?);
            self.consume()?;
        }
        else { 
            accessor = None;
        } 

        let mut seperator: Option<String> = None;
        if self.match_token(TokenKind::Dot, 0)? {
            seperator = Some(".".to_string());
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: Some(Box::new(self.parse_path()?))
            })
        } else if self.match_token(TokenKind::Colon, 0)? {
            seperator = Some("::".to_string());
            self.consume()?;
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: Some(Box::new(self.parse_path()?))
            })
        } else {
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: None
            })
        }
    }

    pub fn parse_path_no_generic(&mut self) -> Result<Path, ParseError> {
        let name = self.consume()?.value;

        let mut targs: Option<Vec<Type>> = None;

        let arguments;
        if self.match_token(TokenKind::OpenParen, 0)? {
            let mut args = vec![];
            self.consume()?;
            while !self.match_token(TokenKind::CloseParen, 0)? {
                args.push(self.parse_expression()?);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }
            self.consume()?;
            arguments = Some(args);
        }
        else {
            arguments = None;
        }

        let accessor: Option<Expression>;
        if self.match_token(TokenKind::OpenBracket, 0)? {
            self.consume()?;
            accessor = Some(self.parse_expression()?);
            self.consume()?;
        }
        else {
            accessor = None;
        }

        let mut seperator: Option<String> = None;
        if self.match_token(TokenKind::Dot, 0)? {
            seperator = Some(".".to_string());
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: Some(Box::new(self.parse_path()?))
            })
        } else if self.match_token(TokenKind::Colon, 0)? {
            seperator = Some("::".to_string());
            self.consume()?;
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: Some(Box::new(self.parse_path()?))
            })
        } else {
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: None
            })
        }
    }
    
    pub fn parse_path_no_args(&mut self) -> Result<Path, ParseError> {
        let name = self.consume()?.value;

        let mut targs: Option<Vec<Type>> = None;

        if self.match_token(TokenKind::LessThan, 0)? {
            self.consume()?;

            let mut args = vec![];

            while !self.match_token(TokenKind::GreaterThan, 0)? {
                args.push(self.parse_type()?);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }

            targs = Some(args);

            self.consume()?;
        }

        let accessor: Option<Expression>;
        if self.match_token(TokenKind::OpenBracket, 0)? {
            self.consume()?;
            accessor = Some(self.parse_expression()?);
            self.consume()?;
        }
        else {
            accessor = None;
        }

        let arguments: Option<Vec<Expression>> = None;

        let mut seperator: Option<String> = None;
        if self.match_token(TokenKind::Dot, 0)? {
            seperator = Some(".".to_string());
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: Some(Box::new(self.parse_path()?))
            })
        } else if self.match_token(TokenKind::Colon, 0)? {
            seperator = Some("::".to_string());
            self.consume()?;
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: Some(Box::new(self.parse_path()?))
            })
        } else {
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(accessor),
                child: None
            })
        }
    }

    pub fn parse_path_type(&mut self) -> Result<Path, ParseError> {
        let name = self.consume()?.value;

        let mut targs: Option<Vec<Type>> = None;

        if self.match_token(TokenKind::LessThan, 0)? {
            self.consume()?;

            let mut args = vec![];

            while !self.match_token(TokenKind::GreaterThan, 0)? {
                args.push(self.parse_type()?);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }

            targs = Some(args);

            self.consume()?;
        }

        let arguments: Option<Vec<Expression>> = None;

        let mut seperator: Option<String> = None;
        if self.match_token(TokenKind::Dot, 0)? {
            seperator = Some(".".to_string());
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(None),
                child: Some(Box::new(self.parse_path()?))
            })
        } else if self.match_token(TokenKind::Colon, 0)? {
            seperator = Some("::".to_string());
            self.consume()?;
            self.consume()?;
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(None),
                child: Some(Box::new(self.parse_path()?))
            })
        } else {
            Ok(Path {
                name,
                seperator,
                arguments,
                type_arguments: targs,
                accessor: Box::new(None),
                child: None
            })
        }
    }
    
    pub fn is_variable_assignment(&self) -> Result<bool, ParseError> {
        let mut offset = 0;

        while !self.match_token_array(
            &[
                TokenKind::Plus,
                TokenKind::Minus,
                TokenKind::Star,
                TokenKind::Slash,
                TokenKind::Percent,
                TokenKind::Equal,
            ],
            offset,
        )? && !self.match_token_array(
            &[
                TokenKind::Plus,
                TokenKind::Minus,
                TokenKind::Star,
                TokenKind::Slash,
                TokenKind::Percent,
                TokenKind::Equal,
            ],
            offset + 1,
        )? {
            if self.match_token(TokenKind::OpenParen, offset)? {
                // hit open-paren before assignment operator
                return Ok(false);
            }
            offset += 1;
        }

        Ok(true)
    }

    pub fn parse_trait_declaration(
        &mut self,
        modifiers: Vec<TokenKind>,
    ) -> Result<TraitDeclaration, ParseError> {
        let mut r#trait = TraitDeclaration {
            items: vec![],
            name: "".to_string(),
            type_arguments: vec![],
            visibility: Visibility::Public,
        };

        for modifier in modifiers {
            if modifier == TokenKind::PublicKw {
                r#trait.visibility = Visibility::Public;
            } else if modifier == TokenKind::PrivateKw {
                r#trait.visibility = Visibility::Private;
            } else {
                return Err(self.gen_error(format!(
                    "Modifier {:#?} is not valid for trait declaration",
                    modifier
                ), line!()));
            }
        }

        self.consume()?; // Skip 'trait'

        r#trait.name = self.consume()?.value;

        if self.match_token(TokenKind::LessThan, 0)? {
            self.consume()?;

            while !self.match_token(TokenKind::GreaterThan, 0)? { 
                r#trait.type_arguments.push(self.consume()?.value);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }

            self.consume()?;
        }

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
                    | TokenKind::SafeKw => {
                        modifiers.push(token.kind);
                        self.consume()?;
                    }
                    _ => break,
                }
            }

            match self.peek(0)?.kind {
                TokenKind::FnKw => {
                    r#trait.items.push(Either::Left(
                        self.parse_function_declaration(modifiers.clone())?,
                    ));
                }
                TokenKind::LetKw => {
                    r#trait.items.push(Either::Right(
                        self.parse_variable_declaration(modifiers.clone())?,
                    ));
                }
                _ => {
                    return Err(
                        self.gen_error("Unexpected token. Expected Struct item.".to_string(), line!())
                    );
                }
            }

            modifiers.clear();
        }

        self.consume()?; // SKip '}'

        Ok(r#trait)
    }

    pub fn match_comparison_operator(&mut self) -> Result<bool, ParseError> {
        if self.match_token(TokenKind::Equal, 0)? && self.match_token(TokenKind::Equal, 1)? {
            Ok(true)
        } else if self.match_token(TokenKind::Bang, 0)? && self.match_token(TokenKind::Equal, 0)? {
            Ok(true)
        } else if self.match_token(TokenKind::LessThan, 0)? {
            Ok(true)
        } else if self.match_token(TokenKind::GreaterThan, 0)? {
            Ok(true)
        } else {
            Ok(false)
        }
    }

    pub fn parse_use_declaration(
        &mut self,
        modifiers: Vec<TokenKind>,
    ) -> Result<UseDeclaration, ParseError> {
        if !modifiers.is_empty() {
            return Err(self.gen_error("Use declaration cannot have modifiers".to_string(), line!()));
        }

        self.consume()?; // Skip 'use'

        let res = Ok(UseDeclaration {
            path: self.parse_path()?,
        });
        self.consume()?; // Skip ';'
        res
    }

    pub fn parse_module_declaration(
        &mut self,
        modifiers: Vec<TokenKind>,
    ) -> Result<ModuleDeclaration, ParseError> {
        let mut module = ModuleDeclaration {
            items: vec![],
            name: "".to_string(),
            visibility: Visibility::Public,
        };

        for modifier in modifiers {
            if modifier == TokenKind::PublicKw {
                module.visibility = Visibility::Public;
            } else if modifier == TokenKind::PrivateKw {
                module.visibility = Visibility::Private;
            } else {
                return Err(self.gen_error(format!(
                    "Modifier {:#?} is not valid for module declaration",
                    modifier
                ), line!()));
            }
        }

        self.consume()?; // Skip 'module'

        module.name = self.consume()?.value;
        
        self.consume()?; // Skip '{'

        let mut modifiers = self.parse_modifiers()?;

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            modifiers = self.parse_modifiers()?;

            match self.peek(0)?.kind {
                TokenKind::LetKw => {
                    module.items.push(ModuleMember::VariableDeclaration(
                        self.parse_variable_declaration(modifiers.clone())?,
                    ));
                }
                TokenKind::FnKw => {
                    module.items.push(ModuleMember::FunctionDeclaration(
                        self.parse_function_declaration(modifiers.clone())?,
                    ));
                }
                TokenKind::ModuleKw => {
                    module.items.push(ModuleMember::ModuleDeclaration(
                        self.parse_module_declaration(modifiers.clone())?,
                    ));
                }
                TokenKind::StructKw => {
                    module.items.push(ModuleMember::StructDeclaration(
                        self.parse_struct_declaration(modifiers.clone())?,
                    ));
                }
                TokenKind::TraitKw => {
                    module.items.push(ModuleMember::TraitDeclaration(
                        self.parse_trait_declaration(modifiers.clone())?,
                    ));
                }
                TokenKind::UseKw => {
                    module.items.push(ModuleMember::UseDeclaration(
                        self.parse_use_declaration(modifiers.clone())?,
                    ));
                }
                _ => {
                    return Err(
                        self.gen_error("Unexpected token. Expected Module item.".to_string(), line!())
                    );
                }
            }
            
            modifiers.clear();
        }

        self.consume()?;

        Ok(module)
    }

    pub fn match_token_array(
        &self,
        kinds: &[TokenKind],
        offset: usize,
    ) -> Result<bool, ParseError> {
        for kind in kinds {
            if self.match_token(kind.clone(), offset)? {
                return Ok(true);
            }
        }
        Ok(false)
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
            return Err(self.gen_error("Unexpected end of file".to_string(), line!()));
        } else {
            Ok(self.tokens[self.position + offset].clone())
        }
    }

    pub fn gen_error(&self, message: String, line: u32) -> ParseError {
        let mut pos = self.position;
        while pos >= self.tokens.len() {
            pos -= 1;
        }
        let error = ParseError {
            message,
            code_line: self.tokens[pos].line,
            line,
        };
        logex::log_error(format!("{}", error).as_str());
        return error;
    }
}
