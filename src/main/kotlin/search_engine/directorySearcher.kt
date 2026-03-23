package search_engine

import java.io.File

fun readfile(file: File) {
    println(file.readText())
}

fun listOfFiles() {
    val files = File("data").listFiles()
    files?.forEach {
        if (it.isDirectory) return@forEach
        if (!(it.name.contains(".txt"))) return@forEach
        println(it.name)
        readfile(it)
    }
}