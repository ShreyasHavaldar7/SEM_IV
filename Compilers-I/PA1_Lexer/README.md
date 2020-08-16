# COOL Compiler #

## The Lexical Analyser ##

The file CoolLexer.g4 contains the rules for lexing the code written in the COOL programming language. The scanner performs the task of reading the characters of the input stream as tokens, like arithmetic symbols (eg. '+'), identifiers (eg. *INT_CONST*), strings and comments to name a few. The following sections explain the thought process behind the design of this lexer.

### Design Decisions ###

- Member Functions:

  - A new member function *invalidToken()* was added to report an error when an invalid character (one that can’t begin any token) is encountered. A string containing just that character is returned as the error string. Lexing is resumed at the following character.

  - The function *processString()* was edited to check for the length of the string and report an error if the string was too long. The length of the string can be a maximum length of 1024 characters (excluding the open and close quotes, hence the -2 in code) following the COOL manual specification. A switch case was added to take care of escape sequences.

- Lexer Rules:

  - Symbols: Characters, or a combination of them which are individually tokens (eg. '+', '@', '<=') were directly tokenized at the beginning itself.

  - Case insensitive alphabets were then created as fragments for cleaner code and simplicity.

  - Case insensitive keywords (eg *if*, *Class*) were dealt with using the above created alphabet fragments.

  - Fragments and other intermediate definitions used to build more complex token definitions:
    - *DIGIT* and *UCL* (representing upper case letters) were defined to simplify the rules following them.

    - *WHITESPACE* was defined to group all valid whitespaces together respectively. The valid whitespaces are skipped by the lexer.

    - *ESC* contains all the valid escaped characters.

    - *STR_VALID* defined all the combination of valid strings as the union of *ESC* and *STR_INVALID_NEG* (defined as the negation of all strings invalid due to presence of particular characters in them).

  - The different kinds of errors that can arise are dealt with next.

    - *UNTERM_STR* checks if a string contains an unescaped newline or the programmer forgot the close quote.

    - *NULL_STR* checks if the string contains a non-escaped NULL character.

    - *ESC_NULL_STR* checks if the string contains an escaped NULL character.

    - *EOF_BCKSLSH_STR* checks if there is a backslash at the end of the file in a string.

    - *EOF_STR* checks if an EOF is encountered before the close quote in a string.

    - *EOF_COMMENT_0* checks if a comment remains open when EOF is encountered at the 0th level of nesting. Only with one "(\*" token followed immediately by EOF with no intermediate characters. Other possibilities of "EOF in comment" errors are handled in the modes listed at the end.

    - *OPEN_COMMENT* checks if "\*)" is seen outside a comment.

  - Identifiers are then dealt with using the standard definition given in the COOL manual. Attention is paid to ensure the *BOOL_CONST* is defined above *OBJECTID* to prevent incorrect tokenization of "true" or "false" due to order of the rules. If a stream of characters is tokenized as *STR_CONST* is it passed to *processString()* for processing it.

  - Comments:

    - Single line comments are simply tokenized by recognizing a character stream beginning with "--" and ending with either newline or EOF.

    - Multi line comments can be nested and makes use of 2 modes which are described in detail below. On encountering the token "(\*" the lexer enters the *IN_MLC* mode.

  - When the character from the input stream does not match with any of the lexer rules defined above, it is assumed to be invalid and passed to *invalidToken()* to report as an error.

- Modes:
  
  - I make use of the following two additional modes to take care of multi level comments. All the possibilities of EOF being encountered in a comment are taken care of extensively at the beginning itself, at each level of nesting and even when that level of comment "(\*" or "\*)" are immediately followed by EOF (EOF_COMMENT_(0,2,4,5)), and are correctly processed as "EOF in comment" error. The tokens with similar purpose are named as *NAME_NUMBER* for maintaining distinction in token names, while being easy to associate and understand. (eg. *EOF_COMMENT_0*, *EOF_COMMENT_1* and so on. All detect presence of EOF in multiline comments.)

    - *IN_MLC*: after checking that EOF is not encountered, the lexer enters *NESTED_MLC* mode if it encounters "(\*", comes out of *IN_MLC* if it encounters a "\*)", while skipping the content of the comment. The lexer is in this mode when exactly one non-closed "(\*" remains.

    - *NESTED_MLC*: after checking that EOF is not encountered at any level of nesting, the lexer remains in *NESTED_MLC* mode if it encounters "(\*", comes out of that level of *NESTED_MLC* if it encounters a "\*)", while skipping the content of the comment. The lexer is in this mode when atleast two non-closed "(\*" remain.

## The Test Cases ##

The robustness of my lexer and its ability to handle errors with proper messages is thoroughly demonstrated via the following test cases. I've made conscious efforts to include edge cases of both valid and invalid tokens in my test cases. Each of these test cases pertains to one type of lexing errors or special cases.

- helloworld.cl: Basic string output program provided as an example.

- test_1.cl: A file to check recognition of arithmetic symbols and integer constants, with basic I/O operations. To check if a correct COOL program is being lexed properly.

- test_2.cl: The important possible errors that can occur due to strings are collected here. It showcases the error handling for:

  - Non-escaped and escaped null character in a string constant.

  - Unterminated string constants (ie. non-escaped new lines in strings).

  - The string constant being too long.

  - EOF within a string constant.

- test_3.cl: All the possible special cases that are valid in strings are collected here, additionally with the backslash at end of file error. It contains various strings containing backslashes:

  - An escaped new line in a string is allowed.

  - '\n' character in a string is allowed.

  - Escaped quotes and backslashes in a string are allowed.

  - Within a string, a sequence ‘\c’ denotes the character ‘c’, with the exception of the specially defined escape sequences, namely '\b', '\t', '\n', '\f'.

  - A string containing a backslash immediately followed by EOF, in other words backslash at end of file is not allowed, it gives an error.

- test_4.cl: This file corresponds to the various kinds of errors caused by comments and their handling by my lexer:

  - A single line comment ends at a newline and any token in next line is not a part of it.

  - Multi line comment is terminated always by "\*)". It does not extend even the same line after "\*)".

  - If a stray "*)" is encountered it is reported as unmatched.

  - EOF in comment error occurs if the number of opening "(\*" in the program exceeds the closing ")\*".

- test_5.cl: This is a COOL program with several combinations of valid comments. It also demonstrates that the lexer correctly scopes the comments in the program and the fact that multiline comments can include new line and characters \*, ( and ) independently.

- test_6.cl: This file is a short collection of various kinds of keywords in COOL, segregated into two categories: Case sensitive and case insensitive. This demonstrates the correct classification of tokens by my lexer. **Note:** *"self"* and *"SELF\_TYPE"* are tokenized as *OBJECTID* and *TYPEID* respectively.

- test_7.cl: The last test case file demonstrates the ability of the lexer to be able to recognize symbols even when they are not whitespace separated. Multi character symbols like '<=' are tokenized by their token name, ie. LE in this case. Single character symbols are tokenized as is. '<' is tokenized as '<'. It also shows how the lexer handles unknown symbols and then resumes lexing at the following character.
