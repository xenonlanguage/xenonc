parser grammar Xenon;

program: programMember*;
programMember:
    functionDeclaration
    | variableDeclaration
    | structDeclaration
    | traitDeclaration
    | useDeclaration
    | moduleDeclaration;

functionDeclaration:
    (PUBLICKW | PRIVATEKW | UNSAFEKW | SAFEKW | EXTERNKW | OVERRIDEKW | VIRTUALKW | ASYNCKW)*
    FNKW NAME
    OPENPAREN (parameter (COMMA parameter)*)? CLOSEPAREN
    (MINUS GREATERTHAN type)?
    (block | SEMICOLON);
parameter: NAME COLON type;
variableDeclaration:
    (PUBLICKW | PRIVATEKW | UNSAFEKW | SAFEKW | CONSTKW | EXTERNKW)*
    LETKW NAME
    (COLON type)?
    (EQUAL expression)?
    SEMICOLON;
structDeclaration:
    (PUBLICKW | PRIVATEKW | ABSTRACTKW | UNSAFEKW | SAFEKW)*
    STRUCTKW NAME
    (COLON path+)?
    OPENBRACE
        (functionDeclaration | variableDeclaration)*
    CLOSEBRACE;
traitDeclaration: (PUBLICKW | PRIVATEKW)? TRAITKW NAME (functionDeclaration | variableDeclaration)*;
useDeclaration: USEKW path;
moduleDeclaration: (PUBLICKW | PRIVATEKW)? MODULEKW NAME OPENBRACE moduleMember* CLOSEBRACE;

path: NAME (COLON COLON path)?;

block: OPENBRACE statement* CLOSEBRACE;

identifier: NAME (OPENPAREN (expression COMMA?)* CLOSEPAREN)? (DOT identifier)?;

statement:
    variableAssignment
    | variableDeclaration
    | functionCall
    | forLoop
    | ifStatement
    | loopStatement
    | switchStatement
    | unsafeBlock
    | whileLoop
    | returnStatement
    | continueStatement
    | breakStatement;

variableAssignment: identifier (PLUS | MINUS | STAR | SLASH | PERCENT)? EQUAL expression SEMICOLON;

forLoop: FORKW NAME INKW identifier statement;

functionCall: identifier SEMICOLON;

ifStatement: IFKW expression statement (ELSEKW statement)?;

loopStatement: LOOPKW statement;

switchStatement: SWITCHKW expression OPENBRACE case* CLOSEBRACE;

case: CASEKW expression block;

unsafeBlock: UNSAFEKW block;

whileLoop: WHILEKW expression statement;

returnStatement: RETURNKW (expression SEMICOLON)?;

continueStatement: CONTINUEKW;

breakStatement: BREAKKW;

moduleMember:
    variableDeclaration
    | functionDeclaration
    | moduleDeclaration
    | structDeclaration
    | traitDeclaration
    | useDeclaration;

type:
    pointerType
    | referenceType
    | tupleType
    | pathType
    | primativeType;

arrayType: type OPENBRACKET numberLiteral CLOSEBRACKET;
pointerType: STAR type;
referenceType: REFKW type;
tupleType: OPENPAREN (type COMMA?)* CLOSEPAREN;
pathType: path;
primativeType: I8KW
               |I16KW
               |I32KW
               |I64KW
               |U8KW
               |U16KW
               |U32KW
               |U64KW
               |F16KW
               |F32KW
               |F64KW
               |BOOLKW
               |CHARKW ;

expression:
    | orExpr;

literal:
    stringLiteral
    | numberLiteral
    | charLiteral
    | booleanLiteral;

stringLiteral: STRING;
charLiteral: CHAR;
numberLiteral: NUMBER;
booleanLiteral: TRUEKW | FALSEKW;

parentheses: OPENPAREN expression CLOSEPAREN;

orExpr: andExpr (OR OR andExpr)*;
andExpr: cmpExpr (AND AND cmpExpr)*;
cmpExpr: bitOrExpr ((EQUAL EQUAL | BANG EQUAL | LESSTHAN | LESSTHAN EQUAL | GREATERTHAN | GREATERTHAN EQUAL) bitOrExpr)*;
bitOrExpr: bitXorExpr (OR bitXorExpr)*;
bitXorExpr: bitAndExpr (CARAT bitAndExpr)*;
bitAndExpr: shiftExpr (AND shiftExpr)*;
shiftExpr: addExpr ((LESSTHAN LESSTHAN | GREATERTHAN GREATERTHAN) addExpr)*;
addExpr: mulExpr ((PLUS | MINUS) mulExpr)*;
mulExpr: castExpr ((STAR | SLASH | PERCENT) castExpr)*;
castExpr: unaryOperation (ASKW type)?;
unaryOperation: (PLUS | MINUS | BANG | AND | STAR)? primary;

primary:
    identifier
    | parentheses
    | literal;