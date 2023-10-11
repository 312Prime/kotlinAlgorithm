package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val sList = mutableListOf<Int>()
        score.forEach {
            if (sList.size < k) sList.add(it)
            else if (sList.last() < it) sList[k - 1] = it
            sList.sortDescending()
            answer += sList.last()
        }
        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}