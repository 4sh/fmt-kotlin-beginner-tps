package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class CellarTest {

    @Nested
    inner class OnEveryBottle {

        val cellar = Cellar(
            bottles = listOf(
                Bottle("Coucheroy", 2005),
                Bottle("Pedesclaux", 2009),
                Bottle("Talbot", 2015),
            )
        )

        @Test
        fun `should describe cellar`() {
            val description = cellar.describeAll()

            expectThat(description).isEqualTo(
                """
                
                Bouteille de Coucheroy de 2005
                Bouteille de Pedesclaux de 2009
                Bouteille de Talbot de 2015
            """.trimIndent()
            )
        }

        @Test
        fun `should get all years`() {
            val years = cellar.years

            expectThat(years).isEqualTo(
                """
                
                2005
                2009
                2015
            """.trimIndent()
            )
        }
    }
}