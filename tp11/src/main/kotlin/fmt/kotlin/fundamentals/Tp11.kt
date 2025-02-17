package fmt.kotlin.fundamentals

import kotlinx.datetime.*
import kotlinx.datetime.format.MonthNames
import kotlinx.datetime.format.alternativeParsing
import kotlinx.datetime.format.char
import kotlin.time.Duration.Companion.days

class Tp11 {

    fun whichDayIsIn48h(clock: Clock): DayOfWeek = TODO()

    fun whichDayIsInTwoDays(clock: Clock): DayOfWeek = TODO()

    fun parseInstant(s: String): LocalDateTime = TODO()

    fun daysBetween(instant1: Instant, instant2: Instant): Long = TODO()

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
