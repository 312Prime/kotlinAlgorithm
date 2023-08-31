package com.example.kotlinalgorithm

import java.io.*

fun main(){
    val inputFile = File("app/src/main/java/com/example/kotlinalgorithm/input.txt")
    val lines = inputFile.readLines()

    print(lines)
}