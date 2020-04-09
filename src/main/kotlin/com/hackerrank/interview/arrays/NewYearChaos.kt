package com.hackerrank.interview.arrays


// Complete the minimumBribes function below.
fun minimumBribesValue(q: Array<Int>): Int {
    var sum = 0
    var min = q[q.size - 1]
    for (index in (q.size - 1) downTo 0) {
        val value = q[index]
        min = min.coerceAtMost(value)
        val bribes = value - index - 1
        when {
            bribes > 2 -> {
                return -1
            }
            bribes > 0 -> {
                sum += bribes
            }
            value > min -> {
                sum++
            }
        }
//        println("$value bribes $bribes times Sum: $sum. Min: $min")
    }
    return sum
}

fun minimumBribes(q: Array<Int>) {
    val result = minimumBribesValue(q)
    if (result < 0) {
        println("Too chaotic")
    } else {
        println(result)
    }
}
//
//fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val t = scan.nextLine().trim().toInt()
//
//    for (tItr in 1..t) {
//        val n = scan.nextLine().trim().toInt()
//
//        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
//
//        minimumBribes(q)
//    }
//}