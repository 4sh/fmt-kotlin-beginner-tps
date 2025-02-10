package fmt.kotlin.fundamentals

interface Container {
    val capacity: Int
}

class Barrel(
    override val capacity: Int
) : Container

class Tank(
    override val capacity: Int
) : Container