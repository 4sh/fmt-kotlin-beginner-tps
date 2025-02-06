package fmt.kotlin.fundamentals

class Tp1 {

    var x = 0

    fun incrementXAndReturnOldValue(): Int {
        return x++;
    }

    fun incrementXAndReturnNewValue(): Int {
        return ++x;
    }

    fun sum(m: Int, n: Int): Int {
        return m + n
    }

    /**
     * n Number of bottles. Always more than 2.
     */
    fun describeNbBottles(n: Int): String {
        return "There are $n bottles";
    }

    fun describeWithDetailNbBottles(totalBottles: Int, nbWhiteBottles: Int, nbRedBottles: Int): String {
        return """
            There are $totalBottles bottles :
                - $nbWhiteBottles bottles of white
                - $nbRedBottles bottles of red
        """.trimIndent()
    }
}