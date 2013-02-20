let rec sumNumber number acc =
    match number with
    | 0 -> acc
    | _ ->
        let acc = acc + number % 10
        sumNumber (number / 10) acc

System.Console.WriteLine(sumNumber 5462 0)