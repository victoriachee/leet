// ! EASY
// #TwoPointers  #Sorting  #Math.abs

/**https://leetcode.com/problems/squares-of-a-sorted-array/ */

package algos.Sort;

import java.util.Arrays;

public class SortedSquares {

   // !BACKWARD PASS comparing absolute num values
   public static int[] sortedSquares(int[] nums) {
      int n = nums.length;
      int[] res = new int[n];

      int left = 0, right = n - 1;

      for (int i = n - 1; i >= 0; i--) { // Backward pass
         // If left num when positive is larger than the right num when positive
         if (Math.abs(nums[left]) > Math.abs(nums[right])) {
            res[i] = nums[left] * nums[left];
            left++;
         } else {
            res[i] = nums[right] * nums[right];
            right--;
         }
      }

      return res;
   }

   // !WHILE loop comparing squared values
   // public static int[] sortedSquares(int[] nums) {
   //     int n = nums.length;
   //     int[] res = new int[n];

   //     int left = 0, right = n - 1, i = n - 1;

   //     while (left <= right) { // *** <=

   //         int leftSquare = nums[left] * nums[left];
   //         int rightSquare = nums[right] * nums[right];

   //         if (leftSquare > rightSquare) {
   //             res[i] = leftSquare;
   //             left++;
   //         } else {
   //             res[i] = rightSquare;
   //             right--;
   //         }
   //         i--;
   //     }
   //     return res;
   // }

   public static void main(String[] args) {
      int[] nums1 = { -4, -1, 0, 3, 10 };
      int[] result1 = sortedSquares(nums1);
      System.out.println(Arrays.toString(nums1) + ": " + Arrays.toString(result1));

      int[] nums2 = { -7, -3, 2, 3, 11 };
      int[] result2 = sortedSquares(nums2);
      System.out.println(Arrays.toString(nums2) + ": " + Arrays.toString(result2));
   }
}
