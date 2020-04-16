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
fun buildPalindrome2(a: String, b: String): String {
    val bReverse = b.reversed()
    var palindrom = "-1"
    a.indices.forEach { i ->
        var localPalindrom = "-1"
        bReverse.indices.forEach { j ->
            if (a[i] == bReverse[j]) {
                localPalindrom = createPalindrom(
                    a = a,
                    aFrom = i,
                    aTo = if (i + 1 <= a.length) i + 1 else i,
                    b = bReverse,
                    bFrom = j,
                    bTo = if (j + 1 <= b.length) j + 1 else j
                )
                val maxLength = Math.min((a.length - i), (bReverse.length - j))
                (2..maxLength).forEach {
                    val subA = a.substring(i, i + it)
                    val subB = bReverse.substring(j, j + it)
                    if (subA == subB) {
                        localPalindrom = createPalindrom(
                            a = a,
                            aFrom = i,
                            aTo = i + it,
                            b = bReverse,
                            bFrom = j,
                            bTo = j + it
                        )
                    }
                }
            }
        }
        palindrom = when {
            palindrom == "-1" -> {
                localPalindrom
            }
            localPalindrom == "-1" -> {
                palindrom
            }
            palindrom < localPalindrom -> {
                palindrom
            }
            else -> localPalindrom
        }
    }

    return palindrom
}

fun buildPalindrome(a: String, b: String): String {
    var palindrom = "-1"
    a.indices.forEach { i ->
        var localPalindrom = "-1"
        b.indices.reversed().forEach { j ->
            println("${a[i]} =?= ${b[j]}")

            if (a[i] == b[j]) {
                var aIndex = i + 1
                var bIndex = j
                var isMoving = true
                var plusA = 5
                var plusB = 5
                while (plusA + plusB != 0) {
                    plusA = 0
                    plusB = 0
                    if (aIndex <= a.length && bIndex >= 0) {
                        val subA = a.substring(i, aIndex)
                        val subB = b.subSequence(bIndex, j + 1)
                        println("A&B   | $subA  $subB")
                        if ("$subA$subB".isPalindrome()) {
                            plusA = 1
                            plusB = 1
                        }
                    }

                    if (aIndex < a.length && plusA + plusA == 0) {
                        val subA = a.substring(i, aIndex)
                        val subB = b.subSequence(bIndex, j + 1)
                        println("A     | $subA  $subB")
                        if ("$subA$subB".isPalindrome()) {
                            plusA = 1
                        }
                    }

                    if (bIndex >= 0 && plusA + plusA == 0) {
                        val subA = a.substring(i, aIndex)
                        val subB = b.subSequence(bIndex, j + 1)
                        println("B     | $subA  $subB")
                        if ("$subA$subB".isPalindrome()) {
                            plusB = 1
                        }
                    }

                    aIndex += plusA
                    bIndex -= plusB
                }
            }
        }
        palindrom = decidePalindrome(palindrom, localPalindrom)
    }

    return palindrom
}

private fun decidePalindrome(a: String, b: String): String {
    return when {
        a == "-1" -> {
            b
        }
        b == "-1" -> {
            a
        }
        a < b -> {
            a
        }
        else -> b
    }
}

private fun String.isPalindrome(): Boolean = this == this.reversed()

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
