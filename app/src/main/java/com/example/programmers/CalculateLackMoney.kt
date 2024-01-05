package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(price: Int, money: Int, count: Int): Long {
        var answer = money.toLong()
        for (i in 1..count) answer -= price * i
        return answer.let { if (it >= 0) 0 else -it }
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
        lines[2].toInt(),
    ).also { print(it) }
    println()
}