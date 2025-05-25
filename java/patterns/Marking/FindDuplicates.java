/** Problem 442: Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
 *
 * !! MEDIUM
 * #Marking  #Negation  #Arrays  #Duplicates  #Iteration
 * #HashMap  -> O(n) Extra Space
 * #In-place -> O(1) Constant Extra Space (algo memory does not incr. w. input size)
 *
 * Given an integer array nums of length n where all the integers are in the range [1, n]
 * and each integer appears once or twice, return an array of all the integers that appear
 * twice.
 *
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
 *
 * Example 1: Input: nums = [4,3,2,7,8,2,3,1] Output: [2,3]
 *
 * Example 2: Input: nums = [1,1,2] Output: [1]
 *
 * Example 3: Input: nums = [1] Output: []
 *
 * Constraints: n == nums.length, 1 <= n <= 10^5, 1 <= nums[i] <= n
 *              Each element in nums appears once or twice.
 */

package patterns.Marking;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

   /** Marking: 5 ms, beats 93.64% of users with Java **/
   public static List<Integer> findDuplicates(int[] nums) {
      final List<Integer> duplicates = new ArrayList<Integer>();
      for (int i = 0; i < nums.length; i++) {
         final int idx = Math.abs(nums[i]); // * Use final!
         if (nums[idx - 1] < 0) {
            duplicates.add(idx);
         } else {
            nums[idx - 1] *= -1; // * Don't retrieve number again!
         }
      }
      return duplicates;
   }

   /** Marking: 24 ms, beats 12.73% of users with Java **/
   public static List<Integer> findDuplicates2(int[] nums) {
      List<Integer> res = new ArrayList<Integer>();
      for (int num : nums) {
         // Since nums is length n, and value of num is 1 to n,
         // Math.abs ensures index is not negative
         int index = Math.abs(num) - 1;

         // If num at index is already negative, num appears twice
         if (nums[index] < 0) {
            res.add(index + 1);
         } else {
            // else change num at index to a negative, num appears once
            nums[index] = -nums[index];
         }
      }
      return res;
   }

   public static void main(String[] args) {
      // Example 1
      int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
      System.out.println("Example 1 Output: " + findDuplicates(nums1));

      // Example 2
      int[] nums2 = { 1, 1, 2 };
      System.out.println("Example 2 Output: " + findDuplicates(nums2));

      // Example 3
      int[] nums3 = { 1 };
      System.out.println("Example 3 Output: " + findDuplicates(nums3));
   }
}
/**
 * !!WRONG:
 *
 * public List<Integer> findDuplicates(int[] nums) {
 *  HashMap<Integer, Integer> numFreqMap = new HashMap<>();
 *  List<Integer> res = new ArrayList<Integer>();
 *
 *  for (int i = 0; i< nums.length; i++){
 *      int num = nums[i];
 *      numFreqMap.put(num, numFreqMap.containsKey(num) ? 2 : 1);
 *  }
 *  for (int num : numFreqMap.keySet()){
 *      if (numFreqMap.get(num) == 2) {
 *      res.add(num);
 *      }
 *  }
 *  return res;
 * }
 *
 * Your solution using a HashMap to store the frequency of each number and then
 * iterating over the keys to find duplicates is correct and will give you the
 * correct result. However, it's worth noting that this solution uses O(n) extra space
 * for the HashMap, and the problem statement specifically asks for a solution that uses
 * only constant extra space.
 *
 * The alternative solution provided earlier, which modifies the input array in
 * place, meets the constant space requirement. If space complexity is a concern and
 * you want to follow the constraints strictly, the in-place modification approach would
 * be preferred.
 *
 * That being said, if you are not concerned about the constant space requirement, your
 * solution using HashMap is a valid and understandable approach to solving the
 * problem.
 * It's good to be aware of different techniques and trade-offs depending on the
 * specific requirements of a problem.
 *
 */
