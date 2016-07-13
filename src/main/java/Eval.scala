
trait Expression

case class Const(v: Int) extends Expression

case class Neg(e: Expression) extends Expression

case class Add(l: Expression, r: Expression) extends Expression


object Eval extends App {

  val eval: (Expression) => Int = {
    case c: Const => c.v
    case a: Add => eval(a.l) + eval(a.r)
    case n: Neg => -eval(n.e)
  }

  println(eval(Add(Const(10), Neg(Add(Const(3), Const(4))))))


}
