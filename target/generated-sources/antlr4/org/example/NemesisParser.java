// Generated from org/example/Nemesis.g4 by ANTLR 4.13.2
package org.example;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class NemesisParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAM=1, IF=2, THEN=3, ELSE=4, STRING=5, INTEGER=6, BOOLEAN=7, BEGIN=8, 
		END=9, WHILE=10, DO=11, READ=12, VAR=13, FALSE=14, TRUE=15, WRITE=16, 
		OPAD=17, OPMULT=18, OPLOG=19, OPNEG=20, OPREL=21, PVIG=22, PONTO=23, ATRIB=24, 
		DPONTOS=25, VIG=26, ABPAR=27, FPAR=28, ID=29, CTE=30, CADEIA=31, COMENTARIO=32, 
		ESPACO=33, ERRO=34;
	public static final int
		RULE_prog = 0, RULE_decls = 1, RULE_listDecl = 2, RULE_declTip = 3, RULE_listId = 4, 
		RULE_tip = 5, RULE_cmdComp = 6, RULE_listCmd = 7, RULE_cmd = 8, RULE_cmdFecha = 9, 
		RULE_cmdAbre = 10, RULE_cmdRead = 11, RULE_cmdWrite = 12, RULE_listW = 13, 
		RULE_elemW = 14, RULE_cmdAtrib = 15, RULE_expr = 16, RULE_exprOprel = 17, 
		RULE_exprOpad = 18, RULE_exprOpmult = 19, RULE_atomo = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decls", "listDecl", "declTip", "listId", "tip", "cmdComp", "listCmd", 
			"cmd", "cmdFecha", "cmdAbre", "cmdRead", "cmdWrite", "listW", "elemW", 
			"cmdAtrib", "expr", "exprOprel", "exprOpad", "exprOpmult", "atomo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'if'", "'then'", "'else'", "'string'", "'integer'", 
			"'boolean'", "'begin'", "'end'", "'while'", "'do'", "'read'", "'var'", 
			"'false'", "'true'", "'write'", null, null, null, "'~'", null, "';'", 
			"'.'", "':='", "':'", "','", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "IF", "THEN", "ELSE", "STRING", "INTEGER", "BOOLEAN", 
			"BEGIN", "END", "WHILE", "DO", "READ", "VAR", "FALSE", "TRUE", "WRITE", 
			"OPAD", "OPMULT", "OPLOG", "OPNEG", "OPREL", "PVIG", "PONTO", "ATRIB", 
			"DPONTOS", "VIG", "ABPAR", "FPAR", "ID", "CTE", "CADEIA", "COMENTARIO", 
			"ESPACO", "ERRO"
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
	public String getGrammarFileName() { return "Nemesis.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NemesisParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(NemesisParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(NemesisParser.ID, 0); }
		public TerminalNode PVIG() { return getToken(NemesisParser.PVIG, 0); }
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public CmdCompContext cmdComp() {
			return getRuleContext(CmdCompContext.class,0);
		}
		public TerminalNode PONTO() { return getToken(NemesisParser.PONTO, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(PROGRAM);
			setState(43);
			match(ID);
			setState(44);
			match(PVIG);
			setState(45);
			decls();
			setState(46);
			cmdComp();
			setState(47);
			match(PONTO);
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
	public static class DeclsContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(NemesisParser.VAR, 0); }
		public ListDeclContext listDecl() {
			return getRuleContext(ListDeclContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitDecls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitDecls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(VAR);
				setState(50);
				listDecl();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class ListDeclContext extends ParserRuleContext {
		public DeclTipContext declTip() {
			return getRuleContext(DeclTipContext.class,0);
		}
		public ListDeclContext listDecl() {
			return getRuleContext(ListDeclContext.class,0);
		}
		public ListDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterListDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitListDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitListDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListDeclContext listDecl() throws RecognitionException {
		ListDeclContext _localctx = new ListDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_listDecl);
		try {
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				declTip();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				declTip();
				setState(56);
				listDecl();
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
	public static class DeclTipContext extends ParserRuleContext {
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public TerminalNode DPONTOS() { return getToken(NemesisParser.DPONTOS, 0); }
		public TipContext tip() {
			return getRuleContext(TipContext.class,0);
		}
		public TerminalNode PVIG() { return getToken(NemesisParser.PVIG, 0); }
		public DeclTipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declTip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterDeclTip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitDeclTip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitDeclTip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclTipContext declTip() throws RecognitionException {
		DeclTipContext _localctx = new DeclTipContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declTip);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			listId();
			setState(61);
			match(DPONTOS);
			setState(62);
			tip();
			setState(63);
			match(PVIG);
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
	public static class ListIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NemesisParser.ID, 0); }
		public TerminalNode VIG() { return getToken(NemesisParser.VIG, 0); }
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public ListIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterListId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitListId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitListId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListIdContext listId() throws RecognitionException {
		ListIdContext _localctx = new ListIdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listId);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(ID);
				setState(67);
				match(VIG);
				setState(68);
				listId();
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
	public static class TipContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(NemesisParser.INTEGER, 0); }
		public TerminalNode BOOLEAN() { return getToken(NemesisParser.BOOLEAN, 0); }
		public TerminalNode STRING() { return getToken(NemesisParser.STRING, 0); }
		public TipContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tip; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterTip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitTip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitTip(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipContext tip() throws RecognitionException {
		TipContext _localctx = new TipContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tip);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 224L) != 0)) ) {
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
	public static class CmdCompContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(NemesisParser.BEGIN, 0); }
		public ListCmdContext listCmd() {
			return getRuleContext(ListCmdContext.class,0);
		}
		public TerminalNode END() { return getToken(NemesisParser.END, 0); }
		public CmdCompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdComp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterCmdComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitCmdComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitCmdComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdCompContext cmdComp() throws RecognitionException {
		CmdCompContext _localctx = new CmdCompContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdComp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(BEGIN);
			setState(74);
			listCmd();
			setState(75);
			match(END);
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
	public static class ListCmdContext extends ParserRuleContext {
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public TerminalNode PVIG() { return getToken(NemesisParser.PVIG, 0); }
		public ListCmdContext listCmd() {
			return getRuleContext(ListCmdContext.class,0);
		}
		public ListCmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listCmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterListCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitListCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitListCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListCmdContext listCmd() throws RecognitionException {
		ListCmdContext _localctx = new ListCmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_listCmd);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				cmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				cmd();
				setState(79);
				match(PVIG);
				setState(80);
				listCmd();
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
	public static class CmdContext extends ParserRuleContext {
		public CmdFechaContext cmdFecha() {
			return getRuleContext(CmdFechaContext.class,0);
		}
		public CmdAbreContext cmdAbre() {
			return getRuleContext(CmdAbreContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmd);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				cmdFecha();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				cmdAbre();
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
	public static class CmdFechaContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(NemesisParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(NemesisParser.THEN, 0); }
		public List<CmdFechaContext> cmdFecha() {
			return getRuleContexts(CmdFechaContext.class);
		}
		public CmdFechaContext cmdFecha(int i) {
			return getRuleContext(CmdFechaContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(NemesisParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(NemesisParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(NemesisParser.DO, 0); }
		public CmdReadContext cmdRead() {
			return getRuleContext(CmdReadContext.class,0);
		}
		public CmdWriteContext cmdWrite() {
			return getRuleContext(CmdWriteContext.class,0);
		}
		public CmdAtribContext cmdAtrib() {
			return getRuleContext(CmdAtribContext.class,0);
		}
		public CmdCompContext cmdComp() {
			return getRuleContext(CmdCompContext.class,0);
		}
		public CmdFechaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFecha; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterCmdFecha(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitCmdFecha(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitCmdFecha(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdFechaContext cmdFecha() throws RecognitionException {
		CmdFechaContext _localctx = new CmdFechaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdFecha);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(IF);
				setState(89);
				expr(0);
				setState(90);
				match(THEN);
				setState(91);
				cmdFecha();
				setState(92);
				match(ELSE);
				setState(93);
				cmdFecha();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(WHILE);
				setState(96);
				expr(0);
				setState(97);
				match(DO);
				setState(98);
				cmdFecha();
				}
				break;
			case READ:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				cmdRead();
				}
				break;
			case WRITE:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				cmdWrite();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				cmdAtrib();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				cmdComp();
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
	public static class CmdAbreContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(NemesisParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(NemesisParser.THEN, 0); }
		public CmdContext cmd() {
			return getRuleContext(CmdContext.class,0);
		}
		public CmdFechaContext cmdFecha() {
			return getRuleContext(CmdFechaContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(NemesisParser.ELSE, 0); }
		public CmdAbreContext cmdAbre() {
			return getRuleContext(CmdAbreContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(NemesisParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(NemesisParser.DO, 0); }
		public CmdAbreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAbre; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterCmdAbre(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitCmdAbre(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitCmdAbre(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAbreContext cmdAbre() throws RecognitionException {
		CmdAbreContext _localctx = new CmdAbreContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdAbre);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(IF);
				setState(107);
				expr(0);
				setState(108);
				match(THEN);
				setState(109);
				cmd();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(IF);
				setState(112);
				expr(0);
				setState(113);
				match(THEN);
				setState(114);
				cmdFecha();
				setState(115);
				match(ELSE);
				setState(116);
				cmdAbre();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(WHILE);
				setState(119);
				expr(0);
				setState(120);
				match(DO);
				setState(121);
				cmdAbre();
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
	public static class CmdReadContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(NemesisParser.READ, 0); }
		public TerminalNode ABPAR() { return getToken(NemesisParser.ABPAR, 0); }
		public ListIdContext listId() {
			return getRuleContext(ListIdContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(NemesisParser.FPAR, 0); }
		public CmdReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterCmdRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitCmdRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitCmdRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdReadContext cmdRead() throws RecognitionException {
		CmdReadContext _localctx = new CmdReadContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cmdRead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(READ);
			setState(126);
			match(ABPAR);
			setState(127);
			listId();
			setState(128);
			match(FPAR);
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
	public static class CmdWriteContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(NemesisParser.WRITE, 0); }
		public TerminalNode ABPAR() { return getToken(NemesisParser.ABPAR, 0); }
		public ListWContext listW() {
			return getRuleContext(ListWContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(NemesisParser.FPAR, 0); }
		public CmdWriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWrite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterCmdWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitCmdWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitCmdWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdWriteContext cmdWrite() throws RecognitionException {
		CmdWriteContext _localctx = new CmdWriteContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cmdWrite);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(WRITE);
			setState(131);
			match(ABPAR);
			setState(132);
			listW();
			setState(133);
			match(FPAR);
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
	public static class ListWContext extends ParserRuleContext {
		public ElemWContext elemW() {
			return getRuleContext(ElemWContext.class,0);
		}
		public TerminalNode VIG() { return getToken(NemesisParser.VIG, 0); }
		public ListWContext listW() {
			return getRuleContext(ListWContext.class,0);
		}
		public ListWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterListW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitListW(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitListW(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListWContext listW() throws RecognitionException {
		ListWContext _localctx = new ListWContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_listW);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				elemW();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				elemW();
				setState(137);
				match(VIG);
				setState(138);
				listW();
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
	public static class ElemWContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(NemesisParser.CADEIA, 0); }
		public ElemWContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elemW; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterElemW(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitElemW(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitElemW(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElemWContext elemW() throws RecognitionException {
		ElemWContext _localctx = new ElemWContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elemW);
		try {
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FALSE:
			case TRUE:
			case OPAD:
			case OPNEG:
			case ABPAR:
			case ID:
			case CTE:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				expr(0);
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(CADEIA);
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
	public static class CmdAtribContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NemesisParser.ID, 0); }
		public TerminalNode ATRIB() { return getToken(NemesisParser.ATRIB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdAtribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterCmdAtrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitCmdAtrib(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitCmdAtrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAtribContext cmdAtrib() throws RecognitionException {
		CmdAtribContext _localctx = new CmdAtribContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_cmdAtrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(ID);
			setState(147);
			match(ATRIB);
			setState(148);
			expr(0);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprOprelContext exprOprel() {
			return getRuleContext(ExprOprelContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OPLOG() { return getToken(NemesisParser.OPLOG, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(151);
			exprOprel(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(153);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(154);
					match(OPLOG);
					setState(155);
					exprOprel(0);
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprOprelContext extends ParserRuleContext {
		public ExprOpadContext exprOpad() {
			return getRuleContext(ExprOpadContext.class,0);
		}
		public ExprOprelContext exprOprel() {
			return getRuleContext(ExprOprelContext.class,0);
		}
		public TerminalNode OPREL() { return getToken(NemesisParser.OPREL, 0); }
		public ExprOprelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOprel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterExprOprel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitExprOprel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitExprOprel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprOprelContext exprOprel() throws RecognitionException {
		return exprOprel(0);
	}

	private ExprOprelContext exprOprel(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprOprelContext _localctx = new ExprOprelContext(_ctx, _parentState);
		ExprOprelContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_exprOprel, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(162);
			exprOpad(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprOprelContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprOprel);
					setState(164);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(165);
					match(OPREL);
					setState(166);
					exprOpad(0);
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprOpadContext extends ParserRuleContext {
		public ExprOpmultContext exprOpmult() {
			return getRuleContext(ExprOpmultContext.class,0);
		}
		public ExprOpadContext exprOpad() {
			return getRuleContext(ExprOpadContext.class,0);
		}
		public TerminalNode OPAD() { return getToken(NemesisParser.OPAD, 0); }
		public ExprOpadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOpad; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterExprOpad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitExprOpad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitExprOpad(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprOpadContext exprOpad() throws RecognitionException {
		return exprOpad(0);
	}

	private ExprOpadContext exprOpad(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprOpadContext _localctx = new ExprOpadContext(_ctx, _parentState);
		ExprOpadContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_exprOpad, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(173);
			exprOpmult(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprOpadContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprOpad);
					setState(175);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(176);
					match(OPAD);
					setState(177);
					exprOpmult(0);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprOpmultContext extends ParserRuleContext {
		public AtomoContext atomo() {
			return getRuleContext(AtomoContext.class,0);
		}
		public ExprOpmultContext exprOpmult() {
			return getRuleContext(ExprOpmultContext.class,0);
		}
		public TerminalNode OPMULT() { return getToken(NemesisParser.OPMULT, 0); }
		public ExprOpmultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOpmult; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterExprOpmult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitExprOpmult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitExprOpmult(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprOpmultContext exprOpmult() throws RecognitionException {
		return exprOpmult(0);
	}

	private ExprOpmultContext exprOpmult(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprOpmultContext _localctx = new ExprOpmultContext(_ctx, _parentState);
		ExprOpmultContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_exprOpmult, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(184);
			atomo();
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprOpmultContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprOpmult);
					setState(186);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(187);
					match(OPMULT);
					setState(188);
					atomo();
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(NemesisParser.ID, 0); }
		public TerminalNode CTE() { return getToken(NemesisParser.CTE, 0); }
		public TerminalNode TRUE() { return getToken(NemesisParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NemesisParser.FALSE, 0); }
		public TerminalNode ABPAR() { return getToken(NemesisParser.ABPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(NemesisParser.FPAR, 0); }
		public TerminalNode OPNEG() { return getToken(NemesisParser.OPNEG, 0); }
		public AtomoContext atomo() {
			return getRuleContext(AtomoContext.class,0);
		}
		public TerminalNode OPAD() { return getToken(NemesisParser.OPAD, 0); }
		public AtomoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).enterAtomo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NemesisListener ) ((NemesisListener)listener).exitAtomo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NemesisVisitor ) return ((NemesisVisitor<? extends T>)visitor).visitAtomo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomoContext atomo() throws RecognitionException {
		AtomoContext _localctx = new AtomoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_atomo);
		try {
			setState(206);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(ID);
				}
				break;
			case CTE:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(CTE);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(FALSE);
				}
				break;
			case ABPAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				match(ABPAR);
				setState(199);
				expr(0);
				setState(200);
				match(FPAR);
				}
				break;
			case OPNEG:
				enterOuterAlt(_localctx, 6);
				{
				setState(202);
				match(OPNEG);
				setState(203);
				atomo();
				}
				break;
			case OPAD:
				enterOuterAlt(_localctx, 7);
				{
				setState(204);
				match(OPAD);
				setState(205);
				atomo();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 17:
			return exprOprel_sempred((ExprOprelContext)_localctx, predIndex);
		case 18:
			return exprOpad_sempred((ExprOpadContext)_localctx, predIndex);
		case 19:
			return exprOpmult_sempred((ExprOpmultContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprOprel_sempred(ExprOprelContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprOpad_sempred(ExprOpadContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exprOpmult_sempred(ExprOpmultContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\"\u00d1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004F\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007S\b\u0007\u0001\b\u0001\b\u0003\b"+
		"W\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\ti\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n|\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0003\r\u008d\b\r\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0091\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u009d\b\u0010\n\u0010\f\u0010\u00a0\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00a8\b\u0011\n"+
		"\u0011\f\u0011\u00ab\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00b3\b\u0012\n\u0012\f\u0012"+
		"\u00b6\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u00be\b\u0013\n\u0013\f\u0013\u00c1\t\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00cf\b\u0014\u0001\u0014\u0000\u0004 \"$&\u0015\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(\u0000\u0001\u0001\u0000\u0005\u0007\u00d3\u0000*\u0001\u0000\u0000"+
		"\u0000\u00024\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006"+
		"<\u0001\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000"+
		"\u0000\fI\u0001\u0000\u0000\u0000\u000eR\u0001\u0000\u0000\u0000\u0010"+
		"V\u0001\u0000\u0000\u0000\u0012h\u0001\u0000\u0000\u0000\u0014{\u0001"+
		"\u0000\u0000\u0000\u0016}\u0001\u0000\u0000\u0000\u0018\u0082\u0001\u0000"+
		"\u0000\u0000\u001a\u008c\u0001\u0000\u0000\u0000\u001c\u0090\u0001\u0000"+
		"\u0000\u0000\u001e\u0092\u0001\u0000\u0000\u0000 \u0096\u0001\u0000\u0000"+
		"\u0000\"\u00a1\u0001\u0000\u0000\u0000$\u00ac\u0001\u0000\u0000\u0000"+
		"&\u00b7\u0001\u0000\u0000\u0000(\u00ce\u0001\u0000\u0000\u0000*+\u0005"+
		"\u0001\u0000\u0000+,\u0005\u001d\u0000\u0000,-\u0005\u0016\u0000\u0000"+
		"-.\u0003\u0002\u0001\u0000./\u0003\f\u0006\u0000/0\u0005\u0017\u0000\u0000"+
		"0\u0001\u0001\u0000\u0000\u000012\u0005\r\u0000\u000025\u0003\u0004\u0002"+
		"\u000035\u0001\u0000\u0000\u000041\u0001\u0000\u0000\u000043\u0001\u0000"+
		"\u0000\u00005\u0003\u0001\u0000\u0000\u00006;\u0003\u0006\u0003\u0000"+
		"78\u0003\u0006\u0003\u000089\u0003\u0004\u0002\u00009;\u0001\u0000\u0000"+
		"\u0000:6\u0001\u0000\u0000\u0000:7\u0001\u0000\u0000\u0000;\u0005\u0001"+
		"\u0000\u0000\u0000<=\u0003\b\u0004\u0000=>\u0005\u0019\u0000\u0000>?\u0003"+
		"\n\u0005\u0000?@\u0005\u0016\u0000\u0000@\u0007\u0001\u0000\u0000\u0000"+
		"AF\u0005\u001d\u0000\u0000BC\u0005\u001d\u0000\u0000CD\u0005\u001a\u0000"+
		"\u0000DF\u0003\b\u0004\u0000EA\u0001\u0000\u0000\u0000EB\u0001\u0000\u0000"+
		"\u0000F\t\u0001\u0000\u0000\u0000GH\u0007\u0000\u0000\u0000H\u000b\u0001"+
		"\u0000\u0000\u0000IJ\u0005\b\u0000\u0000JK\u0003\u000e\u0007\u0000KL\u0005"+
		"\t\u0000\u0000L\r\u0001\u0000\u0000\u0000MS\u0003\u0010\b\u0000NO\u0003"+
		"\u0010\b\u0000OP\u0005\u0016\u0000\u0000PQ\u0003\u000e\u0007\u0000QS\u0001"+
		"\u0000\u0000\u0000RM\u0001\u0000\u0000\u0000RN\u0001\u0000\u0000\u0000"+
		"S\u000f\u0001\u0000\u0000\u0000TW\u0003\u0012\t\u0000UW\u0003\u0014\n"+
		"\u0000VT\u0001\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000W\u0011\u0001"+
		"\u0000\u0000\u0000XY\u0005\u0002\u0000\u0000YZ\u0003 \u0010\u0000Z[\u0005"+
		"\u0003\u0000\u0000[\\\u0003\u0012\t\u0000\\]\u0005\u0004\u0000\u0000]"+
		"^\u0003\u0012\t\u0000^i\u0001\u0000\u0000\u0000_`\u0005\n\u0000\u0000"+
		"`a\u0003 \u0010\u0000ab\u0005\u000b\u0000\u0000bc\u0003\u0012\t\u0000"+
		"ci\u0001\u0000\u0000\u0000di\u0003\u0016\u000b\u0000ei\u0003\u0018\f\u0000"+
		"fi\u0003\u001e\u000f\u0000gi\u0003\f\u0006\u0000hX\u0001\u0000\u0000\u0000"+
		"h_\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000he\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000i\u0013\u0001"+
		"\u0000\u0000\u0000jk\u0005\u0002\u0000\u0000kl\u0003 \u0010\u0000lm\u0005"+
		"\u0003\u0000\u0000mn\u0003\u0010\b\u0000n|\u0001\u0000\u0000\u0000op\u0005"+
		"\u0002\u0000\u0000pq\u0003 \u0010\u0000qr\u0005\u0003\u0000\u0000rs\u0003"+
		"\u0012\t\u0000st\u0005\u0004\u0000\u0000tu\u0003\u0014\n\u0000u|\u0001"+
		"\u0000\u0000\u0000vw\u0005\n\u0000\u0000wx\u0003 \u0010\u0000xy\u0005"+
		"\u000b\u0000\u0000yz\u0003\u0014\n\u0000z|\u0001\u0000\u0000\u0000{j\u0001"+
		"\u0000\u0000\u0000{o\u0001\u0000\u0000\u0000{v\u0001\u0000\u0000\u0000"+
		"|\u0015\u0001\u0000\u0000\u0000}~\u0005\f\u0000\u0000~\u007f\u0005\u001b"+
		"\u0000\u0000\u007f\u0080\u0003\b\u0004\u0000\u0080\u0081\u0005\u001c\u0000"+
		"\u0000\u0081\u0017\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0010\u0000"+
		"\u0000\u0083\u0084\u0005\u001b\u0000\u0000\u0084\u0085\u0003\u001a\r\u0000"+
		"\u0085\u0086\u0005\u001c\u0000\u0000\u0086\u0019\u0001\u0000\u0000\u0000"+
		"\u0087\u008d\u0003\u001c\u000e\u0000\u0088\u0089\u0003\u001c\u000e\u0000"+
		"\u0089\u008a\u0005\u001a\u0000\u0000\u008a\u008b\u0003\u001a\r\u0000\u008b"+
		"\u008d\u0001\u0000\u0000\u0000\u008c\u0087\u0001\u0000\u0000\u0000\u008c"+
		"\u0088\u0001\u0000\u0000\u0000\u008d\u001b\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0003 \u0010\u0000\u008f\u0091\u0005\u001f\u0000\u0000\u0090\u008e"+
		"\u0001\u0000\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u001d"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u001d\u0000\u0000\u0093\u0094"+
		"\u0005\u0018\u0000\u0000\u0094\u0095\u0003 \u0010\u0000\u0095\u001f\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0006\u0010\uffff\uffff\u0000\u0097\u0098"+
		"\u0003\"\u0011\u0000\u0098\u009e\u0001\u0000\u0000\u0000\u0099\u009a\n"+
		"\u0002\u0000\u0000\u009a\u009b\u0005\u0013\u0000\u0000\u009b\u009d\u0003"+
		"\"\u0011\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000"+
		"\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000"+
		"\u0000\u0000\u009f!\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0006\u0011\uffff\uffff\u0000\u00a2\u00a3\u0003$\u0012"+
		"\u0000\u00a3\u00a9\u0001\u0000\u0000\u0000\u00a4\u00a5\n\u0002\u0000\u0000"+
		"\u00a5\u00a6\u0005\u0015\u0000\u0000\u00a6\u00a8\u0003$\u0012\u0000\u00a7"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa"+
		"#\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00ad"+
		"\u0006\u0012\uffff\uffff\u0000\u00ad\u00ae\u0003&\u0013\u0000\u00ae\u00b4"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\n\u0002\u0000\u0000\u00b0\u00b1\u0005"+
		"\u0011\u0000\u0000\u00b1\u00b3\u0003&\u0013\u0000\u00b2\u00af\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5%\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7\u00b8\u0006\u0013\uffff"+
		"\uffff\u0000\u00b8\u00b9\u0003(\u0014\u0000\u00b9\u00bf\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\n\u0002\u0000\u0000\u00bb\u00bc\u0005\u0012\u0000\u0000"+
		"\u00bc\u00be\u0003(\u0014\u0000\u00bd\u00ba\u0001\u0000\u0000\u0000\u00be"+
		"\u00c1\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\'\u0001\u0000\u0000\u0000\u00c1\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c2\u00cf\u0005\u001d\u0000\u0000\u00c3\u00cf"+
		"\u0005\u001e\u0000\u0000\u00c4\u00cf\u0005\u000f\u0000\u0000\u00c5\u00cf"+
		"\u0005\u000e\u0000\u0000\u00c6\u00c7\u0005\u001b\u0000\u0000\u00c7\u00c8"+
		"\u0003 \u0010\u0000\u00c8\u00c9\u0005\u001c\u0000\u0000\u00c9\u00cf\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0005\u0014\u0000\u0000\u00cb\u00cf\u0003"+
		"(\u0014\u0000\u00cc\u00cd\u0005\u0011\u0000\u0000\u00cd\u00cf\u0003(\u0014"+
		"\u0000\u00ce\u00c2\u0001\u0000\u0000\u0000\u00ce\u00c3\u0001\u0000\u0000"+
		"\u0000\u00ce\u00c4\u0001\u0000\u0000\u0000\u00ce\u00c5\u0001\u0000\u0000"+
		"\u0000\u00ce\u00c6\u0001\u0000\u0000\u0000\u00ce\u00ca\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf)\u0001\u0000\u0000\u0000"+
		"\u000e4:ERVh{\u008c\u0090\u009e\u00a9\u00b4\u00bf\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}