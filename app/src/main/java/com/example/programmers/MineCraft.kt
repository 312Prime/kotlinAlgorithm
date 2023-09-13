package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        val mList = mutableListOf<List<Int>>()
        for (i in 1..picks[0] + picks[1] + picks[2]) {
            minerals.slice((i * 5) - 5 until if (minerals.size < i * 5) minerals.size else i * 5)
                .map {
                    when (it) {
                        "diamond" -> 25
                        "iron" -> 5
                        else -> 1
                    }
                }.also { if (it.isNotEmpty()) mList.add(it) }
        }
        mList.sortBy { it.sum() }
        for (i in picks.indices) {
            for (j in 0 until picks[i]) {
                when (i) {
                    0 -> answer += (mList.removeLast().map { 1 }).sum()
                    1 -> answer += (mList.removeLast().map { if (it == 25) 5 else 1 }).sum()
                    2 -> answer += (mList.removeLast()).sum()
                }
                if (mList.isEmpty()) break
            }
            if (mList.isEmpty()) break
        }
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray(),
        lines[1].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}