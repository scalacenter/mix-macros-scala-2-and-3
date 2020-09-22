ThisBuild / scalaVersion := "0.27.0-RC1"
val scala213 = "2.13.4-bin-d003bf5"

resolvers in Global += "scala-integration" at
  "https://scala-ci.typesafe.com/artifactory/scala-integration/"

lazy val scala2macros = project
  .dependsOn(shared)
  .settings(
    name := "testframework-scala2macros",
    scalaVersion := scala213,
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
    scalaVersion := scala213
  )

lazy val app3 = project
  .dependsOn(testframework)
  .settings(
    name := "mix-macros-demo-scala3"
  )
