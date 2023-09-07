package com.example.kotlinalgo

rithm

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(maps: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        for (i in maps.indices) {
            for (j in 0 until maps[0].length) {
                var count = 0
                if (maps[i][j] == 'X') continue
                if (i != 0 && maps.getOrNull(i - 1)?.get(j) != 'X') {
                    count++
                }
                if (j != 0 && maps[i].getOrNull(j - 1) != 'X') {
                    count++
                }

                when(count){
                    0->
//                        1->
                }

            }
        }
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray()
    ).also { print(it) }
    println()
}