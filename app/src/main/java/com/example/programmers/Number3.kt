package com.example.programmers

fun solution(a: Array<String>): BooleanArray {
    val results = mutableListOf<Boolean>()

    for (input in a) {
        val queue = mutableListOf<String>()
        queue.add("a")
        var found = false

        while (queue.isNotEmpty()) {
            val currentString = queue.removeAt(0)

            if (currentString == input) {
                found = true
                break
            }

            val aCount = currentString.count { it == 'a' }
            val newString1 = "b".repeat(aCount) + currentString + "b".repeat(aCount)
            val newString2 = "a" + currentString
            val newString3 = currentString + "a"

            if (newString1.length <= input.length) {
                queue.add(newString1)
            }
            if (newString2.length <= input.length) {
                queue.add(newString2)
            }
            if (newString3.length <= input.length) {
                queue.add(newString3)
            }
        }

        results.add(found)
    }

    return results.toBooleanArray()
}