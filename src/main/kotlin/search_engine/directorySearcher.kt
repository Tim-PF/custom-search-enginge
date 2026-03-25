package search_engine

import java.io.File

fun readfile(file: File) : String {
    return file.readText()
}

fun listOfFiles() : Array<File>? {
    return File("data").listFiles()
}