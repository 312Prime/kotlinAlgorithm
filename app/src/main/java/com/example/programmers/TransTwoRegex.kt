package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf(0, 0)
        var current = s

        while (true) {
            if (current == "1") break
            val trimCurrent = current.toMutableList().filter { it != '0' }
            answer[0] += 1
            answer[1] += current.length - trimCurrent.size
            current = (trimCurrent.size).toString(2)
        }

        return answer
    }

    solution(
        lines[0],
    ).also { print(it.toMutableList()) }
    println()
}