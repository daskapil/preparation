package com.kapil.preparation.coding.array;

import java.util.Arrays;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
//        int[] result = sortedSquares(nums);
//        System.out.println(Arrays.toString(result));

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);

        System.out.println(Arrays.toString(arr));
    }

    // Squares of a Sorted Array
    // Input: nums = [-4,-1,0,3,10]
    // Output: [0,1,9,16,100]
    public static int[] sortedSquares(int[] nums) {
        int[] result = Arrays.stream(nums).map(num -> num * num).toArray();
        Arrays.sort(result);
        return result;
    }


    // Duplicate Zeros:
    //  https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
    // Input: arr = [1,0,2,3,0,4,5,0]
    //Output: [1,0,0,2,3,0,0,4]
    //Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
    //
    // Input: arr = [1,2,3]
    //Output: [1,2,3]
    //Explanation: After calling your function, the input array is modified to: [1,2,3]
    // Note that elements beyond the length of the original array are not written.
    // Do the above modifications to the input array in place and do not return anything.
    public static void duplicateZeros(int[] arr) {
        int index = 0;
        int len = arr.length;

        while (index < len) {
            if (arr[index] == 0) {
                for (int j = len - 2; j > index; j--) {
                    arr[j + 1] = arr[j];
                }
                if (++index < len) { // Incrementing the index to next index before checking next index < len;
                    arr[index] = 0;
                }
            }
            index++;
        }
    }

    //
    public static void duplicateZerosOptimized(int[] arr) {
        int possiableDups = 0;
        int length_ = arr.length - 1;

//        for (int left = 0; left < length_)


    }

}
