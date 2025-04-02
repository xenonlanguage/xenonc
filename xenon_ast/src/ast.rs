use crate::{Safety, Visibility};
use either::Either;

pub struct Program {
    pub file_name: String,
    pub members: Vec<ProgramMember>
}

pub enum ProgramMember {
    FunctionDeclaration(FunctionDeclaration),
    VariableDeclaration(VariableDeclaration),
    StructDeclaration(StructDeclaration),
    TraitDeclaration(TraitDeclaration),
    UseDeclaration(UseDeclaration),
    ModuleDeclaration(ModuleDeclaration)
}

pub struct FunctionDeclaration {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_extern: bool,
    pub is_override: bool,
    pub is_virtual: bool,
    pub is_async: bool,
    pub name: String,
    pub parameters: Vec<Parameter>,
    pub r#type: Option<Type>,
    pub body: Option<Block>
}

pub struct Parameter {
    pub name: String,
    pub r#type: Type
}

pub struct VariableDeclaration {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_const: bool,
    pub is_extern: bool,
    pub name: String,
    pub r#type: Option<Type>,
    pub value: Option<Expression>
}

pub struct StructDeclaration {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_abstract: bool,
    pub name: String,
    pub inherits: Vec<Path>,
    pub items: Vec<Either<FunctionDeclaration, VariableDeclaration>>
}

pub struct TraitDeclaration {
    pub visibility: Visibility,
    pub name: String,
    pub items: Vec<Either<FunctionDeclaration, VariableDeclaration>>
}

pub struct UseDeclaration {
    pub path: Path
}

pub struct ModuleDeclaration {
    pub visibility: Visibility,
    pub name: String,
    pub items: Vec<ModuleMember>
}

pub struct Path {
    pub segments: Vec<String>
}

pub struct Block {
    pub statements: Vec<Statement>
}

pub struct Identifier {
    pub name: String,
    pub arguments: Option<Vec<Expression>>,
    pub child: Option<Box<Identifier>>
}

pub enum Statement {
    VariableAssignment(VariableAssignment),
    VariableDeclaration(VariableDeclaration),
    FunctionCall(Identifier),
    ForLoop(ForLoop),
    IfStatement(IfStatement),
    LoopStatement(LoopStatement),
    SwitchStatement(SwitchStatement),
    UnsafeBlock(Block),
    WhileLoop(WhileLoop),
    ReturnStatement(Expression),
    ContinueStatement,
    BreakStatement
}

pub struct VariableAssignment {
    pub name: Identifier,
    pub operator: String,
    pub value: Expression
}

pub struct ForLoop {
    pub name: String,
    pub iterator: Identifier,
    pub body: Box<Statement>
}

pub struct IfStatement {
    pub condition: Expression,
    pub body: Box<Statement>,
    pub else_body: Option<Box<Statement>>
}

pub struct LoopStatement {
    pub body: Box<Statement>
}

pub struct SwitchStatement {
    pub condition: Expression,
    pub cases: Vec<Case>
}

pub struct Case {
    pub case: Expression,
    pub body: Block
}

pub struct WhileLoop {
    pub condition: Expression,
    pub body: Box<Statement>
}

pub enum ModuleMember {
    VariableDeclaration(VariableDeclaration),
    FunctionDeclaration(FunctionDeclaration),
    ModuleDeclaration(ModuleDeclaration),
    StructDeclaration(StructDeclaration),
    TraitDeclaration(TraitDeclaration),
    UseDeclaration(UseDeclaration)
}

pub enum Type {
    PointerType(Box<Type>),
    ReferenceType(Box<Type>),
    /// Inputs and output
    FunctionRefType(Vec<Type>, Box<Type>),
    TupleType(Vec<Type>),
    PathType(Path),
    PrimativeType(String),
    ArrayType(Box<Type>, Literal)
}

pub enum Expression {
    Parentheses(Box<Expression>),
    OrExpr(OrExpr),
    FunctionCall(Identifier),
    UnaryOperation(UnaryOperation),
    Literal(Literal),
    Identifier(Identifier)
}

pub enum Literal {
    StringLiteral(String),
    NumberLiteral(String),
    CharLiteral(char),
    BooleanLiteral(bool),
    ArrayLiteral(Vec<Expression>),
    TupleLiteral(Vec<Expression>)
}

pub struct OrExpr {
    pub left: Box<OrExpr>,
    pub right: Box<AndExpr>
}

pub struct AndExpr {
    pub left: Box<AndExpr>,
    pub right: Box<CmpExpr>
}

pub struct CmpExpr {
    pub left: Box<CmpExpr>,
    pub operator: String,
    pub right: Box<BitOrExpr>
}

pub struct BitOrExpr {
    pub left: Box<BitOrExpr>,
    pub right: Box<BitXorExpr>
}

pub struct BitXorExpr {
    pub left: Box<BitXorExpr>,
    pub right: Box<BitAndExpr>
}

pub struct BitAndExpr {
    pub left: Box<BitAndExpr>,
    pub right: Box<ShiftExpr>
}

pub struct ShiftExpr {
    pub left: Box<ShiftExpr>,
    pub operator: String,
    pub right: Box<AddExpr>
}

pub struct AddExpr {
    pub left: Box<AddExpr>,
    pub operator: String,
    pub right: Box<MulExpr>
}

pub struct MulExpr {
    pub left: Box<MulExpr>,
    pub operator: String,
    pub right: Box<CastExpr>
}

pub struct CastExpr {
    pub left: Box<UnaryOperation>,
    pub right: Type
}

pub struct UnaryOperation {
    pub operator: String,
    pub expression: Box<Expression>
}