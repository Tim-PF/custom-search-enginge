package search_engine

fun tokenize(text: String): List<String> {
    val wordsList = text.lowercase().split(Regex("[^a-zA-Z0-9]+")).filter { it.isNotEmpty() }
    return wordsList
}