package testframework

import quoted._

object Macros:

  def posImpl(using qctx: QuoteContext): Expr[Position] =
    import qctx.tasty.{given _}
    val name = qctx.tasty.rootPosition.sourceFile.jpath.getFileName.toString
    val line = qctx.tasty.rootPosition.startLine + 1
    '{ Position(${Expr(name)}, ${Expr(line)}) }

  def mkTpeTagImpl[T: Type](using qctx: QuoteContext): Expr[TpeTag[T]] =
    '{ TpeTag(${Expr('[T].show)}) }
