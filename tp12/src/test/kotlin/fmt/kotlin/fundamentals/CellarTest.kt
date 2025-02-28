package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertSame

class CellarTest {
    @Test
    fun `Should add n bottle`() {
        //Etant donné que
        val n = 5
        val cellar = Cellar(n)

        //Lorsque
        for (i in 0..n) {
            cellar.addBottle(Bottle("Latour", 1990, WineColor.RED))
        }

        //Alors
        assertEquals(n, cellar.bottleCount)
    }

    @Test
    fun `Should not add more bottle than cellar space`() {
        //Etant donné que
        val n = 5
        val cellar = Cellar(n - 2)

        //Lorsque
        for (i in 0..n) {
            cellar.addBottle(Bottle("Latour", 1990, WineColor.RED))
        }

        //Alors
        assertEquals(cellar.size, cellar.bottleCount)
    }

    @Test
    fun `Should take first colored bottle`() {
        //Etant donné que
        val cellar = Cellar(5)
        val bottleToRetrieve = Bottle("Margaux", 2012, WineColor.WHITE)

        cellar.addBottle(Bottle("Haut-Brion", 1997, WineColor.RED))
        cellar.addBottle(bottleToRetrieve)
        cellar.addBottle(Bottle("Pétrus", 2008, WineColor.RED))

        //Lorsque
        val bottle = cellar.takeColoredBottle(WineColor.WHITE)

        //Alors
        assertEquals(2, cellar.bottleCount)
        assertSame(bottle, bottleToRetrieve)
    }
}