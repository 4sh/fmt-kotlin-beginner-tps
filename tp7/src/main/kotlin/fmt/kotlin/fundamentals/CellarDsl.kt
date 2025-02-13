package fmt.kotlin.fundamentals

fun cellar(init: CellarDsl.() -> Unit): Cellar {
    val dsl = CellarDsl()
    dsl.init()
    val cellar = Cellar(
        barrels = dsl.barrels,
        bottles = dsl.bottles
    )
    return cellar
}

class CellarDsl {
    val barrels = mutableListOf<Barrel>()
    val bottles = mutableListOf<Bottle>()

    fun barrel(init: BarrelDsl.() -> Unit): Barrel {
        val dsl = BarrelDsl()
        dsl.init()
        val barrel = Barrel(
            capacity = dsl.capacity
        )
        barrels.add(barrel)
        return barrel
    }

    fun bottle(init: BottleDsl.() -> Unit): Bottle {
        val dsl = BottleDsl()
        dsl.init()
        val bottle = Bottle(
            name = dsl.name,
            year = dsl.year
        )
        bottles.add(bottle)
        return bottle
    }
}

class BarrelDsl {
    var capacity: Int = 0
}

class BottleDsl {
    var name: String = ""
    var year: Int = 0
}