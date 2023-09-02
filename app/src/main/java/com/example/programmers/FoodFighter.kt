package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(food: IntArray): String {
        var answer = ""
        food.forEachIndexed { index, i ->
            if (index != 0) answer += index.toString().repeat(i / 2)
        }
        return answer + "0" + answer.reversed()
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray(),
    ).forEach { print(it) }
    println()
}