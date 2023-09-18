package com.example.kotlinalgorithm

import java.util.*
import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    val dx = arrayOf(0, 0, 1, -1)
    val dy = arrayOf(1, -1, 0, 0)

    fun solution(maps: Array<String>): Int {
        var roomS = Pair(0, 0)
        var roomE = Pair(0, 0)
        var roomL = Pair(0, 0)

        fun bruteForce(roomS: Pair<Int, Int>, roomE: Pair<Int, Int>, map: Array<String>): Int {
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            val visited = Array(map.size) { IntArray(map[0].length) }

            queue.add(roomS)
            visited[roomS.first][roomS.second] = 1

            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()!!

                if (x == roomE.first && y == roomE.second)
                    return visited[roomE.first][roomE.second] - 1


                for (i in 0 until 4) {
                    val tempX = x + dx[i]
                    val tempY = y + dy[i]

                    if (tempX in map.indices
                        && tempY in map[0].indices
                        && visited[tempX][tempY] == 0
                        && map[tempX][tempY] != 'X'
                    ) {
                        visited[tempX][tempY] = visited[x][y] + 1
                        queue.add(tempX to tempY)
                    }
                }
            }

            return -1
        }

        for (i in maps.indices) {
            for (j in maps[0].indices) {
                if (maps[i][j] == 'S')
                    roomS = Pair(i, j)
                else if (maps[i][j] == 'E')
                    roomE = Pair(i, j)
                else if (maps[i][j] == 'L')
                    roomL = Pair(i, j)
            }
        }

        val timeToLever = bruteForce(roomS, roomL, maps)
        val timeToExit = bruteForce(roomL, roomE, maps)

        return if (timeToLever == -1 || timeToExit == -1) -1
        else timeToLever + timeToExit
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}