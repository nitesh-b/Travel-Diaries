package au.com.monk.traveldiaries.utils.date

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.TimeZone

class DateFormatter {

    companion object {
        fun currentTS(): Long {
            return System.currentTimeMillis() / 1000
        }

        fun convertTimestampToLocalDate(timestamp: Long, dateFormat: String): String {
            val timeInMillis = timestamp * 1000
            val localDateTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timeInMillis),
                TimeZone.getDefault().toZoneId()
            )
            val formatter = DateTimeFormatter.ofPattern(dateFormat)
            return localDateTime.format(formatter)
        }

        fun timeAgo(timestamp: Long): String {
            val seconds = currentTS() - timestamp
            val minute = seconds/60
            val hour = minute/60
            val day = hour/24
            val week = day/7
            val month = week/4
            val year = month/4
             if (seconds < 60){
                 return  "now"
            }else if(minute < 60){
                 return  String.format("%dmin ago", minute)
            }else if (hour < 24){
                return  String.format("%dhr ago", hour)
            }else if (day < 7){
                return  String.format("%dd ago", day)
            }else if (week < 4){
                 return  String.format("%dwk  ago", week)
             }else if (month < 12){
                 return  String.format("%dmth  ago", month)
             }else{
                 return  String.format("%dyr  ago", year)
             }

        }



    }
}