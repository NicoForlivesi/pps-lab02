package it.unibo.pps.u02

@main
def Es3: Unit =
  val positive: Int => String = _ match
    case n if n>=0 => "Positive"
    case _ => "Negative"

  val posVal = 10
  val negVal = -2
  println(s"Lambda: The val $posVal is ${positive(posVal)}")
  println(s"Lambda: The val $negVal is ${positive(negVal)}")

  def positiveMethod(x: Int): String = x match
    case n if n>=0 => "Positive"
    case _ => "Negative"

  println(s"Method: The val $posVal is ${positiveMethod(posVal)}")
  println(s"Method: The val $negVal is ${positiveMethod(negVal)}")

  val neg: (String => Boolean) => (String => Boolean) = (f) => !f(_)
  def negMethod(f: String => Boolean): String => Boolean = !f(_)

    val empty: String => Boolean = _ == "" // predicate on strings
    val notEmpty = neg(empty) // which type of notEmpty? (String => Boolean)
    println(notEmpty("foo")) // true
    println(notEmpty("")) // false
    println(notEmpty("foo") && !notEmpty("")) // true.. a comprehensive test
