
class Fraction(val numerator: Int, val denominator: Int) {

  def *(f: Fraction) = {
    Fraction(f.numerator * numerator, f.denominator * denominator)
  }

  def +(f: Fraction) = {
    Fraction((numerator * f.denominator) + (denominator * f.numerator), denominator * f.denominator)
  }

  def -(f: Fraction) = {
    this + -f
  }

  def /(f: Fraction) = {
    Fraction(numerator, denominator) * !f
  }

  def unary_- = {
    Fraction(-numerator, denominator)
  }

  def unary_! = {
    Fraction(denominator, numerator)
  }

  def toDouble = numerator.toDouble / denominator.toDouble

  override def toString: String = s"$numerator/$denominator"
}

object Fraction {
  def apply(enumerator: Int, denominator: Int) = new Fraction(enumerator, denominator)
}


object Calculate extends App {

  val times: Fraction = Fraction(1, 2) * Fraction(1, 4)
  println("\nTimes")
  println(times)
  println(times.toDouble)

  val divide: Fraction = Fraction(1, 2) / Fraction(1, 4)
  println("\nDivide")
  println(divide)
  println(divide.toDouble)

  val add: Fraction = Fraction(1, 2) + Fraction(1, 4)
  println("\nAdd")
  println(add)
  println(add.toDouble)

  val subtract: Fraction = Fraction(1, 2) - Fraction(1, 4)
  println("\nSubtract")
  println(subtract)
  println(subtract.toDouble)

  val negative: Fraction = -Fraction(1, 2)
  println("\nNegative")
  println(negative)
  println(negative.toDouble)

  val inverse: Fraction = !Fraction(1, 2)
  println("\nInverse")
  println(inverse)
  println(inverse.toDouble)
}
