// "MEDIUM"
// #Dynamic Programming #Longest Increasing Subsequence #LIS

/** Problem 300. Longest Increasing Subsequence
 * https://leetcode.com/problems/longest-increasing-subsequence/
 * !! "MEDIUM"
 * #BinarySearch  #DynamicProgramming  #LongestIncreasingSubsequence  #LIS
 *
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 *
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18] Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101] with length 4.
 *
 * Example 2:
 * Input: nums = [0,1,0,3,2,3] Output: 4
 *
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7] Output: 1
 *
 * Constraints:
 * 1 <= nums.length <= 2500, -10^4 <= nums[i] <= 10^4
 *
 * Follow up: Come up with an algorithm that runs in O(n log(n)) time complexity
 */

package algos.DP.TopDownMemoization;

import java.util.Arrays;

// !BS: 6ms, DP: 40ms
public class DP_BS_LengthOfLIS {

   public static int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      Arrays.fill(dp, 1);
      int maxLISLength = 1; // At min, LIS should be 1
      // Loop through all nums
      for (int i = 0; i < nums.length; i++) {
         // Loop through all nums before nums[i]
         for (int j = 0; j < i; j++) {
            // If currentNum > earlierNum
            if (nums[i] > nums[j]) {
               // Max length is either prev length + 1
               // or a prev length is already the max
               dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            // ** E.g.
            // 1. nums = [3, 4, 2, 8, 5], dp = [1, 2, 1, 3, 1]
            // nums[4]> nums[0], nums[4]>nums[1], nums[4]>nums[2]
            // 2. dp[4] = Math.max(dp[4] = 1, dp[0]+1 = 1+1, dp[1]+1 = 2+1, dp[2]+1 = 1+1)
            // dp = [1, 2, 1, 3, 3]
         }
         // At this array value, check if its LIS length is max so far
         maxLISLength = Math.max(dp[i], maxLISLength);
      }

      return maxLISLength;
   }

   public static void main(String[] args) {
      int[] nums1 = { 10, 9, 2, 5, 3, 7, 101, 18 };
      System.out.println(lengthOfLIS(nums1)); // Output: 4

      int[] nums2 = { 0, 1, 0, 3, 2, 3 };
      System.out.println(lengthOfLIS(nums2)); // Output: 4

      int[] nums3 = { 7, 7, 7, 7, 7, 7, 7 };
      System.out.println(lengthOfLIS(nums3)); // Output: 1
   }
}
