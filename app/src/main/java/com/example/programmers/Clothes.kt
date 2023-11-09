package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val clothesMap = mutableMapOf<String, Int>()
        clothes.forEach {
            if (clothesMap.containsKey(it.last())) {
                clothesMap[it.last()] = clothesMap[it.last()]!! + 1
            } else {
                clothesMap[it.last()] = 1
            }
        }
        if (clothesMap.size == 1) answer = clothesMap.values.sum() else {
            clothesMap.forEach {
                answer *= (it.value + 1)
            }
            answer--
        }

        return answer
    }

    solution(
        lines[0].split("], [")
            .map { it.split(", ").map { it.removeSurrounding("[", "]") }.toTypedArray() }
            .toTypedArray()
    ).also { print(it) }
    println()
}