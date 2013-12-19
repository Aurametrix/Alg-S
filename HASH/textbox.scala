/* Abstract classes */
/* We want to work with "text boxes"



abstract class TextBox {
/*
   an abstraction for a box of text with one or more lines of the same length
*/   
  // contents returns the content of the textbox in an array,
  // with each element of the array containing one line
  // of the box, from top to bottom
  def contents(): Array[String]
  // height returns the number of lines in the text box
  def height(): Int
  // width returns the length of the lines
  def width(): Int
}
  
new TextBox // gives error, abstract classes cannot be instantiated


// Scala allows parameterless methods
// It also allows the definition of some methods directly
// in an abstract class. These methods can use fields and 
// methods defined in the abstract class itself, but they
// cannot use private fields and methods in concrete classes
// that implement the abstract class.
abstract class TextBox {
    def contents: Array[String]
    // height can be computed by obtaning the contents
    // array and returning its length
    def height: Int = contents.length
    // width can be computed by measuring the length
    // of the first line of the contents array.
    def width: Int = 
      if (height == 0) 
        0 
      else 
        contents(0).length
}




/* Extending classes */

// Array Box is concrete class implementing text boxes
// by means of an array.
class ArrayBox(conts: Array[String]) extends TextBox {
    // since the text box is actually stored in an array
    // (as expected), content is implemented simply by
    // returning that array
    def contents: Array[String] = conts
}

val a = new ArrayBox(Array("hello", "world"))

a.width

a.height



/* Operational difference between fields and 
   parameterless methods
*/

// The value of an object's field is determined at object
// creation time. In contrast, a parameterless method is 
// still a method, so its returned value is computed 
// anew each time the method is called.

class A {
  var x = 0
  val y = x + 1  // y will be initialized to 1 and stay so
  def f = x + 1  // the value returned by f each time depends
                 // on the current value of x
}

val a = new A

a.x
a.y  // evaluates to 1
a.f  // evaluates to 1

a.x = 4

a.y  // still evaluates to 1
a.f  // evaluates to 5


/* Overriding methods and fields */

class ArrayBox(conts: Array[String]) extends TextBox {
    def contents: Array[String] = conts
}

// we can eliminate the need for the parameter conts above
// by turning contents into a field.
// putting the field in the parameter list makes it directly
// initializable by the constructor

class ArrayBox(
    val contents: Array[String]
    ) extends TextBox {
}

val a = Array("abc","123")
val ab = new ArrayBox(a) // contents is directly set to the value of a


/* Invoking superclass constructors */

// A line box is a text box with exactly one line
// We could implemened concretely as a special case of
// an array box
// we can override the definition of width and height
// with a more efficient one though
class LineBox(s: String) extends ArrayBox(Array(s)) {
    override def width = s.length
    override def height = 1
}

// A uniform box is a text box filled uniformly with the 
// same character
// Its constructor needs the height and the width in advance
// We can override the method height and width of TextBox
// directly with parameters now
class UniformBox(
    ch: Char, 
    override val width: Int,
    override val height: Int 
    ) extends TextBox {
  private val line = ch.toString * width
  def contents = Array.fill(height)(line)
}




/* Composition vs inheritance */

// Is a LineBox really an ArrayBox?
// Not really, it is just a special case of a Text Box
// We do not need an array to implement it
// so maybe we should define it directly as a subclass
// of TextBox and store its content in a string
class LineBox(s: String) extends TextBox {
    val contents = Array(s)   // one line array
    // we can replace the generic implementations of 
    // height and width by more efficient versions here too
    override val width = s.length
    override val height = 1
  }

  
  
/* Subtype polymorphism and dynamic binding */

val b1: TextBox = new ArrayBox(Array("hello", "world"))

val a: ArrayBox = new LineBox("hello")

val b2: TextBox = a

val b3: TextBox = new UniformBox('x', 2, 3)


class A {
  def f() = println("I'm f from A")
}

val a = new A

a.f

class AA extends A {
  override def f() = println("I'm f from AA")
}

val aa: A = new AA

aa.f

class AAA extends AA {
  override def f() = println("I'm f from AAA")
}


val aaa: A = new AAA

aaa.f


class AB extends A {
}


val ab = new AB

ab.f


/* Implementing above, beside, and toString */

object TB { // we pack all text box classes into module TB
  abstract class TextBox {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length

    // above puts a box on top of another into a new box
    // Assumes the two boxes to have the same width
    def above(that: TextBox): TextBox =
      new ArrayBox(this.contents ++ that.contents)

    // besides puts one box beside another into a new box
    // Assures the two boxes to have the same height
    def beside(that: TextBox): TextBox = {
      val contents = new Array[String](this.contents.length)
      for (i <- 0 until this.contents.length) 
        contents(i) = this.contents(i) + that.contents(i)
      new ArrayBox(contents)
    }

    // toString puts all lines of the text box into a single
    // string, separating them with a new line character
    override def toString = contents mkString "\n"
  }

  class LineBox(s: String) extends TextBox {
    val contents = Array(s)
    override val width = s.length
    override val height = 1
  }

  class ArrayBox(conts: Array[String]) extends TextBox {
    def contents: Array[String] = conts
  }
} 


import TB._ // imports all the contents of TB

val l1 = new LineBox("Han ")
val l2 = new LineBox("Solo ")
val l3 = new LineBox("Luke ")
val l4 = new LineBox("Skywalker ")

val b1 = l1 beside l2
val b2 = l3 beside l4

val b3 = b1 above b2

b3.height
b3.width

