package fmt.kotlin.fundamentals

class Cellar(
    private val barrels: MutableList<Barrel>
) {
    constructor(nbBarrels: Int): this(generateBarrels(nbBarrels))

    val totalBarrels: Int
        get() = barrels.size

    fun addBarrels(nb: Int) {
        barrels.addAll(generateBarrels(nb))
    }

    fun removeBarrels(nb: Int) {
        for (i in 1..nb) {
            barrels.remove(barrels.last())
        }
    }
}

/**
 * Generate a list of n barrels of 225L
 * @param n number of barrels to generate
 */
fun generateBarrels(n: Int) = (1..n)
    .map { Barrel(225) }
    .toMutableList()