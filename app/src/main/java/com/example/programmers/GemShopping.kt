package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(gems: Array<String>): IntArray {
        val answer = intArrayOf(0, 100000)
        val itemSet = gems.toSet()
        val itemMap = mutableMapOf<String, Int>()
        var left = 0

        for (right in gems.indices) {
            val gem = gems[right]
            itemMap[gem] = right + 1

            while (itemMap.size == itemSet.size) {
                val minValue = itemMap[gems[left]]!!

                if (answer[1] - answer[0] > right - left) {
                    answer[0] = left + 1
                    answer[1] = right + 1
                }
                if (minValue == left + 1) itemMap.remove(gems[left])
                left++
            }
        }

        return answer
    }

    solution(
        lines[0].split(", ").map { it.trim('"') }.toTypedArray(),
    ).also { print(it.toMutableList()) }
    println()
}