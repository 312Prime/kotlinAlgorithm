package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(numbers: IntArray) = 45 - numbers.sum()

    solution(
        lines[0].split(",").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}