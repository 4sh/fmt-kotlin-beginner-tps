package fmt.kotlin.fundamentals

const val INIT = 42

// not present
// val/var
var x: Int = 0

// assignation
fun initValue() {
    x = INIT
}

fun incrementXAndReturnOldValue(): Int {
    return x++;
}

fun incrementXAndReturnNewValue(): Int {
    return ++x;
}

// literal
fun sumZeroPointFive(): Float {
    return x + 0.5f
}

// literal
fun subtractBigNumber(): Int {
    return x + 1_234_567
}

fun checkIfPositive(): Boolean {
    return x > 0
}

fun checkIfRangeOpenEnded(): IntRange {
    return 1..<42
}

fun checkIfRangeOpenClosed(): IntRange {
    return 1..42
}

fun conversion(): Short {
    return x.toShort()
}

fun shitright(): Int {
    return x shr 1
}

/**
 * n Number of bottles. Always more than 2.
 */
fun describeNbBottles(n: Int): String {
    return "There are $n bottles for ${n * 10}\n"
}

fun describeWithDetailNbBottles(totalBottles: Int, nbWhiteBottles: Int, nbRedBottles: Int): String {
    return """
            There are $totalBottles bottles :
                - $nbWhiteBottles bottles of white
                - $nbRedBottles bottles of red
        """.trimIndent()
}