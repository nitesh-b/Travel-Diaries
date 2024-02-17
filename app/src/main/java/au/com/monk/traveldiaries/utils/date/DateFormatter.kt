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


    }
}