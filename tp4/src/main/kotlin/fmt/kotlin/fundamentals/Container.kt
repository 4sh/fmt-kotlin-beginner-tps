package fmt.kotlin.fundamentals

abstract class Container(
    val capacity: Int,
    possibleCapacities: IntRange
) {
    init {
        if (!(possibleCapacities).contains(capacity)) {
            throw IllegalArgumentException()
        }
    }
}

class Barrel(
    capacity: Int
) : Container(capacity, 20000..40000)

class Tank(
    capacity: Int
) : Container(capacity, 2000000..10000000)