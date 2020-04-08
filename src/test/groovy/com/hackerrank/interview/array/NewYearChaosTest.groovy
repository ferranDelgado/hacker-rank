package com.hackerrank.interview.array


import com.hackerrank.interview.arrays.NewYearChaosKt
import spock.lang.Specification
import spock.lang.Unroll

class NewYearChaosTest extends Specification {

    def "sample test 1"() {
        given:
        Integer[] input = [2, 1, 5, 3, 4]

        expect:
        NewYearChaosKt.minimumBribesValue(input) == 3
    }

    def "impossible state"() {
        given:
        Integer[] input = [2, 5, 1, 3, 4]

        expect:
        NewYearChaosKt.minimumBribesValue(input) == -1
    }

    def "Sample test case 1-A"() {
        given:
        Integer[] input = [5, 1, 2, 3, 7, 8, 6, 4]

        expect:
        NewYearChaosKt.minimumBribesValue(input) == -1
    }

    def "Sample test case 1-B"() {
        given:
        Integer[] input = [1, 2, 5, 3, 7, 8, 6, 4]

        expect:
        NewYearChaosKt.minimumBribesValue(input) == 7
    }

    @Unroll
    def "where #input is #result"() {
        expect:
        NewYearChaosKt.minimumBribesValue(input) == result

        where:
        input                 || result
        [1, 2, 5, 6, 7, 4, 3] || 7
        [1, 2, 5, 4, 7, 6, 3] || 6
    }
}
