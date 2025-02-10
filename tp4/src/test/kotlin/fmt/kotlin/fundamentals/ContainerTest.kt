package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectCatching
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isA
import strikt.assertions.isEmpty
import strikt.assertions.isEqualTo
import strikt.assertions.isFailure
import strikt.assertions.isSuccess

class ContainerTest {

    @Nested
    inner class Instances {

        @Test
        fun `Barrel should be a Container`() {
            expectThat(Barrel(20000)).isA<Container>()
        }

        @Test
        fun `Tank should be a Container`() {
            expectThat(Tank(3000000, emptyList())).isA<Container>()
        }
    }

    @Nested
    inner class PossibleCapacities {

        @Test
        fun `Barrel should be created with 22500 cL`() {
            expectCatching {
                Barrel(22500)
            }.isSuccess()
        }

        @Test
        fun `Barrel should not be created with 18000 cL`() {
            expectCatching {
                Barrel(18000)
            }.isFailure()
        }

        @Test
        fun `Barrel should not be created with 45000 cL`() {
            expectCatching {
                Barrel(45000)
            }.isFailure()
        }

        @Test
        fun `Tank should be created with 3000000 cL`() {
            expectCatching {
                Tank(3000000, emptyList())
            }.isSuccess()
        }

        @Test
        fun `Tank should not be created with 1800000 cL`() {
            expectCatching {
                Tank(1800000, emptyList())
            }.isFailure()
        }

        @Test
        fun `Tank should not be created with 12000000 cL`() {
            expectCatching {
                Tank(12000000, emptyList())
            }.isFailure()
        }
    }

    @Nested
    inner class FixedVolume {

        @Test
        fun `Magnum should have a fixed size of 150 cL`() {
            expectThat(Magnum()) {
                isA<FixedVolumeContainer>()
                isA<Container>()
                get { capacity }.isEqualTo(150)
            }
        }

        @Test
        fun `Bottle should have a fixed size of 75 cL`() {
            expectThat(Bottle()) {
                isA<FixedVolumeContainer>()
                isA<Container>()
                get { capacity }.isEqualTo(75)
            }
        }
    }

    @Nested
    inner class ContainersNeededToPourIn {

        @Test
        fun `should not be able to pour Tank in Tank`() {
            expectThrows<IllegalArgumentException> {
                Tank(3000000, emptyList()).containersNeededToPourIn(Tank(3000000, emptyList()))
            }
        }

        @Test
        fun `should be able to pour Tank in Barrel`() {
            expectCatching {
                Tank(3000000, emptyList()).containersNeededToPourIn(Barrel(20000))
            }.isSuccess()
                .isEqualTo(150)
        }

        @Test
        fun `should be able to pour Tank in Magnum`() {
            expectCatching {
                Tank(3000000, emptyList()).containersNeededToPourIn(Magnum())
            }.isSuccess()
                .isEqualTo(20000)
        }

        @Test
        fun `should be able to pour Tank in Bottle`() {
            expectCatching {
                Tank(3000000, emptyList()).containersNeededToPourIn(Bottle())
            }.isSuccess()
                .isEqualTo(40000)
        }

        @Test
        fun `should not be able to pour Barrel in Tank`() {
            expectThrows<IllegalArgumentException> {
                Barrel(20000).containersNeededToPourIn(Tank(3000000, emptyList()))
            }
        }

        @Test
        fun `should not be able to pour Barrel in Barrel`() {
            expectThrows<IllegalArgumentException> {
                Barrel(20000).containersNeededToPourIn(Barrel(20000))
            }
        }

        @Test
        fun `should be able to pour Barrel in Magnum`() {
            expectCatching {
                Barrel(22500).containersNeededToPourIn(Magnum())
            }.isSuccess()
                .isEqualTo(150)
        }

        @Test
        fun `should be able to pour Barrel in Bottle`() {
            expectCatching {
                Barrel(22500).containersNeededToPourIn(Bottle())
            }.isSuccess()
                .isEqualTo(300)
        }

        @Test
        fun `should not be able to pour Magnum in Tank`() {
            expectThrows<IllegalArgumentException> {
                Magnum().containersNeededToPourIn(Tank(3000000, emptyList()))
            }
        }

        @Test
        fun `should not be able to pour Magnum in Barrel`() {
            expectThrows<IllegalArgumentException> {
                Magnum().containersNeededToPourIn(Barrel(20000))
            }
        }

        @Test
        fun `should be able to pour Magnum in Magnum`() {
            expectThrows<IllegalArgumentException> {
                Magnum().containersNeededToPourIn(Magnum())
            }
        }

        @Test
        fun `should be able to pour Magnum in Bottle`() {
            expectThrows<IllegalArgumentException> {
                Magnum().containersNeededToPourIn(Bottle())
            }
        }

        @Test
        fun `should not be able to pour Bottle in Tank`() {
            expectThrows<IllegalArgumentException> {
                Bottle().containersNeededToPourIn(Tank(3000000, emptyList()))
            }
        }

        @Test
        fun `should not be able to pour Bottle in Barrel`() {
            expectThrows<IllegalArgumentException> {
                Bottle().containersNeededToPourIn(Barrel(20000))
            }
        }

        @Test
        fun `should be able to pour Bottle in Magnum`() {
            expectThrows<IllegalArgumentException> {
                Bottle().containersNeededToPourIn(Magnum())
            }
        }

        @Test
        fun `should be able to pour Bottle in Bottle`() {
            expectThrows<IllegalArgumentException> {
                Bottle().containersNeededToPourIn(Bottle())
            }
        }
    }

    @Nested
    inner class Equipments {

        @Test
        fun `Tank equipments should be what I set it to`() {
            expectThat(Tank(3000000, listOf("Porte", "Contrôle de température", "Dégustateur"))) {
                get { equipments }.isEqualTo(listOf("Porte", "Contrôle de température", "Dégustateur"))
            }
        }

        @Test
        fun `Barrel equipments should be Robinet, Bonde`() {
            expectThat(Barrel(22500)) {
                get { equipments }.isEqualTo(listOf("Robinet", "Bonde"))
            }
        }

        @Test
        fun `Magnum should not have equipments`() {
            expectThat(Magnum()) {
                get { equipments }.isEmpty()
            }
        }

        @Test
        fun `Bottle should not have equipments`() {
            expectThat(Bottle()) {
                get { equipments }.isEmpty()
            }
        }
    }
}