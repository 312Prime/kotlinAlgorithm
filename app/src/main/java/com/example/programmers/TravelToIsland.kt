package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val mutableMap = mutableMapOf<Pair<Int, Int>, Boolean>()
        val mutableSet = mutableSetOf<Pair<Int, Int>>()

        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {

                // 초기화
                if (mutableMap[Pair(i, j)] == true || maps[i][j] == 'X') continue
                var sum = 0
                var curI = i
                var curJ = j
                var type = 0

                while (true) {
                    when (type) {
                        1 -> curJ++
                        2 -> curI++
                        3 -> curJ--
                        4 -> curI--
                        else -> {}
                    }
                    if (mutableMap[Pair(curI, curJ)] != true)
                        sum += maps[curI][curJ].toString().toInt()
                    mutableMap[Pair(curI, curJ)] = true
                    type = 0
                    var isOtherWay = false

                    // 순환
                    if (curJ != maps[0].length - 1)
                        if (maps[curI][curJ + 1] != 'X' &&
                            mutableMap[Pair(curI, curJ + 1)] != true
                        ) {
                            if (!isOtherWay) {
                                type = 1
                                isOtherWay = true
                            } else mutableSet.add(Pair(curI, curJ + 1))
                        }
                    if (curI != maps.size - 1) {
                        if (maps[curI + 1][curJ] != 'X' &&
                            mutableMap[Pair(curI + 1, curJ)] != true
                        ) {
                            if (!isOtherWay) {
                                type = 2
                                isOtherWay = true
                            } else {
                                mutableSet.add(Pair(curI + 1, curJ))
                            }
                        }
                    }
                    if (curJ != 0)
                        if (maps[curI][curJ - 1] != 'X' &&
                            mutableMap[Pair(curI, curJ - 1)] != true
                        ) {
                            if (!isOtherWay) {
                                type = 3
                                isOtherWay = true
                            } else mutableSet.add(Pair(curI, curJ - 1))
                        }
                    if (curI != 0)
                        if (maps[curI - 1][curJ] != 'X' &&
                            mutableMap[Pair(curI - 1, curJ)] != true
                        ) {
                            if (!isOtherWay) {
                                type = 4
                                isOtherWay = true
                            } else mutableSet.add(Pair(curI - 1, curJ))
                        }

                    // 재검
                    if (isOtherWay) continue

                    if (mutableSet.size != 0) {
                        curI = mutableSet.last().first
                        curJ = mutableSet.last().second
                        mutableSet.remove(mutableSet.last())
                        continue
                    }

                    answer += sum
                    break
                }
            }
        }
        answer.sort()
        if (answer.isEmpty()) answer += -1
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}