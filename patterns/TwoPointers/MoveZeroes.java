/**
 * Problem 283: Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 * 
 * ! EASY
 * #TwoPointers  #Arrays
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * Example 1: Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
 *
 * Example 2: Input: nums = [0] Output: [0]
 *
 * Constraints: 1 <= nums.length <= 10^4, -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow up: Could you minimize the total number of operations done?
 */

package patterns.TwoPointers;

import java.util.Arrays;

public class MoveZeroes {

   public void moveZeroes(int[] nums) {
      int slow = 0;
      for (int fast = 0; fast < nums.length; fast++) {
         // If fast pointer is non-zero, swap it with slow pointer, increment both
         // If fast pointer is zero, increment fast by 1, don't increment slow
         if (nums[fast] != 0) {
            int temp = nums[fast];
            nums[fast] = nums[slow];
            nums[slow] = temp;
            slow++;
         }
      }

      // [0,1,0,3,12] [1,0,0,3,12] [1,3,0,0,12] [1,3,12,0,0]

      // !!WRONG:
      // for (int fast = 1; fast < nums.length; fast++) {
      //     if (nums[slow] != 0) {
      //         slow++;
      //     } else if (nums[slow] == 0 && nums[fast] != 0) {
      //         nums[slow] = nums[fast];
      //         nums[fast] = 0;
      //         slow++;
      //     }
      // }

      // !CORRECT:
      // for (int fast = 1; fast < nums.length; fast++) {
      //     // If slow is not 0, increase slow and fast
      //     if (nums[slow] != 0) {
      //         slow++;
      //     // Else if slow is 0, fast is not 0, swap them
      //     } else if (nums[fast] != 0) {
      //         nums[slow] = nums[fast];
      //         nums[fast] = 0;
      //         slow++;
      //     }
      //
      //     // If slow is 0, fast is 0, just increase fast
      // }
   }

   public static void main(String[] args) {
      MoveZeroes solution = new MoveZeroes();

      // Example 1
      int[] nums1 = { 0, 1, 0, 3, 12 };
      solution.moveZeroes(nums1);
      System.out.println(Arrays.toString(nums1)); // Output: [1, 3, 12, 0, 0]

      // Example 2
      int[] nums2 = { 0 };
      solution.moveZeroes(nums2);
      System.out.println(Arrays.toString(nums2)); // Output: [0]
   }
}
/*
 *
 *     0, 1, 2, 3, 4, 5 s f
 *
 * 1: [0, 1, 0, 3, 5, 6] 1 2
 * 2: [1, 0, 0, 3, 5, 6] 1 3
 * 3: [1, 3, 0, 0, 5, 6] 2 4
 * 4: [1, 3, 5, 0, 0, 6] 3 5
 * 5: [1, 3, 5, 6, 0, 0] 4 6
 *
 * 1: [1, 0, 2, 3, 5, 6] 1 2
 * 2: [1, 2, 0, 3, 5, 6] 2 3
 * 3: [1, 2, 3, 0, 5, 6] 3 4
 * 4: [1, 2, 3, 5, 0, 6] 4 5
 * 5: [1, 2, 3, 5, 6, 0] 5 6
 *
 * 1: [1, 2, 0, 3, 0, 6]
 * 2: [1, 2, 0, 3, 0, 6]
 * 3: [1, 2, 0, 3, 0, 6]
 * 4: [1, 2, 3, 0, 0, 6]
 * 6: [1, 2, 3, 6, 0, 0]
 *
 * [0, 0, 2, 3, 0, 6]
 */
