let hasSameElements list =
    let rec check list length =
        match list with
        | hd :: tl -> 
            let filteredList = List.filter ((<>) hd) list
            if List.length filteredList = length - 1 then
                check tl (length - 1)
            else
                true
        | [] -> false
    check list (List.length list)

let testList1 = [1; 2; 3; 4; 5]
let testList2 = [1; 2; 3; 3; 5]
printf "%A\n" (hasSameElements testList1)
printf "%A\n" (hasSameElements testList2)