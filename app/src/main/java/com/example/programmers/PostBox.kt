package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val mainContainer = ArrayDeque((1..order.size).toList())
        val subContainer = ArrayDeque<Int>()

        for (i in 1..order.size) {
            val index = order[i - 1]

            if (subContainer.lastOrNull() == index) {
                subContainer.removeLast()
                answer++
                continue
            }
            while (true) {
                when (val currentBox = mainContainer.removeFirstOrNull()) {
                    index -> {
                        answer++
                        break
                    }

                    null -> return answer
                    else -> subContainer.add(currentBox)
                }
            }
        }

        return answer
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}