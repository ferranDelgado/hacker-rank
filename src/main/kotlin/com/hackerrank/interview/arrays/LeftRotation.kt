package com.hackerrank.interview.arrays

import java.util.*

// Complete the rotLeft function below.
fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val rot = d%a.size
    val right = a.copyOfRange(0, rot)
    val left = a.copyOfRange(rot, a.size)
    return left + right
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
