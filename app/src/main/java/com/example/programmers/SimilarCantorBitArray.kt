package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int, l: Long, r: Long): Int {
        var answer = 0

        fun checkNumber(number: Long): Boolean {
            if (number < 5 && number != 2L) return true
            if ((number - 2) % 5 == 0L) return false
            return checkNumber(number / 5)
        }

        for (i in l - 1 until r) {
            if (checkNumber(i)) answer++
        }
        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].toLong(),
        lines[2].toLong(),
    ).also { print(it) }
    println()
}