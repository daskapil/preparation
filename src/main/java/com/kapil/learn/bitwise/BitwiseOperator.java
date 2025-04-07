package com.kapil.learn.bitwise;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitwiseOperator {

    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        log.info("Bitwise AND of {} and {} is {}", a, b, bitwiseAnd(a, b));
    }

    /*
     * Bitwise AND &:
     *   0 & 0 = 0
     *   0 & 1 = 0
     *   1 & 0 = 0
     *   1 & 1 = 1
     *
     *  5 = 101
     *  7 = 111
     *   5 & 7 = 101 & 111 = 101 = 5
     * */
    static int bitwiseAnd(int a, int b) {
        return a & b;
    }

    /*
     * Bitwise OR |:
     *   0 | 0 = 0
     *   0 & 1 = 0
     *   1 & 0 = 0
     *   1 & 1 = 1
     *
     *  5 = 101
     *  7 = 111
     *   5 & 7 = 101 & 111 = 101 = 5
     * */
    static int bitwiseOR(int a, int b) {
        return a & b;
    }
}
