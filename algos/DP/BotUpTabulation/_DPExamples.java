package algos.DP.BotUpTabulation;

import java.util.Arrays;

/**
 * DynamicProgrammingExamples class contains common dynamic programming problems
 * and their solutions using bottom-up tabulation.
 */
public class _DPExamples {

   /**
    * Calculates the n-th Fibonacci number using bottom-up tabulation.
    *
    * @param n The index of the Fibonacci number to calculate.
    * @return The n-th Fibonacci number.
    */

   public static int fibonacci(int n) {
      if (n <= 1) {
         return n;
      }
      int[] dp = new int[n + 1];
      dp[0] = 0;
      dp[1] = 1;
      for (int i = 2; i <= n; i++) {
         // Each Fibonacci number is the sum of the two preceding ones.
         dp[i] = dp[i - 1] + dp[i - 2];
      }
      return dp[n];
   }

   // -----------------------------------------------------
   /**
    * Finds the length of the longest increasing subsequence in an array using bottom-up tabulation.
    *
    * @param nums The input array.
    * @return The length of the longest increasing subsequence.
    */
   public static int longestIncreasingSubsequence(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      Arrays.fill(dp, 1);

      for (int i = 1; i < n; i++) {
         for (int j = 0; j < i; j++) {
            // If the current element is greater than the previous elements,
            // update the length of the increasing subsequence.
            if (nums[i] > nums[j]) {
               dp[i] = Math.max(dp[i], dp[j] + 1); //which means including nums[i] in the subsequence ending at j
            }
         }
      }

      //   int maxLIS = 0;
      //   for (int length : dp) maxLIS = Math.max(maxLIS, length);
      //   return maxLIS;

      // Return the maximum length among all possible increasing subsequences in the array
      return Arrays.stream(dp).max().orElse(0);
   }

   // -----------------------------------------------------
   /**
    * Finds the minimum number of coins needed to make up a given amount using bottom-up tabulation.
    *
    * @param coins  The set of available coins.
    * @param amount The target amount.
    * @return The minimum number of coins needed.
    */
   public static int coinChange(int[] coins, int amount) {
      if (amount == 0) {
         return 0; // Base case: No coins needed for amount 0.
      }

      // Create an array to store the minimum number of coins needed for each amount.
      int[] dp = new int[amount + 1];
      Arrays.fill(dp, amount + 1);
      dp[0] = 0; // Base case: 0 coins needed for amount 0.

      // Iterate through each coin and update the minimum number of coins needed for each amount.
      for (int coin : coins) {
         for (int i = coin; i <= amount; i++) {
            // Update the minimum number of coins needed for each amount.
            // Choose the minimum between the current value and the value using the current coin.
            dp[i] = Math.min(dp[i], dp[i - coin] + 1);
         }
      }
      // If dp[amount] > amount, no valid combination found, return -1. Otherwise, return the result.
      return dp[amount] > amount ? -1 : dp[amount];
   }

   // -----------------------------------------------------
   /**
    * Finds the most efficient way to multiply a sequence of matrices using bottom-up tabulation.
    *
    * @param dimensions The dimensions of matrices.
    * @return The minimum number of scalar multiplications needed for multiplication.
    */
   public static int matrixChainMultiplication(int[] dimensions) {
      int n = dimensions.length - 1;
      int[][] dp = new int[n][n];

      // Base case: Chain length 1, no multiplications needed.
      for (int i = 0; i < n; i++) {
         dp[i][i] = 0;
      }

      // Iterate over subproblems of different lengths (chain lengths).
      for (int len = 2; len <= n; len++) {
         for (int i = 0; i <= n - len; i++) { // Corrected loop bounds
            int j = i + len - 1;
            dp[i][j] = Integer.MAX_VALUE;

            // Iterate over possible split points in the subchain.
            for (int k = i; k < j; k++) { // Corrected loop condition
               // Calculate the cost of multiplying matrices from i to k and k+1 to j.
               int cost =
                  dp[i][k] + dp[k + 1][j] + dimensions[i] * dimensions[k + 1] * dimensions[j + 1];
               dp[i][j] = Math.min(dp[i][j], cost);
            }
         }
      }
      // Return the minimum number of scalar multiplications needed for the entire chain.
      return dp[0][n - 1];
   }

   // -----------------------------------------------------
   /**
    * Finds the maximum sum of non-adjacent numbers in an array using bottom-up tabulation.
    *
    * @param nums The input array.
    * @return The maximum sum of non-adjacent numbers.
    */
   public static int maxSumNonAdjacent(int[] nums) {
      int n = nums.length;

      if (n == 0) {
         return 0; // Base case: Empty array, maximum sum is 0.
      }

      if (n == 1) {
         return nums[0]; // Base case: Array with one element, maximum sum is the element itself.
      }

      int[] dp = new int[n];
      dp[0] = nums[0];
      dp[1] = Math.max(nums[0], nums[1]);

      for (int i = 2; i < n; i++) {
         // Update the maximum sum considering both the current element and the previous element.
         dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
      }

      // Return the maximum sum among all possible subarrays.
      return dp[n - 1];
   }

   // -----------------------------------------------------
   /**
    * Finds the minimum cost to reach the bottom-right cell of a grid from the top-left cell
    * by moving only right or down using bottom-up tabulation.
    *
    * @param grid The input grid with costs.
    * @return The minimum cost to reach the bottom-right cell.
    */
   public static int minCostPath(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int[][] dp = new int[m][n];
      dp[0][0] = grid[0][0];

      // Initialize the first row and first column.
      for (int i = 1; i < m; i++) {
         dp[i][0] = dp[i - 1][0] + grid[i][0];
      }

      for (int j = 1; j < n; j++) {
         dp[0][j] = dp[0][j - 1] + grid[0][j];
      }

      // Fill the dp table.
      for (int i = 1; i < m; i++) {
         for (int j = 1; j < n; j++) {
            // Choose the minimum cost from the cell above or the cell on the left.
            dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
         }
      }

      return dp[m - 1][n - 1];
   }

   // -----------------------------------------------------
   /**
    * Calculates the total number of ways to climb to the top of a staircase with n steps
    * by taking one or two steps at a time using bottom-up tabulation.
    *
    * @param n The number of steps in the staircase.
    * @return The total number of ways to climb to the top.
    */
   public static int climbStairs(int n) {
      if (n <= 2) {
         return n; // Base cases: 1 way for 1 step, 2 ways for 2 steps.
      }

      int[] dp = new int[n + 1];
      dp[1] = 1;
      dp[2] = 2;

      // Fill the dp table.
      for (int i = 3; i <= n; i++) {
         dp[i] = dp[i - 1] + dp[i - 2];
      }

      return dp[n];
   }

   // -----------------------------------------------------
   /**
    * Finds the minimum number of jumps needed to reach the end of the array.
    *
    * @param nums The input array where each element represents the maximum jump
    *             length.
    * @return The minimum number of jumps needed.
    */

   public static int jump(int[] nums) {
      int n = nums.length;

      // dp[i] represents the minimum number of jumps needed to reach index i
      int[] dp = new int[n];
      Arrays.fill(dp, Integer.MAX_VALUE);

      // Base case: No jumps needed to reach the start
      dp[0] = 0;

      for (int i = 1; i < n; i++) {
         // Try to reach index i from all the indices before it
         for (int j = 0; j < i; j++) {
            // If it's possible to reach i from j
            if (j + nums[j] >= i) {
               // Update the minimum number of jumps needed for index i
               dp[i] = Math.min(dp[i], dp[j] + 1);
            }
         }
      }

      // The final result is the minimum jumps needed to reach the end
      return dp[n - 1];
   }

   // -----------------------------------------------------
   /**
    * Finds the maximum sum subarray using Kadane's algorithm.
    *
    * @param nums The input array.
    * @return The maximum sum of a subarray.
    */
   public static int maxSubarraySum(int[] nums) {
      if (nums == null || nums.length == 0) {
         return 0;
      }

      int currentSum = nums[0];
      int maxSum = nums[0];

      for (int i = 1; i < nums.length; i++) {
         // The currentSum represents the maximum sum ending at index i
         currentSum = Math.max(nums[i], currentSum + nums[i]);
         // Update the overall maximum sum
         maxSum = Math.max(maxSum, currentSum);
      }

      // The final result is the maximum sum of a subarray
      return maxSum;
   }

   // -----------------------------------------------------
   public static int longestPalindromeSubsequence(String s) {
      int n = s.length();

      // Create a 2D DP table to store the lengths of LPS for substrings
      int[][] dp = new int[n][n];

      // All substrings of length 1 are palindromes
      for (int i = 0; i < n; i++) {
         dp[i][i] = 1;
      }

      // Fill the DP table in a bottom-up manner
      for (int cl = 2; cl <= n; cl++) {
         for (int i = 0; i < n - cl + 1; i++) {
            int j = i + cl - 1;
            if (s.charAt(i) == s.charAt(j) && cl == 2) {
               dp[i][j] = 2;
            } else if (s.charAt(i) == s.charAt(j)) {
               dp[i][j] = dp[i + 1][j - 1] + 2;
            } else {
               dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
         }
      }

      // Length of LPS for the entire string is stored in the top-right cell of the DP table
      return dp[0][n - 1];
   }

   public static void main(String[] args) {
      // Example 1: Fibonacci
      int fibonacciResult = fibonacci(5);
      System.out.println("Fibonacci(5): " + fibonacciResult);

      // Example 2: Longest Increasing Subsequence
      int[] lisArray = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
      int lisResult = longestIncreasingSubsequence(lisArray);
      System.out.println("Longest Increasing Subsequence: " + lisResult);

      // Example 3: Coin Change
      int[] coins = { 1, 2, 5 };
      int amount = 11;
      int coinChangeResult = coinChange(coins, amount);
      System.out.println("Coin Change for amount " + amount + ": " + coinChangeResult);

      // Example 4: Matrix Chain Multiplication
      int[] matrixDimensions = { 30, 35, 15, 5, 10, 20, 25 };
      int matrixChainResult = matrixChainMultiplication(matrixDimensions);
      System.out.println("Matrix Chain Multiplication: " + matrixChainResult);

      // Test maxSumNonAdjacent
      int[] nums1 = { 2, 7, 9, 3, 1 };
      System.out.println("Max Sum Non-Adjacent: " + maxSumNonAdjacent(nums1)); // Output: 12

      // Test minCostPath
      int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
      System.out.println("Min Cost Path: " + minCostPath(grid)); // Output: 7

      // Test climbStairs
      int n = 5;
      System.out.println("Climb Stairs: " + climbStairs(n)); // Output: 8

      // Test jump
      int[] nums2 = { 2, 3, 1, 1, 4 };
      System.out.println("Jump: " + jump(nums2)); // Output: 2

      // Test maxSubarraySum
      int[] nums3 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
      System.out.println("Max Subarray Sum: " + maxSubarraySum(nums3)); // Output: 6

      // Test Longest Palindromic Subsequence
      String palindromicString = "bbbab";
      System.out.println(
         "Longest Palindromic Subsequence: " + longestPalindromeSubsequence(palindromicString)
      ); // Output: 4
   }
}
