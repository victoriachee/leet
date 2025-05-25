/**
 * The _PrefixSuffix class provides functions to solve generic prefix-suffix questions.
 */
package patterns.PrefixSuffix;

import java.util.Arrays;

public class _PrefixSuffix {

    /**
     * Computes the prefix sum array for a given array of integers.
     *
     * @param nums The input array of integers.
     * @return The prefix sum array.
     */
    public static int[] computePrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return prefixSum;
    }

    /**
     * Computes the suffix sum array for a given array of integers.
     *
     * @param nums The input array of integers.
     * @return The suffix sum array.
     */
    public static int[] computeSuffixSum(int[] nums) {
        int[] suffixSum = new int[nums.length];
        suffixSum[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        return suffixSum;
    }

    /**
     * Computes the maximum subarray sum for a given array of integers.
     * The maximum subarray sum refers to the largest sum of a contiguous subarray 
     * within a given array of numbers.
     * 
     * Given [1, -2, 3, 4, -1, 2, 1, -5, 4]  
     * Contiguous subarray has the maximum sum [3, 4, -1, 2, 1] 
     * -> 3 + 4 + (-1) + 2 + 1 = 9
     * 
     * In the context of array algorithms and discussions, a "subarray" typically 
     * refers to a contiguous (or continuous) sequence of elements within the array. 
     * A subarray is formed by selecting elements from the original array such that 
     * they appear in consecutive positions.
     *
     * @param nums The input array of integers.
     * @return The maximum subarray sum.
     */
    public static int computeMaxSubarraySum(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * Main method for testing the PrefixSuffixSolver class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums = {1, -2, 3, 4, -1, 2, 5};

        // Compute and print the prefix sum
        int[] prefixSum = computePrefixSum(nums);
        System.out.println("Prefix Sum: " + Arrays.toString(prefixSum));

        // Compute and print the suffix sum
        int[] suffixSum = computeSuffixSum(nums);
        System.out.println("Suffix Sum: " + Arrays.toString(suffixSum));

        // Compute and print the maximum subarray sum
        int maxSubarraySum = computeMaxSubarraySum(nums);
        System.out.println("Maximum Subarray Sum: " + maxSubarraySum);
    }
}
