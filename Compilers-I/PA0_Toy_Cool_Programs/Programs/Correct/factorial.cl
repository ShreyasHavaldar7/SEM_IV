(* Shreyas Havaldar *)
(* CS18BTECH11042 *)

class Main inherits IO {

    fact(n: Int) : Int { (* Recursive function to calculate factorial *)
        if(n=0) 
        then 1
        else n*fact(n-1)
        fi
    };

    main() : Object {
        let no: Int <- 0 in {
            out_string("Enter a number \n");
            no <- in_int(); (* Inputting the number *)
            out_string("Factorial of entered number is ");
            out_int(fact(no)); (* Printing the calculated factorial *)
            out_string(".\n");
        } 
    };
};