package fmt.kotlin.fundamentals

data class WineBottle(
    val wineType: WineType,
    val year: Int,
    val grapeVariety: String,
    val volumeInLiters: Double
) {
    fun describe(): String {
        return "Vin ${buildWineTypeDescription(wineType)} de l'année $year"
    }
}

enum class WineType {
    RED,
    WHITE,
    ROSE
}