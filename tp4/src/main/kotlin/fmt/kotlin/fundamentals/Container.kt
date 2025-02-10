package fmt.kotlin.fundamentals

sealed class Container(
    val capacity: Int,
    possibleCapacities: IntRange
) {
    val valid = (possibleCapacities).contains(capacity)

    fun containersNeededToPourIn(container: Container) = when (this) {
        is Tank -> when (container) {
            is Barrel, is FixedVolumeContainer -> capacity / container.capacity
            is Tank -> -1
        }

        is Barrel -> if (container is FixedVolumeContainer) {
            capacity / container.capacity
        } else -1

        is FixedVolumeContainer -> -1
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