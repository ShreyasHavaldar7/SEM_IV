(* Shreyas Havaldar *)
(* CS18BTECH11042 *)
(* Handling of complex correct constructs in strings, especially the ones due to backslashes and error due to backslash at the end of file *)

"Namaste\
World" 
(* Escaped new line in string is allowed *)

"Hello with \n newline character" (* \n character in string is allowed *)

"\0" (* Within a string, a sequence ‘\c’ denotes the character ‘c’, with the exception of the specially defined escape sequences, namely '\b', '\t', '\n', '\f' *)

"\" Namashkar World \"" (* Escaped quotes and backslashes in string are allowed *)

"\\"

(* But a backslash needs to be followed by a character, it cannot occur at the end of the file*)
"hello backslash followed by EOF here\