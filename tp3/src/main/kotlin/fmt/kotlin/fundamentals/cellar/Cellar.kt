package fmt.kotlin.fundamentals.cellar

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
//            wineBarrel.age(monthsNumber)
        }
    }

    fun description(): String {
        var description = """
            Nom de la cave : $cellarName
            Nombre de barriques: ${wineBarrels.size}
            Capacité totale en litres : $totalWineCapacityInLiters
            Barriques de la cave : 
            
        """.trimIndent()

        for (wineBarrel in wineBarrels) {
            description += wineBarrel.description() + "\n"
        }

        return description
    }
}