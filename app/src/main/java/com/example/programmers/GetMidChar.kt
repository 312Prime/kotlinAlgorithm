package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(s: String): String =
        if (s.length % 2 == 0) s.substring(s.length / 2 - 1, s.length / 2 + 1)
        else s[s.length / 2].toString()

    solution(
        lines[0],
    ).also { print(it) }
    println()
}