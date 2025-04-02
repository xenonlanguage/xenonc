// Generated from C:/Users/Liam Greenway/RustroverProjects/xenon/xenon_ast/Xenon.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Xenon extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUBLICKW=1, PRIVATEKW=2, UNSAFEKW=3, SAFEKW=4, EXTERNKW=5, OVERRIDEKW=6, 
		VIRTUALKW=7, ASYNCKW=8, FNKW=9, NAME=10, OPENPAREN=11, COMMA=12, CLOSEPAREN=13, 
		MINUS=14, GREATERTHAN=15, SEMICOLON=16, COLON=17, CONSTKW=18, LETKW=19, 
		EQUAL=20, ABSTRACTKW=21, STRUCTKW=22, OPENBRACE=23, CLOSEBRACE=24, TRAITKW=25, 
		USEKW=26, MODULEKW=27, DOT=28, PLUS=29, STAR=30, SLASH=31, PERCENT=32, 
		FORKW=33, INKW=34, IFKW=35, ELSEKW=36, LOOPKW=37, SWITCHKW=38, CASEKW=39, 
		WHILEKW=40, RETURNKW=41, CONTINUEKW=42, BREAKKW=43, OPENBRACKET=44, CLOSEBRACKET=45, 
		REFKW=46, I8KW=47, I16KW=48, I32KW=49, I64KW=50, U8KW=51, U16KW=52, U32KW=53, 
		U64KW=54, F16KW=55, F32KW=56, F64KW=57, BOOLKW=58, CHARKW=59, STRING=60, 
		CHAR=61, NUMBER=62, TRUEKW=63, FALSEKW=64, OR=65, AND=66, BANG=67, LESSTHAN=68, 
		CARAT=69, ASKW=70;
	public static final int
		RULE_program = 0, RULE_programMember = 1, RULE_functionDeclaration = 2, 
		RULE_parameter = 3, RULE_variableDeclaration = 4, RULE_structDeclaration = 5, 
		RULE_traitDeclaration = 6, RULE_useDeclaration = 7, RULE_moduleDeclaration = 8, 
		RULE_path = 9, RULE_block = 10, RULE_identifier = 11, RULE_statement = 12, 
		RULE_variableAssignment = 13, RULE_forLoop = 14, RULE_functionCall = 15, 
		RULE_ifStatement = 16, RULE_loopStatement = 17, RULE_switchStatement = 18, 
		RULE_case = 19, RULE_unsafeBlock = 20, RULE_whileLoop = 21, RULE_returnStatement = 22, 
		RULE_continueStatement = 23, RULE_breakStatement = 24, RULE_moduleMember = 25, 
		RULE_type = 26, RULE_arrayType = 27, RULE_pointerType = 28, RULE_referenceType = 29, 
		RULE_tupleType = 30, RULE_pathType = 31, RULE_primativeType = 32, RULE_expression = 33, 
		RULE_literal = 34, RULE_stringLiteral = 35, RULE_charLiteral = 36, RULE_numberLiteral = 37, 
		RULE_booleanLiteral = 38, RULE_arrayLiteral = 39, RULE_tupleLiteral = 40, 
		RULE_parentheses = 41, RULE_orExpr = 42, RULE_andExpr = 43, RULE_cmpExpr = 44, 
		RULE_bitOrExpr = 45, RULE_bitXorExpr = 46, RULE_bitAndExpr = 47, RULE_shiftExpr = 48, 
		RULE_addExpr = 49, RULE_mulExpr = 50, RULE_castExpr = 51, RULE_unaryOperation = 52, 
		RULE_primary = 53;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programMember", "functionDeclaration", "parameter", "variableDeclaration", 
			"structDeclaration", "traitDeclaration", "useDeclaration", "moduleDeclaration", 
			"path", "block", "identifier", "statement", "variableAssignment", "forLoop", 
			"functionCall", "ifStatement", "loopStatement", "switchStatement", "case", 
			"unsafeBlock", "whileLoop", "returnStatement", "continueStatement", "breakStatement", 
			"moduleMember", "type", "arrayType", "pointerType", "referenceType", 
			"tupleType", "pathType", "primativeType", "expression", "literal", "stringLiteral", 
			"charLiteral", "numberLiteral", "booleanLiteral", "arrayLiteral", "tupleLiteral", 
			"parentheses", "orExpr", "andExpr", "cmpExpr", "bitOrExpr", "bitXorExpr", 
			"bitAndExpr", "shiftExpr", "addExpr", "mulExpr", "castExpr", "unaryOperation", 
			"primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUBLICKW", "PRIVATEKW", "UNSAFEKW", "SAFEKW", "EXTERNKW", "OVERRIDEKW", 
			"VIRTUALKW", "ASYNCKW", "FNKW", "NAME", "OPENPAREN", "COMMA", "CLOSEPAREN", 
			"MINUS", "GREATERTHAN", "SEMICOLON", "COLON", "CONSTKW", "LETKW", "EQUAL", 
			"ABSTRACTKW", "STRUCTKW", "OPENBRACE", "CLOSEBRACE", "TRAITKW", "USEKW", 
			"MODULEKW", "DOT", "PLUS", "STAR", "SLASH", "PERCENT", "FORKW", "INKW", 
			"IFKW", "ELSEKW", "LOOPKW", "SWITCHKW", "CASEKW", "WHILEKW", "RETURNKW", 
			"CONTINUEKW", "BREAKKW", "OPENBRACKET", "CLOSEBRACKET", "REFKW", "I8KW", 
			"I16KW", "I32KW", "I64KW", "U8KW", "U16KW", "U32KW", "U64KW", "F16KW", 
			"F32KW", "F64KW", "BOOLKW", "CHARKW", "STRING", "CHAR", "NUMBER", "TRUEKW", 
			"FALSEKW", "OR", "AND", "BANG", "LESSTHAN", "CARAT", "ASKW"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Xenon.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Xenon(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<ProgramMemberContext> programMember() {
			return getRuleContexts(ProgramMemberContext.class);
		}
		public ProgramMemberContext programMember(int i) {
			return getRuleContext(ProgramMemberContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 241959934L) != 0)) {
				{
				{
				setState(108);
				programMember();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramMemberContext extends ParserRuleContext {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public TraitDeclarationContext traitDeclaration() {
			return getRuleContext(TraitDeclarationContext.class,0);
		}
		public UseDeclarationContext useDeclaration() {
			return getRuleContext(UseDeclarationContext.class,0);
		}
		public ModuleDeclarationContext moduleDeclaration() {
			return getRuleContext(ModuleDeclarationContext.class,0);
		}
		public ProgramMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterProgramMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitProgramMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitProgramMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramMemberContext programMember() throws RecognitionException {
		ProgramMemberContext _localctx = new ProgramMemberContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programMember);
		try {
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				functionDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				variableDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				structDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(117);
				traitDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
				useDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(119);
				moduleDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FNKW() { return getToken(Xenon.FNKW, 0); }
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public TerminalNode OPENPAREN() { return getToken(Xenon.OPENPAREN, 0); }
		public TerminalNode CLOSEPAREN() { return getToken(Xenon.CLOSEPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Xenon.SEMICOLON, 0); }
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(Xenon.MINUS, 0); }
		public TerminalNode GREATERTHAN() { return getToken(Xenon.GREATERTHAN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> PUBLICKW() { return getTokens(Xenon.PUBLICKW); }
		public TerminalNode PUBLICKW(int i) {
			return getToken(Xenon.PUBLICKW, i);
		}
		public List<TerminalNode> PRIVATEKW() { return getTokens(Xenon.PRIVATEKW); }
		public TerminalNode PRIVATEKW(int i) {
			return getToken(Xenon.PRIVATEKW, i);
		}
		public List<TerminalNode> UNSAFEKW() { return getTokens(Xenon.UNSAFEKW); }
		public TerminalNode UNSAFEKW(int i) {
			return getToken(Xenon.UNSAFEKW, i);
		}
		public List<TerminalNode> SAFEKW() { return getTokens(Xenon.SAFEKW); }
		public TerminalNode SAFEKW(int i) {
			return getToken(Xenon.SAFEKW, i);
		}
		public List<TerminalNode> EXTERNKW() { return getTokens(Xenon.EXTERNKW); }
		public TerminalNode EXTERNKW(int i) {
			return getToken(Xenon.EXTERNKW, i);
		}
		public List<TerminalNode> OVERRIDEKW() { return getTokens(Xenon.OVERRIDEKW); }
		public TerminalNode OVERRIDEKW(int i) {
			return getToken(Xenon.OVERRIDEKW, i);
		}
		public List<TerminalNode> VIRTUALKW() { return getTokens(Xenon.VIRTUALKW); }
		public TerminalNode VIRTUALKW(int i) {
			return getToken(Xenon.VIRTUALKW, i);
		}
		public List<TerminalNode> ASYNCKW() { return getTokens(Xenon.ASYNCKW); }
		public TerminalNode ASYNCKW(int i) {
			return getToken(Xenon.ASYNCKW, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Xenon.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Xenon.COMMA, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 510L) != 0)) {
				{
				{
				setState(122);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 510L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(FNKW);
			setState(129);
			match(NAME);
			setState(130);
			match(OPENPAREN);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(131);
				parameter();
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(132);
					match(COMMA);
					setState(133);
					parameter();
					}
					}
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(141);
			match(CLOSEPAREN);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(142);
				match(MINUS);
				setState(143);
				match(GREATERTHAN);
				setState(144);
				type();
				}
			}

			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENBRACE:
				{
				setState(147);
				block();
				}
				break;
			case SEMICOLON:
				{
				setState(148);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public TerminalNode COLON() { return getToken(Xenon.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(NAME);
			setState(152);
			match(COLON);
			setState(153);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode LETKW() { return getToken(Xenon.LETKW, 0); }
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public TerminalNode SEMICOLON() { return getToken(Xenon.SEMICOLON, 0); }
		public TerminalNode COLON() { return getToken(Xenon.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(Xenon.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> PUBLICKW() { return getTokens(Xenon.PUBLICKW); }
		public TerminalNode PUBLICKW(int i) {
			return getToken(Xenon.PUBLICKW, i);
		}
		public List<TerminalNode> PRIVATEKW() { return getTokens(Xenon.PRIVATEKW); }
		public TerminalNode PRIVATEKW(int i) {
			return getToken(Xenon.PRIVATEKW, i);
		}
		public List<TerminalNode> UNSAFEKW() { return getTokens(Xenon.UNSAFEKW); }
		public TerminalNode UNSAFEKW(int i) {
			return getToken(Xenon.UNSAFEKW, i);
		}
		public List<TerminalNode> SAFEKW() { return getTokens(Xenon.SAFEKW); }
		public TerminalNode SAFEKW(int i) {
			return getToken(Xenon.SAFEKW, i);
		}
		public List<TerminalNode> CONSTKW() { return getTokens(Xenon.CONSTKW); }
		public TerminalNode CONSTKW(int i) {
			return getToken(Xenon.CONSTKW, i);
		}
		public List<TerminalNode> EXTERNKW() { return getTokens(Xenon.EXTERNKW); }
		public TerminalNode EXTERNKW(int i) {
			return getToken(Xenon.EXTERNKW, i);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 262206L) != 0)) {
				{
				{
				setState(155);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 262206L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(161);
			match(LETKW);
			setState(162);
			match(NAME);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(163);
				match(COLON);
				setState(164);
				type();
				}
			}

			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(167);
				match(EQUAL);
				setState(168);
				expression();
				}
			}

			setState(171);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclarationContext extends ParserRuleContext {
		public TerminalNode STRUCTKW() { return getToken(Xenon.STRUCTKW, 0); }
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public TerminalNode OPENBRACE() { return getToken(Xenon.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(Xenon.CLOSEBRACE, 0); }
		public TerminalNode COLON() { return getToken(Xenon.COLON, 0); }
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> PUBLICKW() { return getTokens(Xenon.PUBLICKW); }
		public TerminalNode PUBLICKW(int i) {
			return getToken(Xenon.PUBLICKW, i);
		}
		public List<TerminalNode> PRIVATEKW() { return getTokens(Xenon.PRIVATEKW); }
		public TerminalNode PRIVATEKW(int i) {
			return getToken(Xenon.PRIVATEKW, i);
		}
		public List<TerminalNode> ABSTRACTKW() { return getTokens(Xenon.ABSTRACTKW); }
		public TerminalNode ABSTRACTKW(int i) {
			return getToken(Xenon.ABSTRACTKW, i);
		}
		public List<TerminalNode> UNSAFEKW() { return getTokens(Xenon.UNSAFEKW); }
		public TerminalNode UNSAFEKW(int i) {
			return getToken(Xenon.UNSAFEKW, i);
		}
		public List<TerminalNode> SAFEKW() { return getTokens(Xenon.SAFEKW); }
		public TerminalNode SAFEKW(int i) {
			return getToken(Xenon.SAFEKW, i);
		}
		public List<PathContext> path() {
			return getRuleContexts(PathContext.class);
		}
		public PathContext path(int i) {
			return getRuleContext(PathContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2097182L) != 0)) {
				{
				{
				setState(173);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2097182L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
			match(STRUCTKW);
			setState(180);
			match(NAME);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(181);
				match(COLON);
				setState(183); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(182);
					path();
					}
					}
					setState(185); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NAME );
				}
			}

			setState(189);
			match(OPENBRACE);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 787454L) != 0)) {
				{
				setState(192);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(190);
					functionDeclaration();
					}
					break;
				case 2:
					{
					setState(191);
					variableDeclaration();
					}
					break;
				}
				}
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(197);
			match(CLOSEBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitDeclarationContext extends ParserRuleContext {
		public TerminalNode TRAITKW() { return getToken(Xenon.TRAITKW, 0); }
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public TerminalNode PUBLICKW() { return getToken(Xenon.PUBLICKW, 0); }
		public TerminalNode PRIVATEKW() { return getToken(Xenon.PRIVATEKW, 0); }
		public TraitDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterTraitDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitTraitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitTraitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraitDeclarationContext traitDeclaration() throws RecognitionException {
		TraitDeclarationContext _localctx = new TraitDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_traitDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLICKW || _la==PRIVATEKW) {
				{
				setState(199);
				_la = _input.LA(1);
				if ( !(_la==PUBLICKW || _la==PRIVATEKW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(202);
			match(TRAITKW);
			setState(203);
			match(NAME);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(206);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						setState(204);
						functionDeclaration();
						}
						break;
					case 2:
						{
						setState(205);
						variableDeclaration();
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UseDeclarationContext extends ParserRuleContext {
		public TerminalNode USEKW() { return getToken(Xenon.USEKW, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public UseDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterUseDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitUseDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitUseDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UseDeclarationContext useDeclaration() throws RecognitionException {
		UseDeclarationContext _localctx = new UseDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_useDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(USEKW);
			setState(212);
			path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleDeclarationContext extends ParserRuleContext {
		public TerminalNode MODULEKW() { return getToken(Xenon.MODULEKW, 0); }
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public TerminalNode OPENBRACE() { return getToken(Xenon.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(Xenon.CLOSEBRACE, 0); }
		public List<ModuleMemberContext> moduleMember() {
			return getRuleContexts(ModuleMemberContext.class);
		}
		public ModuleMemberContext moduleMember(int i) {
			return getRuleContext(ModuleMemberContext.class,i);
		}
		public TerminalNode PUBLICKW() { return getToken(Xenon.PUBLICKW, 0); }
		public TerminalNode PRIVATEKW() { return getToken(Xenon.PRIVATEKW, 0); }
		public ModuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterModuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitModuleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitModuleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleDeclarationContext moduleDeclaration() throws RecognitionException {
		ModuleDeclarationContext _localctx = new ModuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_moduleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUBLICKW || _la==PRIVATEKW) {
				{
				setState(214);
				_la = _input.LA(1);
				if ( !(_la==PUBLICKW || _la==PRIVATEKW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(217);
			match(MODULEKW);
			setState(218);
			match(NAME);
			setState(219);
			match(OPENBRACE);
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 241959934L) != 0)) {
				{
				{
				setState(220);
				moduleMember();
				}
				}
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(226);
			match(CLOSEBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public List<TerminalNode> COLON() { return getTokens(Xenon.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(Xenon.COLON, i);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitPath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(NAME);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(229);
				match(COLON);
				setState(230);
				match(COLON);
				setState(231);
				path();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode OPENBRACE() { return getToken(Xenon.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(Xenon.CLOSEBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(OPENBRACE);
			setState(238);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16947941737534L) != 0)) {
				{
				{
				setState(235);
				statement();
				}
				}
				setState(240);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(241);
			match(CLOSEBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public TerminalNode OPENPAREN() { return getToken(Xenon.OPENPAREN, 0); }
		public TerminalNode CLOSEPAREN() { return getToken(Xenon.CLOSEPAREN, 0); }
		public TerminalNode DOT() { return getToken(Xenon.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Xenon.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Xenon.COMMA, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(NAME);
			setState(255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(244);
				match(OPENPAREN);
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 251075696407347219L) != 0)) {
					{
					{
					setState(245);
					expression();
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(246);
						match(COMMA);
						}
					}

					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(254);
				match(CLOSEPAREN);
				}
				break;
			}
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(257);
				match(DOT);
				setState(258);
				identifier();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VariableAssignmentContext variableAssignment() {
			return getRuleContext(VariableAssignmentContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public UnsafeBlockContext unsafeBlock() {
			return getRuleContext(UnsafeBlockContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				variableAssignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				variableDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(263);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				forLoop();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(265);
				ifStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(266);
				loopStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(267);
				switchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(268);
				unsafeBlock();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(269);
				whileLoop();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(270);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(271);
				continueStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(272);
				breakStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableAssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(Xenon.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Xenon.SEMICOLON, 0); }
		public TerminalNode PLUS() { return getToken(Xenon.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Xenon.MINUS, 0); }
		public TerminalNode STAR() { return getToken(Xenon.STAR, 0); }
		public TerminalNode SLASH() { return getToken(Xenon.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(Xenon.PERCENT, 0); }
		public VariableAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableAssignmentContext variableAssignment() throws RecognitionException {
		VariableAssignmentContext _localctx = new VariableAssignmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			identifier();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053080064L) != 0)) {
				{
				setState(276);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053080064L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(279);
			match(EQUAL);
			setState(280);
			expression();
			setState(281);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FORKW() { return getToken(Xenon.FORKW, 0); }
		public TerminalNode NAME() { return getToken(Xenon.NAME, 0); }
		public TerminalNode INKW() { return getToken(Xenon.INKW, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(FORKW);
			setState(284);
			match(NAME);
			setState(285);
			match(INKW);
			setState(286);
			identifier();
			setState(287);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Xenon.SEMICOLON, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			identifier();
			setState(290);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IFKW() { return getToken(Xenon.IFKW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSEKW() { return getToken(Xenon.ELSEKW, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(IFKW);
			setState(293);
			expression();
			setState(294);
			statement();
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(295);
				match(ELSEKW);
				setState(296);
				statement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopStatementContext extends ParserRuleContext {
		public TerminalNode LOOPKW() { return getToken(Xenon.LOOPKW, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_loopStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(LOOPKW);
			setState(300);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCHKW() { return getToken(Xenon.SWITCHKW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OPENBRACE() { return getToken(Xenon.OPENBRACE, 0); }
		public TerminalNode CLOSEBRACE() { return getToken(Xenon.CLOSEBRACE, 0); }
		public List<CaseContext> case_() {
			return getRuleContexts(CaseContext.class);
		}
		public CaseContext case_(int i) {
			return getRuleContext(CaseContext.class,i);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(SWITCHKW);
			setState(303);
			expression();
			setState(304);
			match(OPENBRACE);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASEKW) {
				{
				{
				setState(305);
				case_();
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
			match(CLOSEBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseContext extends ParserRuleContext {
		public TerminalNode CASEKW() { return getToken(Xenon.CASEKW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseContext case_() throws RecognitionException {
		CaseContext _localctx = new CaseContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(CASEKW);
			setState(314);
			expression();
			setState(315);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnsafeBlockContext extends ParserRuleContext {
		public TerminalNode UNSAFEKW() { return getToken(Xenon.UNSAFEKW, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public UnsafeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsafeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterUnsafeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitUnsafeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitUnsafeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnsafeBlockContext unsafeBlock() throws RecognitionException {
		UnsafeBlockContext _localctx = new UnsafeBlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unsafeBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(UNSAFEKW);
			setState(318);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILEKW() { return getToken(Xenon.WHILEKW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(WHILEKW);
			setState(321);
			expression();
			setState(322);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURNKW() { return getToken(Xenon.RETURNKW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Xenon.SEMICOLON, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(RETURNKW);
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(325);
				expression();
				setState(326);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode CONTINUEKW() { return getToken(Xenon.CONTINUEKW, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(CONTINUEKW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode BREAKKW() { return getToken(Xenon.BREAKKW, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(BREAKKW);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleMemberContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ModuleDeclarationContext moduleDeclaration() {
			return getRuleContext(ModuleDeclarationContext.class,0);
		}
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public TraitDeclarationContext traitDeclaration() {
			return getRuleContext(TraitDeclarationContext.class,0);
		}
		public UseDeclarationContext useDeclaration() {
			return getRuleContext(UseDeclarationContext.class,0);
		}
		public ModuleMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterModuleMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitModuleMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitModuleMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModuleMemberContext moduleMember() throws RecognitionException {
		ModuleMemberContext _localctx = new ModuleMemberContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_moduleMember);
		try {
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(335);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(336);
				moduleDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
				structDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(338);
				traitDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(339);
				useDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public PointerTypeContext pointerType() {
			return getRuleContext(PointerTypeContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TupleTypeContext tupleType() {
			return getRuleContext(TupleTypeContext.class,0);
		}
		public PathTypeContext pathType() {
			return getRuleContext(PathTypeContext.class,0);
		}
		public PrimativeTypeContext primativeType() {
			return getRuleContext(PrimativeTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_type);
		try {
			setState(347);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				pointerType();
				}
				break;
			case REFKW:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				referenceType();
				}
				break;
			case OPENPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				tupleType();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 4);
				{
				setState(345);
				pathType();
				}
				break;
			case I8KW:
			case I16KW:
			case I32KW:
			case I64KW:
			case U8KW:
			case U16KW:
			case U32KW:
			case U64KW:
			case F16KW:
			case F32KW:
			case F64KW:
			case BOOLKW:
			case CHARKW:
				enterOuterAlt(_localctx, 5);
				{
				setState(346);
				primativeType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OPENBRACKET() { return getToken(Xenon.OPENBRACKET, 0); }
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(Xenon.CLOSEBRACKET, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			type();
			setState(350);
			match(OPENBRACKET);
			setState(351);
			numberLiteral();
			setState(352);
			match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerTypeContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(Xenon.STAR, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PointerTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterPointerType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitPointerType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitPointerType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerTypeContext pointerType() throws RecognitionException {
		PointerTypeContext _localctx = new PointerTypeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_pointerType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(STAR);
			setState(355);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReferenceTypeContext extends ParserRuleContext {
		public TerminalNode REFKW() { return getToken(Xenon.REFKW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitReferenceType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitReferenceType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_referenceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(REFKW);
			setState(358);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleTypeContext extends ParserRuleContext {
		public TerminalNode OPENPAREN() { return getToken(Xenon.OPENPAREN, 0); }
		public TerminalNode CLOSEPAREN() { return getToken(Xenon.CLOSEPAREN, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Xenon.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Xenon.COMMA, i);
		}
		public TupleTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterTupleType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitTupleType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitTupleType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleTypeContext tupleType() throws RecognitionException {
		TupleTypeContext _localctx = new TupleTypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_tupleType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(OPENPAREN);
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152851136936414208L) != 0)) {
				{
				{
				setState(361);
				type();
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(362);
					match(COMMA);
					}
				}

				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(370);
			match(CLOSEPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PathTypeContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public PathTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterPathType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitPathType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitPathType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathTypeContext pathType() throws RecognitionException {
		PathTypeContext _localctx = new PathTypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pathType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimativeTypeContext extends ParserRuleContext {
		public TerminalNode I8KW() { return getToken(Xenon.I8KW, 0); }
		public TerminalNode I16KW() { return getToken(Xenon.I16KW, 0); }
		public TerminalNode I32KW() { return getToken(Xenon.I32KW, 0); }
		public TerminalNode I64KW() { return getToken(Xenon.I64KW, 0); }
		public TerminalNode U8KW() { return getToken(Xenon.U8KW, 0); }
		public TerminalNode U16KW() { return getToken(Xenon.U16KW, 0); }
		public TerminalNode U32KW() { return getToken(Xenon.U32KW, 0); }
		public TerminalNode U64KW() { return getToken(Xenon.U64KW, 0); }
		public TerminalNode F16KW() { return getToken(Xenon.F16KW, 0); }
		public TerminalNode F32KW() { return getToken(Xenon.F32KW, 0); }
		public TerminalNode F64KW() { return getToken(Xenon.F64KW, 0); }
		public TerminalNode BOOLKW() { return getToken(Xenon.BOOLKW, 0); }
		public TerminalNode CHARKW() { return getToken(Xenon.CHARKW, 0); }
		public PrimativeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primativeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterPrimativeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitPrimativeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitPrimativeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimativeTypeContext primativeType() throws RecognitionException {
		PrimativeTypeContext _localctx = new PrimativeTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_primativeType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1152780767118491648L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public UnaryOperationContext unaryOperation() {
			return getRuleContext(UnaryOperationContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_expression);
		try {
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				parentheses();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				orExpr();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
				unaryOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(380);
				literal();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(381);
				identifier();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
		}
		public CharLiteralContext charLiteral() {
			return getRuleContext(CharLiteralContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public ArrayLiteralContext arrayLiteral() {
			return getRuleContext(ArrayLiteralContext.class,0);
		}
		public TupleLiteralContext tupleLiteral() {
			return getRuleContext(TupleLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_literal);
		try {
			setState(390);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(384);
				stringLiteral();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 2);
				{
				setState(385);
				numberLiteral();
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(386);
				charLiteral();
				}
				break;
			case TRUEKW:
			case FALSEKW:
				enterOuterAlt(_localctx, 4);
				{
				setState(387);
				booleanLiteral();
				}
				break;
			case OPENBRACKET:
				enterOuterAlt(_localctx, 5);
				{
				setState(388);
				arrayLiteral();
				}
				break;
			case OPENPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(389);
				tupleLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Xenon.STRING, 0); }
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CharLiteralContext extends ParserRuleContext {
		public TerminalNode CHAR() { return getToken(Xenon.CHAR, 0); }
		public CharLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterCharLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitCharLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitCharLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CharLiteralContext charLiteral() throws RecognitionException {
		CharLiteralContext _localctx = new CharLiteralContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_charLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(CHAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(Xenon.NUMBER, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_numberLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends ParserRuleContext {
		public TerminalNode TRUEKW() { return getToken(Xenon.TRUEKW, 0); }
		public TerminalNode FALSEKW() { return getToken(Xenon.FALSEKW, 0); }
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_la = _input.LA(1);
			if ( !(_la==TRUEKW || _la==FALSEKW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralContext extends ParserRuleContext {
		public TerminalNode OPENBRACKET() { return getToken(Xenon.OPENBRACKET, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(Xenon.CLOSEBRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Xenon.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Xenon.COMMA, i);
		}
		public ArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayLiteralContext arrayLiteral() throws RecognitionException {
		ArrayLiteralContext _localctx = new ArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_arrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(OPENBRACKET);
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 251075696407347219L) != 0)) {
				{
				{
				setState(401);
				expression();
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(402);
					match(COMMA);
					}
				}

				}
				}
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(410);
			match(CLOSEBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleLiteralContext extends ParserRuleContext {
		public TerminalNode OPENPAREN() { return getToken(Xenon.OPENPAREN, 0); }
		public TerminalNode CLOSEPAREN() { return getToken(Xenon.CLOSEPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Xenon.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Xenon.COMMA, i);
		}
		public TupleLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tupleLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterTupleLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitTupleLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitTupleLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleLiteralContext tupleLiteral() throws RecognitionException {
		TupleLiteralContext _localctx = new TupleLiteralContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_tupleLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(OPENPAREN);
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 251075696407347219L) != 0)) {
				{
				{
				setState(413);
				expression();
				setState(415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(414);
					match(COMMA);
					}
				}

				}
				}
				setState(421);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(422);
			match(CLOSEPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends ParserRuleContext {
		public TerminalNode OPENPAREN() { return getToken(Xenon.OPENPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSEPAREN() { return getToken(Xenon.CLOSEPAREN, 0); }
		public ParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesesContext parentheses() throws RecognitionException {
		ParenthesesContext _localctx = new ParenthesesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_parentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(OPENPAREN);
			setState(425);
			expression();
			setState(426);
			match(CLOSEPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ParserRuleContext {
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(Xenon.OR); }
		public TerminalNode OR(int i) {
			return getToken(Xenon.OR, i);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_orExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			andExpr();
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(429);
				match(OR);
				setState(430);
				match(OR);
				setState(431);
				andExpr();
				}
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ParserRuleContext {
		public List<CmpExprContext> cmpExpr() {
			return getRuleContexts(CmpExprContext.class);
		}
		public CmpExprContext cmpExpr(int i) {
			return getRuleContext(CmpExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(Xenon.AND); }
		public TerminalNode AND(int i) {
			return getToken(Xenon.AND, i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_andExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			cmpExpr();
			setState(443);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(438);
					match(AND);
					setState(439);
					match(AND);
					setState(440);
					cmpExpr();
					}
					} 
				}
				setState(445);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmpExprContext extends ParserRuleContext {
		public List<BitOrExprContext> bitOrExpr() {
			return getRuleContexts(BitOrExprContext.class);
		}
		public BitOrExprContext bitOrExpr(int i) {
			return getRuleContext(BitOrExprContext.class,i);
		}
		public List<TerminalNode> EQUAL() { return getTokens(Xenon.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(Xenon.EQUAL, i);
		}
		public List<TerminalNode> BANG() { return getTokens(Xenon.BANG); }
		public TerminalNode BANG(int i) {
			return getToken(Xenon.BANG, i);
		}
		public List<TerminalNode> LESSTHAN() { return getTokens(Xenon.LESSTHAN); }
		public TerminalNode LESSTHAN(int i) {
			return getToken(Xenon.LESSTHAN, i);
		}
		public List<TerminalNode> GREATERTHAN() { return getTokens(Xenon.GREATERTHAN); }
		public TerminalNode GREATERTHAN(int i) {
			return getToken(Xenon.GREATERTHAN, i);
		}
		public CmpExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterCmpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitCmpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitCmpExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmpExprContext cmpExpr() throws RecognitionException {
		CmpExprContext _localctx = new CmpExprContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_cmpExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			bitOrExpr();
			setState(462);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(457);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						setState(447);
						match(EQUAL);
						setState(448);
						match(EQUAL);
						}
						break;
					case 2:
						{
						setState(449);
						match(BANG);
						setState(450);
						match(EQUAL);
						}
						break;
					case 3:
						{
						setState(451);
						match(LESSTHAN);
						}
						break;
					case 4:
						{
						setState(452);
						match(LESSTHAN);
						setState(453);
						match(EQUAL);
						}
						break;
					case 5:
						{
						setState(454);
						match(GREATERTHAN);
						}
						break;
					case 6:
						{
						setState(455);
						match(GREATERTHAN);
						setState(456);
						match(EQUAL);
						}
						break;
					}
					setState(459);
					bitOrExpr();
					}
					} 
				}
				setState(464);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitOrExprContext extends ParserRuleContext {
		public List<BitXorExprContext> bitXorExpr() {
			return getRuleContexts(BitXorExprContext.class);
		}
		public BitXorExprContext bitXorExpr(int i) {
			return getRuleContext(BitXorExprContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(Xenon.OR); }
		public TerminalNode OR(int i) {
			return getToken(Xenon.OR, i);
		}
		public BitOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterBitOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitBitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitBitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitOrExprContext bitOrExpr() throws RecognitionException {
		BitOrExprContext _localctx = new BitOrExprContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_bitOrExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			bitXorExpr();
			setState(470);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(466);
					match(OR);
					setState(467);
					bitXorExpr();
					}
					} 
				}
				setState(472);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitXorExprContext extends ParserRuleContext {
		public List<BitAndExprContext> bitAndExpr() {
			return getRuleContexts(BitAndExprContext.class);
		}
		public BitAndExprContext bitAndExpr(int i) {
			return getRuleContext(BitAndExprContext.class,i);
		}
		public List<TerminalNode> CARAT() { return getTokens(Xenon.CARAT); }
		public TerminalNode CARAT(int i) {
			return getToken(Xenon.CARAT, i);
		}
		public BitXorExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitXorExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterBitXorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitBitXorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitBitXorExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitXorExprContext bitXorExpr() throws RecognitionException {
		BitXorExprContext _localctx = new BitXorExprContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_bitXorExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			bitAndExpr();
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CARAT) {
				{
				{
				setState(474);
				match(CARAT);
				setState(475);
				bitAndExpr();
				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BitAndExprContext extends ParserRuleContext {
		public List<ShiftExprContext> shiftExpr() {
			return getRuleContexts(ShiftExprContext.class);
		}
		public ShiftExprContext shiftExpr(int i) {
			return getRuleContext(ShiftExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(Xenon.AND); }
		public TerminalNode AND(int i) {
			return getToken(Xenon.AND, i);
		}
		public BitAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterBitAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitBitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitBitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BitAndExprContext bitAndExpr() throws RecognitionException {
		BitAndExprContext _localctx = new BitAndExprContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_bitAndExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(481);
			shiftExpr();
			setState(486);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(482);
					match(AND);
					setState(483);
					shiftExpr();
					}
					} 
				}
				setState(488);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ShiftExprContext extends ParserRuleContext {
		public List<AddExprContext> addExpr() {
			return getRuleContexts(AddExprContext.class);
		}
		public AddExprContext addExpr(int i) {
			return getRuleContext(AddExprContext.class,i);
		}
		public List<TerminalNode> LESSTHAN() { return getTokens(Xenon.LESSTHAN); }
		public TerminalNode LESSTHAN(int i) {
			return getToken(Xenon.LESSTHAN, i);
		}
		public List<TerminalNode> GREATERTHAN() { return getTokens(Xenon.GREATERTHAN); }
		public TerminalNode GREATERTHAN(int i) {
			return getToken(Xenon.GREATERTHAN, i);
		}
		public ShiftExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterShiftExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitShiftExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitShiftExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExprContext shiftExpr() throws RecognitionException {
		ShiftExprContext _localctx = new ShiftExprContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_shiftExpr);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			addExpr();
			setState(499);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(494);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case LESSTHAN:
						{
						setState(490);
						match(LESSTHAN);
						setState(491);
						match(LESSTHAN);
						}
						break;
					case GREATERTHAN:
						{
						setState(492);
						match(GREATERTHAN);
						setState(493);
						match(GREATERTHAN);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(496);
					addExpr();
					}
					} 
				}
				setState(501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends ParserRuleContext {
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(Xenon.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(Xenon.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(Xenon.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(Xenon.MINUS, i);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_addExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			mulExpr();
			setState(507);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(503);
					_la = _input.LA(1);
					if ( !(_la==MINUS || _la==PLUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(504);
					mulExpr();
					}
					} 
				}
				setState(509);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulExprContext extends ParserRuleContext {
		public List<CastExprContext> castExpr() {
			return getRuleContexts(CastExprContext.class);
		}
		public CastExprContext castExpr(int i) {
			return getRuleContext(CastExprContext.class,i);
		}
		public List<TerminalNode> STAR() { return getTokens(Xenon.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(Xenon.STAR, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(Xenon.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(Xenon.SLASH, i);
		}
		public List<TerminalNode> PERCENT() { return getTokens(Xenon.PERCENT); }
		public TerminalNode PERCENT(int i) {
			return getToken(Xenon.PERCENT, i);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitMulExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitMulExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_mulExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			castExpr();
			setState(515);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(511);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7516192768L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(512);
					castExpr();
					}
					} 
				}
				setState(517);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastExprContext extends ParserRuleContext {
		public UnaryOperationContext unaryOperation() {
			return getRuleContext(UnaryOperationContext.class,0);
		}
		public TerminalNode ASKW() { return getToken(Xenon.ASKW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public CastExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterCastExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitCastExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitCastExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CastExprContext castExpr() throws RecognitionException {
		CastExprContext _localctx = new CastExprContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_castExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(518);
			unaryOperation();
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASKW) {
				{
				setState(519);
				match(ASKW);
				setState(520);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperationContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(Xenon.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Xenon.MINUS, 0); }
		public TerminalNode BANG() { return getToken(Xenon.BANG, 0); }
		public TerminalNode AND() { return getToken(Xenon.AND, 0); }
		public TerminalNode STAR() { return getToken(Xenon.STAR, 0); }
		public UnaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterUnaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitUnaryOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitUnaryOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOperationContext unaryOperation() throws RecognitionException {
		UnaryOperationContext _localctx = new UnaryOperationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_unaryOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 13510798882209793L) != 0)) {
				{
				setState(523);
				_la = _input.LA(1);
				if ( !(((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 13510798882209793L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(526);
			primary();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode OPENPAREN() { return getToken(Xenon.OPENPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSEPAREN() { return getToken(Xenon.CLOSEPAREN, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XenonListener ) ((XenonListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XenonVisitor ) return ((XenonVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_primary);
		try {
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(528);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(529);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(530);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(531);
				match(OPENPAREN);
				setState(532);
				expression();
				setState(533);
				match(CLOSEPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001F\u021a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u0001\u0000\u0005\u0000"+
		"n\b\u0000\n\u0000\f\u0000q\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001y\b\u0001\u0001\u0002"+
		"\u0005\u0002|\b\u0002\n\u0002\f\u0002\u007f\t\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002\u0087"+
		"\b\u0002\n\u0002\f\u0002\u008a\t\u0002\u0003\u0002\u008c\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0092\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u0096\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0005\u0004\u009d\b\u0004\n\u0004\f\u0004"+
		"\u00a0\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"\u00a6\b\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00aa\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0005\u0005\u00af\b\u0005\n\u0005\f\u0005"+
		"\u00b2\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004\u0005"+
		"\u00b8\b\u0005\u000b\u0005\f\u0005\u00b9\u0003\u0005\u00bc\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00c1\b\u0005\n\u0005\f\u0005"+
		"\u00c4\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0003\u0006\u00c9\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00cf"+
		"\b\u0006\n\u0006\f\u0006\u00d2\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0003\b\u00d8\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u00de"+
		"\b\b\n\b\f\b\u00e1\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0003\t\u00e9\b\t\u0001\n\u0001\n\u0005\n\u00ed\b\n\n\n\f\n\u00f0\t\n"+
		"\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00f8\b\u000b\u0005\u000b\u00fa\b\u000b\n\u000b\f\u000b\u00fd\t"+
		"\u000b\u0001\u000b\u0003\u000b\u0100\b\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0104\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0112\b\f\u0001\r\u0001"+
		"\r\u0003\r\u0116\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u012a\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0133\b\u0012\n"+
		"\u0012\f\u0012\u0136\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u0149\b\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u0155\b\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u015c\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u016c\b\u001e\u0005\u001e\u016e\b\u001e\n\u001e\f\u001e"+
		"\u0171\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u017f\b!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u0187\b\"\u0001#\u0001"+
		"#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0003"+
		"\'\u0194\b\'\u0005\'\u0196\b\'\n\'\f\'\u0199\t\'\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0003(\u01a0\b(\u0005(\u01a2\b(\n(\f(\u01a5\t(\u0001("+
		"\u0001(\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001*\u0005"+
		"*\u01b1\b*\n*\f*\u01b4\t*\u0001+\u0001+\u0001+\u0001+\u0005+\u01ba\b+"+
		"\n+\f+\u01bd\t+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0003,\u01ca\b,\u0001,\u0005,\u01cd\b,\n,\f,\u01d0"+
		"\t,\u0001-\u0001-\u0001-\u0005-\u01d5\b-\n-\f-\u01d8\t-\u0001.\u0001."+
		"\u0001.\u0005.\u01dd\b.\n.\f.\u01e0\t.\u0001/\u0001/\u0001/\u0005/\u01e5"+
		"\b/\n/\f/\u01e8\t/\u00010\u00010\u00010\u00010\u00010\u00030\u01ef\b0"+
		"\u00010\u00050\u01f2\b0\n0\f0\u01f5\t0\u00011\u00011\u00011\u00051\u01fa"+
		"\b1\n1\f1\u01fd\t1\u00012\u00012\u00012\u00052\u0202\b2\n2\f2\u0205\t"+
		"2\u00013\u00013\u00013\u00033\u020a\b3\u00014\u00034\u020d\b4\u00014\u0001"+
		"4\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00035\u0218\b5\u0001"+
		"5\u0000\u00006\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhj\u0000"+
		"\n\u0001\u0000\u0001\b\u0002\u0000\u0001\u0005\u0012\u0012\u0002\u0000"+
		"\u0001\u0004\u0015\u0015\u0001\u0000\u0001\u0002\u0002\u0000\u000e\u000e"+
		"\u001d \u0001\u0000/;\u0001\u0000?@\u0002\u0000\u000e\u000e\u001d\u001d"+
		"\u0001\u0000\u001e \u0003\u0000\u000e\u000e\u001d\u001eBC\u023d\u0000"+
		"o\u0001\u0000\u0000\u0000\u0002x\u0001\u0000\u0000\u0000\u0004}\u0001"+
		"\u0000\u0000\u0000\u0006\u0097\u0001\u0000\u0000\u0000\b\u009e\u0001\u0000"+
		"\u0000\u0000\n\u00b0\u0001\u0000\u0000\u0000\f\u00c8\u0001\u0000\u0000"+
		"\u0000\u000e\u00d3\u0001\u0000\u0000\u0000\u0010\u00d7\u0001\u0000\u0000"+
		"\u0000\u0012\u00e4\u0001\u0000\u0000\u0000\u0014\u00ea\u0001\u0000\u0000"+
		"\u0000\u0016\u00f3\u0001\u0000\u0000\u0000\u0018\u0111\u0001\u0000\u0000"+
		"\u0000\u001a\u0113\u0001\u0000\u0000\u0000\u001c\u011b\u0001\u0000\u0000"+
		"\u0000\u001e\u0121\u0001\u0000\u0000\u0000 \u0124\u0001\u0000\u0000\u0000"+
		"\"\u012b\u0001\u0000\u0000\u0000$\u012e\u0001\u0000\u0000\u0000&\u0139"+
		"\u0001\u0000\u0000\u0000(\u013d\u0001\u0000\u0000\u0000*\u0140\u0001\u0000"+
		"\u0000\u0000,\u0144\u0001\u0000\u0000\u0000.\u014a\u0001\u0000\u0000\u0000"+
		"0\u014c\u0001\u0000\u0000\u00002\u0154\u0001\u0000\u0000\u00004\u015b"+
		"\u0001\u0000\u0000\u00006\u015d\u0001\u0000\u0000\u00008\u0162\u0001\u0000"+
		"\u0000\u0000:\u0165\u0001\u0000\u0000\u0000<\u0168\u0001\u0000\u0000\u0000"+
		">\u0174\u0001\u0000\u0000\u0000@\u0176\u0001\u0000\u0000\u0000B\u017e"+
		"\u0001\u0000\u0000\u0000D\u0186\u0001\u0000\u0000\u0000F\u0188\u0001\u0000"+
		"\u0000\u0000H\u018a\u0001\u0000\u0000\u0000J\u018c\u0001\u0000\u0000\u0000"+
		"L\u018e\u0001\u0000\u0000\u0000N\u0190\u0001\u0000\u0000\u0000P\u019c"+
		"\u0001\u0000\u0000\u0000R\u01a8\u0001\u0000\u0000\u0000T\u01ac\u0001\u0000"+
		"\u0000\u0000V\u01b5\u0001\u0000\u0000\u0000X\u01be\u0001\u0000\u0000\u0000"+
		"Z\u01d1\u0001\u0000\u0000\u0000\\\u01d9\u0001\u0000\u0000\u0000^\u01e1"+
		"\u0001\u0000\u0000\u0000`\u01e9\u0001\u0000\u0000\u0000b\u01f6\u0001\u0000"+
		"\u0000\u0000d\u01fe\u0001\u0000\u0000\u0000f\u0206\u0001\u0000\u0000\u0000"+
		"h\u020c\u0001\u0000\u0000\u0000j\u0217\u0001\u0000\u0000\u0000ln\u0003"+
		"\u0002\u0001\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000"+
		"om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\u0001\u0001\u0000"+
		"\u0000\u0000qo\u0001\u0000\u0000\u0000ry\u0003\u0004\u0002\u0000sy\u0003"+
		"\b\u0004\u0000ty\u0003\n\u0005\u0000uy\u0003\f\u0006\u0000vy\u0003\u000e"+
		"\u0007\u0000wy\u0003\u0010\b\u0000xr\u0001\u0000\u0000\u0000xs\u0001\u0000"+
		"\u0000\u0000xt\u0001\u0000\u0000\u0000xu\u0001\u0000\u0000\u0000xv\u0001"+
		"\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y\u0003\u0001\u0000\u0000"+
		"\u0000z|\u0007\u0000\u0000\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001"+
		"\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u0080\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005\t\u0000\u0000\u0081\u0082\u0005\n\u0000\u0000\u0082\u008b\u0005"+
		"\u000b\u0000\u0000\u0083\u0088\u0003\u0006\u0003\u0000\u0084\u0085\u0005"+
		"\f\u0000\u0000\u0085\u0087\u0003\u0006\u0003\u0000\u0086\u0084\u0001\u0000"+
		"\u0000\u0000\u0087\u008a\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000"+
		"\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u0083\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000"+
		"\u0000\u0000\u008d\u0091\u0005\r\u0000\u0000\u008e\u008f\u0005\u000e\u0000"+
		"\u0000\u008f\u0090\u0005\u000f\u0000\u0000\u0090\u0092\u00034\u001a\u0000"+
		"\u0091\u008e\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0096\u0003\u0014\n\u0000\u0094"+
		"\u0096\u0005\u0010\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0094\u0001\u0000\u0000\u0000\u0096\u0005\u0001\u0000\u0000\u0000\u0097"+
		"\u0098\u0005\n\u0000\u0000\u0098\u0099\u0005\u0011\u0000\u0000\u0099\u009a"+
		"\u00034\u001a\u0000\u009a\u0007\u0001\u0000\u0000\u0000\u009b\u009d\u0007"+
		"\u0001\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u00a0\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0005\u0013\u0000\u0000\u00a2\u00a5\u0005"+
		"\n\u0000\u0000\u00a3\u00a4\u0005\u0011\u0000\u0000\u00a4\u00a6\u00034"+
		"\u001a\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0014"+
		"\u0000\u0000\u00a8\u00aa\u0003B!\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00ac\u0005\u0010\u0000\u0000\u00ac\t\u0001\u0000\u0000\u0000\u00ad"+
		"\u00af\u0007\u0002\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b0"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u0016\u0000\u0000\u00b4"+
		"\u00bb\u0005\n\u0000\u0000\u00b5\u00b7\u0005\u0011\u0000\u0000\u00b6\u00b8"+
		"\u0003\u0012\t\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b5\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001"+
		"\u0000\u0000\u0000\u00bd\u00c2\u0005\u0017\u0000\u0000\u00be\u00c1\u0003"+
		"\u0004\u0002\u0000\u00bf\u00c1\u0003\b\u0004\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0005\u0018\u0000\u0000\u00c6\u000b\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c9\u0007\u0003\u0000\u0000\u00c8\u00c7\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0005\u0019\u0000\u0000\u00cb\u00d0\u0005\n\u0000"+
		"\u0000\u00cc\u00cf\u0003\u0004\u0002\u0000\u00cd\u00cf\u0003\b\u0004\u0000"+
		"\u00ce\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\r\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u001a\u0000\u0000\u00d4"+
		"\u00d5\u0003\u0012\t\u0000\u00d5\u000f\u0001\u0000\u0000\u0000\u00d6\u00d8"+
		"\u0007\u0003\u0000\u0000\u00d7\u00d6\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da"+
		"\u0005\u001b\u0000\u0000\u00da\u00db\u0005\n\u0000\u0000\u00db\u00df\u0005"+
		"\u0017\u0000\u0000\u00dc\u00de\u00032\u0019\u0000\u00dd\u00dc\u0001\u0000"+
		"\u0000\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000"+
		"\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e1\u00df\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0018"+
		"\u0000\u0000\u00e3\u0011\u0001\u0000\u0000\u0000\u00e4\u00e8\u0005\n\u0000"+
		"\u0000\u00e5\u00e6\u0005\u0011\u0000\u0000\u00e6\u00e7\u0005\u0011\u0000"+
		"\u0000\u00e7\u00e9\u0003\u0012\t\u0000\u00e8\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u0013\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ee\u0005\u0017\u0000\u0000\u00eb\u00ed\u0003\u0018\f\u0000\u00ec"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f2\u0005\u0018\u0000\u0000\u00f2\u0015\u0001\u0000\u0000\u0000\u00f3"+
		"\u00ff\u0005\n\u0000\u0000\u00f4\u00fb\u0005\u000b\u0000\u0000\u00f5\u00f7"+
		"\u0003B!\u0000\u00f6\u00f8\u0005\f\u0000\u0000\u00f7\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fa\u0001\u0000"+
		"\u0000\u0000\u00f9\u00f5\u0001\u0000\u0000\u0000\u00fa\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fe\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fe\u0100\u0005\r\u0000\u0000\u00ff\u00f4\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0005\u001c\u0000\u0000\u0102\u0104\u0003\u0016\u000b"+
		"\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000"+
		"\u0000\u0104\u0017\u0001\u0000\u0000\u0000\u0105\u0112\u0003\u001a\r\u0000"+
		"\u0106\u0112\u0003\b\u0004\u0000\u0107\u0112\u0003\u001e\u000f\u0000\u0108"+
		"\u0112\u0003\u001c\u000e\u0000\u0109\u0112\u0003 \u0010\u0000\u010a\u0112"+
		"\u0003\"\u0011\u0000\u010b\u0112\u0003$\u0012\u0000\u010c\u0112\u0003"+
		"(\u0014\u0000\u010d\u0112\u0003*\u0015\u0000\u010e\u0112\u0003,\u0016"+
		"\u0000\u010f\u0112\u0003.\u0017\u0000\u0110\u0112\u00030\u0018\u0000\u0111"+
		"\u0105\u0001\u0000\u0000\u0000\u0111\u0106\u0001\u0000\u0000\u0000\u0111"+
		"\u0107\u0001\u0000\u0000\u0000\u0111\u0108\u0001\u0000\u0000\u0000\u0111"+
		"\u0109\u0001\u0000\u0000\u0000\u0111\u010a\u0001\u0000\u0000\u0000\u0111"+
		"\u010b\u0001\u0000\u0000\u0000\u0111\u010c\u0001\u0000\u0000\u0000\u0111"+
		"\u010d\u0001\u0000\u0000\u0000\u0111\u010e\u0001\u0000\u0000\u0000\u0111"+
		"\u010f\u0001\u0000\u0000\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0112"+
		"\u0019\u0001\u0000\u0000\u0000\u0113\u0115\u0003\u0016\u000b\u0000\u0114"+
		"\u0116\u0007\u0004\u0000\u0000\u0115\u0114\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117"+
		"\u0118\u0005\u0014\u0000\u0000\u0118\u0119\u0003B!\u0000\u0119\u011a\u0005"+
		"\u0010\u0000\u0000\u011a\u001b\u0001\u0000\u0000\u0000\u011b\u011c\u0005"+
		"!\u0000\u0000\u011c\u011d\u0005\n\u0000\u0000\u011d\u011e\u0005\"\u0000"+
		"\u0000\u011e\u011f\u0003\u0016\u000b\u0000\u011f\u0120\u0003\u0018\f\u0000"+
		"\u0120\u001d\u0001\u0000\u0000\u0000\u0121\u0122\u0003\u0016\u000b\u0000"+
		"\u0122\u0123\u0005\u0010\u0000\u0000\u0123\u001f\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u0005#\u0000\u0000\u0125\u0126\u0003B!\u0000\u0126\u0129"+
		"\u0003\u0018\f\u0000\u0127\u0128\u0005$\u0000\u0000\u0128\u012a\u0003"+
		"\u0018\f\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000"+
		"\u0000\u0000\u012a!\u0001\u0000\u0000\u0000\u012b\u012c\u0005%\u0000\u0000"+
		"\u012c\u012d\u0003\u0018\f\u0000\u012d#\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0005&\u0000\u0000\u012f\u0130\u0003B!\u0000\u0130\u0134\u0005"+
		"\u0017\u0000\u0000\u0131\u0133\u0003&\u0013\u0000\u0132\u0131\u0001\u0000"+
		"\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132\u0001\u0000"+
		"\u0000\u0000\u0134\u0135\u0001\u0000\u0000\u0000\u0135\u0137\u0001\u0000"+
		"\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0137\u0138\u0005\u0018"+
		"\u0000\u0000\u0138%\u0001\u0000\u0000\u0000\u0139\u013a\u0005\'\u0000"+
		"\u0000\u013a\u013b\u0003B!\u0000\u013b\u013c\u0003\u0014\n\u0000\u013c"+
		"\'\u0001\u0000\u0000\u0000\u013d\u013e\u0005\u0003\u0000\u0000\u013e\u013f"+
		"\u0003\u0014\n\u0000\u013f)\u0001\u0000\u0000\u0000\u0140\u0141\u0005"+
		"(\u0000\u0000\u0141\u0142\u0003B!\u0000\u0142\u0143\u0003\u0018\f\u0000"+
		"\u0143+\u0001\u0000\u0000\u0000\u0144\u0148\u0005)\u0000\u0000\u0145\u0146"+
		"\u0003B!\u0000\u0146\u0147\u0005\u0010\u0000\u0000\u0147\u0149\u0001\u0000"+
		"\u0000\u0000\u0148\u0145\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000"+
		"\u0000\u0000\u0149-\u0001\u0000\u0000\u0000\u014a\u014b\u0005*\u0000\u0000"+
		"\u014b/\u0001\u0000\u0000\u0000\u014c\u014d\u0005+\u0000\u0000\u014d1"+
		"\u0001\u0000\u0000\u0000\u014e\u0155\u0003\b\u0004\u0000\u014f\u0155\u0003"+
		"\u0004\u0002\u0000\u0150\u0155\u0003\u0010\b\u0000\u0151\u0155\u0003\n"+
		"\u0005\u0000\u0152\u0155\u0003\f\u0006\u0000\u0153\u0155\u0003\u000e\u0007"+
		"\u0000\u0154\u014e\u0001\u0000\u0000\u0000\u0154\u014f\u0001\u0000\u0000"+
		"\u0000\u0154\u0150\u0001\u0000\u0000\u0000\u0154\u0151\u0001\u0000\u0000"+
		"\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0154\u0153\u0001\u0000\u0000"+
		"\u0000\u01553\u0001\u0000\u0000\u0000\u0156\u015c\u00038\u001c\u0000\u0157"+
		"\u015c\u0003:\u001d\u0000\u0158\u015c\u0003<\u001e\u0000\u0159\u015c\u0003"+
		">\u001f\u0000\u015a\u015c\u0003@ \u0000\u015b\u0156\u0001\u0000\u0000"+
		"\u0000\u015b\u0157\u0001\u0000\u0000\u0000\u015b\u0158\u0001\u0000\u0000"+
		"\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015b\u015a\u0001\u0000\u0000"+
		"\u0000\u015c5\u0001\u0000\u0000\u0000\u015d\u015e\u00034\u001a\u0000\u015e"+
		"\u015f\u0005,\u0000\u0000\u015f\u0160\u0003J%\u0000\u0160\u0161\u0005"+
		"-\u0000\u0000\u01617\u0001\u0000\u0000\u0000\u0162\u0163\u0005\u001e\u0000"+
		"\u0000\u0163\u0164\u00034\u001a\u0000\u01649\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0005.\u0000\u0000\u0166\u0167\u00034\u001a\u0000\u0167;\u0001"+
		"\u0000\u0000\u0000\u0168\u016f\u0005\u000b\u0000\u0000\u0169\u016b\u0003"+
		"4\u001a\u0000\u016a\u016c\u0005\f\u0000\u0000\u016b\u016a\u0001\u0000"+
		"\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016e\u0001\u0000"+
		"\u0000\u0000\u016d\u0169\u0001\u0000\u0000\u0000\u016e\u0171\u0001\u0000"+
		"\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000"+
		"\u0000\u0000\u0170\u0172\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000"+
		"\u0000\u0000\u0172\u0173\u0005\r\u0000\u0000\u0173=\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u0003\u0012\t\u0000\u0175?\u0001\u0000\u0000\u0000"+
		"\u0176\u0177\u0007\u0005\u0000\u0000\u0177A\u0001\u0000\u0000\u0000\u0178"+
		"\u017f\u0003R)\u0000\u0179\u017f\u0003T*\u0000\u017a\u017f\u0003\u001e"+
		"\u000f\u0000\u017b\u017f\u0003h4\u0000\u017c\u017f\u0003D\"\u0000\u017d"+
		"\u017f\u0003\u0016\u000b\u0000\u017e\u0178\u0001\u0000\u0000\u0000\u017e"+
		"\u0179\u0001\u0000\u0000\u0000\u017e\u017a\u0001\u0000\u0000\u0000\u017e"+
		"\u017b\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000\u0000\u017e"+
		"\u017d\u0001\u0000\u0000\u0000\u017fC\u0001\u0000\u0000\u0000\u0180\u0187"+
		"\u0003F#\u0000\u0181\u0187\u0003J%\u0000\u0182\u0187\u0003H$\u0000\u0183"+
		"\u0187\u0003L&\u0000\u0184\u0187\u0003N\'\u0000\u0185\u0187\u0003P(\u0000"+
		"\u0186\u0180\u0001\u0000\u0000\u0000\u0186\u0181\u0001\u0000\u0000\u0000"+
		"\u0186\u0182\u0001\u0000\u0000\u0000\u0186\u0183\u0001\u0000\u0000\u0000"+
		"\u0186\u0184\u0001\u0000\u0000\u0000\u0186\u0185\u0001\u0000\u0000\u0000"+
		"\u0187E\u0001\u0000\u0000\u0000\u0188\u0189\u0005<\u0000\u0000\u0189G"+
		"\u0001\u0000\u0000\u0000\u018a\u018b\u0005=\u0000\u0000\u018bI\u0001\u0000"+
		"\u0000\u0000\u018c\u018d\u0005>\u0000\u0000\u018dK\u0001\u0000\u0000\u0000"+
		"\u018e\u018f\u0007\u0006\u0000\u0000\u018fM\u0001\u0000\u0000\u0000\u0190"+
		"\u0197\u0005,\u0000\u0000\u0191\u0193\u0003B!\u0000\u0192\u0194\u0005"+
		"\f\u0000\u0000\u0193\u0192\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000"+
		"\u0000\u0000\u0194\u0196\u0001\u0000\u0000\u0000\u0195\u0191\u0001\u0000"+
		"\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000"+
		"\u0000\u0000\u0197\u0198\u0001\u0000\u0000\u0000\u0198\u019a\u0001\u0000"+
		"\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000\u019a\u019b\u0005-\u0000"+
		"\u0000\u019bO\u0001\u0000\u0000\u0000\u019c\u01a3\u0005\u000b\u0000\u0000"+
		"\u019d\u019f\u0003B!\u0000\u019e\u01a0\u0005\f\u0000\u0000\u019f\u019e"+
		"\u0001\u0000\u0000\u0000\u019f\u01a0\u0001\u0000\u0000\u0000\u01a0\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a1\u019d\u0001\u0000\u0000\u0000\u01a2\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a3\u01a4"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a6\u0001\u0000\u0000\u0000\u01a5\u01a3"+
		"\u0001\u0000\u0000\u0000\u01a6\u01a7\u0005\r\u0000\u0000\u01a7Q\u0001"+
		"\u0000\u0000\u0000\u01a8\u01a9\u0005\u000b\u0000\u0000\u01a9\u01aa\u0003"+
		"B!\u0000\u01aa\u01ab\u0005\r\u0000\u0000\u01abS\u0001\u0000\u0000\u0000"+
		"\u01ac\u01b2\u0003V+\u0000\u01ad\u01ae\u0005A\u0000\u0000\u01ae\u01af"+
		"\u0005A\u0000\u0000\u01af\u01b1\u0003V+\u0000\u01b0\u01ad\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3U\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b5\u01bb\u0003X,\u0000\u01b6"+
		"\u01b7\u0005B\u0000\u0000\u01b7\u01b8\u0005B\u0000\u0000\u01b8\u01ba\u0003"+
		"X,\u0000\u01b9\u01b6\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000"+
		"\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000"+
		"\u0000\u01bcW\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000"+
		"\u01be\u01ce\u0003Z-\u0000\u01bf\u01c0\u0005\u0014\u0000\u0000\u01c0\u01ca"+
		"\u0005\u0014\u0000\u0000\u01c1\u01c2\u0005C\u0000\u0000\u01c2\u01ca\u0005"+
		"\u0014\u0000\u0000\u01c3\u01ca\u0005D\u0000\u0000\u01c4\u01c5\u0005D\u0000"+
		"\u0000\u01c5\u01ca\u0005\u0014\u0000\u0000\u01c6\u01ca\u0005\u000f\u0000"+
		"\u0000\u01c7\u01c8\u0005\u000f\u0000\u0000\u01c8\u01ca\u0005\u0014\u0000"+
		"\u0000\u01c9\u01bf\u0001\u0000\u0000\u0000\u01c9\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c3\u0001\u0000\u0000\u0000\u01c9\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c6\u0001\u0000\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000"+
		"\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000\u01cb\u01cd\u0003Z-\u0000\u01cc"+
		"\u01c9\u0001\u0000\u0000\u0000\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce"+
		"\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf"+
		"Y\u0001\u0000\u0000\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d1\u01d6"+
		"\u0003\\.\u0000\u01d2\u01d3\u0005A\u0000\u0000\u01d3\u01d5\u0003\\.\u0000"+
		"\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01d8\u0001\u0000\u0000\u0000"+
		"\u01d6\u01d4\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d7[\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d9"+
		"\u01de\u0003^/\u0000\u01da\u01db\u0005E\u0000\u0000\u01db\u01dd\u0003"+
		"^/\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01e0\u0001\u0000\u0000"+
		"\u0000\u01de\u01dc\u0001\u0000\u0000\u0000\u01de\u01df\u0001\u0000\u0000"+
		"\u0000\u01df]\u0001\u0000\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e6\u0003`0\u0000\u01e2\u01e3\u0005B\u0000\u0000\u01e3\u01e5"+
		"\u0003`0\u0000\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000"+
		"\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000"+
		"\u0000\u0000\u01e7_\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000"+
		"\u0000\u01e9\u01f3\u0003b1\u0000\u01ea\u01eb\u0005D\u0000\u0000\u01eb"+
		"\u01ef\u0005D\u0000\u0000\u01ec\u01ed\u0005\u000f\u0000\u0000\u01ed\u01ef"+
		"\u0005\u000f\u0000\u0000\u01ee\u01ea\u0001\u0000\u0000\u0000\u01ee\u01ec"+
		"\u0001\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f2"+
		"\u0003b1\u0000\u01f1\u01ee\u0001\u0000\u0000\u0000\u01f2\u01f5\u0001\u0000"+
		"\u0000\u0000\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001\u0000"+
		"\u0000\u0000\u01f4a\u0001\u0000\u0000\u0000\u01f5\u01f3\u0001\u0000\u0000"+
		"\u0000\u01f6\u01fb\u0003d2\u0000\u01f7\u01f8\u0007\u0007\u0000\u0000\u01f8"+
		"\u01fa\u0003d2\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa\u01fd\u0001"+
		"\u0000\u0000\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001"+
		"\u0000\u0000\u0000\u01fcc\u0001\u0000\u0000\u0000\u01fd\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fe\u0203\u0003f3\u0000\u01ff\u0200\u0007\b\u0000\u0000"+
		"\u0200\u0202\u0003f3\u0000\u0201\u01ff\u0001\u0000\u0000\u0000\u0202\u0205"+
		"\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000\u0203\u0204"+
		"\u0001\u0000\u0000\u0000\u0204e\u0001\u0000\u0000\u0000\u0205\u0203\u0001"+
		"\u0000\u0000\u0000\u0206\u0209\u0003h4\u0000\u0207\u0208\u0005F\u0000"+
		"\u0000\u0208\u020a\u00034\u001a\u0000\u0209\u0207\u0001\u0000\u0000\u0000"+
		"\u0209\u020a\u0001\u0000\u0000\u0000\u020ag\u0001\u0000\u0000\u0000\u020b"+
		"\u020d\u0007\t\u0000\u0000\u020c\u020b\u0001\u0000\u0000\u0000\u020c\u020d"+
		"\u0001\u0000\u0000\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e\u020f"+
		"\u0003j5\u0000\u020fi\u0001\u0000\u0000\u0000\u0210\u0218\u0003D\"\u0000"+
		"\u0211\u0218\u0003\u0016\u000b\u0000\u0212\u0218\u0003\u001e\u000f\u0000"+
		"\u0213\u0214\u0005\u000b\u0000\u0000\u0214\u0215\u0003B!\u0000\u0215\u0216"+
		"\u0005\r\u0000\u0000\u0216\u0218\u0001\u0000\u0000\u0000\u0217\u0210\u0001"+
		"\u0000\u0000\u0000\u0217\u0211\u0001\u0000\u0000\u0000\u0217\u0212\u0001"+
		"\u0000\u0000\u0000\u0217\u0213\u0001\u0000\u0000\u0000\u0218k\u0001\u0000"+
		"\u0000\u00007ox}\u0088\u008b\u0091\u0095\u009e\u00a5\u00a9\u00b0\u00b9"+
		"\u00bb\u00c0\u00c2\u00c8\u00ce\u00d0\u00d7\u00df\u00e8\u00ee\u00f7\u00fb"+
		"\u00ff\u0103\u0111\u0115\u0129\u0134\u0148\u0154\u015b\u016b\u016f\u017e"+
		"\u0186\u0193\u0197\u019f\u01a3\u01b2\u01bb\u01c9\u01ce\u01d6\u01de\u01e6"+
		"\u01ee\u01f3\u01fb\u0203\u0209\u020c\u0217";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}