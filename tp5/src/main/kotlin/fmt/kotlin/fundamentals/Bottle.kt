package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int,
    val color: WineColor
) {

    val mainSales = color.mainSales

    fun isEqualTo(bottle: Bottle) = this == bottle

    fun isSameInstance(bottle: Bottle) = this === bottle

    override fun toString() = "Bouteille de $name ${color.translate()} de $year"
}

enum class WineColor(
    val mainSales: Boolean
) {
    RED(true),
    WHITE(false);

    fun translate() = when (this) {
        RED -> "rouge"
        WHITE -> "blanc"
    }
}