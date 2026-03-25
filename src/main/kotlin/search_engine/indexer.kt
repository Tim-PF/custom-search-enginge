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

fun buildIndex(fileList: Map<Int, File>): Map<String, Set<Int>> {
    val index = mutableMapOf<String, MutableSet<Int>>()

    fileList.forEach { entry ->
        val docId = entry.key
        val file = entry.value
        val tokens = tokenize(readfile(file))

        for (word in tokens) {
            index.getOrPut(word) { mutableSetOf() }.add(docId)
        }
    }

    return index
}