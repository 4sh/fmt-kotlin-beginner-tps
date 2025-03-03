package fmt.kotlin.fundamentals

data class Cellar(val bottles: List<WineBottle>) {
    fun describeBottles(descriptionBuilder: (WineBottle) -> String) {
        for(i in bottles.indices) {
            println("$i: ${descriptionBuilder(bottles[i])}")
        }
    }
}