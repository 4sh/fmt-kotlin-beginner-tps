package fmt.kotlin.fundamentals

import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CellarTest {

    @Test
    fun `Should describe bottles`() {
        //Etant donné que
        val cellar = Cellar(5)

        val bottleMock = mockk<Bottle>()

        every { bottleMock.description() } returns "Bottle"

        cellar.addBottle(bottleMock)
        cellar.addBottle(bottleMock)
        cellar.addBottle(bottleMock)

        //Lorsque
        val description = cellar.describeBottles()

        //Alors
        assertEquals("Bottle\nBottle\nBottle", description)
    }

    @Test
    fun `Should compute cellar value`() {
        //Etant donné que
        val wineStoreMock = mockk<WineStore>()
        val cellar = Cellar(5, wineStoreMock)

        val captureSlot = slot<Bottle>()
        every { wineStoreMock.bottlePrice(capture(captureSlot)) } answers {
            if (captureSlot.captured.color == WineColor.WHITE) {
                10
            } else {
                20
            }
        }

        cellar.addBottle(Bottle("Haut-Brion", 1997, WineColor.RED))
        cellar.addBottle(Bottle("Margaux", 2012, WineColor.WHITE))
        cellar.addBottle(Bottle("Pétrus", 2008, WineColor.RED))

        //Lorsque
        val value = cellar.cellarValue()

        //Alors
        assertEquals(50, value)
        verify(exactly = 3) { wineStoreMock.bottlePrice(any()) }
    }
}