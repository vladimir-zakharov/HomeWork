open System.Collections.Generic
open System

type TreeElement<'a when 'a : comparison>(value : 'a) =
    let mutable left : TreeElement<'a> option = None
    let mutable right : TreeElement<'a> option = None
    member this.value = value
    member this.getLeft = left
    member this.getRight = right
    member this.SetLeft value = left <- Some(TreeElement<'a>(value))
    member this.SetRight value = right <- Some(TreeElement<'a>(value))

type TreeEnumerator<'a when 'a : comparison>(startNode : TreeElement<'a> option) =
    let mutable position = startNode.Value
    let stack = Stack<TreeElement<'a> option>()
    do stack.Push(startNode)
    interface IEnumerator<'a> with
        member this.MoveNext() =
            if stack.Count = 0 then
                false
            else
                position <- stack.Pop().Value
                if position.getRight <> None then
                    stack.Push position.getRight
                if position.getLeft <> None then
                    stack.Push position.getLeft
                true
        member this.Reset() = 
            position <- startNode.Value
        member this.Current = position.value
        member this.get_Current() = position.value :> obj
        member this.Dispose() = ()

type Tree<'a when 'a : comparison>() =
    let mutable head : TreeElement<'a> option = None

    member this.add(value : 'a) =
        if head = None then
            head <- Some(TreeElement<'a>(value))
        else 
            let rec recAdd (node : TreeElement<'a>) =
                if node.value < value then
                    let next = node.getRight
                    if next = None then
                        node.SetRight value
                    else
                        recAdd next.Value
                else
                    let next = node.getLeft
                    if next = None then
                        node.SetLeft value
                    else
                        recAdd next.Value
            recAdd head.Value

    member this.isExists(value : 'a) =
        let rec find (node : TreeElement<'a> option) =
            if node = None then
                false
            else
                if node.Value.value = value then
                    true
                elif  find node.Value.getLeft then
                    true
                else
                    find node.Value.getRight
        find head

    interface IEnumerable<'a> with
        member this.GetEnumerator() =
            new TreeEnumerator<'a>(head) :> IEnumerator<'a>
        member this.GetEnumerator() =
            new TreeEnumerator<'a>(head) :> System.Collections.IEnumerator

let tree = Tree<int>()
tree.add 10
tree.add 15
tree.add 5
tree.add 20
tree.add 17
tree.add 16
tree.add 18
printfn "%A" <| tree.isExists 5
printfn "%A" <| tree.isExists 15
printfn "%A" <| tree.isExists 10
printfn "%A" <| tree.isExists 18
printfn "%A" <| tree.isExists 134
for node in tree do printfn "%A" node