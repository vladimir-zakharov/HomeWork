let supermap funct list =
    let rec add lst newLst =
        match lst with
        | hd :: tl -> 
            let newLst = hd :: newLst
            add tl newLst
        | [] -> newLst
    let rec smap funct list newList =
        match list with
        | hd :: tl -> 
            let newList = add (funct hd) newList
            smap funct tl newList
        | [] -> newList
    List.fold(fun reversedList x -> x :: reversedList) [] (smap funct list [])

let list = [0.0; 2.0; 3.0]
printfn "%A" (supermap (fun x -> [sin x; cos x]) list)