/** Problem 643. Maximum Average Subarray I
 * URL: https://leetcode.com/problems/maximum-average-subarray-i/
 * ! EASY
 * #SlidingWindow  #Arrays  #Math
 *
 * Given an integer array nums of length n and an integer k,
 * Find the maximum average value of a contiguous subarray of length k.
 * Return the result with precision up to 10^-5.
 *
 * Example 1:
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 *
 * Example 2:
 * Input: nums = [5], k = 1
 * Output: 5.00000
 *
 * Constraints: n == nums.length, 1 <= k <= n <= 10^5, -10^4 <= nums[i] <= 10^4
 *
 * TC: O(n) SC: O(1)
 */

package patterns.SlidingWindow;

import java.util.Arrays;

public class MaxAvgSubarrayI {

   public static double findMaxAverage(int[] nums, int k) {
      int sum = 0;
      for (int i = 0; i < k; i++) sum += nums[i];
      int max = sum;
      // Start from the elem after the first window
      for (int i = k; i < nums.length; i++) {
         // Add new elem to sum, subtract first elem of previous window
         sum += nums[i] - nums[i - k];
         max = Math.max(max, sum);
      }
      // !IMPORTANT: Initialize as int & cast to (double) at end to reduce runtime
      return (double) max / k;
      // !!Time limit exceeded -> nested loops, need separate loops
      //// TC O(n*k) SC O(1)
      // if (k < 1) return 0.0;
      // int n = nums.length;
      // double maxSum = Integer.MIN_VALUE;
      // for (int i = 0; i < n; i++) {
      //     // Check if kth elem of window is in arr range
      //     if (i + k - 1 < n) {
      //         int count = 0;
      //         double sum = 0.0;
      //         while (count < k) {
      //             sum += nums[i + count];
      //             count++;
      //         }
      //         maxSum = Math.max(maxSum, sum);
      //     }
      // }
      // return maxSum / k;
   }

   public static void main(String[] args) {
      int[] nums = new int[] { 1, 12, -5, -6, 50, 3 };
      int k = 4;
      System.out.println(Arrays.toString(nums) + " -> " + findMaxAverage(nums, k));
      nums = new int[] { 5 };
      k = 1;
      System.out.println(Arrays.toString(nums) + " -> " + findMaxAverage(nums, k));
   }
}
