import FractionConversions._

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
  def unapply(f: Fraction): Option[(Int, Int)] = Some(f.numerator, f.denominator)
}


object Calculate extends App {

  val matcher : (Fraction) => String = {
    case Fraction(_, 1) => "onesy"
    case Fraction(_, 2) => "twosey"
    case Fraction(4, 3) => "foursey"
    case _ => "ahhhh"
  }

  def matcherOptions(f: Option[Fraction]) = f match {
    case None => "none"
    case Some(Fraction(1, 2)) => "some"
    case Some(_) => "some other"
    case _ => "huh"
  }

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

  println("****************************** Extractors ************************")
  println(matcher(Fraction(2, 1)))
  println(matcher(Fraction(1, 2)))
  println(matcher(Fraction(1, 3)))
  println(matcher(Fraction(4, 3)))

  println("****************************** Options ************************")
  println(matcherOptions(Some(Fraction(1,2))))
  println(matcherOptions(Some(Fraction(1,3))))
  println(matcherOptions(None))

  println("****************************** Implicit ************************")
  println(Fraction(1, 3) + 5)
  println(5 + Fraction(1, 3))
  println(5.5 + Fraction(1, 3))
  println(5.56 + Fraction(1, 3))
  println(5.57232 + Fraction(1, 3))
  println(Fraction(1, 3) + 5.57232 + 10 * 9)

}
