package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(number: String, k: Int): String {
        val current = StringBuilder(number)

        while (current.length != number.length - k) {
            for (i in 0 until current.length - 1) {
                if (current[i].code < current[i + 1].code) {
                    current.deleteAt(i)
                    break
                }
                if (i == current.length - 2) current.deleteAt(current.length - 1)
            }
        }

        return current.toString()
    }

    solution(
        lines[0],
        lines[1].toInt(),
    ).also { print(it) }
    println()
}