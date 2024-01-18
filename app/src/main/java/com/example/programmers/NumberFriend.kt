package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.lang.StringBuilder

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(X: String, Y: String): String {
        val wordBuild = StringBuilder()
        val mapX = X.groupingBy { it.toString() }.eachCount()
        val mapY = Y.groupingBy { it.toString() }.eachCount()

        mapX.keys.forEach { key ->
            val count = Math.min(mapX.getOrElse(key){0}.toInt(), mapY.getOrElse(key){0}.toInt())
            if (count != 0) repeat(count) { wordBuild.append(key) }
        }
        val answer = wordBuild.toList().sortedDescending()
        if (answer.size > 1 && answer.first() == '0') return "0"
        if (answer.isEmpty()) return "-1"

        return answer.joinToString("")
    }

    solution(
        lines[0],
        lines[1],
    ).also { print(it) }
    println()
}