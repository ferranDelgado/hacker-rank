package com.hackerrank.interview.warmup

import com.hackerrank.interview.warmup.SockMerchantKt
import spock.lang.Specification

class SockMerchant extends Specification {

    def "count substr of #input"() {
        expect:
        Integer[] input = [10, 20, 20, 10, 10, 30, 50, 10, 20]
        SockMerchantKt.sockMerchant(input) == 3
    }
}
