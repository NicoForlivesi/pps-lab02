package it.unibo.pps.u02

object Lab2:
  @main
  def runAll: Unit =
    task3
    task4
    task5
    task6
    task7
    ExprTest()
    tryOptionals()

  // Task 3, svolto da solo
  @main
  def task3: Unit =
    val positive: Int => String = _ match
      case n if n >= 0 => "Positive"
      case _ => "Negative"

    val posVal = 10
    val negVal = -2
    println(s"Lambda: The val $posVal is ${positive(posVal)}")
    println(s"Lambda: The val $negVal is ${positive(negVal)}")

    def positiveMethod(x: Int): String = x match
      case n if n >= 0 => "Positive"
      case _ => "Negative"

    println(s"Method: The val $posVal is ${positiveMethod(posVal)}")
    println(s"Method: The val $negVal is ${positiveMethod(negVal)}")

    val neg: (String => Boolean) => (String => Boolean) = (f) => !f(_)

    def negMethod(f: String => Boolean): String => Boolean = !f(_)

    val empty: String => Boolean = _ == "" // predicate on strings
    val notEmpty = neg(empty) // which type of notEmpty? (String => Boolean)
    println(notEmpty("foo")) // true
    println(notEmpty("")) // false
    println(notEmpty("foo") && !notEmpty("")) // true


  // Task 4, svolto da solo
  @main
  def task4: Unit =
    val p1: (Int) => (Int) => (Int) => Boolean = x => y => z => (x <= y && y == z) //Int => (Int => (Int => Boolean))
    val p2: (Int, Int, Int) => Boolean = (x: Int, y: Int, z: Int) => x <= y && y == z
    def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
    def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

    println(p1(10)(11)(11))
    println(p2(10, 11, 11))
    println(p3(10)(11)(11))
    println(p4(10, 11, 11))

  // Task 5, svolto da solo
  @main
  def task5: Unit =
    def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

    println(compose(_ - 1, _ * 2)(5)) //9

  // Task 6, svolto da solo
  @main
  def task6: Unit =
    def power(base: Double, exponent: Int): Double = exponent match
      case 0 => 1
      case _ => base * power(base, exponent - 1)

    def power2(base: Double, exponent: Int): Double =
      @annotation.tailrec
      def _pow_tail_recursion(base: Double, exponent: Int, count: Double): Double = exponent match
        case 0 => 1 // (qui invece serve sia case 0 che case 1)
        case 1 => count
        case _ => _pow_tail_recursion(base, exponent - 1, base * count)
      _pow_tail_recursion(base, exponent, base)

    println((power(2, 3), " " + power(5, 2))) // 8, 25
    println((power2(2, 3), " " + power2(5, 2)))

  // Task 7, svolto da solo
  @main
  def task7: Unit =
    def reverseNumber(n: Int): Int =
      @annotation.tailrec
      def _rev(done: Int, toDo: Int): Int = toDo match
        case n if n / 10 == 0 => done * 10 + n
        case _ => _rev(done * 10 + toDo % 10, toDo / 10)
      _rev(n % 10, n / 10)

    println(reverseNumber(12345678)) // 87654321

  // Task 8, svolto da solo
  enum Expr:
    case Literal(n: Int)
    case Add(s1: Expr, s2: Expr)
    case Multiply(s1: Expr, s2: Expr)

  object Expr:
    def evaluate(expr: Expr): Int = expr match
      case Literal(n) => n
      case Add(s1, s2) => evaluate(s1) + evaluate(s2)
      case Multiply(s1, s2) => evaluate(s1) * evaluate(s2)

    def show(expr: Expr): String = expr match
      case Literal(n) => s"$n"
      case Add(s1, s2) => s"(${show(s1)} + ${show(s2)})"
      case Multiply(s1, s2) => s"(${show(s1)} * ${show(s2)})"

  import Expr.*
  @main def ExprTest(): Unit =
    val literal = Literal(10)
    val literal2 = Literal(20)
    val add = Add(literal, literal2)
    val mult = Multiply(literal, literal2)
    val compose = Add(Multiply(Add(literal, literal2), literal), literal2) //((10+20)*10)+20 = 320

    // testEvaluate
    println(10 == evaluate(literal))
    println(30 == evaluate(add))
    println(200 == evaluate(mult))
    println(320 == evaluate(compose))

    // testShow
    println("10" == show(literal))
    println("(10 + 20)" == show(add))
    println("(10 * 20)" == show(mult))
    println("(((10 + 20) * 10) + 20)" == show(compose))

  // Task 9, svolto da solo
  object Optionals:
    enum OptionalInt:
      case Just(value: Int)
      case Empty()

    object OptionalInt:
      def isEmpty(opt: OptionalInt): Boolean = opt match
        case Empty() => true
        case _ => false

      def orElse(opt: OptionalInt, orElse: Int): Int = opt match
        case Just(a) => a
        case _ => orElse

      def mapInt(opt: OptionalInt)(f: Int => Int): OptionalInt = opt match
        case Just(a) => Just(f(a))
        case _ => Empty()

      def filter(opt: OptionalInt)(f: Int => Boolean): OptionalInt = opt match
        case Just(a) if f(a) => Just(a)
        case _ => Empty()

  @main def tryOptionals(): Unit =
    import Optionals.* // to work with Optionals (to see OptionalInt type)
    import OptionalInt.* // to directly access algorithms

    val s1: OptionalInt = Just(1)
    val s2: OptionalInt = Empty()

    println(s1) // Some(1)
    println(isEmpty(s1)) // false
    println(orElse(s1, 0)) // 1
    println(orElse(s2, 0)) // 0
    println(mapInt(Just(5))(_ + 1)) // Just(6)
    println(mapInt(Empty())(_ + 1)) // Empty
    println(filter(Just(5))(_ > 2)) // Just(5)
    println(filter(Just(5))(_ > 8)) // Empty
    println(filter(Empty())(_ > 2)) // Empty

