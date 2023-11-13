package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0

        babbling.forEach {
            var babble = it
            var current = ""
            while (true) {
                var isRemove = false
                if (babble.startsWith("ye") && current != "ye") {
                    babble = babble.substring(2)
                    isRemove = true
                    current = "ye"
                }
                if (babble.startsWith("ma") && current != "ma") {
                    babble = babble.substring(2)
                    isRemove = true
                    current = "ma"
                }
                if (babble.startsWith("woo") && current != "woo") {
                    babble = babble.substring(3)
                    isRemove = true
                    current = "woo"
                }
                if (babble.startsWith("aya") && current != "aya") {
                    babble = babble.substring(3)
                    isRemove = true
                    current = "aya"
                }
                if (babble.isEmpty()) {
                    answer++
                    break
                }
                if (!isRemove) break
            }
        }

        return answer
    }

    solution(
        lines[0].split(", ").toTypedArray()
    ).also { print(it) }
    println()
}