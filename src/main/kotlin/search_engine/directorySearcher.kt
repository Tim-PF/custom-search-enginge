package search_engine

import java.io.File

fun readfile(file: File) {
    println(file.readText())
}

fun listOfFiles() {
    val files = File("data").listFiles()
    files?.forEach {
        println(it.name)
        readfile(it)
    }
}