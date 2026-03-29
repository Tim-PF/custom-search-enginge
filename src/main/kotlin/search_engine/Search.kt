package search_engine

fun orSearch(index: Map<String, Set<Int>>, query: List<String>): List<Int> {
    val documents = mutableMapOf<Int, Int>()
    for (word in query) {
        if (index.containsKey(word)) {
            index[word]?.forEach { docId ->
                documents[docId] = documents.getOrDefault(docId, 0) + 1
            }
        }
    }
  return sortOrResults(documents)
}
fun sortOrResults(documents: MutableMap<Int, Int>): List<Int> {
    val sortedDocuments = documents.toList().sortedByDescending { it.second }
    return sortedDocuments.map {it.first}
}
