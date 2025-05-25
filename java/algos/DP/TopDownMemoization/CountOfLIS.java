/** 673. Number of Longest Increasing Subsequence
 * URL: https://leetcode.com/problems/number-of-longest-increasing-subsequence/
 * !! MEDIUM
 * #DynamicProgramming  #Math.max
 *
 * Given an integer array nums, return the number of longest increasing
 * subsequences. Notice that the sequence has to be strictly increasing.
 *
 * Example 1: Input: nums = [1,3,5,4,7] Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7]
 * and [1, 3, 5, 7].
 *
 * Example 2: Input: nums = [2,2,2,2,2] Output: 5
 * Explanation: The length of the longest increasing subsequence is 1,
 * and there are 5 increasing subsequences of length 1, so output 5.
 *
 * Constraints: 1 <= nums.length <= 2000, -106 <= nums[i] <= 106
 */

/** More info for understanding the algorithm:
 * By summing up the counts, you are essentially considering all possible ways you
 * can reach the current element and form valid increasing subsequences.
 *
 * Each count represents the number of valid LIS ending at the respective positions,
 * and summing them up gives you the total count of LIS at the current position.
 *
 * 1 3 5 7 (8)
 * 1 2 5 7 (8)
 * 1 2 6 7 (8)
 * 1 3 6 7 (8)
 * 1 2 3 7 (8)
 * Count 5 of valid LIS ending at 7
 *
 * 1 2 3 6 (8)
 * 1 3 5 6 (8)
 * 1 2 5 6 (8)
 * Count 3 of valid LIS ending at 6
 *
 * If LIS ending at 8
 * Count of valid LIS ending at 8 =
 * Count of valid LIS ending at 7 + Count of valid LIS ending at 6
 */

package algos.DP.TopDownMemoization;

import java.util.Arrays;

public class CountOfLIS {

   public static int findNumberOfLIS(int[] nums) {
      int n = nums.length;
      int maxLength = 1; // Max length of LIS
      int[] length = new int[n]; // Length of LIS for elem at each position
      int[] count = new int[n]; // Count of LIS for elem at each position

      for (int i = 0; i < n; i++) { // Loop over all numbers (start from 0!)
         length[i] = count[i] = 1; // Initialize length and count to 1
         // Loop over numbers before current position
         for (int j = 0; j < i; j++) {
            // Check if current number is greater than previous number
            if (nums[i] > nums[j]) {
               // Check if length of LIS at current elem position is less than its
               // its actual length (previous LIS + 1)
               if (length[i] < length[j] + 1) {
                  // Length of LIS at curr position will be 1 more than prev max LIS
                  length[i] = length[j] + 1;
                  // Count of LIS at curr position will be same as prev max LIS
                  count[i] = count[j];
               }
               // Check if length of LIS at current position is equal to prev LIS + 1
               // Means that a prev LIS that is 1 elem shorter than the curr LIS has been
               // found again. The current position's LIS count is those counts added up
               else if (length[i] == length[j] + 1) {
                  count[i] += count[j];
               }
            }
         }
         maxLength = Math.max(length[i], maxLength); // Must be outside loop!
      }

      int finalCount = 0;
      for (int i = 0; i < n; i++) {
         if (length[i] == maxLength) {
            finalCount += count[i];
         }
      }
      return finalCount;
   }

   public static void main(String[] args) {
      int[] test1 = { 1, 3, 5, 4, 7 };
      int ans1 = findNumberOfLIS(test1);

      System.out.println("test1: " + Arrays.toString(test1) + " Ans: " + ans1);
      int[] test2 = { 1, 1, 2, 1, 1 };
      int ans2 = findNumberOfLIS(test2);

      System.out.println("test2: " + Arrays.toString(test2) + " Ans: " + ans2);

      int[] test3 = { 2, 2, 2, 2, 2 };
      int ans3 = findNumberOfLIS(test3);

      System.out.println("test3: " + Arrays.toString(test3) + " Ans: " + ans3);
   }
}
