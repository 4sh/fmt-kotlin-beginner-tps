package fmt.kotlin.fundamentals

import fmt.kotlin.fundamentals.WineColor.RED

data class Cellar(
    val bottles: List<Bottle>
) {
    fun describeBottles() = bottles.joinToString("\n") { bottle ->
        bottle.run {
            "Bouteille de ${name} de ${year}"
        }
    }

    fun describeRedBottles() = bottles.joinToString("\n") {
        it.takeIf { it.color == RED }
            ?.let {
                "Bouteille de ${it.name} de ${it.year}"
            }
            ?: "Bouteille de blanc"
    }
}