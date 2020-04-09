package com.hackerrank.datastructures.advanced

import java.lang.IllegalStateException
import java.util.*

data class Node(val edge: MutableList<Int>, val sum: Long = 0L) {
    operator fun plus(int: Int): Node {
        edge.add(int)
        return this
    }
}


fun main() {
    val scan = Scanner(System.`in`)
    val graph: MutableMap<Int, Node> = mutableMapOf()
    val n = scan.nextInt()
    val q = scan.nextInt()

    fun searchPath(from: Int, to: Int, sum: Long = 0): Long {
        println("Search path from $from to $to")
        return when {
            from == to -> {
                graph.getValue(from).sum
            }
            graph.getValue(from).edge.isEmpty() -> {
                -1
            }
            else -> {
                graph.getValue(from).edge.map {
                    graph.getValue(from).sum + searchPath(to, it)
                }.max() ?: -1
            }
        }
    }

    (0 until (n - 1)).forEach {
        println("Read n: $it -> $n")
        val origin = scan.nextInt()
        val destiny = scan.nextInt()
        graph[origin] = (graph.getOrDefault(origin, Node(mutableListOf(), 1 + it.toLong()))) + destiny
        graph[destiny] = (graph.getOrDefault(destiny, Node(mutableListOf(), 1 + it.toLong())))
    }
    println(graph)

    (0 until q).forEach {
        println("Read q: $it -> $q")
        val type = scan.nextInt()
        when (type) {
            1 -> {
                val type = scan.nextLine().split(" ")
            }
            2 -> {
                val from = scan.nextInt()
                val to = scan.nextInt()
                val sum = searchPath(from, to)
                println(sum)
            }
            else -> {
                throw IllegalStateException("Unknown type $type")
            }
        }
    }

    println(graph)
}