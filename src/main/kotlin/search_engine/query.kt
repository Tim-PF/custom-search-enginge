package search_engine

fun queryUserInput() : List<String> {
    val unfilteredquery = readln()
    val filteredQuery = tokenizedQuery(unfilteredquery)
    return filteredQuery
}

fun askQuery() : List<String> {
    println("Enter your query: ")
    return queryUserInput()
}
fun tokenizedQuery(query: String) : List<String> {
    return query.lowercase().split(Regex("[^a-zA-Z0-9]+")).filter{prompt -> prompt.isNotEmpty()}
}