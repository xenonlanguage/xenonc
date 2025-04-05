use either::Either;

pub struct Tank {
    pub items: Vec<Item>
}

pub enum Item {
    ExternTank(Identifier),
    Use(UseTree),
    Function(Function),
    Module(Module),
    Enum(Enum),
    Struct(Struct),
    Trait(Trait),
}

pub struct Struct {
    pub name: Identifier,
    pub parents: Vec<Type>,
    pub fields: Vec<Either<Function, VariableDeclaration>>
}

pub struct Trait {
    pub name: Identifier,
    pub fields: Vec<Either<Function, VariableDeclaration>>
}

pub struct Enum {
    pub name: Identifier,
    pub variants: Vec<Variant>
}

pub struct Variant {
    pub name: Identifier,
    pub r#type: Type,
}

pub struct UseTree {
    pub prefix: Path,
    pub kind: UseTreeKind
}

pub enum UseTreeKind {
    Simple(Identifier),
    Nested(Vec<UseTree>),
    Glob
}

pub struct Function {
    pub name: Identifier,
    pub generics: Vec<Identifier>,
    pub inputs: Vec<Parameter>,
    pub output: Type,
    pub body: Option<Block>,
}

pub struct Block {
    pub statements: Vec<Statement>,
}

pub enum Statement {
    Block(Block),
    Declaration(VariableDeclaration),
    Assignment(VariableAssignment),
    Call(Identifier, Vec<Expression>),
    If(Expression, Box<Block>, Option<Box<Block>>),
    While(Expression, Box<Block>),
    Loop(Box<Block>),
    For(Identifier, Expression, Box<Block>),
    Return(Option<Expression>),
    Break,
    Continue,
    Null,
}

pub struct VariableDeclaration {
    pub name: Identifier,
    pub r#type: Option<Type>,
    pub initializer: Option<Expression>,
}

pub struct VariableAssignment {
    pub name: Path,
    pub operator: AssignmentOperator,
    pub value: Expression,
}

pub enum AssignmentOperator {
    Assign,
    AddAssign,
    SubAssign,
    MulAssign,
    DivAssign,
    ModulusAssign,
}

pub struct Parameter {
    pub name: Identifier,
    pub r#type: Type,
}

pub struct Module {
    pub name: Identifier,
    pub items: Vec<Item>
}

pub struct Attribute {
    pub name: String,
    pub value: Option<String>,
}

pub enum Type {
    Array(Box<Type>, Option<Literal>),
    Pointer(Box<Type>),
    Reference(Box<Type>),
    Path(Path),
    Primative(String),
    Null
}

pub struct Path {
    pub segments: Vec<PathSegment>
}

pub struct PathSegment {
    pub identifier: Identifier,
    pub args: Option<Vec<Type>>
}

pub enum Expression {
    Array(Vec<Expression>),
    Identifier(Identifier),
    Call(Identifier, Vec<Expression>),
    BinaryOp(BinaryOp),
    Cast(Cast),
    UnaryOp(UnaryOp),
    Index(Box<Expression>, Box<Expression>),
    Path(Path),
    Literal(Literal),
    Null
}

pub struct Identifier {
    pub name: String,
}

pub struct UnaryOp {
    pub operator: UnaryOperator,
    pub expression: Box<Expression>
}

pub enum UnaryOperator {
    Not,
    Negate,
    Deref,
    Pointer,
    Reference
}

pub struct BinaryOp {
    pub left: Box<Expression>,
    pub operator: BinaryOperator,
    pub right: Box<Expression>
}

pub struct Cast {
    pub value: Box<Expression>,
    pub r#type: Type,
}

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
}

pub enum Literal {
    Boolean(bool),
    Char(char),
    Integer(String),
    Float(String),
    String(String),
    Null
}