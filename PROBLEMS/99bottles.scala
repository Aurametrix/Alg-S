object NinetyNineBottlesOfBeer {
  val verse = """|99 bottles of beer on the wall
                 |99 bottles of beer
                 |Take one down, pass it around
                 |98 bottles of beer on the wall""".stripMargin
 
  val song = new scala.collection.mutable.Queue() ++= verse.lines += ""
  val Bottles = "(\\d+) bottles of beer.*".r
 
  def changeLine(line: String) = line match {
      case Bottles("0") => song clear ()
      case Bottles(n) => song enqueue line.replace(n, n.toInt - 1 toString)
      case _ => song enqueue line
    }
 
  def sing = while(!song.isEmpty) {
    val line = song dequeue ()
    println(line)
    changeLine(line)
  }
}
