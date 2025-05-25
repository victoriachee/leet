/**
 * Problem 1: Two Sum
 * https://leetcode.com/problems/two-sum/description/
 * 
 * ! EASY
 * #TwoPointers  #HashMap  #Math  #Minus
 *
 * Given an array of integers nums and an integer target, return indices of two numbers
 * such that they add up to target. You may assume each input has exactly one solution,
 * and you may not use the same element twice. Return the answer in any order.
 *
 * Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1]
 * Explanation: nums[0] + nums[1] == 9, so return [0, 1].
 *
 * Example 2: Input: nums = [3,2,4], target = 6 Output: [1,2]
 *
 * Example 3: Input: nums = [3,3], target = 6 Output: [0,1]
 *
 * Constraints: 2 <= nums.length <= 10^4, -10^9 <= nums[i] <= 10^9, -10^9 <= target <= 10^9
 * Only one valid answer exists.
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n^2) time complexity?
 */

package algos.Hash.HashMap;

import java.util.HashMap;

public class TwoSum {

   // TC: O(n) - 1 Iteration, SC: O(n) - HashMap creation
   public static int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> numIndexMap = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         int num = nums[i];
         int requiredNum = target - num;
         if (numIndexMap.containsKey(requiredNum)) {
            // Get index of required num
            return new int[] { numIndexMap.get(requiredNum), i };
         }
         numIndexMap.put(num, i);
      }

      throw new IllegalArgumentException("No two sum");
   }

   public static void main(String[] args) {
      // Example 1
      int[] nums1 = { 2, 7, 11, 15 };
      int target1 = 9;
      int[] result1 = twoSum(nums1, target1);
      printArray(result1);

      // Example 2
      int[] nums2 = { 3, 2, 4 };
      int target2 = 6;
      int[] result2 = twoSum(nums2, target2);
      printArray(result2);

      // Example 3
      int[] nums3 = { 3, 3 };
      int target3 = 6;
      int[] result3 = twoSum(nums3, target3);
      printArray(result3);
   }

   private static void printArray(int[] arr) {
      for (int num : arr) System.out.print(num + " ");
      System.out.println();
   }
}
