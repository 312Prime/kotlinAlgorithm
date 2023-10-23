package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(sequence: IntArray): Long {
        var answer = 0L

        val upperArray = sequence.map { 0L }.toLongArray()
        val downArray = sequence.map { 0L }.toLongArray()
        var isFlip = 1
        for (i in sequence.indices) {
            upperArray[i] = sequence[i] * isFlip.toLong()
            isFlip *= -1
            downArray[i] = sequence[i] * isFlip.toLong()
        }

        var count1 = 0L
        var count2 = 0L

        for (i in sequence.indices) {
            count1 += upperArray[i]
            count2 += downArray[i]

            if (count1 < 0) count1 = 0
            if (count2 < 0) count2 = 0

            answer = Math.max(answer, Math.max(count1, count2))
        }

        return answer
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}