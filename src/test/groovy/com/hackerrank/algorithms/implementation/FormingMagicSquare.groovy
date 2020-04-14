package com.hackerrank.algorithms.implementation

import spock.lang.Specification

class FormingMagicSquare extends Specification {

    def "Sample 0"() {
        expect:
        Integer[][] input = [
                [5, 3, 4],
                [1, 5, 8],
                [6, 4, 2],
        ]

        FormingMagicSquareKt.formingMagicSquare(input) == 7
    }

    def "Sample 1"() {
        expect:
        Integer[][] input = [
                [4, 8, 2],
                [4, 5, 7],
                [6, 1, 6],


        ]

        FormingMagicSquareKt.formingMagicSquare(input) == 4
    }

    def "Test case 7"() {

        expect:
        Integer[][] input = [
                [6, 1, 2],
                [7, 2, 6],
                [5, 6, 2]
        ]

        FormingMagicSquareKt.formingMagicSquare(input) == 18
    }

}
