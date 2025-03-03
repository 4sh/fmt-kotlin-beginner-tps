package fmt.kotlin.fundamentals

data class WineBottle(
    val wineType: WineType,
    val year: Int,
    val grapeVariety: String,
    val volumeInLiters: Double
)

enum class WineType(private val goodMealTypesPairings: List<MealType>) {
    RED(listOf(MealType.RED_MEAT, MealType.CHEESE)),
    WHITE (listOf(MealType.WHITE_FISH, MealType.WHITE_MEAT, MealType.CHEESE)),
    ROSE(listOf(MealType.RED_MEAT, MealType.GREEN_VEGETABLES));

    fun goesWellWith(mealType: MealType): Boolean {
        for (goodMealTypesPairing in goodMealTypesPairings) {
            if (goodMealTypesPairing == mealType) {
                return true
            }
        }

        return false
    }
}