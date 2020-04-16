package com.hackerrank.algorithms.string

import spock.lang.Specification
import spock.lang.Unroll

class BuildPalindrome extends Specification {

    @Unroll
    def "Sample 0"() {
        expect:
        BuildPalindromeKt.buildPalindrome(a, b) == s

        where:
        a      | b     || s
        "bac"  | "bac" || "aba"
        "jdfh" | "fds" || "dfhfd"
//        "a"           | "a"    || "aa"
        "naa"  | "n"   || "naan"
        "n"    | "aan" || "naan"
        "naba" | "n"   || "naban"
//        "naba"        | "aban" || "nabaaban"
    }

    def "sort"() {
        expect:
        BuildPalindromeKt.sort(["aa", "aba", "zaza"]) == "aba"
//        BuildPalindromeKt.sort(["aa", "cc"]) == "aba"
    }

}
