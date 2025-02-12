package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int
) {
    override fun toString() = "Bouteille de $name de $year"
}