package com.kapil.preparation.coding.math;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecimalBinary {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            int binary = decimal2Binary(i);
            log.info("Binary form of {} is {}", i, binary);
            log.info("Decimal form of {} is {}", binary, binary2Decimal(binary));
        }
    }

    private static int decimal2Binary(int decimal) {
        int binary = 0;
        int power = 1;
        while (decimal > 0) {
            binary += decimal % 2 * power;
            decimal /= 2;
            power *= 10;
        }
        return binary;
    }

    private static int binary2Decimal(int binary) {
        int decimal = 0;
        int power = 0;

        while(binary > 0) {
            decimal += (int) ((binary % 10) * Math.pow(2, power));
            binary /= 10;
            power++;
        }

        return decimal;
    }
}
