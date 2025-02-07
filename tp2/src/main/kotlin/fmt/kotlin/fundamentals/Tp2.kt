package fmt.kotlin.fundamentals

import kotlin.text.Typography.prime

class Tp2 {

    fun getFirstPrimeNumbers(nbToFind: Int): List<Int> {
        // The list containing all the prime numbers we found
        // It is a val because we will modify the array but not build a new array each time we add something to it
        val primeNumbers = arrayListOf<Int>()

        // Start with 2 as 0 and 1 are not prime numbers
        // n is a var because we will change it at the end of each loop to test the next number
        var n = 2

        // Iterate while we don't have enough prime numbers in the list we want to return
        while (primeNumbers.size < nbToFind) {
            var prime = true

            // Iterate over every number until the one we want to test to see if it can be divided
            for (i in 2..n - 1) {
                if (n % i == 0) {
                    prime = false
                    // It if can be divided once, no need to test other numbers
                    break
                }
            }

            // Add it to the list we want to return, if we did not find a divisor
            if (prime) {
                primeNumbers.add(n)
            }

            // We try the next number
            n++
        }

        return primeNumbers
    }

    fun getFirstPrimeNumbersBetter(nbToFind: Int): List<Int> {
        // The list containing all the prime numbers we found
        // It is a val because we will modify the array but not build a new array each time we add something to it
        val primeNumbers = arrayListOf<Int>()

        // Start with 2 as 0 and 1 are not prime numbers
        // n is a var because we will change it at the end of each loop to test the next number
        var n = 2

        // Iterate while we don't have enough prime numbers in the list we want to return
        while (primeNumbers.size < nbToFind) {
            // Add it to the list we want to return, if we did not find a divisor
            if (isPrime(n, primeNumbers)) {
                primeNumbers.add(n)
            }

            // We try the next number
            n++
        }

        return primeNumbers
    }

    private fun isPrime(n: Int, primeNumbers: List<Int>): Boolean {
        for (i in primeNumbers) {
            if (canBeDivided(n, i)) {
                // It if can be divided once, no need to test other numbers
                return false
            }
        }
        return true
    }

    private fun canBeDivided(n: Int, i: Int) = n % i == 0
}