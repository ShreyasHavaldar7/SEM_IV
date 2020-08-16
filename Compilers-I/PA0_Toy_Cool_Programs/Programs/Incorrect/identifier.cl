(* Shreyas Havaldar *)
(* CS18BTECH11042 *)
(* Incorrect Program for section 10.1 *)
class Main inherits IO {
    main() : Object {
        let int#1: Int<-7, int2: Int <- 7 in {
        	int2 <- 7.7;
        	
        	(* ERROR = Identifier containing #, integer being assigned 7.7 *)
        	(* Integers are non-empty strings of digits 0-9. Identifiers are strings (other than keywords) consisting of letters, digits, and the underscore character. *)
        	
        	out_int(int#1);
		}    
    };
};