use std::fmt::format;
use std::sync::Mutex;
use crate::ast::{Identifier, Item, Tank};
use crate::lexer::token::{Token, TokenKind};

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
    
    pub fn parse_item(&mut self) -> Result<Item, ParseError> {
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
        }
    }

    pub fn parse_modifiers(&mut self) -> Result<Vec<TokenKind>, crate::parser::ParseError> {
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