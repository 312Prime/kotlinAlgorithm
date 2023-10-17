package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val nData = data.sortedByDescending { it[0] }.sortedBy { it[col - 1] }
        val answerList = mutableListOf<Int>()
        for (i in row_begin..row_end) {
            var count = 0
            nData[i - 1].forEach { count += it % i }
            answerList.add(count)
        }
        return answerList.reduce { x, y -> x xor y }
    }

    solution(
        lines[0].split(", ")
            .map { it.removeSurrounding("[", "]").split(",").map { it.toInt() }.toIntArray() }
            .toTypedArray(),
        lines[1].toInt(),
        lines[2].toInt(),
        lines[3].toInt(),
    ).also { print(it) }
    println()
}