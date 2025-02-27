package fmt.kotlin.fundamentals

class Cellar(val size: Int, private val store: WineStore = WineStore()) {
    private val bottles: MutableList<Bottle> = mutableListOf()
    val bottleCount
        get() = bottles.size
    private val spaceLeft
        get() = size - bottleCount

    fun describeBottles() = bottles.joinToString("\n") { bottle ->
        bottle.description()
    }

    /**
     * Returns the sum of the prices of all the bottles
     */
    fun cellarValue(): Price = bottles.sumOf { this.store.bottlePrice(it) }

    /**
     * Adds bottle to the list only if there space left for it
     */
    fun addBottle(bottle: Bottle) =
        if (spaceLeft > 0) bottles.add(bottle) else null.also { println("Cellar is full, cannot add bottle") }

    /**
     * Removes and returns the first bottle of color from the bottle list
     */
    fun takeColoredBottle(color: WineColor): Bottle? =
        bottles.firstOrNull { it.color == color }?.also { bottles.remove(it) }

    /**
     * Removes and returns the first bottle matching all criteria from the bottle list
     */
    fun takeSpecificBottle(name: String, year: Int, color: WineColor): Bottle? = bottles.firstOrNull {
        it.name.contains(name) && it.year == year && it.color == color
    }?.also { bottles.remove(it) }
}