package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun main(args: Array<String>) {
        val (a, b) = readLine()!!.split(' ').map(String::toInt)
        println("a = $a")
        println("b = $b")
    }

    main(
        lines[0].split(" ").toTypedArray(),
    ).also { print(it) }
    println()
}