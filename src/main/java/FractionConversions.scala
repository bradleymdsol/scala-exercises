
object FractionConversions {

  implicit def intToFraction(i: Int): Fraction = {
    Fraction(i, 1)
  }

  implicit def doubleToFraction(d: Double): Fraction = {
    def doubleToFraction(d: Double, denominator: Int): Fraction = {
      if (d.isWhole) Fraction(d.toInt, denominator)
      else doubleToFraction(d * 10, denominator * 10)
    }
    doubleToFraction(d * 10, 10)
  }

}
