package fmt.kotlin.fundamentals

fun main() {
    println(getFirstPrimeNumbers())
}

private const val MIN = 0
private const val MAX = 10000
private const val ERROR_MIN = "nbToFind must be > 0"
private const val ERROR_MAX = "nbToFind must be < 10000"

private const val prefix = "["
private const val separator = ", "
private const val suffix = "]"

fun getFirstPrimeNumbers(nbToFind: Int = 10): String = when {
    nbToFind <= MIN -> ERROR_MIN
    nbToFind > MAX -> ERROR_MAX
    else -> computeFirstPrimeNumbers(nbToFind)
}

private fun computeFirstPrimeNumbers(nbToFind: Int = 10): String {
    var current = 2
    var found = ""
    var nbFound = 0

    while (nbFound < nbToFind) {
        if (isPrime(current)) {
            found += if (nbFound == 0) {
                prefix
            } else {
                separator
            }
            found += current
            nbFound++
        }
        current++
    }

    found += suffix
    return found
}

private fun isPrime(current: Int): Boolean {
    for (n in 2..<current) {
        if (canBeDivideWithoutRest(current, n)) {
            return false
        }
    }

    return true
}

private fun canBeDivideWithoutRest(current: Int, toTest: Int) = current % toTest == 0