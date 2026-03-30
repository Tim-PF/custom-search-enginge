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

fun andSearch(index: Map<String, Set<Int>>, query: List<String>): List<Int> {
    if (query.isEmpty()) return emptyList()

    val result = index[query[0]]?.toMutableSet() ?: return emptyList()

    for (token in query.drop(1)) {
        val docs = index[token]?.toMutableSet() ?: return emptyList()
        result.retainAll(docs)
    }

    return result.toList()
}
