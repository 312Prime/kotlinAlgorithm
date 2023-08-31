package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cnt1 = 0
        var cnt2 = 0
        goal.forEach {
            if (cards1.getOrNull(cnt1) == it) cnt1++
            else if (cards2.getOrNull(cnt2) == it) cnt2++
            else return "No"
        }
        return "Yes"
    }

    print(
        solution(
            lines[0].removeSurrounding("[", "]").split(", ").toTypedArray(),
            lines[1].removeSurrounding("[", "]").split(", ").toTypedArray(),
            lines[2].removeSurrounding("[", "]").split(", ").toTypedArray()
        )
    )
}