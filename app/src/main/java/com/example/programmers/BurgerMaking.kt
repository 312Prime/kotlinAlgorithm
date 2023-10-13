package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val iList = ingredient.toMutableList()
        var count = 0
        while (true) {
            if (iList.size - 3 < count) break
            if (iList[count] == 1 && iList[count + 1] == 2 && iList[count + 2] == 3 && iList[count + 3] == 1) {
                iList.removeAt(count)
                iList.removeAt(count)
                iList.removeAt(count)
                iList.removeAt(count)
                answer++
                count = if (count <= 3) -1 else count - 3
            }
            count++
        }
        return answer
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}