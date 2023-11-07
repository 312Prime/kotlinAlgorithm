package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var count = 0
        for (i in progresses.indices) {
            val remain = 100 - progresses[i]
            (remain / speeds[i]).plus(if (remain % speeds[i] != 0) 1 else 0).also {
                if (it > count) {
                    count = it
                    answer.add(1)
                } else {
                    answer[answer.size - 1] += 1
                }
            }
        }

        return answer.toIntArray()
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
        lines[1].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it.toMutableList()) }
    println()
}