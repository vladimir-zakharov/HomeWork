type Tree<'a> =
    | Tree of 'a * Tree<'a> * Tree<'a>
    | Tip of 'a

let height tree =
    let rec tempHeight tree acc =
        match tree with
        | Tree(_, l, r) -> 1 + max (tempHeight l (acc + 1)) (tempHeight r (acc + 1))
        | Tip _ -> 1
    tempHeight tree 0

let testTree = Tree(10, Tree(1, Tip(2), Tip(3)), Tip(20))
printf "%d\n" (height testTree)

