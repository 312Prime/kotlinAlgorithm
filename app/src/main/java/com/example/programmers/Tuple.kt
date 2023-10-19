package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(s: String): IntArray {
        var answer = intArrayOf()
        s.removeSurrounding("{{", "}}").split("},{")
            .map {
                it.removeSurrounding("{", "}").split(",").map { it.toInt() }.toIntArray()
            }.toTypedArray().sortedBy { it.size }.forEach {
                answer += it.filter { !answer.contains(it) }
            }
        return answer
    }

    solution(
        lines[0],
    ).also { print(it) }
    println()
}