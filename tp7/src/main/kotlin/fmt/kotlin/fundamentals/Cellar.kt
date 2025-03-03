package fmt.kotlin.fundamentals

data class Cellar(val bottles: List<WineBottle>) {
    fun describeBottles(mealType: MealType, descriptionBuilder: (WineBottle, MealType) -> String) {
        for(i in bottles.indices) {
            println("$i: ${descriptionBuilder(bottles[i], mealType)}")
        }
    }
}