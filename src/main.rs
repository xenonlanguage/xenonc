use std::env::current_dir;
use std::fmt::format;
use std::fs;
use clap::builder::TypedValueParser;
use clap::Parser;
use logex::{log_error, log_fatal_error};
use xenon_lexer::lexer::Lexer;

fn main() {
    let mut emits = EmitType::AST;
    // setup the better panic output
    human_panic::setup_panic!();

    let args = Args::parse();

    let input = args.input;
    let output = args.output;
    let emit = args.emit;
    match emit.as_str() {
        "ast" => {
            emits = EmitType::AST
        },
        _ => {
            log_fatal_error(format!("Unknown emit type: {}", emit).as_str());
        }
    }

    let code = fs::read_to_string(input.clone()).unwrap();
    let tokens = Lexer::new(code).tokenize().unwrap();
    let mut ast = xenon_parser::parser::Parser::new(tokens).parse_program(input).unwrap();
    if emits == EmitType::AST {
        fs::write(format!("{}.ast", output), format!("{:#?}", ast)).unwrap();
        return;
    }


}

#[derive(PartialEq)]
enum EmitType {
    AST
}

#[derive(Parser, Debug)]
#[command(version, about, long_about = None, author)]
pub struct Args {
    #[arg(short, long)]
    input: String,

    #[arg(short, long, default_value = "ast")]
    emit: String,

    #[arg(short, long, default_value = "output")]
    output: String,
}