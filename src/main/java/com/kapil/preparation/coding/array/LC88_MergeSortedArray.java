package com.kapil.preparation.coding.array;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/merge-sorted-array/description/
 * Easy
 * */
public class LC88_MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
//        merge(nums1, m, nums2, n);
//        merge2(nums1, m, nums2, n);
        merge3(nums1, m, nums2, n);
    }

    private static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        System.out.println(Arrays.toString(nums1));
    }

    // O((m + n)log(m + n))
    private static void merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++){
            nums1[i] = nums2[j];
            i++;
        }

        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mix = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                mix[k] = nums1[j];
                i++;
            } else {
                mix[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            mix[k] = nums1[i];
            i++;
            k++;
        }

        while( j < n) {
            mix[k] = nums2[j];
            j++;
            k++;
        }

        System.arraycopy(mix, 0, nums1, 0, mix.length);
        System.out.println(Arrays.toString(nums1));
    }
}
