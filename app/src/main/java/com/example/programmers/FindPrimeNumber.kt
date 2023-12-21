package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    lateinit var numberSet: MutableSet<Int>

    fun checkPrimeNumber(checkNumber: Int): Boolean {
        when (checkNumber) {
            0 -> return false
            1 -> return false
            2 -> return true
            else ->
                for (i in 2..checkNumber / 2 + 1) {
                    if (checkNumber % i == 0) return false
                }
        }
        return true
    }

    fun combinatorNumber(numbers: String, result: String) {
        if (result.isNotEmpty()) numberSet.add(result.toInt())
        if (numbers.isEmpty()) return
        numbers.forEachIndexed { index, c ->
            combinatorNumber(numbers.removeRange(index..index), c.plus(result))
        }
    }

    fun solution(numbers: String): Int {
        numberSet = mutableSetOf()
        combinatorNumber(numbers, "")
        return numberSet.count { checkPrimeNumber(it) }
    }

    solution(
        lines[0],
    ).also { print(it) }
    println()
}