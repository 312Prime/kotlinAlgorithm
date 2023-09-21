package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(storey: Int): Int {
        var answer = 0
        var cNumber = storey
        while (cNumber != 0) {
            if (cNumber % 10 == 0) cNumber /= 10
            if (cNumber % 10 < 5) {
                answer += cNumber % 10
                cNumber -= cNumber % 10
            } else if (cNumber % 10 == 5 && cNumber % 100 <= 50) {
                answer += cNumber % 10
                cNumber -= cNumber % 10
            } else {
                answer += (10 - (cNumber % 10))
                cNumber += (10 - (cNumber % 10))
            }
        }
        return answer
    }

    solution(
        lines[0].toInt()
    ).also { print(it) }
    println()
}