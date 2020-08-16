Note: Please have a look at the program comments for detailed explanations about the logic correctness and predicate definitions.


Input Format: 
colouring(map(Name of Map, List of states(each with list of its neighbors)), list of colours).


How to run:
On entering the swipl console by entering swipl map_colouring.pl in the terminal, enter the query input as specified in the input format. Enter semicolon ‘;’ for the program to print more valid colour assignments, press Enter key to end that query. The program is designed such that it will try to use the least number of colours as possible. As seen below, for the sample input only 3 colours are required, so MA, KL, AP are all assigned blue, GO, TL, TN all assigned green, KA is assigned red. Other valid solutions follow on pressing ‘;’, until the query is terminated by pressing Enter key, or it exhausts all valid assignments.


Sample Input/Output:
Enter map and colours as colouring(map(name, list of states with neighbours), list of colours)


?- colouring(map('India',[MA:[GO,KA,TL], GO:[MA,KA], KL:[TN,KA], TN:[KL,KA,AP], KA:[TL,KL,TN,AP,MA,GO], AP:[TL,TN,KA], TL:[KA,AP,MA]]),[blue, green, red, yellow]).
MA = KL, KL = AP, AP = blue,
GO = TL, TL = TN, TN = green,
KA = red .


(Note: Enter Key was pressed to terminate the sample output)