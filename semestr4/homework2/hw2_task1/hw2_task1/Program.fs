let rec reverseList list newList = 
    match list with
    | h::t -> 
        let newList = list.Head :: newList 
        reverseList list.Tail newList
    | [] -> newList

System.Console.WriteLine(reverseList [1; 3; 2] [])

let reverseList2 list =
    List.fold(fun reversedList x -> x :: reversedList) [] list

System.Console.WriteLine(reverseList2 [1; 3; 2])