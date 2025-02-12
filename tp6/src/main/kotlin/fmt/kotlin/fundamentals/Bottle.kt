package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int
) {
    override fun toString() = "Bouteille de $name de $year"
}

fun String.toBottle(): Bottle {
    val year = takeLast(4)
    val substringAfter = substringAfter("Bouteille de ")
    val name = substringAfter.substringBefore(" de $year")

    return Bottle(name, year.toInt())
}