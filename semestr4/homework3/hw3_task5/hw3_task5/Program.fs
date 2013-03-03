type Tree<'a, 'b> =
    | Tree of 'a * Tree<'a, 'b> * Tree<'a, 'b>
    | Tip of 'b

exception InvalidOperation of string

let rec calculate tree =
    match tree with
    | Tree(operation, l, r) ->
        match operation with
        | '+' -> calculate l + calculate r
        | '-' -> calculate l - calculate r
        | '*' -> calculate l * calculate r
        | '/' -> calculate l / calculate r
        | _ -> raise (InvalidOperation "invalid operation!")
    | Tip number -> number

let testTree = Tree('+', Tree('*', Tip(2), Tip(3)), Tip(20))
try
    printf "%d\n" (calculate testTree)
with
    | InvalidOperation(str) -> printfn "%s" str