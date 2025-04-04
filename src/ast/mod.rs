use std::fmt;
use std::fmt::{Formatter};
use either::Either;
use enum_as_inner::EnumAsInner;
use crate::ast::Literal::StringLiteral;

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Safety {
    #[default]
    Safe,
    Unsafe,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Visibility {
    #[default]
    Public,
    Private,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Program {
    pub file_name: String,
    pub members: Vec<ProgramMember>,
}

#[derive(Clone, Debug, Default, EnumAsInner, PartialEq, PartialOrd)]
pub enum ProgramMember {
    FunctionDeclaration(FunctionDeclaration),
    VariableDeclaration(VariableDeclaration),
    StructDeclaration(StructDeclaration),
    TraitDeclaration(TraitDeclaration),
    UseDeclaration(UseDeclaration),
    ModuleDeclaration(ModuleDeclaration),
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct FunctionDeclaration {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_extern: bool,
    pub is_override: bool,
    pub is_virtual: bool,
    pub is_async: bool,
    pub name: Path,
    pub parameters: Vec<Parameter>,
    pub r#type: Option<Type>,
    pub body: Option<Block>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Parameter {
    pub name: String,
    pub r#type: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct VariableDeclaration {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_const: bool,
    pub is_extern: bool,
    pub name: String,
    pub r#type: Option<Type>,
    pub value: Option<Expression>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct StructDeclaration {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_abstract: bool,
    pub name: String,
    pub type_arguments: Vec<String>,
    pub inherits: Vec<Path>,
    pub items: Vec<Either<FunctionDeclaration, VariableDeclaration>>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct TraitDeclaration {
    pub visibility: Visibility,
    pub name: String,
    pub type_arguments: Vec<String>,
    pub items: Vec<Either<FunctionDeclaration, VariableDeclaration>>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct UseDeclaration {
    pub path: Path,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct ModuleDeclaration {
    pub visibility: Visibility,
    pub name: String,
    pub items: Vec<ModuleMember>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Hash)]
pub struct Path {
    pub name: String,
    pub seperator: Option<String>,
    pub arguments: Option<Vec<Expression>>,
    pub type_arguments: Option<Vec<Type>>,
    /// Where in an array to access, if any
    pub accessor: Box<Option<Expression>>,
    pub child: Option<Box<Path>>,
}
impl fmt::Display for Path {
    fn fmt(&self, fmt: &mut Formatter<'_>) -> fmt::Result {
        write!(fmt, "{}", self.name)?;
        match self.seperator { 
            Some(ref seperator) => write!(fmt, "{}", seperator)?,
            None => (),
        }
        match self.type_arguments {
            Some(ref type_arguments) => {
                write!(fmt, "<{}>", type_arguments.iter().map(|t| t.to_string()).collect::<Vec<_>>().join(", "))?;
            }
            None => (),
        }
        Ok(())
    }
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Block {
    pub statements: Vec<Statement>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Statement {
    Block(Block),
    VariableAssignment(VariableAssignment),
    VariableDeclaration(VariableDeclaration),
    FunctionCall(Path),
    ForLoop(ForLoop),
    IfStatement(IfStatement),
    LoopStatement(LoopStatement),
    SwitchStatement(SwitchStatement),
    UnsafeBlock(Block),
    WhileLoop(WhileLoop),
    ReturnStatement(Option<Expression>),
    ContinueStatement,
    BreakStatement,
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct VariableAssignment {
    pub name: Path,
    pub operator: String,
    pub value: Expression,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct ForLoop {
    pub name: String,
    pub iterator: Path,
    pub body: Box<Statement>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct IfStatement {
    pub condition: Expression,
    pub body: Box<Statement>,
    pub else_body: Option<Box<Statement>>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct LoopStatement {
    pub body: Box<Statement>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct SwitchStatement {
    pub condition: Expression,
    pub cases: Vec<Case>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Case {
    pub case: Expression,
    pub body: Block,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct WhileLoop {
    pub condition: Expression,
    pub body: Box<Statement>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum ModuleMember {
    VariableDeclaration(VariableDeclaration),
    FunctionDeclaration(FunctionDeclaration),
    ModuleDeclaration(ModuleDeclaration),
    StructDeclaration(StructDeclaration),
    TraitDeclaration(TraitDeclaration),
    UseDeclaration(UseDeclaration),
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Hash)]
pub enum Type {
    PointerType(Box<Type>),
    ReferenceType(Box<Type>),
    /// Inputs and output
    TupleType(Vec<Type>),
    PathType(Path),
    PrimativeType(String),
    ArrayType(Box<Type>, Option<Literal>),
    #[default]
    Null,
}
impl fmt::Display for Type {
    fn fmt(&self, fmt: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self {
            Type::PointerType(t) => {
                write!(fmt, "*{}", t)?
            }
            Type::ReferenceType(t) => {
                write!(fmt, "ref {}", t)?
            }
            Type::TupleType(t) => {
                write!(fmt, "(")?;
                if t.len() >= 1 {
                    write!(fmt, "{}", t[0])?
                }
                for i in 0..t.len() {
                    write!(fmt, ", {}", t[i])?
                }
                write!(fmt, ")")?;
            }
            Type::PathType(t) => {
                write!(fmt, "{}", t)?
            }
            Type::PrimativeType(t) => {
                write!(fmt, "{}", t)?
            }
            Type::ArrayType(t, l) => {
                write!(fmt, "{}[{:#?}]", t, l)?
            }
            Type::Null => {
                write!(fmt, "null")?
            }
        }
        Ok(())
    }
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Hash)]
pub enum Expression {
    Parentheses(Box<Expression>),
    BinOp(BinOp),
    UnaryOperation(UnaryOperation),
    Literal(Literal),
    Identifier(Path),
    Cast(Cast),
    #[default]
    Null,
}
impl fmt::Display for Expression {
    fn fmt(&self, fmt: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self { 
            Expression::Parentheses(e) => {
                write!(fmt, "({})", e)?;
            }
            Expression::BinOp(e) => {
                write!(fmt, "({} {} {})", e.left, e.operator, e.right)?;
            }
            Expression::UnaryOperation(e) => {
                write!(fmt, "{}{}", e.operator, e.expression)?;
            }
            Expression::Literal(e) => {
                write!(fmt, "{}", e)?;
            }
            Expression::Identifier(e) => {
                write!(fmt, "{}", e)?;
            }
            Expression::Cast(e) => {
                write!(fmt, "{} as {}", e.left, e.right)?;
            }
            Expression::Null => {
                write!(fmt, "null")?;
            }
        }
        return Ok(())
    }
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
#[derive(Hash)]
pub enum Literal {
    StringLiteral(String),
    IntegerLiteral(String),
    FloatLiteral(String),
    CharLiteral(char),
    BooleanLiteral(bool),
    ArrayLiteral(Vec<Expression>),
    TupleLiteral(Vec<Expression>),
    #[default]
    Null,
}
impl fmt::Display for Literal {
    fn fmt(&self, fmt: &mut fmt::Formatter<'_>) -> fmt::Result {
        match self { 
            Literal::StringLiteral(s) => {
                write!(fmt, "\"{}\"", s)?;
            }
            Literal::IntegerLiteral(s) => {
                write!(fmt, "{}", s)?;
            }
            Literal::FloatLiteral(s) => {
                write!(fmt, "{}", s)?;
            }
            Literal::CharLiteral(s) => {
                write!(fmt, "'{}'", s)?;
            }
            Literal::BooleanLiteral(s) => {
                write!(fmt, "{}", s)?;
            }
            Literal::ArrayLiteral(s) => {
                write!(fmt, "[")?;
                if s.len() >= 1 {
                    write!(fmt, "{}", s[0])?;
                }
                for i in 0..s.len() {
                    write!(fmt, ", {}", s[i])?;
                }
                write!(fmt, "]")?;
            }
            Literal::TupleLiteral(s) => {
                write!(fmt, "(")?;
                if s.len() >= 1 {
                    write!(fmt, "{}", s[0])?;
                }
                for i in 0..s.len() {
                    write!(fmt, ", {}", s[i])?;
                }
                write!(fmt, ")")?;
            }
            Literal::Null => {
                write!(fmt, "null")?;
            }
        }
        Ok(())
    }
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Hash)]
pub struct BinOp {
    pub left: Box<Expression>,
    pub operator: String,
    pub right: Box<Expression>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
#[derive(Hash)]
pub struct Cast {
    pub left: Box<Expression>,
    pub right: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
#[derive(Hash)]
pub struct UnaryOperation {
    pub operator: String,
    pub expression: Box<Expression>,
}
