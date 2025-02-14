package fmt.kotlin.fundamentals

interface InventoryRepository {

    fun addCellar(cellar: Cellar): Entity<Cellar>

    fun addBottle(bottle: Bottle, cellarId: String): Entity<Bottle>

    fun findBottles(cellarId: String): List<Entity<Bottle>>

    fun findCellarId(bottleId: String): String?

    fun findAllCellarIds(): List<String>

    fun clear(cellarId: String)
}
