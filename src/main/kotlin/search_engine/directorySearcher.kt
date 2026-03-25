package search_engine

import java.io.File

fun readfile(file: File) : String {
    return file.readText()
}

fun listOfFiles() : Array<File>? {
    return File("data").listFiles()
 /*   val fileList = mapFiles(files)
    val index = mutableMapOf<String, Set<Int>>()
    fileList.forEach {
        val tokenList = tokenize(readfile(it.value))
        for (word in tokenList) {
            if (index.containsKey(word)) {
                index[word] = index[word]!!.plus(it.key)
            } else {
                index[word] = setOf(it.key)
            }
        }
   } */
}