package com.hackerrank.interview.warmup

import java.util.*

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 */

// Complete the countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var altitude = 0
    var valleys = 0
    s.forEach {
        when (it) {
            'D' -> {
                --altitude
            }
            'U' -> {
                ++altitude
            }
            else -> {
                throw IllegalStateException("Unknown letter $it")
            }
        }
        if(altitude == -1 && it == 'D') {
            ++valleys
        }
    }
    return valleys
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}
