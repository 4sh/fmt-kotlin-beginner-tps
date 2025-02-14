package fmt.kotlin.fundamentals

import java.io.InputStream
import java.nio.file.Path
import java.util.*
import kotlin.io.path.*

class InventoryFileRepository(
    val basePath: Path
) : InventoryRepository {

    override fun addCellar(cellar: Cellar) = Entity(
        id = newId(),
        data = cellar
    )
        .also { cellarEntity ->
            basePath.resolve(cellarEntity.id).createDirectory()

            cellar.bottles.forEach {
                addBottle(it, cellarEntity.id)
            }
        }

    override fun addBottle(bottle: Bottle, cellarId: String): Entity<Bottle> {
        val dirPath = basePath.resolve(cellarId)
        if (dirPath.notExists()) {
            throw IllegalArgumentException("Cellar does not exists: $cellarId")
        }
        val bottleEntity = Entity(
            id = newId(),
            data = bottle
        )
        dirPath.resolve(bottleEntity.id).writeText("${bottle.name},${bottle.year}")

        return bottleEntity
    }

    override fun findBottles(cellarId: String) =
        basePath.resolve(cellarId).toFile().listFiles()!!.map {
            Entity(
                it.name,
                it.readText().toBottle()
            )
        }


    override fun findCellarId(bottleId: String) =
        basePath.listDirectoryEntries().firstOrNull {
            it.toFile().list()?.any { it == bottleId } ?: false
        }?.name


    override fun findAllCellarIds() = basePath.toFile().list()!!.toList()

    override fun clear(cellarId: String) {
        basePath.resolve(cellarId).toFile().deleteRecursively()
    }

    override fun importBottle(cellarId: String, stream: InputStream) =
        stream.reader()
            .use {
                it.readText()
            }
            .toBottle()
            .also {
                addBottle(it, cellarId)
            }

    companion object {
        private fun newId() = UUID.randomUUID().toString()
    }
}

private fun String.toBottle() = split(",").let {
    Bottle(it.first(), it.get(1).toInt())
}