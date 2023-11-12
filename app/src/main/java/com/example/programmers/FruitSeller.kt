package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer = 0

        score.sortedDescending().chunked(m).forEach {
            if (it.size == m) answer += it.last() * m
        }

        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
        lines[2].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}