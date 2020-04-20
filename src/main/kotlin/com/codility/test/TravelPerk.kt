package com.codility.test

fun forTest(a: List<Int>) = solution(a.toIntArray())

fun buildTree(blockSize: Int, B: List<Int>) {
    println("$B: ${B.sum()}")
    println("First path: ${B.slice(0 until 2)}")
    (0 until blockSize).forEach { firstCut ->
        val part = B.slice(0 until firstCut) + B.slice(firstCut + 1 until B.size)
        println("[$firstCut] path: ${part.slice((0 until 2))}")
        B.indices.filter { it != firstCut }.forEach { secondCut ->
            val partB = part.slice(0 until secondCut) + part.slice(secondCut + 1 until part.size)
            println("[$firstCut][$secondCut] path: ${partB.slice((0 until 2))}")
        }
    }
}

fun solution(A: IntArray): Boolean {
    val deletions = 2
    val blockSize = (A.size - deletions) / 3
    println("blockSize: $blockSize")
    val part = A.slice(0 until (blockSize + deletions))
    buildTree(blockSize, part)
    return false
}

fun <E> List<E>.delete(positionA: Int, positionB: Int, blockSize: Int = 2): List<E> {
    val leftCut = positionA.coerceAtMost(positionB)
    val rightCut = positionA.coerceAtLeast(positionB)
    val left = subList(0, leftCut)
    val middle = subList(listOf(size, leftCut + 1, rightCut).min()!!, rightCut)
    val right = subList(size.coerceAtMost(rightCut + 1), size)
    return (left + middle + right).slice(0 until size.coerceAtMost(blockSize))
}

enum class CutType {
    CUT_ONE, CUT_TWO, CUT_NONE
}

fun lastFreePos(size: Int, a: Int, b: Int): CutType {
    return when {
        a + b == (size * 2) - 1 -> {
            CutType.CUT_NONE
        }
        listOf(a, b).contains(size - 1) -> {
            CutType.CUT_ONE
        } else -> {
            CutType.CUT_TWO
        }
    }
}

/**
 * Last cut aka worker 3
 */
fun deleteOneOrNone(list: List<Int>, from: Int, to: Int, blockSize: Int, previousSum: Int? = null, cutsLeft: Int): Boolean {
    val sum = list.sum()
    (list.indices).forEach { first ->
        if(sum - list[first] == previousSum) {
            return true
        }
        return false
    }

    return false
}

fun deleteTwoOrNone(list: List<Int>, from: Int, to: Int, blockSize: Int, previousSum: Int? = null, cutsLeft: Int): Boolean {
    if (cutsLeft == 0) {
        return true
    } else {
        val sublist = list.slice((0 until list.size.coerceAtMost(blockSize + 2)))
        println("Next tree on $sublist")
        val sum = sublist.sum()
        (0 until blockSize).forEach { first ->
            sublist.indices.forEach { second ->
                if (first != second) {
                    val optB = sublist.delete(first, second, blockSize)
                    val sumB = sum - sublist[first] - sublist[second]
                    if (previousSum == sumB) {
                        println("Next -- Delete position $first and $second: $optB: $sumB")
                        when(lastFreePos(sublist.size, first, second)) {
                            CutType.CUT_ONE -> {
                                TODO()
                            }
                            CutType.CUT_TWO -> {
                                TODO()
                            }
                            CutType.CUT_NONE -> {
                                TODO()
                            }
                        }
//                        println("Next -- Delete position $first and $second: $optB: $sumB")
//                        val nextInit = lastFreePos(sublist.size, first, second)
//                        val nextList = list.subList(nextInit, list.size)
//                        println("nextList = $nextList")
//                        deleteTwoOrNone(
//                            nextList,
//                            0,
//                            blockSize + 2,
//                            blockSize,
//                            sumB,
//                            cutsLeft - 1
//                        )
                    }
                    println("-- Delete position $first and $second: $optB: $sumB")
                }
            }
        }
    }

    return false
}

fun main() {
    val size = 4
    val blockSize = 2
    val deletions = 2
    val list = listOf(1, 3, 4, 2, 2, 2, 1, 1, 2)
    println("List: $list")
    val sum = list.sum()
    println("Do not delete: ${list.slice((0 until blockSize))}: ${list.slice((0 until blockSize)).sum()}")
    deleteTwoOrNone(
        list.subList(2, list.size),
//        list.subList(2, 2 + blockSize + deletions),
        0,
        blockSize + deletions,
        blockSize,
        list.slice((0 until blockSize)).sum(),
        2
    )

//    (0 until blockSize).forEach { first ->
//        (0 until size).forEach { second ->
//            if(first != second) {
//                val optB = list.delete(first, second)
//                val sumB = sum - list[first] - list[second]
//                println("Delete position $first and $second: $optB: $sumB")
//            }
//        }
//    }
}
