package testframework

import scala.reflect.macros.blackbox.Context

object Scala2Macros {

  def posImpl(c: Context): c.Expr[Position] = {
    import c.universe._
    val fileName = c.enclosingPosition.source.path.split('/').last
    val line = c.enclosingPosition.line
    c.Expr(q"new testframework.Position($fileName, $line)")
  }

}
