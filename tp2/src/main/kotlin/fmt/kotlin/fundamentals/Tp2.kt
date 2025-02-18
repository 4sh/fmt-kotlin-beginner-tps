package fmt.kotlin.fundamentals

// guide
// STEP 4
// 1 : add start concept and adapt main call to start from 42


// method main
// named parameter
fun main() {
    println(getFirstPrimeNumbersBatches(1, 2, 3, start = 42))
}

// const
private const val MIN = 0
private const val MAX = 101
private const val ERROR_MIN = "nbToFind must be > 0"
private const val ERROR_MAX = "nbToFind must be > 101"
private const val prefix = "["
private const val separator = ", "
private const val suffix = "]"

// named parameter
// fun
// body function
// when
fun getFirstPrimeNumbersBatches(vararg nbToFindBatches: Int, start: Int): String {
    var result = ""
    for (nbToFind in nbToFindBatches) {
        result +=
            when (nbToFind) {
                in Int.MIN_VALUE..MIN -> ERROR_MIN
                in MAX..<Int.MAX_VALUE -> ERROR_MAX
                else -> {
                    computeFirstPrimeNumbers(start, nbToFind)
                }
            }
        result += "\n"
    }
    return result
}

private fun computeFirstPrimeNumbers(start: Int, nbToFind: Int): String {
    var current = 2
    var found = ""
    var nbFound = 0

    // while
    while (nbFound < nbToFind) {
        if (isPrime(current) && current > start) {
            // concatenation
            // if else
            found += if (nbFound == 0) {
                prefix
            } else {
                separator
            }
            // interpolation
            found += "($current)"
            nbFound++
        }
        current++
    }

    found += suffix
    return found
}

// fun
private fun isPrime(current: Int): Boolean {
    // rand open-ended
    // for loop
    for (n in 2..<current) {
        if (canBeDivideWithoutRest(current, n)) {
            return false
        }
    }
    return true
}

// fun
private fun canBeDivideWithoutRest(current: Int, toTest: Int) = current % toTest == 0
