package search_engine

import java.io.File

fun readfile(file: File) : String {
    return file.readText()
}

fun listOfFiles() {
    val files = File("data").listFiles() ?: return
    val fileList = mapFiles(files)
    fileList.forEach {
        println(it.value.name)
        val tokenList = tokenize(readfile(it.value))
    }
}