% Shreyas Jayant Havaldar
% CS18BTECH11042

:- write('Enter "queens(S)." to list all solutions for eight queens puzzle, using BFS strategy').

% Predicate append/3: In append(?List1, ?List2, ?List1AndList2) List1AndList2 is the concatenation of List1 and List2
% Predicate is_list/1: is_list(+Term) is True if Term is bound to the empty list ([]) or a term with functor ’[|]' and arity 2 and the second argument is a list.

dimensions([1/_C1, 2/_C2, 3/_C3, 4/_C4, 5/_C5, 6/_C6, 7/_C7, 8/_C8]). % As the solutions are required in this format, maintaining the chess board configuration thus.

columns([1,2,3,4,5,6,7,8]). % List of columns in the chess board from which we have to choose one

% Using of the above two predicates allows this program to be easy to adpat to different sizes of the chess board

% The tree in my program consists of each node having 8 children, each child is the placement of a queen on the next row for every column.
% Each level of the tree corresponds to one row, thus there are 8 levels in the tree(apart from the root, which is a single node representing an empty board), each having 8 nodes.
% I start placing a queen on the 1st row initially, placing queens on all columns and checking for their validity.
% BFS here is achieved by moving on to the next row only when all possible valid queen placements on columns of this row have been evaluated.
% The columns are succesively picked from 1 to 8 and tested for being safe board configuration by using the predicate check.
% While maintaing the list of valid board configurations for queen placements on this column of this row, queen placements on other columns of this row are evaluated
% There is no backtracking to previous rows as all valid configurations until that level of tree are already maintained, so breadth first nature is ensured.

queens(S):- % Main predicate triggered by the user
    dimensions(Board), % Obtaining the initial chess board configuration, where all rows are empty, and the queens have to be placed in the columns.
    control(S, Board, []). % Calling the control predicate with the empty board configuration and an empty list which will eventually filled with list of all queen placements across all rows, removing rows from the parameter Board

control(S, [], Boards):- % When the second parameter is empty, all the rows from the Board have been extracted and assigned all possible safe columns in which the queen can be placed.
    member(S, Boards). % At this moment the list of lists Boards is filled with lists of all valid configurations of the queen placement on the board. Obtaining each valid placement as S(which is a list in required format.), a member of Boards. 
control(S, [R/_C|Rs], Boards):- % When all the rows of the Board have not been explored, extracting the next row from the list and checking valid placements on its columns.
    find_possibility(Boards, Updated_Boards, R), % Evaluating the placement of placing a queen in a column in this row, and receving the updated the valid the Board configurations in which all the queens are safe.
    manage(Updated_Boards, Updated_Board_Managed), % Used to manage the nesting in the lists, as Updated_Boards will be received as a list of list of list, reducing it to a list of lists Updated_Board_Managed, the correct format for the parameter to recursively call the predicate control.
    control(S, Rs, Updated_Board_Managed). % Once all possible column placements for this row have been explored and the board configuration updated thus, moving on to the next row in the board.

find_possibility([], [Initial], 1):- % Invoked when the queens are placed along the 1st row with Initial board config. 
    columns(D), % Need to evaluate the placement of queens at all columns from 1 to 8.
    validate_possibility([], D, Initial, 1), % Validating the board configuration for all placements along this row
    !. % Use of cuts to prevent next definition of this predicate being invoked.
find_possibility([B|Bs], [UB|UBs], R):- % General definition of predicate to evaluate placement of queen at rows other than 1.
    columns(D),  % Need to evaluate the placement of queens at all columns from 1 to 8.
    validate_possibility(B, D, UB_temp, R), % Validating the board configuration for all placements along this row
    remove(UB_temp, UB), % To remove empty lists from the list of lists of lists UB_temp to put in UB
    find_possibility(Bs, UBs, R), % To recursively check for valid queen placements in the next row with updated board configuration retrieved from placing all valid arrangements of queens on columns along this row.
    !. % Use of cuts to prevent next definition of this predicate being invoked.
find_possibility([], [], _R). % All the possible board configurations have been explored so we can return to control predicate.

validate_possibility(_B, [], [], _R):- % If the evaluation of the placement of the queens on all the columns is done and there is a queen on the 8th column, return true.
    !. % Use of cuts to prevent next definition of this predicate being invoked.
validate_possibility(B, [C|D] , [UB|UBs], R):- % Evaluation of the placement of queens along columns in the row, while updating the board configuration if successful.
    ((check(R/C, B)) ->  % Checking if the placement of a queen in row R and column C is safe for the current board configuration
    ((append(B, [R/C], UB)), % If it evaluates to true, ie. the placement is safe, append this placement to the board configuration for the evaluation of the next row.
    validate_possibility(B, D, UBs, R), % Validate other column placement possibilities along this row with the list of possible board configuration updated for this placement
    !);
    (validate_possibility(B, D, [UB|UBs], R)), % If it is false, ie. the placement is unsafe, validate other column placement possibilities along this row without any change in the list of board configurations 
    !).
validate_possibility(_B, [], [[]|[]], _R). % If the evaluation of the placement of the queens on all the columns is done and there is not a queen on the 8th column, return true. Needed to manage empty lists as it would not match with the first definition of this predicate.

% Utility predicate to manage the level of nesting in the lists, to reduce list of lists of lists, to list of lists or list of lists to lists and so on. Example follows.
% ?- manage([[7],[9,8]], X).
% X = [7, 9, 8].
manage([], []). 
manage([A|B], Managed):-
    is_list(A),
    manage(B, UB),
    !,
    append(A, UB, Managed).
manage([A|B], [A|UB]):-
    manage(B,UB).

% Utility predicate to remove empty lists from list of lists. Example follows.
% ?- remove([[7,8], [7], [], []], X).
% X = [[7, 8], [7]].
remove([],[]):- 
    !.
remove([[]|Xs], Ys):-
    remove(Xs, Ys),
    !.
remove([X|Xs], [X|Ys]):-
    remove(Xs,Ys).

% Do not need to use arithemetic constraints from CLP(FD) library here since all columns Cx have been fully instantiated.
check(_X,[]). % We can place a queen on empty board anywhere, is a safe position always, so true.
check(R/C, [Rx/Cx|Rs]):-  % For a non empty board, checks if placement of a queen in row R and column C, does not attack any other queens already placed on the board.
    % 2 queens attack each other if any one of the following two relations fails. If both relations hold true, the queen placement is safe and check proceeds to recursively check conflict of R with the other rows on the board.
    C =\= Cx, % The two queens in different rows should not be in the same column
    abs(C - Cx) =\= abs(R - Rx), % The two queens should not lie on each others diagonal, so the absolute value of the difference between their column and row numbers should not be the same.
    check(R/C,Rs). % Check for possibility of placement of a queen in row R and column C, attacking queens in the other rows.