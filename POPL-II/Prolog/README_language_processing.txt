Note: Please have a look at the program comments for detailed explanations about the logic correctness and predicate definitions.


Input Format: 
sentence(Fact or Query(enclosed in double quotes)).
ie.         sentence("Fact"). 
sentence("Query").


How to run:
On entering the swipl console by entering swipl language_processing.pl in the terminal, enter the fact/query input as specified in the input format. If you enter a fact, ie. a sentence terminating in a period(‘.’), the fact will be added to the knowledge base and program prints true to the console. If you enter a query, ie. a sentence terminating in a question-mark(‘?’), the query will check the facts present in the knowledge base and determine if the query holds. Program prints true to the console if the knowledge base contains relations which evaluate the query to true, otherwise the program prints false. The program takes care of multiple levels of relations and multiple paths existing to evaluate the query and does not print duplicate values, that is it does not print true twice if two paths exist which determine the query to be true. It also checks the existence of facts in the knowledge base to see if a fact entered by the user already exists, and thus does not duplicate facts in the knowledge base.


Sample Input/Output:
Enter sentence as sentence(fact or query)


?- sentence("Is George a man?").
false.


?- sentence("George is a man.").
true.


?- sentence("Is George a man?").
true.


?- sentence("Is George a person?").
false.


?- sentence("A man is a person.").
true.


?- sentence("Is George a person?").
true.