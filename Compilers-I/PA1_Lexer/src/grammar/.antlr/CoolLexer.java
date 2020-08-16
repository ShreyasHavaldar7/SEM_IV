// Generated from /home/shreyas/Documents/SEM_IV/Compilers-I/PA1_Lexer/src/grammar/CoolLexer.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WHITESPACE=43, ESC=44, UNTERM_STR=45, 
		NULL_STR=46, ESC_NULL_STR=47, EOF_BCKSLSH_STR=48, EOF_STR=49, EOF_COMMENT_0=50, 
		OPEN_COMMENT=51, SINGLE_LINE_COMMENT=52, MULTI_LINE_COMMENT=53, OTHER=54, 
		EOF_COMMENT_1=55, EOF_COMMENT_2=56, IN_NEST_MLC_0=57, CLOSE_MLC_0=58, 
		CONTENT_MLC_0=59, EOF_COMMENT_3=60, EOF_COMMENT_4=61, EOF_COMMENT_5=62, 
		IN_NEST_MLC_1=63, CLOSE_MLC_1=64, CONTENT_MLC_1=65;
	public static final int
		IN_MLC=1, NESTED_MLC=2;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE", "IN_MLC", "NESTED_MLC"
	};

	public static final String[] ruleNames = {
		"SEMICOLON", "DARROW", "COMMA", "DOT", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"PLUS", "MINUS", "STAR", "SLASH", "COLON", "ATSYM", "TILDE", "LT", "EQUALS", 
		"LE", "ASSIGN", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
		"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
		"Z", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", "LOOP", "POOL", 
		"THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", "NOT", "DIGIT", 
		"UCL", "LCL", "LETTER", "WHITESPACE", "ESC", "STR_INVALID_NEG", "STR_VALID", 
		"UNTERM_STR", "NULL_STR", "ESC_NULL_STR", "EOF_BCKSLSH_STR", "EOF_STR", 
		"EOF_COMMENT_0", "OPEN_COMMENT", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"TYPEID", "OBJECTID", "SINGLE_LINE_COMMENT", "MULTI_LINE_COMMENT", "OTHER", 
		"EOF_COMMENT_1", "EOF_COMMENT_2", "IN_NEST_MLC_0", "CLOSE_MLC_0", "CONTENT_MLC_0", 
		"EOF_COMMENT_3", "EOF_COMMENT_4", "EOF_COMMENT_5", "IN_NEST_MLC_1", "CLOSE_MLC_1", 
		"CONTENT_MLC_1"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WHITESPACE", "ESC", "UNTERM_STR", "NULL_STR", "ESC_NULL_STR", 
		"EOF_BCKSLSH_STR", "EOF_STR", "EOF_COMMENT_0", "OPEN_COMMENT", "SINGLE_LINE_COMMENT", 
		"MULTI_LINE_COMMENT", "OTHER", "EOF_COMMENT_1", "EOF_COMMENT_2", "IN_NEST_MLC_0", 
		"CLOSE_MLC_0", "CONTENT_MLC_0", "EOF_COMMENT_3", "EOF_COMMENT_4", "EOF_COMMENT_5", 
		"IN_NEST_MLC_1", "CLOSE_MLC_1", "CONTENT_MLC_1"
	};
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



		/*
			ADDED MY MEMBER VARIABLES AND METHODS HERE
		*/

		/**
		* Function to report errors.
		* Using this function whenever my lexer encounters any erroneous input
		*/
		public void reportError(String errorString){
			setText(errorString);
			setType(ERROR);
		}

		public void invalidToken() { 
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
			reportError(text);
		}

		public void processString() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();

			//write your code to test strings here

			if(text.length()-2 > 1024) {
				reportError("String constant too long"); // Checking if the length of string exceeds 1024 characters without quotes
			} else {
				text = text.substring(1, text.length()-1); // Removing the quotes
				String newText = "";
				for(int i=0; i < text.length(); i++) {
					if (text.charAt(i)=='\\') {
						switch(text.charAt(i+1)) {
							case 'n':
							newText+= '\n';
							break;
							case 'f':
							newText+= '\f';
							break;
							case 'r':
							newText+= '\r';
							break;
							case 't':
							newText+= '\t';
							break;
							case 'v':
							newText+= '\u000b'; // Unicode for vertical tab
							break;
							case '\\':
							newText+= '\\';
							break;
							default:
							newText+= (text.charAt(i+1));						
						}
						i++;					
					} else {
						newText+= (text.charAt(i));
					}
				}
				text = newText;
				setText(text);	
			}
			return;
		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 70:
			UNTERM_STR_action((RuleContext)_localctx, actionIndex);
			break;
		case 71:
			NULL_STR_action((RuleContext)_localctx, actionIndex);
			break;
		case 72:
			ESC_NULL_STR_action((RuleContext)_localctx, actionIndex);
			break;
		case 73:
			EOF_BCKSLSH_STR_action((RuleContext)_localctx, actionIndex);
			break;
		case 74:
			EOF_STR_action((RuleContext)_localctx, actionIndex);
			break;
		case 75:
			EOF_COMMENT_0_action((RuleContext)_localctx, actionIndex);
			break;
		case 76:
			OPEN_COMMENT_action((RuleContext)_localctx, actionIndex);
			break;
		case 79:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 84:
			OTHER_action((RuleContext)_localctx, actionIndex);
			break;
		case 85:
			EOF_COMMENT_1_action((RuleContext)_localctx, actionIndex);
			break;
		case 86:
			EOF_COMMENT_2_action((RuleContext)_localctx, actionIndex);
			break;
		case 90:
			EOF_COMMENT_3_action((RuleContext)_localctx, actionIndex);
			break;
		case 91:
			EOF_COMMENT_4_action((RuleContext)_localctx, actionIndex);
			break;
		case 92:
			EOF_COMMENT_5_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void UNTERM_STR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			reportError("Unterminated string constant");
			break;
		}
	}
	private void NULL_STR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			reportError("String contains null character");
			break;
		}
	}
	private void ESC_NULL_STR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			reportError("String contains escaped null character");
			break;
		}
	}
	private void EOF_BCKSLSH_STR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			reportError("backslash at end of file");
			break;
		}
	}
	private void EOF_STR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			reportError("EOF in string constant");
			break;
		}
	}
	private void EOF_COMMENT_0_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			reportError("EOF in comment");
			break;
		}
	}
	private void OPEN_COMMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:
			reportError("Unmatched *)");
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7:
			 processString(); 
			break;
		}
	}
	private void OTHER_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8:
			invalidToken();
			break;
		}
	}
	private void EOF_COMMENT_1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9:
			reportError("EOF in comment");
			break;
		}
	}
	private void EOF_COMMENT_2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10:
			reportError("EOF in comment");
			break;
		}
	}
	private void EOF_COMMENT_3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11:
			reportError("EOF in comment");
			break;
		}
	}
	private void EOF_COMMENT_4_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12:
			reportError("EOF in comment");
			break;
		}
	}
	private void EOF_COMMENT_5_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13:
			reportError("EOF in comment");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u0246\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t"+
		"<\4=\t=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4"+
		"H\tH\4I\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\t"+
		"S\4T\tT\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^"+
		"\4_\t_\4`\t`\4a\ta\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3"+
		"&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/"+
		"\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3"+
		"\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39"+
		"\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3=\3=\3=\3=\3>\3>"+
		"\3>\3>\3>\3>\3>\3?\3?\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\5C\u017d\nC\3D\6D"+
		"\u0180\nD\rD\16D\u0181\3D\3D\3E\3E\3E\3F\3F\3G\3G\7G\u018d\nG\fG\16G\u0190"+
		"\13G\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\7I\u019c\nI\fI\16I\u019f\13I\3I\5I"+
		"\u01a2\nI\3I\3I\3J\3J\3J\3J\3J\3J\3J\7J\u01ad\nJ\fJ\16J\u01b0\13J\3J\5"+
		"J\u01b3\nJ\3J\3J\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3"+
		"N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\5O\u01d8\nO\3P\6P\u01db"+
		"\nP\rP\16P\u01dc\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\7R\u01e8\nR\fR\16R\u01eb\13"+
		"R\3S\3S\3S\3S\7S\u01f1\nS\fS\16S\u01f4\13S\3T\3T\3T\3T\7T\u01fa\nT\fT"+
		"\16T\u01fd\13T\3T\5T\u0200\nT\3T\3T\3U\3U\3U\3U\3U\3U\3V\3V\3V\3W\3W\3"+
		"W\3W\3X\3X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3"+
		"[\3\\\3\\\3\\\3\\\3]\3]\3]\3]\3]\3]\3^\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3"+
		"_\3`\3`\3`\3`\3`\3`\3a\3a\3a\3a\3\u01fb\2b\5\r\7\31\t\16\13\30\r\t\17"+
		"\n\21\26\23\27\25\17\27\20\31\21\33\22\35\13\37\f!\23#\24%\25\'\32)\33"+
		"+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S"+
		"\2U\2W\2Y\2[\2]\2_\34a\35c\36e\37g i!k\"m#o$q%s&u\'w(y){*}+\177,\u0081"+
		"\2\u0083\2\u0085\2\u0087\2\u0089-\u008b.\u008d\2\u008f\2\u0091/\u0093"+
		"\60\u0095\61\u0097\62\u0099\63\u009b\64\u009d\65\u009f\6\u00a1\7\u00a3"+
		"\b\u00a5\4\u00a7\5\u00a9\66\u00ab\67\u00ad8\u00af9\u00b1:\u00b3;\u00b5"+
		"<\u00b7=\u00b9>\u00bb?\u00bd@\u00bfA\u00c1B\u00c3C\5\2\3\4%\4\2CCcc\4"+
		"\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLl"+
		"l\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2"+
		"UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\3\2\62"+
		";\3\2C\\\3\2c|\4\2\13\17\"\"\3\2\2\2\6\2\2\2\f\f$$^^\5\2\f\f$$^^\4\3\f"+
		"\f$$\3\3\f\f\2\u0234\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2"+
		"\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\3\u00af\3\2\2\2\3\u00b1\3\2\2\2\3\u00b3\3\2\2\2\3\u00b5"+
		"\3\2\2\2\3\u00b7\3\2\2\2\4\u00b9\3\2\2\2\4\u00bb\3\2\2\2\4\u00bd\3\2\2"+
		"\2\4\u00bf\3\2\2\2\4\u00c1\3\2\2\2\4\u00c3\3\2\2\2\5\u00c5\3\2\2\2\7\u00c7"+
		"\3\2\2\2\t\u00ca\3\2\2\2\13\u00cc\3\2\2\2\r\u00ce\3\2\2\2\17\u00d0\3\2"+
		"\2\2\21\u00d2\3\2\2\2\23\u00d4\3\2\2\2\25\u00d6\3\2\2\2\27\u00d8\3\2\2"+
		"\2\31\u00da\3\2\2\2\33\u00dc\3\2\2\2\35\u00de\3\2\2\2\37\u00e0\3\2\2\2"+
		"!\u00e2\3\2\2\2#\u00e4\3\2\2\2%\u00e6\3\2\2\2\'\u00e8\3\2\2\2)\u00eb\3"+
		"\2\2\2+\u00ee\3\2\2\2-\u00f0\3\2\2\2/\u00f2\3\2\2\2\61\u00f4\3\2\2\2\63"+
		"\u00f6\3\2\2\2\65\u00f8\3\2\2\2\67\u00fa\3\2\2\29\u00fc\3\2\2\2;\u00fe"+
		"\3\2\2\2=\u0100\3\2\2\2?\u0102\3\2\2\2A\u0104\3\2\2\2C\u0106\3\2\2\2E"+
		"\u0108\3\2\2\2G\u010a\3\2\2\2I\u010c\3\2\2\2K\u010e\3\2\2\2M\u0110\3\2"+
		"\2\2O\u0112\3\2\2\2Q\u0114\3\2\2\2S\u0116\3\2\2\2U\u0118\3\2\2\2W\u011a"+
		"\3\2\2\2Y\u011c\3\2\2\2[\u011e\3\2\2\2]\u0120\3\2\2\2_\u0122\3\2\2\2a"+
		"\u0128\3\2\2\2c\u012d\3\2\2\2e\u0130\3\2\2\2g\u0133\3\2\2\2i\u0136\3\2"+
		"\2\2k\u013f\3\2\2\2m\u0143\3\2\2\2o\u0148\3\2\2\2q\u014d\3\2\2\2s\u0152"+
		"\3\2\2\2u\u0158\3\2\2\2w\u015d\3\2\2\2y\u0162\3\2\2\2{\u0165\3\2\2\2}"+
		"\u0169\3\2\2\2\177\u0170\3\2\2\2\u0081\u0174\3\2\2\2\u0083\u0176\3\2\2"+
		"\2\u0085\u0178\3\2\2\2\u0087\u017c\3\2\2\2\u0089\u017f\3\2\2\2\u008b\u0185"+
		"\3\2\2\2\u008d\u0188\3\2\2\2\u008f\u018e\3\2\2\2\u0091\u0191\3\2\2\2\u0093"+
		"\u0196\3\2\2\2\u0095\u01a5\3\2\2\2\u0097\u01b6\3\2\2\2\u0099\u01bc\3\2"+
		"\2\2\u009b\u01c1\3\2\2\2\u009d\u01c7\3\2\2\2\u009f\u01d7\3\2\2\2\u00a1"+
		"\u01da\3\2\2\2\u00a3\u01de\3\2\2\2\u00a5\u01e3\3\2\2\2\u00a7\u01ec\3\2"+
		"\2\2\u00a9\u01f5\3\2\2\2\u00ab\u0203\3\2\2\2\u00ad\u0209\3\2\2\2\u00af"+
		"\u020c\3\2\2\2\u00b1\u0210\3\2\2\2\u00b3\u0216\3\2\2\2\u00b5\u021c\3\2"+
		"\2\2\u00b7\u0222\3\2\2\2\u00b9\u0226\3\2\2\2\u00bb\u022a\3\2\2\2\u00bd"+
		"\u0230\3\2\2\2\u00bf\u0236\3\2\2\2\u00c1\u023c\3\2\2\2\u00c3\u0242\3\2"+
		"\2\2\u00c5\u00c6\7=\2\2\u00c6\6\3\2\2\2\u00c7\u00c8\7?\2\2\u00c8\u00c9"+
		"\7@\2\2\u00c9\b\3\2\2\2\u00ca\u00cb\7.\2\2\u00cb\n\3\2\2\2\u00cc\u00cd"+
		"\7\60\2\2\u00cd\f\3\2\2\2\u00ce\u00cf\7*\2\2\u00cf\16\3\2\2\2\u00d0\u00d1"+
		"\7+\2\2\u00d1\20\3\2\2\2\u00d2\u00d3\7}\2\2\u00d3\22\3\2\2\2\u00d4\u00d5"+
		"\7\177\2\2\u00d5\24\3\2\2\2\u00d6\u00d7\7-\2\2\u00d7\26\3\2\2\2\u00d8"+
		"\u00d9\7/\2\2\u00d9\30\3\2\2\2\u00da\u00db\7,\2\2\u00db\32\3\2\2\2\u00dc"+
		"\u00dd\7\61\2\2\u00dd\34\3\2\2\2\u00de\u00df\7<\2\2\u00df\36\3\2\2\2\u00e0"+
		"\u00e1\7B\2\2\u00e1 \3\2\2\2\u00e2\u00e3\7\u0080\2\2\u00e3\"\3\2\2\2\u00e4"+
		"\u00e5\7>\2\2\u00e5$\3\2\2\2\u00e6\u00e7\7?\2\2\u00e7&\3\2\2\2\u00e8\u00e9"+
		"\7>\2\2\u00e9\u00ea\7?\2\2\u00ea(\3\2\2\2\u00eb\u00ec\7>\2\2\u00ec\u00ed"+
		"\7/\2\2\u00ed*\3\2\2\2\u00ee\u00ef\t\2\2\2\u00ef,\3\2\2\2\u00f0\u00f1"+
		"\t\3\2\2\u00f1.\3\2\2\2\u00f2\u00f3\t\4\2\2\u00f3\60\3\2\2\2\u00f4\u00f5"+
		"\t\5\2\2\u00f5\62\3\2\2\2\u00f6\u00f7\t\6\2\2\u00f7\64\3\2\2\2\u00f8\u00f9"+
		"\t\7\2\2\u00f9\66\3\2\2\2\u00fa\u00fb\t\b\2\2\u00fb8\3\2\2\2\u00fc\u00fd"+
		"\t\t\2\2\u00fd:\3\2\2\2\u00fe\u00ff\t\n\2\2\u00ff<\3\2\2\2\u0100\u0101"+
		"\t\13\2\2\u0101>\3\2\2\2\u0102\u0103\t\f\2\2\u0103@\3\2\2\2\u0104\u0105"+
		"\t\r\2\2\u0105B\3\2\2\2\u0106\u0107\t\16\2\2\u0107D\3\2\2\2\u0108\u0109"+
		"\t\17\2\2\u0109F\3\2\2\2\u010a\u010b\t\20\2\2\u010bH\3\2\2\2\u010c\u010d"+
		"\t\21\2\2\u010dJ\3\2\2\2\u010e\u010f\t\22\2\2\u010fL\3\2\2\2\u0110\u0111"+
		"\t\23\2\2\u0111N\3\2\2\2\u0112\u0113\t\24\2\2\u0113P\3\2\2\2\u0114\u0115"+
		"\t\25\2\2\u0115R\3\2\2\2\u0116\u0117\t\26\2\2\u0117T\3\2\2\2\u0118\u0119"+
		"\t\27\2\2\u0119V\3\2\2\2\u011a\u011b\t\30\2\2\u011bX\3\2\2\2\u011c\u011d"+
		"\t\31\2\2\u011dZ\3\2\2\2\u011e\u011f\t\32\2\2\u011f\\\3\2\2\2\u0120\u0121"+
		"\t\33\2\2\u0121^\3\2\2\2\u0122\u0123\5/\27\2\u0123\u0124\5A \2\u0124\u0125"+
		"\5+\25\2\u0125\u0126\5O\'\2\u0126\u0127\5O\'\2\u0127`\3\2\2\2\u0128\u0129"+
		"\5\63\31\2\u0129\u012a\5A \2\u012a\u012b\5O\'\2\u012b\u012c\5\63\31\2"+
		"\u012cb\3\2\2\2\u012d\u012e\5\65\32\2\u012e\u012f\5;\35\2\u012fd\3\2\2"+
		"\2\u0130\u0131\5;\35\2\u0131\u0132\5\65\32\2\u0132f\3\2\2\2\u0133\u0134"+
		"\5;\35\2\u0134\u0135\5E\"\2\u0135h\3\2\2\2\u0136\u0137\5;\35\2\u0137\u0138"+
		"\5E\"\2\u0138\u0139\59\34\2\u0139\u013a\5\63\31\2\u013a\u013b\5M&\2\u013b"+
		"\u013c\5;\35\2\u013c\u013d\5Q(\2\u013d\u013e\5O\'\2\u013ej\3\2\2\2\u013f"+
		"\u0140\5A \2\u0140\u0141\5\63\31\2\u0141\u0142\5Q(\2\u0142l\3\2\2\2\u0143"+
		"\u0144\5A \2\u0144\u0145\5G#\2\u0145\u0146\5G#\2\u0146\u0147\5I$\2\u0147"+
		"n\3\2\2\2\u0148\u0149\5I$\2\u0149\u014a\5G#\2\u014a\u014b\5G#\2\u014b"+
		"\u014c\5A \2\u014cp\3\2\2\2\u014d\u014e\5Q(\2\u014e\u014f\59\34\2\u014f"+
		"\u0150\5\63\31\2\u0150\u0151\5E\"\2\u0151r\3\2\2\2\u0152\u0153\5W+\2\u0153"+
		"\u0154\59\34\2\u0154\u0155\5;\35\2\u0155\u0156\5A \2\u0156\u0157\5\63"+
		"\31\2\u0157t\3\2\2\2\u0158\u0159\5/\27\2\u0159\u015a\5+\25\2\u015a\u015b"+
		"\5O\'\2\u015b\u015c\5\63\31\2\u015cv\3\2\2\2\u015d\u015e\5\63\31\2\u015e"+
		"\u015f\5O\'\2\u015f\u0160\5+\25\2\u0160\u0161\5/\27\2\u0161x\3\2\2\2\u0162"+
		"\u0163\5G#\2\u0163\u0164\5\65\32\2\u0164z\3\2\2\2\u0165\u0166\5E\"\2\u0166"+
		"\u0167\5\63\31\2\u0167\u0168\5W+\2\u0168|\3\2\2\2\u0169\u016a\5;\35\2"+
		"\u016a\u016b\5O\'\2\u016b\u016c\5U*\2\u016c\u016d\5G#\2\u016d\u016e\5"+
		";\35\2\u016e\u016f\5\61\30\2\u016f~\3\2\2\2\u0170\u0171\5E\"\2\u0171\u0172"+
		"\5G#\2\u0172\u0173\5Q(\2\u0173\u0080\3\2\2\2\u0174\u0175\t\34\2\2\u0175"+
		"\u0082\3\2\2\2\u0176\u0177\t\35\2\2\u0177\u0084\3\2\2\2\u0178\u0179\t"+
		"\36\2\2\u0179\u0086\3\2\2\2\u017a\u017d\5\u0083A\2\u017b\u017d\5\u0085"+
		"B\2\u017c\u017a\3\2\2\2\u017c\u017b\3\2\2\2\u017d\u0088\3\2\2\2\u017e"+
		"\u0180\t\37\2\2\u017f\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u017f\3"+
		"\2\2\2\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\bD\2\2\u0184"+
		"\u008a\3\2\2\2\u0185\u0186\7^\2\2\u0186\u0187\n \2\2\u0187\u008c\3\2\2"+
		"\2\u0188\u0189\n!\2\2\u0189\u008e\3\2\2\2\u018a\u018d\5\u008bE\2\u018b"+
		"\u018d\5\u008dF\2\u018c\u018a\3\2\2\2\u018c\u018b\3\2\2\2\u018d\u0190"+
		"\3\2\2\2\u018e\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u0090\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0191\u0192\7$\2\2\u0192\u0193\5\u008fG\2\u0193\u0194\7"+
		"\f\2\2\u0194\u0195\bH\3\2\u0195\u0092\3\2\2\2\u0196\u0197\7$\2\2\u0197"+
		"\u0198\5\u008fG\2\u0198\u019d\7\2\2\2\u0199\u019c\5\u008bE\2\u019a\u019c"+
		"\n\"\2\2\u019b\u0199\3\2\2\2\u019b\u019a\3\2\2\2\u019c\u019f\3\2\2\2\u019d"+
		"\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2"+
		"\2\2\u01a0\u01a2\t#\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a4\bI\4\2\u01a4\u0094\3\2\2\2\u01a5\u01a6\7$\2\2\u01a6\u01a7\5\u008f"+
		"G\2\u01a7\u01a8\7^\2\2\u01a8\u01a9\7\2\2\2\u01a9\u01ae\3\2\2\2\u01aa\u01ad"+
		"\5\u008bE\2\u01ab\u01ad\n\"\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ab\3\2\2"+
		"\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b2"+
		"\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b3\t#\2\2\u01b2\u01b1\3\2\2\2\u01b3"+
		"\u01b4\3\2\2\2\u01b4\u01b5\bJ\5\2\u01b5\u0096\3\2\2\2\u01b6\u01b7\7$\2"+
		"\2\u01b7\u01b8\5\u008fG\2\u01b8\u01b9\7^\2\2\u01b9\u01ba\7\2\2\3\u01ba"+
		"\u01bb\bK\6\2\u01bb\u0098\3\2\2\2\u01bc\u01bd\7$\2\2\u01bd\u01be\5\u008f"+
		"G\2\u01be\u01bf\7\2\2\3\u01bf\u01c0\bL\7\2\u01c0\u009a\3\2\2\2\u01c1\u01c2"+
		"\7*\2\2\u01c2\u01c3\7,\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c5\7\2\2\3\u01c5"+
		"\u01c6\bM\b\2\u01c6\u009c\3\2\2\2\u01c7\u01c8\7,\2\2\u01c8\u01c9\7+\2"+
		"\2\u01c9\u01ca\3\2\2\2\u01ca\u01cb\bN\t\2\u01cb\u009e\3\2\2\2\u01cc\u01cd"+
		"\7v\2\2\u01cd\u01ce\5M&\2\u01ce\u01cf\5S)\2\u01cf\u01d0\5\63\31\2\u01d0"+
		"\u01d8\3\2\2\2\u01d1\u01d2\7h\2\2\u01d2\u01d3\5+\25\2\u01d3\u01d4\5A "+
		"\2\u01d4\u01d5\5O\'\2\u01d5\u01d6\5\63\31\2\u01d6\u01d8\3\2\2\2\u01d7"+
		"\u01cc\3\2\2\2\u01d7\u01d1\3\2\2\2\u01d8\u00a0\3\2\2\2\u01d9\u01db\5\u0081"+
		"@\2\u01da\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc"+
		"\u01dd\3\2\2\2\u01dd\u00a2\3\2\2\2\u01de\u01df\7$\2\2\u01df\u01e0\5\u008f"+
		"G\2\u01e0\u01e1\7$\2\2\u01e1\u01e2\bQ\n\2\u01e2\u00a4\3\2\2\2\u01e3\u01e9"+
		"\5\u0083A\2\u01e4\u01e8\5\u0087C\2\u01e5\u01e8\5\u0081@\2\u01e6\u01e8"+
		"\7a\2\2\u01e7\u01e4\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e6\3\2\2\2\u01e8"+
		"\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea\u00a6\3\2"+
		"\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01f2\5\u0085B\2\u01ed\u01f1\5\u0087C\2"+
		"\u01ee\u01f1\5\u0081@\2\u01ef\u01f1\7a\2\2\u01f0\u01ed\3\2\2\2\u01f0\u01ee"+
		"\3\2\2\2\u01f0\u01ef\3\2\2\2\u01f1\u01f4\3\2\2\2\u01f2\u01f0\3\2\2\2\u01f2"+
		"\u01f3\3\2\2\2\u01f3\u00a8\3\2\2\2\u01f4\u01f2\3\2\2\2\u01f5\u01f6\7/"+
		"\2\2\u01f6\u01f7\7/\2\2\u01f7\u01fb\3\2\2\2\u01f8\u01fa\13\2\2\2\u01f9"+
		"\u01f8\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fb\u01f9\3\2"+
		"\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u0200\t$\2\2\u01ff"+
		"\u01fe\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\bT\2\2\u0202\u00aa\3\2"+
		"\2\2\u0203\u0204\7*\2\2\u0204\u0205\7,\2\2\u0205\u0206\3\2\2\2\u0206\u0207"+
		"\bU\13\2\u0207\u0208\bU\2\2\u0208\u00ac\3\2\2\2\u0209\u020a\13\2\2\2\u020a"+
		"\u020b\bV\f\2\u020b\u00ae\3\2\2\2\u020c\u020d\13\2\2\2\u020d\u020e\7\2"+
		"\2\3\u020e\u020f\bW\r\2\u020f\u00b0\3\2\2\2\u0210\u0211\7*\2\2\u0211\u0212"+
		"\7,\2\2\u0212\u0213\3\2\2\2\u0213\u0214\7\2\2\3\u0214\u0215\bX\16\2\u0215"+
		"\u00b2\3\2\2\2\u0216\u0217\7*\2\2\u0217\u0218\7,\2\2\u0218\u0219\3\2\2"+
		"\2\u0219\u021a\bY\17\2\u021a\u021b\bY\2\2\u021b\u00b4\3\2\2\2\u021c\u021d"+
		"\7,\2\2\u021d\u021e\7+\2\2\u021e\u021f\3\2\2\2\u021f\u0220\bZ\20\2\u0220"+
		"\u0221\bZ\2\2\u0221\u00b6\3\2\2\2\u0222\u0223\13\2\2\2\u0223\u0224\3\2"+
		"\2\2\u0224\u0225\b[\2\2\u0225\u00b8\3\2\2\2\u0226\u0227\13\2\2\2\u0227"+
		"\u0228\7\2\2\3\u0228\u0229\b\\\21\2\u0229\u00ba\3\2\2\2\u022a\u022b\7"+
		"*\2\2\u022b\u022c\7,\2\2\u022c\u022d\3\2\2\2\u022d\u022e\7\2\2\3\u022e"+
		"\u022f\b]\22\2\u022f\u00bc\3\2\2\2\u0230\u0231\7,\2\2\u0231\u0232\7+\2"+
		"\2\u0232\u0233\3\2\2\2\u0233\u0234\7\2\2\3\u0234\u0235\b^\23\2\u0235\u00be"+
		"\3\2\2\2\u0236\u0237\7*\2\2\u0237\u0238\7,\2\2\u0238\u0239\3\2\2\2\u0239"+
		"\u023a\b_\17\2\u023a\u023b\b_\2\2\u023b\u00c0\3\2\2\2\u023c\u023d\7,\2"+
		"\2\u023d\u023e\7+\2\2\u023e\u023f\3\2\2\2\u023f\u0240\b`\20\2\u0240\u0241"+
		"\b`\2\2\u0241\u00c2\3\2\2\2\u0242\u0243\13\2\2\2\u0243\u0244\3\2\2\2\u0244"+
		"\u0245\ba\2\2\u0245\u00c4\3\2\2\2\27\2\3\4\u017c\u0181\u018c\u018e\u019b"+
		"\u019d\u01a1\u01ac\u01ae\u01b2\u01d7\u01dc\u01e7\u01e9\u01f0\u01f2\u01fb"+
		"\u01ff\24\b\2\2\3H\2\3I\3\3J\4\3K\5\3L\6\3M\7\3N\b\3Q\t\7\3\2\3V\n\3W"+
		"\13\3X\f\7\4\2\6\2\2\3\\\r\3]\16\3^\17";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}