package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>) =
        arr1.mapIndexed { listIndex, ints -> ints.mapIndexed { index, int -> arr2[listIndex][index] + int } }

    solution(
        lines[0].split("],[").map { it.split(",").map { it.toInt() }.toIntArray() }.toTypedArray(),
        lines[1].split("],[").map { it.split(",").map { it.toInt() }.toIntArray() }.toTypedArray(),
    ).also { print(it) }
    println()
}