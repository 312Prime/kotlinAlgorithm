package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(numbers: LongArray): LongArray {
        var answer: LongArray = longArrayOf()

        numbers.forEach { number ->
            val startNumber = number.toString(2).reversed()
            if (startNumber[0] != '0') {
                var fixIndex = 0

                for ((count, i) in startNumber.indices.withIndex()) {
                    if (startNumber[i] == '0') {
                        fixIndex = count
                        break
                    }
                }
                answer += if (fixIndex == 0) ("10" + "1".repeat(startNumber.length - 1)).toLong(2)
                else {
                    (startNumber.substring(0, fixIndex - 1)
                            + "01" + startNumber.substring(fixIndex + 1)).reversed().toLong(2)
                }
            } else {
                answer += ("1" + startNumber.substring(1)).reversed().toLong(2)
            }
        }

        return answer
    }

    solution(
        lines[0].split(",").map { it.toLong() }.toLongArray(),
    ).also { print(it.toMutableList()) }
    println()
}