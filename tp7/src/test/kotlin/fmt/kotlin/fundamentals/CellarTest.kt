package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.all
import strikt.assertions.hasSize
import strikt.assertions.isEqualTo
import strikt.assertions.withFirst

class CellarTest {

    @Nested
    inner class Dsl {

        @Test
        fun `should build a Cellar`() {
            val cellar = cellar {
                barrel {
                    capacity = 225
                }
                barrel {
                    capacity = 225
                }
                bottle {
                    name = "Coucheroy"
                    year = 2005
                }
            }

            expectThat(cellar) {
                get { barrels }.hasSize(2)
                    .all {
                        get { capacity }.isEqualTo(225)
                    }
                get { bottles }.hasSize(1)
                    .withFirst {
                        get { name }.isEqualTo("Coucheroy")
                        get { year }.isEqualTo(2005)
                    }

            }
        }
    }

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