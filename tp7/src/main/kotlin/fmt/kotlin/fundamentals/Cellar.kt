package fmt.kotlin.fundamentals

data class Cellar(val bottles: List<WineBottle>) {
    fun describeBottles(descriptionBuilder: (WineBottle, MealType) -> String, mealType: MealType) {
        for(i in bottles.indices) {
            println("$i: ${descriptionBuilder(bottles[i], mealType)}")
        }
    }
}