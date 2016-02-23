def jortSort[K:Ordering]( a:Array[K] ) = a.sorted.deep == a.deep
