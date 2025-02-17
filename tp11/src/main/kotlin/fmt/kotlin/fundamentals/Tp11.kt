package fmt.kotlin.fundamentals

import kotlinx.datetime.*
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.alternativeParsing
import kotlinx.datetime.format.char
import kotlin.time.Duration.Companion.days

class Tp11 {

    fun whichDayIsInTwoDays(clock: Clock) = (clock.now() + 2.days)
        .toLocalDateTime(TimeZone.of("Europe/Paris"))
        .dayOfWeek

    fun parseInstant(s: String) =
        LocalDateTime.Format {
            dayOfMonth()
            alternativeParsing({
                char('/')
                monthNumber()
                char('/')
            }) {
                char(' ')
                monthName(frenchMonthNames)
                char(' ')
            }
            yearTwoDigits(1900)
            chars(" à ")
            hour()
            char('h')
            minute()
        }.parse(s)

    fun daysBetween(instant1: Instant, instant2: Instant) =
        (instant2 - instant1).inWholeDays

    companion object {
        private val frenchMonthNames = MonthNames(
            listOf(
                "janvier",
                "février",
                "mars",
                "avril",
                "mai",
                "juin",
                "juillet",
                "août",
                "septembre",
                "octobre",
                "novembre",
                "décembre"
            )
        )
    }
}