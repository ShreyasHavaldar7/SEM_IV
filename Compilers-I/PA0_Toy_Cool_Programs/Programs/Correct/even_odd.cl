(* Shreyas Havaldar *)
(* CS18BTECH11042 *)

class Main inherits IO {
    
    mod(x:Int, y:Int): Int {
        x - ((x/y)*y)
    };    

    main() : Object {
        let a: Int <- 0 in {
            out_string("Enter a number to check if it is even or odd \n");
            a <- in_int(); (* Inputting the number *)
            if mod(a,2) = 0  (* Checking if the number is divisible by 2 and printing correspondingly *)
            then out_string("Entered number is EVEN.\n")
            else out_string("Entered number is ODD.\n")
            fi;            
        }
    };
};