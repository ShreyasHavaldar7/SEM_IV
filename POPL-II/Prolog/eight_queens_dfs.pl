% Shreyas Jayant Havaldar
% CS18BTECH11042

:- use_module(library(clpfd)). % Required for #\= operator.
:- write('Enter "queens(S)." to list all solutions for eight queens puzzle, using DFS strategy').

dimensions([1/_C1, 2/_C2, 3/_C3, 4/_C4, 5/_C5, 6/_C6, 7/_C7, 8/_C8]). % As the solutions are required in this format, maintaining the chess board configuration thus.

columns([1,2,3,4,5,6,7,8]). % List of columns in the chess board from which we have to choose one

% Using of the above two predicates allows this program to be easy to adpat to different sizes of the chess board

% The tree in my program consists of each node having 8 children, each child is the placement of a queen on the next row for every column.
% Each level of the tree corresponds to one row, thus there are 8 levels in the tree(apart from the root, which is a single node representing an empty board), each having 8 nodes.
% I start placing a queen on the 1st row initially, then keep moving towards the 8th row, ensuring the placement is safe.
% DFS here is achieved by the backtracking nature of Prolog, first a column from the list columns is chosen, then if the board configuration is safe for placing a queen in that column of the row, the next row is evaluated.
% The columns are succesively picked from 1 to 8 and tested for being safe board configuration by using the predicate check.
% When a column for every row has been picked, the board has 8 safe queens on it and this is returned as a solution.
% If at any point, no column for a row is safe, the program backtracks to the previous row and selects the next column, repetitively until all safe paths of the tree are explored.

queens(S):- % Main predicate which is triggered by the user, all the solutions are stored in S.
    dimensions(Board), % Obtaining the initial chess board configuration, where all rows are empty, and the queens have to be placed in the columns.
    control(Board), % Calling the control predicate with the board configuration.
    S = (Board). % The board configuration at the end of one complete traversal of the tree is the solution, with a queen on some column of every row, such that no two queens attack each other.

control([]). % The board has been filled up, as all rows from the dimensions have been assigned a column in which the queen is placed, as the list is now empty. So is true.
control([R/C|Rs]):- % Extracts a row R from the board dimensions and tries to place a queen on one of its columns safely.
    columns(Cs),
    member(C, Cs), % The column C must belong to the list columns
    check(R/C, Rs), % Checking if the placement of a queen in row R and column C is safe for the current board configuration
    control(Rs). % Recursively calling the control predicate to place queens on the remaining rows Rs, of the board.

% Arithmetic constraints from CLP(FD) library subsume and supersede low-level predicates over integers. The main advantage of arithmetic constraints is that they are true relations and can be used in all directions. 
% Operator #\=/2: ?X #\= ?Y is true if the arithmetic expressions X and Y evaluate to distinct integers. Used because these constraints can be used in all directions, also if one or more of their arguments are only partially instantiated, which is the case with our Cx variable initially.
check(_X,[]). % We can place a queen on empty board anywhere, is a safe position always, so true.
check(R/C, [Rx/Cx|Rs]):- % For a non empty board, checks if placement of a queen in row R and column C, does not attack any other queens already placed on the board.
    % 2 queens attack each other if any one of the following two relations fails. If both relations hold true, the queen placement is safe and check proceeds to recursively check conflict of R with the other rows on the board.
    C #\= Cx, % The two queens in different rows should not be in the same column
    abs(C - Cx) #\= abs(R - Rx), % The two queens should not lie on each others diagonal, so the absolute value of the difference between their column and row numbers should not be the same.
    check(R/C,Rs). % Check for possibility of placement of a queen in row R and column C, attacking queens in the other rows.