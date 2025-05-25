/** 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges/
 * 
 * ! EASY
 * #Intervals  #Arrays
 * 
 * Given a sorted unique integer array nums, return the smallest sorted list of ranges
 * covering all numbers, each represented as "a->b" if a != b, or "a" if a == b.
 * The question specifies that continuous elements should be kept in an interval,
 * while non-continuous elements should be represented individually.
 *
 * Example:
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 *
 * Constraints:
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * All values in nums are unique and sorted in ascending order.
 */

package patterns.Intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryOfRanges {

   public static List<String> summaryRanges(int[] nums) {
      List<String> res = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
         int start = nums[i]; // first num of range
         // Check that [i+1] is a valid array index (last idx is arr.len - 1), 
         // and if current num + 1 is equal to the next num (contiguous elems)
         while (i < nums.length - 1 && nums[i] + 1 == nums[i + 1]) {
            i++;
         }
         int end = nums[i]; // last num of range
         res.add(formatRange(start, end));
      }
      return res;
   }

   private static String formatRange(int start, int end) {
      return (start == end) ? Integer.toString(start) : start + "->" + end;
   }

   public static void main(String[] args) {
      int[] nums1 = { 0, 1, 2, 4, 5, 7 };
      int[] nums2 = { 0, 2, 3, 4, 6, 8, 9 };

      List<String> output1 = summaryRanges(nums1);
      List<String> output2 = summaryRanges(nums2);

      System.out.println(output1); // Output: ["0->2", "4->5", "7"]
      System.out.println(output2); // Output: ["0", "2->4", "6", "8->9"]
   }
}
