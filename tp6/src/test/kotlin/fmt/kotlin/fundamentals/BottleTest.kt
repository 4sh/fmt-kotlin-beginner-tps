package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isFailure

class BottleTest {

    @Nested
    inner class Parsing {

        @Test
        fun `should parse Bouteille de Coucheroy de 2005`() {
            val  bottle = "Bouteille de Coucheroy de 2005".toBottle()

            expectThat(bottle).isEqualTo(Bottle("Coucheroy", 2005))
        }

        @Test
        fun `should not parse Bouteille de Coucheroy wihtout year`() {
            expectCatching { "Bouteille de Coucheroy".toBottle() }.isFailure()
        }
    }
}