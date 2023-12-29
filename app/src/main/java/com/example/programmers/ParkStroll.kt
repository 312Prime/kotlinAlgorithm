package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val startX = park.indexOf(park.find { it.contains('S') })
        var currentXY = Pair(startX, park[startX].indexOf('S'))

        fun moveNews(count: Int, news: Char) {
            val temp = currentXY
            var isSuccess = false

            for (i in 1..count) {
                when (news) {
                    'N' -> {
                        if (currentXY.first == 0) continue
                        if (park[currentXY.first - 1][currentXY.second] == 'X') continue
                        currentXY = Pair(currentXY.first - 1, currentXY.second)
                    }

                    'E' -> {
                        if (currentXY.second == park[0].length - 1) continue
                        if (park[currentXY.first][currentXY.second + 1] == 'X') continue
                        currentXY = Pair(currentXY.first, currentXY.second + 1)
                    }

                    'W' -> {
                        if (currentXY.second == 0) continue
                        if (park[currentXY.first][currentXY.second - 1] == 'X') continue
                        currentXY = Pair(currentXY.first, currentXY.second - 1)
                    }

                    'S' -> {
                        if (currentXY.first == park.size - 1) continue
                        if (park[currentXY.first + 1][currentXY.second] == 'X') continue
                        currentXY = Pair(currentXY.first + 1, currentXY.second)
                    }
                }
                if (i == count) isSuccess = true
            }
            if (!isSuccess) currentXY = temp
        }

        routes.forEach { route ->
            moveNews(route.last().toString().toInt(), route.first())
        }

        return intArrayOf(currentXY.first, currentXY.second)
    }

    solution(
        lines[0].split(",").map { it.trim('"') }.toTypedArray(),
        lines[1].split(",").map { it.trim('"') }.toTypedArray(),
    ).also { print(it.toMutableList()) }
    println()
}