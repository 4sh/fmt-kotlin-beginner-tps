package fmt.kotlin.fundamentals

// guide
// STEP 1
// 1 : start from empty file, to write  a function from scratch, valid with runner(test)
// 2: ask for number of functions :  check if use : while, for loop, more functions, body function, bonus : interpolation, range, inference, const...
// 3 : write main function, without parameter (default parameter), valid with output comparison

// method main
fun main() {
    println(getFirstPrimeNumbers())
}

// const
private const val prefix = "["
private const val separator = ", "
private const val suffix = "]"

// named parameter
// fun
// body function
// when
fun getFirstPrimeNumbers(nbToFind: Int = 10): String  {
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
