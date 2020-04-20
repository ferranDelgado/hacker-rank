package com.codility.test

fun forTestTest(a: List<Int>) = solution(a.toIntArray())

fun solutionTest(A: IntArray): Int {
    var min = 0
    A.sort()
    val filter = A.filter { it > 0 }
    if(filter.isEmpty() || filter.first() != 1) {
        return 1
    } else {
        filter.indices.forEach {
            val diff = if (it + 1 < filter.size) A[it + 1] - A[it] else 0


            if (diff > 1 && filter[it] >= 0) {
                return filter[it] + 1
            } else if (filter[it] >= 0) {
                min = filter[it]
            }
        }
        return min + 1
    }
}
