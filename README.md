Alg-S
=====

Scala, object-functional programming and scripting language, a child of Ruby and Java. Runs on JVM. 
Pure object-oriented programming (OOP) language (every variable is an object, and every “operator” is a method). 
Functional programming (FP) language (can pass functions around as variables))
Powers Twitter, Netflix, Tumblr (Yahoo), Linkedin, Foursquare, Quora, Box.com, Coursera ... 


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

Algorithm samples

[Google](https://code.google.com/p/scalgorithms/)

http://www.scala-lang.org/old/node/219

[DCI: Data, Context and Interaction](http://fulloo.info/Examples/ScalaExamples/)

[Changing syntax](https://news.ycombinator.com/item?id=14388242)

Github:
https://github.com/scala
First commit:
https://github.com/scala/scala/commit/e566ca34a3fd246a4535c458ae47ff7ea62e2de7


Books:
http://alvinalexander.com/scala/scala-cookbook-preface-original

