package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(number: Int, limit: Int, power: Int): Int {
        var answer = 0
        for (i in 1..number) {
            var atk = 0
            for (j in 1..i / 2) if (i % j == 0) atk++
            answer += if (atk + 1 > limit) power else atk + 1
        }
        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
        lines[2].toInt(),
    ).also { print(it) }
    println()
}