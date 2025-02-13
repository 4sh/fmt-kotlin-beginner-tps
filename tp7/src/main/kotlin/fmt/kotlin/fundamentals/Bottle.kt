package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int
) {
    fun describe() = "Bouteille de $name de $year"
}