use crate::ast::{Access, AssignmentOperator, Attribute, BinaryOp, BinaryOperator, Block, Case, Cast, Enum, Expression, ForLoop, Function, Identifier, IfStatement, Item, Literal, Module, Parameter, Path, PathSegment, Safety, Statement, Struct, SwitchStatement, Tank, Trait, Type, UnaryOp, UnaryOperator, VariableAssignment, VariableDeclaration, Variant, Visibility, WhileStatement};
use crate::lexer::token::{Token, TokenKind};
use either::{Left, Right};

#[derive(Debug, Clone, PartialEq, Default)]
pub struct ParseError {
    pub message: String,
    pub line: usize,
}
impl std::fmt::Display for ParseError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "Parse error on line {}: {}", self.line, self.message)
    }
}

pub struct Parser {
    pub tokens: Vec<Token>,
    pub index: usize,
}
impl Parser {
    pub fn new(tokens: Vec<Token>) -> Parser {
        return Parser {
            tokens,
            index: 0,
        }
    }
    
    pub fn parse(&mut self, tank_name: String) -> Result<Tank, ParseError> {
        let mut tank = Tank::default();
        tank.name = tank_name;
        while self.index < self.tokens.len() {
            tank.items.push(self.parse_item()?);
        }
        return Ok(tank);
    }
    
    pub fn parse_attributes(&mut self) -> Result<Vec<Attribute>, ParseError> {
        let mut attributes = vec![];
        while self.match_token(TokenKind::Pound, 0)? {
            let mut attr = Attribute::default();
            self.consume()?;
            self.consume()?;
            attr.name = self.parse_path()?;
            if self.match_token(TokenKind::OpenParen, 0)? {
                self.consume()?;
                attr.value = Some(self.parse_path()?);
                self.consume()?;
            }
            self.consume()?;
            attributes.push(attr);
        }
        return Ok(attributes);
    }
    
    pub fn parse_item(&mut self) -> Result<Item, ParseError> {
        let attributes = self.parse_attributes()?;
        let modifiers = self.parse_modifiers()?;
        match self.peek(0)?.kind { 
            TokenKind::ImportKw => {
                self.consume()?; // Skip 'import'
                self.consume()?; // Skip 'tank'
                let val =  Ok(Item::ImportTank(Identifier {
                    name: self.consume()?.value
                }));
                self.consume()?; // Skip ';'
                return val;
            }
            TokenKind::UseKw => {
                self.consume()?;
                let path = self.parse_path()?;
                self.consume()?; // Skip ';'
                return Ok(Item::Use(path));
            }
            TokenKind::LetKw => {
                return Ok(Item::Variable(self.parse_variable_declaration(attributes, modifiers)?));
            }
            TokenKind::FnKw => {
                return Ok(Item::Function(self.parse_function(attributes, modifiers)?));
            }
            TokenKind::ModuleKw => {
                return Ok(Item::Module(self.parse_module(attributes, modifiers)?));
            }
            TokenKind::EnumKw => {
                return Ok(Item::Enum(self.parse_enum(attributes, modifiers)?));
            }
            TokenKind::StructKw => {
                return Ok(Item::Struct(self.parse_struct(attributes, modifiers)?));
            }
            TokenKind::TraitKw => {
                return Ok(Item::Trait(self.parse_trait(attributes, modifiers)?));
            }
            _ => {
                return Err(self.gen_error("Invalid item"));
            }
        }
    }
    
    pub fn parse_variable_declaration(&mut self, attributes: Vec<Attribute>, modifiers: Vec<TokenKind>) -> Result<VariableDeclaration, ParseError> {
        let mut variable = VariableDeclaration::default();
        
        variable.attributes = attributes;

        for modifier in modifiers {
            match modifier {
                TokenKind::PublicKw => {
                    variable.visibility = Visibility::Public;
                }
                TokenKind::PrivateKw => {
                    variable.visibility = Visibility::Private;
                }
                TokenKind::InternalKw => {
                    variable.visibility = Visibility::Internal;
                }
                TokenKind::UnsafeKw => {
                    variable.safety = Safety::Unsafe;
                }
                TokenKind::SafeKw => {
                    variable.safety = Safety::Safe;
                }
                _ => {
                    return Err(self.gen_error("Invalid modifier for variable declaration"));
                }
            }
        }
        
        self.consume()?; // Skip 'let'
        
        variable.name = self.parse_identifier()?;
        
        if self.match_token(TokenKind::Colon, 0)? {
            self.consume()?;
            variable.r#type = Some(self.parse_type()?);
        }
        
        if self.match_token(TokenKind::Equal, 0)? {
            self.consume()?;
            variable.initializer = Some(self.parse_expression()?);
        }
        
        self.consume()?; // Skip ';'
        
        return Ok(variable);
    }
    
    pub fn parse_expression(&mut self) -> Result<Expression, ParseError> {
        return self.parse_or_expr();
    }

    pub fn parse_or_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_and_expr()?;
        if !self.match_token(TokenKind::Or, 0)? && !self.match_token(TokenKind::Or, 1)? {
            return Ok(left);
        }
        self.consume()?; // SKip '|' x2
        self.consume()?;
        let right = self.parse_or_expr()?;
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: BinaryOperator::Or,
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
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: BinaryOperator::And,
            right: Box::new(right),
        }))
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
    
    pub fn parse_cmp_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_bit_or_expr()?;
        if !self.match_comparison_operator()? {
            return Ok(left);
        }
        let op = self.parse_comparison_operator()?;
        let right = self.parse_bit_or_expr()?;
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: op,
            right: Box::new(right),
        }))
    }

    pub fn parse_comparison_operator(&mut self) -> Result<BinaryOperator, ParseError> {
        if self.match_token(TokenKind::Equal, 0)? && self.match_token(TokenKind::Equal, 1)? {
            self.consume()?;
            self.consume()?;
            Ok(BinaryOperator::Eq)
        } else if self.match_token(TokenKind::Bang, 0)? && self.match_token(TokenKind::Equal, 0)? {
            self.consume()?;
            self.consume()?;
            Ok(BinaryOperator::Ne)
        } else if self.match_token(TokenKind::LessThan, 0)? {
            if self.match_token(TokenKind::Equal, 1)? {
                self.consume()?;
                self.consume()?;
                return Ok(BinaryOperator::Le);
            }
            self.consume()?;
            Ok(BinaryOperator::Lt)
        } else if self.match_token(TokenKind::GreaterThan, 0)? {
            if self.match_token(TokenKind::Equal, 1)? {
                self.consume()?;
                self.consume()?;
                return Ok(BinaryOperator::Ge);
            }
            self.consume()?;
            Ok(BinaryOperator::Gt)
        } else {
            Err(
                self.gen_error("Unexpected token. Expected comparison operator.")
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
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: BinaryOperator::BitOr,
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
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: BinaryOperator::BitXor,
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
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: BinaryOperator::BitAnd,
            right: Box::new(right),
        }))
    }

    pub fn parse_shift_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_add_expr()?;
        let op: BinaryOperator;
        if self.match_token(TokenKind::LessThan, 0)? && self.match_token(TokenKind::LessThan, 1)? {
            op = BinaryOperator::Shl;
        } else if self.match_token(TokenKind::GreaterThan, 0)?
            && self.match_token(TokenKind::GreaterThan, 1)?
        {
            op = BinaryOperator::Shr;
        } else {
            return Ok(left);
        }
        self.consume()?; // Skip '|'
        let right = self.parse_shift_expr()?;
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: op,
            right: Box::new(right),
        }))
    }

    pub fn parse_add_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_mul_expr()?;
        let op: BinaryOperator;
        if self.match_token(TokenKind::Plus, 0)? {
            op = BinaryOperator::Add;
        }
        else if self.match_token(TokenKind::Minus, 0)? {
            op = BinaryOperator::Sub;
        }
        else { 
            return Ok(left);
        }
        let right = self.parse_add_expr()?;
        Ok(Expression::BinaryOp(BinaryOp {
            left: Box::new(left),
            operator: op,
            right: Box::new(right),
        }))
    }

    pub fn parse_mul_expr(&mut self) -> Result<Expression, ParseError> {
        let left = self.parse_cast_expr()?;
        let op: BinaryOperator;
        if self.match_token(TokenKind::Star, 0)? {
            op = BinaryOperator::Mul;
        }
        else if self.match_token(TokenKind::Slash, 0)? {
            op = BinaryOperator::Div;
        }
        else if self.match_token(TokenKind::Percent, 0)? {
            op = BinaryOperator::Rem;
        }
        else {
            return Ok(left);
        }
        let right = self.parse_cast_expr()?;
        Ok(Expression::BinaryOp(BinaryOp {
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
            value: Box::new(left),
            r#type: right,
        }))
    }

    pub fn parse_unary_operation(&mut self) -> Result<Expression, ParseError> {
        if self.match_token(TokenKind::Minus, 0)? {
            self.consume()?;
            Ok(Expression::UnaryOp(UnaryOp {
                operator: UnaryOperator::Negate,
                expression: Box::new(self.parse_primary()?),
            }))
        }
        else if self.match_token(TokenKind::Star, 0)? {
            self.consume()?;
            Ok(Expression::UnaryOp(UnaryOp {
                operator: UnaryOperator::Deref,
                expression: Box::new(self.parse_primary()?),
            }))
        }
        else if self.match_token(TokenKind::Bang, 0)? {
            self.consume()?;
            Ok(Expression::UnaryOp(UnaryOp {
                operator: UnaryOperator::Not,
                expression: Box::new(self.parse_primary()?),
            }))
        }
        else if self.match_token(TokenKind::And, 0)? {
            self.consume()?;
            Ok(Expression::UnaryOp(UnaryOp {
                operator: UnaryOperator::Pointer,
                expression: Box::new(self.parse_primary()?),
            }))
        }
        else if self.match_token(TokenKind::RefKw, 0)? {
            self.consume()?;
            Ok(Expression::UnaryOp(UnaryOp {
                operator: UnaryOperator::Reference,
                expression: Box::new(self.parse_primary()?),
            }))
        }
        else {
            return Ok(self.parse_primary()?);
        }
    }

    pub fn parse_primary(&mut self) -> Result<Expression, ParseError> {
        if self.match_token(TokenKind::Name, 0)? {
            Ok(Expression::Access(self.parse_access()?))
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
        if self.match_token(TokenKind::TrueKw, 0)? {
            return Ok(Literal::Boolean(true))
        }
        else if self.match_token(TokenKind::FalseKw, 0)? {
            return Ok(Literal::Boolean(false))
        }
        else if self.match_token(TokenKind::Char, 0)? {
            return Ok(Literal::Char(self.consume()?.value.chars().next().unwrap()))
        }
        else if self.match_token(TokenKind::String, 0)? {
            return Ok(Literal::String(self.consume()?.value))
        }
        else if self.match_token(TokenKind::Number, 0)? {
            let val = self.consume()?.value;
            if val.contains('.') {
                return Ok(Literal::Float(val))
            }
            else {
                return Ok(Literal::Integer(val))
            }
        }
        else {
            return Err(self.gen_error("Invalid literal"));
        }
    }
    
    pub fn parse_variable_assignment(&mut self) -> Result<VariableAssignment, ParseError> {
        let mut var = VariableAssignment::default();
        var.name = self.parse_access()?;
        if self.match_token(TokenKind::Equal, 0)? {
            var.operator = AssignmentOperator::Assign;
            self.consume()?;
        }
        else if self.match_token(TokenKind::Plus, 0)? {
            var.operator = AssignmentOperator::AddAssign;
            self.consume()?;
            self.consume()?;
        }
        else if self.match_token(TokenKind::Minus, 0)? {
            var.operator = AssignmentOperator::SubAssign;
            self.consume()?;
            self.consume()?;
        }
        else if self.match_token(TokenKind::Star, 0)? {
            var.operator = AssignmentOperator::MulAssign;
            self.consume()?;
            self.consume()?;
        }
        else if self.match_token(TokenKind::Slash, 0)? {
            var.operator = AssignmentOperator::DivAssign;
            self.consume()?;
            self.consume()?;
        }
        else if self.match_token(TokenKind::Percent, 0)? {
            var.operator = AssignmentOperator::ModulusAssign;
            self.consume()?;
            self.consume()?;
        }
        else {
            return Err(self.gen_error("Invalid assignment operator"));
        }
        
        var.value = self.parse_expression()?;
        self.consume()?;
        Ok(var)
    }
    
    pub fn parse_if_statenment(&mut self) -> Result<IfStatement, ParseError> {
        let mut i = IfStatement::default();
        self.consume()?;
        i.condition = self.parse_expression()?;
        i.body = Box::new(self.parse_statement()?);
        if self.match_token(TokenKind::ElseKw, 0)? {
            self.consume()?;
            i.else_body = Some(Box::new(self.parse_statement()?));
        }
        return Ok(i);
    }
    
    pub fn parse_switch_statement(&mut self) -> Result<SwitchStatement, ParseError> {
        let mut switch = SwitchStatement::default();
        self.consume()?;
        switch.expression = self.parse_expression()?;
        self.consume()?;
        while !self.match_token(TokenKind::CloseBrace, 0)? {
            switch.cases.push(self.parse_case()?);
        }
        self.consume()?;
        return Ok(switch);
    }

    pub fn parse_case(&mut self) -> Result<Case, ParseError> {
        let mut case = Case::default();
        self.consume()?;
        case.value = Some(self.parse_expression()?);
        self.consume()?;
        case.body = self.parse_block()?;
        self.consume()?;
        return Ok(case);
    }
    
    pub fn parse_statement(&mut self) -> Result<Statement, ParseError> {
        if self.match_token(TokenKind::OpenBrace, 0)? {
            return Ok(Statement::Block(self.parse_block()?));
        }
        else if self.match_token(TokenKind::LetKw, 0)? {
            return Ok(Statement::Declaration(self.parse_variable_declaration(vec![], vec![])?));
        }
        else if self.match_token(TokenKind::Name, 0)? {
            if self.variable_assignment()? {
                return Ok(Statement::Assignment(self.parse_variable_assignment()?));
            }
            else { 
                return Ok(Statement::Call(self.parse_access()?));
            }
        }
        else if self.match_token(TokenKind::IfKw, 0)? {
            return Ok(Statement::If(self.parse_if_statenment()?));
        }
        else if self.match_token(TokenKind::SwitchKw, 0)? {
            return Ok(Statement::Switch(self.parse_switch_statement()?))
        }
        else if self.match_token(TokenKind::WhileKw, 0)? {
            return Ok(Statement::While(self.parse_while_statement()?))
        }
        else if self.match_token(TokenKind::LoopKw, 0)? {
            self.consume()?;
            return Ok(Statement::Loop(Box::new(self.parse_block()?)))
        }
        else if self.match_token(TokenKind::ForKw, 0)? {
            return Ok(Statement::For(self.parse_for_loop()?))
        }
        else if self.match_token(TokenKind::ReturnKw, 0)? {
            self.consume()?;
            if self.match_token(TokenKind::Semicolon, 0)? {
                return Ok(Statement::Return(None));
            }
            else {
                return Ok(Statement::Return(Some(self.parse_expression()?)));
            }
        }
        else if self.match_token(TokenKind::ContinueKw, 0)? {
            self.consume()?;
            return Ok(Statement::Continue);
        }
        else if self.match_token(TokenKind::BreakKw, 0)? {
            self.consume()?;
            return Ok(Statement::Break);
        }
        else {
            return Err(self.gen_error("Invalid statement"));
        }
    }
    
    pub fn parse_while_statement(&mut self) -> Result<WhileStatement, ParseError> {
        let mut whil = WhileStatement::default();
        self.consume()?;
        whil.condition = self.parse_expression()?;
        whil.body = self.parse_block()?;
        return Ok(whil);
    }

    pub fn parse_access(&mut self) -> Result<Access, ParseError> {
        let path = self.parse_path()?;
        
        let args: Option<Vec<Expression>>;
        
        if self.match_token(TokenKind::OpenParen, 0)? {
            self.consume()?;
            let mut a = vec![];
            while !self.match_token(TokenKind::CloseParen, 0)? {
                a.push(self.parse_expression()?);
                if self.match_token(TokenKind::Comma, 0)? {
                    self.consume()?;
                }
            }
            args = Some(a);
        }
        else {
            args = None
        }
        if self.match_token(TokenKind::Dot, 0)? {
            self.consume()?;
            return Ok(Access {
                path,
                arguments: args,
                child: Some(Box::new(self.parse_access()?))
            })
        }
        else {
            return Ok(Access {
                path,
                arguments: args,
                child: None
            })
        }
    }
    
    pub fn variable_assignment(&mut self) -> Result<bool, ParseError> {
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
    
    pub fn parse_trait(&mut self, attributes: Vec<Attribute>, modifiers: Vec<TokenKind>) -> Result<Trait, ParseError> {
        let mut r#trait = Trait::default();
        
        r#trait.attributes = attributes;

        for modifier in modifiers {
            match modifier {
                TokenKind::PublicKw => {
                    r#trait.visibility = Visibility::Public;
                }
                TokenKind::PrivateKw => {
                    r#trait.visibility = Visibility::Private;
                }
                TokenKind::InternalKw => {
                    r#trait.visibility = Visibility::Internal;
                }
                TokenKind::UnsafeKw => {
                    r#trait.safety = Safety::Unsafe;
                }
                TokenKind::SafeKw => {
                    r#trait.safety = Safety::Safe;
                }
                _ => {
                    return Err(self.gen_error("Invalid modifier for trait"));
                }
            }
        }
        
        self.consume()?;
        
        r#trait.name = self.parse_identifier()?;
        
        self.consume()?;

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            let attributes = self.parse_attributes()?;
            let modifiers = self.parse_modifiers()?;
            match self.peek(0)?.kind {
                TokenKind::LetKw => {
                    r#trait.fields.push(Right(self.parse_variable_declaration(attributes, modifiers)?));
                }
                TokenKind::FnKw => {
                    r#trait.fields.push(Left(self.parse_function(attributes, modifiers)?));
                }
                _ => {
                    return Err(self.gen_error("Invalid trait member"));
                }
            }
        }

        self.consume()?;
        
        return Ok(r#trait);
    }
    
    pub fn parse_struct(&mut self, attributes: Vec<Attribute>, modifiers: Vec<TokenKind>) -> Result<Struct, ParseError> {
        let mut struc = Struct::default();
        
        struc.attributes = attributes;

        for modifier in modifiers {
            match modifier {
                TokenKind::PublicKw => {
                    struc.visibility = Visibility::Public;
                }
                TokenKind::PrivateKw => {
                    struc.visibility = Visibility::Private;
                }
                TokenKind::InternalKw => {
                    struc.visibility = Visibility::Internal;
                }
                TokenKind::UnsafeKw => {
                    struc.safety = Safety::Unsafe;
                }
                TokenKind::SafeKw => {
                    struc.safety = Safety::Safe;
                }
                TokenKind::AbstractKw => {
                    struc.is_abstract = true;
                }
                _ => {
                    return Err(self.gen_error("Invalid modifier for struct"));
                }
            }
        }
        
        self.consume()?; // SKip 'struct'
        
        struc.name = self.parse_identifier()?;
        
        self.consume()?;

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            let attributes = self.parse_attributes()?;
            let modifiers = self.parse_modifiers()?;
            match self.peek(0)?.kind { 
                TokenKind::LetKw => {
                    struc.fields.push(Right(self.parse_variable_declaration(attributes, modifiers)?));
                }
                TokenKind::FnKw => {
                    struc.fields.push(Left(self.parse_function(attributes, modifiers)?));
                }
                _ => {
                    return Err(self.gen_error("Invalid struct member"));
                }
            }
        }
        
        self.consume()?;
        
        return Ok(struc);
    }
    
    pub fn parse_enum(&mut self, attributes: Vec<Attribute>, modifiers: Vec<TokenKind>) -> Result<Enum, ParseError> {
        let mut r#enum = Enum::default();
        
        r#enum.attributes = attributes;

        for modifier in modifiers {
            match modifier {
                TokenKind::PublicKw => {
                    r#enum.visibility = Visibility::Public;
                }
                TokenKind::PrivateKw => {
                    r#enum.visibility = Visibility::Private;
                }
                TokenKind::InternalKw => {
                    r#enum.visibility = Visibility::Internal;
                }
                TokenKind::UnsafeKw => {
                    r#enum.safety = Safety::Unsafe;
                }
                TokenKind::SafeKw => {
                    r#enum.safety = Safety::Safe;
                }
                _ => {
                    return Err(self.gen_error("Invalid modifier for enum"));
                }
            }
        }
        
        self.consume()?; // Skip 'enum'
        
        r#enum.name = self.parse_identifier()?;
        
        self.consume()?;
        
        while !self.match_token(TokenKind::CloseBrace, 0)? {
            r#enum.variants.push(self.parse_variant()?);
        }
        
        self.consume()?;
        
        return Ok(r#enum);
    }
    
    pub fn parse_variant(&mut self) -> Result<Variant, ParseError> {
        let mut variant = Variant::default();
        
        variant.attributes = self.parse_attributes()?;
        
        variant.name = self.parse_identifier()?;
        
        if self.match_token(TokenKind::OpenParen, 0)? {
            self.consume()?;
            variant.r#type = self.parse_type()?;
            self.consume()?;
        }
        
        if self.match_token(TokenKind::Comma, 0)? {
            self.consume()?;
        }
        
        return Ok(variant);
    }
    
    pub fn parse_function(&mut self, attributes: Vec<Attribute>,  modifiers: Vec<TokenKind>) -> Result<Function, ParseError> {
        let mut function = Function::default();
        function.attributes = attributes;
        for modifier in modifiers {
            match modifier {
                TokenKind::PublicKw => {
                    function.visibility = Visibility::Public;
                }
                TokenKind::PrivateKw => {
                    function.visibility = Visibility::Private;
                }
                TokenKind::InternalKw => {
                    function.visibility = Visibility::Internal;
                }
                TokenKind::UnsafeKw => {
                    function.safety = Safety::Unsafe;
                }
                TokenKind::SafeKw => {
                    function.safety = Safety::Safe;
                }
                TokenKind::AbstractKw => {
                    function.is_abstract = true;
                }
                TokenKind::VirtualKw => {
                    function.is_virtual = true;
                }
                TokenKind::OverrideKw => {
                    function.is_override = true;
                }
                _ => {
                    return Err(self.gen_error("Invalid modifier for function"));
                }
            }
        }
        
        self.consume()?; // Skip 'fn'
        
        function.name = self.parse_identifier()?;
        if self.match_token(TokenKind::LessThan, 0)? {
            function.generics = self.parse_generic_args()?;
        }
        
        self.consume()?;

        while !self.match_token(TokenKind::CloseParen, 0)? {
            function.inputs.push(self.parse_parameter()?);
        }
        
        self.consume()?;
        
        if self.match_token(TokenKind::Minus, 0)? {
            self.consume()?; // SKip '-'
            self.consume()?; // Skip '>'
            function.output = self.parse_type()?;
        }
        
        if self.match_token(TokenKind::Semicolon, 0)? {
            function.body = None;
            self.consume()?;
        }
        else {
            function.body = Some(self.parse_block()?);
        }
        
        return Ok(function);
    }
    
    pub fn parse_block(&mut self) -> Result<Block, ParseError> {
        let mut block = Block::default();
        
        self.consume()?; // Skip '{'
        
        while !self.match_token(TokenKind::CloseBrace, 0)? {
            block.statements.push(self.parse_statement()?);
        }
        
        self.consume()?;
        
        return Ok(block);
    }
    
    pub fn parse_generic_args(&mut self) -> Result<Vec<Identifier>, ParseError> {
        let mut args = vec![];
        
        self.consume()?; //Skip '<'

        while !self.match_token(TokenKind::GreaterThan, 0)? {
            args.push(self.parse_identifier()?);
            if self.match_token(TokenKind::Comma, 0)? {
                self.consume()?;
            }
        }
        
        self.consume()?;
        
        return Ok(args);
    }
    
    pub fn parse_parameter(&mut self) -> Result<Parameter, ParseError> {
        let mut param = Parameter::default();
        
        param.name = self.parse_identifier()?;
        
        self.consume()?;
        
        param.r#type = self.parse_type()?;
        
        if self.match_token(TokenKind::Comma, 0)? { 
            self.consume()?;
        }
        
        return Ok(param);
    }
    
    pub fn parse_module(&mut self, attributes: Vec<Attribute>, modifiers: Vec<TokenKind>) -> Result<Module, ParseError> {
        let mut module = Module::default();
        
        module.attributes = attributes;
        for modifier in modifiers {
            match modifier {
                TokenKind::PublicKw => {
                    module.visibility = Visibility::Public;
                }
                TokenKind::PrivateKw => {
                    module.visibility = Visibility::Private;
                }
                TokenKind::InternalKw => {
                    module.visibility = Visibility::Internal;
                }
                _ => {
                    return Err(self.gen_error("Invalid modifier for module"));
                }
            }
        }
        
        self.consume()?; // Skip 'module'
        
        module.name = self.parse_identifier()?;
        
        self.consume()?;

        while !self.match_token(TokenKind::CloseBrace, 0)? {
            module.items.push(self.parse_item()?);
        }
        
        self.consume()?;
        
        return Ok(module);
    }
    
    pub fn parse_path(&mut self) -> Result<Path, ParseError> {
        let mut path = Path::default();

        let mut segment = PathSegment::default();
        segment.identifier = self.parse_identifier()?;
        if self.match_token(TokenKind::LessThan, 0)? {
            segment.args = Some(self.parse_type_args()?);
        }
        path.segments.push(segment);
        while self.match_token(TokenKind::Colon, 0)? {
            self.consume()?; // Skip ':'
            self.consume()?; // SKip ':'
            let mut segment = PathSegment::default();
            segment.identifier = self.parse_identifier()?;
            if self.match_token(TokenKind::LessThan, 0)? {
                segment.args = Some(self.parse_type_args()?);
            }
            path.segments.push(segment);
        }
        
        return Ok(path);
    }
    
    pub fn parse_type_args(&mut self) -> Result<Vec<Type>, ParseError> {
        self.consume()?; // Skip '<'
        let mut args = vec![];
        while !self.match_token(TokenKind::GreaterThan, 0)? {
            args.push(self.parse_type()?);
            if self.match_token(TokenKind::Comma, 0)? {
                self.consume()?; // Skip ','
            }
        }
        self.consume()?; // Skip '>'
        return Ok(args);
    }
    
    pub fn parse_type(&mut self) -> Result<Type, ParseError> {
        match self.peek(0)?.kind {
            TokenKind::RefKw => {
                self.consume()?;
                return Ok(Type::Reference(Box::new(self.parse_type()?)));
            }
            TokenKind::Star => {
                self.consume()?;
                return Ok(Type::Pointer(Box::new(self.parse_type()?)));
            }
            TokenKind::Name => {
                let path = self.parse_path()?;
                if self.match_token(TokenKind::OpenBracket, 0)? {
                    self.consume()?;
                    if !self.match_token(TokenKind::CloseBracket, 0)? { 
                        let ty = Type::Array(Box::new(Type::Path(path)), Some(self.parse_literal()?));
                        self.consume()?;
                        return Ok(ty);
                    }
                    let ty = Type::Array(Box::new(Type::Path(path)), None);
                    self.consume()?;
                    return Ok(ty);
                }
                return Ok(Type::Path(path));
            }
            TokenKind::I8Kw
            | TokenKind::I16Kw
            | TokenKind::I32Kw
            | TokenKind::I64Kw
            | TokenKind::U8Kw
            | TokenKind::U16Kw
            | TokenKind::U32Kw
            | TokenKind::U64Kw
            | TokenKind::F32Kw
            | TokenKind::F64Kw
            | TokenKind::BoolKw
            | TokenKind::CharKw => {
                return Ok(Type::Primative(self.consume()?.value))
            }
            _ => {
                return Err(self.gen_error("Invalid type"));
            }
        }
     }
    
    pub fn parse_identifier(&mut self) -> Result<Identifier, ParseError> {
        let identifier = Identifier {
            name: self.consume()?.value
        };
        return Ok(identifier);
    }
    
    pub fn parse_for_loop(&mut self) -> Result<ForLoop, ParseError> {
        let mut lop = ForLoop::default();
        self.consume()?;
        lop.name = self.parse_identifier()?;
        self.consume()?;
        lop.iterator = self.parse_expression()?;
        lop.body = self.parse_block()?;
        Ok(lop)
    }

    pub fn parse_modifiers(&mut self) -> Result<Vec<TokenKind>, ParseError> {
        let mut modifiers = vec![];

        while let Ok(token) = self.peek(0) {
            match token.kind {
                TokenKind::ConstKw
                | TokenKind::ExternKw
                | TokenKind::PublicKw
                | TokenKind::PrivateKw
                | TokenKind::InternalKw
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
    
    pub fn gen_error(&mut self, message: &str) -> ParseError {
        let mut index = self.index;
        while index >= self.tokens.len() {
            index -= 1;
        }
        
        let err =  ParseError {
            line: self.tokens[index].line,
            message: message.to_string(),
        };
        logex::log_error(format!("{}", err).as_str());
        return err;
    }

    pub fn match_token_array(&mut self, kinds: &[TokenKind], offset: usize) -> Result<bool, ParseError> {
        for kind in kinds {
            if self.match_token(*kind, offset)? {
                return Ok(true);
            }
        }
        return Ok(false);
    }
    
    pub fn match_token(&mut self, kind: TokenKind, offset: usize) -> Result<bool, ParseError> {
        Ok(self.peek(offset)?.kind == kind)
    }
    
    pub fn consume(&mut self) -> Result<Token, ParseError> {
        let tok = self.peek(0);
        self.index += 1;
        return tok;
    }
    
    pub fn peek(&mut self, offset: usize) -> Result<Token, ParseError> {
        if self.index + offset >= self.tokens.len() {
            return Err(self.gen_error(""))
        }
        else {
            return Ok(self.tokens[self.index + offset].clone())
        }
    }
}