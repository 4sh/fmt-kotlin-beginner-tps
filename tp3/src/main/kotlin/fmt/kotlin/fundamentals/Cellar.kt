package fmt.kotlin.fundamentals

class Cellar(
    private val barrels: MutableList<Barrel>
) {
    val totalBarrels: Int = 0

    fun addBarrels(nb: Int) {
    }

    fun removeBarrels(nb: Int) {
    }
}

/**
 * Generate a list of n barrels of 225L
 * @param n number of barrels to generate
 */
fun generateBarrels(n: Int) = (1..n)
    .map { Barrel(225) }
    .toMutableList()