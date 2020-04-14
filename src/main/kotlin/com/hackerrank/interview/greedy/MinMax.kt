package com.hackerrank.interview.greedy

import java.util.*

// Complete the maxMin function below.
fun maxMin(k: Int, arr: Array<Int>): Int {
    arr.sort()
    var min = arr.last()
    (0 .. arr.size - k).forEach {i ->
        val index = i + k - 1
        val sub = arr[index] - arr[i]
        min = sub.coerceAtMost(min)
    }
    return min
}

fun maxMinOld(k: Int, arr: Array<Int>): Int {
    var subarr = arr.copyOfRange(0, k)
    subarr.sort()
    arr.copyOfRange(k, arr.size).forEach { value ->
        var indexPlace = subarr.indexOfFirst { it > value }
        indexPlace = if (indexPlace == -1) k else indexPlace
        val left = subarr.copyOfRange(0, indexPlace)
        val right = subarr.copyOfRange(indexPlace, k)
        val mix = left + value + right

        val a = mix[k - 1] - mix[0]
        val b = mix[k] - mix[1]
        subarr = if (a < b) {
            mix.copyOfRange(0, k)
        } else {
            mix.copyOfRange(1, k + 1)
        }
        println("$value ${subarr.toList()} => ${subarr.toList().max()} - ${subarr.toList().min()} = ${subarr.toList().max()!! - subarr.toList().min()!!}")
    }
    return subarr.last() - subarr.first()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val k = scan.nextLine().trim().toInt()

    val arr = Array<Int>(n, { 0 })
    for (i in 0 until n) {
        val arrItem = scan.nextLine().trim().toInt()
        arr[i] = arrItem
    }

    val result = maxMin(k, arr)

    println(result)
}
