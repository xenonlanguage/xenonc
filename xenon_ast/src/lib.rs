pub mod ast;

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
