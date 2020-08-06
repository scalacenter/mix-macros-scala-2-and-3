package testframework

import scala.reflect.macros.blackbox.Context

object Scala2Macros {

  def posImpl(c: Context): c.Expr[Position] = {
    import c.universe._
    val fileName = c.enclosingPosition.source.file.name
    val line = c.enclosingPosition.line
    c.Expr(q"new _root_.testframework.Position($fileName, $line)")
  }

  class TpeTagImpl(val c: Context) {
    import c.universe._

    def mkTag[T: c.WeakTypeTag]: c.Expr[TpeTag[T]] =
      c.Expr[TpeTag[T]](
        q"new _root_.testframework.TpeTag(${implicitly[c.WeakTypeTag[T]].tpe.toString})")

  }

}
