ThisBuild / scalaVersion := "3.0.2"
val scala213 = "2.13.7"

lazy val scala2macros = project
  .dependsOn(shared)
  .settings(
    name := "testframework-scala2macros",
    scalaVersion := scala213,
    scalacOptions += "-Ytasty-reader",
    libraryDependencies += "org.scala-lang" % "scala-reflect" % scala213
  )

lazy val testframework = project
  .dependsOn(shared, scala2macros)
  .settings(
    name := "testframework",
  )

lazy val shared = project
  .settings(
    name := "testframework-shared",
  )

lazy val app2 = project
  .dependsOn(testframework)
  .settings(
    name := "mix-macros-demo-scala2",
    scalaVersion := scala213,
    scalacOptions += "-Ytasty-reader",
  )

lazy val app3 = project
  .dependsOn(testframework)
  .settings(
    name := "mix-macros-demo-scala3"
  )
