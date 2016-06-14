
abstract class GeometricFigure {
  val name: String
  def area(): Double
  def perimeter(): Double
}

class Rectangle(horizontalSide: Double, verticalSide: Double) extends GeometricFigure with Drawable {
  override val name = "Rectangle"
  override def area(): Double = horizontalSide * verticalSide
  override def perimeter(): Double = horizontalSide * 2 + verticalSide * 2
}

class Square(side: Double) extends Rectangle(side, side) {
  override val name = "Square"
}

class Ellipse(verticalAxis: Double, horizontalAxis: Double) extends GeometricFigure with Drawable {
  override val name = "Ellipse"
  override def area(): Double = verticalAxis * horizontalAxis * Math.PI
  override def perimeter(): Double = 2 * Math.PI * Math.sqrt((Math.pow(verticalAxis, 2) + Math.pow(horizontalAxis, 2)) / 2)
}

class Circle(radius: Double) extends Ellipse(radius, radius) with Fillable {
  override val name = "Circle"
}

class Triangle(aSide: Double, bSide: Double, cSide: Double) extends GeometricFigure with Drawable {
  override val name = "Triangle"
  override def area(): Double = {
    val halfPerimeter: Double = perimeter() / 2
    Math.sqrt(halfPerimeter * (halfPerimeter - aSide) * (halfPerimeter * bSide) * (halfPerimeter * bSide))
  }
  override def perimeter(): Double = aSide + bSide + cSide
  override def draw() {
    super.draw()
    println(s"Sides: $aSide $bSide $cSide")
  }
}

trait Drawable extends GeometricFigure {
  def draw() {
    println(s"\n$name")
    println(s"Area: ${area()}")
    println(s"Perimeter: ${perimeter()}")
  }
}

trait Fillable extends Drawable {
  override def draw() {
    super.draw()
    println("Filled")
  }
}


object Shapes extends App {
  new Rectangle(1.2, 2.5).draw()
  new Square(2).draw()
  new Ellipse(1, 5).draw()
  new Circle(5).draw()
  (new Triangle(5, 4, 3) with Fillable).draw()
}
