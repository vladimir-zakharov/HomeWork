let rec reverseList list newList = 
    match list with
    | h::t -> 
        let newList = List.head list :: newList 
        reverseList list.Tail newList
    | [] -> newList

System.Console.WriteLine(reverseList [1; 3; 2;] [])