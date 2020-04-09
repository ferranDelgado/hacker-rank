package com.hackerrank.interview.arrays

import java.util.*

// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var count = 0
    arr.indices.forEach {
        while (arr[it] != it + 1) {
            val newI = arr[it] - 1
            val swap = arr[it]
            arr[it] = arr[newI]
            arr[newI] = swap
            ++count;
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
