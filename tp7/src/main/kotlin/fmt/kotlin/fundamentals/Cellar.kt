package fmt.kotlin.fundamentals

import jdk.internal.org.jline.utils.Colors.s

data class Cellar(
    val bottles: List<Bottle>,
    val barrels: List<Barrel> = emptyList()
) {
    fun describeAll() = callOnEveryBottle(Bottle::describe)

    val years
        get() = callOnEveryBottle {
            it.year.toString()
        }

    private fun callOnEveryBottle(block: (Bottle) -> String): String {
        var res = ""
        for (bottle in bottles) {
            res = res + "\n" + block(bottle)
        }
        return res
    }
}