package com.hackerrank.sorting

import spock.lang.Specification

class SortingComparatorTest extends Specification {

    def "Sample input"() {
        Player[] input = [
            new Player("amy", 100),
            new Player("david", 100),
            new Player("heraldo", 50),
            new Player("aakansha", 75),
            new Player("aleksa", 150)
        ]

        expect:
        Arrays.sort(input, new Checker())
        input[0] == new Player("aleksa", 150)
        input[1] == new Player("amy", 100)
        input[2] == new Player("david", 100)
        input[3] == new Player("aakansha", 75)
        input[4] == new Player("heraldo", 50)
    }

    def "1. Decreasing score"() {
        Player[] input = [
            new Player("amy", 100),
            new Player("david", 80),
            new Player("heraldo", 50),
            new Player("aakansha", -11)
        ]

        expect:
        Arrays.sort(input, new Checker())
        input[0].score == 100
        input[1].score == 80
        input[2].score == 50
        input[3].score == -11
    }

    def "2. alphabetically ascending"() {
        Player[] input = [
            new Player("amy", 100),
            new Player("heraldo", 100),
            new Player("david", 100),
            new Player("aakansha", 100)
        ]

        expect:
        Arrays.sort(input, new Checker())
        input[0].name == "aakansha"
        input[1].name == "amy"
        input[2].name == "david"
        input[3].name == "heraldo"
    }
}
