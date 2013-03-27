exception EmptyQueue of string

type Queue =
    {members : int []}
    let mutable counter <- 0
    member this.Count = counter
    member this.Enqueue(value) = value :: list
    member this.Dequeue = 
        match list with
        | hd :: tl -> tl
        | [] ->  raise (EmptyQueue "Queue is empty!")



