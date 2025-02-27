package fmt.kotlin.fundamentals

typealias Price = Int

class WineStore() {
    fun bottlePrice(bottle: Bottle): Price {
        if (bottle.name.contains("Rothschild")){
            return 300
        } else {
            val age = 2025 - bottle.year
            return when(bottle.color){
                WineColor.RED -> age * 10
                WineColor.WHITE -> 100 - age * 3
            }
        }
    }
}