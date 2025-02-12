package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int
) {

    fun isEqualTo(bottle: Bottle) = this == bottle

    fun isSameInstance(bottle: Bottle) = this === bottle
}