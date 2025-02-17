package fmt.kotlin.fundamentals

import kotlinx.datetime.*
import kotlinx.datetime.DateTimeUnit.Companion.DAY
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.alternativeParsing
import kotlinx.datetime.format.char
import kotlin.time.Duration.Companion.hours

class Tp11 {

    fun whichDayIsIn48h(clock: Clock) = (clock.now() + 48.hours)
        .toLocalDateTime(TimeZone.of("Europe/Paris"))
        .dayOfWeek

    fun whichDayIsInTwoDays(clock: Clock) = clock.now()
        .toLocalDateTime(TimeZone.of("Europe/Paris"))
        .date
        .plus(2, DAY)
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
