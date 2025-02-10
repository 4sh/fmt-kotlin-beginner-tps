package fmt.kotlin.fundamentals

abstract class Container(
    val capacity: Int,
    possibleCapacities: IntRange
) {
    val valid = (possibleCapacities).contains(capacity)

    fun containersNeededToPourIn(container: Container) = -1
}

class Barrel(
    capacity: Int
) : Container(capacity, 20000..40000)

class Tank(
    capacity: Int
) : Container(capacity, 2000000..10000000)

abstract class FixedVolumeContainer(capacity: Int) : Container(capacity, capacity..capacity)

class Magnum : FixedVolumeContainer(150)
class Bottle : FixedVolumeContainer(75)