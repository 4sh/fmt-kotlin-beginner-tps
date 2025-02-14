package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int,
    val color: WineColor
)

enum class WineColor {
    RED,
    WHITE
}