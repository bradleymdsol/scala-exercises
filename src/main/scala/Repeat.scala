import scala.annotation.tailrec

class Repeatable(body: => Unit) {

  @tailrec
  final def until(condition: => Boolean): Unit = {
    body
    if (!condition) until(condition)
  }

}

object Repeat extends App {

  def repeat(e: => Unit): Repeatable = {
    new Repeatable(e)
  }

  var countDown = 5

  repeat {
    println("abc")
  } until {
    countDown = countDown - 1
    countDown <= 0
  }

}

