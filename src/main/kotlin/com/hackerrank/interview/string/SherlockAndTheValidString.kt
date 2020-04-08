package com.hackerrank.interview.string

import java.util.*
import kotlin.collections.*

// Complete the isValid function below.
fun isValid(s: String): String {
    val map = (s.indices).groupingBy {
        s[it]
    }.fold(0) { acc, _ ->
        acc + 1
    }

    val count = map.values.first()
    var oneToSubtract = true

    map.forEach { (_, v) ->
        if (count != v && count != v - 1 && v - 1 != 0) {
            return "NO"
        } else if (count != v && (count == v - 1 || v - 1 == 0) && !oneToSubtract) {
            return "NO"
        } else if (count != v && (count == v - 1 || v - 1 == 0)) {
            oneToSubtract = false
        }
    }
    return "YES"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = isValid(s)

    println(result)
}
