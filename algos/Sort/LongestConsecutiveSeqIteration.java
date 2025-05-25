// https://leetcode.com/problems/longest-consecutive-sequence/

// !Iteration approach:
// Time Complexity: O(n log n) - Arrays.sort(nums)
// Space Complexity: O(1) - Sorts nums in-place

/**
 * @see https://leetcode.com/problems/longest-consecutive-sequence/solutions/4139456/c-c-java-python-javascript-beats-100-3-approaches-explained/
 *      for better time complexity & space complexity approaches
 */

package algos.Sort;

import java.util.Arrays;

public class LongestConsecutiveSeqIteration {

   public int longestConsecutive(int[] nums) {
      if (nums.length <= 1) return nums.length;

      Arrays.sort(nums);

      int maxLen = 1;
      int currLen = 1;
      int prev = nums[0];
      for (int i = 1; i < nums.length; i++) {
         // Duplicates in consec. sequence are ignored
         // E.g. In: [1, 2, 3, 100, 200] -> 3, In: [0, 1, 1, 2] -> 3
         if (nums[i] != prev) {
            if (nums[i] == prev + 1) {
               currLen++;
            } else { // End of sequence
               currLen = 1;
            }
            prev = nums[i];
            maxLen = Math.max(maxLen, currLen);
         }
      }
      return maxLen;
   }

   public static void main(String[] args) {
      LongestConsecutiveSeqIteration solution = new LongestConsecutiveSeqIteration();

      // Example usage
      int[] nums1 = { 100, 4, 200, 1, 3, 2 };
      int result1 = solution.longestConsecutive(nums1);
      System.out.println("Example 1: " + Arrays.toString(nums1) + " -> " + result1);

      int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
      int result2 = solution.longestConsecutive(nums2);
      System.out.println("Example 2: " + Arrays.toString(nums2) + " -> " + result2);

      int[] nums3 = { 1, 2, 0, 1 };
      int result3 = solution.longestConsecutive(nums3);
      System.out.println("Example 3: " + Arrays.toString(nums3) + " -> " + result3);
   }
}
