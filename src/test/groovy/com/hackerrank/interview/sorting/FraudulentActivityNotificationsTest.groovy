package com.hackerrank.interview.sorting

import spock.lang.Specification

class FraudulentActivityNotificationsTest extends Specification{

    def "Sample input 0"() {
        def input = [2, 3, 4, 2, 3, 6, 8, 4, 5]

        expect:
        FraudulentActivityNotificationsKt.activityNotifications(input, 5) == 2
    }

    def "sample test case 1"(){
        def input = [1, 2, 3, 4, 4]

        expect:
        FraudulentActivityNotificationsKt.activityNotifications(input, 4) == 0
    }


    def "trailing data "() {
        def list = new TrailingData(3, [1, 2, 3, 4, 5, 6, 7])

        expect:
        list.median() == 2
    }

    def "adding should shift the median "() {
        def list = new TrailingData(3, [1, 2, 3, 4, 5, 6, 7])

        expect:
        list.add(4)
        list.median() == 3
    }

    def "add sorted at last"() {
        def list = new TrailingData(3, [1, 3, 2])

        expect:
        list.addSorted(4)
        list.sortedValues == [1, 2, 3, 4]
    }

    def "add sorted beginning"() {
        def list = new TrailingData(3, [10, 3, 2])

        expect:
        list.addSorted(0)
        list.sortedValues == [0, 2, 3, 10]
    }

    def "add sorted middle"() {
        def list = new TrailingData(3, [10, 3, 2])

        expect:
        list.addSorted(5)
        list.sortedValues == [2, 3, 5, 10]
    }

    def "always the same value"() {
        def list = new TrailingData(4, [2, 2, 2, 2])

        expect:
        list.addSorted(5)
        list.sortedValues == [2, 2, 2, 2, 5]
    }

    def "repeated values"() {
        def list = new TrailingData(10, [2, 2, 2, 2, 3, 3, 4, 4, 6, 6])

        expect:
        list.addSorted(5)
        list.sortedValues == [2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6]
    }

    def "repeated values, inserted at the beginning"() {
        def list = new TrailingData(10, [2, 2, 2, 2, 3, 3, 4, 4, 6, 6])

        expect:
        list.addSorted(1)
        list.sortedValues == [1, 2, 2, 2, 2, 3, 3, 4, 4, 6, 6]
    }

    def "index of first value"() {
        def list = new TrailingData(5, [1, 2, 3, 4, 5])

        expect:
        list.indexOfSorted(1) == 0
    }

    def "index of last value"() {
        def list = new TrailingData(5, [1, 2, 3, 4, 5])

        expect:
        list.indexOfSorted(5) == 4
    }

    def "index of value in the middle"() {
        def list = new TrailingData(5, [1, 2, 3, 4, 5])

        expect:
        list.indexOfSorted(3) == 2
    }

    def "index of value in the middle right"() {
        def list = new TrailingData(5, [1, 2, 3, 4, 5])

        expect:
        list.indexOfSorted(4) == 3
    }

    def "index of value in the middle left"() {
        def list = new TrailingData(5, [1, 2, 3, 4, 5])

        expect:
        list.indexOfSorted(2) == 1
    }

    def "index of missing value"() {
        def list = new TrailingData(5, [1, 2, 3, 4, 5])

        expect:
        list.indexOfSorted(50) == -1
    }
}
