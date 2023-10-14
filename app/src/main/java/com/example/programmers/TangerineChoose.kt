package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(k: Int, tangerine: IntArray): Int {
        var answer = 0
        var count = k
        val tMap = mutableMapOf<Int, Int>()
        tangerine.sorted().forEach {
            tMap[it] = if (tMap[it] == null) 1 else (tMap[it]!! + 1)
        }
        tMap.toList().sortedByDescending { it.second }.forEach {
            count -= it.second
            answer++
            if (count <= 0) return answer
        }
        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}