package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf(50, 50, 0, 0)
        for (i in wallpaper.indices) for (j in 0 until wallpaper[0].length) {
            if (wallpaper[i][j] == '#') {
                if (i < answer[0]) answer[0] = i
                if (j < answer[1]) answer[1] = j
                if (i > answer[2]) answer[2] = i
                if (j > answer[3]) answer[3] = j
            }
        }
        answer[2] += 1
        answer[3] += 1
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}