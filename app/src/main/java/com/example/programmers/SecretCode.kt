package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(s: String, skip: String, index: Int): String {
        var answer = ""
        val abt = ('a'..'z').filter { it !in skip }.map { it.toString() }

        s.forEach { answer += abt[(abt.indexOf(it.toString()) + index) % abt.size] }
        return answer
    }

    solution(
        lines[0],
        lines[1],
        lines[2].toInt(),
    ).forEach { print(it) }
    println()
}