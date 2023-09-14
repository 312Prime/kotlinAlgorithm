package com.example.kotlinalgorithm

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val cMap = mutableMapOf<Int, Int>()

        for (i in 1..n) cMap[i] = -1
        cMap[destination] = 0
        roads.filter { it.first() == destination || it.last() == destination }.forEach {
            if (it.first() == destination) cMap[it.last()] = 1
            if (it.last() == destination) cMap[it.first()] = 1
        }
        cMap.toList().sortedBy { it.second }.forEach {
            it.first
        }

        println(roads.sortedBy { it.first() })

        return answer
    }

    solution(
        lines[0].toInt(),
        lines[1].removeSurrounding("[[", "]]").split("], [").map { itt ->
            itt.removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray()
        }.toTypedArray(),
        lines[2].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray(),
        lines[3].toInt(),
    ).also { print(it) }
    println()
}