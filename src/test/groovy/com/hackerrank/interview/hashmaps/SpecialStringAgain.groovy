package com.hackerrank.interview.hashmaps


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

    def "between slow and fast"() {
        expect:
        SpecialStringAgainKt.substrCount(input) == SpecialStringAgainKt.substrCountSlow(input)

        where:
        input || nothing
        "ababcbcccbccbcacccbababbcacaaaaacbabcabcacaccabaabcaaaacacbccccaaccbcbccaccacbcaaababaacbccbbbabccbaabab" || true
        "ccacacabccacabaaaabbcbccbabcbbcaccabaababcbcacabcabacbbbccccabcbcabbaaaaabacbcbbbcababaabcbbaaababababb"  || true
        "abcaabcaacacbbaccbbabbcbbcbacbacabaaaaccacbaabccabbacabaabaaaabbccbaaaabacabcacbbabbacbcbccbbbaaabaaaca"  || true
        "abacccaacbcccaacbbcaabcbbccbccacbbcbcaaabbaababacccbacacbcbcbbccaacbbacbcbaaaacaccbcaaacbbcbbabaaacbacc"  || true
        "accbbabbcccbcbcbcbcabbccbacccbacabcaacbcaccabbacbbccccaabbacccaacbbbacbccbcaaaaaabaacaaabccbbcccaacbacbc" || true
        "caaacaacaaaacbbaaccacbcbaaaccaabcbccacaaccccacaacbcacccbcababcabacaabbcacccbacbbaaaccabbabaaccabbcbbcaab" || true
        "bcabaacabacbcabbaaabccabcacbcbabcbccbabcabbbcbacaaacaabbbabbaacbbacaccccabbabcbcabababbcbaaacbaacbacacba" || true
        "bbcacccbccbbbcbcabcabbbcaabbaccccabaabbcbcccabaacccccaaacbbbcbcacacbabaccccbcbabacaaaabcccaaccacbcbbccca" || true
        "acccbbcaaaccccaabacabcabbccaababbcabccbcaccccbaaabbbcbabaccacaabcabcbacaccbaccbbaabccbbbccaccabccbabbbcc" || true
        "baabcaabcabcbbabccbaaccabaacbbaaaabcbcabaacacbcaabbaaabaaccacbaacababcbacbaacacccacaacbacbbaacbcbbbabccb" || true
        "ababcbcccbccbcacccbababbcacaaaaacbabcabcacaccabaabcaaaacacbccccaaccbcbccaccacbcaaababaacbccbbbabccbaabab" || true

    }

    def "compare old and new"() {
        expect:
        def input = "ccccabc" //bacbcbbbcababaabcbbaaababababb"

        SpecialStringAgainKt.substrCount(input) == SpecialStringAgainKt.substrCountSlow(input)
    }

    def "longest equal"() {
        expect:
        SpecialStringAgainKt.longestEqual(input, letter as Character) == result

        where:
        input | letter || result
        "aaa" | 'a'     | 3
        "aba" | 'a'     | 1
        "aba" | 'b'     | 0
    }

    @Unroll
    def "is #input special"() {

        expect:
        SpecialStringAgainKt.isSpecial(input) == result

        where:
        input   || result
        "asa"   || true
        "aasa"  || false
        "asasd" || false
        "as"    || false
    }
}
