package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var x = a
        var y = b

        while ((x - 0.5 / 2).toInt() != (y - 0.5 / 2).toInt()) {
            answer++
            if (x % 2 == 1) x += 1
            if (y % 2 == 1) y += 1
            x /= 2
            y /= 2
        }

        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
        lines[2].toInt(),
    ).also { print(it) }
    println()
}