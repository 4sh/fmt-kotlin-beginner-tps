package fmt.kotlin.fundamentals

import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.LocalDateTime
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.Test
import kotlin.time.Clock
import kotlin.time.Instant

class Tp11Test {

    private val now = Instant.parse("2024-03-30T22:00:00Z")
    private val clock = object : Clock {
        override fun now() = now
    }

    @Test
    fun `should find what day it is in 48 hours`() {
        val day = whichDayIsIn48h(clock)

        expectThat(day).isEqualTo(DayOfWeek.TUESDAY)
    }

    @Test
    fun `should find what day it is in 2 days`() {
        val day = whichDayIsInTwoDays(clock)

        expectThat(day).isEqualTo(DayOfWeek.MONDAY)
    }

    @Test
    fun `should parse instant`() {
        val instant1 = parseInstant("16 novembre 85 à 11h00")
        val instant2 = parseInstant("16/11/85 à 11h00")

        val expected = LocalDateTime.parse("1985-11-16T11:00:00")
        expectThat(instant1).isEqualTo(expected)
        expectThat(instant2).isEqualTo(expected)
    }

    @Test
    fun `should give days between`() {
        val days = daysBetween(now, Instant.parse("2025-02-21T11:00:00Z"))

        expectThat(days).isEqualTo(327)
    }
}
