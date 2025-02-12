package fmt.kotlin.fundamentals

import fmt.kotlin.fundamentals.WineColor.RED
import fmt.kotlin.fundamentals.WineColor.WHITE
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue
import kotlin.test.Test

class BottleTest {

    @Nested
    inner class Equality {
        @Test
        fun `should be equals if name and year are equals`() {
            val isEqual = Bottle("Coucheroy", 2005, RED).isEqualTo(Bottle("Coucheroy", 2005, RED))

            expectThat(isEqual).isTrue()
        }

        @Test
        fun `should not be equals if year is different`() {
            val isEqual = Bottle("Coucheroy", 2005, RED).isEqualTo(Bottle("Coucheroy", 2009, RED))

            expectThat(isEqual).isFalse()
        }

        @Test
        fun `should not be equals if name is different`() {
            val isEqual = Bottle("Coucheroy", 2005, RED).isEqualTo(Bottle("Pedesclaux", 2009, RED))

            expectThat(isEqual).isFalse()
        }

        @Test
        fun `should not be same instance even if name and year are equals`() {
            val isEqual = Bottle("Coucheroy", 2005, RED).isSameInstance(Bottle("Coucheroy", 2005, RED))

            expectThat(isEqual).isFalse()
        }

        @Test
        fun `should be same instance`() {
            val bottle = Bottle("Coucheroy", 2005, RED)
            val isEqual = bottle.isSameInstance(bottle)

            expectThat(isEqual).isTrue()
        }
    }

    @Nested
    inner class ToString {

        @Test
        fun `should describe the bottle of red`() {
            val s = Bottle("Coucheroy", 2005, RED).toString()

            expectThat(s).isEqualTo("Bouteille de Coucheroy rouge de 2005")
        }

        @Test
        fun `should describe the bottle of white`() {
            val s = Bottle("Yquem", 2006, WHITE).toString()

            expectThat(s).isEqualTo("Bouteille de Yquem blanc de 2006")
        }
    }
}