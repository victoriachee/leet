package practice.CyclicSort;

public class SmallestPositiveMissing {
    
    /**
     * https://leetcode.com/problems/first-missing-positive/description/
     * https://www.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1
     * Function to find the smallest positive number missing from the unsorted array
     * 
     * The function `firstMissingPositive` rearranges an array of integers to place each number in its
     * correct position and then finds the first missing positive integer.
     * 
     * 
     * @param nums The `nums` parameter is an array of integers containing positive and negative
     * numbers. T
     * @return The method `firstMissingPositive` returns the first missing positive integer in the
     * input array `nums`. If all positive integers from 1 to n are present in the array, it returns n
     * + 1.
     */
    public static int smallestPositiveMissing(int[] nums) {
        int n = nums.length;

        // Place each number in its correct position
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find the first number (index + 1) where the number is not correct
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positions are correct, the missing number is n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("The smallest missing positive integer is: " + smallestPositiveMissing(nums));
        // Output: The smallest missing positive integer is: 2
    }
}
