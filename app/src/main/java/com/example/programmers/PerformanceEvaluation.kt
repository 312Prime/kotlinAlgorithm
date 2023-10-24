package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(scores: Array<IntArray>): Int {
        var answer = 1
        var minY = 0
        val me = listOf(scores[0][0], scores[0][1])
        val sList = scores.sortedBy { it.last() }.sortedByDescending { it.first() }

        for (i in sList.indices) {
            if (minY < sList[i].last()) {
                minY = sList[i].last()
            } else if (minY > sList[i].last()) {
                if (sList[i].toList() == me) {
                    return -1
                }
                continue
            }
            if (sList[i].first() + sList[i].last() > me.first() + me.last()) {
                answer++
            }
        }

        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split("],[")
            .map { it.split(",").map { it.toInt() }.toIntArray() }.toTypedArray(),
    ).also { print(it) }
    println()
}