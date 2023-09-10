package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(bookTime: Array<Array<String>>): Int {
        val newList = mutableMapOf<Int, Int>()
        for (key in 0..1500) newList[key] = 0

        bookTime.forEach { lane ->
            val startTime =
                lane[0].substring(0, 2).toInt() * 60 + lane[0].substring(3, 5).toInt()
            val endTime =
                lane[1].substring(0, 2).toInt() * 60 + lane[1].substring(3, 5).toInt() + 10

            for (i in startTime until endTime) {
                newList[i] = newList[i]!! + 1
            }
        }
        return newList.maxOf { it.value }
    }

    solution(
        lines[0].removeSurrounding("[[", "]]").split("], [").map { it ->
            it.removeSurrounding("[", "]").split(", ").toTypedArray()
        }.toTypedArray()
    ).also { print(it) }
    println()
}