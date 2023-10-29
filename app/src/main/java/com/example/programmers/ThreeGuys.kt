package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(number: IntArray): Int {
        var answer: Int = 0
        for (i in number.indices) for (j in i + 1 until number.size) for (k in j + 1 until number.size) {
            if (number[i] + number[j] + number[k] == 0) {
                answer++
            }
        }

        return answer
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}