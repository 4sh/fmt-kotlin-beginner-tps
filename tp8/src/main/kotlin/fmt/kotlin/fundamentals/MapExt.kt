package fmt.kotlin.fundamentals

/**
 * Merge with [map] using [operation] to compute the new value.
 *
 * If one map have no entry for a key, operation is not called and the existing value is used.
 *
 * @param K the type of keys in the maps
 * @param V the type of values in the maps
 * @param map       the map to merge with
 * @param operation an operation to call on entry with a value in both map to compute the new value
 * @return a new map with keys of both maps and values computed with [operation]
 */
fun <K, V> Map<K, V>.merge(map: Map<K, V>, operation: (V, V) -> V): Map<K, V> =
    (keys + map.keys).associateWith { key ->
        if (this[key] != null && map[key] != null) {
            operation(this[key]!!, map[key]!!)
        } else {
            this[key] ?: map[key]!!
        }
    }
