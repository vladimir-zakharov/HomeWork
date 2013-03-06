let isPrime n =
    let rec check i =
        n <> 1 && (i > n / 2 || (n % i <> 0 && check (i + 1)))
    check 2

let prime n =
    let n = n + 1
    let rec find number res =
        if number = n then
            res - 1
        else
            if isPrime res then
                find (number + 1) (res + 1)
            else
                find number (res + 1)
    find 1 3

let seqPrimes = Seq.initInfinite(prime)
Seq.take 20 seqPrimes |> Seq.iter(printf "%A ")
