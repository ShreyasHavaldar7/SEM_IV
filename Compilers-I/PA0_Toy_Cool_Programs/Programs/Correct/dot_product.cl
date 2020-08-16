(* Shreyas Havaldar *)
(* CS18BTECH11042 *)

class Main inherits IO {
    main() : Object {
        let x1: Int <- 0, y1: Int <- 0, x2: Int <- 0, y2: Int <- 0 in {
        	out_string("Enter two 2D vectors as co-ordinates, ie. 4 integer values \n");
            x1 <- in_int();
            y1 <- in_int();
            x2 <- in_int();
            y2 <- in_int();
            (* Inputting the vector co-ordinates *)
            out_string("The dot product of the vectors between the points is ");
            out_int(x1*x2 + y1*y2); (* Calculating and printing dot product *)
            out_string(".\n");           
        }
	};
};
