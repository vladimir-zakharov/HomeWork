open System.Text.RegularExpressions
open System
open System.Net
open System.IO

let downloadPage (url : string) =
    async { 
        let req = WebRequest.Create(url)
        use! resp = req.AsyncGetResponse()
        use stream = resp.GetResponseStream()
        let reader = new StreamReader(stream)
        let html = reader.ReadToEnd()
        return html }
            
let downloadRefPages (url : string) =
    let download (url : string) = 
        async {
            let! mainHtml = downloadPage url
            let regEx = new Regex(@"href=""http://?(\w|((?!\s|'|"")\W))*""")
            let matches = regEx.Matches(mainHtml)
            let references = [|for m in matches -> m.Value.Substring(6, m.Value.Length - 7)|]
            let tasks = [|for ref in references -> downloadPage ref|]
            let! results = Async.Parallel tasks 
            for i in 0..references.Length - 1 do
                printfn "%s --- %d" references.[i] results.[i].Length }
    download url |> Async.RunSynchronously

downloadRefPages "https://www.google.ru"