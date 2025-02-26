package fmt.kotlin.fundamentals

class Cellar private constructor(
    ownerName: String,
    private var wineBarrels: List<WineBarrel>,
) {
    constructor(ownerName: String) : this(ownerName, listOf())

    val totalWineCapacityInLiters: Int
        get() {
            var totalCapacity = 0

            for (wineBarrel in wineBarrels) {
                totalCapacity += wineBarrel.capacityInLiters
            }

            return totalCapacity
        }

    var cellarName = "Cave de " + ownerName
        set(ownerName) {
            field = "Cave de " + ownerName
        }

    fun addBarrels(wineBarrels: List<WineBarrel>) {
        this.wineBarrels = this.wineBarrels.plus(wineBarrels)
    }

    fun age(monthsNumber: Int) {
        for (wineBarrel in wineBarrels) {
            wineBarrel.age(monthsNumber)
        }
    }
}