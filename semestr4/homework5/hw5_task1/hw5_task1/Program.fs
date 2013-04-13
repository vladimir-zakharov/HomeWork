open System

type OperatingSystem =
    abstract infectPossibility : int
    abstract name : string

let Linux =
    { new OperatingSystem with
        member this.infectPossibility = 5
        member this.name = "Linux" }

let MacOS =
    { new OperatingSystem with
        member this.infectPossibility = 15
        member this.name = "MacOS" }

let Windows =
    { new OperatingSystem with
        member this.infectPossibility = 45
        member this.name = "Windows" }

let rand = Random()

type Computer(os : OperatingSystem, startState : bool) =
    let mutable infestation : bool = startState
    member this.operatingSystem = os
    member this.operatingSystemName = os.name
    member this.isInfected = infestation
    member this.virusAttack =
        let temp = rand.Next(100) + 1
        printfn "random number is %d" temp
        
        if (temp < os.infectPossibility) then 
            infestation <- true

type LocalNetwork(computers : Computer [], networkStructure : int [] []) =
    member this.computers = computers
    member this.networkStructure = networkStructure 
    member this.printState =
        for i in 0..computers.Length - 1 do
            if computers.[i].isInfected then
                    printfn  "%A" ("computer " + string i + " with operating system " + string computers.[i].operatingSystemName + " is infected")
            else 
               printfn "%A" ("computer " + string i + " with operating system " + string computers.[i].operatingSystemName + " isn't infected")
        printfn ""
    member this.getInfectState = 
        Array.init 10 (fun i -> computers.[i].isInfected)

    member this.updateState =
        let currentInfectState = this.getInfectState
        let length = computers.Length

        for i in 0..length - 1 do
            for j in 0..length - 1 do
                if networkStructure.[i].[j] = 1 then
                    if currentInfectState.[i] then
                        computers.[j].virusAttack

let networkStructure = [|[|0; 1; 1; 0; 0; 1; 0; 0; 0; 0|]; 
                         [|1; 0; 1; 0; 0; 0; 0; 0; 0; 0|];
                         [|1; 1; 0; 1; 0; 0; 0; 0; 0; 0|];
                         [|0; 0; 1; 0; 1; 0; 0; 0; 0; 0|];
                         [|0; 0; 0; 1; 0; 1; 0; 0; 0; 1|];
                         [|1; 0; 0; 0; 1; 0; 1; 0; 0; 0|];
                         [|0; 0; 0; 0; 0; 1; 0; 1; 0; 0|];
                         [|0; 0; 0; 0; 0; 0; 1; 0; 1; 0|];
                         [|0; 0; 0; 0; 0; 0; 0; 1; 0; 1|];
                         [|0; 0; 0; 0; 1; 0; 0; 0; 1; 0|];|]

let computer0 = Computer(Linux, false)
let computer1 = Computer(Windows, false)
let computer2 = Computer(Windows, false)
let computer3 = Computer(MacOS, false)
let computer4 = Computer(Linux, false)
let computer5 = Computer(Linux, false)
let computer6 = Computer(MacOS, true)
let computer7 = Computer(MacOS, false)
let computer8 = Computer(Windows, true)
let computer9 = Computer(Windows, false)

let computers = [|computer0; computer1; computer2; computer3; computer4; computer5; computer6; computer7; computer8; computer9|]

let network = LocalNetwork(computers, networkStructure)

let timer = new System.Timers.Timer(2000.0);

timer.Elapsed.Add(fun _ -> 
                    Console.Clear()
                    printfn "Press the Enter key to exit the program.\n"
                    network.updateState
                    network.printState)

network.printState
timer.Start()

if Console.ReadLine() = "" then exit 0
