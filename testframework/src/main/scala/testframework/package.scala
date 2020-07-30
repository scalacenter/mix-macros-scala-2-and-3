package object testframework:

  import scala.language.experimental.macros

  def pos: Position = macro Scala2Macros.posImpl
  inline def pos: Position = ${ Macros.posImpl }
