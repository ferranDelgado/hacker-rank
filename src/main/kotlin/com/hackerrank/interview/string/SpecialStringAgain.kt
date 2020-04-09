package com.hackerrank.interview.string

import java.util.*

fun isSpecial(s: String): Boolean {
    val first: Char = s.toList().first()
    s.indices.forEach { i ->
        val isMiddle = i == s.length / 2 && s.length % 2 == 1
        if (s[i] != first && !isMiddle) {
            return false
        }
    }
    return true
}

fun substrCountSlow(s: String): Long {
    var count = 0L
    s.indices.forEach { i ->
        (i + 2..s.length).forEach { subI ->
            if (isSpecial(s.substring(i, subI))) {
                count++
            }
        }
    }
    return count + s.length
}

fun String.longestEqual(c: Char): Int {
    return fold(0 to true) { acc, v ->
        if (v == c && acc.second) {
            acc.first + 1 to true
        } else {
            acc.first to false
        }
    }.first
}

// Complete the substrCount function below.
fun substrCount(s: String): Long {
    var count = 1L
    var previousLetter: Char = s.first()
    var sameLetterCount = 1
    (1 until s.length).forEach { i ->
        if (s[i] != previousLetter) {
            val subStrInit = i + 1
            val subStrEnd = s.length.coerceAtMost(subStrInit + sameLetterCount)
            val subStr = s.substring(subStrInit, subStrEnd)
            val subCount = subStr.longestEqual(previousLetter)
            if (subCount in 1..sameLetterCount) {
                count += subCount
            }
            previousLetter = s[i]
            sameLetterCount = 1
        } else {
            ++sameLetterCount
        }
        count += sameLetterCount
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = substrCount(s)

    println(result)
}