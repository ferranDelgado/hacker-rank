package com.codility.test

import com.codility.test.CodilityTestKt
import spock.lang.Specification

class CodelyTest extends Specification {

    def "Sample 0"() {
        given:
        def input = [1, 3, 6, 4, 1, 2]

        expect:
        CodilityTestKt.forTestTest(input) == 5

    }

    def "negative numbers"() {
        given:
        def input = [-1, -3]

        expect:
        CodilityTestKt.forTestTest(input) == 1
    }


    def "negative numbers and more"() {
        given:
        def input = [-1, -3, 1]

        expect:
        CodilityTestKt.forTestTest(input) == 2
    }

    def "negative numbers and more more"() {
        given:
        def input = [-1, -3, 1, 2]

        expect:
        CodilityTestKt.forTestTest(input) == 2
    }

    def "1 but not the first"() {
        given:
        def input = [-1, -3, 2, 4, 5, 6, 9]

        expect:
        CodilityTestKt.forTestTest(input) == 1
    }

}
