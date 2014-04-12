import io.Source
import java.io.FileNotFoundException

object WC {

  def main(args: Array[String]) {
    println("Enter the name of your file, ie myfile.txt:")
    val fileName = readLine

    val words = try {
      Source.fromFile(fileName).getLines.toSeq.map(_.toLowerCase.trim)
    } catch {
      case e: FileNotFoundException =>
        sys.error("No file named %s found".format(fileName))
    }

    val counts = words.groupBy(identity).mapValues(_.size)

    println("Number of instances found of:")
    for((word, count) <- counts) println("%s\t%d".format(word, count))

  }

}
