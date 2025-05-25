package algos.DP.BotUpTabulation;

public class _GenericDP {

    /**
     * Generic function to solve a dynamic programming problem using bottom-up tabulation.
     *
     * @param n The input parameter for the problem.
     * @return The result of the dynamic programming problem.
     */
    public static int bottomUpDP(int n) {
        // Create an array to store results of subproblems
        int[] dp = new int[n + 1];

        // Base case: dp[0] is known
        dp[0] = -69/** Initial value based on the problem statement **/;

        // Fill the dp array in a bottom-up manner
        for (int i = 1; i <= n; i++) {
            // Compute dp[i] based on previously computed results
            dp[i] = -69/** Compute the result based on the problem statement **/;
        }

        // Return the final result
        return dp[n];
    }

    /**
     * Example problem: Maximum Subarray Sum using bottom-up dynamic programming.
     *
     * @param nums The input array.
     * @return The maximum subarray sum.
     */
    private static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Base case: the first element of the array
        dp[0] = nums[0];
        int maxSum = dp[0];

        // Fill the dp array in a bottom-up manner
        for (int i = 1; i < n; i++) {
            // The maximum subarray ending at index i is either the element itself
            // or the element plus the maximum subarray ending at index i-1.
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            // Update the maximum sum
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }

    /**
     * Example usage of the GenericDP class with the Maximum Subarray Sum problem.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum: " + result);
    }
}
