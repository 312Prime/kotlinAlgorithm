package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int): Long {
        val answerList = mutableListOf(1L)
        var temp = 1L
        val REMAIN = 1234567

        for (i in 0..n) {
            answerList.add((answerList[i] % REMAIN + temp % REMAIN) % REMAIN)
            temp = answerList[i]
        }

        return answerList[answerList.size - 3]
    }

    solution(
        lines[0].toInt(),
    ).also { print(it) }
    println()
}