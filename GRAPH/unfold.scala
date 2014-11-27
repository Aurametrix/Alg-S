def unfold[T,R](init: T)(f: T => Option[(R,T)]): Stream[R] = f(init) match {
  case None => Stream[R]()
  case Some((r,v)) => r #:: unfold(v)(f)
}
