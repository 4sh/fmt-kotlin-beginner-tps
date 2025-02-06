package fmt.kotlin.fundamentals

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo
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
            expectThat(x).isEqualTo(0);

            val res1 = incrementXAndReturnOldValue()

            expectThat(res1).isEqualTo(0)
            expectThat(x).isEqualTo(1);

            val res2 = incrementXAndReturnOldValue()

            expectThat(res2).isEqualTo(1)
            expectThat(x).isEqualTo(2);
        }

        @Test
        fun `should increment x and return new value`() {
            expectThat(x).isEqualTo(0);

            val res1 = incrementXAndReturnNewValue()

            expectThat(res1).isEqualTo(1)
            expectThat(x).isEqualTo(1);

            val res2 = incrementXAndReturnNewValue()

            expectThat(res2).isEqualTo(2)
            expectThat(x).isEqualTo(2);
        }
    }

    @Nested
    inner class Sum {

        @ParameterizedTest
        @CsvSource("1, 1.5", "2, 2.5", "3, 3.5")
        fun `should sum`(n: Int, expectedSum: Float) {
            x = n
            val sum = sumZeroPointFive()

            expectThat(sum).isEqualTo(expectedSum)
        }
    }

    @Nested
    inner class Subtract {

        @ParameterizedTest
        @CsvSource("1854644, 1", "3854643, 2000000")
        fun `should subtract`(n: Int, expected: Int) {
            x = n
            val sum = subtractBigNumber()

            expectThat(sum).isEqualTo(expected)
        }
    }

    @Nested
    inner class InRange {

        @ParameterizedTest
        @CsvSource("0, false", "1, true", "20, true", "42, true", "43, false")
        fun `should check in range open`(n: Int, expected: Boolean) {
            val range = buildRangeOpen()

            expectThat(range.contains(n)).isEqualTo(expected)
        }

        @ParameterizedTest
        @CsvSource("0, false", "1, true", "20, true", "42, false", "43, false")
        fun `should check in range open ended`(n: Int, expected: Boolean) {
            val range = buildRangeOpenEnded()

            expectThat(range.contains(n)).isEqualTo(expected)
        }
    }

    @Nested
    inner class DescribeNbBottles {

        @ParameterizedTest
        @CsvSource("3, There are 3 bottles", "17, There are 17 bottles")
        fun `should describe bottles`(n: Int, expectedDescription: String) {
            x = n
            val decription = describeNbBottles()

            expectThat(decription).isEqualTo(expectedDescription)
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

            expectThat(description).isEqualTo(expectedDescription)
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