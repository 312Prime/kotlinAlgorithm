package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(record: Array<String>): Array<String> {
        var answer = arrayOf<String>()
        val idMap = mutableMapOf<String, String>()
        val recordList = mutableListOf<List<String>>()

        record.forEach {
            val message = it.split(" ")
            when (message[0]) {
                "Enter" -> {
                    idMap[message[1]] = message[2]
                    recordList.add(listOf(message[1], "Enter"))
                }

                "Leave" -> {
                    recordList.add(listOf(message[1], "Leave"))
                }

                "Change" -> {
                    idMap[message[1]] = message[2]
                }
            }
        }

        recordList.forEach {
            when (it[1]) {
                "Enter" -> answer += "${idMap[it[0]]}님이 들어왔습니다."
                "Leave" -> answer += "${idMap[it[0]]}님이 나갔습니다."
            }
        }

        return answer
    }

    solution(lines[0].split(", ").map { it.trim('"') }.toTypedArray())
        .also { print(it.toMutableList()) }
    println()
}