package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var coke = n

        while (coke >= a) {
            val count = coke / a
            coke %= a
            coke += count * b
            answer += count * b
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