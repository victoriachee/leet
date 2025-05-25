/** Problem 448: Find All Numbers Disappeared in an Array
 * URL: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * ! EASY
 * #Arrays  #In-place
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n], return
 * an array of all the integers in the range [1, n] that do not appear in nums.
 *
 * Example 1: Input: nums = [4,3,2,7,8,2,3,1] Output: [5,6]
 *
 * Example 2: Input: nums = [1,1] Output: [2]
 *
 * Constraints: n == nums.length, 1 <= n <= 10^5, 1 <= nums[i] <= n
 *
 * Follow up: Implement without extra space and in O(n) runtime.
 * Important: Assume the returned list does not count as extra space.
 */

package patterns.Marking;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {

   public static List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> res = new ArrayList<Integer>();

      for (int num : nums) {
         // Make the value an index from 0 to n
         int index = Math.abs(num) - 1;

         // Show that the value is in the nums array
         // by marking the value at the index (value - 1)
         // as negative (ensure it is not already neg)
         if (nums[index] > 0) {
            nums[index] = -nums[index];
         }
      }

      // If any value at any index is not negative,
      // the number that is (index + 1) is not present
      for (int i = 0; i < nums.length; i++) {
         if (nums[i] > 0) {
            res.add(i + 1);
         }
      }
      return res;
   }

   public static void main(String[] args) {
      // Example usage
      int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
      System.out.println(findDisappearedNumbers(nums1)); // Output: [5, 6]

      int[] nums2 = { 1, 1 };
      System.out.println(findDisappearedNumbers(nums2)); // Output: [2]
   }
}
