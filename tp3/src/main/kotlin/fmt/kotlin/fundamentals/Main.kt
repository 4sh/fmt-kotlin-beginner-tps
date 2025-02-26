package fmt.kotlin.fundamentals

fun main() {
    val tooBigBarrel = WineBarrel(600)

    val barrel1 = WineBarrel(271)
    val barrel2 = WineBarrel(376)
    val barrel3 = WineBarrel(642)
    val barrel4 = WineBarrel(522)
    val barrel5 = WineBarrel(58)
    barrel5.age(4)

    val barrel6 = WineBarrel(100, barrel5)

    val cellar = Cellar("Laurent de Sauve d’Yquem")
    cellar.addBarrels(
        listOf(
            barrel1,
            barrel2,
            barrel3,
            barrel4,
            barrel6
        )
    )
    cellar.cellarName = "Joséphine d'Yquem"
    cellar.age(8)
    println(cellar.description())
    println(barrel5.description())

    val bottle = Bottle(1)
    val wineBottle = WineBottle(
        "RED",
        bottle
    )
}