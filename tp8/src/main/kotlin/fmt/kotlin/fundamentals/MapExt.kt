package fmt.kotlin.fundamentals

/**
 * Merge with [map] using [operation] to compute the new value.
 *
 * If one map have no entry for a key, operation is not called and the existing value is used.
 *
 * @param map       the map to merge with
 * @param operation an operation to call on entry with a value in both map to compute the new value
 * @return a new map with keys of both maps and values computed with [operation]
 */
fun Map<String, Int>.merge(map: Map<String, Int>, operation: (Int, Int) -> Int): Map<String, Int> = TODO()