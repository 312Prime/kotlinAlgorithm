package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        val weightList = weights.sorted().toIntArray()

        for (i in weightList.indices) for (j in i + 1 until weightList.size) {
            if (weightList[i] == weightList[j]) {
                answer++
                continue
            }
            if (weightList[i] * 2 == weightList[j]) {
                answer++
                continue
            }
            if (weightList[i] * 3 == weightList[j] * 2) {
                answer++
                continue
            }
            if (weightList[i] * 4 == weightList[j] * 3) {
                answer++
                continue
            }
        }
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray()
    ).also { print(it) }
    println()
}