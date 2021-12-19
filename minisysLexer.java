// Generated from C:/Users/yung/IdeaProjects/untitled3\minisys.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class minisysLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, WhiteSpace=22, DecimalConst=23, 
		OctalConst=24, HexadecimalConst=25, Ident=26, Nondigit=27, HexadecimalPrefix=28, 
		NonzeroDigit=29, OctalDigit=30, Digit=31, HexadecimalDigit=32, Add=33, 
		Sub=34, Mult=35, Div=36, Mod=37, EqExpSymbol=38, RelExpSymbol=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "WhiteSpace", "DecimalConst", "DecimalConst_", 
			"OctalConst", "OctalConst_", "HexadecimalConst", "HexadecimalConst_", 
			"Ident", "Ident_", "Nondigit", "HexadecimalPrefix", "NonzeroDigit", "OctalDigit", 
			"Digit", "HexadecimalDigit", "Add", "Sub", "Mult", "Div", "Mod", "EqExpSymbol", 
			"RelExpSymbol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'const'", "','", "';'", "'['", "']'", "'='", "'{'", 
			"'}'", "'int'", "'main'", "'return'", "'if'", "'else'", "'while'", "'break'", 
			"'continue'", "'&&'", "'||'", "'!'", null, null, null, null, null, null, 
			null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "WhiteSpace", 
			"DecimalConst", "OctalConst", "HexadecimalConst", "Ident", "Nondigit", 
			"HexadecimalPrefix", "NonzeroDigit", "OctalDigit", "Digit", "HexadecimalDigit", 
			"Add", "Sub", "Mult", "Div", "Mod", "EqExpSymbol", "RelExpSymbol"
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


	public minisysLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "minisys.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u00fb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\5\31\u00b1"+
		"\n\31\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u00b9\n\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\5\35\u00c2\n\35\3\36\3\36\3\36\3\37\3\37\3\37\5\37\u00ca"+
		"\n\37\3\37\3\37\3\37\5\37\u00cf\n\37\5\37\u00d1\n\37\3 \3 \3!\3!\3!\3"+
		"!\5!\u00d9\n!\3\"\3\"\3#\3#\3$\3$\5$\u00e1\n$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3*\3*\3+\3+\3+\3+\5+\u00f3\n+\3,\3,\3,\3,\3,\5,\u00fa\n,\2\2-"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\2\63\32\65\2\67\339\2;\34="+
		"\2?\35A\36C\37E G!I\"K#M$O%Q&S\'U(W)\3\2\6\5\2\13\f\17\17\"\"\5\2C\\a"+
		"ac|\5\2\62;CHch\4\2>>@@\2\u0101\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\63\3\2\2\2\2\67\3\2\2\2\2;\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2"+
		"\2\2\3Y\3\2\2\2\5[\3\2\2\2\7]\3\2\2\2\tc\3\2\2\2\13e\3\2\2\2\rg\3\2\2"+
		"\2\17i\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25o\3\2\2\2\27q\3\2\2\2\31u\3\2"+
		"\2\2\33z\3\2\2\2\35\u0081\3\2\2\2\37\u0084\3\2\2\2!\u0089\3\2\2\2#\u008f"+
		"\3\2\2\2%\u0095\3\2\2\2\'\u009e\3\2\2\2)\u00a1\3\2\2\2+\u00a4\3\2\2\2"+
		"-\u00a6\3\2\2\2/\u00aa\3\2\2\2\61\u00b0\3\2\2\2\63\u00b2\3\2\2\2\65\u00b8"+
		"\3\2\2\2\67\u00ba\3\2\2\29\u00c1\3\2\2\2;\u00c3\3\2\2\2=\u00d0\3\2\2\2"+
		"?\u00d2\3\2\2\2A\u00d8\3\2\2\2C\u00da\3\2\2\2E\u00dc\3\2\2\2G\u00e0\3"+
		"\2\2\2I\u00e2\3\2\2\2K\u00e4\3\2\2\2M\u00e6\3\2\2\2O\u00e8\3\2\2\2Q\u00ea"+
		"\3\2\2\2S\u00ec\3\2\2\2U\u00f2\3\2\2\2W\u00f9\3\2\2\2YZ\7*\2\2Z\4\3\2"+
		"\2\2[\\\7+\2\2\\\6\3\2\2\2]^\7e\2\2^_\7q\2\2_`\7p\2\2`a\7u\2\2ab\7v\2"+
		"\2b\b\3\2\2\2cd\7.\2\2d\n\3\2\2\2ef\7=\2\2f\f\3\2\2\2gh\7]\2\2h\16\3\2"+
		"\2\2ij\7_\2\2j\20\3\2\2\2kl\7?\2\2l\22\3\2\2\2mn\7}\2\2n\24\3\2\2\2op"+
		"\7\177\2\2p\26\3\2\2\2qr\7k\2\2rs\7p\2\2st\7v\2\2t\30\3\2\2\2uv\7o\2\2"+
		"vw\7c\2\2wx\7k\2\2xy\7p\2\2y\32\3\2\2\2z{\7t\2\2{|\7g\2\2|}\7v\2\2}~\7"+
		"w\2\2~\177\7t\2\2\177\u0080\7p\2\2\u0080\34\3\2\2\2\u0081\u0082\7k\2\2"+
		"\u0082\u0083\7h\2\2\u0083\36\3\2\2\2\u0084\u0085\7g\2\2\u0085\u0086\7"+
		"n\2\2\u0086\u0087\7u\2\2\u0087\u0088\7g\2\2\u0088 \3\2\2\2\u0089\u008a"+
		"\7y\2\2\u008a\u008b\7j\2\2\u008b\u008c\7k\2\2\u008c\u008d\7n\2\2\u008d"+
		"\u008e\7g\2\2\u008e\"\3\2\2\2\u008f\u0090\7d\2\2\u0090\u0091\7t\2\2\u0091"+
		"\u0092\7g\2\2\u0092\u0093\7c\2\2\u0093\u0094\7m\2\2\u0094$\3\2\2\2\u0095"+
		"\u0096\7e\2\2\u0096\u0097\7q\2\2\u0097\u0098\7p\2\2\u0098\u0099\7v\2\2"+
		"\u0099\u009a\7k\2\2\u009a\u009b\7p\2\2\u009b\u009c\7w\2\2\u009c\u009d"+
		"\7g\2\2\u009d&\3\2\2\2\u009e\u009f\7(\2\2\u009f\u00a0\7(\2\2\u00a0(\3"+
		"\2\2\2\u00a1\u00a2\7~\2\2\u00a2\u00a3\7~\2\2\u00a3*\3\2\2\2\u00a4\u00a5"+
		"\7#\2\2\u00a5,\3\2\2\2\u00a6\u00a7\t\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9"+
		"\b\27\2\2\u00a9.\3\2\2\2\u00aa\u00ab\5C\"\2\u00ab\u00ac\5\61\31\2\u00ac"+
		"\60\3\2\2\2\u00ad\u00ae\5G$\2\u00ae\u00af\5\61\31\2\u00af\u00b1\3\2\2"+
		"\2\u00b0\u00ad\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\62\3\2\2\2\u00b2\u00b3"+
		"\7\62\2\2\u00b3\u00b4\5\65\33\2\u00b4\64\3\2\2\2\u00b5\u00b6\5E#\2\u00b6"+
		"\u00b7\5\65\33\2\u00b7\u00b9\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b8\u00b9\3"+
		"\2\2\2\u00b9\66\3\2\2\2\u00ba\u00bb\5A!\2\u00bb\u00bc\5I%\2\u00bc\u00bd"+
		"\59\35\2\u00bd8\3\2\2\2\u00be\u00bf\5I%\2\u00bf\u00c0\59\35\2\u00c0\u00c2"+
		"\3\2\2\2\u00c1\u00be\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2:\3\2\2\2\u00c3"+
		"\u00c4\5? \2\u00c4\u00c5\5=\37\2\u00c5<\3\2\2\2\u00c6\u00c7\5? \2\u00c7"+
		"\u00c8\5=\37\2\u00c8\u00ca\3\2\2\2\u00c9\u00c6\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00d1\3\2\2\2\u00cb\u00cc\5G$\2\u00cc\u00cd\5=\37\2\u00cd\u00cf"+
		"\3\2\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d1\3\2\2\2\u00d0"+
		"\u00c9\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1>\3\2\2\2\u00d2\u00d3\t\3\2\2"+
		"\u00d3@\3\2\2\2\u00d4\u00d5\7\62\2\2\u00d5\u00d9\7z\2\2\u00d6\u00d7\7"+
		"\62\2\2\u00d7\u00d9\7Z\2\2\u00d8\u00d4\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9"+
		"B\3\2\2\2\u00da\u00db\4\63;\2\u00dbD\3\2\2\2\u00dc\u00dd\4\629\2\u00dd"+
		"F\3\2\2\2\u00de\u00e1\7\62\2\2\u00df\u00e1\5C\"\2\u00e0\u00de\3\2\2\2"+
		"\u00e0\u00df\3\2\2\2\u00e1H\3\2\2\2\u00e2\u00e3\t\4\2\2\u00e3J\3\2\2\2"+
		"\u00e4\u00e5\7-\2\2\u00e5L\3\2\2\2\u00e6\u00e7\7/\2\2\u00e7N\3\2\2\2\u00e8"+
		"\u00e9\7,\2\2\u00e9P\3\2\2\2\u00ea\u00eb\7\61\2\2\u00ebR\3\2\2\2\u00ec"+
		"\u00ed\7\'\2\2\u00edT\3\2\2\2\u00ee\u00ef\7?\2\2\u00ef\u00f3\7?\2\2\u00f0"+
		"\u00f1\7#\2\2\u00f1\u00f3\7?\2\2\u00f2\u00ee\3\2\2\2\u00f2\u00f0\3\2\2"+
		"\2\u00f3V\3\2\2\2\u00f4\u00fa\t\5\2\2\u00f5\u00f6\7@\2\2\u00f6\u00fa\7"+
		"?\2\2\u00f7\u00f8\7>\2\2\u00f8\u00fa\7?\2\2\u00f9\u00f4\3\2\2\2\u00f9"+
		"\u00f5\3\2\2\2\u00f9\u00f7\3\2\2\2\u00faX\3\2\2\2\r\2\u00b0\u00b8\u00c1"+
		"\u00c9\u00ce\u00d0\u00d8\u00e0\u00f2\u00f9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}

    public void removeErrorListener() {
    }
}