package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = n
        val isInNetwork = computers.map { false }.toMutableList()
        val tempList = mutableListOf<Int>()

        fun findNetwork(x: Int) {
            for (j in computers.indices) {
                if (isInNetwork[j]) continue
                if (computers[x][j] == 1 && computers[j][x] == 1) {
                    isInNetwork[j] = true
                    tempList.add(j)
                    answer--
                }
            }
        }

        for (i in computers.indices) {
            if (isInNetwork[i]) continue
            isInNetwork[i] = true
            findNetwork(i)
            while (tempList.isNotEmpty()) {
                findNetwork(tempList.removeFirst())
            }
        }

        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].split("], [").map { it.split(", ").map { it.toInt() }.toIntArray() }.toTypedArray()
    ).also { print(it) }
    println()
}