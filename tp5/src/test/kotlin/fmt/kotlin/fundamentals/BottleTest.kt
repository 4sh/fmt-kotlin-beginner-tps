package fmt.kotlin.fundamentals

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
            val isEqual = Bottle("Coucheroy", 2005).isEqualTo(Bottle("Coucheroy", 2005))

            expectThat(isEqual).isTrue()
        }

        @Test
        fun `should not be equals if year is different`() {
            val isEqual = Bottle("Coucheroy", 2005).isEqualTo(Bottle("Coucheroy", 2009))

            expectThat(isEqual).isFalse()
        }

        @Test
        fun `should not be equals if name is different`() {
            val isEqual = Bottle("Coucheroy", 2005).isEqualTo(Bottle("Pedesclaux", 2009))

            expectThat(isEqual).isFalse()
        }

        @Test
        fun `should not be same instance even if name and year are equals`() {
            val isEqual = Bottle("Coucheroy", 2005).isSameInstance(Bottle("Coucheroy", 2005))

            expectThat(isEqual).isFalse()
        }

        @Test
        fun `should be same instance`() {
            val bottle = Bottle("Coucheroy", 2005)
            val isEqual = bottle.isSameInstance(bottle)

            expectThat(isEqual).isTrue()
        }
    }
}