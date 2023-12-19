package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(seoul: Array<String>) = "김서방은 ${seoul.indexOf("Kim")}에 있다"

    solution(
        lines[0].split(", ").toTypedArray(),
    ).also { print(it) }
    println()
}