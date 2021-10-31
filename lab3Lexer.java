// Generated from C:/Users/yung/IdeaProjects/untitled3\lab3.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lab3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, WhiteSpace=12, DecimalConst=13, OctalConst=14, HexadecimalConst=15, 
		Ident=16, Nondigit=17, HexadecimalPrefix=18, NonzeroDigit=19, OctalDigit=20, 
		Digit=21, HexadecimalDigit=22, Add=23, Sub=24, Mult=25, Div=26, Mod=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "WhiteSpace", "DecimalConst", "DecimalConst_", "OctalConst", 
			"OctalConst_", "HexadecimalConst", "HexadecimalConst_", "Ident", "Ident_", 
			"Nondigit", "HexadecimalPrefix", "NonzeroDigit", "OctalDigit", "Digit", 
			"HexadecimalDigit", "Add", "Sub", "Mult", "Div", "Mod"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'const'", "','", "';'", "'='", "'int'", "'main'", 
			"'{'", "'}'", "'return'", null, null, null, null, null, null, null, null, 
			null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"WhiteSpace", "DecimalConst", "OctalConst", "HexadecimalConst", "Ident", 
			"Nondigit", "HexadecimalPrefix", "NonzeroDigit", "OctalDigit", "Digit", 
			"HexadecimalDigit", "Add", "Sub", "Mult", "Div", "Mod"
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


	public lab3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lab3.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00ad\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\5\17p\n\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\5\21x\n\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\5\23\u0081\n\23\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u0089\n\25\3\25\3"+
		"\25\3\25\5\25\u008e\n\25\5\25\u0090\n\25\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\5\27\u0098\n\27\3\30\3\30\3\31\3\31\3\32\3\32\5\32\u00a0\n\32\3\33\3"+
		"\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \2\2!\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\20!\2#\21%\2\'"+
		"\22)\2+\23-\24/\25\61\26\63\27\65\30\67\319\32;\33=\34?\35\3\2\5\5\2\13"+
		"\f\17\17\"\"\5\2C\\aac|\5\2\62;CHch\2\u00b0\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\37\3\2\2\2\2#\3\2\2\2\2\'\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tK\3\2\2\2"+
		"\13M\3\2\2\2\rO\3\2\2\2\17Q\3\2\2\2\21U\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2"+
		"\2\27^\3\2\2\2\31e\3\2\2\2\33i\3\2\2\2\35o\3\2\2\2\37q\3\2\2\2!w\3\2\2"+
		"\2#y\3\2\2\2%\u0080\3\2\2\2\'\u0082\3\2\2\2)\u008f\3\2\2\2+\u0091\3\2"+
		"\2\2-\u0097\3\2\2\2/\u0099\3\2\2\2\61\u009b\3\2\2\2\63\u009f\3\2\2\2\65"+
		"\u00a1\3\2\2\2\67\u00a3\3\2\2\29\u00a5\3\2\2\2;\u00a7\3\2\2\2=\u00a9\3"+
		"\2\2\2?\u00ab\3\2\2\2AB\7*\2\2B\4\3\2\2\2CD\7+\2\2D\6\3\2\2\2EF\7e\2\2"+
		"FG\7q\2\2GH\7p\2\2HI\7u\2\2IJ\7v\2\2J\b\3\2\2\2KL\7.\2\2L\n\3\2\2\2MN"+
		"\7=\2\2N\f\3\2\2\2OP\7?\2\2P\16\3\2\2\2QR\7k\2\2RS\7p\2\2ST\7v\2\2T\20"+
		"\3\2\2\2UV\7o\2\2VW\7c\2\2WX\7k\2\2XY\7p\2\2Y\22\3\2\2\2Z[\7}\2\2[\24"+
		"\3\2\2\2\\]\7\177\2\2]\26\3\2\2\2^_\7t\2\2_`\7g\2\2`a\7v\2\2ab\7w\2\2"+
		"bc\7t\2\2cd\7p\2\2d\30\3\2\2\2ef\t\2\2\2fg\3\2\2\2gh\b\r\2\2h\32\3\2\2"+
		"\2ij\5/\30\2jk\5\35\17\2k\34\3\2\2\2lm\5\63\32\2mn\5\35\17\2np\3\2\2\2"+
		"ol\3\2\2\2op\3\2\2\2p\36\3\2\2\2qr\7\62\2\2rs\5!\21\2s \3\2\2\2tu\5\61"+
		"\31\2uv\5!\21\2vx\3\2\2\2wt\3\2\2\2wx\3\2\2\2x\"\3\2\2\2yz\5-\27\2z{\5"+
		"\65\33\2{|\5%\23\2|$\3\2\2\2}~\5\65\33\2~\177\5%\23\2\177\u0081\3\2\2"+
		"\2\u0080}\3\2\2\2\u0080\u0081\3\2\2\2\u0081&\3\2\2\2\u0082\u0083\5+\26"+
		"\2\u0083\u0084\5)\25\2\u0084(\3\2\2\2\u0085\u0086\5+\26\2\u0086\u0087"+
		"\5)\25\2\u0087\u0089\3\2\2\2\u0088\u0085\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\u0090\3\2\2\2\u008a\u008b\5\63\32\2\u008b\u008c\5)\25\2\u008c\u008e\3"+
		"\2\2\2\u008d\u008a\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f"+
		"\u0088\3\2\2\2\u008f\u008d\3\2\2\2\u0090*\3\2\2\2\u0091\u0092\t\3\2\2"+
		"\u0092,\3\2\2\2\u0093\u0094\7\62\2\2\u0094\u0098\7z\2\2\u0095\u0096\7"+
		"\62\2\2\u0096\u0098\7Z\2\2\u0097\u0093\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		".\3\2\2\2\u0099\u009a\4\63;\2\u009a\60\3\2\2\2\u009b\u009c\4\629\2\u009c"+
		"\62\3\2\2\2\u009d\u00a0\7\62\2\2\u009e\u00a0\5/\30\2\u009f\u009d\3\2\2"+
		"\2\u009f\u009e\3\2\2\2\u00a0\64\3\2\2\2\u00a1\u00a2\t\4\2\2\u00a2\66\3"+
		"\2\2\2\u00a3\u00a4\7-\2\2\u00a48\3\2\2\2\u00a5\u00a6\7/\2\2\u00a6:\3\2"+
		"\2\2\u00a7\u00a8\7,\2\2\u00a8<\3\2\2\2\u00a9\u00aa\7\61\2\2\u00aa>\3\2"+
		"\2\2\u00ab\u00ac\7\'\2\2\u00ac@\3\2\2\2\13\2ow\u0080\u0088\u008d\u008f"+
		"\u0097\u009f\3\b\2\2";
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