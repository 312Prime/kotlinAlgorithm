package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int): Int {
        val numbers = mutableListOf(0, 1)

        (1..n).forEach { index ->
            numbers.add((numbers[index - 1] % 1234567 + numbers[index] % 1234567) % 1234567)
        }

        return numbers[n]
    }

    solution(
        lines[0].toInt(),
    ).also { print(it) }
    println()
}