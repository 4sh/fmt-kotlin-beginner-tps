package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int
) {
    override fun toString() = "Bouteille de $name de $year"
}

fun String.toBottle() = try {
    val year = takeLast(4)
    val substringAfter = substringAfter("Bouteille de ")
    val name = substringAfter.substringBefore(" de $year")

    Bottle(name, year.toInt())
} catch (e: NumberFormatException) {
    null
} finally {
    println(this)
}