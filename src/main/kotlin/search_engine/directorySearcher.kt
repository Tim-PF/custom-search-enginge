package search_engine

import java.io.File

fun readfile(file: File) : String {
    return file.readText()
}

fun listOfFiles() {
    val files = File("data").listFiles() ?: return
    val fileList = mapFiles(files)
    val index = mutableMapOf<String,List<Int>>()
    fileList.forEach {
        println(it.value.name)
        val tokenList = tokenize(readfile(it.value))
        for (word in tokenList) {
            if (index.containsKey(word)) {
                index[word] = index[word]!!.plus(it.key)
            } else {
                index[word] = listOf(it.key)
            }
        }
    }
    println(index);
}