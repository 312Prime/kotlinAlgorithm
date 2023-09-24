package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(line: MutableList<String>) {
        lines.removeFirst()
        var cDrone = 0
        var cBird = 0
        val visList = line.map { it.map { false }.toMutableList() }.toMutableList()
        for (i in line.indices) {
            for (j in 0 until line[0].length) {
                var drone = 0
                var bird = 0
                if (line[i][j] != '#' && !visList[i][j]) {
                    var isOWay = false
                    val oWay = mutableListOf<Pair<Int, Int>>()
                    var cx = i
                    var cy = j
                    var nWay = 0
                    while (true) {
                        if (!visList[cx][cy]) when (line[cx][cy]) {
                            'v' -> bird++
                            'o' -> drone++
                        }
                        isOWay = false
                        when (nWay) {
                            1 -> cy++
                            2 -> cx++
                            3 -> cy--
                            4 -> cx--
                        }
                        nWay = 0
                        visList[cx][cy] = true
                        if (cy + 1 < line[0].length && line[cx][cy + 1] != '#' && !visList[cx][cy + 1]) {
                            if (isOWay) {
                                oWay.add(Pair(cx, cy + 1))
                            } else {
                                isOWay = true
                                nWay = 1
                            }
                        }

                        if (cx + 1 < line.size && line[cx + 1][cy] != '#' && !visList[cx + 1][cy]) {
                            if (isOWay) {
                                oWay.add(Pair(cx + 1, cy))
                            } else {
                                isOWay = true
                                nWay = 2
                            }
                        }

                        if (cy != 0 && line[cx][cy - 1] != '#' && !visList[cx][cy - 1]) {
                            if (isOWay) {
                                oWay.add(Pair(cx, cy - 1))
                            } else {
                                isOWay = true
                                nWay = 3
                            }
                        }

                        if (cx != 0 && line[cx - 1][cy] != '#' && !visList[cx - 1][cy]) {
                            if (isOWay) {
                                oWay.add(Pair(cx - 1, cy))
                            } else {
                                isOWay = true
                                nWay = 4
                            }
                        }

                        if (!isOWay) {
                            if (oWay.isNotEmpty()) oWay.removeLast().also {
                                cx = it.first
                                cy = it.second
                            } else break
                        }
                    }

                    if (bird >= drone) {
                        cBird += bird
                    } else {
                        cDrone += drone
                    }
                }
            }
        }
        print("$cDrone $cBird")
    }

//    input
//    6 6
//...#..
//.##v#.
//#v.#.#
//#.o#.#
//.###.#
//...###

    solution(
        lines
    ).also { print(it) }
    println()
}