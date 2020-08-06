package testframework

/**A basic tag recording a representation of the type `T`.
 * Does not dealias or use qualified names.
 */
final case class TpeTag[T](repr: String):
  override final def toString: String = s"TpeTag[$repr]"
