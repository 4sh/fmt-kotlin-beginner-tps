package fmt.kotlin.fundamentals

import fmt.kotlin.fundamentals.UserRole.BUYER
import fmt.kotlin.fundamentals.UserRole.OWNER
import fmt.kotlin.fundamentals.WineColor.RED
import fmt.kotlin.fundamentals.WineColor.WHITE
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.hasSize
import strikt.assertions.isEqualTo

class CellarTest {

    @Nested
    inner class Description {
        @Test
        fun `should get bottles description`() {
            val description = Cellar(
                mutableListOf(
                    Bottle("Coucheroy", 2005, RED),
                    Bottle("Pedesclaux", 2009, RED)
                )
            ).describeBottles()

            expectThat(description).isEqualTo(
                """
            Bouteille de Coucheroy de 2005
            Bouteille de Pedesclaux de 2009
        """.trimIndent()
            )
        }

        @Test
        fun `should get red bottles description`() {
            val description = Cellar(
                mutableListOf(
                    Bottle("Coucheroy", 2005, RED),
                    Bottle("Camarsac", 2018, WHITE),
                    Bottle("Pedesclaux", 2009, RED),
                )
            ).describeRedBottles()

            expectThat(description).isEqualTo(
                """
            Bouteille de Coucheroy de 2005
            Bouteille de blanc
            Bouteille de Pedesclaux de 2009
        """.trimIndent()
            )
        }
    }

    @Nested
    inner class Role {
        @Test
        fun `should add bottle to cellar as owner`() {
            Session.currentUser = owner

            val cellar = Cellar(mutableListOf<Bottle>())

            cellar.addBottle(Bottle("Coucheroy", 2005, RED))

            expectThat(cellar.bottles).hasSize(1)
        }

        @Test
        fun `should not add bottle to cellar as buyer`() {
            Session.currentUser = buyer

            val cellar = Cellar(mutableListOf<Bottle>())

            expectThrows<UnauthorizedException> {
                cellar.addBottle(Bottle("Coucheroy", 2005, RED))
            }
        }
    }

    companion object {
        private val owner = User("bmagrez", OWNER)
        private val buyer = User("pdupont", BUYER)
    }
}