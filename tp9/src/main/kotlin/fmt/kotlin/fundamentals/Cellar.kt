package fmt.kotlin.fundamentals

import fmt.kotlin.fundamentals.UserRole.BUYER
import fmt.kotlin.fundamentals.UserRole.OWNER
import fmt.kotlin.fundamentals.WineColor.RED

data class Cellar(
    val bottles: MutableList<Bottle>
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

    fun addBottle(bottle: Bottle) {
        with(Session.currentUser) {
            when (role) {
                OWNER -> bottles.add(bottle)
                    .also { println(bottle) }
                BUYER -> throw UnauthorizedException(login)
            }
        }
    }
}