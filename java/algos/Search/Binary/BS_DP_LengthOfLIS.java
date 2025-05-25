/** Problem 300. Longest Increasing Subsequence
 * URL: https://leetcode.com/problems/longest-increasing-subsequence/
 * !! "MEDIUM"
 * #BinarySearch  #LongestIncreasingSubsequence  #LIS  #DynamicProgramming
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

/* Dynamic Programming vs Binary Search:

    *Dynamic Programming Approach:
      - Pros:
        Straightforward and easy to understand, easier implementation.
        O(n^2) time complexity.

      - Cons: Slower for larger inputs, especially if n is large.

    *Binary Search Approach:
      - Pros: More efficient, especially for large inputs. O(n log(n)) time complexity.

      - Cons: May be challenging to understand, requires careful implementation.

    *Considerations:
      - Input Size:
        For small to moderate sizes, either approach may work well.
        For large inputs, binary search is likely more efficient.

      - Ease of Implementation:
        If simplicity is crucial, dynamic programming might be preferable.

      - Time Complexity: For constraints like O(n log(n)), binary search is necessary.

      - Space Complexity:
        Both use O(n) space, but binary search can be more memory-efficient.


*/

package algos.Search.Binary;

import java.util.ArrayList;
import java.util.List;

public class BS_DP_LengthOfLIS {

   // !BS: 6ms, DP: 40ms
   public static int lengthOfLIS(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      List<Integer> lis = new ArrayList<>();
      lis.add(nums[0]); // Initialize the list with the first element ***!!!

      for (int i = 1; i < nums.length; i++) {
         // If the current number is greater than the last element of the LIS,
         // extend the LIS [2] -> [2, 5]
         if (nums[i] > lis.get(lis.size() - 1)) {
            lis.add(nums[i]);
         // Otherwise, find the appropriate position to update the LIS
         // Update the lis element at lis idx 0 from [10] -> [9] since left (0) == right (0)
         // If lis [2, 5] Update 5 with with smaller value -> [2, 3]
         // Replaces last lis num with the smaller num
         } else {
            int insertionPoint = binarySearch(lis, nums[i]);
            lis.set(insertionPoint, nums[i]);
         }
      }

      return lis.size();
   }

   private static int binarySearch(List<Integer> lis, int target) {
      int left = 0, right = lis.size() - 1;

      while (left < right) {
         int mid = left + (right - left) / 2;
         if (lis.get(mid) < target) {
            left = mid + 1;
         } else {
            right = mid;
         }
      }

      return left;
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
