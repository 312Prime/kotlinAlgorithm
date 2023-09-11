package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(sequence: IntArray, k: Int): IntArray {
        val answer = intArrayOf(0, 10000000)
        var left = 0
        var sum = 0

        for (right in sequence.indices) {
            sum += sequence[right]
            while (sum > k) {
                sum -= sequence[left]
                left++
            }
            if (sum == k && right - left < answer[1] - answer[0]) {
                answer[0] = left
                answer[1] = right
            }
        }
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray(),
        lines[1].toInt()
    ).also { print(it) }
    println()
}