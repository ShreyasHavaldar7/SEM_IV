(* Shreyas Havaldar *)
(* CS18BTECH11042 *)

class Main inherits IO {
    main() : Object {
        let a: Int <- 0, b:Int <- 0 in {
            out_string("Enter two non-zero numbers \n");
            a <- in_int(); (* Inputting the two non-zero *)
            b <- in_int();

            while not a = b (* While loop to implement Euclid's algorithm for calculating GCD *)
            loop
                if a <= b
                then b <- b - a
                else a <- a - b
                fi
            pool;
            
            out_string("The GCD of the two numbers entered is "); (* Printing the GCD calculated *)
            out_int(a);
            out_string(".\n");
        }
    };
};



