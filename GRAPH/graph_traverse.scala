def traverse[A](graph : Map[A,Set[A]], toVisit : Seq[A], visited : Set[A]) : Seq[A] = {
  if(toVisit.isEmpty) {
    Seq.empty
  } else {
    val next = toVisit.head
    val succ = (graph(next) -- visited -- toVisit).toSeq
    // DFS :
    // next +: traverse(graph, succ ++ toVisit.tail, visited + next)
    // BFS :
    next +: traverse(graph, toVisit.tail ++ succ, visited + next)
  }
}

def traverseFrom[A](graph : Map[A,Set[A]], initial : A) =
  traverse(graph, Seq(initial), Set.empty)

annotation.tailrec
def traverseTR[A](graph : Map[A,Set[A]], toVisit : Seq[A], visited : Set[A], accumulator : Seq[A]) : Seq[A] = {
  if(toVisit.isEmpty) {
    accumulator
  } else {
    val next = toVisit.head
    val succ = (graph(next) -- visited -- toVisit).toSeq
    // DFS :
    //traverseTR(graph, succ ++ toVisit.tail, visited + next, accumulator :+ next)
    // BFS :
    traverseTR(graph, toVisit.tail ++ succ, visited + next, accumulator :+ next)
  }
}

def traverseFrom[A](graph : Map[A,Set[A]], initial : A) =
  traverseTR(graph, Seq(initial), Set.empty, Seq.empty)
