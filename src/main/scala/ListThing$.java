object ListThing extends App {
  //
  //  val drop : (List[Int], Int) => List[Int] = (l: List[Int], n: Int) => l match {
  //    case _ if l.size < n =>
  //    case _ => l
  //  }
  //
  //  drop(List(1, 2, 3, 4), 2)


  val myLength: (List[Int]) => Int = {
    case Nil => 0
    case l => 1 + myLength(l.tail)
  }

  println(myLength(List(1, 2, 4)))

  val last: (List[Int]) => Int = {
    case Nil => 0
    case l =>
      if (l.tail == Nil) l.head else last(l.tail)
  }

  println(last(List(1, 3, 4, 5)))


  val drop : (List[Int], Int) => List[Int] = (l : List[Int], n: Int) => n match {
    case 0 => l
    case _ => drop(l.tail, n - 1)
  }

  println(drop(List(2, 3, 5, 1, 5), 2))

  // not done
  val take : (List[Int], Int) => List[Int] = (l : List[Int], n: Int) => n match {
    case 0 => l
    case _ => l.head :: take(l.tail, n - 1)
  }

  println(take(List(2, 3, 5, 1, 5), 2))


}
