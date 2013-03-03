let isPrime n =
    let rec check i =
        n <> 1 && (i > n/2 || (n % i <> 0 && check (i + 1)))
    check 2

let prime n =
    let n = n + 1
    let rec find number res =
        if number = n then
            res - 1
        else
            if isPrime res then
                let number = number + 1
                let res = res + 1
                find number res
            else
                let res = res + 1
                find number res
    find 1 3

let seqPrimes = Seq.initInfinite(prime)
printfn "%A" seqPrimes
