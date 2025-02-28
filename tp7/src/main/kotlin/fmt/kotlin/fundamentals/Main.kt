package fmt.kotlin.fundamentals

val printWineBottle: () -> Unit = { println("Wine bottle") }
val shortlyDescribeWineBottleUsingExplicitAttributeName: (WineBottle) -> Unit = { wineBottle -> println(wineBottle.wineType)}
val shortlyDescribeWineBottleUsingIt: (WineBottle) -> Unit = {  println(it.wineType)}
val buildWineBottleDescription: (WineBottle) -> String = {
    val bottleType = when(it.wineType) {
        WineType.RED -> "rouge"
        WineType.WHITE -> "blanc"
        WineType.ROSE -> "rosé"
    }

    "Vin $bottleType de l'année ${it.year}"
}

fun main() {
    printWineBottle()
    val wineBottle = WineBottle(
        WineType.RED,
        2016,
        "Isabelle",
        1.0
    )
    shortlyDescribeWineBottleUsingExplicitAttributeName(wineBottle)
    shortlyDescribeWineBottleUsingIt(wineBottle)
    println(buildWineBottleDescription(wineBottle))
}