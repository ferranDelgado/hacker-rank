package com.hackerrank.interview.graph

import java.util.Scanner

data class ConnectedComponent(val cities: MutableMap<Int, Boolean> = mutableMapOf()) {
    fun count(): Int = cities.keys.size

    fun addConnection(connection: List<Int>) {
        connection.forEach {
            cities[it] = true
        }
    }

    fun merge(connectedComponent: ConnectedComponent) {
        cities += connectedComponent.cities
    }

    fun cost(roadPrice: Int, libraryPrice: Int): Long {
        val oneLib = (cities.size - 1) * roadPrice + libraryPrice
        val allLibs = cities.size * libraryPrice
        return minOf(oneLib, allLibs).toLong()
    }

    fun containsAny(connection: List<Int>): Boolean {
        val find = connection.find {
            cities[it] ?: false
        }
        return find != null
    }
}

fun connectedComponents(cities: List<List<Int>>): MutableList<ConnectedComponent> {
    val components = mutableListOf<ConnectedComponent>()

    cities.forEach { connection ->
        val found = components.filter { it.containsAny(connection) }
        if(found.size == 1 || found.size == 2) {
            found[0].addConnection(connection)
        }
        when (found.size) {
            2 -> {
                found[0].merge(found[1])
                components.remove(found[1])
            }
            0 -> {
                val newComponent = ConnectedComponent()
                newComponent.addConnection(connection)
                components += mutableListOf(newComponent)
            }
        }
    }
    return components
}

// Complete the roadsAndLibraries function below.
fun roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: List<List<Int>>): Long {
    val connectedComponents = connectedComponents(cities)
    val aloneCities = maxOf(n - connectedComponents.map { it.count() }.sum(), 0)
    return connectedComponents
        .map { it.cost(roadPrice = c_road, libraryPrice = c_lib) }
        .sum() + (aloneCities * c_lib)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val nmC_libC_road = scan.nextLine().split(" ")

        val n = nmC_libC_road[0].trim().toInt()

        val m = nmC_libC_road[1].trim().toInt()

        val c_lib = nmC_libC_road[2].trim().toInt()

        val c_road = nmC_libC_road[3].trim().toInt()

        val cities = (0 until m).map {
            scan.nextLine().split(" ").map { it.trim().toInt() }
        }

        val result = roadsAndLibraries(n, c_lib, c_road, cities)

        println(result)
    }
}