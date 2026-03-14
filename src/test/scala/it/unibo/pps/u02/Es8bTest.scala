package it.unibo.pps.u02

import Expr.*
import org.junit.*
import org.junit.Assert.*

class ExprTest:
  @Before
  val literal = Expr.Literal(10)
  val literal2 = Expr.Literal(20)
  val add = Expr.Add(literal, literal2)
  val mult = Expr.Multiply(literal, literal2)
  val compose = Expr.Add(Expr.Multiply(Expr.Add(literal, literal2), literal), literal2) //((10+20)*10)+20 = 320

  @Test def evaluateTest(): Unit =
    assertEquals(10, Expr.evaluate(literal))
    assertEquals(30, Expr.evaluate(add))
    assertEquals(200, Expr.evaluate(mult))
    assertEquals(320, Expr.evaluate(compose))

  @Test def showTest(): Unit =
    assertEquals("10", Expr.show(literal))
    assertEquals("(10 + 20)", Expr.show(add))
    assertEquals("(10 * 20)", Expr.show(mult))
    assertEquals("(((10 + 20) * 10) + 20)", Expr.show(compose))



