package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val playerMap =
            players.withIndex().associate { (index, player) -> player to index }.toMutableMap()

        callings.forEach { calling ->
            val tempIndex = playerMap[calling]
            val tempName = players[tempIndex!!]
            players[tempIndex] = players[tempIndex - 1]
            players[tempIndex - 1] = tempName
            playerMap[calling] = tempIndex - 1
            playerMap[players[tempIndex]] = tempIndex
        }
        return players
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray(),
        lines[1].removeSurrounding("[", "]").split(", ").toTypedArray(),
    ).forEach { print(it) }
    println()
}