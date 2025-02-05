package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Test

class HelloWorldTest {

    @Suppress("SimplifyBooleanWithConstants") // The compiler knows the test is always successful
    @Test
    fun `should return hello world`() {
        check(HELLO_WORLD == "Hello, World!")

        println()
        println("""
            Bienvenue en Kotlin !
            Si ce message est affiché, c'est que le test s'est correctement exécuté et que ton environnement est correctement configuré.
            À dans quelques jours pour la formation…
        """.trimIndent())
        println()
    }

}
