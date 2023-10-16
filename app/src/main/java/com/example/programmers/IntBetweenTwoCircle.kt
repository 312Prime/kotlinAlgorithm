package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(r1: Int, r2: Int): Long {
        var answer: Long = 0
        for (i in 1..r2) {
            val r1Ceil = Math.ceil(Math.sqrt(r1 * r1.toDouble() - i * i.toDouble())).toInt()
            val r2Floor = Math.floor(Math.sqrt(r2 * r2.toDouble() - i * i.toDouble())).toInt()
            answer += (r2Floor - r1Ceil + 1).toLong()
        }
        return answer * 4
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
    ).also { print(it) }
    println()
}