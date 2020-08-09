package testframework

import scala.reflect.macros.blackbox.Context

object Scala2Macros {

  def posImpl(c: Context): c.Tree = {
    import c.universe._
    val fileName = c.enclosingPosition.source.file.name
    val line = c.enclosingPosition.line
    q"new _root_.testframework.Position($fileName, $line)"
  }

  class TpeTagImpl(val c: Context) {
    import c.universe._

    def mkTag[T](implicit T: c.WeakTypeTag[T]): Tree =
      q"new _root_.testframework.TpeTag[$T](${T.tpe.toString})"

  }

}
