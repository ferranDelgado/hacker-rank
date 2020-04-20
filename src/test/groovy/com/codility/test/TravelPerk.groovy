package com.codility.test


import spock.lang.Specification

class TravelPerk extends Specification {

    def "Sample 0"() {
        given:
        def input = [1, 3, 4, 2, 2, 2, 1, 1, 2]

        expect:
        TravelPerkKt.forTest(input)

    }

}
