package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int): IntArray {
        var answer = intArrayOf()
        val numList = mutableListOf(mutableListOf(1))
        var direction = "L"
        var xy = Pair(0, 0)

        for (i in 2..n) numList.add(List(i) { 0 }.toMutableList())

        for (i in 2..(1..n).sum()) {
            when (direction) {
                "L" -> {
                    xy = Pair(xy.first + 1, xy.second)
                    numList[xy.first][xy.second] = i
                    if (numList.getOrNull(xy.first + 1)?.getOrNull(xy.second) != 0) direction = "R"
                }

                "R" -> {
                    xy = Pair(xy.first, xy.second + 1)
                    numList[xy.first][xy.second] = i
                    if (numList.getOrNull(xy.first)?.getOrNull(xy.second + 1) != 0) direction = "U"
                }

                "U" -> {
                    xy = Pair(xy.first - 1, xy.second - 1)
                    numList[xy.first][xy.second] = i
                    if (numList[xy.first - 1][xy.second - 1] != 0) direction = "L"
                }
            }
        }
        numList.forEach { answer += it }

        return answer
    }

    solution(
        lines[0].toInt()
    ).also { print(it.toMutableList()) }
    println()
}