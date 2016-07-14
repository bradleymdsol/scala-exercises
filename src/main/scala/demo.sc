
val strings: List[String] = List("a", "b", "c")
val list: List[Any] = strings ++ "d"
list

1 :: 2 :: 3 :: 4 :: 5 :: Nil
Nil ++ "a" ++ "b" ++ "c"

val map: Map[String, Int] = Map("Dave" -> 3, "Jim" -> 9)

val maybeInt: Option[Int] = map.get("Dave111")

if(maybeInt.isDefined)
  println(maybeInt.get)


