package fmt.kotlin.fundamentals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class WineStoreTest {

    //Créer un test paramétré qui prend en argument Bottle, et Price (Int)
    //Et qui vérifie que le prix calculé de la bouteille correspond au prix donné en paramètre



    class WineStoreArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(Bottle("Haut-Brion", 1997, WineColor.RED), 280),
            Arguments.of(Bottle("Margaux", 2012, WineColor.WHITE), 61),
            Arguments.of(Bottle("Pétrus", 2008, WineColor.RED), 170),
            Arguments.of(Bottle("Lafitte-Rothschild", 1997, WineColor.RED), 300)
        )
    }
}

