package com.hackerrank.interview.hashmaps

import com.hackerrank.interview.string.SherlockAndTheValidStringKt
import spock.lang.Specification
import spock.lang.Unroll

class SherlockAndTheValidString extends Specification {

    @Unroll
    def "is #input valid"() {

        expect:
        SherlockAndTheValidStringKt.isValid(input) == result

        where:
        input                            || result
        "abc"                            || "YES"
        "abcc"                           || "YES"
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" || "YES"
        "abccdd"                         || "NO"
        "abccc"                          || "NO"
        "aabbcd"                         || "NO"
        "abcdefghhgfedecba"              || "YES"
        "aabbccddeefghi"                 || "NO"
        "aabbcd"                         || "NO"
        "aabbc"                          || "YES"
    }
}
