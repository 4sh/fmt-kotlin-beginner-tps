package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA

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
}