package com.hackerrank.algorithms.string

import java.util.Scanner

fun String.changesToPalindrom() =
    (0 until length / 2).map { i ->
        if (get(i) != get(length - i - 1)) 1 else 0
    }.sum()

// Complete the highestValuePalindrome function below.
fun highestValuePalindrome(s: String, n: Int, k: Int): String {
    var bothChanges = k - s.changesToPalindrom()
    if (bothChanges < 0) {
        return "-1"
    }
    val sb = StringBuilder(s)
    var i = 0
    var moveLeft = k
    while (i < n/2 && moveLeft > 0) {
        when {
            (bothChanges > 0 && moveLeft > 1 && sb[i] != '9' && sb[n - i - 1] != '9') -> {
                sb.setCharAt(n - i - 1, '9')
                sb.setCharAt(i, '9')
                moveLeft -= 2
                bothChanges -= if(s[n - i - 1] == s[i]) 2 else 1
            }
            sb[i] > sb[n - i - 1] -> {
                sb.setCharAt(n - i - 1, sb[i])
                moveLeft -= 1
            }
            sb[i] < sb[n - i - 1] -> {
                sb.setCharAt(i, sb[n - i - 1])
                moveLeft -= 1
            }
            else -> {}
        }
        ++i
    }

    if (moveLeft % 2 == 1) {
        sb.setCharAt(n / 2, '9')
        moveLeft--
    }

    i = 0
    while (moveLeft > 1 && i < n/2) {
        if (sb[i] != '9') {
            sb.setCharAt(n - i - 1, '9')
            sb.setCharAt(i, '9')
            --moveLeft
        }
        ++i
    }
    return sb.toString()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val s = scan.nextLine()

    val result = highestValuePalindrome(s, n, k)

    println(result)
}
