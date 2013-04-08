type Tree<'a> =
    | Tree of 'a * Tree<'a> * Tree<'a>
    | Tip of 'a

let rec treeMap funct tree =
    match tree with
    | Tree(node, l, r) -> Tree(funct node, treeMap funct l, treeMap funct r)
    | Tip node -> Tip(funct node)

let tree = Tree(1, Tip(2), Tip(3))
printfn "%A" <| treeMap (fun x -> x * 10) tree
