val dottyVersion = "0.25.0"
val scala213Version = "2.13.4-bin-SNAPSHOT"

lazy val scala2macros = project
  .dependsOn(shared)
  .settings(
    name := "testframework-scala2macros",
    version := "0.1.0",

    scalaVersion := scala213Version,
    crossVersion := CrossVersion.constant(dottyVersion),

    libraryDependencies += "org.scala-lang" % "scala-reflect" % scala213Version
  )

lazy val testframework = project
  .dependsOn(shared, scala2macros)
  .settings(
    name := "testframework",
    version := "0.1.0",

    scalaVersion := dottyVersion,
    crossVersion := CrossVersion.constant(dottyVersion),
  )

lazy val shared = project
  .settings(
    name := "testframework-shared",
    version := "0.1.0",
    scalaVersion := dottyVersion,
    crossVersion := CrossVersion.constant(dottyVersion)
  )

lazy val root = project
  .in(file("."))
  .dependsOn(testframework)
  .settings(
    name := "mix-macros-demo",
    version := "0.1.0",

    scalaVersion := scala213Version
  )
