package com.hackerrank.interview.arrays

import com.hackerrank.interview.hashmaps.SherlockAndAnagramsKt
import spock.lang.Specification
import spock.lang.Unroll

class SherlockAndAnagrams extends Specification {

    @Unroll
    def "Sample 0"() {
        expect:
        SherlockAndAnagramsKt.sherlockAndAnagrams(input) == result
        where:
        input        || result
        "abba"       || 4
        "abcd"       || 0
        "ifailuhkqq" || 3
        "kkkk"       || 10
        "cdcd"       || 5
    }

    def "long ones"() {
        def input = "ifailuhkqqhucpoltgtyovarjsnrbfpvmupwjjjfiwwhrlkpekxxnebfrwibylcvkfealgonjkzwlyfhhkefuvgndgdnbelgruel"

        expect:
        SherlockAndAnagramsKt.sherlockAndAnagrams(input) == 399
    }
}
