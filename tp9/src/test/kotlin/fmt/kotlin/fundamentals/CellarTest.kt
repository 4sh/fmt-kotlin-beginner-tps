package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class CellarTest {

    @Test
    fun `should get bottles description`() {
        val description = Cellar(
            listOf(
                Bottle("Coucheroy", 2005),
                Bottle("Pedesclaux", 2009)
            )
        ).describeBottles()

        expectThat(description).isEqualTo("""
            Bouteille de Coucheroy de 2005
            Bouteille de Pedesclaux de 2009
        """.trimIndent())
    }
}