package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(phone_number: String): String {
        var answer = ""
        for (i in phone_number.indices) {
            if (phone_number.length - 4 <= i) answer += phone_number[i]
            else answer += "*"
        }

        return answer
    }

    solution(
        lines[0]
    ).also { print(it.toMutableList()) }
    println()
}