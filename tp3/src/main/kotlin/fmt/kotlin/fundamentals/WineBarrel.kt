package fmt.kotlin.fundamentals

class WineBarrel private constructor(
    val capacityInLiters: Int = 225,
    private var wineAgeInMonths: Int
) {
    fun age(monthsNumber: Int) {
        wineAgeInMonths += monthsNumber
    }

    constructor(capacityInLiters: Int = 225) : this(capacityInLiters, 0)

    constructor(capacityInLiters: Int = 225, wineBarrel: WineBarrel) : this(
        capacityInLiters,
        wineBarrel.wineAgeInMonths
    )

    init {
        if (capacityInLiters > 500) {
            println("Warning: barrel is high, thus wine won't taste good")
        }
    }

    fun description(): String {
        return """
            Capacité en litres: $capacityInLiters
            Âge du vin : $wineAgeInMonths
        """.trimIndent()
    }
}