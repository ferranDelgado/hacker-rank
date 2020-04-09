package com.hackerrank.interview.hashmaps


import spock.lang.Specification

class FrequencyQueries extends Specification {


    def "sample test 1"() {
        given:
        Integer[][] input = [
                [3, 4],
                [2, 1003],
                [1, 16],
                [3, 1]
        ]
        expect:
        FrequencyQueriesKt.freqQuery(input).toList() == [0, 1]
    }

    def "sample test 2"() {
        given:
        Integer[][] input = [
                [1, 3],
                [2, 3],
                [3, 2],
                [1, 4],
                [1, 5],
                [1, 5],
                [1, 4],
                [3, 2],
                [2, 4],
                [3, 2],
        ]
        expect:
        FrequencyQueriesKt.freqQuery(input).toList() == [0, 1, 1]
    }

    def "My test 1"() {
        given:
        Integer[][] input = [
                [1, 3],
                [1, 3],
                [1, 3],
                [2, 3],
                [2, 3],
                [2, 3],
                [2, 3],
                [2, 3],
                [2, 3],
                [2, 3],
                [2, 3],
                [2, 3],
                [3, 2],
        ]
        expect:
        FrequencyQueriesKt.freqQuery(input).toList() == [0]
    }
}
