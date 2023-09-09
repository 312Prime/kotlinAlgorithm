package com.example.kotlinalgorithm

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        return answer
    }

    solution(
        lines[0].removeSurrounding("[[", "]]").split("], [").map { it ->
            it.removeSurrounding("[", "]").split(", ").toTypedArray()
        }.toTypedArray()
    ).also { print(it) }
    println()
}