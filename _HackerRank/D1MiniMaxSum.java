/**
 * https://www.hackerrank.com/challenges/one-week-preparation-kit-mini-max-sum/
 * 
 * !!Description: SPECIFIES LONG INTEGER, OTHERWISE TEST CASES DON'T WORK
 * 
 * Write a Java method called 'findMinMax' that takes a List of integers as
 * input and prints the minimum and maximum values in the list separated by space.
 *
 */

package _HackerRank;

import java.util.*;

public class D1MiniMaxSum {
    public static void miniMaxSum(List<Integer> arr) {
        long sum = 0;
        long min = Long.MAX_VALUE; // min of num and min, num will always initially be min
        long max = Long.MIN_VALUE; // max of num and min, num will always initially be max

        for (int num : arr) {
            sum += num;
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        long minAns = sum - max;
        long maxAns = sum - min;

        System.out.println(minAns + " " + maxAns);
    }

    public static void main(String[] args) {
        // Test Case 1
        List<Integer> arr1 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.print("Test Case 1: ");
        D1MiniMaxSum.miniMaxSum(arr1);

        // Test Case 2
        List<Integer> arr2 = Arrays.asList(5, 10, 15, 20, 25);
        System.out.print("Test Case 2: ");
        D1MiniMaxSum.miniMaxSum(arr2);

        // Test Case 3
        List<Integer> arr3 = Arrays.asList(3, 7, 1, 8, 4);
        System.out.print("Test Case 3: ");
        D1MiniMaxSum.miniMaxSum(arr3);

        // Test Case 4
        List<Integer> arr4 = Arrays.asList(-2, 0, 5, -1, 2);
        System.out.print("Test Case 4: ");
        D1MiniMaxSum.miniMaxSum(arr4);

        // Test Case 5
        List<Integer> arr5 = Arrays.asList(100, 200, 300, 400, 500);
        System.out.print("Test Case 5: ");
        D1MiniMaxSum.miniMaxSum(arr5);
    }
}
