let maxPairPos list =
    let list = List.zip (0 :: list) (list @ [0])
    let list = List.map (fun (a, b) -> a + b) list
    let max = List.max list
    List.findIndex((=) max) list 

let list1 = [1; 5; 6; 2]
printf "maxPairPos = %d\n" (maxPairPos list1)