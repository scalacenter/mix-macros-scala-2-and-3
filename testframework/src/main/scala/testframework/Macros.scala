package testframework

import scala.quoted._

object Macros:

  def posImpl(using quotes: Quotes): Expr[Position] =
    import quotes.reflect.given
    val name = quotes.reflect.SourceFile.current.jpath.getFileName.toString
    val line = quotes.reflect.Position.ofMacroExpansion.startLine + 1
    '{ Position(${Expr(name)}, ${Expr(line)}) }

  def mkTpeTagImpl[T: Type](using quotes: Quotes): Expr[TpeTag[T]] =
    '{ TpeTag(${Expr(Type.show[T])}) }

  def actuallyAnIntImpl(using quotes: Quotes): Expr[Int] = Expr(23)
