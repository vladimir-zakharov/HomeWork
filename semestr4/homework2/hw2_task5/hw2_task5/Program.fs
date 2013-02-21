let isPalindrom (str : string) =
    let strArr = str.ToCharArray()
    let reversedStrArr = Array.rev strArr
    strArr = reversedStrArr

System.Console.WriteLine(isPalindrom "aabbaa")
System.Console.WriteLine(isPalindrom "aababa")

