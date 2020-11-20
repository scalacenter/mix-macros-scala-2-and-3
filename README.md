## Demo of mixing macros for Scala 2 and 3

In this repo we have a simple project structure simulating a test framework:

- `testframework`: a library that provides a position macro that can be consumed from either Scala `2.13` or `3.0`
  - compiled with Dotty `3.0.0-M1`
  - depends on `shared`, `scala2macros`
- `shared`: provides data structures used by macros
  - compiled with Dotty `3.0.0-M1`
- `scala2macros`: provides implementation of macros for Scala 2
  - compiled with Scala `2.13.4`
  - depends on `shared`
- `app2`: the demo Scala 2 application that uses the test framework
  - compiled with Scala `2.13.4`
  - depends on `testframework`
- `app3`: replicates the demo application for `app2` but compiled with Scala 3
  - using the exact same library dependencies
  - compiled with Dotty `3.0.0-M1`

The main macro we use is `def pos: Position` which summons a data structure containing the source file and line number of the callsite. This is called in [Main.scala](src/main/scala/Main.scala).

It is defined in the single source file [`testframework/package.scala`](testframework/src/main/scala/testframework/package.scala) of the `testframework` project and provides macros that can be read from either Scala 2.13 or Scala 3.0. The implementations of the macros are contained in separate libraries, transitively included by depending on `testframework`.

### Usage

- run the Scala 2 app demo with `sbt app2/run`
- run the same application but compiled with Scala 3 `sbt app3/run`
  - you may notice a different output to `app2` due to differences in type printing in macros
