package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer = ""
        val characterList = mutableListOf(0, 0, 0, 0)
        val characters = listOf(Pair('R', 'T'), Pair('C', 'F'), Pair('J', 'M'), Pair('A', 'N'))
        for (i in survey.indices) {
            when (survey[i][0]) {
                'R' -> characterList[0] += choices[i] - 4
                'T' -> characterList[0] += -(choices[i] - 4)
                'C' -> characterList[1] += choices[i] - 4
                'F' -> characterList[1] += -(choices[i] - 4)
                'J' -> characterList[2] += choices[i] - 4
                'M' -> characterList[2] += -(choices[i] - 4)
                'A' -> characterList[3] += choices[i] - 4
                'N' -> characterList[3] += -(choices[i] - 4)
            }
        }
        characterList.forEachIndexed { index, i ->
            answer += if (i > 0) characters[index].second else characters[index].first
        }

        return answer
    }

    solution(
        lines[0].split(", ").map { it.trim('"') }.toTypedArray(),
        lines[1].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}