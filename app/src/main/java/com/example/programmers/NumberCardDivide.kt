package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun calculate(arrayA: IntArray, arrayB: IntArray): Int {
        val sortedArrayA = arrayA.sorted()
        val answerAList = mutableListOf<Int>()

        for (i in 2..sortedArrayA[0] / 2 + 1) {
            if (sortedArrayA[0] % i == 0) answerAList.add(i)
        }
        answerAList.add(sortedArrayA[0])

        sortedArrayA.forEach { indexA ->
            val removeIndex = mutableListOf<Int>()
            answerAList.forEachIndexed { index, answerA ->
                if (indexA % answerA != 0) removeIndex.add(index)
            }
            removeIndex.reversed().forEach {
                answerAList.removeAt(it)
            }
        }

        arrayB.sorted().forEach { indexB ->
            val removeIndex = mutableListOf<Int>()
            answerAList.forEachIndexed { index, answerA ->
                if (indexB % answerA == 0) removeIndex.add(index)
            }
            removeIndex.reversed().forEach {
                answerAList.removeAt(it)
            }
        }

        return if (answerAList.isEmpty()) 0 else answerAList.maxOf { it }
    }

    fun solution(arrayA: IntArray, arrayB: IntArray): Int {

        return Math.max(calculate(arrayA, arrayB), calculate(arrayB, arrayA))
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
        lines[1].split(", ").map { it.toInt() }.toIntArray()
    )
        .also { print(it) }
    println()
}