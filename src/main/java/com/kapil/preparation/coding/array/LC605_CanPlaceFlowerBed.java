package com.kapil.preparation.coding.array;

/*
 * https://leetcode.com/problems/can-place-flowers/
 *
 *  You have a long flowerbed in which some of the plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
 * and an integer n, return if n new flowers can be planted in the flowerbed without violating the
 * no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 *
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 *
 * Company: LinkedIn
 * */
public class LC605_CanPlaceFlowerBed {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] != 0) continue;

            if ((i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
        }

        return count >= n;
    }

    public static void main(String[] args) {
//        int[] flowerbeds = {1, 0, 0, 0, 0, 1, 0, 0};
        int[] flowerbeds = {1};
        System.out.println("Can we place flowerbed? " + canPlaceFlowers(flowerbeds, 0));
    }
}
