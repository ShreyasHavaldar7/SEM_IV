(* Shreyas Havaldar *)
(* CS18BTECH11042 *)
(* Incorrect Program for section 10.5 *)
class Main inherits IO {
    main() : Object {
        out_string("Hello!   ") (* ERROR = \357 *)
        (* White space consists of any sequence of the characters: blank (ascii 32), \n (newline, ascii 10), \f (form feed, ascii 12), \r (carriage return, ascii 13), \t (tab, ascii 9), \v (vertical tab, ascii 11). I used U+2007, FIGURE SPACE after ! in line 7 *)
    };
};