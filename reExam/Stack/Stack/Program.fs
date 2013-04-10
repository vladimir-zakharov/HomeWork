exception EmptyStackException of string

type Stack<'a>() =
    let mutable list : 'a list = []
    member this.push(value) = list <- value :: list
    member this.pop =
        match list with
        | hd :: tl -> 
            list <- tl
            hd
        | [] -> raise (EmptyStackException "failed pop method. The stack is empty!")
    member this.isEmpty = list.Length = 0

let testStack = Stack<int>()

testStack.push 10
testStack.push 15
testStack.push 20
printfn "%A" testStack.isEmpty
try
    printfn "%A" testStack.pop
with
    | EmptyStackException str -> printfn "%s" str
try
    printfn "%A" testStack.pop
with
    | EmptyStackException str -> printfn "%s" str
try
    printfn "%A" testStack.pop
with
    | EmptyStackException str -> printfn "%s" str
try
    printfn "%A" testStack.pop
with
    | EmptyStackException str -> printfn "%s" str

printfn "%A" testStack.isEmpty

