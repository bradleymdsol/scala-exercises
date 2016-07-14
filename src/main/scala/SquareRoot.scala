import scala.io.StdIn

object SquareRoot extends App {

  var estimate = 1.0
  val number = StdIn.readLine("Enter number: ").toDouble

  do {
    estimate = calculateEstimate(estimate, number)
    println(estimate)
  } while (!isGoodEnough(estimate, number))

  println(estimate)

  def isGoodEnough(estimate: Double, number: Double): Boolean = {
    val x: Double = (estimate * estimate - number) / number
    x < 0.000001 && x > -0.000001
  }

  def calculateEstimate(estimate: Double, number: Double): Double = {
    (estimate + (number / estimate)) / 2
  }
}

object RecursionSquareRoot extends App {

  def sqrt(value: Double) = {

    def sqrt0(value: Double, estimate: Double): Double = {
      if (isGoodEnough(estimate, value)) estimate
      else sqrt0(value, (estimate + (value / estimate)) / 2)
    }

    def isGoodEnough(estimate: Double, number: Double): Boolean = {
      val x: Double = (estimate * estimate - number) / number
      x < 0.000001 && x > -0.000001
    }

    sqrt0(value, 1.0)
  }

  println(sqrt(64))
}
