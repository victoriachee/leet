/** Problem 219: Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/
 *
 * ! EASY
 * #Arrays  #HashMap
 *
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j in the array (positions in array) such that
 * nums[i] == nums[j] and abs(i - j) <= k.
 *
 * Example 1: Input: nums = [1,2,3,1], k = 3 Output: true
 *
 * Example 2: Input: nums = [1,0,1,1], k = 1 Output: true
 *
 * Example 3: Input: nums = [1,2,3,1,2,3], k = 2 Output: false
 *
 * Constraints: 1 <= nums.length <= 10^5, -10^9 <= nums[i] <= 10^9, 0 <= k <= 10^5
 */

package algos.Hash.HashMap;

import java.util.HashMap;

public class ContainsNearbyDuplicate {

   /**
    * Determines whether there are two distinct indices i and j in the given integer array
    * such that nums[i] == nums[j] and abs(i - j) is at most k.
    *
    * @param nums The integer array to check for duplicates.
    * @param k    The maximum absolute difference allowed between the indices of two duplicate elements.
    *             It must be a non-negative integer and can be at most 10^5.
    * @return {@code true} if there are such indices, {@code false} otherwise.
    */
   public static boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer, Integer> numIdxMap = new HashMap<>();

      for (int i = 0; i < nums.length; i++) {
         int numj = nums[i];


         // Check if the current element is already in the HashMap
         if (numIdxMap.containsKey(numj)) {
            // Get index j via num[j] key. If the absolute difference between the
            // current index & the previous index is at most k, return true.
            if (Math.abs(i - numIdxMap.get(numj)) <= k) {
               return true;
            }
         } 
         // Update the index of the current element in the HashMap
         // Allows checking for more than 2 duplicates at distinct indices
         numIdxMap.put(numj, i);
      }

      // No such indices found
      return false;
   }

   public static void main(String[] args) {
      // Test case 1
      int[] nums1 = { 1, 2, 3, 1 };
      int k1 = 3;
      System.out.println("Test Case 1: " + containsNearbyDuplicate(nums1, k1)); // Output: true

      // Test case 2
      int[] nums2 = { 1, 0, 1, 1 };
      int k2 = 1;
      System.out.println("Test Case 2: " + containsNearbyDuplicate(nums2, k2)); // Output: true

      // Test case 3
      int[] nums3 = { 1, 2, 3, 1, 2, 3 };
      int k3 = 2;
      System.out.println("Test Case 3: " + containsNearbyDuplicate(nums3, k3)); // Output: false
   }
}
