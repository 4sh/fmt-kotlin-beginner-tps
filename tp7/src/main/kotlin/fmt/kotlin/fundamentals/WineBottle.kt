package fmt.kotlin.fundamentals

data class WineBottle(
    val wineType: WineType,
    val year: Int,
    val grapeVariety: String,
    val volumeInLiters: Double
) {
}

enum class WineType {
    RED,
    WHITE,
    ROSE
}