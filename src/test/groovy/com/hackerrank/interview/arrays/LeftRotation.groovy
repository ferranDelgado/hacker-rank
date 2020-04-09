package com.hackerrank.interview.arrays


import spock.lang.Specification

class LeftRotation extends Specification {

    def "Sample 0"() {
        expect:
        Integer[] input = [1, 2, 3, 4, 5]
        LeftRotationKt.rotLeft(input, 4) == [5, 1, 2, 3, 4] as Integer[]
    }

    def "Sample 1"() {
        expect:
        Integer[] input = [1, 2, 3, 4, 5]
        LeftRotationKt.rotLeft(input, 10) == [1, 2, 3, 4, 5] as Integer[]
    }
}
