package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(priorities: IntArray, location: Int): Int {
        val work = List(priorities.size) { if (it == location) 1000 else it + 1 }
        val workPriorities = work.zip(priorities.toTypedArray()).toMutableList()
        val endList = mutableListOf<Pair<Int, Int>>()

        while (workPriorities.isNotEmpty()) {
            val temp = workPriorities.removeFirst()
            if (workPriorities.isEmpty()) {
                endList.add(temp)
                break
            }
            if (workPriorities.maxOf { it.second } > temp.second) workPriorities.add(temp)
            else endList.add(temp)
        }

        return endList.indexOf(Pair(1000, priorities[location])) + 1
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
        lines[1].toInt(),
    ).also { print(it) }
    println()
}