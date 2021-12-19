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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, WhiteSpace=23, DecimalConst=24, 
		OctalConst=25, HexadecimalConst=26, Ident=27, Nondigit=28, HexadecimalPrefix=29, 
		NonzeroDigit=30, OctalDigit=31, Digit=32, HexadecimalDigit=33, Add=34, 
		Sub=35, Mult=36, Div=37, Mod=38, EqExpSymbol=39, RelExpSymbol=40;
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
			"T__17", "T__18", "T__19", "T__20", "T__21", "WhiteSpace", "DecimalConst", 
			"DecimalConst_", "OctalConst", "OctalConst_", "HexadecimalConst", "HexadecimalConst_", 
			"Ident", "Ident_", "Nondigit", "HexadecimalPrefix", "NonzeroDigit", "OctalDigit", 
			"Digit", "HexadecimalDigit", "Add", "Sub", "Mult", "Div", "Mod", "EqExpSymbol", 
			"RelExpSymbol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "','", "'['", "']'", "'const'", "';'", "'='", "'{'", 
			"'}'", "'int'", "'void'", "'main'", "'return'", "'if'", "'else'", "'while'", 
			"'break'", "'continue'", "'&&'", "'||'", "'!'", null, null, null, null, 
			null, null, null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", 
			"'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "WhiteSpace", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0102\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\5\32\u00b8\n\32\3\33\3\33\3\33\3\34\3\34\3\34\5\34"+
		"\u00c0\n\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\5\36\u00c9\n\36\3\37\3"+
		"\37\3\37\3 \3 \3 \5 \u00d1\n \3 \3 \3 \5 \u00d6\n \5 \u00d8\n \3!\3!\3"+
		"\"\3\"\3\"\3\"\5\"\u00e0\n\"\3#\3#\3$\3$\3%\3%\5%\u00e8\n%\3&\3&\3\'\3"+
		"\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3,\3,\5,\u00fa\n,\3-\3-\3-\3-\3-\5-\u0101"+
		"\n-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\33\67\29\34"+
		";\2=\35?\2A\36C\37E G!I\"K#M$O%Q&S\'U(W)Y*\3\2\6\5\2\13\f\17\17\"\"\5"+
		"\2C\\aac|\5\2\62;CHch\4\2>>@@\2\u0108\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2\2\29\3"+
		"\2\2\2\2=\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3"+
		"\2\2\2\re\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23o\3\2\2\2\25q\3\2\2\2\27s"+
		"\3\2\2\2\31w\3\2\2\2\33|\3\2\2\2\35\u0081\3\2\2\2\37\u0088\3\2\2\2!\u008b"+
		"\3\2\2\2#\u0090\3\2\2\2%\u0096\3\2\2\2\'\u009c\3\2\2\2)\u00a5\3\2\2\2"+
		"+\u00a8\3\2\2\2-\u00ab\3\2\2\2/\u00ad\3\2\2\2\61\u00b1\3\2\2\2\63\u00b7"+
		"\3\2\2\2\65\u00b9\3\2\2\2\67\u00bf\3\2\2\29\u00c1\3\2\2\2;\u00c8\3\2\2"+
		"\2=\u00ca\3\2\2\2?\u00d7\3\2\2\2A\u00d9\3\2\2\2C\u00df\3\2\2\2E\u00e1"+
		"\3\2\2\2G\u00e3\3\2\2\2I\u00e7\3\2\2\2K\u00e9\3\2\2\2M\u00eb\3\2\2\2O"+
		"\u00ed\3\2\2\2Q\u00ef\3\2\2\2S\u00f1\3\2\2\2U\u00f3\3\2\2\2W\u00f9\3\2"+
		"\2\2Y\u0100\3\2\2\2[\\\7*\2\2\\\4\3\2\2\2]^\7+\2\2^\6\3\2\2\2_`\7.\2\2"+
		"`\b\3\2\2\2ab\7]\2\2b\n\3\2\2\2cd\7_\2\2d\f\3\2\2\2ef\7e\2\2fg\7q\2\2"+
		"gh\7p\2\2hi\7u\2\2ij\7v\2\2j\16\3\2\2\2kl\7=\2\2l\20\3\2\2\2mn\7?\2\2"+
		"n\22\3\2\2\2op\7}\2\2p\24\3\2\2\2qr\7\177\2\2r\26\3\2\2\2st\7k\2\2tu\7"+
		"p\2\2uv\7v\2\2v\30\3\2\2\2wx\7x\2\2xy\7q\2\2yz\7k\2\2z{\7f\2\2{\32\3\2"+
		"\2\2|}\7o\2\2}~\7c\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\34\3\2\2\2\u0081"+
		"\u0082\7t\2\2\u0082\u0083\7g\2\2\u0083\u0084\7v\2\2\u0084\u0085\7w\2\2"+
		"\u0085\u0086\7t\2\2\u0086\u0087\7p\2\2\u0087\36\3\2\2\2\u0088\u0089\7"+
		"k\2\2\u0089\u008a\7h\2\2\u008a \3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d"+
		"\7n\2\2\u008d\u008e\7u\2\2\u008e\u008f\7g\2\2\u008f\"\3\2\2\2\u0090\u0091"+
		"\7y\2\2\u0091\u0092\7j\2\2\u0092\u0093\7k\2\2\u0093\u0094\7n\2\2\u0094"+
		"\u0095\7g\2\2\u0095$\3\2\2\2\u0096\u0097\7d\2\2\u0097\u0098\7t\2\2\u0098"+
		"\u0099\7g\2\2\u0099\u009a\7c\2\2\u009a\u009b\7m\2\2\u009b&\3\2\2\2\u009c"+
		"\u009d\7e\2\2\u009d\u009e\7q\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7v\2\2"+
		"\u00a0\u00a1\7k\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7w\2\2\u00a3\u00a4"+
		"\7g\2\2\u00a4(\3\2\2\2\u00a5\u00a6\7(\2\2\u00a6\u00a7\7(\2\2\u00a7*\3"+
		"\2\2\2\u00a8\u00a9\7~\2\2\u00a9\u00aa\7~\2\2\u00aa,\3\2\2\2\u00ab\u00ac"+
		"\7#\2\2\u00ac.\3\2\2\2\u00ad\u00ae\t\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0"+
		"\b\30\2\2\u00b0\60\3\2\2\2\u00b1\u00b2\5E#\2\u00b2\u00b3\5\63\32\2\u00b3"+
		"\62\3\2\2\2\u00b4\u00b5\5I%\2\u00b5\u00b6\5\63\32\2\u00b6\u00b8\3\2\2"+
		"\2\u00b7\u00b4\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\64\3\2\2\2\u00b9\u00ba"+
		"\7\62\2\2\u00ba\u00bb\5\67\34\2\u00bb\66\3\2\2\2\u00bc\u00bd\5G$\2\u00bd"+
		"\u00be\5\67\34\2\u00be\u00c0\3\2\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00c0\3"+
		"\2\2\2\u00c08\3\2\2\2\u00c1\u00c2\5C\"\2\u00c2\u00c3\5K&\2\u00c3\u00c4"+
		"\5;\36\2\u00c4:\3\2\2\2\u00c5\u00c6\5K&\2\u00c6\u00c7\5;\36\2\u00c7\u00c9"+
		"\3\2\2\2\u00c8\u00c5\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9<\3\2\2\2\u00ca"+
		"\u00cb\5A!\2\u00cb\u00cc\5? \2\u00cc>\3\2\2\2\u00cd\u00ce\5A!\2\u00ce"+
		"\u00cf\5? \2\u00cf\u00d1\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00d1\3\2\2"+
		"\2\u00d1\u00d8\3\2\2\2\u00d2\u00d3\5I%\2\u00d3\u00d4\5? \2\u00d4\u00d6"+
		"\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d0\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8@\3\2\2\2\u00d9\u00da\t\3\2\2"+
		"\u00daB\3\2\2\2\u00db\u00dc\7\62\2\2\u00dc\u00e0\7z\2\2\u00dd\u00de\7"+
		"\62\2\2\u00de\u00e0\7Z\2\2\u00df\u00db\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"D\3\2\2\2\u00e1\u00e2\4\63;\2\u00e2F\3\2\2\2\u00e3\u00e4\4\629\2\u00e4"+
		"H\3\2\2\2\u00e5\u00e8\7\62\2\2\u00e6\u00e8\5E#\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e6\3\2\2\2\u00e8J\3\2\2\2\u00e9\u00ea\t\4\2\2\u00eaL\3\2\2\2\u00eb"+
		"\u00ec\7-\2\2\u00ecN\3\2\2\2\u00ed\u00ee\7/\2\2\u00eeP\3\2\2\2\u00ef\u00f0"+
		"\7,\2\2\u00f0R\3\2\2\2\u00f1\u00f2\7\61\2\2\u00f2T\3\2\2\2\u00f3\u00f4"+
		"\7\'\2\2\u00f4V\3\2\2\2\u00f5\u00f6\7?\2\2\u00f6\u00fa\7?\2\2\u00f7\u00f8"+
		"\7#\2\2\u00f8\u00fa\7?\2\2\u00f9\u00f5\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"X\3\2\2\2\u00fb\u0101\t\5\2\2\u00fc\u00fd\7@\2\2\u00fd\u0101\7?\2\2\u00fe"+
		"\u00ff\7>\2\2\u00ff\u0101\7?\2\2\u0100\u00fb\3\2\2\2\u0100\u00fc\3\2\2"+
		"\2\u0100\u00fe\3\2\2\2\u0101Z\3\2\2\2\r\2\u00b7\u00bf\u00c8\u00d0\u00d5"+
		"\u00d7\u00df\u00e7\u00f9\u0100\3\b\2\2";
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