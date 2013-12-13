def msort[A](less: (A, A) => Boolean)(xs: List[A]): List[A] = {
  def merge(xs1: List[A], xs2: List[A]): List[A] =
    if (xs1.isEmpty) xs2
    else if (xs2.isEmpty) xs1
    else if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2)
    else xs2.head :: merge(xs1, xs2.tail)
  val n = xs.length/2
  if (n == 0) xs
  else merge(msort(less)(xs take n), msort(less)(xs drop n))
}

msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))

/** Tbelow is another example of merge sort
  *
  * Above is from http://www.scala-lang.org/docu/files/ScalaByExample.pdf
  */


object MergeSort {
  def merge(xs: List[Int], ys: List[Int], res: List[Int]): List[Int] =
    (xs, ys) match {
      case (Nil, ys) => res.reverse ++ ys
      case (xs, Nil) => res.reverse ++ xs
      case (x :: xs1, y :: ys1) =>
        if (x < y) merge(xs1, ys, x :: res)
        else merge(xs, ys1, y :: res)
    }
 
  def apply(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    if (n == 0)
      xs
    else {
      val (left, right) = xs splitAt (n)
      merge(apply(left), apply(right), Nil)
    }
  }
}

MergeSort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))
