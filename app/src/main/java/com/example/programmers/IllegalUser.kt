package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val sList = banned_id.map { mutableListOf<Int>() }.toMutableList()
        banned_id.forEachIndexed { banIndex, banId ->
            user_id.forEachIndexed { uidIndex, uid ->
                var count = 0
                if (uid.length == banId.length) {
                    banId.forEachIndexed { index, c ->
                        if (c == '*' || c == uid[index]) count++
                    }
                }
                if (count == uid.length) sList[banIndex].add(uidIndex)
            }
        }
        val banSet = mutableSetOf<List<String>>()
        fun combinator(
            arrays: List<List<String>>,
            current: List<String> = emptyList(), currentIndex: Int = 0
        ) {
            if (currentIndex == arrays.size) {
                if (current.size == current.distinct().size) banSet.add(current.sorted())
            } else {
                for (i in arrays[currentIndex]) {
                    combinator(arrays, current + i, currentIndex + 1)
                }
            }
        }
        combinator(sList.map { it.map { it.toString() } })
        return banSet.size
    }

    solution(
        lines[0].split(", ").map { it.substring(1, it.length - 1) }.toTypedArray(),
        lines[1].split(", ").map { it.substring(1, it.length - 1) }.toTypedArray(),
    ).also { print(it) }
    println()
}