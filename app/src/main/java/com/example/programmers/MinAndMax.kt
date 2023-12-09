package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(s: String): String {
        val sList = s.split(" ").map { it.toInt() }

        return "${sList.minOf { it }} ${sList.maxOf { it }}"
    }

    solution(
        lines[0],
    ).also { print(it) }
    println()
}