package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.PriorityQueue

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer = 0
        var man = n
        var shield = k
        val winHeap = PriorityQueue<Int>(compareBy { -it })
        enemy.forEach { wave ->
            winHeap.offer(wave)
            man -= wave
            if (shield > 0 && man < 0 && winHeap.size != 0) {
                man += winHeap.poll()
                shield--
            }
            if (man < 0) return answer
            answer++
        }
        return enemy.size
    }

    solution(
        lines[0].toInt(),
        lines[1].toInt(),
        lines[2].split(", ").map { it.toInt() }.toIntArray(),
    ).also { print(it) }
    println()
}