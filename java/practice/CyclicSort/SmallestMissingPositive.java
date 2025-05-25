package practice.CyclicSort;

public class SmallestMissingPositive {



    /**
     * https://leetcode.com/problems/first-missing-positive/description/
     * The function is intended to find the smallest positive integer missing from an array of
     * integers.
     * 
     * Goal: The goal is to place each number x in its correct position [x - 1]
     * E.g. 3 should be placed at index 2 (3 - 1)
     * 
     * Condition: The condition nums[i] != nums[nums[i] - 1] ensures that the 
     * current number nums[i] is not already in its correct position. 
     * If it is not, we perform a swap to place it correctly.
     * 
     * After the rearrangement, the array should ideally look like this: 
     * [1, 2, 3, 4, 5]. Each number i should be at index i - 1.
     * If the value at index i is not i + 1, it means the smallest missing positive 
     * integer is i + 1.
     * 
     * @param nums 
     * 
     * @return 
     */
    public static int smallestPositiveMissing(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // positive integers, valid range for reordering, correct position = no swap
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        // if num not at correct index, missing num is index + 1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        // if all nums at correct position, return n + 1
        return n + 1;
    }

    public static void main(String[] args) {    
        int[][] testCases = {
            {}, // Empty array
            {1}, // Single element - Positive
            {-1}, // Single element - Negative
            {0}, // Single element - Zero
            {-3, -2, -1}, // All negative numbers
            {2, 3, 4}, // Array with positive numbers not starting from 1
            {3, 4, -1, 1}, // Array with mixed positive and negative numbers
            {1, 2, 3, 4, 5}, // All positive numbers in sequence
            {1, 1, 2, 2}, // Array with duplicates
            {1000, 2000, 3000}, // Array with large numbers
            {2, 1} // Array with n and n-1 elements
        };
        
        for (int[] nums : testCases) {
            System.out.println("Array: " + java.util.Arrays.toString(nums) + " => Smallest missing positive: " + smallestPositiveMissing(nums));
        }
        }

}


