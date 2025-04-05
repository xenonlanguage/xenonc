use either::Either;

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Visibility {
    Public,
    Private,
    #[default]
    Internal,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Safety {
    #[default]
    Safe,
    Unsafe,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Tank {
    pub name: String,
    pub items: Vec<Item>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Item {
    ImportTank(Identifier),
    Use(Path),
    Variable(VariableDeclaration),
    Function(Function),
    Module(Module),
    Enum(Enum),
    Struct(Struct),
    Trait(Trait),
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct SwitchStatement {
    pub expression: Expression,
    pub cases: Vec<Case>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Case {
    // Is default if none
    pub value: Option<Expression>,
    pub body: Block,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Struct {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_abstract: bool,
    pub attributes: Vec<Attribute>,
    pub name: Identifier,
    pub parents: Vec<Type>,
    pub fields: Vec<Either<Function, VariableDeclaration>>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Trait {
    pub visibility: Visibility,
    pub safety: Safety,
    pub attributes: Vec<Attribute>,
    pub name: Identifier,
    pub fields: Vec<Either<Function, VariableDeclaration>>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Enum {
    pub visibility: Visibility,
    pub safety: Safety,
    pub attributes: Vec<Attribute>,
    pub name: Identifier,
    pub variants: Vec<Variant>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Variant {
    pub attributes: Vec<Attribute>,
    pub name: Identifier,
    pub r#type: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Function {
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_abstract: bool,
    pub is_virtual: bool,
    pub is_override: bool,
    pub attributes: Vec<Attribute>,
    pub name: Identifier,
    pub generics: Vec<Identifier>,
    pub inputs: Vec<Parameter>,
    pub output: Type,
    pub body: Option<Block>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Block {
    pub statements: Vec<Statement>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Statement {
    Block(Block),
    Declaration(VariableDeclaration),
    Assignment(VariableAssignment),
    Call(Access),
    If(IfStatement),
    Switch(SwitchStatement),
    While(WhileStatement),
    Loop(Box<Block>),
    For(ForLoop),
    Return(Option<Expression>),
    Break,
    Continue,
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct WhileStatement {
    pub condition: Expression,
    pub body: Block,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct IfStatement {
    pub condition: Expression,
    pub body: Box<Statement>,
    pub else_body: Option<Box<Statement>>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct ForLoop {
    pub name: Identifier,
    pub iterator: Expression,
    pub body: Block,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Access {
    pub path: Path,
    pub arguments: Option<Vec<Expression>>,
    pub child: Option<Box<Access>>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct VariableDeclaration {
    pub attributes: Vec<Attribute>,
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_const: bool,
    pub name: Identifier,
    pub r#type: Option<Type>,
    pub initializer: Option<Expression>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct VariableAssignment {
    pub name: Access,
    pub operator: AssignmentOperator,
    pub value: Expression,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum AssignmentOperator {
    #[default]
    Assign,
    AddAssign,
    SubAssign,
    MulAssign,
    DivAssign,
    ModulusAssign,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Parameter {
    pub name: Identifier,
    pub r#type: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Module {
    pub attributes: Vec<Attribute>,
    pub visibility: Visibility,
    pub name: Identifier,
    pub items: Vec<Item>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Attribute {
    pub name: Path,
    pub value: Option<Path>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Type {
    Array(Box<Type>, Option<Literal>),
    Pointer(Box<Type>),
    Reference(Box<Type>),
    Path(Path),
    Primative(String),
    #[default]
    Null
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Path {
    pub segments: Vec<PathSegment>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct PathSegment {
    pub identifier: Identifier,
    pub args: Option<Vec<Type>>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Expression {
    Array(Vec<Expression>),
    Struct(Path, Vec<StructParam>),
    Access(Access),
    BinaryOp(BinaryOp),
    Cast(Cast),
    UnaryOp(UnaryOp),
    Index(Box<Expression>, Box<Expression>),
    Path(Path),
    Literal(Literal),
    #[default]
    Null
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct StructParam {
    pub name: Identifier,
    pub value: Expression,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Identifier {
    pub name: String,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct UnaryOp {
    pub operator: UnaryOperator,
    pub expression: Box<Expression>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum UnaryOperator {
    Not,
    Negate,
    Deref,
    Pointer,
    Reference,
    #[default]
    Null
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct BinaryOp {
    pub left: Box<Expression>,
    pub operator: BinaryOperator,
    pub right: Box<Expression>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Cast {
    pub value: Box<Expression>,
    pub r#type: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum BinaryOperator {
    Add,
    Sub,
    Mul,
    Div,
    Rem,
    And,
    Or,
    BitXor,
    BitAnd,
    BitOr,
    Shl,
    Shr,
    Eq,
    Lt,
    Le,
    Ne,
    Ge,
    Gt,
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub enum Literal {
    Boolean(bool),
    Char(char),
    Integer(String),
    Float(String),
    String(String),
    #[default]
    Null
}