use hashbrown::HashMap;

pub type Tank = Scope;

pub struct Scope {
    pub symbols: HashMap<String, Symbol>
}

pub struct Symbol {
    pub name: String,
}