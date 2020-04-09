package com.hackerrank.interview.warmup

import java.util.*

// Complete the sockMerchant function below.
fun sockMerchant(ar: Array<Int>): Int {
    val countingMap = mutableMapOf<Int, Int>()
    var counting = 0
    ar.forEach {
        countingMap[it] = (countingMap[it] ?: 0) + 1
        if (countingMap.getValue(it) % 2 == 0) {
            counting++
        }
    }
    return counting
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(ar)

    println(result)
}
