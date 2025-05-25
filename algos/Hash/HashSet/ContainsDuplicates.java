/** Problem 217: Contains Duplicate
 * https://leetcode.com/problems/contains-duplicate/
 *
 * ! EASY
 * #Arrays  #HashSet
 *
 * Given an integer array nums, return true if any value appears at least twice in
 * the array, and return false if every element is distinct.
 *
 * Example 1: Input: nums = [1,2,3,1] Output: true
 *
 * Example 2: Input: nums = [1,2,3,4] Output: false
 *
 * Example 3: Input: nums = [1,1,1,3,3,4,3,2,4,2] Output: true
 *
 * Constraints: 1 <= nums.length <= 10^5, -10^9 <= nums[i] <= 10^9
 */

package algos.Hash.HashSet;

import java.util.HashSet;

public class ContainsDuplicates {

   /**
    * Determines whether any value appears at least twice in the given integer array.
    *
    * @param nums The integer array to check for duplicates. 
    * @return {@code true} if any value appears at least twice in the array, {@code false} otherwise.
    */
   public static boolean containsDuplicate(int[] nums) {
      HashSet<Integer> set = new HashSet<>(); // Distinct & unordered

      for (int num : nums) {
         if (set.contains(num)) return true; // It was already added before, is duplicate
         set.add(num);
      }
      return false; 
   }

   public static void main(String[] args) {
      // Test case 1
      int[] nums1 = { 1, 2, 3, 1 };
      System.out.println("Test Case 1: " + ContainsDuplicates.containsDuplicate(nums1)); // Output: true

      // Test case 2
      int[] nums2 = { 1, 2, 3, 4 };
      System.out.println("Test Case 2: " + ContainsDuplicates.containsDuplicate(nums2)); // Output: false

      // Test case 3
      int[] nums3 = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
      System.out.println("Test Case 3: " + ContainsDuplicates.containsDuplicate(nums3)); // Output: true
   }
}
