package fmt.kotlin.fundamentals

class WineBarrel private constructor(
    val capacityInLiters: Int = 225,
    private var wineAgeInMonths: Int
) {
    constructor(capacityInLiters: Int = 225) : this(capacityInLiters, 0)

    constructor(capacityInLiters: Int = 225, wineBarrel: WineBarrel) : this(
        capacityInLiters,
        wineBarrel.wineAgeInMonths
    )
}