/** Problem 136: Single Number
 *
 * URL: https://leetcode.com/problems/single-number/
 * URL: https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer
 *
 * !! " EASY "
 * #Arrays  #BitManipulation  #XOR
 *
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 *
 * Implement a solution with linear runtime complexity and only constant extra space.
 *
 * Example 1: Input: nums = [2,2,1] Output: 1
 *
 * Example 2: Input: nums = [4,1,2,1,2] Output: 4
 *
 * Example 3: Input: nums = [1] Output: 1
 *
 * Constraints: 1 <= nums.length <= 3 * 10^4, -3 * 10^4 <= nums[i] <= 3 * 10^4
 * Each element in the array appears twice except for one element which appears only once.
 */

/**
 * !Important Context:
 * (A XOR B) XOR C = A XOR (B XOR C)
 *
 * The XOR of two equal numbers is 0, and XOR of any number with 0 is the
 * number itself. So, by XORing all elements in the array, the duplicates
 * will cancel each other out, leaving only the unique element.
 *
 * * Time Complexity:   O(n)
 * * Space Complexity:  O(1)
 */

package _HackerRank;

public class D2LonelyInteger {

   public static int singleNumber(int[] nums) {
      int res = 0;
      for (int num : nums) {
         res ^= num; // Equivalent to res = res ^ num;
      }
      return res;
   }

   public static void main(String[] args) {
      // Example 1
      int[] nums1 = { 2, 2, 1 };
      System.out.println(singleNumber(nums1)); // Output: 1

      // Example 2
      int[] nums2 = { 4, 1, 2, 1, 2 };
      System.out.println(singleNumber(nums2)); // Output: 4

      // Example 3
      int[] nums3 = { 1 };
      System.out.println(singleNumber(nums3)); // Output: 1
   }
}
/*
 * To find the single number in the array with linear runtime complexity and constant
 * extra space, you can use the bitwise XOR operation.
 * The XOR of a number with itself is 0, and XOR is commutative and associative.
 * So, XORing all the numbers in the array will cancel out the duplicates, leaving only
 * the single number.
 * XOR (exclusive or) is a binary operation that takes two binary digits or Boolean
 * values as input and returns a single binary digit or Boolean value as output.
 * The XOR operation has the following truth table:
 *
 * css
 *
 * | A | B | A XOR B |
 * |---|---|---------|
 * | 0 | 0 | 0 |
 * | 0 | 1 | 1 |
 * | 1 | 0 | 1 |
 * | 1 | 1 | 0 |
 *
 * int a = 5; // binary: 101
 * int b = 3; // binary: 011
 *
 * int result = a ^ b;
 * a:   101
 * b:   011
 *      101
 * X    011
 * ---------
 *      110
 *
 * The result of the XOR operation is 110 in binary, which is equal to 6 in
 * decimal.
 *
 *
 * int[] nums2 = {4, 1, 2, 1, 2};
 * System.out.println(solution.singleNumber(nums2)); // Output: 4
 *
 * Initial Result: result is initialized to 0.
 * Loop Iteration 1: result ^= 4 updates result to 4.
 * Loop Iteration 2: result ^= 1 updates result to 5.
 * Loop Iteration 3: result ^= 2 updates result to 7.
 * Loop Iteration 4: result ^= 1 updates result to 6.
 * Loop Iteration 5: result ^= 2 updates result to 4.
 * Final Result: The final value of result is 4.
 *
 * Now, let's understand each step:
 *
 * result ^= 4: The binary representation of result is initially 0000.
 * The binary representation of 4 is 0100. The XOR operation results in 0100,
 * which is 4 in decimal.
 *
 * result ^= 1: The binary representation of result is 0100.
 * The binary representation of 1 is 0001. The XOR operation results in 0101,
 * which is 5 in decimal.
 *
 * result ^= 2: The binary representation of result is 0101.
 * The binary representation of 2 is 0010. The XOR operation results in 0111,
 * which is 7 in decimal.
 *
 * result ^= 1: The binary representation of result is 0111.
 * The binary representation of 1 is 0001. The XOR operation results in 0110,
 * which is 6 in decimal.
 *
 * result ^= 2: The binary representation of result is 0110.
 * The binary representation of 2 is 0010. The XOR operation results in 0100,
 * which is 4 in decimal.
 *
 * At this point, the loop has processed all elements in the array, and the
 * final value of result is 4, which is the single number in the array.
 * The XOR operation has effectively canceled out the duplicates, leaving only
 * the single element.
 */
