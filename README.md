## Demo of mixing scala 2 macros with scala 3

In this repo we have a simple project structure simulating a test framework:

- `testframework`: a library that provides a position macro that can be consumed from either Scala `2.13` or `3.0`
  - compiled with Dotty `0.25.0`
  - depends on `shared`, `scala2macros`
- `shared`: provides data structures used by macros
  - compiled with Dotty `0.25.0`
- `scala2macros`: provides implementation of macros for scala 2
  - compiled with Scala `2.13.4-bin-SNAPSHOT`
  - depends on `shared`
- `root`: the demo Scala 2 application that uses the test framework
  - compiled with Scala `2.13.4-bin-SNAPSHOT`
  - depends on `testframework`

The main macro we use is `def pos: Position` which summons a data structure containing the source file and line number of the callsite. This is called in [Main.scala](src/main/scala/Main.scala).

It is defined in the single source file [`testframework/package.scala`](testframework/src/main/scala/testframework/package.scala) of the `testframework` project and provides macros that can be read from either Scala 2.13 or Scala 3.0. The implementations of the macros are contained in separate libraries, transitively included by depending on `testframework`.

### Usage
You will need to locally build Scala 2.13.4 snapshot from [this commit](https://github.com/scalacenter/scala/commit/ae2dcdf8502391b9e8656d73c5b8c95664d303cc)

- run the demo with `sbt run`
