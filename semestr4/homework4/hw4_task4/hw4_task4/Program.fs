type Expression =
    | Addition of Expression * Expression
    | Subtraction of Expression * Expression
    | Multiplication of Expression * Expression
    | Division of Expression * Expression
    | Const of float
    | Variable

let rec getDerivate expr = 
    match expr with
    | Addition(expr1, expr2) -> Addition(getDerivate expr1, getDerivate expr2)
    | Subtraction(expr1, expr2) -> Subtraction(getDerivate expr1, getDerivate expr2)
    | Multiplication(expr1, expr2) -> Addition(Multiplication(getDerivate expr1, expr2), Multiplication(expr1, getDerivate expr2))
    | Division(expr1, expr2) -> Division(Subtraction(Multiplication(getDerivate expr1, expr2), Multiplication(expr1, getDerivate expr2)), Multiplication(expr2, expr2))   
    | Const(cst) -> Const(0.0)
    | Variable -> Const(1.0)

let rec simplifyExpr expr =
    match expr with
    | Addition(expr1, expr2) -> 
        match  (expr1, expr2) with
        | (Const(0.0), _) -> expr2
        | (_, Const(0.0)) -> expr1
        | (Const(first), Const(second)) -> Const(first + second)
        | _ -> Addition(simplifyExpr expr1, simplifyExpr expr2)
    | Subtraction(expr1, expr2) -> 
        match  (expr1, expr2) with
        | (_, Const(0.0)) -> expr1
        | (expr1, expr2) when expr1 = expr2 -> Const(0.0)
        | (Const(first), Const(second)) -> Const(first - second)
        | _ -> Subtraction(simplifyExpr expr1, simplifyExpr expr2)
    | Multiplication(expr1, expr2) -> 
        match  (expr1, expr2) with
        | (Const(1.0), _) -> expr2
        | (_, Const(1.0)) -> expr1
        | (Const(0.0), _) | (_, Const(0.0)) -> Const(0.0)
        | (Const(first), Const(second)) -> Const(first * second)
        | _ -> Multiplication(simplifyExpr expr1, simplifyExpr expr2)
    | Division(expr1, expr2) -> 
        match  (expr1, expr2) with
        | (Const(0.0), _) -> Const(0.0)
        | (_, Const(1.0)) -> expr1
        | (Const(first), Const(second)) -> Const(first / second)
        | (expr1, expr2) when expr1 = expr2 -> Const(1.0)
        | _ -> Division(simplifyExpr expr1, simplifyExpr expr2)
    | Const(cst) -> Const(cst)
    | Variable -> Variable

let rec recSimplify current previous = 
    if current = previous then current
    else recSimplify (simplifyExpr current) current

let express = Addition(Multiplication(Const(5.0), Variable), Multiplication(Const(144.0), Variable))
let derivate = getDerivate express
printfn "%A" <| recSimplify (simplifyExpr derivate) derivate
