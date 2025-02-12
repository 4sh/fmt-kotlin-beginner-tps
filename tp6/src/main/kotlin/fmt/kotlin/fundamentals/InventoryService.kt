package fmt.kotlin.fundamentals

class InventoryService {

    val bottles = mutableListOf<Bottle>()

    val errors = mutableListOf<String>()

    fun addAll(bottlesText: List<String>) {
        for (s in bottlesText) {
            s.toBottle()?.add() ?: errors.add(s)
        }
    }

    fun Bottle.add() {
        bottles.add(this)
    }
}