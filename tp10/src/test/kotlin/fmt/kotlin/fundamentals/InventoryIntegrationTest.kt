package fmt.kotlin.fundamentals

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.*
import java.nio.file.Files
import kotlin.io.path.absolute

class InventoryIntegrationTest {

    private val service = InventoryService(InventoryFileRepository(Files.createTempDirectory("inventory").absolute()))

    @BeforeEach
    fun setup() {
        service.findAllCellarIds()
            .forEach(service::clear)
    }

    @Test
    fun `should not find any cellars`() {
        val cellarIds = service.findAllCellarIds()
        expectThat(cellarIds).isEmpty()
    }

    @Nested
    inner class AddCellar {

        @Test
        fun `should add cellar with no bottles and find it`() {
            val cellar = service.addCellar(Cellar(emptyList()))

            val cellars = service.findAllCellarIds()
            expectThat(cellars)
                .hasSize(1)
                .first().isEqualTo(cellar.id)
        }

        @Test
        fun `should add cellar with bottles and find them`() {
            val cellar = service.addCellar(
                Cellar(
                    listOf(
                        Bottle("Coucheroy", 2005),
                        Bottle("Pedesclaux", 2009)
                    )
                )
            )

            val bottles = service.findBottles(cellar.id)
            expectThat(bottles.sortedBy { it.data.name })
                .hasSize(2)
                .withFirst {
                    get { data.name }.isEqualTo("Coucheroy")
                    get { data.year }.isEqualTo(2005)
                }
                .withElementAt(1) {
                    get { data.name }.isEqualTo("Pedesclaux")
                    get { data.year }.isEqualTo(2009)
                }

        }
    }

    @Nested
    inner class AddBottle {

        @Test
        fun `should not add bottle in not existing cellar`() {
            expectThrows<IllegalArgumentException> {
                service.addBottle(Bottle("Coucheroy", 2005), "1")
            }
        }

        @Test
        fun `should add bottle in cellar`() {
            val cellar = service.addCellar(Cellar(emptyList()))

            service.addBottle(Bottle("Coucheroy", 2005), cellar.id)

            val bottles = service.findBottles(cellar.id)

            expectThat(bottles)
                .hasSize(1)
                .single().and {
                    get { data.name }.isEqualTo("Coucheroy")
                    get { data.year }.isEqualTo(2005)
                }
        }
    }

    @Nested
    inner class FindCellarId {

        @Test
        fun `should find cellar id`() {
            val cellar1 = service.addCellar(Cellar(emptyList()))
            val cellar2 = service.addCellar(Cellar(emptyList()))

            val bottle = service.addBottle(Bottle("Coucheroy", 2005), cellar1.id)
            service.addBottle(Bottle("Pedesclaux", 2009), cellar1.id)
            service.addBottle(Bottle("Coucheroy", 2005), cellar2.id)
            service.addBottle(Bottle("Talbot", 2015), cellar2.id)

            val cellarId = service.findCellarId(bottle.id)

            expectThat(cellarId).isEqualTo(cellar1.id)
        }
    }

    @Nested
    inner class Import {

        @Test
        fun `should import bottle`() {
            val cellar = service.addCellar(Cellar(emptyList()))

            val bottle = service.importBottle(cellar.id, "Coucheroy,2009".byteInputStream())

            expectThat(bottle) {
                get { name }.isEqualTo("Coucheroy")
                get { year }.isEqualTo(2009)
            }

            val bottles = service.findBottles(cellar.id)

            expectThat(bottles)
                .hasSize(1)
                .withFirst {
                    get { data.name }.isEqualTo("Coucheroy")
                    get { data.year }.isEqualTo(2009)
                }
        }
    }
}