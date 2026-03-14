package it.unibo.pps.u02

@main
def Es5: Unit =
  def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

  println(compose(_ - 1, _ * 2)(5)) //9