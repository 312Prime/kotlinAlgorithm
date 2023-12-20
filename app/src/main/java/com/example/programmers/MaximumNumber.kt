package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(numbers: IntArray): String {
        val numberList = numbers.sortedWith { first, second ->
            "$second$first".compareTo("$first$second")
        }

        if (numberList.first() == 0) return "0"

        return numberList.map { it }.joinToString("")
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}