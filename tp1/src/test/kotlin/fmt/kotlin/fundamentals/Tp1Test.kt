package fmt.kotlin.fundamentals

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.stream.Stream
import kotlin.test.Test

class Tp1Test {

    @BeforeEach
    fun beforeEach() {
        initValue()
    }

    @Nested
    inner class Increment {

        @Test
        fun `should increment x and return last value`() {
            expectThat(x).isEqualTo(42);

            val res1 = incrementXAndReturnOldValue()

            expectThat(res1).isEqualTo(42)
            expectThat(x).isEqualTo(43);

            val res2 = incrementXAndReturnOldValue()

            expectThat(res2).isEqualTo(43)
            expectThat(x).isEqualTo(44);
        }

        @Test
        fun `should increment x and return new value`() {
            expectThat(x).isEqualTo(42);

            val res1 = incrementXAndReturnNewValue()

            expectThat(res1).isEqualTo(43)
            expectThat(x).isEqualTo(43);

            val res2 = incrementXAndReturnNewValue()

            expectThat(res2).isEqualTo(44)
            expectThat(x).isEqualTo(44);
        }
    }

    @Nested
    inner class Sum {

        fun `should sum`() {
            val sum = sumZeroPointFive()

            expectThat(sum).isEqualTo(42.5f)
        }
    }

    @Nested
    inner class DescribeNbBottles {

        @ParameterizedTest
        @ValueSource(strings = ["3,There are 3 bottles for 30\n", "17,There are 17 bottles for 170\n"])
        fun `should describe bottles`(v: String) {
            val decription = describeNbBottles(v.split(",")[0].toInt())

            expectThat(decription).isEqualTo(v.split(",")[1])
        }

        @ParameterizedTest
        @MethodSource("fmt.kotlin.fundamentals.Tp1Test#provideShouldDescribeBottlesWithDetailParams")
        fun `should describe bottles with detail`(
            totalBottles: Int,
            nbWhiteBottles: Int,
            nbRedBottles: Int,
            expectedDescription: String
        ) {
            val description = describeWithDetailNbBottles(totalBottles, nbWhiteBottles, nbRedBottles)

            expectThat(description).isEqualTo(expectedDescription)
        }
    }

    companion object {
        @JvmStatic
        private fun provideShouldDescribeBottlesWithDetailParams() = Stream.of(
            Arguments.of(
                5, 2, 3, """
                There are 5 bottles :
                    - 2 bottles of white
                    - 3 bottles of red
            """.trimIndent()
            ),
            Arguments.of(
                8, 3, 5, """
                There are 8 bottles :
                    - 3 bottles of white
                    - 5 bottles of red
            """.trimIndent()
            )
        )
    }
}