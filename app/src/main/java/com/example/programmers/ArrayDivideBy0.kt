package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(arr: IntArray, divisor: Int): IntArray {
        val answerList = arr.filter { it % divisor == 0 }
        if (answerList.isEmpty()) return intArrayOf(-1)
        return answerList.sorted().toIntArray()
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
        lines[1].toInt()
    ).also { print(it.toMutableList()) }
    println()
}