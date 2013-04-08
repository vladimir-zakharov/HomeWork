open System.IO
open System.Collections.Generic
open System.Text
open System

let addNewRecord name number (currentData : Dictionary<string, string>) =
    if (currentData.ContainsKey number) then 
        printf "Невозможно добавить %s " name
        printfn "В книге уже есть человек с номером %s" number
    else 
        currentData.Add(number, name)

let writeToFile path (str : string) =
    try
        use file = File.CreateText path
        file.WriteLine str
    with
    | exn -> printfn "Ошибка! %s" exn.Message

let saveData path (currentData : Dictionary<string, string>) =
    let data = new StringBuilder()
    let append (str : string) = data.Append str |> ignore
    for pair in currentData do
        append(pair.Value + "\n" + pair.Key + "\n")   
    writeToFile path (data.ToString())

let readData path (currentData : Dictionary<string, string>) = 
    try
         use reader = File.OpenText path
         let rec readLines() =
            let line1 = reader.ReadLine()
            let line2 = reader.ReadLine()
            match line1 with
            | null | ""  -> ()
            | _ ->
                addNewRecord line1 line2 currentData
                readLines() 
         readLines()
    with
    | exn -> printfn "Ошибка! %s" exn.Message

let findNameByNumber number (currentData : Dictionary<string, string>) =
    if currentData.ContainsKey number then
        printfn "%s" currentData.[number]
    else
        printfn "В телефонной книге нет человека с таким номером"

let findNumberByName name (currentData : Dictionary<string, string>) =
    if currentData.ContainsValue(name) then
        for pair in currentData do
            if pair.Value.Equals name then
                printfn "%s" pair.Key
    else
        printfn "В телефонной книге нет человека с таким именем"

let isEmptyString string = 
    string = ""

let rec checkEmpty() =
    let string = Console.ReadLine()
    if isEmptyString string then 
        printfn "%s" "Вы ничего не ввели! Пожалуйста, введите строку"
        checkEmpty()
    else string

let rec startProcess data =
    printf "\nВведите цифру от 0 до 5:
0 - выйти
1 - добавить запись (имя и телефон)
2 - найти телефон по имени
3 - найти имя по телефону
4 - сохранить текущие данные в файл
5 - считать данные из файла\n\n"

    let key = Console.ReadLine()
    Console.Clear()
    match key with
    | "0" -> exit 0
    | "1" ->
         printfn "%s" "\nВведите имя"
         let name = checkEmpty()
         printfn "%s" "\nВведите номер телефона"
         let number = checkEmpty()
         addNewRecord name number data
         startProcess data
    | "2" ->
        printfn "%s" "\nВведите имя человека, номер которого вы хотите найти"
        findNumberByName(Console.ReadLine()) data
        startProcess data
    | "3" ->
        printfn "%s" "\nВведите номер телефона, чтобы узнать имя владельца"
        findNameByNumber(Console.ReadLine()) data
        startProcess data
    | "4" -> 
        saveData "phoneBook.txt" data
        startProcess data
    | "5" -> 
        readData "phoneBook.txt" data
        startProcess data   
    | _ -> 
        printfn "%s" "\nОшибка ввода. Попробуйте ещё раз"
        startProcess data

let currentData = new Dictionary<string, string>()
startProcess currentData

