package com.hackerrank.interview.warmup

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=warmup
 */

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var i = 0
    var jumps = 0
    while (i < c.size - 1) {
        when {
            i + 2 == c.size -> {
                i = c.size
            }
            c[i + 2] == 0 -> {
                i += 2
            }
            else -> {
                ++i
            }
        }
        ++jumps
    }
    return jumps
}

fun main() {
    val a = jumpingOnClouds(arrayOf(0, 0, 1, 0, 0, 1, 0))
    println("A ($a) should be 4")

    val b = jumpingOnClouds(arrayOf(0, 0, 0, 0, 1, 0))
    println("B ($b) should be 3")

    val c = jumpingOnClouds(arrayOf(0, 0, 0, 0, 0, 0))
    println("B ($c) should be 3")

    val d = jumpingOnClouds(arrayOf(0, 0, 0, 1, 0, 0))
    println("B ($d) should be 3")

}
//
//fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val n = scan.nextLine().trim().toInt()
//
//    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    val result = jumpingOnClouds(c)
//
//    println(result)
//}
