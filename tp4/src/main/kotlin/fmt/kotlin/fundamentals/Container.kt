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

    open fun containersNeededToPourIn(container: Container) = capacity / container.capacity
}

class Barrel(
    capacity: Int
) : Container(capacity, 20000..40000) {

    override fun containersNeededToPourIn(container: Container) = when (container) {
        is Barrel, is Tank -> throw IllegalArgumentException()
        else -> super.containersNeededToPourIn(container)
    }
}

class Tank(
    capacity: Int
) : Container(capacity, 2000000..10000000) {

    override fun containersNeededToPourIn(container: Container) = if (container is Tank) {
        throw IllegalArgumentException()
    } else super.containersNeededToPourIn(container)
}

sealed class FixedVolumeContainer(capacity: Int) : Container(capacity, capacity..capacity) {
    override fun containersNeededToPourIn(container: Container): Int {
        throw IllegalArgumentException()
    }
}

class Magnum : FixedVolumeContainer(150)
class Bottle : FixedVolumeContainer(75)