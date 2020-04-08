package com.hackerrank.interview.hashmaps

import java.lang.IllegalStateException

// Complete the freqQuery function below.
fun freqQuery(queries: Array<Array<Int>>): Array<Int> {
    val map = mutableMapOf<Int, Int>()
    val counts = mutableMapOf<Int, Int>()
    val result = mutableListOf<Int>()
    queries.forEach { (query, value) ->
        when (query) {
            1 -> {
                if (map.containsKey(value)) {
                    val oldCount: Int = map.getValue(value)
                    counts[oldCount] = counts[oldCount]!! - 1

                    map[value] = oldCount + 1
                    counts[oldCount + 1] = 1 + (counts[oldCount + 1] ?: 0)
                } else {
                    map[value] = 1
                    counts[1] = 1 + (counts[1] ?: 0)
                }
            }
            2 -> {
                if (map.containsKey(value)) {
                    val oldCount: Int = map.getValue(value)
                    counts[oldCount] = 0.coerceAtLeast(counts[oldCount]!! - 1)

                    val newCountIndex = 0.coerceAtLeast(oldCount - 1)
                    map[value] = newCountIndex
                    counts[newCountIndex] = 1 + (counts[newCountIndex] ?: 0)
                }
            }
            3 -> {
                result += if (counts.getOrDefault(value, 0) > 0) 1 else 0
            }
            else -> throw IllegalStateException("Unknown query type: $query")
        }
    }
    return result.toTypedArray()
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    val queries = Array<Array<Int>>(q, { Array<Int>(2, { 0 }) })

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val ans = freqQuery(queries)

    println(ans.joinToString("\n"))
}
