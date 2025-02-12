package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.*
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.test.Test

class InventoryServiceTest {

    @Test
    fun `should add 3 bottles`() {
        val service = InventoryService()

        service.addAll(listOf(
            "Bouteille de Coucheroy de 2005",
            "Bouteille de Coucheroy",
            "Bouteille de Pedesclaux de 2009",
            "Bouteille de Talbot de 2015",
        ))

        expectThat(service.bottles.toList()).isEqualTo(
            listOf(
                Bottle("Coucheroy", 2005),
                Bottle("Pedesclaux", 2009),
                Bottle("Talbot", 2015),
            )
        )
    }
}