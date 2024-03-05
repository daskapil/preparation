package com.kapil.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {

    public static void main(String[] args) {
//        array1D();
        array2D();
    }

    private static void array1D() {
        Scanner scanner = new Scanner(System.in);

        //array of primitives
        int[] arrInt = new int[4];

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arrInt));

        //array of objects
        String[] arr = new String[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.next();
        }

        System.out.println(Arrays.toString(arr));
    }


    private static void array2D() {
//        int[][] arr = new int[3][];
        int[][] arr = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };
        System.out.println(Arrays.toString(arr[0]));
        System.out.println(arr.length);

        Scanner scanner = new Scanner(System.in);

        int[][] arr2D = new int[3][3];
        System.out.println(arr2D.length);

        //input
        for (int row = 0; row < arr2D.length; row++) {
            //for each column in each row
            for (int column = 0; column < arr2D[row].length; column++) {
                arr2D[row][column] = scanner.nextInt();
            }
        }

        //output
//        for (int row = 0; row < arr2D.length; row++) {
//            //for each column in each row
//            for (int column = 0; column < arr2D[row].length; column++) {
//                System.out.print(arr2D[row][column] + " ");
//            }
//            System.out.println();
//        }

        for (int[] a : arr2D) {
            System.out.println(Arrays.toString(a));
        }
    }
}
