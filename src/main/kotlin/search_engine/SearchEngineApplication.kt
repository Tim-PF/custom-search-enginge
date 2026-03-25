package search_engine

fun main() {
    val files = listOfFiles()?: return
    val fileMap = mapFiles(files)
    val index = buildIndex(fileMap)
    println(index)
}