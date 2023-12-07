package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(s: String): Int {
        var answer: Int = 0
        var brackets = s
        if (brackets.length == 1) return 0

        for (i in s.indices) {
            brackets = brackets.substring(1) + brackets[0]
            val temp = brackets.toMutableList()
            val stack = mutableListOf<Char>()
            while (temp.size != 0) {
                val current = temp.removeFirst()
                if (current == '[' || current == '{' || current == '(') stack.add(current)
                else {
                    if (stack.isEmpty()) break
                    when (stack.removeLast()) {
                        '[' -> if (current != ']') break
                        '{' -> if (current != '}') break
                        '(' -> if (current != ')') break
                    }
                }
            }
            if (temp.size == 0 && stack.isEmpty()) answer++
        }
        return answer
    }

    solution(
        lines[0],
    ).also { print(it) }
    println()
}