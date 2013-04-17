open System.ComponentModel

let array = Array.init 1000000 (fun x -> 1)

let sum10000Elements startPos =
    let rec sum i acc =
        if i > startPos + 9999 then acc
        else sum (i + 1) (acc + array.[i])
    sum startPos 0

let mutable res = 0

let flags = Array.init 100 (fun x -> false)

for i in 0..99 do
    let worker = new BackgroundWorker()
    worker.DoWork.Add(fun args -> args.Result <- box <| sum10000Elements (i * 10000)) 
    worker.RunWorkerCompleted.Add(fun args -> 
                                    res <- res + (args.Result :?> int)
                                    flags.[i] <- true)
    worker.RunWorkerAsync()

while not (Array.forall(fun x -> x = true) flags) do ()

printfn "%A" res