package com.kapil.preparation.coding.binarysearch;

/*
 *https://leetcode.com/problems/split-array-largest-sum/
 * */
public class LC410_SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] arr = {7, 2, 5, 10, 8};
        int m = 2;

        System.out.println(splitArray(arr, 2));
    }

    /*
     * Case - 1:
     * what is minimum no. of partitions that we can make? 1
     * Partition: * [7, 2, 5, 10, 8] - only one combination
     * Sum of partition = 32
     * Max sum = 32
     * Ans: Min among of all partition max sum = 32
     *
     * Case - 2:
     * what is maximum no. of partitions that we can make? N
     * [7, 2, 5, 10, 8] => [7], [2], [5], [10], [8] - only one combination
     * max among all sum of individual sub-array = 10
     * Ans = 10
     *
     * minAns = max element in array = 10 => Lower limit
     * maxAns = sum of all element in array = 32 => Upper limit
     *
     * Answer will lay between lower and upper limit
     * Hence, apply binary search between lower and upper limit to find potential answer and split the array
     * start = 10 (Lower limit), end = 32 (Upper limit),
     * mid = (start + end) / 2 => (10 + 30) / 2 = 21 (potential answer)
     *
     * now,
     * 7 < 21 => add to sub-array => [7]
     * 7 + 2 < 21, add to sub-array => [7, 2]
     * 7 + 2 + 5 < 21, add to sub-array => [7, 2, 5]
     * 7 + 2 + 5 + 8 > 21, close first sub-array, create a new sub-array with 8 => [7, 2, 5] , [8]
     * 8 + 10 < 21, add to 2nd sub-array => [7, 2, 5] , [8, 10] => all elements are considered
     * therefore no. of pieces = 2
     *
     * now no. of pieces must be equal to given split (m)
     * if (pieces > given splits (m)) => potential answer is higher than answer
     *      therefore, potential answer will lay between start (10) and  end (20) = mid - 1
     *      mid = (10 + 20) / 2 = 15
     * else => if (pieces > given split (m)) => potential answer is lesser than answer
     *      therefore, potential answer will lay between start (16) = mid + 1 and  end (20) = previous end
     *      mid = (15 + 20) / 2 = 17
     *  and so on...
     *
     * finally start == end, Ans will be start/end
     *
     * */

    public static int splitArray(int[] nums, int m) {
        int start = 0; // minAns
        int end = 0; // maxAns

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        //binary search
        while (start < end) {
            //try the mid as potential answer
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
                    // you cannot add this in this sub-array, make new one
                    // say you add this num in new sub-array, then sum = num
                    pieces++;
                    sum = num;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end; //here start == end
    }
}
