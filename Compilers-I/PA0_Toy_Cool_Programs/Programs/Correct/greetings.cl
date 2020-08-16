(* Shreyas Havaldar *)
(* CS18BTECH11042 *)

class Main inherits IO {
    main() : Object {
       let name: String <- "" in {
            out_string("Hey! What's your name? \n"); (* Prompts the user to enter his/her name *)
            name <- in_string();
            out_string("Greetings! ".concat(name.concat(". \n"))); (* Prints the greeting by concatenating user name ay the end. *)
        }  
    };
};