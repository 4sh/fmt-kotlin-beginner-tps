package fmt.kotlin.fundamentals

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

    private val tp1 = Tp1()

    @Nested
    inner class Increment {

        @Test
        fun `should increment x and return last value`() {
            expectThat(tp1.x).isEqualTo(0);

            val res1 = tp1.incrementXAndReturnOldValue()

            expectThat(res1).isEqualTo(0)
            expectThat(tp1.x).isEqualTo(1);

            val res2 = tp1.incrementXAndReturnOldValue()

            expectThat(res2).isEqualTo(1)
            expectThat(tp1.x).isEqualTo(2);
        }

        @Test
        fun `should increment x and return new value`() {
            expectThat(tp1.x).isEqualTo(0);

            val res1 = tp1.incrementXAndReturnNewValue()

            expectThat(res1).isEqualTo(1)
            expectThat(tp1.x).isEqualTo(1);

            val res2 = tp1.incrementXAndReturnNewValue()

            expectThat(res2).isEqualTo(2)
            expectThat(tp1.x).isEqualTo(2);
        }
    }

    @Nested
    inner class Sum {

        @ParameterizedTest
        @CsvSource("1, 2, 3", "2, 3, 5", "3, 8, 11")
        fun `should sum`(m: Int, n: Int, expectedSum: Int) {
            val sum = tp1.sum(m, n)

            expectThat(sum).isEqualTo(expectedSum)
        }
    }

    @Nested
    inner class DescribeNbBottles {

        @ParameterizedTest
        @CsvSource("3, There are 3 bottles", "17, There are 17 bottles")
        fun `should describe bottles`(n: Int, expectedDescription: String) {
            val decription = tp1.describeNbBottles(n)

            expectThat(decription).isEqualTo(expectedDescription)
        }

        @ParameterizedTest
        @MethodSource("fmt.kotlin.fundamentals.Tp1Test#provideShouldDescribeBottlesWithDetailParams")
        fun `should describe bottles with detail`(
            totalBottles: Int,
            nbWhiteBottles: Int,
            nbRedBottles: Int,
            expectedDescription: String
        ) {
            val description = tp1.describeWithDetailNbBottles(totalBottles, nbWhiteBottles, nbRedBottles)

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