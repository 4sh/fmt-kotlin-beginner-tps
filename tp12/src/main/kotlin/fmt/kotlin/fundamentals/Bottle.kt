package fmt.kotlin.fundamentals

data class Bottle(
    val name: String,
    val year: Int,
    val color: WineColor
) {
    fun description(): String {
        return if (year < 2010){
            "Aged $color $name, from $year, with complex nose of dried fruit, leather, and tobacco. " +
                    "Silky texture, softened tannins, and deep flavors of dark fruit and truffle. Long, elegant finish."
        } else {
            "Young $color $name, from $year, with fresh aromas of blackberry and violet. " +
                    "Lively and structured on the palate, with firm tannins and bright acidity. " +
                    "Crisp, fruity finish with a touch of spice."
        }
    }
}

enum class WineColor {
    RED,
    WHITE
}