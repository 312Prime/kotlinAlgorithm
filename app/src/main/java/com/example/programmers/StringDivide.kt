package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(s: String): Int {
        var answer: Int = 0
        var tempChar = s.first()
        var count = 0
        var countOther = 0

        for (i in s.indices) {
            if (count == 0) {
                tempChar = s[i]
                count++
            } else {
                if (tempChar == s[i]) count++
                else countOther++
            }
            if (count == countOther) {
                count = 0
                countOther = 0
                answer++
            } else if (i == s.length - 1) answer++
        }

        return answer
    }

    solution(
        lines[0],
    ).also { print(it) }
    println()
}