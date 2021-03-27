package com.hackerrank.algorithms.implementation

import groovy.transform.ToString
import spock.lang.Specification
import spock.lang.Unroll

class QueensAttackIITest extends Specification {

    def "Sample 0"() {
        expect:
        List<XY> obstables = []
        QueensAttackIIKt.queensAttack(4, 0, 4, 4, obstables) == 9
    }


    def "Sample 1"() {
        expect:
        List<XY> obstables = [
            new XY(5, 5),
            new XY(4, 2),
            new XY(2, 3)
        ]
        QueensAttackIIKt.queensAttack(5, 3, 4, 3, obstables) == 10
    }

    def "My Sample 0"() {
        expect:
        List<XY> obstables = []
        QueensAttackIIKt.queensAttack(5, 0, 4, 4, obstables) == 14
    }

    def "My Sample 1"() {
        expect:
        List<XY> obstables = [
            new XY(5, 5),
            new XY(1, 2),
            new XY(2, 2),
            new XY(5, 1),
            new XY(2, 4)
        ]
        QueensAttackIIKt.queensAttack(5, 0, 3, 3, obstables) == 10
    }

    def "My Sample 2, same diagonal"() {
        expect:
        List<XY> obstables = [
             new XY(4, 4),
             new XY(5, 5),
        ]
        QueensAttackIIKt.queensAttack(5, 0, 3, 3, obstables) == 14
    }

    def "Drawing"() {
        def input = readInput("input06.txt")
        File resource = new File("sample_06.out")
        resource.text = QueensAttackIIKt.csv(input.n, input.k, input.r_q, input.c_q, input.obstacles)
        expect:
        QueensAttackIIKt.queensAttack(input.n, input.k, input.r_q, input.c_q, input.obstacles) == 40
    }


    @Unroll
    def "++ diagonals x: #x y: #y n: #n = #dist"() {
        expect:
        def a = new XY(x, y)

        a.posPosDiagonalDistance(n) == dist
        where:
        x | y | n || dist
        1 | 1 | 5 || 4
        1 | 3 | 5 || 2
        4 | 3 | 5 || 1
        5 | 3 | 5 || 0
        5 | 5 | 5 || 0
        1 | 5 | 5 || 0
    }

    @Unroll
    def "+- diagonals x: #x y: #y n: #n = #dist"() {
        expect:
        def a = new XY(x, y)

        a.posNegDiagonalDistance(n) == dist
        where:
        x | y | n || dist
        1 | 1 | 5 || 0
        1 | 3 | 5 || 2
        4 | 3 | 5 || 1
        5 | 3 | 5 || 0
        5 | 5 | 5 || 0
        1 | 5 | 5 || 4
    }

    @Unroll
    def "-+ diagonals x: #x y: #y n: #n = #dist"() {
        expect:
        def a = new XY(x, y)

        a.negPosDiagonalDistance(n) == dist
        where:
        x | y | n || dist
        1 | 1 | 5 || 0
        1 | 3 | 5 || 0
        4 | 3 | 5 || 2
        5 | 3 | 5 || 2
        5 | 5 | 5 || 0
        1 | 5 | 5 || 0
    }

    @Unroll
    def "-- diagonals x: #x y: #y n: #n = #dist"() {
        expect:
        def a = new XY(x, y)

        a.negNegDiagonalDistance(n) == dist
        where:
        x | y | n || dist
        1 | 1 | 5 || 0
        1 | 3 | 5 || 0
        4 | 3 | 5 || 2
        5 | 3 | 5 || 2
        5 | 5 | 5 || 4
        1 | 5 | 5 || 0
    }

    InputData readInput(String file) {
        File resource = new File(getClass().getClassLoader().getResource("QueensAttackIITest/$file").getFile())
        def values = resource
                        .readLines()
                        .collect {
                            String[] split = it.split(" ")
                            new XY(split[0] as int, split[1] as int)
                        }
        def n = values[0].x
        def k = values[0].y
        def queen =  values[1]

        new InputData(n, k, queen.x, queen.y, values.subList(2, values.size()))
    }

    @ToString
    private static class InputData {

        int n
        int k
        int r_q
        int c_q
        List<XY> obstacles

        InputData(int n, int k, int r_q, int c_q, List<XY> obstacles) {
            this.n = n
            this.k = k
            this.r_q = r_q
            this.c_q = c_q
            this.obstacles = obstacles
        }
    }
}
