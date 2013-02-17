let rec fib n =
    match n with
    | 1 | 2 -> 1
    | _ -> fib (n - 1) + fib (n - 2)

System.Console.WriteLine(fib 8)

