package fmt.kotlin.fundamentals

sealed class Container(
    val capacity: Int,
    possibleCapacities: IntRange
) {
    init {
        if (!(possibleCapacities).contains(capacity)) {
            throw IllegalArgumentException()
        }
    }

    val equipments: List<String> = emptyList()

    fun containersNeededToPourIn(container: Container) = when (this) {
        is Tank -> when (container) {
            is Barrel, is FixedVolumeContainer -> capacity / container.capacity
            is Tank -> throw IllegalArgumentException()
        }

        is Barrel -> if (container is FixedVolumeContainer) {
            capacity / container.capacity
        } else throw IllegalArgumentException()

        is FixedVolumeContainer -> throw IllegalArgumentException()
    }
}

class Barrel(
    capacity: Int
) : Container(capacity, 20000..40000)

class Tank(
    capacity: Int
) : Container(capacity, 2000000..10000000)

sealed class FixedVolumeContainer(capacity: Int) : Container(capacity, capacity..capacity)

class Magnum : FixedVolumeContainer(150)
class Bottle : FixedVolumeContainer(75)