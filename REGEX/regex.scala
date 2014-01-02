/** Regular expressions
  * random expressions
  *
  * meta characters and such
  *
  * 
  *
  * will edit later
  */

<state id="Multilevel Comment AK" color="#236E25" type="comment" font-style="italic">
  <begin><regex>/\*\*(?'commentCatch'\*+)</regex></begin>
  <end><regex>(?#see-insert-start-group:commentCatch)\*\*/</regex></end>
  <import mode="Base" state="EmailAndURLContainerState" keywords-only="yes"/>
</state>

implicit class Regex(sc: StringContext) {
  def r = new util.matching.Regex(sc.parts.mkString, sc.parts.tail.map(_ => "x"): _*)
}

import scala.util.matching.Regex

val AmBn = "a+b+".r
/** AmBn: scala.util.matching.Regex = a+b+ */

val WordDigit1 = "\\w+\\d+".r
/** WordDigit1: scala.util.matching.Regex = \w+\d+ */

val WordDigit2 = """\w+\d+""".r
/** WordDigit2: scala.util.matching.Regex = \w+\d+ */

val Name = """(Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+)""".r
/** Name: scala.util.matching.Regex = (Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+) */

val Name(title, first, last) = "Ms. Pat Jones"
title: String = Ms
first: String = Pat
last: Jones
