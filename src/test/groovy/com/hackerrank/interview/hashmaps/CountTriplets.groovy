package com.hackerrank.interview.hashmaps


import spock.lang.Specification

class CountTriplets extends Specification {

    def "sample test 1"() {
        given:
        Long[] input = [1, 2, 2, 4]
        Long r = 2

        expect:
        CountTripletsKt.countTriplets(input, r) == 2
    }

    def "Sample input 1"() {
        given:
        Long[] input = [1, 3, 9, 9, 27, 81]
        Long r = 3

        expect:
        CountTripletsKt.countTriplets(input, r) == 6
    }

    def "Sample input 1.2"() {
        given:
        Long[] input = [1, 3, 5, 9, 9, 27, 81]
        Long r = 3

        expect:
        CountTripletsKt.countTriplets(input, r) == 6
    }

    def "Sample input 1.3"() {
        given:
        Long[] input = [1, 3, 3, 9, 9]
        Long r = 3

        expect:
        CountTripletsKt.countTriplets(input, r) == 4
    }

    def "Sample input 2"() {
        given:
        Long[] input = [1, 5, 5, 25, 125]
        Long r = 5

        expect:
        CountTripletsKt.countTriplets(input, r) == 4
    }


    def "Sample input 2.1"() {
        given:
        Long[] input = [1, 5, 5, 32, 25, 125, 5]
        Long r = 5

        expect:
        CountTripletsKt.countTriplets(input, r) == 6
    }

    def "Test case 2. r = 1"() {
        given:
        Long[] input = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        Long r = 1

        expect:
        CountTripletsKt.countTriplets(input, r) == 161700
    }

    def "Test case 2.1: r = 1"() {
        given:
        Long[] input = [2, 2, 2]
        Long r = 1

        expect:
        CountTripletsKt.countTriplets(input, r) == 1
    }

    def "Test case 2.2: r = 1"() {
        given:
        Long[] input = [2, 2, 2, 3, 3, 3, 4, 4, 4]
        Long r = 1

        expect:
        CountTripletsKt.countTriplets(input, r) == 3
    }

    def "Test case 2.1"() {
        given:
        Long[] input = [1, 2, 3, 4, 5]
        Long r = 1

        expect:
        CountTripletsKt.countTriplets(input, r) == 0
    }
}
