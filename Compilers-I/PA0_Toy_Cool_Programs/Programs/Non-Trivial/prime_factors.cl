(* Shreyas Havaldar *)
(* CS18BTECH11042 *)

class Main inherits IO {
    mod(x:Int, y:Int): Int { (* Utility function to calculate the remainder of x/y *)
        x - ((x/y)*y)
    };
    checkPrime(n: Int) : Bool { (* Utility function to check if the number passed is prime or not *)
        let check: Bool <- true, i: Int <- 2 in {
            if (n <= 1) then false (* If non-positive or 1 then not prime *)
            else if (n <= 3) then true (* 2 and 3 are prime numbers *)
            else { 
                while (i * i <= n)  (* Iterating upto sqaureroot of n, for all n > 3 *)
                loop {
                    if (mod(n,i) = 0) (* If n is divisible by any number between 2 and n-1, it is not prime *)
                    then check <- false
                    else 0
                    fi;
                    i <- i + 1; (* Incrementing the iterator *)
                } pool;

            }
            fi
            fi;
            check;

        }
    };

    main() : Object {
        let no: Int <- 0, i: Int <- 2 in {
            out_string("Enter a positive number \n");
            no <- in_int();
            out_string("Prime factor(s) of the entered number are: \n");

            if no = 1
            then out_string("No prime factors!\n") (* 1 has no prime factors *)
            else {
	            while not no<i (* To loop until the no to find its factors *)
	            loop {
	                if(mod(no,i) = 0) (* If a number is factor of the user entered no, checking if it is prime, if it is, then printing it on the output *)
	                then if checkPrime(i) 
	                     then {
	                        out_int(i);
	                        out_string("\n");
	                        }
	                     else 0
	                     fi
	                else 0
	                fi;
	                i <- i + 1; (* Incrementing the iterator *)
	            } pool;
        	}
            fi;
        } 
    };
};