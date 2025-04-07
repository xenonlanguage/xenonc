use std::thread::scope;
use hashbrown::HashMap;
use serde::{Deserialize, Serialize};
use uuid::Uuid;
use crate::ast::{Block, Enum, Function, Item, Tank, Trait, TraitField, Type, VariableDeclaration, Variant, Visibility, Statement, Struct, Module, StructField};

#[derive(Clone, Debug, Default)]
pub struct Scope {
    pub symbols: HashMap<String, Symbol>
}

impl Scope {
    pub fn create_item_symbol(&mut self, item: Item) {
        match item {
            Item::Enum(e) => {
                let symbol = self.create_enum_symbol(e.clone());
                self.symbols.insert(e.name.name.clone(), symbol);
            }
            Item::Variable(v) => {
                let symbol = self.create_variable_symbol(v.clone());
                self.symbols.insert(v.name.name.clone(), symbol);
            }
            Item::Trait(t) => {
                let symbol = self.create_trait_symbol(t.clone());
                self.symbols.insert(t.name.name.clone(), symbol);
            }
            Item::Function(f) => {
                let symbol = self.create_function_symbol(f.clone());
                self.symbols.insert(f.name.name.clone(), symbol);
            }
            Item::Struct(s) => {
                let symbol = self.create_struct_symbol(s.clone());
                self.symbols.insert(s.name.name.clone(), symbol);
            }
            Item::Module(m) => {
                let symbol = self.create_module_symbol(m.clone());
                self.symbols.insert(m.name.name.clone(), symbol);
            }
            _ => {
                
            }
        }
    }

    fn create_enum_symbol(&mut self, e: Enum) -> Symbol {
        let mut symbol = Symbol::default();
        symbol.name = e.name.name;
        symbol.unique_id = Uuid::new_v4();
        symbol.data = SymbolData::EnumData(e.variants);
        symbol
    }
    
    fn create_variable_symbol(&mut self, v: VariableDeclaration) -> Symbol {
        let mut symbol = Symbol::default();
        symbol.name = v.name.name;
        symbol.unique_id = Uuid::new_v4();
        symbol.data = SymbolData::VariableData(v.r#type);
        symbol
    }

    fn create_trait_symbol(&mut self, t: Trait) -> Symbol {
        let mut symbol = Symbol::default();
        symbol.name = t.name.name;
        symbol.unique_id = Uuid::new_v4();
        symbol.data = {
            let mut fields = Scope::default();

            for field in t.fields {
                match field {
                    TraitField::Variable(v) => {
                        fields.symbols.insert(v.name.name.clone(), self.create_variable_symbol(v.clone()));
                    }
                    TraitField::Function(f) => {
                        fields.symbols.insert(f.name.name.clone(), self.create_function_symbol(f.clone()));
                    }
                    _ => {
                        
                    }
                }
            }
            
            SymbolData::TraitData(fields)
        };
        symbol
    }
    
    fn create_function_symbol(&mut self, f: Function) -> Symbol {
        let mut symbol = Symbol::default();
        
        symbol.name = f.name.name.clone();
        symbol.unique_id = Uuid::new_v4();
        symbol.data = {
            let mut data = FunctionData::default();
            
            data.inputs = {
                let mut fields = vec![];

                for input in f.inputs {
                    fields.push({
                        let mut symbol = Symbol::default();
                        symbol.name = input.name.name;
                        symbol.unique_id = Uuid::new_v4();
                        symbol.data = SymbolData::VariableData(Some(input.r#type));
                        symbol
                    });
                }

                fields
            };
            
            data.output = f.output.clone();
            
            match f.body {
                Some(body) => {
                    data.body = Box::new(Some(self.create_block_scope(body)));
                }
                None => {
                    data.body = Box::new(None);
                }
            }
            
            SymbolData::FunctionData(data)
        };
        
        return symbol;
    }
    
    fn create_block_scope(&mut self, body: Block) -> Symbol {
        let mut scope = Scope::default();

        for statement in body.statements {
            match statement { 
                Statement::Block(s) => {
                    scope.symbols.insert("".to_string(), self.create_block_scope(s));
                }
                Statement::Unsafe(u) => {
                    scope.symbols.insert("".to_string(), self.create_block_scope(u));
                }
                Statement::For(f) => {
                    scope.symbols.insert("".to_string(), {
                        let mut symbol = Symbol::default();
                        
                        symbol.name = f.name.name;
                        symbol.unique_id = Uuid::new_v4();
                        symbol.data = SymbolData::VariableData(None);
                        
                        symbol
                    });
                    scope.symbols.insert("".to_string(), self.create_block_scope(f.body));
                }
                Statement::If(i) => {
                    scope.symbols.insert("".to_string(), self.create_block_scope(Block {
                        statements: vec![*i.body],
                    }));
                    if i.else_body.is_some() {
                        scope.symbols.insert("".to_string(), self.create_block_scope(Block {
                            statements: vec![*i.else_body.unwrap()],
                        }));
                    }
                }
                Statement::Switch(s) => {
                    for case in s.cases {
                        scope.symbols.insert("".to_string(), self.create_block_scope(case.body));
                    }
                }
                Statement::Loop(l) => {
                    scope.symbols.insert("".to_string(), self.create_block_scope(*l));
                }
                Statement::Declaration(d) => {
                    scope.symbols.insert(d.name.name.clone(), self.create_variable_symbol(d.clone()));
                }
                Statement::While(w) => {
                    scope.symbols.insert("".to_string(), self.create_block_scope(w.body));
                }
                _ => ()
            }
        }
        
        Symbol {
            name: "".to_string(),
            unique_id: Uuid::new_v4(),
            data: SymbolData::Block(scope)
        }
    }

    fn create_struct_symbol(&mut self, str: Struct) -> Symbol {
        let mut symbol = Symbol::default();
        
        symbol.name = str.name.name.clone();
        symbol.unique_id = Uuid::new_v4();
        symbol.data = {
            let mut data = SymbolData::default();
            let mut fields = Scope::default();
            for field in str.fields {
                match field { 
                    StructField::Variable(f) => {
                        fields.symbols.insert(f.name.name.clone(), self.create_variable_symbol(f.clone()));
                    }
                    StructField::Function(f) => {
                        fields.symbols.insert(f.name.name.clone(), self.create_function_symbol(f.clone()));
                    }
                    _ => {}
                }
            }
            
            data = SymbolData::StructData(fields);
            data
        };
        
        
        symbol
    }

    fn create_module_symbol(&self, modu: Module) -> Symbol {
        let mut symbol = Symbol::default();
        symbol.name = modu.name.name.clone();
        symbol.unique_id = Uuid::new_v4();
        symbol.data = {
            let mut scope = Scope::default();
            for item in modu.items {
                scope.create_item_symbol(item);
            }
            SymbolData::Module(scope)
        };
        
        symbol
    }
}

#[derive(Clone, Debug, Default)]
pub struct Symbol {
    pub name: String,
    pub unique_id: Uuid,
    pub data: SymbolData
}

#[derive(Clone, Debug, Default)]
pub enum SymbolData {
    EnumData(Vec<Variant>),
    VariableData(Option<Type>),
    TraitData(Scope),
    FunctionData(FunctionData),
    StructData(Scope),
    Block(Scope),
    Module(Scope),
    #[default]
    Null
}

#[derive(Clone, Debug, Default)]
pub struct FunctionData {
    pub inputs: Vec<Symbol>,
    pub output: Type,
    pub body: Box<Option<Symbol>>,
}

pub fn walk_tank(tank: Tank) -> Scope {
    let mut scope = Scope::default();

    for item in tank.items {
        scope.create_item_symbol(item.clone());
    }
    
    return scope;
}