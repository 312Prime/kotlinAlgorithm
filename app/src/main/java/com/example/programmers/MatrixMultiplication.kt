package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()
        val arr2SliceList = arr2.first().indices.map { index -> arr2.map { it[index] } }

        arr1.forEach { firstArray ->
            val tempList = mutableListOf<Int>()
            arr2SliceList.forEach { secondArray ->
                tempList.add(firstArray.indices.sumOf { index -> firstArray[index] * secondArray[index] })
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
    ).also { print(it.map { it.toMutableList() }.toMutableList()) }
    println()
}