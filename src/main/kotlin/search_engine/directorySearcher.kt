package search_engine

import java.io.File

fun readfile(file: File) : String {
    return file.readText()
}

fun listOfFiles() {
    val files = File("data").listFiles()
    files?.forEach {
        if (it.isDirectory) return@forEach
        if (!(it.name.contains(".txt"))) return@forEach
        println(it.name)
        tokenize(readfile(it))
    }
}