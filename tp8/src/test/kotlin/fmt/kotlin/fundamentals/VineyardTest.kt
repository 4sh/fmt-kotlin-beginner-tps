package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class VineyardTest {

    val vineyard = Vineyard(
        listOf(
            Cellar(
                listOf(
                    Bottle("Coucheroy", 2005),
                    Bottle("Coucheroy", 2005),
                    Bottle("Coucheroy", 2015),
                    Bottle("Coucheroy", 2015),
                    Bottle("Pedesclaux", 2009),
                    Bottle("Pedesclaux", 2009),
                    Bottle("Pedesclaux", 2009),
                )
            ),
            Cellar(
                listOf(
                    Bottle("Coucheroy", 2015),
                    Bottle("Coucheroy", 2015),
                    Bottle("Coucheroy", 2015),
                    Bottle("Pedesclaux", 2009),
                    Bottle("Pedesclaux", 2009),
                    Bottle("Talbot", 2009),
                    Bottle("Talbot", 2015),
                    Bottle("Pedesclaux", 2009),
                )
            ),
            Cellar(
                listOf(
                    Bottle("Talbot", 2005),
                    Bottle("Talbot", 2005),
                    Bottle("Talbot", 2005),
                    Bottle("Talbot", 2005),
                    Bottle("Pedesclaux", 2009),
                    Bottle("Pedesclaux", 2009),
                    Bottle("Pedesclaux", 2009),
                )
            )
        )
    )


    @Test
    fun `should count bottles in all cellars`() {
        val count = vineyard.countBottles()

        expectThat(count).isEqualTo(
            mapOf(
                "Coucheroy" to 7,
                "Pedesclaux" to 9,
                "Talbot" to 6
            )
        )
    }
}