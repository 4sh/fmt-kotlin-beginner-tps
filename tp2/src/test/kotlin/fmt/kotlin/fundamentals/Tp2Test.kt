package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Tp2Test {

    @Nested
    inner class Prime {

        @Test
        fun `should return 100 first prime numbers`() {
            val numbers = getFirstPrimeNumbers(100)

            expectThat(numbers).isEqualTo(
                "[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541]"
            )
        }

        @Test
        fun `should fail with 0`() {
            val error = getFirstPrimeNumbers(0)
            expectThat(error).isEqualTo("nbToFind must be > 0")
        }

        @Test
        fun `should fail with 10001`() {
            val error = getFirstPrimeNumbers(10001)
            expectThat(error).isEqualTo("nbToFind must be < 10000")
        }
    }
}