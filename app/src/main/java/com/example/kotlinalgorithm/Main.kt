package com.example.kotlinalgorithm

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(inputs: Array<String>) {
    }

    solution(
        lines[0].split(", ").toTypedArray()
    ).also { print(it) }
    println()
}