package com.example.kotlinalgorithm

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(maps: Array<String>): Int {
        val isVisitedList = mutableListOf<MutableList<Boolean>>()
        var roomS = Pair(0, 0)
        var roomL = Pair(0, 0)
        var roomE = Pair(0, 0)
        val queue = mutableListOf<Pair<Int, Int>>()

        for (i in maps.indices) {
            isVisitedList.add(MutableList(maps[0].length) { false })
        }
        for (i in maps.indices) for (j in maps[0].indices) {
            when (maps[i][j]) {
                'S' -> roomS = Pair(i, j)
                'L' -> roomL = Pair(i, j)
                'E' -> roomE = Pair(i, j)
            }
        }
        queue.add(roomS)
        while (queue.isNotEmpty()) {
            maps[queue.removeLast().first][queue.removeLast().second]
        }


        return 1
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}