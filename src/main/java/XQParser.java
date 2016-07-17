// Generated from XQParser.g4 by ANTLR 4.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		QUOTE=1, CLOSESQ=24, JOIN=29, ASSIGN=27, SATISFIES=30, DOUBLESLASH=4, 
		TXT=8, RETURN=12, STRINGCONST=38, SOME=28, CLOSECURL=35, DOC=2, CLOSEBRACKET=6, 
		ID=37, WS=36, EMPTY=31, COMMA=7, OR=16, SINGLESLASH=3, IN=13, EQUAL=25, 
		FOR=9, DOT=20, IS=14, CLOSETAG=33, WHERE=11, EQ=18, OPENBRACKET=5, OPENCURL=34, 
		OPENTAG=32, NOT=17, DOUBLEDOT=21, AT=22, STAR=19, AND=15, EQUALITY=26, 
		VARNAME=39, LET=10, OPENSQ=23;
	public static final String[] tokenNames = {
		"<INVALID>", "QUOTE", "DOC", "'/'", "'//'", "'('", "')'", "','", "'text()'", 
		"FOR", "LET", "WHERE", "RETURN", "IN", "IS", "AND", "OR", "NOT", "EQ", 
		"'*'", "'.'", "'..'", "'@'", "'['", "']'", "'='", "'=='", "':='", "SOME", 
		"JOIN", "SATISFIES", "EMPTY", "OPENTAG", "'>'", "'{'", "'}'", "WS", "ID", 
		"STRINGCONST", "VARNAME"
	};
	public static final int
		RULE_ap = 0, RULE_rp = 1, RULE_f = 2, RULE_forClause = 3, RULE_letClause = 4, 
		RULE_whereClause = 5, RULE_returnClause = 6, RULE_cond = 7, RULE_xqs = 8, 
		RULE_oxq = 9, RULE_xq = 10, RULE_list = 11, RULE_forJ = 12, RULE_path = 13, 
		RULE_condJ = 14, RULE_returnJ = 15;
	public static final String[] ruleNames = {
		"ap", "rp", "f", "forClause", "letClause", "whereClause", "returnClause", 
		"cond", "xqs", "oxq", "xq", "list", "forJ", "path", "condJ", "returnJ"
	};

	@Override
	public String getGrammarFileName() { return "XQParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ApDoubleSlashContext extends ApContext {
		public Token FILENAME;
		public TerminalNode DOUBLESLASH() { return getToken(XQParser.DOUBLESLASH, 0); }
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public TerminalNode STRINGCONST() { return getToken(XQParser.STRINGCONST, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public TerminalNode DOC() { return getToken(XQParser.DOC, 0); }
		public ApDoubleSlashContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterApDoubleSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitApDoubleSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitApDoubleSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApSlashContext extends ApContext {
		public Token FILENAME;
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public TerminalNode STRINGCONST() { return getToken(XQParser.STRINGCONST, 0); }
		public TerminalNode SINGLESLASH() { return getToken(XQParser.SINGLESLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public TerminalNode DOC() { return getToken(XQParser.DOC, 0); }
		public ApSlashContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterApSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitApSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitApSlash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		try {
			setState(44);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ApSlashContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32); match(DOC);
				setState(33); match(OPENBRACKET);
				setState(34); ((ApSlashContext)_localctx).FILENAME = match(STRINGCONST);
				setState(35); match(CLOSEBRACKET);
				setState(36); match(SINGLESLASH);
				setState(37); rp(0);
				}
				break;

			case 2:
				_localctx = new ApDoubleSlashContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(38); match(DOC);
				setState(39); match(OPENBRACKET);
				setState(40); ((ApDoubleSlashContext)_localctx).FILENAME = match(STRINGCONST);
				setState(41); match(CLOSEBRACKET);
				setState(42); match(DOUBLESLASH);
				setState(43); rp(0);
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

	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RpCurrContext extends RpContext {
		public TerminalNode DOT() { return getToken(XQParser.DOT, 0); }
		public RpCurrContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpCurr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpCurr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpCurr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpSlashContext extends RpContext {
		public RpContext left;
		public RpContext right;
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public TerminalNode SINGLESLASH() { return getToken(XQParser.SINGLESLASH, 0); }
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpSlashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpParentContext extends RpContext {
		public TerminalNode DOUBLEDOT() { return getToken(XQParser.DOUBLEDOT, 0); }
		public RpParentContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpParent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpParent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpParent(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpTxtContext extends RpContext {
		public TerminalNode TXT() { return getToken(XQParser.TXT, 0); }
		public RpTxtContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpTxt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpTxt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpTxt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpTagnameContext extends RpContext {
		public TerminalNode ID() { return getToken(XQParser.ID, 0); }
		public RpTagnameContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpTagname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpTagname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpTagname(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpStarContext extends RpContext {
		public TerminalNode STAR() { return getToken(XQParser.STAR, 0); }
		public RpStarContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpStar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpStar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpStar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpFilterContext extends RpContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TerminalNode CLOSESQ() { return getToken(XQParser.CLOSESQ, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode OPENSQ() { return getToken(XQParser.OPENSQ, 0); }
		public RpFilterContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpAttributeContext extends RpContext {
		public TerminalNode AT() { return getToken(XQParser.AT, 0); }
		public TerminalNode ID() { return getToken(XQParser.ID, 0); }
		public RpAttributeContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpBracketContext extends RpContext {
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public RpBracketContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpCommaContext extends RpContext {
		public RpContext left;
		public RpContext right;
		public TerminalNode COMMA() { return getToken(XQParser.COMMA, 0); }
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpCommaContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpComma(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RpDoubleSlashContext extends RpContext {
		public RpContext left;
		public RpContext right;
		public TerminalNode DOUBLESLASH() { return getToken(XQParser.DOUBLESLASH, 0); }
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpDoubleSlashContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRpDoubleSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRpDoubleSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRpDoubleSlash(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new RpTagnameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(47); match(ID);
				}
				break;
			case STAR:
				{
				_localctx = new RpStarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(48); match(STAR);
				}
				break;
			case DOT:
				{
				_localctx = new RpCurrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49); match(DOT);
				}
				break;
			case DOUBLEDOT:
				{
				_localctx = new RpParentContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50); match(DOUBLEDOT);
				}
				break;
			case TXT:
				{
				_localctx = new RpTxtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(51); match(TXT);
				}
				break;
			case AT:
				{
				_localctx = new RpAttributeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52); match(AT);
				setState(53); match(ID);
				}
				break;
			case OPENBRACKET:
				{
				_localctx = new RpBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(54); match(OPENBRACKET);
				setState(55); rp(0);
				setState(56); match(CLOSEBRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(74);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new RpSlashContext(new RpContext(_parentctx, _parentState));
						((RpSlashContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(60);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(61); match(SINGLESLASH);
						setState(62); ((RpSlashContext)_localctx).right = rp(5);
						}
						break;

					case 2:
						{
						_localctx = new RpDoubleSlashContext(new RpContext(_parentctx, _parentState));
						((RpDoubleSlashContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(63);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(64); match(DOUBLESLASH);
						setState(65); ((RpDoubleSlashContext)_localctx).right = rp(4);
						}
						break;

					case 3:
						{
						_localctx = new RpCommaContext(new RpContext(_parentctx, _parentState));
						((RpCommaContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(66);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(67); match(COMMA);
						setState(68); ((RpCommaContext)_localctx).right = rp(2);
						}
						break;

					case 4:
						{
						_localctx = new RpFilterContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(69);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(70); match(OPENSQ);
						setState(71); f(0);
						setState(72); match(CLOSESQ);
						}
						break;
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FEqualContext extends FContext {
		public RpContext left;
		public RpContext right;
		public TerminalNode EQUAL() { return getToken(XQParser.EQUAL, 0); }
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public TerminalNode EQ() { return getToken(XQParser.EQ, 0); }
		public FEqualContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterFEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitFEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitFEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FIsContext extends FContext {
		public RpContext left;
		public RpContext right;
		public TerminalNode IS() { return getToken(XQParser.IS, 0); }
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public TerminalNode EQUALITY() { return getToken(XQParser.EQUALITY, 0); }
		public FIsContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterFIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitFIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitFIs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FNotContext extends FContext {
		public TerminalNode NOT() { return getToken(XQParser.NOT, 0); }
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FNotContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterFNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitFNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitFNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FBracketContext extends FContext {
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public FBracketContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterFBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitFBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitFBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FRpContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FRpContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterFRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitFRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitFRp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FOrContext extends FContext {
		public FContext left;
		public FContext right;
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public TerminalNode OR() { return getToken(XQParser.OR, 0); }
		public FOrContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterFOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitFOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitFOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FAndContext extends FContext {
		public FContext left;
		public FContext right;
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public TerminalNode AND() { return getToken(XQParser.AND, 0); }
		public FAndContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterFAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitFAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitFAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new FNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(80); match(NOT);
				setState(81); f(1);
				}
				break;

			case 2:
				{
				_localctx = new FRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82); rp(0);
				}
				break;

			case 3:
				{
				_localctx = new FEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83); ((FEqualContext)_localctx).left = rp(0);
				setState(84); match(EQUAL);
				setState(85); ((FEqualContext)_localctx).right = rp(0);
				}
				break;

			case 4:
				{
				_localctx = new FEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87); ((FEqualContext)_localctx).left = rp(0);
				setState(88); match(EQ);
				setState(89); ((FEqualContext)_localctx).right = rp(0);
				}
				break;

			case 5:
				{
				_localctx = new FIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91); ((FIsContext)_localctx).left = rp(0);
				setState(92); match(EQUALITY);
				setState(93); ((FIsContext)_localctx).right = rp(0);
				}
				break;

			case 6:
				{
				_localctx = new FIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95); ((FIsContext)_localctx).left = rp(0);
				setState(96); match(IS);
				setState(97); ((FIsContext)_localctx).right = rp(0);
				}
				break;

			case 7:
				{
				_localctx = new FBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99); match(OPENBRACKET);
				setState(100); f(0);
				setState(101); match(CLOSEBRACKET);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(111);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new FAndContext(new FContext(_parentctx, _parentState));
						((FAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(105);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(106); match(AND);
						setState(107); ((FAndContext)_localctx).right = f(4);
						}
						break;

					case 2:
						{
						_localctx = new FOrContext(new FContext(_parentctx, _parentState));
						((FOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(108);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(109); match(OR);
						setState(110); ((FOrContext)_localctx).right = f(3);
						}
						break;
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public static class ForClauseContext extends ParserRuleContext {
		public TerminalNode IN(int i) {
			return getToken(XQParser.IN, i);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XQParser.COMMA); }
		public TerminalNode FOR() { return getToken(XQParser.FOR, 0); }
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public TerminalNode VARNAME(int i) {
			return getToken(XQParser.VARNAME, i);
		}
		public List<TerminalNode> VARNAME() { return getTokens(XQParser.VARNAME); }
		public List<TerminalNode> IN() { return getTokens(XQParser.IN); }
		public TerminalNode COMMA(int i) {
			return getToken(XQParser.COMMA, i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitForClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitForClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116); match(FOR);
			setState(117); match(VARNAME);
			setState(118); match(IN);
			setState(119); xq(0);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(120); match(COMMA);
				setState(121); match(VARNAME);
				setState(122); match(IN);
				setState(123); xq(0);
				}
				}
				setState(128);
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

	public static class LetClauseContext extends ParserRuleContext {
		public List<TerminalNode> ASSIGN() { return getTokens(XQParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(XQParser.ASSIGN, i);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XQParser.COMMA); }
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public TerminalNode VARNAME(int i) {
			return getToken(XQParser.VARNAME, i);
		}
		public List<TerminalNode> VARNAME() { return getTokens(XQParser.VARNAME); }
		public TerminalNode LET() { return getToken(XQParser.LET, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(XQParser.COMMA, i);
		}
		public LetClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterLetClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitLetClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitLetClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetClauseContext letClause() throws RecognitionException {
		LetClauseContext _localctx = new LetClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_letClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); match(LET);
			setState(130); match(VARNAME);
			setState(131); match(ASSIGN);
			setState(132); xq(0);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(133); match(COMMA);
				setState(134); match(VARNAME);
				setState(135); match(ASSIGN);
				setState(136); xq(0);
				}
				}
				setState(141);
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

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(XQParser.WHERE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitWhereClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitWhereClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(WHERE);
			setState(143); cond(0);
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

	public static class ReturnClauseContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(XQParser.RETURN, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitReturnClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitReturnClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(RETURN);
			setState(146); xq(0);
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

	public static class CondContext extends ParserRuleContext {
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
	 
		public CondContext() { }
		public void copyFrom(CondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CondSomeContext extends CondContext {
		public TerminalNode SATISFIES() { return getToken(XQParser.SATISFIES, 0); }
		public TerminalNode IN(int i) {
			return getToken(XQParser.IN, i);
		}
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XQParser.COMMA); }
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode VARNAME(int i) {
			return getToken(XQParser.VARNAME, i);
		}
		public List<TerminalNode> VARNAME() { return getTokens(XQParser.VARNAME); }
		public TerminalNode SOME() { return getToken(XQParser.SOME, 0); }
		public List<TerminalNode> IN() { return getTokens(XQParser.IN); }
		public TerminalNode COMMA(int i) {
			return getToken(XQParser.COMMA, i);
		}
		public CondSomeContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondSome(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondSome(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondIsContext extends CondContext {
		public XqContext left;
		public XqContext right;
		public TerminalNode IS() { return getToken(XQParser.IS, 0); }
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public TerminalNode EQUALITY() { return getToken(XQParser.EQUALITY, 0); }
		public CondIsContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondIs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondIs(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondEBracketContext extends CondContext {
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode EMPTY() { return getToken(XQParser.EMPTY, 0); }
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public CondEBracketContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondEBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondEBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondEBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondBracketContext extends CondContext {
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public CondBracketContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondAndContext extends CondContext {
		public CondContext left;
		public CondContext right;
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public TerminalNode AND() { return getToken(XQParser.AND, 0); }
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondAndContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondOrContext extends CondContext {
		public CondContext left;
		public CondContext right;
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public TerminalNode OR() { return getToken(XQParser.OR, 0); }
		public CondOrContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondNotContext extends CondContext {
		public TerminalNode NOT() { return getToken(XQParser.NOT, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondNotContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CondEqualContext extends CondContext {
		public XqContext left;
		public XqContext right;
		public TerminalNode EQUAL() { return getToken(XQParser.EQUAL, 0); }
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public TerminalNode EQ() { return getToken(XQParser.EQ, 0); }
		public CondEqualContext(CondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterCondEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitCondEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitCondEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_cond, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new CondSomeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(149); match(SOME);
				setState(150); match(VARNAME);
				setState(151); match(IN);
				setState(152); xq(0);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(153); match(COMMA);
					setState(154); match(VARNAME);
					setState(155); match(IN);
					setState(156); xq(0);
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(162); match(SATISFIES);
				setState(163); cond(5);
				}
				break;

			case 2:
				{
				_localctx = new CondNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165); match(NOT);
				setState(166); cond(1);
				}
				break;

			case 3:
				{
				_localctx = new CondEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167); ((CondEqualContext)_localctx).left = xq(0);
				setState(168); match(EQUAL);
				setState(169); ((CondEqualContext)_localctx).right = xq(0);
				}
				break;

			case 4:
				{
				_localctx = new CondEqualContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171); ((CondEqualContext)_localctx).left = xq(0);
				setState(172); match(EQ);
				setState(173); ((CondEqualContext)_localctx).right = xq(0);
				}
				break;

			case 5:
				{
				_localctx = new CondIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175); ((CondIsContext)_localctx).left = xq(0);
				setState(176); match(EQUALITY);
				setState(177); ((CondIsContext)_localctx).right = xq(0);
				}
				break;

			case 6:
				{
				_localctx = new CondIsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(179); ((CondIsContext)_localctx).left = xq(0);
				setState(180); match(IS);
				setState(181); ((CondIsContext)_localctx).right = xq(0);
				}
				break;

			case 7:
				{
				_localctx = new CondEBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183); match(EMPTY);
				setState(184); match(OPENBRACKET);
				setState(185); xq(0);
				setState(186); match(CLOSEBRACKET);
				}
				break;

			case 8:
				{
				_localctx = new CondBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188); match(OPENBRACKET);
				setState(189); cond(0);
				setState(190); match(CLOSEBRACKET);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(200);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new CondAndContext(new CondContext(_parentctx, _parentState));
						((CondAndContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(194);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(195); match(AND);
						setState(196); ((CondAndContext)_localctx).right = cond(4);
						}
						break;

					case 2:
						{
						_localctx = new CondOrContext(new CondContext(_parentctx, _parentState));
						((CondOrContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(197);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(198); match(OR);
						setState(199); ((CondOrContext)_localctx).right = cond(3);
						}
						break;
					}
					} 
				}
				setState(204);
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

	public static class XqsContext extends ParserRuleContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public OxqContext oxq() {
			return getRuleContext(OxqContext.class,0);
		}
		public XqsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xqs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqsContext xqs() throws RecognitionException {
		XqsContext _localctx = new XqsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_xqs);
		try {
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205); oxq();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206); xq(0);
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

	public static class OxqContext extends ParserRuleContext {
		public OxqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oxq; }
	 
		public OxqContext() { }
		public void copyFrom(OxqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RewriteXqContext extends OxqContext {
		public ForJContext forJ() {
			return getRuleContext(ForJContext.class,0);
		}
		public ReturnJContext returnJ() {
			return getRuleContext(ReturnJContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(XQParser.RETURN, 0); }
		public TerminalNode FOR() { return getToken(XQParser.FOR, 0); }
		public TerminalNode WHERE() { return getToken(XQParser.WHERE, 0); }
		public CondJContext condJ() {
			return getRuleContext(CondJContext.class,0);
		}
		public RewriteXqContext(OxqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterRewriteXq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitRewriteXq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitRewriteXq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OxqContext oxq() throws RecognitionException {
		OxqContext _localctx = new OxqContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_oxq);
		try {
			_localctx = new RewriteXqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(209); match(FOR);
			setState(210); forJ();
			setState(211); match(WHERE);
			setState(212); condJ(0);
			setState(213); match(RETURN);
			setState(214); returnJ(0);
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

	public static class XqContext extends ParserRuleContext {
		public XqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xq; }
	 
		public XqContext() { }
		public void copyFrom(XqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class XqApContext extends XqContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public XqApContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqAp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqVarContext extends XqContext {
		public TerminalNode VARNAME() { return getToken(XQParser.VARNAME, 0); }
		public XqVarContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqJoinContext extends XqContext {
		public XqContext left;
		public XqContext right;
		public ListContext leftlist;
		public ListContext rightlist;
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XQParser.COMMA); }
		public ListContext list(int i) {
			return getRuleContext(ListContext.class,i);
		}
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public List<ListContext> list() {
			return getRuleContexts(ListContext.class);
		}
		public TerminalNode JOIN() { return getToken(XQParser.JOIN, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(XQParser.COMMA, i);
		}
		public XqJoinContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqJoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqJoin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqJoin(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqDoubleSlashContext extends XqContext {
		public TerminalNode DOUBLESLASH() { return getToken(XQParser.DOUBLESLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqDoubleSlashContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqDoubleSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqDoubleSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqDoubleSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqStrContext extends XqContext {
		public TerminalNode STRINGCONST() { return getToken(XQParser.STRINGCONST, 0); }
		public XqStrContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqStr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqTagsContext extends XqContext {
		public List<TerminalNode> OPENTAG() { return getTokens(XQParser.OPENTAG); }
		public TerminalNode OPENCURL() { return getToken(XQParser.OPENCURL, 0); }
		public List<TerminalNode> ID() { return getTokens(XQParser.ID); }
		public TerminalNode CLOSETAG(int i) {
			return getToken(XQParser.CLOSETAG, i);
		}
		public TerminalNode OPENTAG(int i) {
			return getToken(XQParser.OPENTAG, i);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode ID(int i) {
			return getToken(XQParser.ID, i);
		}
		public List<TerminalNode> CLOSETAG() { return getTokens(XQParser.CLOSETAG); }
		public TerminalNode CLOSECURL() { return getToken(XQParser.CLOSECURL, 0); }
		public XqTagsContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqTags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqTags(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqTags(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqSlashContext extends XqContext {
		public TerminalNode SINGLESLASH() { return getToken(XQParser.SINGLESLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public XqSlashContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqLetContext extends XqContext {
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqLetContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqBracketContext extends XqContext {
		public TerminalNode OPENBRACKET() { return getToken(XQParser.OPENBRACKET, 0); }
		public XqContext xq() {
			return getRuleContext(XqContext.class,0);
		}
		public TerminalNode CLOSEBRACKET() { return getToken(XQParser.CLOSEBRACKET, 0); }
		public XqBracketContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqBracket(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqBracket(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqBracket(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqComplexContext extends XqContext {
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public LetClauseContext letClause() {
			return getRuleContext(LetClauseContext.class,0);
		}
		public XqComplexContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqComplex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqComplex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqComplex(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class XqCommaContext extends XqContext {
		public XqContext left;
		public XqContext right;
		public XqContext xq(int i) {
			return getRuleContext(XqContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(XQParser.COMMA, 0); }
		public List<XqContext> xq() {
			return getRuleContexts(XqContext.class);
		}
		public XqCommaContext(XqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterXqComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitXqComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitXqComma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XqContext xq() throws RecognitionException {
		return xq(0);
	}

	private XqContext xq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		XqContext _localctx = new XqContext(_ctx, _parentState);
		XqContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_xq, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			switch (_input.LA(1)) {
			case LET:
				{
				_localctx = new XqLetContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(217); letClause();
				setState(218); xq(2);
				}
				break;
			case VARNAME:
				{
				_localctx = new XqVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(220); match(VARNAME);
				}
				break;
			case STRINGCONST:
				{
				_localctx = new XqStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221); match(STRINGCONST);
				}
				break;
			case DOC:
				{
				_localctx = new XqApContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222); ap();
				}
				break;
			case OPENBRACKET:
				{
				_localctx = new XqBracketContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223); match(OPENBRACKET);
				setState(224); xq(0);
				setState(225); match(CLOSEBRACKET);
				}
				break;
			case OPENTAG:
				{
				_localctx = new XqTagsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227); match(OPENTAG);
				setState(228); match(ID);
				setState(229); match(CLOSETAG);
				setState(230); match(OPENCURL);
				setState(231); xq(0);
				setState(232); match(CLOSECURL);
				setState(233); match(OPENTAG);
				setState(234); match(ID);
				setState(235); match(CLOSETAG);
				}
				break;
			case FOR:
				{
				_localctx = new XqComplexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237); forClause();
				setState(239);
				_la = _input.LA(1);
				if (_la==LET) {
					{
					setState(238); letClause();
					}
				}

				setState(242);
				_la = _input.LA(1);
				if (_la==WHERE) {
					{
					setState(241); whereClause();
					}
				}

				setState(244); returnClause();
				}
				break;
			case JOIN:
				{
				_localctx = new XqJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246); match(JOIN);
				setState(247); match(OPENBRACKET);
				setState(248); ((XqJoinContext)_localctx).left = xq(0);
				setState(249); match(COMMA);
				setState(250); ((XqJoinContext)_localctx).right = xq(0);
				setState(251); match(COMMA);
				setState(252); ((XqJoinContext)_localctx).leftlist = list();
				setState(253); match(COMMA);
				setState(254); ((XqJoinContext)_localctx).rightlist = list();
				setState(255); match(CLOSEBRACKET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(270);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(268);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new XqCommaContext(new XqContext(_parentctx, _parentState));
						((XqCommaContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(259);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(260); match(COMMA);
						setState(261); ((XqCommaContext)_localctx).right = xq(8);
						}
						break;

					case 2:
						{
						_localctx = new XqSlashContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(262);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(263); match(SINGLESLASH);
						setState(264); rp(0);
						}
						break;

					case 3:
						{
						_localctx = new XqDoubleSlashContext(new XqContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_xq);
						setState(265);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(266); match(DOUBLESLASH);
						setState(267); rp(0);
						}
						break;
					}
					} 
				}
				setState(272);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class ListContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(XQParser.ID); }
		public TerminalNode CLOSESQ() { return getToken(XQParser.CLOSESQ, 0); }
		public List<TerminalNode> COMMA() { return getTokens(XQParser.COMMA); }
		public TerminalNode ID(int i) {
			return getToken(XQParser.ID, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(XQParser.COMMA, i);
		}
		public TerminalNode OPENSQ() { return getToken(XQParser.OPENSQ, 0); }
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); match(OPENSQ);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(274); match(ID);
				setState(279);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(275); match(COMMA);
					setState(276); match(ID);
					}
					}
					setState(281);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(287); match(CLOSESQ);
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

	public static class ForJContext extends ParserRuleContext {
		public ForJContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forJ; }
	 
		public ForJContext() { }
		public void copyFrom(ForJContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class JforContext extends ForJContext {
		public TerminalNode IN(int i) {
			return getToken(XQParser.IN, i);
		}
		public PathContext path(int i) {
			return getRuleContext(PathContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(XQParser.COMMA); }
		public TerminalNode VARNAME(int i) {
			return getToken(XQParser.VARNAME, i);
		}
		public List<TerminalNode> VARNAME() { return getTokens(XQParser.VARNAME); }
		public List<PathContext> path() {
			return getRuleContexts(PathContext.class);
		}
		public List<TerminalNode> IN() { return getTokens(XQParser.IN); }
		public TerminalNode COMMA(int i) {
			return getToken(XQParser.COMMA, i);
		}
		public JforContext(ForJContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterJfor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitJfor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitJfor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForJContext forJ() throws RecognitionException {
		ForJContext _localctx = new ForJContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forJ);
		int _la;
		try {
			_localctx = new JforContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(289); match(VARNAME);
			setState(290); match(IN);
			setState(291); path();
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292); match(COMMA);
				setState(293); match(VARNAME);
				setState(294); match(IN);
				setState(295); path();
				}
				}
				setState(300);
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

	public static class PathContext extends ParserRuleContext {
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
	 
		public PathContext() { }
		public void copyFrom(PathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PathDSlashContext extends PathContext {
		public TerminalNode DOUBLESLASH() { return getToken(XQParser.DOUBLESLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode VARNAME() { return getToken(XQParser.VARNAME, 0); }
		public PathDSlashContext(PathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterPathDSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitPathDSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitPathDSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PathSlashContext extends PathContext {
		public TerminalNode SINGLESLASH() { return getToken(XQParser.SINGLESLASH, 0); }
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode VARNAME() { return getToken(XQParser.VARNAME, 0); }
		public PathSlashContext(PathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterPathSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitPathSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitPathSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PathApContext extends PathContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public PathApContext(PathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterPathAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitPathAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitPathAp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_path);
		try {
			setState(308);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new PathApContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(301); ap();
				}
				break;

			case 2:
				_localctx = new PathSlashContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(302); match(VARNAME);
				setState(303); match(SINGLESLASH);
				setState(304); rp(0);
				}
				break;

			case 3:
				_localctx = new PathDSlashContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(305); match(VARNAME);
				setState(306); match(DOUBLESLASH);
				setState(307); rp(0);
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

	public static class CondJContext extends ParserRuleContext {
		public CondJContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condJ; }
	 
		public CondJContext() { }
		public void copyFrom(CondJContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class JEqContext extends CondJContext {
		public Token left;
		public Token right;
		public TerminalNode EQUAL() { return getToken(XQParser.EQUAL, 0); }
		public TerminalNode EQ() { return getToken(XQParser.EQ, 0); }
		public TerminalNode VARNAME(int i) {
			return getToken(XQParser.VARNAME, i);
		}
		public List<TerminalNode> VARNAME() { return getTokens(XQParser.VARNAME); }
		public JEqContext(CondJContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterJEq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitJEq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitJEq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JEqSContext extends CondJContext {
		public TerminalNode EQUAL() { return getToken(XQParser.EQUAL, 0); }
		public TerminalNode STRINGCONST() { return getToken(XQParser.STRINGCONST, 0); }
		public TerminalNode EQ() { return getToken(XQParser.EQ, 0); }
		public TerminalNode VARNAME() { return getToken(XQParser.VARNAME, 0); }
		public JEqSContext(CondJContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterJEqS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitJEqS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitJEqS(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JAndContext extends CondJContext {
		public CondJContext lt;
		public CondJContext rt;
		public CondJContext condJ(int i) {
			return getRuleContext(CondJContext.class,i);
		}
		public TerminalNode AND() { return getToken(XQParser.AND, 0); }
		public List<CondJContext> condJ() {
			return getRuleContexts(CondJContext.class);
		}
		public JAndContext(CondJContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterJAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitJAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitJAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondJContext condJ() throws RecognitionException {
		return condJ(0);
	}

	private CondJContext condJ(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondJContext _localctx = new CondJContext(_ctx, _parentState);
		CondJContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_condJ, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new JEqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(311); ((JEqContext)_localctx).left = match(VARNAME);
				setState(312); match(EQ);
				setState(313); ((JEqContext)_localctx).right = match(VARNAME);
				}
				break;

			case 2:
				{
				_localctx = new JEqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(314); ((JEqContext)_localctx).left = match(VARNAME);
				setState(315); match(EQUAL);
				setState(316); ((JEqContext)_localctx).right = match(VARNAME);
				}
				break;

			case 3:
				{
				_localctx = new JEqSContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317); match(VARNAME);
				setState(318); match(EQ);
				setState(319); match(STRINGCONST);
				}
				break;

			case 4:
				{
				_localctx = new JEqSContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(320); match(VARNAME);
				setState(321); match(EQUAL);
				setState(322); match(STRINGCONST);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new JAndContext(new CondJContext(_parentctx, _parentState));
					((JAndContext)_localctx).lt = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_condJ);
					setState(325);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(326); match(AND);
					setState(327); ((JAndContext)_localctx).rt = condJ(4);
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public static class ReturnJContext extends ParserRuleContext {
		public Token lt;
		public Token rt;
		public List<TerminalNode> OPENTAG() { return getTokens(XQParser.OPENTAG); }
		public TerminalNode OPENCURL() { return getToken(XQParser.OPENCURL, 0); }
		public TerminalNode OPENTAG(int i) {
			return getToken(XQParser.OPENTAG, i);
		}
		public List<TerminalNode> OPENBRACKET() { return getTokens(XQParser.OPENBRACKET); }
		public ReturnJContext returnJ(int i) {
			return getRuleContext(ReturnJContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(XQParser.ID, i);
		}
		public TerminalNode VARNAME() { return getToken(XQParser.VARNAME, 0); }
		public List<TerminalNode> CLOSEBRACKET() { return getTokens(XQParser.CLOSEBRACKET); }
		public List<TerminalNode> CLOSETAG() { return getTokens(XQParser.CLOSETAG); }
		public TerminalNode CLOSECURL() { return getToken(XQParser.CLOSECURL, 0); }
		public List<ReturnJContext> returnJ() {
			return getRuleContexts(ReturnJContext.class);
		}
		public TerminalNode CLOSEBRACKET(int i) {
			return getToken(XQParser.CLOSEBRACKET, i);
		}
		public List<TerminalNode> ID() { return getTokens(XQParser.ID); }
		public TerminalNode CLOSETAG(int i) {
			return getToken(XQParser.CLOSETAG, i);
		}
		public TerminalNode COMMA() { return getToken(XQParser.COMMA, 0); }
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TerminalNode OPENBRACKET(int i) {
			return getToken(XQParser.OPENBRACKET, i);
		}
		public ReturnJContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnJ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).enterReturnJ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQParserListener ) ((XQParserListener)listener).exitReturnJ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XQParserVisitor ) return ((XQParserVisitor<? extends T>)visitor).visitReturnJ(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnJContext returnJ() throws RecognitionException {
		return returnJ(0);
	}

	private ReturnJContext returnJ(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ReturnJContext _localctx = new ReturnJContext(_ctx, _parentState);
		ReturnJContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_returnJ, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(334); path();
				}
				break;

			case 2:
				{
				setState(335); match(VARNAME);
				}
				break;

			case 3:
				{
				setState(336); match(OPENBRACKET);
				setState(337); returnJ(0);
				setState(338); match(CLOSEBRACKET);
				setState(339); match(COMMA);
				setState(340); match(OPENBRACKET);
				setState(341); returnJ(0);
				setState(342); match(CLOSEBRACKET);
				}
				break;

			case 4:
				{
				setState(344); match(OPENTAG);
				setState(345); ((ReturnJContext)_localctx).lt = match(ID);
				setState(346); match(CLOSETAG);
				setState(347); match(OPENCURL);
				setState(348); returnJ(0);
				setState(349); match(CLOSECURL);
				setState(350); match(OPENTAG);
				setState(351); ((ReturnJContext)_localctx).rt = match(ID);
				setState(352); match(CLOSETAG);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(361);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ReturnJContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_returnJ);
					setState(356);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(357); match(COMMA);
					setState(358); returnJ(3);
					}
					} 
				}
				setState(363);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return rp_sempred((RpContext)_localctx, predIndex);

		case 2: return f_sempred((FContext)_localctx, predIndex);

		case 7: return cond_sempred((CondContext)_localctx, predIndex);

		case 10: return xq_sempred((XqContext)_localctx, predIndex);

		case 14: return condJ_sempred((CondJContext)_localctx, predIndex);

		case 15: return returnJ_sempred((ReturnJContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean returnJ_sempred(ReturnJContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return precpred(_ctx, 3);

		case 5: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean xq_sempred(XqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return precpred(_ctx, 7);

		case 9: return precpred(_ctx, 6);

		case 10: return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return precpred(_ctx, 3);

		case 7: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 4);

		case 1: return precpred(_ctx, 3);

		case 2: return precpred(_ctx, 1);

		case 3: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean condJ_sempred(CondJContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11: return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3)\u016f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2/\n\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\7\3M\n\3\f\3\16\3P\13\3\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4j\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4r\n\4\f\4\16\4u\13\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\7\5\177\n\5\f\5\16\5\u0082\13\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6\u008c\n\6\f\6\16\6\u008f\13\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00a0\n\t\f\t\16\t\u00a3"+
		"\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c3\n\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00cb\n\t\f\t\16\t\u00ce\13\t\3\n\3\n\5\n"+
		"\u00d2\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5"+
		"\f\u00f2\n\f\3\f\5\f\u00f5\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u0104\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u010f"+
		"\n\f\f\f\16\f\u0112\13\f\3\r\3\r\3\r\3\r\7\r\u0118\n\r\f\r\16\r\u011b"+
		"\13\r\7\r\u011d\n\r\f\r\16\r\u0120\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\7\16\u012b\n\16\f\16\16\16\u012e\13\16\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\5\17\u0137\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0146\n\20\3\20\3\20\3\20\7\20\u014b"+
		"\n\20\f\20\16\20\u014e\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0165"+
		"\n\21\3\21\3\21\3\21\7\21\u016a\n\21\f\21\16\21\u016d\13\21\3\21\2\b\4"+
		"\6\20\26\36 \22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\u0197\2.\3"+
		"\2\2\2\4<\3\2\2\2\6i\3\2\2\2\bv\3\2\2\2\n\u0083\3\2\2\2\f\u0090\3\2\2"+
		"\2\16\u0093\3\2\2\2\20\u00c2\3\2\2\2\22\u00d1\3\2\2\2\24\u00d3\3\2\2\2"+
		"\26\u0103\3\2\2\2\30\u0113\3\2\2\2\32\u0123\3\2\2\2\34\u0136\3\2\2\2\36"+
		"\u0145\3\2\2\2 \u0164\3\2\2\2\"#\7\4\2\2#$\7\7\2\2$%\7(\2\2%&\7\b\2\2"+
		"&\'\7\5\2\2\'/\5\4\3\2()\7\4\2\2)*\7\7\2\2*+\7(\2\2+,\7\b\2\2,-\7\6\2"+
		"\2-/\5\4\3\2.\"\3\2\2\2.(\3\2\2\2/\3\3\2\2\2\60\61\b\3\1\2\61=\7\'\2\2"+
		"\62=\7\25\2\2\63=\7\26\2\2\64=\7\27\2\2\65=\7\n\2\2\66\67\7\30\2\2\67"+
		"=\7\'\2\289\7\7\2\29:\5\4\3\2:;\7\b\2\2;=\3\2\2\2<\60\3\2\2\2<\62\3\2"+
		"\2\2<\63\3\2\2\2<\64\3\2\2\2<\65\3\2\2\2<\66\3\2\2\2<8\3\2\2\2=N\3\2\2"+
		"\2>?\f\6\2\2?@\7\5\2\2@M\5\4\3\7AB\f\5\2\2BC\7\6\2\2CM\5\4\3\6DE\f\3\2"+
		"\2EF\7\t\2\2FM\5\4\3\4GH\f\4\2\2HI\7\31\2\2IJ\5\6\4\2JK\7\32\2\2KM\3\2"+
		"\2\2L>\3\2\2\2LA\3\2\2\2LD\3\2\2\2LG\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2"+
		"\2\2O\5\3\2\2\2PN\3\2\2\2QR\b\4\1\2RS\7\23\2\2Sj\5\6\4\3Tj\5\4\3\2UV\5"+
		"\4\3\2VW\7\33\2\2WX\5\4\3\2Xj\3\2\2\2YZ\5\4\3\2Z[\7\24\2\2[\\\5\4\3\2"+
		"\\j\3\2\2\2]^\5\4\3\2^_\7\34\2\2_`\5\4\3\2`j\3\2\2\2ab\5\4\3\2bc\7\20"+
		"\2\2cd\5\4\3\2dj\3\2\2\2ef\7\7\2\2fg\5\6\4\2gh\7\b\2\2hj\3\2\2\2iQ\3\2"+
		"\2\2iT\3\2\2\2iU\3\2\2\2iY\3\2\2\2i]\3\2\2\2ia\3\2\2\2ie\3\2\2\2js\3\2"+
		"\2\2kl\f\5\2\2lm\7\21\2\2mr\5\6\4\6no\f\4\2\2op\7\22\2\2pr\5\6\4\5qk\3"+
		"\2\2\2qn\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\7\3\2\2\2us\3\2\2\2vw"+
		"\7\13\2\2wx\7)\2\2xy\7\17\2\2y\u0080\5\26\f\2z{\7\t\2\2{|\7)\2\2|}\7\17"+
		"\2\2}\177\5\26\f\2~z\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\t\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\f\2\2\u0084"+
		"\u0085\7)\2\2\u0085\u0086\7\35\2\2\u0086\u008d\5\26\f\2\u0087\u0088\7"+
		"\t\2\2\u0088\u0089\7)\2\2\u0089\u008a\7\35\2\2\u008a\u008c\5\26\f\2\u008b"+
		"\u0087\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\13\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\r\2\2\u0091\u0092"+
		"\5\20\t\2\u0092\r\3\2\2\2\u0093\u0094\7\16\2\2\u0094\u0095\5\26\f\2\u0095"+
		"\17\3\2\2\2\u0096\u0097\b\t\1\2\u0097\u0098\7\36\2\2\u0098\u0099\7)\2"+
		"\2\u0099\u009a\7\17\2\2\u009a\u00a1\5\26\f\2\u009b\u009c\7\t\2\2\u009c"+
		"\u009d\7)\2\2\u009d\u009e\7\17\2\2\u009e\u00a0\5\26\f\2\u009f\u009b\3"+
		"\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7 \2\2\u00a5\u00a6\5\20"+
		"\t\7\u00a6\u00c3\3\2\2\2\u00a7\u00a8\7\23\2\2\u00a8\u00c3\5\20\t\3\u00a9"+
		"\u00aa\5\26\f\2\u00aa\u00ab\7\33\2\2\u00ab\u00ac\5\26\f\2\u00ac\u00c3"+
		"\3\2\2\2\u00ad\u00ae\5\26\f\2\u00ae\u00af\7\24\2\2\u00af\u00b0\5\26\f"+
		"\2\u00b0\u00c3\3\2\2\2\u00b1\u00b2\5\26\f\2\u00b2\u00b3\7\34\2\2\u00b3"+
		"\u00b4\5\26\f\2\u00b4\u00c3\3\2\2\2\u00b5\u00b6\5\26\f\2\u00b6\u00b7\7"+
		"\20\2\2\u00b7\u00b8\5\26\f\2\u00b8\u00c3\3\2\2\2\u00b9\u00ba\7!\2\2\u00ba"+
		"\u00bb\7\7\2\2\u00bb\u00bc\5\26\f\2\u00bc\u00bd\7\b\2\2\u00bd\u00c3\3"+
		"\2\2\2\u00be\u00bf\7\7\2\2\u00bf\u00c0\5\20\t\2\u00c0\u00c1\7\b\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u0096\3\2\2\2\u00c2\u00a7\3\2\2\2\u00c2\u00a9\3\2"+
		"\2\2\u00c2\u00ad\3\2\2\2\u00c2\u00b1\3\2\2\2\u00c2\u00b5\3\2\2\2\u00c2"+
		"\u00b9\3\2\2\2\u00c2\u00be\3\2\2\2\u00c3\u00cc\3\2\2\2\u00c4\u00c5\f\5"+
		"\2\2\u00c5\u00c6\7\21\2\2\u00c6\u00cb\5\20\t\6\u00c7\u00c8\f\4\2\2\u00c8"+
		"\u00c9\7\22\2\2\u00c9\u00cb\5\20\t\5\u00ca\u00c4\3\2\2\2\u00ca\u00c7\3"+
		"\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\21\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\5\24\13\2\u00d0\u00d2\5\26"+
		"\f\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\23\3\2\2\2\u00d3\u00d4"+
		"\7\13\2\2\u00d4\u00d5\5\32\16\2\u00d5\u00d6\7\r\2\2\u00d6\u00d7\5\36\20"+
		"\2\u00d7\u00d8\7\16\2\2\u00d8\u00d9\5 \21\2\u00d9\25\3\2\2\2\u00da\u00db"+
		"\b\f\1\2\u00db\u00dc\5\n\6\2\u00dc\u00dd\5\26\f\4\u00dd\u0104\3\2\2\2"+
		"\u00de\u0104\7)\2\2\u00df\u0104\7(\2\2\u00e0\u0104\5\2\2\2\u00e1\u00e2"+
		"\7\7\2\2\u00e2\u00e3\5\26\f\2\u00e3\u00e4\7\b\2\2\u00e4\u0104\3\2\2\2"+
		"\u00e5\u00e6\7\"\2\2\u00e6\u00e7\7\'\2\2\u00e7\u00e8\7#\2\2\u00e8\u00e9"+
		"\7$\2\2\u00e9\u00ea\5\26\f\2\u00ea\u00eb\7%\2\2\u00eb\u00ec\7\"\2\2\u00ec"+
		"\u00ed\7\'\2\2\u00ed\u00ee\7#\2\2\u00ee\u0104\3\2\2\2\u00ef\u00f1\5\b"+
		"\5\2\u00f0\u00f2\5\n\6\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f4\3\2\2\2\u00f3\u00f5\5\f\7\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\5\16\b\2\u00f7\u0104\3\2\2\2\u00f8"+
		"\u00f9\7\37\2\2\u00f9\u00fa\7\7\2\2\u00fa\u00fb\5\26\f\2\u00fb\u00fc\7"+
		"\t\2\2\u00fc\u00fd\5\26\f\2\u00fd\u00fe\7\t\2\2\u00fe\u00ff\5\30\r\2\u00ff"+
		"\u0100\7\t\2\2\u0100\u0101\5\30\r\2\u0101\u0102\7\b\2\2\u0102\u0104\3"+
		"\2\2\2\u0103\u00da\3\2\2\2\u0103\u00de\3\2\2\2\u0103\u00df\3\2\2\2\u0103"+
		"\u00e0\3\2\2\2\u0103\u00e1\3\2\2\2\u0103\u00e5\3\2\2\2\u0103\u00ef\3\2"+
		"\2\2\u0103\u00f8\3\2\2\2\u0104\u0110\3\2\2\2\u0105\u0106\f\t\2\2\u0106"+
		"\u0107\7\t\2\2\u0107\u010f\5\26\f\n\u0108\u0109\f\b\2\2\u0109\u010a\7"+
		"\5\2\2\u010a\u010f\5\4\3\2\u010b\u010c\f\7\2\2\u010c\u010d\7\6\2\2\u010d"+
		"\u010f\5\4\3\2\u010e\u0105\3\2\2\2\u010e\u0108\3\2\2\2\u010e\u010b\3\2"+
		"\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		"\27\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u011e\7\31\2\2\u0114\u0119\7\'\2"+
		"\2\u0115\u0116\7\t\2\2\u0116\u0118\7\'\2\2\u0117\u0115\3\2\2\2\u0118\u011b"+
		"\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c\u0114\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121"+
		"\u0122\7\32\2\2\u0122\31\3\2\2\2\u0123\u0124\7)\2\2\u0124\u0125\7\17\2"+
		"\2\u0125\u012c\5\34\17\2\u0126\u0127\7\t\2\2\u0127\u0128\7)\2\2\u0128"+
		"\u0129\7\17\2\2\u0129\u012b\5\34\17\2\u012a\u0126\3\2\2\2\u012b\u012e"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\33\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012f\u0137\5\2\2\2\u0130\u0131\7)\2\2\u0131\u0132\7\5"+
		"\2\2\u0132\u0137\5\4\3\2\u0133\u0134\7)\2\2\u0134\u0135\7\6\2\2\u0135"+
		"\u0137\5\4\3\2\u0136\u012f\3\2\2\2\u0136\u0130\3\2\2\2\u0136\u0133\3\2"+
		"\2\2\u0137\35\3\2\2\2\u0138\u0139\b\20\1\2\u0139\u013a\7)\2\2\u013a\u013b"+
		"\7\24\2\2\u013b\u0146\7)\2\2\u013c\u013d\7)\2\2\u013d\u013e\7\33\2\2\u013e"+
		"\u0146\7)\2\2\u013f\u0140\7)\2\2\u0140\u0141\7\24\2\2\u0141\u0146\7(\2"+
		"\2\u0142\u0143\7)\2\2\u0143\u0144\7\33\2\2\u0144\u0146\7(\2\2\u0145\u0138"+
		"\3\2\2\2\u0145\u013c\3\2\2\2\u0145\u013f\3\2\2\2\u0145\u0142\3\2\2\2\u0146"+
		"\u014c\3\2\2\2\u0147\u0148\f\5\2\2\u0148\u0149\7\21\2\2\u0149\u014b\5"+
		"\36\20\6\u014a\u0147\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c"+
		"\u014d\3\2\2\2\u014d\37\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\b\21\1"+
		"\2\u0150\u0165\5\34\17\2\u0151\u0165\7)\2\2\u0152\u0153\7\7\2\2\u0153"+
		"\u0154\5 \21\2\u0154\u0155\7\b\2\2\u0155\u0156\7\t\2\2\u0156\u0157\7\7"+
		"\2\2\u0157\u0158\5 \21\2\u0158\u0159\7\b\2\2\u0159\u0165\3\2\2\2\u015a"+
		"\u015b\7\"\2\2\u015b\u015c\7\'\2\2\u015c\u015d\7#\2\2\u015d\u015e\7$\2"+
		"\2\u015e\u015f\5 \21\2\u015f\u0160\7%\2\2\u0160\u0161\7\"\2\2\u0161\u0162"+
		"\7\'\2\2\u0162\u0163\7#\2\2\u0163\u0165\3\2\2\2\u0164\u014f\3\2\2\2\u0164"+
		"\u0151\3\2\2\2\u0164\u0152\3\2\2\2\u0164\u015a\3\2\2\2\u0165\u016b\3\2"+
		"\2\2\u0166\u0167\f\4\2\2\u0167\u0168\7\t\2\2\u0168\u016a\5 \21\5\u0169"+
		"\u0166\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c!\3\2\2\2\u016d\u016b\3\2\2\2\35.<LNiqs\u0080\u008d\u00a1\u00c2"+
		"\u00ca\u00cc\u00d1\u00f1\u00f4\u0103\u010e\u0110\u0119\u011e\u012c\u0136"+
		"\u0145\u014c\u0164\u016b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}