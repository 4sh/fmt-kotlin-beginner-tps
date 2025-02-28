package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isNotNull

class CellarTest {
    lateinit var cellar: Cellar

    @BeforeEach
    fun initCellar() {
        cellar = Cellar(5)

        cellar.addBottle(Bottle("Haut-Brion", 1997, WineColor.RED))
        cellar.addBottle(Bottle("Margaux", 2012, WineColor.WHITE))
        cellar.addBottle(Bottle("Pétrus", 2008, WineColor.RED))
    }

    @Test
    fun `Should take first matching bottle Junit`() {
        //Lorsque
        val bottle = cellar.takeSpecificBottle("Margaux", 2012, WineColor.WHITE)

        //Alors
        assertEquals("Margaux", bottle?.name)
        assertEquals(2012, bottle?.year)
        assertEquals(WineColor.WHITE, bottle?.color)
    }

    @Test
    fun `Should take first matching bottle Strikt`() {
        //Lorsque
        val bottle = cellar.takeSpecificBottle("Margaux", 2012, WineColor.WHITE)

        //Alors
        expectThat(bottle).isNotNull().and {
            get { name }.isEqualTo("Margaux")
            get { year }.isEqualTo(2012)
            get { color }.isEqualTo(WineColor.WHITE)
        }
    }
}