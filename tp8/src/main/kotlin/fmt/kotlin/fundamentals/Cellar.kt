package fmt.kotlin.fundamentals

data class Vineyard(
    val cellars: List<Cellar>
) {

    fun countBottles() = cellars.fold(emptyMap<String, Int>()) { res, cellar ->
        res.merge(cellar.bottles.groupingBy { it.name }.eachCount()) { n, m -> n + m }
    }
}

data class Cellar(
    val bottles: List<Bottle>
)

data class Bottle(
    val name: String,
    val year: Int
)
