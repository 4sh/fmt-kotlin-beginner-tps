package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isFailure
import strikt.assertions.isFalse
import strikt.assertions.isSuccess
import strikt.assertions.isTrue

class ContainerTest {

    @Nested
    inner class Instances {

        @Test
        fun `Barrel should be a Container`() {
            expectThat(Barrel(20000)).isA<Container>()
        }

        @Test
        fun `Tank should be a Container`() {
            expectThat(Tank(3000000)).isA<Container>()
        }
    }

    @Nested
    inner class PossibleCapacities {

        @Test
        fun `Barrel should be created with 22500 cL`() {
            val container = Barrel(22500)
            expectThat(container) {
                get { valid }.isTrue()
            }
        }

        @Test
        fun `Barrel should not be created with 18000 cL`() {
            val container = Barrel(18000)
            expectThat(container) {
                get { valid }.isFalse()
            }
        }

        @Test
        fun `Barrel should not be created with 45000 cL`() {
            val container = Barrel(45000)
            expectThat(container) {
                get { valid }.isFalse()
            }
        }

        @Test
        fun `Tank should be created with 3000000 cL`() {
            val container = Tank(3000000)
            expectThat(container) {
                get { valid }.isTrue()
            }
        }

        @Test
        fun `Tank should not be created with 1800000 cL`() {
            val container = Tank(1800000)
            expectThat(container) {
                get { valid }.isFalse()
            }
        }

        @Test
        fun `Tank should not be created with 12000000 cL`() {
            val container = Tank(12000000)
            expectThat(container) {
                get { valid }.isFalse()
            }
        }
    }
}