// Generated from \\snb.ch\Users\rko\Downloads\Cymbol.g4 by ANTLR 4.1
package com.dsl.cymbol;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CymbolLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__20=1, T__19=2, T__18=3, T__17=4, T__16=5, T__15=6, T__14=7, T__13=8, 
		T__12=9, T__11=10, T__10=11, T__9=12, T__8=13, T__7=14, T__6=15, T__5=16, 
		T__4=17, T__3=18, T__2=19, T__1=20, T__0=21, ID=22, INT=23, WS=24, SL_COMMENT=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"']'", "')'", "','", "'+'", "'['", "'-'", "'*'", "'('", "'if'", "'int'", 
		"'='", "'return'", "';'", "'void'", "'{'", "'then'", "'else'", "'=='", 
		"'}'", "'float'", "'!'", "ID", "INT", "WS", "SL_COMMENT"
	};
	public static final String[] ruleNames = {
		"T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", "T__13", 
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "ID", "LETTER", "INT", "WS", "SL_COMMENT"
	};


	    public static final int WHITESPACE = 1;
	    public static final int COMMENTS = 2;


	public CymbolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cymbol.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 24: WS_action((RuleContext)_localctx, actionIndex); break;

		case 25: SL_COMMENT_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: _channel = WHITESPACE;  break;
		}
	}
	private void SL_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: _channel = COMMENTS;  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\33\u009a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\7\27{\n\27\f\27"+
		"\16\27~\13\27\3\30\3\30\3\31\6\31\u0083\n\31\r\31\16\31\u0084\3\32\6\32"+
		"\u0088\n\32\r\32\16\32\u0089\3\32\3\32\3\33\3\33\3\33\3\33\7\33\u0092"+
		"\n\33\f\33\16\33\u0095\13\33\3\33\3\33\3\33\3\33\3\u0093\34\3\3\1\5\4"+
		"\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16"+
		"\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1"+
		"/\2\1\61\31\1\63\32\2\65\33\3\3\2\5\3\2\62;\4\2C\\c|\5\2\13\f\17\17\""+
		"\"\u009d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3\2"+
		"\2\2\t=\3\2\2\2\13?\3\2\2\2\rA\3\2\2\2\17C\3\2\2\2\21E\3\2\2\2\23G\3\2"+
		"\2\2\25J\3\2\2\2\27N\3\2\2\2\31P\3\2\2\2\33W\3\2\2\2\35Y\3\2\2\2\37^\3"+
		"\2\2\2!`\3\2\2\2#e\3\2\2\2%j\3\2\2\2\'m\3\2\2\2)o\3\2\2\2+u\3\2\2\2-w"+
		"\3\2\2\2/\177\3\2\2\2\61\u0082\3\2\2\2\63\u0087\3\2\2\2\65\u008d\3\2\2"+
		"\2\678\7_\2\28\4\3\2\2\29:\7+\2\2:\6\3\2\2\2;<\7.\2\2<\b\3\2\2\2=>\7-"+
		"\2\2>\n\3\2\2\2?@\7]\2\2@\f\3\2\2\2AB\7/\2\2B\16\3\2\2\2CD\7,\2\2D\20"+
		"\3\2\2\2EF\7*\2\2F\22\3\2\2\2GH\7k\2\2HI\7h\2\2I\24\3\2\2\2JK\7k\2\2K"+
		"L\7p\2\2LM\7v\2\2M\26\3\2\2\2NO\7?\2\2O\30\3\2\2\2PQ\7t\2\2QR\7g\2\2R"+
		"S\7v\2\2ST\7w\2\2TU\7t\2\2UV\7p\2\2V\32\3\2\2\2WX\7=\2\2X\34\3\2\2\2Y"+
		"Z\7x\2\2Z[\7q\2\2[\\\7k\2\2\\]\7f\2\2]\36\3\2\2\2^_\7}\2\2_ \3\2\2\2`"+
		"a\7v\2\2ab\7j\2\2bc\7g\2\2cd\7p\2\2d\"\3\2\2\2ef\7g\2\2fg\7n\2\2gh\7u"+
		"\2\2hi\7g\2\2i$\3\2\2\2jk\7?\2\2kl\7?\2\2l&\3\2\2\2mn\7\177\2\2n(\3\2"+
		"\2\2op\7h\2\2pq\7n\2\2qr\7q\2\2rs\7c\2\2st\7v\2\2t*\3\2\2\2uv\7#\2\2v"+
		",\3\2\2\2w|\5/\30\2x{\5/\30\2y{\t\2\2\2zx\3\2\2\2zy\3\2\2\2{~\3\2\2\2"+
		"|z\3\2\2\2|}\3\2\2\2}.\3\2\2\2~|\3\2\2\2\177\u0080\t\3\2\2\u0080\60\3"+
		"\2\2\2\u0081\u0083\t\2\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\62\3\2\2\2\u0086\u0088\t\4\2"+
		"\2\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\32\2\2\u008c\64\3\2\2\2\u008d"+
		"\u008e\7\61\2\2\u008e\u008f\7\61\2\2\u008f\u0093\3\2\2\2\u0090\u0092\13"+
		"\2\2\2\u0091\u0090\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0094\3\2\2\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0097\7\f"+
		"\2\2\u0097\u0098\3\2\2\2\u0098\u0099\b\33\3\2\u0099\66\3\2\2\2\b\2z|\u0084"+
		"\u0089\u0093";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}