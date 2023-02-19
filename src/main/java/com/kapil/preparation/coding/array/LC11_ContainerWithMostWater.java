package com.kapil.preparation.coding.array;
/*
* https://leetcode.com/problems/container-with-most-water/
* */
public class LC11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length;
        int max = 0;

        while(l < r) {
            int width = r - l;
            int area = width * height[l];
            max = Math.max(max, area);


        }

        return max;
    }
}
