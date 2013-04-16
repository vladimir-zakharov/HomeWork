type RoundingBuilder(digit : int) =

    member this.Bind (x : float, rest : float -> float) =
        System.Math.Round(rest x, digit)

    member this.Return x = x

let rounding digit = RoundingBuilder digit

printfn "%A" <|
    rounding 3 {
        let! a = 2.0 / 12.0
        let! b = 3.5
        return a / b
    }