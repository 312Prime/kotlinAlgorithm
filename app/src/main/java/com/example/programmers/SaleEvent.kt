package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = mutableMapOf<String, Int>().toMutableMap()

        for (i in want.indices) wantMap[want[i]] = -number[i]
        for (i in discount.indices) {
            wantMap[discount[i]] = wantMap.getOrElse(discount[i]) { 0 } + 1
            if (i >= 10) wantMap[discount[i - 10]] = wantMap[discount[i - 10]]!! - 1
            if (wantMap.count { it.value < 0 } <= 0) answer++
        }

        return answer
    }

    solution(
        lines[0].split(", ").map { it.trim('"') }.toTypedArray(),
        lines[1].split(", ").map { it.toInt() }.toIntArray(),
        lines[2].split(", ").map { it.trim('"') }.toTypedArray()
    ).also { print(it) }
    println()
}