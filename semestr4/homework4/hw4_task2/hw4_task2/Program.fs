let multiplyList0 y list = List.map(fun x -> x * y) list
let multiplyList1 y = List.map(fun x -> x * y)
let multiplyList2 y = List.map((*) y)
let multiplyList3 = List.map << (*)
printfn "%A" (multiplyList0 10 [1; 2; 3])
printfn "%A" (multiplyList1 10 [1; 2; 3])
printfn "%A" (multiplyList2 10 [1; 2; 3])
printfn "%A" (multiplyList3 10 [1; 2; 3])