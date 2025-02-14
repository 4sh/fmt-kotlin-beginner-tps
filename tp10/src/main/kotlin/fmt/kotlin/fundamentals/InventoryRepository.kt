package fmt.kotlin.fundamentals

import java.io.InputStream

interface InventoryRepository {

    /**
     * Store a cellar and all bottles in it.
     *
     * @param cellar the [Cellar] to store
     * @return an Entity containing the generated id and the created cellar
     */
    fun addCellar(cellar: Cellar): Entity<Cellar>

    /**
     * Creates a bottle in the [Cellar] referenced by [cellarId].
     *
     * @param bottle the [Bottle] to create
     * @param cellarId the [Cellar] about to contain the new [Bottle]
     * @throws [IllegalArgumentException] if [Cellar] does not exist
     */
    fun addBottle(bottle: Bottle, cellarId: String): Entity<Bottle>

    /**
     * Lists all bottles in the cellar.
     *
     * @param cellarId the [Cellar] to list [Bottle]s from
     * @return a [List] of [Entity] containing the [Bottle]s in the [Cellar]
     */
    fun findBottles(cellarId: String): List<Entity<Bottle>>

    /**
     * Give the id of the cellar containing this bottle if it exists.
     *
     * @param bottleId the id of the [Bottle] to find.
     * @return the cellar id of the [Cellar] containing this [Bottle], null if the [Bottle] does not exist
     */
    fun findCellarId(bottleId: String): String?

    /**
     * List all cellar ids
     *
     * @return the id of all [Cellar]s
     */
    fun findAllCellarIds(): List<String>

    /**
     * Remove the cellar and all the bottles in it.
     *
     * @param cellarId id of the [Cellar] to remove
     */
    fun clear(cellarId: String)

    /**
     * Create a bottle in a cellar.
     *
     * @param cellarId id of the [Cellar] to import into
     * @param stream an [InputStream] containing the [Bottle] data encoded in UTF-8 as `"[name],[year]"`
     * @return the [Bottle] created
     */
    fun importBottle(cellarId: String, stream: InputStream): Bottle
}
