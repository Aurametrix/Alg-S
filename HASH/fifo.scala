import java.util.concurrent.BlockingQueue
import scala.collection.JavaConversions._

class FIFOStream[A]( private val queue: BlockingQueue[Option[A]] ) {
  def toStream: Stream[A] = queue take match {
    case Some(a) => Stream cons ( a, toStream )
    case None => Stream empty
  }
  def close() = queue add None
  def enqueue( as: A* ) = queue addAll as.map( Some(_) )
}

object FIFOStream {
  def apply[A]() = new LinkedBlockingQueue
}
