package fmt.kotlin.fundamentals

data class Cellar(
    val bottles: List<Bottle>
) {
    fun describeBottles() = bottles.joinToString("\n") { bottle ->
        bottle.run {
            "Bouteille de ${name} de ${year}"
        }
    }
}