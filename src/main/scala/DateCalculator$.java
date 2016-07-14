object DateCalculator extends App {

  var year = 0
  do {
    year = StdIn.readLine("Please enter a Gregorian year: ").toInt
  } while (year <= 1583 || year >= 2999)

  val a = year % 19
  val b = Math.floor(year / 100)
  val h = ((19 * a) + b - calculateD(b) - calculateG(b) + 15) % 30
  val c = year % 100

  val l = (32 + (2 * calculateE(b)) + (2 * calculateI(c)) - h - calculateK(c)) % 7
  val m = Math.floor((a + (11 * h) + (22 * l)) / 451)

  println(LocalDate.of(year, calculateMonth(h, l, m), calculateDay(h, l, m)).toString)

  def calculateDay(h: Double, l: Double, m: Double): Int =
    (((h + l - (7 * m) + 114) % 31) + 1).toInt

  def calculateMonth(h: Double, l: Double, m: Double): Int =
    Math.floor((h + l - (7 * m) + 114) / 31).toInt

  def calculateF(b: Double): Double =
    Math.floor((b + 8) / 25)

  def calculateK(c: Double): Double =
    c % 4

  def calculateI(c: Double): Double =
    Math.floor(c / 4)

  def calculateE(b: Double): Double =
    b % 4

  def calculateG(b: Double): Double =
    Math.floor((b - calculateF(b) + 1) / 3)

  def calculateD(b: Double): Double =
    Math.floor(b / 4)

}
