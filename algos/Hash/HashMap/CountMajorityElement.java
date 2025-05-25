/**
 * Problem 169: Majority Element
 * https://leetcode.com/problems/majority-element/
 * 
 * ! EASY
 * #Arrays  #HashMap  #Counting
 *
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 * Example 1: Input: nums = [3,2,3] Output: 3
 *
 * Example 2: Input: nums = [2,2,1,1,1,2,2] Output: 2
 *
 * Constraints: n == nums.length, 1 <= n <= 5 * 10^4, -10^9 <= nums[i] <= 10^9
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

package algos.Hash.HashMap;

import java.util.HashMap;

public class CountMajorityElement {

   public static int majorityElement(int[] nums) {
      HashMap<Integer, Integer> elemCount = new HashMap<>();
      int majElem = 0;
      int majCount = 0;

      for (int elem : nums) {
         // Use getOrDefault method to simplify getting count (get value using key)
         int count = elemCount.getOrDefault(elem, 0) + 1;
         elemCount.put(elem, count);

         if (majCount < count) {
            majCount = count;
            majElem = elem;
         }
      }
      return majElem;
   }

   public static void main(String[] args) {
      // Example 1
      int[] nums1 = { 3, 2, 3 };
      System.out.println("Example 1: " + majorityElement(nums1));

      // Example 2
      int[] nums2 = { 2, 2, 1, 1, 1, 2, 2 };
      System.out.println("Example 2: " + majorityElement(nums2));
   }
}
// !! NOT as good, used 2 for loops instead of 1, used containsKey & get instead of
// !! getOrDefault
// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> freq = new HashMap<>();
//         for (int num : nums) {
//             int count = freq.containsKey(num) ? freq.get(num) : 0;
//             freq.put(num, count + 1);
//         }
//         int majorityElem = 0;
//         int majorityCount = 0;
//         for (int elem : freq.keySet()) {
//             int elemFreq = freq.get(elem);
//             if (Math.max(majorityCount, elemFreq) != majorityCount) {
//                 majorityCount = elemFreq;
//                 majorityElem = elem;
//             }
//         }
//         return majorityElem;
//     }
// }
