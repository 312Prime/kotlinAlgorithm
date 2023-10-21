package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(brown: Int, yellow: Int): IntArray {
        val yList = mutableListOf(yellow)

        for (i in 1..yellow / 2) if (yellow % i == 0) yList.add(i)
        for (i in yList.indices) if ((yellow / yList[i]) + yList[i] + 2 == brown / 2) {
            return intArrayOf(yList[i] + 2, yellow / yList[i] + 2).sortedDescending().toIntArray()
        }

        return intArrayOf(0, 0)
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
    ).also { print(it) }
    println()
}