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

        val bottleMock = //TODO

        //TODO Mocker l'appel de Bottle.description pour retourner Bottle à chaque fois

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
        val wineStoreMock = //TODO
        val cellar = Cellar(5)

        //TODO Mocker l'appel de WineStoreMock.bottlePrice en capturant le paramètre

        cellar.addBottle(Bottle("Haut-Brion", 1997, WineColor.RED))
        cellar.addBottle(Bottle("Margaux", 2012, WineColor.WHITE))
        cellar.addBottle(Bottle("Pétrus", 2008, WineColor.RED))

        //Lorsque
        val value = cellar.cellarValue()

        //Alors
        assertEquals(50, value)
        //TODO Vérifier que le prix a été calculé trois fois (1 fois par bouteille)
    }
}