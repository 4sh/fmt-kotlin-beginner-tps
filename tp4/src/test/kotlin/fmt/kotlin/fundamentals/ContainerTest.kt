package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isA
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class ContainerTest {

    @Nested
    inner class Instances {

        @Test
        fun `Barrel should be a Container`() {
            expectThat(Barrel(20000)).isA<Container>()
        }

        @Test
        fun `Tank should be a Container`() {
            expectThat(Tank(3000000)).isA<Container>()
        }
    }

    @Nested
    inner class PossibleCapacities {

        @Test
        fun `Barrel should be created with 22500 cL`() {
            val container = Barrel(22500)
            expectThat(container) {
                get { valid }.isTrue()
            }
        }

        @Test
        fun `Barrel should not be created with 18000 cL`() {
            val container = Barrel(18000)
            expectThat(container) {
                get { valid }.isFalse()
            }
        }

        @Test
        fun `Barrel should not be created with 45000 cL`() {
            val container = Barrel(45000)
            expectThat(container) {
                get { valid }.isFalse()
            }
        }

        @Test
        fun `Tank should be created with 3000000 cL`() {
            val container = Tank(3000000)
            expectThat(container) {
                get { valid }.isTrue()
            }
        }

        @Test
        fun `Tank should not be created with 1800000 cL`() {
            val container = Tank(1800000)
            expectThat(container) {
                get { valid }.isFalse()
            }
        }

        @Test
        fun `Tank should not be created with 12000000 cL`() {
            val container = Tank(12000000)
            expectThat(container) {
                get { valid }.isFalse()
            }
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
            val containersNeeded = Tank(3000000).containersNeededToPourIn(Tank(3000000))

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should be able to pour Tank in Barrel`() {
            val containersNeeded = Tank(3000000).containersNeededToPourIn(Barrel(20000))

            expectThat(containersNeeded).isEqualTo(150)
        }

        @Test
        fun `should be able to pour Tank in Magnum`() {
            val containersNeeded = Tank(3000000).containersNeededToPourIn(Magnum())

            expectThat(containersNeeded).isEqualTo(20000)
        }

        @Test
        fun `should be able to pour Tank in Bottle`() {
            val containersNeeded = Tank(3000000).containersNeededToPourIn(Bottle())

            expectThat(containersNeeded).isEqualTo(40000)
        }

        @Test
        fun `should not be able to pour Barrel in Tank`() {
            val containersNeeded = Barrel(20000).containersNeededToPourIn(Tank(3000000))

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should not be able to pour Barrel in Barrel`() {
            val containersNeeded = Barrel(20000).containersNeededToPourIn(Barrel(20000))

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should be able to pour Barrel in Magnum`() {
            val containersNeeded = Barrel(22500).containersNeededToPourIn(Magnum())

            expectThat(containersNeeded).isEqualTo(150)
        }

        @Test
        fun `should be able to pour Barrel in Bottle`() {
            val containersNeeded = Barrel(22500).containersNeededToPourIn(Bottle())

            expectThat(containersNeeded).isEqualTo(300)
        }

        @Test
        fun `should not be able to pour Magnum in Tank`() {
            val containersNeeded = Magnum().containersNeededToPourIn(Tank(3000000))

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should not be able to pour Magnum in Barrel`() {
            val containersNeeded = Magnum().containersNeededToPourIn(Barrel(20000))

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should be able to pour Magnum in Magnum`() {
            val containersNeeded = Magnum().containersNeededToPourIn(Magnum())

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should be able to pour Magnum in Bottle`() {
            val containersNeeded = Magnum().containersNeededToPourIn(Bottle())

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should not be able to pour Bottle in Tank`() {
            val containersNeeded = Bottle().containersNeededToPourIn(Tank(3000000))

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should not be able to pour Bottle in Barrel`() {
            val containersNeeded = Bottle().containersNeededToPourIn(Barrel(20000))

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should not be able to pour Bottle in Magnum`() {
            val containersNeeded = Bottle().containersNeededToPourIn(Magnum())

            expectThat(containersNeeded).isEqualTo(-1)
        }

        @Test
        fun `should be able to pour Bottle in Bottle`() {
            val containersNeeded = Bottle().containersNeededToPourIn(Bottle())

            expectThat(containersNeeded).isEqualTo(-1)
        }
    }
}