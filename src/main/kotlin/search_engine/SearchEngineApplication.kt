package search_engine

fun main() {
    val files = listOfFiles()?: return
    val fileMap = mapFiles(files)
    val index = buildIndex(fileMap)
    val query = askQuery()
    println(fileMap)
    println(query)
    println(index)
    val orResults = orSearch(index, query)
    val andResults = andSearch(index, query)
    printResults(fileMap, orResults)
    printResults(fileMap, andResults)


}