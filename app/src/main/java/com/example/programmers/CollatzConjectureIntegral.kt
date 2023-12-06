package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        var answer: DoubleArray = doubleArrayOf()
        val rangeList = mutableListOf(k)
        var currentNumber = k

        while (currentNumber != 1) {
            when (currentNumber % 2) {
                0 -> currentNumber /= 2
                1 -> currentNumber = currentNumber * 3 + 1
            }
            rangeList.add(currentNumber)
        }

        ranges.forEach { range ->
            var area = 0.0
            if (range.first() >= rangeList.size + range.last()) {
                answer += -1.0
                return@forEach
            }
            for (i in range.first() until rangeList.size + range.last() - 1) {
                area += ((rangeList[i] + rangeList[i + 1]) / 2.0)
            }
            answer += area
        }

        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].split("],[").map { it.split(",").map { it.toInt() }.toIntArray() }.toTypedArray(),
    ).also { print(it.toMutableList()) }
    println()
}