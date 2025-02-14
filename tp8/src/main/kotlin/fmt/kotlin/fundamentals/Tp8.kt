package fmt.kotlin.fundamentals

class Tp8 {

    fun getFirstPrimeNumbers(nbToFind: Int) = generateSequence(2) { it + 1 }
        .filter { it.isPrime() }
        .take(nbToFind)
        .toList()

    private fun Int.isPrime() = generateSequence(2) { it + 1 }
        .takeWhile { it < this }
        .none() { this % it == 0 }
}