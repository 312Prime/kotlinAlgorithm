package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(num: Int): String = if (num % 2 == 1) "Odd" else "Even"

    solution(
        lines[0].toInt(),
    ).also { print(it) }
    println()
}