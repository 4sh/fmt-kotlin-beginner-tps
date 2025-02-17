package fmt.kotlin.fundamentals

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format.MonthNames
import kotlin.time.Clock
import kotlin.time.Instant

fun whichDayIsIn48h(clock: Clock): DayOfWeek = TODO()

fun whichDayIsInTwoDays(clock: Clock): DayOfWeek = TODO()

fun parseInstant(s: String): LocalDateTime = TODO()

fun daysBetween(instant1: Instant, instant2: Instant): Long = TODO()

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
