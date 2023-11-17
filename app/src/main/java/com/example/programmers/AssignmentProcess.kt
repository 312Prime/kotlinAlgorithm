package com.example.programmers

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")

    val lines = mutableListOf<String>()
    BufferedReader(FileReader(inputFile)).lines().forEach { lines.add(it) }

    fun stringToTime(time: String): Int {
        val timeList = time.split(":")
        return timeList[0].toInt() * 60 + timeList[1].toInt()
    }

    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val subjectList = mutableListOf<Triple<String, Int, Int>>()
        val stackList = mutableListOf<Pair<String, Int>>()

        plans.sortedBy { stringToTime(it[1]) }.forEach {
            subjectList.add(Triple(it[0], stringToTime(it[1]), it[2].toInt()))
        }

        while (subjectList.size > 1) {
            var overTime = subjectList[0].second + subjectList[0].third - subjectList[1].second
            if (overTime > 0) {
                stackList.add(Pair(subjectList.removeFirst().first, overTime))
            } else {
                answer += subjectList.removeFirst().first
                while (overTime < 0) {
                    if (stackList.size == 0) break
                    val last = stackList.removeLast()
                    if (last.second > -overTime) {
                        stackList.add(Pair(last.first, last.second + overTime))
                        break
                    } else {
                        overTime += last.second
                        answer += last.first
                    }
                }
            }
            subjectList.sortBy { it.second }
        }
        answer += subjectList[0].first
        stackList.reversed().forEach { answer += it.first }

        return answer
    }

    solution(lines[0].split("], [").map { it.split(", ").map { it.trim('"') }.toTypedArray() }
        .toTypedArray()).also { print(it.toMutableList()) }
    println()
}