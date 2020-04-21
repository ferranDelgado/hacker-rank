package com.codility.test

fun forTest(a: List<Int>) = solution(a.toIntArray())


fun solution(A: IntArray): Boolean {
    val workersSize = (A.size - 2) / 3

    return listOf(
        noCuts(A.toList(), workersSize),
        oneCuts(A.toList(), workersSize),
        twoCuts(A.toList(), workersSize)
    ).find { it() }?.let { true } ?: false
}

fun twoCuts(list: List<Int>, workersSize: Int): () -> Boolean = {
    val leftTo = workersSize + 2
    val left = list.subList(0, leftTo)
    val middleTo: Int = leftTo + workersSize
    val middle = list.subList(leftTo, middleTo)
    val right = list.subList(middleTo, list.size)
    middle.sum() == right.sum() && left.delete2MustSum(middle.sum())
}

fun oneCuts(list: List<Int>, workersSize: Int): () -> Boolean = {
    val leftTo = workersSize + 1
    val left = list.subList(0, leftTo)
    val opt1 = {
        //middle has one cut
        val middleTo = leftTo + workersSize + 1
        val middle = list.subList(leftTo, middleTo)
        val right = list.subList(middleTo, list.size)

        val rightSum = right.sum()
        left.delete1MustSum(rightSum) && middle.delete1MustSum(rightSum)
    }

    val opt2 = {
        //right has one cut
        val middleTo = leftTo + workersSize
        val middle = list.subList(leftTo, middleTo)
        val right = list.subList(middleTo, list.size)

        val middleSum = middle.sum()
        left.delete1MustSum(middleSum) && right.delete1MustSum(middleSum)
    }
    listOf(opt1, opt2).find { it() }?.let { true } ?: false
}

fun List<Int>.delete1MustSum(sum: Int): Boolean {
    val sumToCut = sum()
    return find { sumToCut - it == sum }?.let { true } ?: false
}

fun List<Int>.delete2MustSum(sum: Int): Boolean {
    if (sum < 0) {
        return false
    }
    val set = mutableSetOf<Int>()
    return find {
        if (set.contains(it)) {
            true
        } else {
            set.add(sum - it)
            false
        }
    }?.let { true } ?: false
}

fun noCuts(list: List<Int>, workersSize: Int): () -> Boolean = {
    val workTime = list.subList(0, workersSize).sum()
    //Middle has 0 cut
    val opt1 = {
        val middle = list.subList(workersSize, workersSize * 2)
        val right = list.subList(workersSize * 2, list.size)
        workTime == middle.sum() && right.delete2MustSum(right.sum() - workTime)
    }

    //Middle has 1 cut
    val opt2 = {
        val middle = list.subList(workersSize, (workersSize * 2) + 1)
        val right = list.subList((workersSize * 2) + 1, list.size)
        middle.delete1MustSum(workTime) && right.delete1MustSum(workTime)
    }


    //Middle has 2 cut
    val opt3 = {
        val middle = list.subList(workersSize, workersSize * 2 + 2)
        val right = list.subList(workersSize * 2 + 2, list.size)
        workTime == right.sum() && middle.delete2MustSum(middle.sum() - workTime)
    }

    listOf(opt1, opt2, opt3).find { it() }?.let { true } ?: false
}