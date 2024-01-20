package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val reportMap = id_list.associateWith { mutableSetOf<String>() }.toMutableMap()
        val sendMap = id_list.associateWith { 0 }.toMutableMap()

        report.forEach {
            val reporter = it.split(" ").first()
            val reported = it.split(" ").last()
            reportMap[reported]!!.add(reporter)
        }

        reportMap.filter { it.value.size >= k }.values.flatten().forEach {
            sendMap[it] = sendMap[it]!! + 1
        }

        return sendMap.values.toIntArray()
    }

    solution(
        lines[0].split(", ").map { it.trim('"') }.toTypedArray(),
        lines[1].split(",").map { it.trim('"') }.toTypedArray(),
        lines[2].toInt()
    ).also { print(it.toMutableList()) }
    println()
}