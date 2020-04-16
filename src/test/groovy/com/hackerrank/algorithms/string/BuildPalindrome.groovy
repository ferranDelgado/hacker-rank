package com.hackerrank.algorithms.string

import spock.lang.Specification
import spock.lang.Unroll

class BuildPalindrome extends Specification {

    @Unroll
    def "Sample 0"() {
        expect:
        BuildPalindromeKt.buildPalindrome(a, b) == s

        where:
        a             | b      || s
//        "bac"         | "bac"  || "aba"
//        "jdfh"        | "fds"  || "dfhfd"
//        "a"           | "a"    || "aa"
        "naaaaaaaaaa" | "n"    || "naaaaaaaaaan"
//        "naba"        | "n"    || "naban"
//        "naba"        | "aban" || "nabaaban"
    }

}
