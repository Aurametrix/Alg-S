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


To compile and run on Windows one of the above Scala programs, let's say sort.scala, we can simply proceed as follows:
> mkdir classes
> scalac -d classes %SCALA_HOME%\doc\scala-devel-docs\scala\examples\sort.scala
> scala -cp classes examples.sort
[6,2,8,5,1]
[1,2,5,6,8]
