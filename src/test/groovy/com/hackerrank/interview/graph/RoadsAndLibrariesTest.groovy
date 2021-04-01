package com.hackerrank.interview.graph

import spock.lang.Specification

class RoadsAndLibrariesTest extends Specification {

    def "sample test case 0"() {
        expect:
        def input =
            """
                2
                3 3 2 1
                1 2
                3 1
                2 3
                6 6 2 5
                1 3
                3 4
                2 4
                1 2
                2 3
                5 6
            """
        run(input) == [4, 12L]
    }

    def "sample test case 1"() {
        expect:
        def input =
            """
                1
                6 4 2 3
                1 2
                1 3
                4 5
                4 6
            """
        run(input) == [12L]
    }

    def "sample test case 2"() {
        expect:
        def input = """
            1
            5 3 6 1
            1 2
            1 3
            1 4
        """
        run(input) == [15L]
    }

    def "my sample test case 1"() {
        expect:
        def input =
            """
                1
                10 7 2 1
                1 2
                2 3
                3 4
                4 5
                6 7
                7 8
                8 1
            """
        // 1-2-3-4-5---8-7-6
        run(input) == [13L]
    }

    def "my sample test case 2"() {
        expect:
        def input =
            """
                1
                5 2 2 1
                1 2
                3 5
            """
        run(input) == [8L]
    }

    def "test case 10"() {
        expect:
        def result = RoadsAndLibrariesKt.roadsAndLibrariesMain(getClass().getClassLoader().getResource("RoadsAndLibraries/input10.txt").newInputStream())
        result == [5649516L, 8432327200L, 5948772399L, 1713294016L, 7902963560L, 7246913654L, 5405604L, 1739991079L, 787818609L, 9896100000L]
    }

    def "test case 10 - 3"() {
        expect:
        def result = RoadsAndLibrariesKt.roadsAndLibrariesMain(getClass().getClassLoader().getResource("RoadsAndLibraries/input10_3.txt").newInputStream())
        result == [5948772399L]
    }

    List<Long> run(String input) {
        RoadsAndLibrariesKt.roadsAndLibrariesMain(new ByteArrayInputStream(input.getBytes('UTF-8')))
    }
}
