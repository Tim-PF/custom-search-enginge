package search_engine

import java.io.File

fun readfile() {
    val file =
        File( "src/main/kotlin/search_engine/test.txt")
    println(file.readText())
}