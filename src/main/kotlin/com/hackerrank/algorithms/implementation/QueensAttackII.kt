package com.hackerrank.algorithms.implementation

import java.util.Scanner
import kotlin.math.absoluteValue

val direcctions = listOf<List<Int>>(
    listOf(1, 0),
    listOf(-1, 0),
    listOf(0, 1),
    listOf(0, -1),
    listOf(1, 1),
    listOf(-1, 1),
    listOf(1, -1),
    listOf(-1, -1)
)

// Complete the queensAttack function below.
fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: List<XY>): Int {
    val queen = XY(r_q, c_q)
    val unblockDistance =
        queen.posPosDiagonalDistance(n) +
            queen.posNegDiagonalDistance(n) +
            queen.negPosDiagonalDistance(n) +
            queen.negNegDiagonalDistance(n) +
            queen.rightDistance(n) +
            queen.leftDistance() +
            queen.upDistance(n) +
            queen.downDistance()
    val closest = mutableMapOf<String, Int>()
    obstacles.forEach {
        val miss = miss(queen, it, n)
        println("$queen || $it : $miss")
        closest[miss.direction] = maxOf(closest[miss.direction] ?: 0, miss.value)

    }
    val missed = closest.values.sum()
    println(closest)
    return unblockDistance - missed
}

fun queensAttackBrute(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: List<XY>): Int {
    var result = 0;
    direcctions.forEach { dir ->
        for (it in 1 until n) {
            val pos = XY(r_q + dir[0] * it, c_q + dir[1] * it)
            if (pos.notValid(n) || obstacles.contains(pos)) {
                break
            }
            ++result
        }
    }
    return result
}

data class MissResult(val direction: String, val value: Int)

fun miss(queen: XY, block: XY, n: Int): MissResult {
    val dist = block - queen
    when {
        dist.left() -> {
            return MissResult("l", block.y)
        }
        dist.right() -> {
            return MissResult("r", n - block.y + 1)
        }
        dist.up() -> {
            return MissResult("u", n - block.x + 1)
        }
        dist.down() -> {
            return MissResult("d", block.x)
        }
        dist.posPos() -> {
            return MissResult("++", Math.min(n - block.x, n - block.y) + 1)
        }
        dist.posNeg() -> {
            return MissResult("+-", Math.min(n - block.x + 1, block.y))
        }
        dist.negNeg() -> {
            return MissResult("--", Math.min(block.y, block.x))
        }
        dist.negPos() -> {
            return MissResult("-+", Math.min(block.x, n - block.y + 1))
        }
        else -> {
            return MissResult("out", 0)
        }
    }
}

data class XY(val x: Int, val y: Int) {
    fun notValid(n: Int): Boolean {
        return x < 1 || y < 1 || x > n || y > n
    }

    operator fun minus(o: XY): XY {
        return XY(x - o.x, y - o.y)
    }

    private fun isDiagonal(): Boolean = x.absoluteValue == y.absoluteValue
    fun posPos(): Boolean = isDiagonal() && x > 0 && y > 0
    fun posNeg(): Boolean = isDiagonal() && x > 0 && y < 0
    fun negPos(): Boolean = isDiagonal() && x < 0 && y > 0
    fun negNeg(): Boolean = isDiagonal() && x < 0 && y < 0

    fun left() = x == 0 && y < 0
    fun right() = x == 0 && y > 0
    fun up() = y == 0 && x > 0
    fun down() = y == 0 && x < 0

    fun posPosDiagonalDistance(n: Int): Int {
        return Math.min(
            (n - y).absoluteValue,
            (n - x).absoluteValue
        )
    }

    fun posNegDiagonalDistance(n: Int): Int {
        return Math.min(
            (y - 1),
            (n - x).absoluteValue
        )
    }

    fun negPosDiagonalDistance(n: Int): Int {
        return Math.min(
            (n - y).absoluteValue,
            (x - 1).absoluteValue
        )
    }

    fun negNegDiagonalDistance(n: Int): Int {
        return Math.min(x, y) - 1
    }

    fun rightDistance(n: Int) = (n - x).absoluteValue
    fun leftDistance() = (y - 1).coerceAtLeast(0)
    fun upDistance(n: Int) = (n - y).absoluteValue
    fun downDistance() = (x - 1).coerceAtLeast(0)

    constructor(from: List<Int>) : this(from[0], from[1])
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val r_qC_q = scan.nextLine().split(" ")

    val r_q = r_qC_q[0].trim().toInt()

    val c_q = r_qC_q[1].trim().toInt()

    val obstacles: List<XY> = (0 until k).map {
        val map: List<Int> = scan.nextLine().split(" ").map { it.trim().toInt() }
        XY(map)
    }

    val result = queensAttack(n, k, r_q, c_q, obstacles)

    println(result)
}


fun draw(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: List<XY>):String {
    val queen = XY(r_q, c_q)
    val s: String = buildString {
        (1 .. n).forEach { col ->
            (1 .. n).forEach { row ->
                val pos = XY(col, row)
                if(queen == pos) {
                    append("|Q")
                } else if(obstacles.contains(pos)) {
                    append("|X")
                } else {
                    append("| ")
                }
            }
            append("|\n")
        }
    }

    return s
}

fun csv(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: List<XY>): String {
    val queen = XY(r_q, c_q)
    val s: String = buildString {
        (1 .. n).forEach { col ->
            (1 .. n).forEach { row ->
                val pos = XY(col, row)
                if(queen == pos) {
                    append("Q,")
                } else if(obstacles.contains(pos)) {
                    append("X,")
                } else {
                    append(",")
                }
            }
            append(",\n")
        }
    }

    return s
}