package practice.TwoPointers;

public class SquaresOfSortedArray {

    /**
        * TC: O(n)
        * Finds array of the squares of each number sorted in non-decreasing order.
        * 
        * . Edge cases:
        *   - Negative numbers, Zeros, Positive numbers
        *   - Large numbers
        *   - Empty array
        * . Method
        *   1. input array is sorted, can have negative values - hence start from end of res
        *   2. res array same size as input array
        *   3. left and right pointer in the input array
        *   4. compare their abs values
        *   5. add larger squared value to end of res array and move pointer inwards
        *
        * Follow up: Squaring each element and sorting the new array is very trivial, 
        * could you find an O(n) solution using a different approach?
        * 
        * @param arr The sorted input array.
        * @return The squares of each number.
    */
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left = 0; 
        int right = nums.length - 1;

        for (int i = res.length - 1; i >= 0; i--) {
            int leftVal = Math.abs(nums[left]);
            int rightVal = Math.abs(nums[right]);
            if (leftVal > rightVal) {
                res[i] = leftVal * leftVal;
                left++;
            } else {
                res[i] = rightVal * rightVal;
                right--;
            }
        }
        return res;
    }   

    public static void main(String[] args) {
        // Define test cases
        int[][] testCases = {
            {}, // Empty array
            {0}, // Single element
            {1}, // Single positive element
            {-1}, // Single negative element
            {1, 2, 3}, // All positive numbers
            {-3, -2, -1}, // All negative numbers
            {-4, -1, 0, 3, 10}, // Mixed positive and negative numbers
            {-1, 0, 1}, // Array with zero
            {-2, -2, 2, 2}, // Duplicates
            {-10000, 10000} // Large numbers
        };

        // Run and print results for each test case
        for (int[] testCase : testCases) {
            int[] result = sortedSquares(testCase);
            System.out.print("Input: " + java.util.Arrays.toString(testCase) + " => Output: ");
            System.out.println(java.util.Arrays.toString(result));
        }
    }

    /*
    Step-by-Step Explanation:
    
    *Understanding the Problem:

    .We are given a sorted array of integers (which can include negative numbers).
    .We need to return a new array containing the squares of these integers, sorted in non-decreasing order.
    .A brute force approach would square each element and then sort the array, resulting in 
    O(nlogn) time complexity. 
    .We need to achieve this in O(n) time complexity.
    
    *Plan:

    .Use a two-pointer technique:
        -One pointer (left) starting from the beginning of the array.
        -Another pointer (right) starting from the end of the array.
    .Compare the absolute values of the elements at these two pointers.
    .Place the larger square value at the end of a result array and move the corresponding pointer inward.
    .Repeat until all elements are processed.
    
    *Implementation Details:
    .Initialize the result array with the same length as the input array.
    .Use a loop to iterate from the end of the result array to the beginning.
    .In each iteration, compare the absolute values of elements at left and right.
    .Insert the larger square value at the current position in the result array.
    .Move the pointer (either left or right) inward.
    .Continue this process until the result array is fully populated.
     */
}
