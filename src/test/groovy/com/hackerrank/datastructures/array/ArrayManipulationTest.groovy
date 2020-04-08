package com.hackerrank.datastructures.array

import spock.lang.Specification

class ArrayManipulationTest extends Specification {

    def "sample test 3"() {
        given:
        Integer[][] input = [
                [2, 6, 8],
                [3, 5, 7],
                [1, 8, 1],
                [5, 9, 15]
        ]

        expect:
        ArrayManipulationKt.arrayManipulation(10, input) == 31
    }

    def "easy test"() {
        given:
        Integer[][] input = [
                [1, 2, 100],
                [2, 5, 100],
                [2, 2, 100],
                [3, 4, 100]
        ]
        expect:
        ArrayManipulationKt.arrayManipulation(5, input) == 300
    }

    def "stupid and long"() {
        given:
        Integer[][] input = [
                [1, 1_000_0000, 100],
                [1, 1_000_0000, 100],
                [1, 1_000_0000, 100]
        ]
        expect:

        ArrayManipulationKt.arrayManipulation(1_000_0001, input) == 300
    }

}
