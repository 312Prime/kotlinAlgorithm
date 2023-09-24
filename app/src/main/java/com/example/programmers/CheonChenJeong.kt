package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(args: String) {
        var cAbt = 'D'
        var count = 0
        var answer1 = 0
        var answer2 = 0
        args.forEach {
            if (cAbt == it) {
                answer1++
                if (count++ % 2 == 0) answer2++
            } else count = 0
            cAbt = it
        }

        println("$answer1 $answer2")
    }

//    input
//    AAABBCCBCAAC

    solution(
        lines[0]
    ).also { print(it) }
    println()
}