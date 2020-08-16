(* Shreyas Havaldar *)
(* CS18BTECH11042 *)
(* Incorrect Program for section 10.2 *)
class Main inherits IO {
    main() : Object {
        out_string("Hello
                   World!") (* ERROR = Unterminated string constant *)
        (* A non-escaped newline character may not appear in a string *)
    };
};