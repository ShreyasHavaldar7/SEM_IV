(* Shreyas Havaldar *)
(* CS18BTECH11042 *)

class Main inherits IO {

    palind(s: String) : Bool {

    if s.length() = 0 (* Recursive function to check if a string is palindrome by matching characters from both ends of the string *)
    then true
    else if s.length() = 1
    then true
    else if (s.substr(0,1) = s.substr(s.length()-1, 1))
    then palind(s.substr(1, s.length() - 2))
    else false
    fi
    fi
    fi
    };
   
    main() : Object {
        let i: Int <- 0, s: String <- " ", s_copy: String <- " ", len: Int <- 0, wc: Int <- 0, choice: Int <- 0, str: String <- "" in {
            out_string("Enter: \n0 for Word Count,\n1 for Character Count,\n2 for Name to Initials Converter, \n3 to check if the sentence is palindrome\n"); (* Letting the user know of the functionalities *)
            choice <- in_int();
            out_string("Enter a sentence to analyze \n");
            s <- in_string();
            s_copy <- s; (* Storing a copy of the original string *)
            s <- " ".concat(s); (* Adding a whitespace to the beginning of the string *)
            len <- s.length();

            while not i = len (* Loop to iterate through the sentence *)
            loop {
                if s.substr(i, 1) = " " 
                then {
                    wc <- wc + 1; (* Counting the no of words in the sentence *)
                    str <- str.concat(s.substr(i+1,1)); (* Storing the initials created from the sentence *)
                    str <- str.concat(".");
                } else 0 
                fi;
                i <- i + 1; (* Incrementing the iterator *)
            } pool;   

            if choice = 0 (* Checking the user choice and printing the required result *)
            then {
            out_string("Number of word(s) in the sentence is ");
            out_int(wc);
            out_string(".\n");
            } else if choice = 1 then {
                out_string("Number of character(s) in the sentence including whitespaces is ");
                out_int(len-1); (* Subtracting 1 due to the whitespace we added in line 27 *)
                out_string(".\n");
                out_string("Number of character(s) in the sentence excluding whitespaces is ");
                out_int(len-wc); (* As words are equal to the number of whitespaces in the new sentence *)
                out_string(".\n");
            } else if choice = 2 then {
                out_string(str);
                out_string("\n"); 
            } else if choice = 3 then {
                if palind(s_copy)
                then out_string("A Palindrome String! \n")
                else out_string("Not a Palindrome String! \n")
                fi;
            } else {
            out_string("Invalid Choice\n"); (* Printing if user enters anything other than 0,1,2 or 3 *)
            } 
            fi
            fi
            fi
            fi;
              
        }
    };
};