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

package patterns.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_2Ptr_HashMap {

   /** Hash Map Approach: Unordered, Unique **/
   // Generally faster for unsorted input.
   // TC: O(n) - One Iteration, SC: O(n) - HashMap creation
   public static int[] twoSumHashMap(int[] nums, int target) {
      HashMap<Integer, Integer> numIndexMap = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         int reqNum = target - nums[i];
         if (numIndexMap.containsKey(reqNum)) {
            // Get index of required num
            return new int[] { numIndexMap.get(reqNum), i };
         }
         numIndexMap.put(nums[i], i); //key is num, value is index
      }

      throw new IllegalArgumentException("No two sum");
   }

   /** Two Pointer Approach: Sorting Pre-processing **/
   // More efficient in terms of time complexity for large datasets.
   // TC:  O(n log n) - Due to Arrays.sort, SC: O(1)  
   public static int[] twoSumTwoPointer(int[] nums, int target) {
      Arrays.sort(nums); //!! Sort arr
      int left = 0, right = nums.length - 1;

      while (left < right) {
         int sum = nums[left] + nums[right];

         if (sum == target) {
            return new int[] { left, right };
         } else if (sum < target) {
            left++;
         } else {
            right--;
         }
      }

      return new int[] { -1, -1 };
   }

   public static void main(String[] args) {
      // Example 1
      int[] nums1 = { 2, 7, 11, 15 };
      int target1 = 9;
      int[] result1 = twoSumHashMap(nums1, target1);
      int[] result1twopointer = twoSumTwoPointer(nums1, target1);
      System.out.println("\nOriginal: " + target1 + ":");
      printArray(nums1);
      System.out.println("\nHashMap: ");
      printArray(result1);
      System.out.println("\nTwo Pointer: ");
      printArray(result1twopointer);

      // Example 2
      int[] nums2 = { 3, 2, 4 };
      int target2 = 6;
      int[] result2 = twoSumHashMap(nums2, target2);
      int[] result2twopointer = twoSumTwoPointer(nums2, target2);
      System.out.println("\nOriginal: " + target2 + ":");
      printArray(nums2);
      System.out.println("\nHashMap: ");
      printArray(result2);
      System.out.println("\nTwo Pointer: ");
      printArray(result2twopointer);

      // Example 3
      int[] nums3 = { 3, 3 };
      int target3 = 6;
      int[] result3 = twoSumHashMap(nums3, target3);
      int[] result3twopointer = twoSumTwoPointer(nums3, target3);
      System.out.println("\nOriginal: " + target3 + ":");
      printArray(nums3);
      System.out.println("\nHashMap: ");
      printArray(result3);
      System.out.println("\nTwo Pointer: ");
      printArray(result3twopointer);
   }

   private static void printArray(int[] arr) {
      for (int num : arr) System.out.print(num + " ");
      System.out.println();
   }
}
