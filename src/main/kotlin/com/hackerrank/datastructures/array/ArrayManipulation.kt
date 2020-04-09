package com.hackerrank.datastructures.array

import java.util.*

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val ints = MutableList(n) { 0L }
    var max = 0L

    queries.forEach { query ->
        val from = query[0] - 1
        val to = query[1]
        val add = query[2].toLong()
        ints[from] += add
        if(to < n) ints[to] -= add
    }

    var tmp = 0L
    ints.forEach {
        tmp += it
        max = max.coerceAtLeast(tmp)
    }
    return max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextInt()
    val m = scan.nextInt()
    val ints = (0..n).map { 0L }.toMutableList()

    var max = 0L

    for (i in 0 until m) {
        val from = scan.nextInt() - 1
        val to = scan.nextInt()
        val add = scan.nextLong()
        ints[from] += add
        if(to < n) ints[to] -= add

    }
//
    var tmp = 0L
    ints.forEach {
        tmp += it
        max = max.coerceAtLeast(tmp)
    }

    println(max)
}