package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(a: IntArray): Int {
        val minIndex = a.indexOf(a.minOf { it })
        val leftList = a.slice(0 until minIndex)
        val rightList = a.slice(minIndex + 1 until a.size).reversed()

        fun boom(list: List<Int>): Int {
            var max = 1000000000
            var count = 0
            for (i in list.indices) {
                if (max > list[i]) {
                    max = list[i]
                    count++
                }
            }
            return count
        }
        return boom(leftList) + boom(rightList) + 1
    }

    solution(
        lines[0].split(",").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}