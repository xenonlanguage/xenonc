use token::{Token, TokenKind};
pub mod token;

/// An error from the lexer
#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct LexerError {
    pub message: String,
    pub line: usize,
    pub column: usize,
}

/// The lexer
#[derive(Clone, Debug, Default, PartialEq, PartialOrd)]
pub struct Lexer {
    /// The tokens
    pub tokens: Vec<Token>,
    /// The code being lexed
    pub source: Vec<char>,
    /// The current position in the code
    pub position: usize,
    /// The current line
    pub line: usize,
    /// The current column
    pub column: usize,
}
impl Lexer {
    /// Create a new instance of Lexer
    pub fn new(source: String) -> Self {
        Self {
            tokens: Vec::new(),
            source: source.chars().collect(),
            position: 0,
            line: 1,
            column: 1,
        }
    }

    /// Tokenize the input
    pub fn tokenize(&mut self) -> Result<Vec<Token>, LexerError> {
        let mut buffer = String::new();

        while self.peek(0).is_ok() {
            let mut token = Token::new();
            token.start_col = self.column;
            token.line = self.line;
            if self.peek(0)?.is_whitespace() {
                if self.peek(0)? == '\n' {
                    self.line += 1;
                    self.position += 1;
                    self.column = 1;
                } else {
                    self.consume()?;
                }
                continue;
            } else if self.peek(0)?.is_numeric() {
                buffer.push(self.consume()?);
                while self.peek(0)?.is_numeric() || self.peek(0)? == '.' {
                    buffer.push(self.consume()?);
                }
                token.kind = TokenKind::Number;
                token.value = buffer.clone();
                token.end_col = self.column;
                self.tokens.push(token);
                buffer.clear();
            } else if self.peek(0)? == '"' {
                self.consume()?;
                while self.peek(0)? != '"' {
                    buffer.push(self.consume()?);
                }
                self.consume()?;
                token.kind = TokenKind::String;
                token.value = buffer.clone();
                token.end_col = self.column;
                self.tokens.push(token);
                buffer.clear();
            } else if self.peek(0)? == '\'' {
                self.consume()?;
                token.value = self.consume()?.to_string();
                self.consume()?;
                token.kind = TokenKind::Char;
                token.end_col = self.column;
                self.tokens.push(token);
            } else if self.peek(0)?.is_alphabetic() {
                buffer.push(self.consume()?);
                while self.peek(0)?.is_alphanumeric() || self.peek(0)? == '_' {
                    buffer.push(self.consume()?);
                }
                token.kind = match buffer.as_str() {
                    "as" => TokenKind::AsKw,
                    "break" => TokenKind::BreakKw,
                    "const" => TokenKind::ConstKw,
                    "continue" => TokenKind::ContinueKw,
                    "else" => TokenKind::ElseKw,
                    "extern" => TokenKind::ExternKw,
                    "false" => TokenKind::FalseKw,
                    "true" => TokenKind::TrueKw,
                    "fn" => TokenKind::FnKw,
                    "for" => TokenKind::ForKw,
                    "if" => TokenKind::IfKw,
                    "in" => TokenKind::InKw,
                    "let" => TokenKind::LetKw,
                    "case" => TokenKind::CaseKw,
                    "loop" => TokenKind::LoopKw,
                    "switch" => TokenKind::SwitchKw,
                    "module" => TokenKind::ModuleKw,
                    "public" => TokenKind::PublicKw,
                    "private" => TokenKind::PrivateKw,
                    "internal" => TokenKind::InternalKw,
                    "ref" => TokenKind::RefKw,
                    "return" => TokenKind::ReturnKw,
                    "self" => TokenKind::SelfKw,
                    "import" => TokenKind::ImportKw,
                    "tank" => TokenKind::TankKw,
                    "enum" => TokenKind::EnumKw,
                    "struct" => TokenKind::StructKw,
                    "unsafe" => TokenKind::UnsafeKw,
                    "use" => TokenKind::UseKw,
                    "while" => TokenKind::WhileKw,
                    "async" => TokenKind::AsyncKw,
                    "await" => TokenKind::AwaitKw,
                    "dyn" => TokenKind::DynKw,
                    "abstract" => TokenKind::AbstractKw,
                    "override" => TokenKind::OverrideKw,
                    "virtual" => TokenKind::VirtualKw,
                    "safe" => TokenKind::SafeKw,
                    "trait" => TokenKind::TraitKw,
                    "i8" => TokenKind::I8Kw,
                    "i16" => TokenKind::I16Kw,
                    "i32" => TokenKind::I32Kw,
                    "i64" => TokenKind::I64Kw,
                    "u8" => TokenKind::U8Kw,
                    "u16" => TokenKind::U16Kw,
                    "u32" => TokenKind::U32Kw,
                    "u64" => TokenKind::U64Kw,
                    "f16" => TokenKind::F16Kw,
                    "f32" => TokenKind::F32Kw,
                    "f64" => TokenKind::F64Kw,
                    "bool" => TokenKind::BoolKw,
                    "char" => TokenKind::CharKw,
                    "void" => TokenKind::VoidKw,
                    _ => TokenKind::Name,
                };
                token.value = buffer.clone();
                token.end_col = self.column;
                self.tokens.push(token);
                buffer.clear();
            } else {
                buffer.push(self.consume()?);
                token.kind = match buffer.as_str() {
                    ";" => TokenKind::Semicolon,
                    "," => TokenKind::Comma,
                    "." => TokenKind::Dot,
                    "(" => TokenKind::OpenParen,
                    ")" => TokenKind::CloseParen,
                    "[" => TokenKind::OpenBracket,
                    "]" => TokenKind::CloseBracket,
                    "{" => TokenKind::OpenBrace,
                    "}" => TokenKind::CloseBrace,
                    "#" => TokenKind::Pound,
                    "?" => TokenKind::Question,
                    ":" => TokenKind::Colon,
                    "=" => TokenKind::Equal,
                    "!" => TokenKind::Bang,
                    "<" => TokenKind::LessThan,
                    ">" => TokenKind::GreaterThan,
                    "-" => TokenKind::Minus,
                    "^" => TokenKind::Carat,
                    "&" => TokenKind::And,
                    "|" => TokenKind::Or,
                    "+" => TokenKind::Plus,
                    "*" => TokenKind::Star,
                    "/" => TokenKind::Slash,
                    "%" => TokenKind::Percent,
                    _ => TokenKind::Unknown,
                };
                token.end_col = self.column;
                token.value = buffer.clone();
                self.tokens.push(token);
                buffer.clear();
            }
        }

        Ok(self.tokens.clone())
    }

    /// Generate a LexerError
    fn gen_error(&self, message: String) -> LexerError {
        LexerError {
            message,
            line: self.line,
            column: self.column,
        }
    }

    /// Peek at the next character
    fn peek(&self, offset: usize) -> Result<char, LexerError> {
        if self.position + offset >= self.source.len() {
            // File ended abruptly.
            Err(self.gen_error("Unexpected end of file".to_string()))
        } else {
            Ok(self.source[self.position + offset])
        }
    }

    /// Consume the next character
    fn consume(&mut self) -> Result<char, LexerError> {
        // Get the Result
        let res = self.peek(0);
        self.position += 1;
        self.column += 1;
        res
    }
}
