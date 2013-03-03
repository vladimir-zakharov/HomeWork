type Tree<'a> =
    | Tree of 'a * Tree<'a> * Tree<'a>
    | Tip of 'a

let rec height tree =
    match tree with
    | Tree(_, l, r) -> 1 + max (height l) (height r)
    | Tip _ -> 1

let testTree = Tree(10, Tree(1, Tip(2), Tip(3)), Tip(20))
printf "%d\n" (height testTree)

