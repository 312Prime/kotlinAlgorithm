package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(x: Int, n: Int): LongArray {
        var answer = longArrayOf()

        for (i in 1 .. n) answer += i * x.toLong()

        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
    ).also { print(it.toMutableList()) }
    println()
}