let rec factor n = 
    match n with 
    | 0 -> 1 
    | _ -> n * factor (n - 1)

System.Console.WriteLine(factor 5)