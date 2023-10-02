package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        val pList = MutableList(n) { true }
        section.forEach {
            pList[it - 1] = false
        }
        for (i in 0 until n) {
            if (!pList[i]) {
                answer++
                for (j in i until i + m) {
                    if (pList.size-1 >= j) pList[j] = true
                }
            }
        }
        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
        lines[2].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}