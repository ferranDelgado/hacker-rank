package com.hackerrank.algorithms.string

import spock.lang.Specification
import spock.lang.Unroll

class HigherValuePalindrom extends Specification {

    @Unroll
    def "sample: #s"() {
        expect:
        HigherValuePalindromKt.highestValuePalindrome(s, n, k) == r

        where:
        s           | n | k || r
        "3943"      | 4 | 1 || "3993"
        "092282"    | 6 | 3 || "992299"
        "0011"      | 4 | 1 || "-1"
        "99899"     | 5 | 1 || "99999"
        "11111"     | 5 | 2 || "91119"
        "1111"      | 4 | 2 || "9119"
        "9119"      | 4 | 2 || "9999"
        "123454321" | 9 | 2 || "923454329"
        "123454321" | 9 | 3 || "923494329"
        "123454321" | 9 | 5 || "993494399"
        "123454321" | 9 | 9 || "999999999"
    }


    @Unroll
    def "Sample #inFile"() {
        expect:
        InputData input = readInput(inFile)
        def out = readOutput(outFile)
        HigherValuePalindromKt.highestValuePalindrome(input.s, input.n, input.k) == out

        where:
        inFile           || outFile
        "test_08_in.txt" || "test_08_out.txt"
        "test_17_in.txt" || "test_17_out.txt"
    }

    def "Sample 08"() {
        expect:
        InputData input = readInput("test_08_in.txt")
        def out = readOutput("test_08_out.txt")
        HigherValuePalindromKt.highestValuePalindrome(input.s, input.n, input.k) == out
    }

    def "Sample 17"() {
        expect:
        InputData input = readInput("test_17_in.txt")
        def out = readOutput("test_17_out.txt")
        HigherValuePalindromKt.highestValuePalindrome(input.s, input.n, input.k) == out
    }

    InputData readInput(String file) {
        File resource = new File(getClass().getClassLoader().getResource("HigherValuePalinfrom/$file").getFile())
        def lines = resource.readLines()
        assert lines.size() == 2
        def nk = lines[0].split(" ")
        assert nk.size() == 2

        new InputData(nk[0] as int, nk[1] as int, lines[1])
    }

    String readOutput(String file) {
        File resource = new File(getClass().getClassLoader().getResource("HigherValuePalinfrom/$file").getFile())
        def lines = resource.readLines()
        assert lines.size() >= 1
        lines[0]
    }

    private static class InputData {

        int n
        int k
        String s

        InputData(int n, int k, String s) {
            this.n = n
            this.k = k
            this.s = s
        }
    }
}
