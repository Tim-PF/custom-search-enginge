package search_engine

import java.io.File

fun mapFiles(files: Array<File>) : Map<Int,File> {
    val map = mutableMapOf<Int,File>()
    files.withIndex().forEach {
        if (it.value.isDirectory) return@forEach
        if (it.value.extension != "txt") return@forEach
        map[it.index] = it.value
    }
    return map
}