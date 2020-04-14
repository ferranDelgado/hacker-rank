package com.hackerrank.algorithms.implementation

import java.util.*
import kotlin.collections.ArrayList

fun print(s: List<List<Int>>) {
    println("__________________")
    s.forEach {
        println(it.joinToString(separator = ","))
    }
    println("__________________")
}

val magicSquare = arrayListOf(
    arrayListOf(8, 3, 4),
    arrayListOf(1, 5, 9),
    arrayListOf(6, 7, 2)
)

val magicSquareVMirror = arrayListOf(
    arrayListOf(4, 3, 8),
    arrayListOf(9, 5, 1),
    arrayListOf(2, 7, 6)
)

val magicSquareHMirror = arrayListOf(
    arrayListOf(6, 7, 2),
    arrayListOf(1, 5, 9),
    arrayListOf(8, 3, 4)
)


fun rot90(s: List<List<Int>>) = arrayListOf(
    arrayListOf(s[2][0], s[1][0], s[0][0]),
    arrayListOf(s[2][1], s[1][1], s[0][1]),
    arrayListOf(s[2][2], s[1][2], s[0][2])
)

fun diff(a: Array<Array<Int>>, b: List<List<Int>>) =
    (0 until 3).map { i ->
        (0 until 3).map { j ->
            Math.abs(a[i][j] - b[i][j])
        }.sum()
    }.sum()

// Complete the formingMagicSquare function below.
fun formingMagicSquare(s: Array<Array<Int>>): Int {
    val transformations = arrayListOf(
        magicSquare,
        magicSquare.rot90(1),
        magicSquare.rot90(2),
        magicSquare.rot90(3),
        magicSquareVMirror,
        magicSquareVMirror.rot90(1),
        magicSquareVMirror.rot90(2),
        magicSquareVMirror.rot90(3),
        magicSquareHMirror,
        magicSquareHMirror.rot90(1),
        magicSquareHMirror.rot90(2),
        magicSquareHMirror.rot90(3)
    )

    return transformations.map { diff(s, it) }.min()!!
}

private fun ArrayList<ArrayList<Int>>.rot90(times: Int): ArrayList<ArrayList<Int>> {
    var result = this
    (0 until times).forEach {
        result = rot90(result)
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = Array<Array<Int>>(3, { Array<Int>(3, { 0 }) })

    for (i in 0 until 3) {
        s[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = formingMagicSquare(s)

    println(result)
}
