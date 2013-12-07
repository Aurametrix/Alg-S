object BubbleSort {
 
  def bubbleSort(array: Array[Int]) = {
    def bubbleSortRecursive(array: Array[Int], current: Int, to: Int): Array[Int] = {
        println(array.mkString(",") + "    current -> " + current + ", to -> " + to)
        to match {
          case 0 => array
          case _ if(to == current) => bubbleSortRecursive(array, 0, to - 1)
          case _ =>
            if (array(current) > array(current + 1)) {
            var temp = array(current + 1)
            array(current + 1) = array(current)
            array(current) = temp
          }
          bubbleSortRecursive(array, current + 1, to)
        }
    }
    bubbleSortRecursive(array, 0, array.size - 1)
  }
 
  def main(args: Array[String]) {
    val sortedArray = bubbleSort(Array(11, 9,10,2,6))
    println("Sorted Array -> " + sortedArray.mkString(","))
  }
}
