% Shreyas Jayant Havaldar
% CS18BTECH11042

:- use_module(library(clpfd)). % Required for predicate maplist/2
:- write('Enter map and colours as colouring(map(name, list of states with neighbours), list of colours)').

% Predicate maplist/2: maplist(:Goal, ?List) is True if Goal is successfully applied on all matching elements of the List.
% Predicate member/2: member(?Elem, ?List) is True if Elem is a member of List.

colouring(map(_Name,States), Colours):- % Input the map and the list of colours from the user in the specified format, call the colour assignment predicate and colour checking predicate in succession. 
    colour_assignment(States, Colours), % First assign colours to all states
    colour_checking(States). % To check if the assigned colours cause any conflict, ie. if two neighbours are coloured the same
    % If colour_checking evaluates to false, ie. if two neighbours are coloured the same, via the backtracking nature of Prolog, a different colour assigment is tried until the predicate evalutes to true, and then prints the non-conflicting assignment on the console using least number of colours possible, if no such assignment exists, colouring evaluates to false.
    % This program prints all possible valid solutions if you press semi-colon repeatedly.
    % Each of the state is a variable itself, which then stores the colour assigned to it.

colour_checking([]). % Always true as no conflict for empty list of states.
colour_checking([S:Ns|Ss]):- % Checks for each state, whether the colour assigned to it is identical to any of its neighbours, in order. 
    maplist(\=(S),Ns), % Here the List is all the neighbouring states, and Goal is that the colour assigned to them is not same as the state S.
    colour_checking(Ss). % Recursively checks all the other states remaining in the list.

colour_assignment([], _Colours). % Always true as any colour can be assigned for empty list of states.
colour_assignment([S:_Ns|Ss], Colours):- % Assigns a colour to each state by picking a colour from the list of colours in order. 
    member(S,Colours), % Here ensures if the value assigned to the State belongs to the list of colours.
    colour_assignment(Ss, Colours). % Recursively assigns colours to all the other states remaining in the list.

% Sample Input: 
% colouring(map('India',[MA:[GO,KA,TL], GO:[MA,KA], KL:[TN,KA], TN:[KL,KA,AP], KA:[TL,KL,TN,AP,MA,GO], AP:[TL,TN,KA], TL:[KA,AP,MA]]),[blue, green, red, yellow]).