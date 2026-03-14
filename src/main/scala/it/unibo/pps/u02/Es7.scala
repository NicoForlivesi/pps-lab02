package it.unibo.pps.u02

@main
def Es7: Unit =
  def power(base: Double, exponent: Int): Double = exponent match
//    case 1 => base (non serve gia gestito dal caso default)
    case 0 => 1
    case _ => base * power(base, exponent - 1)

  println((power(2, 3), " " + power(5, 2))) // 8, 25

  def power2(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def _pow_tail_recursion(base: Double, exponent: Int, count: Double): Double = exponent match
      case 0 => 1 // (qui invece serve sia case 0 che case 1)
      case 1 => count
      case _ => _pow_tail_recursion(base, exponent - 1, base * count)
    _pow_tail_recursion(base, exponent, base)

  println((power2(2, 3), " " + power2(5, 2)))
