package fmt.kotlin.fundamentals

val buildWineBottleShortDescription: (WineBottle) -> String = {
    "Vin ${buildWineTypeDescription(it.wineType)} de l'année ${it.year}"
}

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

    cellar.describeBottles(buildWineBottleShortDescription)

    cellar.describeBottles({
        "Vin ${buildWineTypeDescription(it.wineType)} de l'année ${it.year}, " +
                "cépage ${it.grapeVariety}, bouteille de ${it.volumeInLiters} litres"
    })
    cellar.describeBottles {
        "Vin ${buildWineTypeDescription(it.wineType)} de l'année ${it.year}, " +
                "cépage ${it.grapeVariety}, bouteille de ${it.volumeInLiters} litres"
    }
    cellar.describeBottles(WineBottle::describe)
}

fun buildWineTypeDescription(wineType: WineType): String =
    when (wineType) {
        WineType.RED -> "rouge"
        WineType.WHITE -> "blanc"
        WineType.ROSE -> "rosé"
    }