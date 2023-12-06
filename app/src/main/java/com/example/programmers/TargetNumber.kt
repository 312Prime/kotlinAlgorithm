package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(numbers: IntArray, target: Int): Int {
        val targetNumbers = mutableListOf(0)

        for (i in numbers.indices) {
            val temp = mutableListOf<Int>()
            targetNumbers.forEach {
                temp.add(it + numbers[i])
                temp.add(it - numbers[i])
            }
            targetNumbers.clear()
            targetNumbers.addAll(temp)
        }

        return targetNumbers.count { it == target }
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
        lines[1].toInt(),
    ).also { print(it) }
    println()
}