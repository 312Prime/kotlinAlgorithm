package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(targets: Array<IntArray>): Int {
        var end = 0
        var answer = 0

        targets.sortWith(compareBy { it.last() })

        for (i in targets.indices) {
            val startCurrent = targets[i].first()
            val endCurrent = targets[i].last()

            if (startCurrent < end) continue
            else {
                end = endCurrent
                answer++
            }
        }

        return answer
    }

    solution(
        lines[0].split("],[").map { it.split(",").map { it.toInt() }.toIntArray() }.toTypedArray(),
    ).also { print(it) }
    println()
}