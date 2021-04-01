package com.hackerrank.interview.graph

import java.io.InputStream
import java.lang.IllegalStateException
import java.util.Scanner

data class GraphMeta(val connected: Long, val disconnectedCities: Long) {
    fun cost(cities: Int, libraryCost: Long, roadCost: Long): Long {
        val all = connected + disconnectedCities
        val oneLib: Long = all * libraryCost + (cities - all) * roadCost
        val allLibs: Long = cities.toLong() * libraryCost
        return minOf(oneLib, allLibs)
    }
}

fun connectedComponents(n: Int, cities: Map<Int, List<Int>>): Long {
    val visited = BooleanArray(n + 1)
    var connected = 0L

    fun dfs(index: Int) {
        visited[index] = true
        cities[index]?.forEach { it ->
            if (!visited[it]) {
                dfs(it)
            }
        }
    }
    (1..n).forEach {
        if (!visited[it]) {
            ++connected
            dfs(it)

        }
    }
    return connected
}

fun roadsAndLibraries(n: Int, libraryCost: Long, roadCost: Long, cities: Map<Int, List<Int>>): Long {
    return if (libraryCost < roadCost) {
        n.toLong() * libraryCost
    } else {
        val cc = connectedComponents(n, cities)
        return (cc * libraryCost) + (n - cc) * roadCost
    }
}

private fun Scanner.firstInt(): Int {
    var value: Int?
    do {
        value = nextLine().trim().toIntOrNull()
    } while (value == null && hasNextLine())

    return value ?: throw IllegalStateException("No integer found")
}

fun roadsAndLibrariesMain(inputStream: InputStream): List<Long> {
    val scan = Scanner(inputStream)

    val q = scan.firstInt()

    return (1..q).map { qItr ->
        val nmC_libC_road = scan.nextLine().trim().split(" ")

        val n = nmC_libC_road[0].trim().toInt()

        val m = nmC_libC_road[1].trim().toLong()

        val c_lib = nmC_libC_road[2].trim().toLong()

        val c_road = nmC_libC_road[3].trim().toLong()

        val cities: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        (0 until m).forEach {
            val parts = scan.nextLine().trim().split(" ")
            val a = parts[0].trim().toInt()
            val b = parts[1].trim().toInt()
            if (cities[a] == null) {
                cities[a] = mutableListOf()
            }
            if (cities[b] == null) {
                cities[b] = mutableListOf()
            }

            cities[a]!!.add(b)
            cities[b]!!.add(a)
        }

        roadsAndLibraries(n, c_lib, c_road, cities)
    }
}

fun main(args: Array<String>) {
    roadsAndLibrariesMain(System.`in`).forEach { result ->
        println(result)
    }
}