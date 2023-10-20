package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        for (i in 0..d / k + 1) answer += (Math.sqrt(d.toLong() * d * 1.0 - i * k.toLong() * i * k * 1.0) / k + 1).toLong()

        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
    ).also { print(it) }
    println()
}