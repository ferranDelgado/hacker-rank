package com.hackerrank.interview.arrays


import spock.lang.Specification

class MinimumSwaps2 extends Specification {

    def "Sample 0"() {
        expect:
        Integer[] input = [4, 3, 1, 2]
        MinimumSwaps2Kt.minimumSwaps(input) == 3
    }

    def "Sample 1"() {
        expect:
        Integer[] input = [2, 3, 4, 1, 5]
        MinimumSwaps2Kt.minimumSwaps(input) == 3
    }

    def "Sample 2"() {
        expect:
        Integer[] input = [1, 3, 5, 2, 4, 6, 7]
        MinimumSwaps2Kt.minimumSwaps(input) == 3
    }
}
