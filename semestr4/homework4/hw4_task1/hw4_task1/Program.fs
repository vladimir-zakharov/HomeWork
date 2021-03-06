﻿open System.Collections.Generic

let isEmpty (stack : Stack<'a>) =
    stack.Count = 0

let checkBalance (str : string) =
    let stack = new Stack<char>()
    let length = str.Length
    let rec check i =
        if i < length then
            let checkSymbol symbol =
                let chr = stack.Pop() 
                match symbol with
                | ')' -> chr <> '(' 
                | '}' -> chr <> '{'
                | ']' -> chr <> '[' 
                | _ -> false
            match str.[i] with
            | '(' | '{' | '[' as char -> 
                stack.Push char
                check (i + 1)
            | ')' | '}' | ']' as char -> 
                if isEmpty stack then false
                elif checkSymbol char then false
                else check (i + 1)
            | _ -> check (i + 1)
        else
            isEmpty stack
    check 0

printfn "%b" (checkBalance "()()({})[{()()}{})]")
printfn "%b" (checkBalance "()()({})[{()()}{}]")
printfn "%b" (checkBalance "]")
printfn "%b" (checkBalance "(((({{")
