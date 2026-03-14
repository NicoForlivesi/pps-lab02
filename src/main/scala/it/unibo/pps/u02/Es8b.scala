package it.unibo.pps.u02


//object Expr:
//  enum Expr:
//    case Literal(n: Int)
//    case Add(s1: Expr, s2: Expr)
//    case Multiply(s1: Expr, s2: Expr)
//
//  object Expr:
//    def evaluate(expr: Expr): Int = expr match
//      case Literal(n) => n
//      case Add(s1, s2) => evaluate(s1) + evaluate(s2)
//      case Multiply(s1, s2) => evaluate(s1) * evaluate(s2)
//
//    def show(expr: Expr): String = expr match
//      case Literal(n) => s"$n"
//      case Add(s1, s2) => s"(${show(s1)} + ${show(s2)})"
//      case Multiply(s1, s2) => s"(${show(s1)} * ${show(s2)})"
