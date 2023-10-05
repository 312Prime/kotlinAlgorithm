package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        targets.forEach { target ->
            var count = 0
            for (i in target.indices) {
                var min = 100
                keymap.forEach { key -> key.indexOf(target[i]).also { if (it < min && it != -1) min = it } }
                if (min == 100) {
                    count = -1
                    break
                } else count += min + 1
            }
            answer += if (count == -1) -1 else count
        }
        return answer
    }

    solution(
        lines[0].split(", ").toTypedArray(),
        lines[1].split(", ").toTypedArray(),
    ).also { print(it) }
    println()
}