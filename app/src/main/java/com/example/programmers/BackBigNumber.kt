package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.Stack

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()

        for (i in numbers.size-1 downTo 0) {
            while (!stack.empty()) {
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek()
                    break
                }
                else stack.pop()
            }
            if (stack.isEmpty()) answer[i] = -1
            stack.push(numbers[i])
        }
        return answer
    }

    solution(
        lines[0].removeSurrounding("[", "]").split(", ").map { it.toInt() }.toIntArray()
    ).also { print(it) }
    println()
}