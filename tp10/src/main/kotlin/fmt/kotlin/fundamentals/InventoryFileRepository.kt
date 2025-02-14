package fmt.kotlin.fundamentals

import java.io.InputStream
import java.nio.file.Path
import java.util.UUID

class InventoryFileRepository(
    val basePath: Path
) : InventoryRepository {

    override fun addCellar(cellar: Cellar): Entity<Cellar> {
        TODO("Not yet implemented")
    }

    override fun addBottle(bottle: Bottle, cellarId: String): Entity<Bottle> {
        TODO("Not yet implemented")
    }

    override fun findBottles(cellarId: String): List<Entity<Bottle>> {
        TODO("Not yet implemented")
    }

    override fun findCellarId(bottleId: String): String? {
        TODO("Not yet implemented")
    }

    override fun findAllCellarIds(): List<String> {
        TODO("Not yet implemented")
    }

    override fun clear(cellarId: String) {
        TODO("Not yet implemented")
    }

    override fun importBottle(cellarId: String, stream: InputStream): Bottle {
        TODO("Not yet implemented")
    }

    companion object {
        private fun newId() = UUID.randomUUID().toString()
    }
}