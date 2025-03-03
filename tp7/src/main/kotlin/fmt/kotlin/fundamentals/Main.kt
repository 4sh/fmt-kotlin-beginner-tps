package fmt.kotlin.fundamentals


fun main() {
    val cellar = Cellar(listOf(
        WineBottle(
            WineType.RED,
            2016,
            "Isabelle",
            1.0
        ),
        WineBottle(
            WineType.WHITE,
            2011,
            "Melon de Bourgogne",
            0.75
        ),
        WineBottle(
            WineType.ROSE,
            2018,
            "Sangiovese",
            2.0
        ),
    ))


}

fun buildWineTypeDescription(wineType: WineType): String =
    when (wineType) {
        WineType.RED -> "rouge"
        WineType.WHITE -> "blanc"
        WineType.ROSE -> "rosé"
    }