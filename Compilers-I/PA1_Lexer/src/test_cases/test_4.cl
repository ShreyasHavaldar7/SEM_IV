(* Shreyas Havaldar *)
(* CS18BTECH11042 *)
(* Handling of errors in comments *)

-- This is a single line comment
"This is not an part of the single line comment as it ends when it encounters a newline"

(* Multi line comment ends when it meets the characters * and ) 
in immediate succession*) "So this is not a part of the comment"

*) (* Unmatched termination of comment *)

(* Due to (* nesting (* comments *) extend until EOF error as equal no of *) as (* not encountered
(* This is the comment that contains EOF