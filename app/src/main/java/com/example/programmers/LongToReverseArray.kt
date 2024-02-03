package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Long): IntArray =
        n.toString().map { it.toString().toInt() }.reversed().toIntArray()

    solution(
        lines[0].toLong(),
    ).also { print(it.toMutableList()) }
    println()
}