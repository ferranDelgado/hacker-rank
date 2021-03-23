package com.hackerrank.algorithms.string

import java.util.Scanner

fun String.changesToPalindrom() =
    (0 until length / 2).map { i ->
        if (get(i) != get(length - i - 1)) 1 else 0
    }.sum()

// Complete the highestValuePalindrome function below.
fun highestValuePalindrome(s: String, n: Int, k: Int): String {
    var bothChanges = k - s.changesToPalindrom()
    if(bothChanges < 0) {
        return "-1"
    }
    val sb = StringBuilder(s)
    (0 until n / 2).forEach { i ->
        when {
            //sb[i] == '9' && sb[n - i - 1] == '9' -> { }
            bothChanges > 0 -> {
                if(sb[i] != '9') bothChanges -= 1
                if(sb[n - i - 1] != '9') bothChanges -= 1
                sb.setCharAt(n - i - 1, '9')
                sb.setCharAt(i, '9')

            }
            sb[i] > sb[n - i - 1] -> {
                sb.setCharAt(n - i - 1, sb[i])
            }
            sb[i] < sb[n - i - 1] -> {
                sb.setCharAt(i, sb[n - i - 1])
            }
            else -> {
                println("NOthing to do $i ${sb[i]} <> ${sb[n - i - 1]}")
            }
        }
    }

    if(bothChanges%2 == 1) {
        sb.setCharAt(n/2, '9')
        bothChanges--
    }

    var i = 0
    while (bothChanges > 0 && i < n/2) {
        if(sb[i] != '9') {
            sb.setCharAt(n - i - 1, '9')
            sb.setCharAt(i, '9')
            bothChanges -= 2
        }
        i++
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
