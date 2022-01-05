import testframework.{_, given}

object Main extends App {

  println(implicitly[Position])
  println(implicitly[TpeTag[List[String]]])
  println(s"actuallyAnInt: Int as given by ${implicitly[actuallyAnInt.type <:< Int]}")

}
