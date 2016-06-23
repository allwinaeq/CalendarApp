package Calendar


import java.util.{Calendar, GregorianCalendar}

import scala.collection.immutable.ListMap



/**
  * Created by allwin on 20/6/16.
  */

class ViewCalendar {
  val days: List[String] =List("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat")

  var calendar = new GregorianCalendar()

  def ViewMonths(M:Int,D:Int,Y: Int,year:Int,Months: ListMap[String, Int]) {
    var y= Y - (14 - M) / 12;

    var x= y + y/4 - y/100 + y/400

    var m = M + 12 * ((14 - M) / 12) - 2;

    var Days=(D + x + (31*m)/12) % 7;

    var monthIndex=0

    var dayIndex = 0

    var break = 0

    var answer = true

    println("Year:" +year)

    for (months <- Months) {
      println("\nMonth:" + months._1)

      calendar.set(year, monthIndex, 1);
      dayIndex = calendar.get(Calendar.DAY_OF_WEEK)
      break = dayIndex

      days.foreach { days => print(days.mkString + "\t") }
      println()

      while (break != 1) {
        print("\t")
        break -= 1
      }


      for (i <- 1 to months._2) {
        print(i + "\t")
        if (dayIndex % 7 == 0) {
          println()
        }
        dayIndex += 1
      }

      monthIndex += 1
    }

  }

}

object CalenderSample extends App {


  var LeapYear: Int = 0
  val year = readInt()
  println("Display the calendar")

  if ((year % 100 != 0) && (year % 400 == 0) || (year % 4 == 0)) {

    LeapYear = 29
  }


  else {
    LeapYear = 28
  }

  var map = ListMap("January" -> 31, "Febrauary" -> LeapYear, "March" -> 31, "April" -> 30, "May" -> 31, "June" -> 30, "July" -> 31, "August" -> 31, "September" -> 30, "October" -> 31, "November" -> 30, "December" -> 31)

  val c = new ViewCalendar

  println(c)

}













