/**
 * The {@code SumRange} class efficiently computes the sum of ranges in an array using
 * precomputed prefix sums.
 *
 * Cumulative sums are stored in the {@code prefixSum} array during object initialization,
 * enabling quick calculation of the sum of any given range.
 * 
 * <pre>
 * {@code
 *   int[] nums = {1, 2, 3, 4};
 *   SumRange sumRange = new SumRange(nums);
 *   int sum = sumRange.sumRange(1, 3); // Returns the sum of elements from index 1 to 3 (2 + 3 + 4)
 * }
 * </pre>
 *
 * *This approach optimizes range sum queries in an array, reducing time complexity
 * *from O(n) to O(1) for each query after the initial preprocessing.
 */

package patterns.PrefixSuffix;

public class CalculateSumOfRange {

    /**
     * Array to store the prefix sum values.
     */
    int[] prefixSum;

    /**
     * Constructs a CalculateSumOfRange object with the given array of numbers.
     *
     * @param nums The array of numbers for which the prefix sum is calculated.
     */
    public CalculateSumOfRange(int[] nums) {
        // Initialize prefixSum array with the same values as nums
        prefixSum = nums; // pass-by pointer

        // Calculate prefix sum for each index in the array
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }

    /**
     * Calculates the sum of elements within a specified range [left, right] in the original array.
     *
     * @param left  The left index of the range.
     * @param right The right index of the range.
     * @return The sum of elements in the specified range.
     */
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        } else {
            // Sum of elements from index left to right is calculated as:
            // prefixSum[right] - prefixSum[left - 1]
            return prefixSum[right] - prefixSum[left - 1];
        }
    }

    /**
     * Main method for testing the CalculateSumOfRange class.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        // Create a CalculateSumOfRange object
        CalculateSumOfRange numArray = new CalculateSumOfRange(nums);

        // Test the sumRange method
        int result1 = numArray.sumRange(2, 3);
        System.out.println("Sum from index 2 to 3: " + result1); // Output: 7

        // Test another range
        int result2 = numArray.sumRange(1, 2);
        System.out.println("Sum from index 1 to 2: " + result2); // Output: 5
    }
}
