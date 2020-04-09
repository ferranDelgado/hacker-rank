package com.hackerrank.interview.hashmaps

import java.util.*

fun String.code(): String {
    val letters = mutableMapOf(
        'a' to 0,
        'e' to 0,
        'i' to 0,
        'o' to 0,
        'u' to 0,
        'b' to 0,
        'c' to 0,
        'd' to 0,
        'f' to 0,
        'g' to 0,
        'h' to 0,
        'j' to 0,
        'k' to 0,
        'l' to 0,
        'm' to 0,
        'n' to 0,
        'p' to 0,
        'q' to 0,
        'r' to 0,
        's' to 0,
        't' to 0,
        'v' to 0,
        'w' to 0,
        'x' to 0,
        'y' to 0,
        'z' to 0
    )
    forEach { letters[it] = letters.getValue(it) + 1 }
    return letters
        .values
        .joinToString(separator = "-")
}


// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {
    val dic = mutableMapOf<String, Int>()
    var count = 0
    s.indices.forEach { i ->
        val letterCode = s[i].toString().code()
        if (dic.contains(letterCode)) {
            count += (dic[letterCode] ?: 1)
        }
        (0 until i).forEach { j ->
            val subs = s.substring(j, i + 1)
            val code = subs.code()
            if (dic.contains(code)) {
                count += (dic[code] ?: 1)
            }
            dic[code] = (dic[code] ?: 0) + 1
        }

        dic[letterCode] = (dic[letterCode] ?: 0) + 1
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}
