package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isEqualTo

class CellarTest {

    @Nested
    inner class PrimaryConstructor {

        @Test
        fun `should initialize barrels with 100 barrels`() {
            val cellar = Cellar(generateBarrels(100))

            expectThat(cellar) {
                get { totalBarrels }.isEqualTo(100)
            }
        }

        @Test
        fun `should add 50 barrels`() {
            val cellar = Cellar(generateBarrels(100))

            cellar.addBarrels(50)

            expectThat(cellar) {
                get { totalBarrels }.isEqualTo(150)
            }
        }

        @Test
        fun `should remove 20 barrels`() {
            val cellar = Cellar(generateBarrels(100))

            cellar.removeBarrels(20)

            expectThat(cellar) {
                get { totalBarrels }.isEqualTo(80)
            }
        }
    }

    @Nested
    inner class SecondaryConstructor {

        @Test
        fun `should initialize barrels with 100 barrels`() {
            val cellar = Cellar(100)

            expectThat(cellar) {
                get { totalBarrels }.isEqualTo(100)
            }
        }

        @Test
        fun `should add 50 barrels`() {
            val cellar = Cellar(100)

            cellar.addBarrels(50)

            expectThat(cellar) {
                get { totalBarrels }.isEqualTo(150)
            }
        }

        @Test
        fun `should remove 20 barrels`() {
            val cellar = Cellar(100)

            cellar.removeBarrels(20)

            expectThat(cellar) {
                get { totalBarrels }.isEqualTo(80)
            }
        }

        @Test
        fun `should not have a negative number of barrels`() {
            expectThrows<IllegalArgumentException> {
                Cellar(-5)
            }
        }
    }
}