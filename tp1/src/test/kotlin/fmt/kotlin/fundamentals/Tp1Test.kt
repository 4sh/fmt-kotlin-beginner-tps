package fmt.kotlin.fundamentals

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.Test

class Tp1Test {

    @Nested
    inner class Increment {

        @BeforeEach
        fun beforeEach() {
            x = 0
        }

        @Test
        fun `should increment x and return last value`() {
            check(x == 0)

            val res1 = incrementXAndReturnOldValue()

            check(res1 == 0)
            check(x == 1)

            val res2 = incrementXAndReturnOldValue()

            check(res2 == 1)
            check(x == 2)
        }

        @Test
        fun `should increment x and return new value`() {
            check(x == 0)

            val res1 = incrementXAndReturnNewValue()

            check(res1 == 1)
            check(x == 1)

            val res2 = incrementXAndReturnNewValue()

            check(res2 == 2)
            check(x == 2)
        }
    }

    @Nested
    inner class Sum {

        @ParameterizedTest
        @CsvSource("1, 1.5", "2, 2.5", "3, 3.5")
        fun `should sum`(n: Int, expectedSum: Float) {
            x = n
            val sum = sumZeroPointFive()

            check(sum == expectedSum)
        }
    }

    @Nested
    inner class Subtract {

        @ParameterizedTest
        @CsvSource("1854644, 1", "3854643, 2000000")
        fun `should subtract`(n: Int, expected: Int) {
            x = n
            val sum = subtractBigNumber()

            check(sum == expected)
        }
    }

    @Nested
    inner class InRange {

        @ParameterizedTest
        @CsvSource("0, false", "1, true", "20, true", "42, true", "43, false")
        fun `should check in range open`(n: Int, expected: Boolean) {
            val range = buildRangeOpen()

            check(range.contains(n) == expected)
        }

        @ParameterizedTest
        @CsvSource("0, false", "1, true", "20, true", "42, false", "43, false")
        fun `should check in range open ended`(n: Int, expected: Boolean) {
            val range = buildRangeOpenEnded()

            check(range.contains(n) == expected)
        }
    }

    @Nested
    inner class DescribeNbBottles {

        @ParameterizedTest
        @CsvSource("3, There are 3 bottles", "17, There are 17 bottles")
        fun `should describe bottles`(n: Int, expectedDescription: String) {
            x = n
            val description = describeNbBottles()

            check(description == expectedDescription)
        }

        @ParameterizedTest
        @MethodSource("fmt.kotlin.fundamentals.Tp1Test#provideShouldDescribeBottlesWithDetailParams")
        fun `should describe bottles with detail`(
            totalBottlesValue: Int,
            nbWhiteBottlesValue: Int,
            nbRedBottlesValue: Int,
            expectedDescription: String
        ) {
            totalBottles = totalBottlesValue
            nbWhiteBottles = nbWhiteBottlesValue
            nbRedBottles = nbRedBottlesValue
            val description = describeWithDetailNbBottles()

            check(description == expectedDescription)
        }
    }

    companion object {
        @JvmStatic
        private fun provideShouldDescribeBottlesWithDetailParams() = Stream.of(
            Arguments.of(5, 2, 3, """
                There are 5 bottles :
                    - 2 bottles of white
                    - 3 bottles of red
            """.trimIndent()),
            Arguments.of(8, 3, 5, """
                There are 8 bottles :
                    - 3 bottles of white
                    - 5 bottles of red
            """.trimIndent())
        )
    }
}
