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

    cellar.describeBottles(MealType.WHITE_MEAT) { wineBottle, mealType ->
        val winePairingAdvice = if (wineBottle.wineType.goesWellWith(
                mealType
            )
        ) {
            "Nous vous recommandons ce vin pour s'accorder avec votre plat."
        } else {
            "Ce vin n'est pas le meilleur choix pour accompagner votre plat."
        }

        "Vin ${buildWineTypeDescription(wineBottle.wineType)} de l'année ${wineBottle.year}. $winePairingAdvice"
    }

    cellar.describeBottles(MealType.RED_MEAT) { wineBottle, _ ->
        "Vin ${buildWineTypeDescription(wineBottle.wineType)} de l'année ${wineBottle.year}."
    }
}

fun buildWineTypeDescription(wineType: WineType): String =
    when (wineType) {
        WineType.RED -> "rouge"
        WineType.WHITE -> "blanc"
        WineType.ROSE -> "rosé"
    }