/**
 * Problem 15. 3Sum
 * https://leetcode.com/problems/3sum
 * 
 * !! MEDIUM
 * #TwoPointers  #Arrays
 *
 * Given an array 'nums', find all unique triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * The solution set must not contain duplicate triplets.
 *
 * !! Important: Triplet VALUES can be duplicated (e.g. [-1, -1, 2]), but triplets
 * !! themselves need to be distinct (e.g. [-1, 0, 1], [-1, 0, 1] is not allowed)
 *
 * !! Note: nums = [-2,0,0,2,2] must return [[-2,0,2]], not [[-2,0,2],[-2,0,2]]
 *
 * Example 1: Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: Distinct triplets are [-1,0,1] and [-1,-1,2].
 *
 * Example 2: Input: nums = [0,1,1] Output: [] // No triplet sums up to 0.
 *
 * Example 3: Input: nums = [0,0,0] Output: [[0,0,0]] // The only possible triplet sums
 * up to 0.
 *
 * Constraints: - 3 <= nums.length <= 3000 -105 <= nums[i] <= 105
 */

package patterns.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

   public static List<List<Integer>> threeSumWithDistinctTriplets(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      Arrays.sort(nums);
      int target = 0;
      for (int i = 0; i <= nums.length - 3; i++) {
         if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
               int sum = nums[i] + nums[left] + nums[right];

               if (sum == target) {
                  res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                  //!![-2,0,0,2,2] must return [[-2,0,2]] not [[-2,0,2],[-2,0,2]]
                  while (left < right && nums[left] == nums[left + 1]) left++;
                  while (left < right && nums[right] == nums[right - 1]) right--;

                  left++;
                  right--;
               } else if (sum < target) {
                  left++;
               } else if (sum > target) {
                  right--;
               }
            }
         }
      }
      return res;
   }

   public static List<List<Integer>> threeSumWithComments(int[] nums) {
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      Arrays.sort(nums); // Sort arr in asc order for better time complexity
      int target = 0;

      // [-4,-1, -1, 0, 1, 2] len = 6, last index = 5
      // Loop through ONLY first value of the potential triplets
      for (int i = 0; i <= nums.length - 3; i++) {
         // Check that value is not a duplicate of prev value
         // Only check for duplicates for elements beyond the first one (index=0)
         // !!Prevent duplicate triplets e.g. [-1, 0, 1], [-1, 0, 1]
         if (i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
            // Set left pointer to the next elem index & right pointer to last index
            int left = i + 1;
            int right = nums.length - 1;

            // Explore range of elems to the right of curr elem
            while (left < right) {
               int sum = nums[i] + nums[left] + nums[right];

               if (sum == target) {
                  // If sum == 0, add triplets to list
                  res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                  // Check if next pointer value is duplicate of curr
                  // pointer val & update pointer to skip duplicate
                  while (left != right) {
                     if (nums[left] == nums[left + 1]) left++; 
                     else if (nums[right] == nums[right - 1]) right--; 
                     else break; // Break if next pointers aren't duplicates
                  }
                  left++; // If sum == 0, explore new values
                  right--;
               } else if (sum < target) {
                  // If sum < 0, increase left pointer (to increase sum)
                  left++;
               } else if (sum > target) {
                  // If sum < 0, decrease right pointer (to decrease sum)
                  right--;
               }
            }
         }
      }
      return res;
   }

   public static void main(String[] args) {
      System.out.println("Distinct triplets");
      int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
      System.out.println(threeSumWithDistinctTriplets(nums));
      nums = new int[] { 0, 1, 1 };
      System.out.println(threeSumWithDistinctTriplets(nums));
      nums = new int[] { 0, 0, 0 };
      System.out.println(threeSumWithDistinctTriplets(nums));
      nums = new int[] { -2, 0, 0, 2, 2 };
      System.out.println(threeSumWithDistinctTriplets(nums));

      System.out.println("Distinct triplets");
      nums = new int[] { -1, 0, 1, 2, -1, -4 };
      System.out.println(threeSumWithComments(nums));
      nums = new int[] { 0, 1, 1 };
      System.out.println(threeSumWithComments(nums));
      nums = new int[] { 0, 0, 0 };
      System.out.println(threeSumWithComments(nums));
      nums = new int[] { -2, 0, 0, 2, 2 };
      System.out.println(threeSumWithComments(nums));
   }
}
