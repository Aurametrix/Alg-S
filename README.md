Alg-S
=====

Scala, object-functional programming and scripting language

Download:
http://www.scala-lang.org/download/
with Homebrew: brew install scala
with MAaports: sudo port install scala2.10

On Mac OS X the path to Scala bin is usually: /Users/<your username>/scala/bin 
and on Windows the path is usually: C:\Program Files (x86)\scala\bin

The scalac command compiles Scala source files and generates Java bytecode which can be 
executed on any standard JVM analogous to javac

Code can be run as a script without prior compilation using:

$ scala mycode.scala

Execute commands in the Scala interpreter, using the option -e:

$ scala -e 'println("Hello, World!")'