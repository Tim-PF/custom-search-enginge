package search_engine

import java.io.File

fun printResults(fileMap: Map<Int, File>, results: List<Int>) {
    results.forEach {
        fileMap[it]?.let { file -> println(file.name) }
    }
}