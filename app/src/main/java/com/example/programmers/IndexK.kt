package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(array: IntArray, commands: Array<IntArray>) =
        commands.map { array.toList().subList(it[0] - 1, it[1]).sorted()[it[2] - 1] }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
        lines[1].split("], [").map { it.split(", ").map { it.toInt() }.toIntArray() }
            .toTypedArray(),
    ).also { print(it.toMutableList()) }
    println()
}