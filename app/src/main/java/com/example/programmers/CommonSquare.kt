package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(w: Int, h: Int): Long {
        var greatestCommonDivisor = 0

        for (i in 2..Math.max(w, h))
            if (w % i == 0 && h % i == 0 && greatestCommonDivisor < i) greatestCommonDivisor = i

        return w.toLong() * h - (w + h - greatestCommonDivisor)
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt()
    )
        .also { print(it) }
    println()
}