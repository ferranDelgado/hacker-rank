package com.hackerrank.interview.warmup

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    val leftover = n % s.length
    val leftOverCount = s.substring(0, leftover.toInt()).filter { it == 'a' }.count()
    val number = s.filter { it == 'a' }.count()
    return (number * (n / s.length)) + leftOverCount
}

fun main() {
    val caseA = repeatedString("aba", 10)
    println("caseA: $caseA should be 7")

    val caseB = repeatedString("a", 1000000000000)
    println("caseB: $caseB should be 1000000000000")

    val caseC = repeatedString("cpoioipi", 1000000000000)
    println("caseC: $caseC should be 0")

    val caseD = repeatedString("baa", 10)
    println("caseD: $caseD should be 6")

    val caseF = repeatedString("baa", 2)
    println("caseF: $caseF should be 1")
}
//fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val s = scan.nextLine()
//
//    val n = scan.nextLine().trim().toLong()
//
//    val result = repeatedString(s, n)
//
//    println(result)
//}