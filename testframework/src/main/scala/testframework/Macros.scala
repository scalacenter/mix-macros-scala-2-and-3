package testframework

import quoted._

object Macros:

  def posImpl(using qctx: QuoteContext): Expr[Position] =
    import qctx.reflect.given
    val name = qctx.reflect.rootPosition.sourceFile.jpath.getFileName.toString
    val line = qctx.reflect.rootPosition.startLine + 1
    '{ Position(${Expr(name)}, ${Expr(line)}) }

  def mkTpeTagImpl[T: Type](using qctx: QuoteContext): Expr[TpeTag[T]] =
    '{ TpeTag(${Expr(Type[T].show)}) }

  def actuallyAnIntImpl(using qctx: QuoteContext): Expr[Int] = Expr(23)
