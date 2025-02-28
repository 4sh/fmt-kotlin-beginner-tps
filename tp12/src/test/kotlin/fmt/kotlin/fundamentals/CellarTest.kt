package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNotNull

class CellarTest {

    //Écrire le Étant donné que dans un beforeEach pour ne pas dupliquer le code

    @Test
    fun `Should take first matching bottle Junit`() {
        //Étant donné que
        val cellar = Cellar(5)

        cellar.addBottle(Bottle("Haut-Brion", 1997, WineColor.RED))
        cellar.addBottle(Bottle("Margaux", 2012, WineColor.WHITE))
        cellar.addBottle(Bottle("Pétrus", 2008, WineColor.RED))

        //Lorsque
        val bottle = cellar.takeSpecificBottle("Margaux", 2012, WineColor.WHITE)

        //Alors
        assertEquals("Margaux", bottle?.name)
        assertEquals(2012, bottle?.year)
        assertEquals(WineColor.WHITE, bottle?.color)
    }

    //Écrire la même fonction que celle en Junit mais cette fois avec les assertions de Strikt
}