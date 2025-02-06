package fmt.kotlin.fundamentals

var x = 0

fun incrementXAndReturnOldValue(): Int {
    return x++
}

fun incrementXAndReturnNewValue(): Int {
    return ++x
}

fun sumZeroPointFive(): Float {
    return x + 0.5f
}

fun subtractBigNumber(): Int {
    return x - 1_854_643
}

fun buildRangeOpen(): IntRange {
    return 1..42
}

fun buildRangeOpenEnded(): IntRange {
    return 1..<42
}

/**
 * n Number of bottles. Always more than 2.
 */
fun describeNbBottles(): String {
    return "There are $x bottles"
}

var totalBottles = 0
var nbWhiteBottles = 0
var nbRedBottles = 0

fun describeWithDetailNbBottles(): String {
    return """
            There are $totalBottles bottles :
                - $nbWhiteBottles bottles of white
                - $nbRedBottles bottles of red
        """.trimIndent()
}
