package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(arr: IntArray): Int {
        val commons = mutableListOf<Int>()

        arr.forEach {
            var current = it
            val tempList = mutableListOf<Int>()
            B@ while (current != 1) {
                for (i in 2..it) if (current % i == 0) {
                    tempList.add(i)
                    current /= i
                    continue@B
                }
            }
            commons.forEach { tempList.remove(it) }
            commons.addAll(tempList)
        }
        return commons.reduce { total, number -> total * number }
    }

    solution(
        lines[0].split(",").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}