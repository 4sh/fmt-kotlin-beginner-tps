package fmt.kotlin.fundamentals

// guide
// STEP 2
// 1 : handle error case
// 2 : version with subject and without subject


// method main
fun main() {
    println(getFirstPrimeNumbers())
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
fun getFirstPrimeNumbers(nbToFind: Int = 10): String = when (nbToFind) {
    in Int.MIN_VALUE..MIN -> ERROR_MIN
    in MAX..<Int.MAX_VALUE -> ERROR_MAX
    else -> {
        computeFirstPrimeNumbers(nbToFind)
    }
}

// version with when + subject
fun getFirstPrimeNumbers2(nbToFind: Int = 10): String = when {
    nbToFind < MIN -> ERROR_MIN
    nbToFind > MAX -> ERROR_MAX
    else -> {
        computeFirstPrimeNumbers(nbToFind)
    }
}

private fun computeFirstPrimeNumbers(nbToFind: Int): String {
    var current = 2
    var found = ""
    var nbFound = 0

    // while
    while (nbFound < nbToFind) {
        if (isPrime(current)) {
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
