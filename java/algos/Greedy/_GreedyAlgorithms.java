package algos.Greedy;

import java.util.Arrays;

public class _GreedyAlgorithms {

    /**
     * Example 1: Assign Cookies.
     *
     * Given the greed factor of each child (g) and the size of available cookies (s),
     * we want to maximize the number of satisfied children.
     *
     * @param g Array representing the greed factor of each child.
     * @param s Array representing the size of available cookies.
     * @return The maximum number of children that can be satisfied.
     */
    public static int assignCookies(int[] g, int[] s) {
        // Sort the arrays in descending order to distribute larger cookies to greedier children
        Arrays.sort(g);
        Arrays.sort(s);
        
        int i = g.length - 1; // Index for greed factor
        int j = s.length - 1; // Index for available cookies
        int satisfiedChildren = 0;

        // Greedily assign cookies to maximize satisfied children
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                satisfiedChildren++;
                i--;
            }
            j--;
        }

        return satisfiedChildren;
    }

    /**
     * Example 2: Jump Game.
     *
     * Given an array representing the maximum jump length at each position,
     * determine if it is possible to reach the last index.
     *
     * @param nums Array representing the maximum jump length at each position.
     * @return True if it is possible to reach the last index, false otherwise.
     */
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;

        // Iterate backward to find the leftmost position that can reach the last index
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }

        // If the leftmost position is the first index, it is possible to reach the last index
        return lastPos == 0;
    }

    /**
     * Example 3: Minimum Number of Arrows to Burst Balloons.
     *
     * Given an array representing the start and end coordinates of balloons,
     * find the minimum number of arrows needed to burst all balloons.
     *
     * @param points Array representing the start and end coordinates of balloons.
     * @return The minimum number of arrows needed to burst all balloons.
     */
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort the points based on the end coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];

        // Greedily shoot arrows to burst balloons
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }

    /**
     * Example 4: Non-overlapping Intervals.
     *
     * Given an array representing the start and end coordinates of intervals,
     * find the minimum number of intervals to remove to make the rest non-overlapping.
     *
     * @param intervals Array representing the start and end coordinates of intervals.
     * @return The minimum number of intervals to remove to make the rest non-overlapping.
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort the intervals based on the end coordinates
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int nonOverlappingIntervals = 1;
        int end = intervals[0][1];

        // Greedily select non-overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                nonOverlappingIntervals++;
                end = intervals[i][1];
            }
        }

        return intervals.length - nonOverlappingIntervals;
    }

    /**
     * Example 5: Fractional Knapsack Problem.
     *
     * Given the weights and values of items, and the maximum weight the knapsack can hold,
     * find the maximum value that can be obtained from the knapsack.
     *
     * @param weights  Array representing the weights of items.
     * @param values   Array representing the values of items.
     * @param capacity The maximum weight the knapsack can hold.
     * @return The maximum value that can be obtained from the knapsack.
     */
    public static double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        // Calculate the value-to-weight ratios for each item
        double[] valuePerWeight = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            valuePerWeight[i] = (double) values[i] / weights[i];
        }

        // Sort items based on value-to-weight ratios in descending order
        Integer[] indices = new Integer[weights.length];
        for (int i = 0; i < weights.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Double.compare(valuePerWeight[b], valuePerWeight[a]));

        double maxValue = 0;

        // Greedily fill the knapsack with items
        for (int index : indices) {
            if (weights[index] <= capacity) {
                maxValue += values[index];
                capacity -= weights[index];
            } else {
                // Fractional part of the item can be included
                maxValue += valuePerWeight[index] * capacity;
                break;
            }
        }

        return maxValue;
    }

    /**
     * Example 6: Huffman Coding.
     *
     * Given an array representing the frequencies of characters,
     * encode the string using Huffman coding.
     *
     * @param frequencies Array representing the frequencies of characters.
     * @return The encoded string using Huffman coding.
     */
    public static String huffmanCoding(int[] frequencies) {
        // Implementation of Huffman coding to compress data
        // (Insert your greedy algorithm code here)
        return ""; // Placeholder return value
    }

    public static void main(String[] args) {
        // Example 1: Assign Cookies
        int[] greedFactors = {1, 2, 3};
        int[] cookieSizes = {1, 1};
        System.out.println("Max Satisfied Children: " + assignCookies(greedFactors, cookieSizes)); // Output: 1

        // Example 2: Jump Game
        int[] jumpArray = {2, 3, 1, 1, 4};
        System.out.println("Can Jump to End: " + canJump(jumpArray)); // Output: true

        // Example 3: Minimum Number of Arrows to Burst Balloons
        int[][] balloonCoordinates = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println("Min Arrows to Burst Balloons: " + findMinArrowShots(balloonCoordinates)); // Output: 2

        // Example 4: Non-overlapping Intervals
        int[][] intervalCoordinates = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Min Intervals to Remove: " + eraseOverlapIntervals(intervalCoordinates)); // Output: 1

        // Example 5: Fractional Knapsack Problem
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int knapsackCapacity = 50;
        System.out.println("Max Value from Knapsack: " + fractionalKnapsack(weights, values, knapsackCapacity)); // Output: 240.0

    }
}
