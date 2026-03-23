package search_engine

import java.io.File

fun readfile(file: File) : String {
    return file.readText()
}

fun listOfFiles() {
    val files = File("data").listFiles() ?: return
    val fileList = mapFiles(files)
    println(fileList)
    files.forEach {
        if (it.isDirectory) return@forEach
        if (!(it.name.contains(".txt"))) return@forEach
        println(it.name)
        val tokenList = tokenize(readfile(it))
    }
}