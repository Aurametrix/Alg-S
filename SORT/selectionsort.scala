// Imperative way
//
def selectionSort(list: Array[Int]): Unit {
  def swap(list: Array[Int], i: Int, j: Int) {
    var tmp = list(i)
    list(i) = list(j)
    list(j) = tmp
  }
  
  var i = 0
  while(i < (list.length - 1)) {
    var min = i
    var j = i + 1
    
    while (j < list.length) {
      if(list(j) < list(min)) {
        min = j
      }
      j += 1
    }
    
    swap(list, i, min)
    i += 1
  }
}
 
// Scal-ish way
def minimum(xs: List[Int]): List[Int] =
  (List(xs.head) /: xs.tail) {
    (ys, x) =>
      if(x < ys.head) (x :: ys)
      else            (ys.head :: x :: ys.tail)
}

def selectionSort0(xs: List[Int]): List[Int] =  
  if(xs.isEmpty) List()
  else {
    val ys = minimum(xs)
    if(ys.tail.isEmpty) 
      ys
    else
      ys.head :: selectionSort(ys.tail)
}

// recursive tail
def selectionSort1(xs: List[Int]) = {
  def selectionSortHelper(xs: List[Int], accumulator: List[Int]): List[Int] =
    if(xs.isEmpty) accumulator
    else {
          val ys = maximum(xs)
          selectionSortHelper(ys.tail, ys.head :: accumulator)
    }

  selectionSortHelper(xs, Nil) 
}

// Functional / Recursive version
//
def selectionSort2(list: List[Int]): List[Int] = {
  
  if(list.length == 1) list
  else {
    // Pseudo code
    // list.min :: selectionSort2(list.everything_but_min)
  }
}


// Generic way
def less[T <: Comparable[T]](i: T, j: T) = i.compareTo(j) < 0

def swap[T](xs: Array[T], i: Int, j: Int) { val tmp = xs(i); xs(i) = xs(j); xs(j) = tmp }

def selectiveSortG[T <: Comparable[T]](xs: Array[T]) {
    val n = xs.size
    for (i <- 0 until n) {
        val min = List.range(i + 1, n).foldLeft(i)((a, b) => if (less(xs(a), xs(b))) a else b)
        swap(xs, i, min)
    }
  }     
