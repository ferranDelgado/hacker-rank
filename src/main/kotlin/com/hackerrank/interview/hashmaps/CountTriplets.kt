package com.hackerrank.interview.hashmaps

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/** Complete the countTriplets function below.
 *
 */
fun countTriplets(arr: Array<Long>, r: Long): Long {
    val nextSecond: MutableMap<Long, Long> = mutableMapOf()
    val nextThird: MutableMap<Long, Long> = mutableMapOf()
    var count = 0L

    arr.forEach {
        nextThird[it]?.let { value ->
            count += value
        }

        nextSecond[it]?.let { value ->
            nextThird[it * r] = value + (nextThird[it * r] ?: 0)
        }

        nextSecond[it * r] = 1 + (nextSecond[it * r] ?: 0)
    }
    return count
}
//fun countTriplets(arr: Array<Long>, r: Long): Long {
//    val group = arr.groupingBy { it }
//        .fold(0) { acc, value ->
//            acc + 1
//        }
//    var count = 0L
//
//    arr.forEach { value ->
//        val secondCount = group[value*r]
//        val thirdCount = group[value*r*r]
//        if(secondCount != null && thirdCount != null) {
//            count += secondCount * thirdCount
//        }
//    }
//
////    group.forEach {(value, firstCount) ->
////        val secondCount = group[value*r]
////        val thirdCount = group[value*r*r]
////        if(secondCount != null && thirdCount != null) {
////            count += firstCount * secondCount * thirdCount
////        }
////    }
//
////    while (i + 2 < group.keys.size) {
////        if ((keys[i + 2] / r / r) == keys[i] || (keys[i + 1] / r) == keys[i]) {
////            val first = group.getValue(keys[i])
////            val second = group.getValue(keys[i + 1])
////            val third = group.getValue(keys[i + 2])
////            count += first * second * third
////        }
////
////        ++i
////    }
//    return count
//}

fun main(args: Array<String>) {
    val nr = readLine()!!.trimEnd().split(" ")

    val n = nr[0].toInt()

    val r = nr[1].toLong()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toLong() }.toTypedArray()

    val ans = countTriplets(arr, r)

    println(ans)
}
