package com.example.kotlinalgorithm

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(players: Array<String>, callings: Array<String>): Array<String> {

        return players
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray(),
        lines[1].removeSurrounding("[", "]").split(", ").toTypedArray(),
    ).forEach { print(it) }
    println()
}