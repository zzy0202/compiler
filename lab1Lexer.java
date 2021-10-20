package lab1;// Generated from lab1.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lab1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, WhiteSpace=9, 
		DecimalConst=10, OctalConst=11, HexadecimalConst=12, HexadecimalPrefix=13, 
		NonzeroDigit=14, OctalDigit=15, Digit=16, HexadecimalDigit=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "WhiteSpace", 
			"DecimalConst", "DigitalConst_", "OctalConst", "OctalConst_", "HexadecimalConst", 
			"HexadecimalConst_", "HexadecimalPrefix", "NonzeroDigit", "OctalDigit", 
			"Digit", "HexadecimalDigit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'int'", "'main'", "'{'", "'}'", "'return'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "WhiteSpace", "DecimalConst", 
			"OctalConst", "HexadecimalConst", "HexadecimalPrefix", "NonzeroDigit", 
			"OctalDigit", "Digit", "HexadecimalDigit"
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


	public lab1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lab1.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23r\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\5\fP\n\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\5\16X\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20a\n\20\3\21\3\21"+
		"\3\21\3\21\5\21g\n\21\3\22\3\22\3\23\3\23\3\24\3\24\5\24o\n\24\3\25\3"+
		"\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\2\31\r\33"+
		"\2\35\16\37\2!\17#\20%\21\'\22)\23\3\2\4\5\2\13\f\17\17\"\"\5\2\62;CH"+
		"ch\2s\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2"+
		"\2\2\2\35\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\3+\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\63\3\2\2\2\138\3\2\2\2\r:\3\2"+
		"\2\2\17<\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25I\3\2\2\2\27O\3\2\2\2\31Q\3"+
		"\2\2\2\33W\3\2\2\2\35Y\3\2\2\2\37`\3\2\2\2!f\3\2\2\2#h\3\2\2\2%j\3\2\2"+
		"\2\'n\3\2\2\2)p\3\2\2\2+,\7*\2\2,\4\3\2\2\2-.\7+\2\2.\6\3\2\2\2/\60\7"+
		"k\2\2\60\61\7p\2\2\61\62\7v\2\2\62\b\3\2\2\2\63\64\7o\2\2\64\65\7c\2\2"+
		"\65\66\7k\2\2\66\67\7p\2\2\67\n\3\2\2\289\7}\2\29\f\3\2\2\2:;\7\177\2"+
		"\2;\16\3\2\2\2<=\7t\2\2=>\7g\2\2>?\7v\2\2?@\7w\2\2@A\7t\2\2AB\7p\2\2B"+
		"\20\3\2\2\2CD\7=\2\2D\22\3\2\2\2EF\t\2\2\2FG\3\2\2\2GH\b\n\2\2H\24\3\2"+
		"\2\2IJ\5#\22\2JK\5\27\f\2K\26\3\2\2\2LM\5\'\24\2MN\5\27\f\2NP\3\2\2\2"+
		"OL\3\2\2\2OP\3\2\2\2P\30\3\2\2\2QR\7\62\2\2RS\5\33\16\2S\32\3\2\2\2TU"+
		"\5%\23\2UV\5\33\16\2VX\3\2\2\2WT\3\2\2\2WX\3\2\2\2X\34\3\2\2\2YZ\5!\21"+
		"\2Z[\5)\25\2[\\\5\37\20\2\\\36\3\2\2\2]^\5)\25\2^_\5\37\20\2_a\3\2\2\2"+
		"`]\3\2\2\2`a\3\2\2\2a \3\2\2\2bc\7\62\2\2cg\7z\2\2de\7\62\2\2eg\7Z\2\2"+
		"fb\3\2\2\2fd\3\2\2\2g\"\3\2\2\2hi\4\63;\2i$\3\2\2\2jk\4\629\2k&\3\2\2"+
		"\2lo\7\62\2\2mo\5#\22\2nl\3\2\2\2nm\3\2\2\2o(\3\2\2\2pq\t\3\2\2q*\3\2"+
		"\2\2\b\2OW`fn\3\b\2\2";
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