package lab2;// Generated from C:/Users/yung/IdeaProjects/untitled3\lab2.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lab2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, WhiteSpace=9, 
		DecimalConst=10, OctalConst=11, HexadecimalConst=12, HexadecimalPrefix=13, 
		NonzeroDigit=14, OctalDigit=15, Digit=16, HexadecimalDigit=17, Add=18, 
		Sub=19, Mult=20, Div=21, Mod=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "WhiteSpace", 
			"DecimalConst", "DecimalConst_", "OctalConst", "OctalConst_", "HexadecimalConst", 
			"HexadecimalConst_", "HexadecimalPrefix", "NonzeroDigit", "OctalDigit", 
			"Digit", "HexadecimalDigit", "Add", "Sub", "Mult", "Div", "Mod"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'int'", "'main'", "'{'", "'}'", "'return'", "';'", 
			null, null, null, null, null, null, null, null, null, "'+'", "'-'", "'*'", 
			"'/'", "'%'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "WhiteSpace", "DecimalConst", 
			"OctalConst", "HexadecimalConst", "HexadecimalPrefix", "NonzeroDigit", 
			"OctalDigit", "Digit", "HexadecimalDigit", "Add", "Sub", "Mult", "Div", 
			"Mod"
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


	public lab2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lab2.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0086\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\5\fZ\n\f\3\r\3\r\3\r\3\16\3\16\3\16\5\16b\n\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20k\n\20\3\21\3\21\3\21\3\21\5\21"+
		"q\n\21\3\22\3\22\3\23\3\23\3\24\3\24\5\24y\n\24\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\2\2\33\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\2\31\r\33\2\35\16\37\2!\17#\20%\21\'\22)\23+"+
		"\24-\25/\26\61\27\63\30\3\2\4\5\2\13\f\17\17\"\"\5\2\62;CHch\2\u0087\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\31\3\2\2\2\2"+
		"\35\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2"+
		"\5\67\3\2\2\2\79\3\2\2\2\t=\3\2\2\2\13B\3\2\2\2\rD\3\2\2\2\17F\3\2\2\2"+
		"\21M\3\2\2\2\23O\3\2\2\2\25S\3\2\2\2\27Y\3\2\2\2\31[\3\2\2\2\33a\3\2\2"+
		"\2\35c\3\2\2\2\37j\3\2\2\2!p\3\2\2\2#r\3\2\2\2%t\3\2\2\2\'x\3\2\2\2)z"+
		"\3\2\2\2+|\3\2\2\2-~\3\2\2\2/\u0080\3\2\2\2\61\u0082\3\2\2\2\63\u0084"+
		"\3\2\2\2\65\66\7*\2\2\66\4\3\2\2\2\678\7+\2\28\6\3\2\2\29:\7k\2\2:;\7"+
		"p\2\2;<\7v\2\2<\b\3\2\2\2=>\7o\2\2>?\7c\2\2?@\7k\2\2@A\7p\2\2A\n\3\2\2"+
		"\2BC\7}\2\2C\f\3\2\2\2DE\7\177\2\2E\16\3\2\2\2FG\7t\2\2GH\7g\2\2HI\7v"+
		"\2\2IJ\7w\2\2JK\7t\2\2KL\7p\2\2L\20\3\2\2\2MN\7=\2\2N\22\3\2\2\2OP\t\2"+
		"\2\2PQ\3\2\2\2QR\b\n\2\2R\24\3\2\2\2ST\5#\22\2TU\5\27\f\2U\26\3\2\2\2"+
		"VW\5\'\24\2WX\5\27\f\2XZ\3\2\2\2YV\3\2\2\2YZ\3\2\2\2Z\30\3\2\2\2[\\\7"+
		"\62\2\2\\]\5\33\16\2]\32\3\2\2\2^_\5%\23\2_`\5\33\16\2`b\3\2\2\2a^\3\2"+
		"\2\2ab\3\2\2\2b\34\3\2\2\2cd\5!\21\2de\5)\25\2ef\5\37\20\2f\36\3\2\2\2"+
		"gh\5)\25\2hi\5\37\20\2ik\3\2\2\2jg\3\2\2\2jk\3\2\2\2k \3\2\2\2lm\7\62"+
		"\2\2mq\7z\2\2no\7\62\2\2oq\7Z\2\2pl\3\2\2\2pn\3\2\2\2q\"\3\2\2\2rs\4\63"+
		";\2s$\3\2\2\2tu\4\629\2u&\3\2\2\2vy\7\62\2\2wy\5#\22\2xv\3\2\2\2xw\3\2"+
		"\2\2y(\3\2\2\2z{\t\3\2\2{*\3\2\2\2|}\7-\2\2},\3\2\2\2~\177\7/\2\2\177"+
		".\3\2\2\2\u0080\u0081\7,\2\2\u0081\60\3\2\2\2\u0082\u0083\7\61\2\2\u0083"+
		"\62\3\2\2\2\u0084\u0085\7\'\2\2\u0085\64\3\2\2\2\b\2Yajpx\3\b\2\2";
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