package search_engine

fun tokenize(text: String): List<String> {
    val wordsList = text.split(" ")
    return wordsList
}