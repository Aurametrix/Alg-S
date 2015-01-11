// option 1
val day = (weather \ "channel" \ "item" \ "forecast")(0) \ "@day" 
val date = (weather \ "channel" \ "item" \ "forecast")(0) \ "@date"

//option 2
val low = (weather \\ "forecast")(0) \ "@low"
val high = (weather \\ "forecast")(0) \ "@high"

// scala> val date = (weather \\ "forecast")(0) \ "@date" 
// date: scala.xml.NodeSeq = 10 Nov 2011


// option 3

// 1) creates a NodeSeq with the three <forecast> elements
val forecasts = weather \ "channel" \ "item" \ "forecast"

// 2) extract the attributes
val day = forecasts(0) \ "@day"    // Thu (as a NodeSeq)
val date = forecasts(0) \ "@date"  // 10 Nov 2011
val low = forecasts(0) \ "@low"    // 37
val high = forecasts(0) \ "@high"  // 58
val text = forecasts(0) \ "@text" // Partly Cloudy

// This approach returns the elements as a NodeSeq: 
// scala> val day = forecasts(0) \ "@day"
// day: scala.xml.NodeSeq = Thu


// iterating over elements

val forecastNodes = (weather \\ "forecast")

forecastNodes.foreach{ n =>
   val day = (n \ "@day").text 
   val date = (n \ "@date").text 
   val low = (n \ "@low").text
   println(s"$day, $date, Low: $low")
 }

