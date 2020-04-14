package com.hackerrank.interview.greedy

import spock.lang.Specification

class MinMax extends Specification {

    def "Sample 0"() {
        expect:
        Integer[] input = [10, 100, 300, 200, 1000, 20, 30]

        MinMaxKt.maxMin(3, input) == 20
    }

    def "Sample 1"() {
        expect:
        Integer[] input = [1, 2, 3, 4, 10, 20, 30, 40, 100, 200]

        MinMaxKt.maxMin(4, input) == 3
    }

    def "Sample 2"() {
        expect:
        Integer[] input = [1, 2, 1, 2, 1]

        MinMaxKt.maxMin(2, input) == 0
    }

    def "test case 3"() {
        expect:
        Integer[] input = [6327, 571, 6599, 479, 7897, 9322, 4518, 571, 6677, 7432, 815, 6920, 4329, 4104, 7775, 5708, 7991, 5802, 8619, 6053, 7539, 7454, 9000, 3267, 6343, 7165, 4095, 439, 5621, 4095, 153, 1948, 1018, 6752, 8779, 5267, 2426, 9649, 2190, 9103, 7081, 3006, 2376, 7762, 3462, 151, 3471, 1453, 2305, 8442]

        MinMaxKt.maxMin(8, input) == 816
    }

    def "test case 16"() {
        expect:
        Integer[] input = [100, 200, 300, 350, 400, 401, 402]

        MinMaxKt.maxMin(3, input) == 2
    }
}
