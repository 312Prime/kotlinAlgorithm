package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(x: Int, y: Int, n: Int): Int {
        val dpList = IntArray(y + 1) { 1000001 }

        dpList[x] = 0
        for (i in x..y) {
            if (i > n && i - n >= x && dpList[i] > dpList[i - n] + 1) {
                dpList[i] = dpList[i - n] + 1
            }
            if (i % 2 == 0 && i / 2 >= x && dpList[i] > dpList[i / 2] + 1) {
                dpList[i] = dpList[i / 2] + 1
            }
            if (i % 3 == 0 && i / 3 >= x && dpList[i] > dpList[i / 3] + 1) {
                dpList[i] = dpList[i / 3] + 1
            }
        }

        return dpList[y].run { if (this == 1000001) -1 else this }
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
        lines[2].toInt(),
    ).also { print(it) }
    println()
}