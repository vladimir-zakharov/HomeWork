let rec firstEntry list number pos = 
    match list with
    | h::t -> 
        if number = list.Head then 
            pos
        else
            firstEntry list.Tail number (pos + 1)
    | [] -> -1

System.Console.WriteLine(firstEntry [1; 4; 5; 2; 7; 2] 2 0)