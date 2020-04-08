package com.hackerrank.interview.string

import java.util.*

fun isSpecial(s: String): Boolean {
    val first: Char = s.toList().first()
    s.indices.forEach { i ->
        if (s[i] != first && (s.length == 2 || i != s.length / 2)) {
            return false
        }
    }
    return true
}

// Complete the substrCount function below.
fun substrCount(s: String): Long {
    var count = 0L
    s.indices.forEach { i ->
        (i + 2 .. s.length).forEach { subI ->
//            println("$i:: $subI :> ${s.substring(i, subI)} == ${isSpecial(s.substring(i, subI))}")
            if(isSpecial(s.substring(i, subI))) {
                count++
            }
        }
    }
    return count + s.length
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = substrCount(s)

    println(result)
}