package com.hackerrank.interview.sorting

import java.util.LinkedList
import java.util.Queue
import java.util.Scanner


class TrailingData(private val size: Int, initialValues: List<Int>) {

    private val values: Queue<Int>
    private var sortedValues: MutableList<Int>
    private val medianFn: () -> Double

    init {
        check(initialValues.size >= size) { "Initial list smaller than trailing size" }
        this.values = LinkedList(initialValues.subList(0, size))
        this.sortedValues = this.values.toMutableList()
        this.sortedValues.sort()

        val midIndex = size/2
        medianFn = if(size%2 == 0) {
            { (sortedValues[midIndex] + sortedValues[midIndex - 1]).toDouble() / 2 }
        } else {
            { sortedValues[midIndex].toDouble() }
        }
    }

    fun median(): Double = medianFn()

    fun add(value: Int) {
        val head = values.remove()
        //Wrong
        values.add(value)
        val index = indexOfSorted(head)
        sortedValues.removeAt(index)
        addSorted(value)
    }

    fun addSorted(value: Int) {
        val index = addSortedIndex(value, 0, sortedValues.size)
        sortedValues.add(index, value)
    }

    private fun addSortedIndex(value: Int, from: Int, to: Int): Int {
        val mid = from + (to - from) / 2
        return if(from == to) {
            from
        } else {
            if(sortedValues[mid] > value) {
                addSortedIndex(value, from, mid)
            } else {
                addSortedIndex(value, mid + 1, to)
            }
        }
    }

    private fun indexOfSorted(value: Int, from: Int, to: Int): Int {
        val mid = from + (to - from) / 2
        return if(from == to) {
            -1
        } else {
            when {
                sortedValues[mid] == value -> {
                    mid
                }
                sortedValues[mid] > value -> {
                    indexOfSorted(value, from, mid)
                }
                else -> {
                    indexOfSorted(value, mid + 1, to)
                }
            }
        }
    }

    fun indexOfSorted(value: Int): Int {
        return indexOfSorted(value, 0, sortedValues.size)
    }

    fun prettyPrint(): String {
        return sortedValues.toString() + " :: " + medianFn()
    }

}

// Complete the activityNotifications function below.
fun activityNotifications(expenditure: List<Int>, d: Int): Int {
    val trailingData = TrailingData(d, expenditure)
    return expenditure.subList(d, expenditure.size).map {
        val alarm = if(it >= 2*trailingData.median()) 1 else 0
//        println("$it >= ${trailingData.prettyPrint()} => $alarm")
        trailingData.add(it)
        alarm
    }.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val expenditure = scan.nextLine().split(" ").map { it.trim().toInt() }.toList()

    val result = activityNotifications(expenditure, d)

    println(result)
}