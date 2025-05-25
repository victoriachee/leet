// https://leetcode.com/problems/longest-consecutive-sequence/

// !Unordered set approach:
// Time Complexity: O(n) - Traverse each consecutive sequence only once
// Space Complexity: O(n)

/**
 * @see https://leetcode.com/problems/longest-consecutive-sequence/solutions/4139456/c-c-java-python-javascript-beats-100-3-approaches-explained/
 *      for better time complexity & space complexity
 */

package algos.Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LongestConsecutiveSeqUnordered {

   public int longestConsecutive(int[] nums) {
      if (nums.length <= 1) return nums.length;

      // Get an sorted and distinct set
      Set<Integer> hashSet = new HashSet<>();
      IntStream.of(nums).forEach(hashSet::add);

      int maxLen = 1; // Max length of of consec. seq.
      for (int num : nums) {
         // Ensure num is a start of a sequence E.g. [2, 3, 100, 200]
         if (!hashSet.contains(num - 1)) {
            int currLen = 1; // Current length of consec. seq.
            int currNum = num; // *** Needed to traverse each seq. once
            while (hashSet.contains(currNum + 1)) {
               currLen++;
               currNum++;
            }
            maxLen = Math.max(maxLen, currLen);
         }
      }
      return maxLen;
   }

   public static void main(String[] args) {
      LongestConsecutiveSeqUnordered solution = new LongestConsecutiveSeqUnordered();

      // Example usage
      int[] nums1 = { 100, 4, 200, 1, 3, 2 };
      int result1 = solution.longestConsecutive(nums1);
      System.out.println("Example 1: " + Arrays.toString(nums1) + " -> " + result1);

      int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
      int result2 = solution.longestConsecutive(nums2);
      System.out.println("Example 2: " + Arrays.toString(nums2) + " -> " + result2);
   }
}
