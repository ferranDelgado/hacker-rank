package com.hackerrank.interview.graph

import spock.lang.Specification

class RoadsAndLibrariesTest extends Specification {


    def "tes case 2"(){
        expect:
        RoadsAndLibrariesKt.roadsAndLibraries(5, 6, 1, [[1, 2], [1, 3], [1, 4]]) == 15
    }

    def "sample 1"(){
        expect:
        RoadsAndLibrariesKt.roadsAndLibraries(3, 2, 1, [[1, 2], [3, 1], [2, 3]]) == 4
    }

    def "sample 2"(){
        expect:
        RoadsAndLibrariesKt.roadsAndLibraries(6, 2, 5, [[1, 3], [3, 4], [2, 4], [1, 2], [2, 3], [5, 6]]) == 12
    }

    def "all connected with merge"() {
        def components = RoadsAndLibrariesKt.connectedComponents([[1, 2], [2, 4], [5, 3], [3, 4]])

        expect:
        components.size() == 1
        components[0].cities.keySet().containsAll([1, 2, 3, 4, 5])
    }

    def "2 components"() {
        def components = RoadsAndLibrariesKt.connectedComponents([[1, 2], [2, 4], [5, 3], [3, 8]])
        def expectedComponent1 = [1, 2, 4]
        def expectedComponent2 = [3, 5, 8]
        expect:
        components.size() == 2
        def component1 = components.find { it.containsAny(expectedComponent1) }
        component1.cities.keySet().containsAll(expectedComponent1)
        expectedComponent2.forEach {
            assert !component1.cities.keySet().contains(it)
        }


        def component2 = components.find { it.containsAny(expectedComponent2) }
        component2.cities.keySet().containsAll(expectedComponent2)

        expectedComponent1.forEach {
            assert !component2.cities.keySet().contains(it)
        }
    }
}
