let isPalindrom (str : string) =
    let strArr = str.ToCharArray()
    let reversedStrArr = Array.rev strArr
    strArr = reversedStrArr

let maxPalindrom =
    let rec find num1 num2 max =
        if num1 > 999 then max
        else
            let rec find2 num3 num4 max2 =
                if num4 > 999 then
                    max2
                else
                    let mul = num3 * num4
                    if isPalindrom(string mul) then
                        if mul > max then 
                            let max2 = mul
                            find2 num3 (num4 + 1) max2
                        else 
                            find2 num3 (num4 + 1) max2
                    else find2 num3 (num4 + 1) max2      
            let max = find2 num1 num2 max
            find (num1 + 1) num2 max
    find 100 100 0

printfn "%A" maxPalindrom