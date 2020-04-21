package com.codility.test


import spock.lang.Specification
import spock.lang.Unroll

class TravelPerk extends Specification {

    def "Sample 0"() {
        given:
        def input = [1, 3, 4, 2, 2, 2, 1, 1, 2]

        expect:
        TravelPerkKt.forTest(input)

    }

    @Unroll
    def "where #input"() {
        expect:
        TravelPerkKt.forTest(input) == result

        where:
        input                       || result
        [1, 3, 4, 2, 2, 2, 1, 1, 2] || true
        [1, 1, 1, 1, 1, 1]          || false
        [1, 1, 1, 0, 1, 2, 3, 0, 0] || true
        [1, 2, 2, 2, 1, 2, 4, 0, 0] || true
        [1, 2, 2, 4, 0, 0, 2, 1, 2] || true
        [0, 0, 3, 3, 6, 0, 6, 0]    || true
    }

    def "out of index"() {
        given:
        def input = [1, 1, 1, 1, 1]

        expect:
        TravelPerkKt.forTest(input)

    }

    def "Long test"() {
        given:
        def input = [1, 2] * 20_000

        println input
        expect:
        !TravelPerkKt.forTest(input)
    }

    def "delete 1 must sum"() {
        given:
        def input = [1, 2, 4, 1]

        expect:
        TravelPerkKt.delete1MustSum(input, 4)

    }

    def "delete 2 must sum"() {
        given:
        def input = [1, 1]

        expect:
        TravelPerkKt.delete2MustSum(input, 2)

    }
}
