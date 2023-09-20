package com.example.kotlinalgorithm

import java.util.*
import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    fun solution(maps: Array<String>): IntArray {
        var answer = intArrayOf()
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}