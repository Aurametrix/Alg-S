(99 to 1 by -1).par foreach { n =>
  println(
    f"$n%d bottles of beer on the wall\n" +
      f"$n%d bottles of beer\n" +
      f"Take one down, pass it around\n" +
      f"${n - 1}%d bottles of beer on the wall\n")
}
