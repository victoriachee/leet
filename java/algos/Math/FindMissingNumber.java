/** Problem 268: Missing Number
 * https://leetcode.com/problems/missing-number/
 * 
 * ! EASY
 * #Arrays  #Math  #Summation  #n*(n+1)/2
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 *
 * Example 1: Input: nums = [3,0,1] Output: 2
 * Explanation: n = 3, all numbers are in the range [0,3]. 2 is missing in nums.
 *
 * Example 2: Input: nums = [0,1] Output: 2
 * Explanation: n = 2, all numbers are in the range [0,2]. 2 is missing in nums.
 *
 * Example 3: Input: nums = [9,6,4,2,3,5,7,0,1] Output: 8
 * Explanation: n = 9, all numbers are in the range [0,9]. 8 is missing in nums.
 *
 * Constraints: n == nums.length, 1 <= n <= 10^4, 0 <= nums[i] <= n, Unique nums.
 *
 * Follow up: Implement solution using only O(1) extra space and O(n) runtime.
 */

/**
 * Space Complexity: O(1)
 *  Algorithm uses constant extra space. Independent of input size.
 *  Uses few integer variables (n, expectedSum, actualSum).
 *
 * Time Complexity: O(n)
 *  Linearly proportional to input array size. Iterates once to calculate sum.
 */

package algos.Math;

public class FindMissingNumber {

   public static int findMissingNumber(int[] nums) {
      int n = nums.length;
      int expectedSum = n * (n + 1) / 2; // Sum of all ints from 0 to n
      int actualSum = 0;

      for (int num : nums) {
         actualSum += num;
      }
      return expectedSum - actualSum;
   }

   public static void main(String[] args) {
      int[] nums1 = { 3, 0, 1 };
      System.out.println(findMissingNumber(nums1)); // Output: 2

      int[] nums2 = { 0, 1 };
      System.out.println(findMissingNumber(nums2)); // Output: 2

      int[] nums3 = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
      System.out.println(findMissingNumber(nums3)); // Output: 8
   }
}
