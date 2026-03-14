package it.unibo.pps.u02

@main
def Es8: Unit =
  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def _rev(done: Int, toDo: Int): Int = toDo match
      case n if n / 10 == 0 => done * 10 + n
      case _ => _rev(done * 10 + toDo % 10, toDo / 10 )
    _rev(n % 10, n / 10)

  println(reverseNumber(7890563))
