// https://leetcode.com/problems/find-the-duplicate-number/

// 9 Approaches:
// https://leetcode.com/problems/find-the-duplicate-number/solutions/1892921/9-approaches-count-hash-in-place-marked-sort-binary-search-bit-mask-fast-slow-pointers/

/**
 * Analysis
    Time Complexity: O(n)
    Space Complexity: O(1)

 * Follow-up Answers:

    1. How can we prove that at least one duplicate number must exist in nums?

    The array contains n + 1 integers in the range [1, n], which means there are only n
    distinct integers to accommodate in the array. Since the array has n + 1 elements,
    there must be at least one integer that appears more than once (a duplicate). This
    is a consequence of the Pigeonhole Principle.

    2. Can you solve the problem in linear runtime complexity?

    Yes, the provided solution has a linear runtime complexity of O(n). The for loop
    iterates through each element in the array once, and each operation inside the loop
    takes constant time. Therefore, the overall time complexity is linear.
 */
package patterns.Marking;

public class FindDuplicate {

   public static int findDuplicate(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
         int num = Math.abs(nums[i]);
         int indexAsNum = num - 1;

         // If num at indexAsNum(num-1) is negative, it is a duplicate
         if (nums[indexAsNum] < 0) {
            return num;
         } else {
            //Set num at indexAsNum(num-1) as negative
            nums[indexAsNum] = -nums[indexAsNum];
         }
      }
      return 0;
   }

   public static void main(String[] args) {
      int[] nums1 = { 1, 3, 4, 2, 2 };
      System.out.println(findDuplicate(nums1)); // Output: 2

      int[] nums2 = { 3, 1, 3, 4, 2 };
      System.out.println(findDuplicate(nums2)); // Output: 3

      int[] nums3 = { 1, 2, 3, 4, 1 };
      System.out.println(findDuplicate(nums3)); // Output: 1
   }
}
/// [1, 2, 3, 4, 1]
//   0  1  2  3  4
