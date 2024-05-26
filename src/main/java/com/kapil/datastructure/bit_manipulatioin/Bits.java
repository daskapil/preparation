package com.kapil.datastructure.bit_manipulatioin;

public class Bits {

    public static void main(String[] args) {
        getBit(5, 1);
        setBit(5, 1);
        clearBit(5, 2);
        int operation = 0; // 1 or 0
        updateBit(5, 1, operation);
    }

    // n = 5 --> 0101
    // position = 2
    //setBit => (1 << pos) AND n
    // 1 << pos --> 0001 << 2 --> 0100
    // 0100 & 0101 --> 0100 (non-zero) => 1
    private static void getBit(int n, int pos) {
        int bitMask = 1 << pos;

        if ((bitMask | n) == 0) {
            System.out.println("Bit was zero");
        } else {
            System.out.println("Bit was one");
        }
    }

    // n = 5 --> 0101
    // position = 1
    // bitMask => 1 << pos --> 0001 << 1 --> 0010
    // setBit => (1 << pos) OR n
    // 0010 | 0101 --> 0111 (7 => non-zero ) => 1
    private static void setBit(int n, int pos) {
        int bitMask = 1 << pos;
        int newNumber = bitMask | n;
        System.out.println(newNumber);
    }

    // n = 5 --> 0101
    // position = 2
    // Bit Mask => 1 << pos --> 0001 << 2 --> 0100
    // clear Bit => Operation: AND with NOT => ( NOT (1 << pos) ) AND N
    // ~(BitMask) => ~(0100) => 1011
    // 1011 & 0101 --> 0001
    private static void clearBit(int n, int pos) {
        int bitMask = 1 << pos;
        int notBitMask = ~bitMask;
        int newNumber = notBitMask & n;
        System.out.println(newNumber);
    }

    // n = 5 --> 0101
    // position = 2
    // Bit Mask => 1 << pos --> 0001 << 2 --> 0100
    // UpdateBit Operations: update 1 to 0 and O to 1
    //  setBit => (1 << pos) OR n
    // When it is 1, set to 0: clear Bit => Operation: AND with NOT => ( NOT (1 << pos) ) AND N
    // ~(BitMask) => ~(0100) => 1011
    // 1011 & 0101 --> 0001
    private static void updateBit(int n, int pos, int operation) {
        int bitMask = 1 << pos;
        if (operation == 1) {
            System.out.println(bitMask | n);
        } else {
            System.out.println(~bitMask & n);
        }
    }
}
