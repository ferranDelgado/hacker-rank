package com.hackerrank.algorithms.string

import java.util.*


fun createPalindrom(a: String, aFrom: Int, aTo: Int, b: String, bFrom: Int, bTo: Int): String {
    val subA = a.substring(aFrom, aTo)
    val subB = b.substring(bFrom, bTo)

    val subAHasNext = aTo < a.length
    val subBHasNext = bTo < b.length
    return when {
        subAHasNext && subBHasNext -> {
            val middle = if (a[aTo] < b[bTo]) a[aTo] else b[bTo]
            subA + middle + subB.reversed()
        }
        subAHasNext -> {
            val middle = a[aTo]
            subA + middle + subB.reversed()
        }
        subBHasNext -> {
            val middle = b[bTo]
            subA + middle + subB.reversed()
        }
        else -> subA + subB.reversed()
    }
}

/*
https://www.hackerrank.com/challenges/challenging-palindromes/problem
 * Complete the buildPalindrome function below.
 */
fun buildPalindrome(a: String, b: String): String {
    var palindrome: String? = null
    val bReversed = b.reversed()
    a.indices.forEach { i ->
        bReversed.indices.forEach { j ->
            val pali = if (a[i] == bReversed[j]) {
                recu(a, i, i + 1, bReversed, j, j + 1)
            } else null
            palindrome = listOfNotNull(palindrome, pali).sort()
        }
    }
    return palindrome ?: "-1"
}


fun recu(a: String, aFrom: Int, aTo: Int, b: String, bFrom: Int, bTo: Int): String? {
    val subA = a.substring(aFrom, aTo)
    val subB = b.substring(bFrom, bTo).reversed()

    val w = "$subA${subB}".palindromeOrNull()
    val x = if (aTo + 1 <= a.length && bTo + 1 <= b.length) {
        recu(a, aFrom, aTo + 1, b, bFrom, bTo + 1)
    } else null

    val y = if (aTo + 1 <= a.length) {
        recu(a, aFrom, aTo + 1, b, bFrom, bTo)
    } else null

    val z = if (bTo + 1 <= b.length) {
        recu(a, aFrom, aTo, b, bFrom, bTo + 1)
    } else null
    return listOfNotNull(w, x, y, z).sort()
}

fun List<String>.sort(): String? {
    val comparator = compareByDescending<String> {
        it.length
    }.thenBy {
        it
    }

    return sortedWith(comparator).firstOrNull()
}

private fun String.isPalindrome(): Boolean = this == this.reversed()
private fun String.palindromeOrNull(): String? =
    if (isPalindrome() && length > 2) {
        this
    } else null

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val a = scan.nextLine()

        val b = scan.nextLine()

        val result = buildPalindrome(a, b)

        println(result)
    }
}
