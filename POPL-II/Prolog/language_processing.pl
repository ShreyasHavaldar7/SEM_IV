% Shreyas Jayant Havaldar
% CS18BTECH11042

:- write('Enter sentence as sentence(fact or query)').
% Predicate dynamic/1: Informs the interpreter that the definition of the predicate(s) may change during execution, required as I use assertz/1 predicate on both of these.
:- dynamic is_a/2. % Dynamic predicate is_a(X,Y) to add specific facts to the knowledge base as relations between X and Y, eg. "George is a man." X = "George", Y = "man", is_a("George","man"). 
:- dynamic a_is_a/2. % Dynamic predicate a_is_a(X,Y) to add general facts to the knowledge base as relations between X and Y, eg. "A man is a person." X = "man", Y = "person", a_is_a("man","person").

% Predicate: sub_string/5: In sub_string(+String, ?Before, ?Length, ?After, ?SubString) SubString is a substring of String. There are Before characters in String before SubString, SubString contains Length character and is followed by After characters in String.
% Predicate: split_string/4: split_string(+String, +SepChars, +PadChars, -SubStrings) breaks String into SubStrings. The SepChars argument provides the characters that act as separators and thus the length of SubStrings is one more than the number of separators found if SepChars and PadChars do not have common characters.
% Predicate assertz/1: In assertz(+Term) Assert a clause (fact or rule), Term into the database, as the last clause.

% There can be three types of sentences S corresponding to each of the following 3 predicates: Please enter S to be of exactly one of these 3 types, where X and Y can be anything but the other words stay the same.
% fact_general/2: sentence("A X is a Y.")
% fact_specific/2: sentence("X is a Y.")
% query_data/2: sentence("Is X a Y?")

sentence(S):- % Inputs the sentence entered by the user into S
    sub_string(S, 0, _, 1, S_clean), % S_clean stores the sentence entered by the user without the ending character, ie. without . or ?
    sub_string(S, _, 1, 0, Punct), % Punct stores the last character of the sentence, ie. . or ?, to determine whether it is a fact or a query
    sub_string(S, 0, 1, _, C), % C stores the first character of the sentence, to determine if it is a general fact or a specific fact
    split_string(S_clean, " ", " ", L), % Splits the sentence string into list of words, stored in L
    ((Punct = ".") -> % If the sentence is a fact
        ((C = "A") -> % If the sentence is a general fact, ie. beginning with 'A', as opposed to beginning with a proper noun.
        fact_general(L, "."); % Then the fact_general predicate is called.
        fact_specific(L, ".")); % Else the fact_specific predicate is called, as the sentence begins with a proper noun, as opposed to 'A'.
    query_data(L, "?")). % If the sentence is not a fact, it is a query and the query_data predicate is called.

% Above I employed two if conditions and their respective else clauses to determine the right predicate to be called on basis of the type of sentence S

% X is a common/collective noun here and Y is a class to which it belongs, eg. "A man is a person."
fact_general(["A", X, "is", "a", Y], "."):-  
    ((a_is_a(X,Y)) -> % Checks if the fact already exists in the knowledge base, otherwise adds it to the knowledge base using assertz.
    (a_is_a(X,Y)); % True if above if clause satisfied as fact exists in the knowledge base, so assertz predicate not invoked
    assertz(a_is_a(X,Y))). % As the fact does not exist in the knowledge base, adds it using assertz.

% X is a proper noun here and Y is a class to which it belongs, eg. "George is a man."
fact_specific([X, "is", "a", Y], "."):- 
    ((is_a(X,Y)) -> % Checks if the fact already exists in the knowledge base, otherwise adds it to the knowledge base using assertz.
    (is_a(X,Y)); % True if above if clause satisfied as fact exists in the knowledge base, so assertz predicate not invoked
    assertz(is_a(X,Y))). % As the fact does not exist in the knowledge base, adds it using assertz.

subclass(B,B):- % A class is always a subclass of itself, using cut to prevent checking further, as this predicate evalutes to true, so relation established.
    !.
subclass(B,C):- % Checks recursively if B is a sub class of C through any possible path
    ((a_is_a(B,C)) -> % Checks if a direct fact connecting B and C exists, eg. "A man is a person."
    (a_is_a(B,C), % True if the direct relation exists so no need to check further
    !); % If found use cut to prevent checking further as one relation found true, so relation exists.
    (a_is_a(B,D), % If no direct relation exists, checks recursively if there is an intermediate class such that B is directly related to it, and it is the subclass of C 
    subclass(D,C), % If not found keep checking via intermediate classes
    !)). % Cuts are only employed when the full path has been found

query_data(["Is", A, "a", C], "?"):- % Answers the users query based on the database by searching recursively.
    ((is_a(A,C)) -> % Checks if a direct fact connecting X and Y exists, eg. "George is a man."
    (is_a(A,C)); % True if the direct relation exists so no need to check further
    (is_a(A,B), % If a direct fact does not exist, checks for indirect multi levels of relations
    subclass(B,C))). % Calls predicate to check if there is a track from B to C via some sub classes,     