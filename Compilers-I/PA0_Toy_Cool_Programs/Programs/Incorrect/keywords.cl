(* Shreyas Havaldar *)
(* CS18BTECH11042 *)
(* Incorrect Program for section 10.4 *)
class Main inherits IO {
    main() : Object {
        let flag:Bool<-True, check:Bool<-fAlSe in { (* ERROR = in syntax error at or near TYPEID = True *)
        (* the first letter of true and false must be lowercase, the trailing letters may be upper or lower case. *)
            if(flag = check)
            then out_string("Passed\n")
            else out_string("Failed\n")
            fi;
        }
    };
};