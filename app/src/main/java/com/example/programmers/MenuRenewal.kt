package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: ArrayList<String> = arrayListOf<String>()
        val setMap = mutableMapOf<String, Int>()

        fun addMap(
            input: String,
            current: String = "",
            index: Int = 0,
            resultMap: MutableMap<String, Int>
        ) {
            if (index == input.length) {
                if (current.isNotEmpty() && current.length > 1)
                    resultMap.merge(current, 1, Int::plus)
                return
            }
            addMap(input, current + input[index], index + 1, resultMap)
            addMap(input, current, index + 1, resultMap)
        }

        for (i in orders.indices) {
            addMap(orders[i].split("").sorted().joinToString(""), resultMap = setMap)
        }
        course.forEach { size ->
            val map = setMap.filter { it.key.length == size && it.value > 1 }
            val max = map.values.maxOfOrNull { it }
            map.forEach { if (it.value == max) answer.add(it.key) }
        }

        return answer.sorted().toTypedArray()
    }

    solution(
        lines[0].split(", ").map { it.trim('"') }.toTypedArray(),
        lines[1].split(",").map { it.toInt() }.toIntArray(),
    ).also { print(it.toMutableList()) }
    println()
}