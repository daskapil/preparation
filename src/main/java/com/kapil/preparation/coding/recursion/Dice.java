package com.kapil.preparation.coding.recursion;

public class Dice {
    public static void main(String[] args) {
        dice(4);
    }

    private static void dice(int target) {
        dice(target, "");
    }

    private static void dice(int target, String out) {
        if (target == 0) {
            System.out.println(out);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(target - i, out + i);
        }
    }
}
