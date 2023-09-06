package com.example.kotlinalgorithm

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(logs: Array<String>): Int {
        var answer: Int = logs.size
        val logNames = listOf("team_name : ", "application_name : ", "error_level : ", "message : ")
        val nonAlphabeticalPattern = "[^a-zA-Z]".toRegex()

        Back@ for (i in logs.indices) {
            if (logs[i].length > 100) continue@Back
            if (nonAlphabeticalPattern.containsMatchIn(logs[i].first().toString())) continue@Back

            for (j in logNames.indices) {
                if (logs[i].indexOf(logNames[j]) == -1) continue@Back
                if (j != logNames.size - 1 && logs[i].indexOf(logNames[j + 1]) == -1) continue@Back
                val ids = logs[i].substring(
                    logs[i].indexOf(logNames[j]) + logNames[j].length,
                    if (j == logNames.size - 1) logs[i].length
                    else (logs[i].indexOf(logNames[j + 1]) - 1)
                )
                if (nonAlphabeticalPattern.containsMatchIn(ids)) continue@Back
            }
            answer--
        }
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}