package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int): Int {
        var answer: Int = 2

        while (n % answer != 1) answer++

        return answer
    }

    solution(
        lines[0].toInt(),
    ).also { print(it) }
    println()
}