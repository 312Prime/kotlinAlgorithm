package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun swapPosition(str: List<String>, target: List<String>): Int {
        var newStr = str.toMutableList()
        var cnt = 0
        for (index in 0..(newStr.size - 2)) {
            if (newStr[index] != target[index]) {
                val a = newStr[index]
                newStr[index] = newStr[index + 1]
                newStr[index + 1] = a
                cnt++
            }
        }
        return if (newStr == target) cnt else 20
    }

    fun sensor(inputs: List<String>) {
        val before = inputs[1].split(" ")
        val after = inputs[2].split(" ")

        val startWith0 = mutableListOf<String>()
        val startWith1 = mutableListOf<String>()
        var currentIdx = "0"

        for (num in after) {
            for (i in 1..num.toInt()) {
                startWith0.add(currentIdx)
                currentIdx = if (currentIdx == "0") "1" else "0"
                startWith1.add(currentIdx)
            }
        }
        print(swapPosition(before, startWith0).coerceAtMost(swapPosition(before, startWith1)))
    }

    // input
//    6 3
//1 0 0 1 0 1
//1 3 2

    sensor(
        lines
    ).also { print(it) }
    println()
}