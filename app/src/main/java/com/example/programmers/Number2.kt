package com.example.programmers

fun main() {
    fun solution(color: Array<String>, prices: IntArray): Int {
        val top = HashMap<String, Int>()
        val pants = HashMap<String, Int>()
        var matchingCnt = 0

        for (aColor in color) {
            val aClothes = aColor.split("") // 0: 상의, 1: 하의
            top[aClothes[0]] = top.getOrDefault(aClothes[0], 0) + 1 // 상의 추가
            pants[aClothes[1]] = pants.getOrDefault(aClothes[1], 0) + 1 // 하의 추가
        }

        for (targetColor in top.keys) {
            // 매칭 여부 확인
            if (pants.containsKey(targetColor)) {
                // 매칭 개수 만큼 최소값
                val min = minOf(top[targetColor]!!, pants[targetColor]!!)
                matchingCnt += min
            }
        }

        // 매칭 계산
        return (matchingCnt * prices[0]) + (color.size - matchingCnt) * prices[1]
    }
    println(solution(arrayOf("RG", "WR", "BW", "GG"), intArrayOf(2000, 6000)))
}