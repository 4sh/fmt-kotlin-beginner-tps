package fmt.kotlin.fundamentals

import java.io.InputStream

class InventoryService(
    private val repository: InventoryRepository
) {

    fun addCellar(cellar: Cellar) = repository.addCellar(cellar)

    fun addBottle(botte: Bottle, cellarId: String) = repository.addBottle(botte, cellarId)

    fun findBottles(cellarId: String) = repository.findBottles(cellarId)

    fun findCellarId(bottleId: String) = repository.findCellarId(bottleId)

    fun findAllCellarIds() = repository.findAllCellarIds()

    fun clear(cellarId: String) = repository.clear(cellarId)

    fun importBottle(cellarId: String, stream: InputStream) = repository.importBottle(cellarId, stream)
}