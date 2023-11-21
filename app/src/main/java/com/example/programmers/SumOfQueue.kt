package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val queueFirst = ArrayDeque(queue1.toList())
        val queueSecond = ArrayDeque(queue2.toList())
        var count = 0

        var sumFirst = queueFirst.sum().toLong()
        var sumSecond = queueSecond.sum().toLong()

        while (sumFirst != sumSecond) {
            count++
            if (sumFirst > sumSecond) {
                val add = queueFirst.removeFirst()
                queueSecond.add(add)
                sumFirst -= add
                sumSecond += add
            } else {
                val add = queueSecond.removeFirst()
                queueFirst.add(add)
                sumFirst += add
                sumSecond -= add
            }
            if (count >= (queue1.size + queue2.size) * 2) return -1
        }

        return count
    }

    solution(
        lines[0].split(", ").map { it.toInt() }.toIntArray(),
        lines[1].split(", ").map { it.toInt() }.toIntArray()
    )
        .also { print(it) }
    println()
}