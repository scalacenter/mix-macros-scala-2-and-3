## Demo of mixing macros for Scala 2 and 3

In this repo we have a simple project structure simulating a test framework:

- `testframework`: a library that provides a position macro that can be consumed from either Scala `2.13` or `3.0`
  - compiled with Dotty `0.26.0-RC1`
  - depends on `shared`, `scala2macros`
- `shared`: provides data structures used by macros
  - compiled with Dotty `0.26.0-RC1`
- `scala2macros`: provides implementation of macros for scala 2
  - compiled with Scala `2.13.4-bin-SNAPSHOT`
  - depends on `shared`
- `root`: the demo Scala 2 application that uses the test framework
  - compiled with Scala `2.13.4-bin-SNAPSHOT`
  - depends on `testframework`

The main macro we use is `def pos: Position` which summons a data structure containing the source file and line number of the callsite. This is called in [Main.scala](src/main/scala/Main.scala).

It is defined in the single source file [`testframework/package.scala`](testframework/src/main/scala/testframework/package.scala) of the `testframework` project and provides macros that can be read from either Scala 2.13 or Scala 3.0. The implementations of the macros are contained in separate libraries, transitively included by depending on `testframework`.

### Usage
You will need to locally build Scala 2.13.4 snapshot from [this commit](https://github.com/scalacenter/scala/commit/a15ae98b387d1a78d71a14a253f8b1d8c246cfef)

- run the demo with `sbt run`
