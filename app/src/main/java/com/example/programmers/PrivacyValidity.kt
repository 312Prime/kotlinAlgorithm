package com.example.programmers

import java.io.*
import java.text.SimpleDateFormat
import java.util.Calendar

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val dateFormat = SimpleDateFormat("yyyy.MM.dd")
        privacies.forEachIndexed { index, privacy ->
            if (Calendar.getInstance().apply {
                    time = dateFormat.parse(privacy)
                    add(Calendar.MONTH, terms.find { it.first() == privacy.last() }!!.substring(2).toInt())
                }.time <= dateFormat.parse(today)) answer += index + 1
        }
        return answer
    }

    solution(
        lines[0],
        lines[1].split(", ").toTypedArray(),
        lines[2].split(", ").toTypedArray(),
    ).also { print(it) }
    println()
}