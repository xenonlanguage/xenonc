use either::Either;


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

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
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
    pub name: String,
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
    pub inherits: Vec<Path>,
    pub items: Vec<Either<FunctionDeclaration, VariableDeclaration>>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct TraitDeclaration {
    pub visibility: Visibility,
    pub name: String,
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

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Path {
    pub name: String,
    pub seperator: Option<String>,
    pub arguments: Option<Vec<Expression>>,
    pub child: Option<Box<Path>>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Block {
    pub statements: Vec<Statement>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Statement {
    VariableAssignment(VariableAssignment),
    VariableDeclaration(VariableDeclaration),
    FunctionCall(Path),
    ForLoop(ForLoop),
    IfStatement(IfStatement),
    LoopStatement(LoopStatement),
    SwitchStatement(SwitchStatement),
    UnsafeBlock(Block),
    WhileLoop(WhileLoop),
    ReturnStatement(Expression),
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

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Type {
    PointerType(Box<Type>),
    ReferenceType(Box<Type>),
    /// Inputs and output
    FunctionRefType(Vec<Type>, Box<Type>),
    TupleType(Vec<Type>),
    PathType(Path),
    PrimativeType(String),
    ArrayType(Box<Type>, Literal),
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Expression {
    Parentheses(Box<Expression>),
    BinOp(BinOp),
    FunctionCall(Path),
    UnaryOperation(UnaryOperation),
    Literal(Literal),
    Identifier(Path),
    Cast(Cast),
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
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

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct BinOp {
    pub left: Box<Expression>,
    pub operator: String,
    pub right: Box<Expression>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Cast {
    pub left: Box<Expression>,
    pub right: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct UnaryOperation {
    pub operator: String,
    pub expression: Box<Expression>,
}
