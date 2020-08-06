import testframework._

object Main extends App {

  println(implicitly[Position])
  println(implicitly[TpeTag[List[String]]])

}
