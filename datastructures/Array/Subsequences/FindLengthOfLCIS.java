/** Problem 674: Longest Continuous Increasing Subsequence
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 * 
 * ! EASY
 * #Arrays  #Iteration  #Math.max  #Subsequences
 *
 * Given an unsorted array 'nums', return the length of the longest continuous
 * increasing subsequence. The subsequence must be strictly increasing.
 *
 * Example 1: Input: [1,3,5,4,7] Output: 3 Explanation: Longest subsequence is [1,3,5].
 *
 * Example 2: Input: [2,2,2,2,2] Output: 1 Explanation: Longest subsequence is [2].
 *
 * Constraints: 1 <= nums.length <= 10^4, -10^9 <= nums[i] <= 10^9
 */

package Array.Subsequences;

public class FindLengthOfLCIS {

   public static int findLengthOfLCIS(int[] nums) {
      if (nums.length == 1) return 1;
      int max = 1;
      int curr = 1;

      for (int i = 1; i < nums.length; i++) {
         if (nums[i] > nums[i - 1]) curr++; else curr = 1;
         max = Math.max(max, curr);
      }
      return max;
   }

   public static void main(String[] args) {
      // Example 1:
      int[] nums1 = { 1, 3, 5, 4, 7 };
      System.out.println("Example 1: " + findLengthOfLCIS(nums1)); // Output: 3

      // Example 2:
      int[] nums2 = { 2, 2, 2, 2, 2 };
      System.out.println("Example 2: " + findLengthOfLCIS(nums2)); // Output: 1
   }
}
