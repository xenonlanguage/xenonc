use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "visibility")]
pub enum Visibility {
    #[serde(rename = "public")]
    Public,
    #[serde(rename = "private")]
    Private,
    #[default]
    #[serde(rename = "internal")]
    Internal,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "safety")]
pub enum Safety {
    #[default]
    #[serde(rename = "safe")]
    Safe,
    #[serde(rename = "unsafe")]
    Unsafe,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize)]
#[serde(rename = "tank")]
pub struct Tank {
    #[serde(rename = "name")]
    pub name: String,
    #[serde(rename = "items")]
    pub items: Vec<Item>
}
impl Tank {
    pub fn new(name: String) -> Tank {
        Self {
            name,
            items: vec![]
        }
    }
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "item")]
pub enum Item {
    #[serde(rename = "import tank")]
    ImportTank(Identifier),
    #[serde(rename = "use")]
    Use(Path),
    #[serde(rename = "variable")]
    Variable(VariableDeclaration),
    #[serde(rename = "function")]
    Function(Function),
    #[serde(rename = "module")]
    Module(Module),
    #[serde(rename = "enum")]
    Enum(Enum),
    #[serde(rename = "struct")]
    Struct(Struct),
    #[serde(rename = "trait")]
    Trait(Trait),
    #[default]
    #[serde(rename = "null")]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "switch")]
pub struct Switch {
    #[serde(rename = "expression")]
    pub expression: Expression,
    #[serde(rename = "cases")]
    pub cases: Vec<Case>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "case")]
pub struct Case {
    // Is default if none
    #[serde(rename = "value")]
    pub value: Option<Expression>,
    #[serde(rename = "body")]
    pub body: Block,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "struct")]
pub struct Struct {
    #[serde(rename = "visibility")]
    pub visibility: Visibility,
    #[serde(rename = "safety")]
    pub safety: Safety,
    #[serde(rename = "abstract")]
    pub is_abstract: bool,
    #[serde(rename = "attributes")]
    pub attributes: Vec<Attribute>,
    #[serde(rename = "name")]
    pub name: Identifier,
    #[serde(rename = "parents")]
    pub parents: Vec<Type>,
    #[serde(rename = "fields")]
    pub fields: Vec<StructField>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "field")]
pub enum StructField {
    #[serde(rename = "function")]
    Function(Function),
    #[serde(rename = "variable")]
    Variable(VariableDeclaration),
    #[default]
    #[serde(rename = "null")]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "trait")]
pub struct Trait {
    #[serde(rename = "visibility")]
    pub visibility: Visibility,
    #[serde(rename = "safety")]
    pub safety: Safety,
    #[serde(rename = "attributes")]
    pub attributes: Vec<Attribute>,
    #[serde(rename = "name")]
    pub name: Identifier,
    #[serde(rename = "fields")]
    pub fields: Vec<TraitField>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
#[serde(rename = "field")]
pub enum TraitField {
    #[serde(rename = "function")]
    Function(Function),
    #[serde(rename = "variable")]
    Variable(VariableDeclaration),
    #[default]
    #[serde(rename = "null")]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Enum {
    pub visibility: Visibility,
    pub safety: Safety,
    pub attributes: Vec<Attribute>,
    pub name: Identifier,
    pub variants: Vec<Variant>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Variant {
    pub attributes: Vec<Attribute>,
    pub name: Identifier,
    pub r#type: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
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

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Block {
    pub statements: Vec<Statement>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub enum Statement {
    Block(Block),
    Declaration(VariableDeclaration),
    Assignment(VariableAssignment),
    Call(Access),
    Unsafe(Block),
    If(IfStatement),
    Switch(Switch),
    While(WhileStatement),
    Loop(Box<Block>),
    For(ForLoop),
    Return(Option<Expression>),
    Break,
    Continue,
    #[default]
    Null,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct WhileStatement {
    pub condition: Expression,
    pub body: Block,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct IfStatement {
    pub condition: Expression,
    pub body: Box<Statement>,
    pub else_body: Option<Box<Statement>>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct ForLoop {
    pub name: Identifier,
    pub iterator: Expression,
    pub body: Block,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Access {
    pub path: Path,
    pub arguments: Option<Vec<Expression>>,
    pub child: Option<Box<Access>>,
    pub index: Box<Option<Expression>>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct VariableDeclaration {
    pub attributes: Vec<Attribute>,
    pub visibility: Visibility,
    pub safety: Safety,
    pub is_const: bool,
    pub name: Identifier,
    pub r#type: Option<Type>,
    pub initializer: Option<Expression>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct VariableAssignment {
    pub name: Access,
    pub operator: AssignmentOperator,
    pub value: Expression,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub enum AssignmentOperator {
    #[default]
    Assign,
    AddAssign,
    SubAssign,
    MulAssign,
    DivAssign,
    ModulusAssign,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Parameter {
    pub name: Identifier,
    pub r#type: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Module {
    pub attributes: Vec<Attribute>,
    pub visibility: Visibility,
    pub name: Identifier,
    pub items: Vec<Item>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Attribute {
    pub name: Path,
    pub value: Option<Path>,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub enum Type {
    Array(Box<Type>, Option<Literal>),
    Pointer(Box<Type>),
    Reference(Box<Type>),
    Path(Path),
    Primative(String),
    #[default]
    Null
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Path {
    pub segments: Vec<PathSegment>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct PathSegment {
    pub identifier: Identifier,
    pub args: Option<Vec<Type>>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
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

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct StructParam {
    pub name: Identifier,
    pub value: Expression,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Identifier {
    pub name: String,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct UnaryOp {
    pub operator: UnaryOperator,
    pub expression: Box<Expression>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub enum UnaryOperator {
    Not,
    Negate,
    Deref,
    Pointer,
    Reference,
    #[default]
    Null
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct BinaryOp {
    pub left: Box<Expression>,
    pub operator: BinaryOperator,
    pub right: Box<Expression>
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub struct Cast {
    pub value: Box<Expression>,
    pub r#type: Type,
}

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
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

#[derive(Clone, Debug, Default, PartialEq, PartialOrd, Serialize, Deserialize, Hash)]
pub enum Literal {
    Boolean(bool),
    Char(char),
    Integer(String),
    Float(String),
    String(String),
    #[default]
    Null
}