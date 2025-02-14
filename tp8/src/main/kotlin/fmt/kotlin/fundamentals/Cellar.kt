package fmt.kotlin.fundamentals

data class Vineyard(
    val cellars: List<Cellar>
) {

    fun countBottles() = emptyMap<String, Int>()
}

data class Cellar(
    val bottles: List<Bottle>
)

data class Bottle(
    val name: String,
    val year: Int
)
