package fmt.kotlin.fundamentals

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.time.DayOfWeek.MONDAY
import java.time.DayOfWeek.TUESDAY
import kotlin.test.Test

class Tp11Test {

    private val tp11 = Tp11()
    private val now = Instant.parse("2024-03-30T22:00:00Z")
    private val clock = object : Clock {
        override fun now() = now
    }

    @Test
    fun `should find what day it is in 48 hours`() {
        val day = tp11.whichDayIsIn48h(clock)

        expectThat(day).isEqualTo(TUESDAY)
    }

    @Test
    fun `should find what day it is in 2 days`() {
        val day = tp11.whichDayIsInTwoDays(clock)

        expectThat(day).isEqualTo(MONDAY)
    }

    @Test
    fun `should parse instant`() {
        val instant1 = tp11.parseInstant("16 novembre 85 à 11h00")
        val instant2 = tp11.parseInstant("16/11/85 à 11h00")

        val expected = LocalDateTime.parse("1985-11-16T11:00:00")
        expectThat(instant1).isEqualTo(expected)
        expectThat(instant2).isEqualTo(expected)
    }

    @Test
    fun `should give days between`() {
        val days = tp11.daysBetween(now, Instant.parse("2025-02-21T11:00:00Z"))

        expectThat(days).isEqualTo(327)
    }
}