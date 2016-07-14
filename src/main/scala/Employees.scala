
class Employee(val name: String, val reports: Employee*) {
  override def toString: String = name
}

object Employees extends App {
  val bill = new Employee("Bill")
  val dave = new Employee("Dave")
  val jane = new Employee("Jane", bill, dave)
  val rick = new Employee("Rick")
  val fed = new Employee("Fed", rick, jane)

  val persons = List(bill, dave, jane, rick, fed)

  // filter so all managers
  // use flatMap to get pair of people and their manager

  println("Managers")
  private val managers: List[Employee] = persons.filter(_.reports.nonEmpty)
  println(managers)

  println("flatMap")
  println(managers.flatMap(manager => manager.reports.map(report => (manager.name, report.name))))

  // invert keys can values

  private val toInvert = Map("Key1" -> "Value1", "Key2" -> "Value2", "Key3" -> "Value3", "Key4" -> "Value4")

//  private val stringToString: Map[String, String] = toInvert.map { case (k, v) => (v, k) }
  private val stringToString: Map[String, String] = toInvert.map(x => (x._2, x._1))
  println(stringToString)

}
