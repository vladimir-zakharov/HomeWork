let countEvenFilter list =
    List.length (List.filter (fun x -> x % 2 = 0) list)

let countEvenMap list =
    let list = List.map (fun x -> x % 2) list
    List.reduce (+) list

let countEvenFold list =
    List.fold (fun acc x -> acc + x % 2) 0 list

let testList = [1; 5; 6; 3; 8; 2]
printf "%d\n" (countEvenFilter testList)
printf "%d\n" (countEvenMap testList)
printf "%d\n" (countEvenFold testList)


