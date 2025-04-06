use clap::Parser;
use lexer::Lexer;
use logex::log_fatal_error;
use std::fs;

pub mod lexer;
pub mod parser;
pub mod ast;
pub mod resolve;

fn main() {
    let mut emits = EmitType::Ast;
    // set up the better panic output
    human_panic::setup_panic!();

    let args = Args::parse();

    let input = args.input;
    let output = args.output;
    let emit = args.emit;
    match emit.as_str() {
        "ast" => {
            emits = EmitType::Ast
        },
        "ast-json" => {
            emits = EmitType::AstJson
        },
        _ => {
            log_fatal_error(format!("Unknown emit type: {}", emit).as_str());
        }
    }

    let code = fs::read_to_string(input.clone()).unwrap();
    let tokens = Lexer::new(code).tokenize().unwrap();
    let ast = parser::Parser::new(tokens).parse(input.clone()).unwrap();
    let symboltable = resolve::walk_tank(ast.clone());
    println!("{:#?}", symboltable);
    if emits == EmitType::Ast {
        let _ = fs::write(format!("{}.ast", output), format!("{:#?}", ast));
        return;
    }
    if emits == EmitType::AstJson {
        fs::write(format!("{}.ast", output), serde_json::to_string_pretty(&ast).unwrap()).unwrap();
    }
}

#[derive(PartialEq)]
enum EmitType {
    Ast,
    AstJson,
}

#[derive(Parser, Debug)]
#[command(version, about, long_about = None, author)]
pub struct Args {
    #[arg(short, long)]
    input: String,

    #[arg(short, long, default_value = "ast-json")]
    emit: String,

    #[arg(short, long, default_value = "output")]
    output: String,
}