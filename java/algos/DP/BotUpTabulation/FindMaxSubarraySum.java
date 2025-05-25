/**
 * FindMaxSubarraySum class contains a method to determine the maximum sum of a subarray in an integer array.
 * The class uses the dynamic programming approach with top-down memoization.
 */
package algos.DP.BotUpTabulation;

public class FindMaxSubarraySum {

    /**
     * Calculates the maximum sum of a subarray in the given integer array.
     *
     * @param nums The input array of integers.
     * @return The maximum sum of a subarray.
     */
    public static int maxSubArray(int[] nums) {
        // Check for null or empty input array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int maxSum = dp[0];

        // Iterate through the array to find the maximum sum
        for (int i = 1; i < n; i++) {
            // The maximum subarray ending at index i is either the element itself
            // or the element plus the maximum subarray ending at index i-1.
            // Start a new subarray or take the previous element
            // dp[i] is the max sum of subarray elems, nums[i] is the curr elem
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            // Update the maximum sum
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    /**
     * The main method demonstrates the usage of the maxSubArray method with sample input arrays.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1)); // Output: 6 (subarray [4, -1, 2, 1])

        int[] nums2 = {1};
        System.out.println(maxSubArray(nums2)); // Output: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums3)); // Output: 23 (subarray [5, 4, -1, 7, 8])
    }
}
