package it.unibo.pps.u02

@main
def Es4: Unit =
  val p1: (Int) => (Int) => (Int) => Boolean = x => y => z => (x <= y && y == z) //Int => (Int => (Int => Boolean))
  val p2: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z
//  def p4(x: Int, y: Int, z: Int): Boolean = (x,y, z) match
//    case (a, b, c) if x<=y && y==z => true
//    case _ => false

  println(p1(10)(11)(11))
  println(p2(10, 11, 11))
  println(p3(10)(11)(11))
  println(p4(10, 11, 11))
