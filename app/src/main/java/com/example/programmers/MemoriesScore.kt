package com.example.programmers

import java.io.*

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer: IntArray = intArrayOf()

        photo.forEach { array ->
            var sum = 0
            array.forEach { currentName ->
                if (name.indexOf(currentName) != -1) sum += yearning[name.indexOf(currentName)]
            }
            answer += sum
        }
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").toTypedArray(),
        lines[1].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray(),
        lines[2].removeSurrounding("[[", "]]").split("], [").map { it ->
            it.removeSurrounding("[", "]").split(", ").toTypedArray()
        }.toTypedArray()
    )
}