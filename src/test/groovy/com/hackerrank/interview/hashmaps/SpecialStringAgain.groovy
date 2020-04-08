package com.hackerrank.interview.hashmaps

import com.hackerrank.interview.string.SherlockAndTheValidStringKt
import com.hackerrank.interview.string.SpecialStringAgainKt
import spock.lang.Specification
import spock.lang.Unroll

class SpecialStringAgain extends Specification {

    @Unroll
    def "count substr of #input"() {

        expect:
        SpecialStringAgainKt.substrCount(input) == result

        where:
        input     || result
        "asasd"   || 7
        "abcbaba" || 10
        "aaaa"    || 10
    }


    @Unroll
    def "is #input special"() {

        expect:
        SpecialStringAgainKt.isSpecial(input) == result

        where:
        input   || result
        "asa"   || true
        "aasa"  || true
        "asasd" || false
        "as"    || false
    }
}
