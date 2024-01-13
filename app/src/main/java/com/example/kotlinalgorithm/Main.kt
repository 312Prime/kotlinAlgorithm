package com.example.kotlinalgorithm

import java.io.BufferedReader
import java.io.File
import java.io.FileReader


fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()

        arr1.forEachIndexed { index, firstArray ->
            val tempList = mutableListOf<Int>()
            for (i in 0 until arr2[0].size) {
//                tempList.add()
                println(firstArray.indices.sumBy { number -> firstArray[number] * arr2.map { it[i] } })
            }
            answer += tempList.toIntArray()
        }

        return answer
    }

    solution(
        lines[0].split("], [").map { it.split(", ").map { it.toInt() }.toIntArray() }
            .toTypedArray(),
        lines[1].split("], [").map { it.split(", ").map { it.toInt() }.toIntArray() }
            .toTypedArray(),
    ).also { print(it) }
    println()
}