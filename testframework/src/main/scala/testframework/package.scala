package object testframework:

  import scala.language.experimental.macros

  implicit def pos: Position = macro Scala2Macros.posImpl
  inline given pos: Position = ${ Macros.posImpl }

  implicit def mkTpeTag[T]: TpeTag[T] = macro Scala2Macros.TpeTagImpl.mkTag[T]
  inline given mkTpeTag[T]: TpeTag[T] = ${ Macros.mkTpeTagImpl[T] }

  def actuallyAnInt: Any = macro Scala2Macros.Whitebox.actuallyAnIntImpl
  transparent inline def actuallyAnInt: Any = ${ Macros.actuallyAnIntImpl }
