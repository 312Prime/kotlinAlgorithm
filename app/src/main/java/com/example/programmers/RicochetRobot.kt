package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun findRoad(
        x: Int,
        y: Int,
        board: Array<String>,
        dx: Int,
        dy: Int
    ): Pair<Int, Int> {
        var currentX = x
        var currentY = y
        while (true) {
            if (currentX + dx == -1 || currentX + dx == board.size)
                return Pair(currentX, currentY)
            if (currentY + dy == -1 || currentY + dy == board[0].length)
                return Pair(currentX, currentY)
            if (board[currentX + dx][currentY + dy] == 'D')
                return Pair(currentX, currentY)
            currentX += dx
            currentY += dy
        }
    }

    fun solution(board: Array<String>): Int {
        var answer = Int.MAX_VALUE
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(-1, 0, 1, 0)
        val queueList = mutableListOf<Triple<Int, Int, Int>>()
        val visited = MutableList(board.size) { MutableList(board[0].length) { Int.MAX_VALUE } }

        board.forEachIndexed { i, sList ->
            if (sList.contains('R')) {
                queueList.add(Triple(i, sList.indexOf('R'), 0))
            }
        }

        while (queueList.isNotEmpty()) {
            val temp = queueList.removeLast()
            val current = Pair(temp.first, temp.second)
            val count = temp.third

            if (board[current.first][current.second] == 'G') {
                answer = Math.min(answer, count)
            }

            for (i in 0..3) {
                val toGoNode = findRoad(current.first, current.second, board, dx[i], dy[i])
                if (toGoNode != current && visited[toGoNode.first][toGoNode.second] > count + 1) {
                    queueList.add(Triple(toGoNode.first, toGoNode.second, count + 1))
                    visited[toGoNode.first][toGoNode.second] = count + 1
                }
            }
        }

        return if (answer == Int.MAX_VALUE) -1 else answer
    }

    solution(
        lines[0].split(", ").map { it.trim('"') }.toTypedArray(),
    ).also { print(it) }
    println()
}