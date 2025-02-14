package fmt.kotlin.fundamentals

import fmt.kotlin.fundamentals.WineColor.RED
import fmt.kotlin.fundamentals.WineColor.WHITE
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class CellarTest {

    @Test
    fun `should get bottles description`() {
        val description = Cellar(
            listOf(
                Bottle("Coucheroy", 2005, RED),
                Bottle("Pedesclaux", 2009, RED)
            )
        ).describeBottles()

        expectThat(description).isEqualTo("""
            Bouteille de Coucheroy de 2005
            Bouteille de Pedesclaux de 2009
        """.trimIndent())
    }

    @Test
    fun `should get red bottles description`() {
        val description = Cellar(
            listOf(
                Bottle("Coucheroy", 2005, RED),
                Bottle("Camarsac", 2018, WHITE),
                Bottle("Pedesclaux", 2009, RED),
            )
        ).describeRedBottles()

        expectThat(description).isEqualTo("""
            Bouteille de Coucheroy de 2005
            Bouteille de blanc
            Bouteille de Pedesclaux de 2009
        """.trimIndent())
    }
}