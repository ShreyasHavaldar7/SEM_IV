lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,
	OBJECTID,
	BOOL_CONST,
	INT_CONST,
	STR_CONST,
	LPAREN,
	RPAREN,
	COLON,
	ATSYM,
	SEMICOLON,
	COMMA,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	TILDE,
	LT,
	EQUALS,
	LBRACE,
	RBRACE,
	DOT,
	DARROW,
	LE,
	ASSIGN,
	CLASS,
	ELSE,
	FI,
	IF,
	IN,
	INHERITS,
	LET,
	LOOP,
	POOL,
	THEN,
	WHILE,
	CASE,
	ESAC,
	OF,
	NEW,
	ISVOID,
	NOT
}



@members{

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
}
/*
	ALL LEXER RULES BELOW
*/

// Symbols

SEMICOLON: ';';
DARROW: '=>';
COMMA: ',';
DOT: '.';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
PLUS: '+';
MINUS: '-';
STAR: '*';
SLASH: '/';
COLON: ':';
ATSYM: '@';
TILDE: '~';
LT: '<';
EQUALS: '=';
LE: '<=';
ASSIGN: '<-';

// Creating case insensitive alphabets
fragment A : [aA]; 
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];

// Keywords, Not case sensitive
CLASS: C L A S S;
ELSE: E L S E;
FI: F I;
IF: I F;
IN: I N;
INHERITS: I N H E R I T S;
LET: L E T;		
LOOP: L O O P;
POOL: P O O L;
THEN: T H E N;
WHILE: W H I L E;
CASE: C A S E;
ESAC: E S A C;
OF: O F;
NEW: N E W;
ISVOID: I S V O I D;
NOT: N O T;

// Intermediaries
fragment DIGIT: [0-9];
fragment UCL: [A-Z];
fragment LCL: [a-z];
fragment LETTER: (UCL|LCL);
WHITESPACE: [ \n\f\r\t\u000b]+ -> skip; // skip causes the lexer to discard the token.
ESC: ('\\'~('\u0000')); // Escape characters are allowed except for null character
fragment STR_INVALID_NEG: ~('\n'|'\u0000'|'\\'|'"'); // String cannot contain unescaped newline, null, only backslash, or unescaped quotes
fragment STR_VALID: (ESC | STR_INVALID_NEG)*;

// Errors
UNTERM_STR: '"' STR_VALID '\n' {reportError("Unterminated string constant");};
NULL_STR: '"' STR_VALID '\u0000' (ESC | ~('\n'|'\\'|'"'))* ('"'|'\n'| (EOF)) {reportError("String contains null character");};
ESC_NULL_STR: '"' STR_VALID '\\\u0000' (ESC | ~('\n'|'\\'|'"'))* ('"'|'\n'| (EOF)) {reportError("String contains escaped null character");};
EOF_BCKSLSH_STR: '"' STR_VALID '\\' (EOF) {reportError("backslash at end of file");}; 
EOF_STR: '"' STR_VALID (EOF) {reportError("EOF in string constant");};
EOF_COMMENT_0: '(*' (EOF) {reportError("EOF in comment");}; // (EOF) represents end of file representation, EOF in comment at 0th level of nesting, immediately after comment open, ie. (*(EOF)
OPEN_COMMENT: '*)' {reportError("Unmatched *)");};	

// Identifiers
BOOL_CONST: 't' R U E | 'f' A L S E; 
INT_CONST: (DIGIT)+;
STR_CONST: '"' STR_VALID '"' { processString(); };
TYPEID: (UCL)(LETTER|DIGIT|'_')*;
OBJECTID: (LCL)(LETTER|DIGIT|'_')*;

// Comments
SINGLE_LINE_COMMENT: '--' .*? ('\n'|(EOF)) -> skip; //Using non-greedy lexer subrule to consume all input until a new line is encountered	
MULTI_LINE_COMMENT: '(*' -> pushMode(IN_MLC), skip; // If a multi line comment opener, "(*" is encountered we enter IN_MLC mode while skipping characters in the comment

// The character token doesn't match with any rule
OTHER: . {invalidToken();};

// Using modes for managing nested multiline comments and errors due to EOF in them
mode IN_MLC;
EOF_COMMENT_1: . (EOF) {reportError("EOF in comment");}; // EOF in comment with some characters at 0th level of nesting, eg. (*hello(EOF)
EOF_COMMENT_2: '(*' (EOF) {reportError("EOF in comment");}; // eg. (*hello(*(EOF)
IN_NEST_MLC_0: '(*' -> pushMode(NESTED_MLC), skip;
CLOSE_MLC_0: '*)' -> popMode, skip;
CONTENT_MLC_0: . -> skip;

mode NESTED_MLC;
EOF_COMMENT_3: . (EOF) {reportError("EOF in comment");}; // eg. (*hello(*hi(EOF)
EOF_COMMENT_4: '(*' (EOF) {reportError("EOF in comment");}; // eg. (*hello(*hi(*(EOF)
EOF_COMMENT_5: '*)' (EOF) {reportError("EOF in comment");}; // eg. (*hello(*hi*)(EOF)
IN_NEST_MLC_1: '(*' -> pushMode(NESTED_MLC), skip;
CLOSE_MLC_1: '*)' -> popMode, skip;
CONTENT_MLC_1: . -> skip;