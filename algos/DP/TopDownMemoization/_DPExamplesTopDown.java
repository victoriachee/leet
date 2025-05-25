package algos.DP.TopDownMemoization;

import java.util.Arrays;

public class _DPExamplesTopDown {

   /**
    * Example 1: Fibonacci Numbers using Memoization.
    *
    * @param n The Fibonacci sequence index.
    * @return The nth Fibonacci number.
    */
   public static int fibonacci(int n) {
      int[] memo = new int[n + 1];
      Arrays.fill(memo, -1);
      return fibonacciHelper(n, memo);
   }

   private static int fibonacciHelper(int n, int[] memo) {
      if (n <= 1) {
         return n; // Base cases: F(0) = 0, F(1) = 1
      }

      if (memo[n] != -1) {
         return memo[n]; // Return the memoized result if available
      }

      // Recursive calculation
      memo[n] = fibonacciHelper(n - 1, memo) + fibonacciHelper(n - 2, memo);
      return memo[n];
   }

   // -------------------------------------------
   /**
    * Example 2: Count Ways to Reach the Nth Stair using Memoization.
    *
    * @param n The number of stairs.
    * @return The number of ways to reach the top.
    */
   public static int countWaysToReachTop(int n) {
      int[] memo = new int[n + 1];
      Arrays.fill(memo, -1);
      return countWaysHelper(n, memo);
   }

   private static int countWaysHelper(int n, int[] memo) {
      if (n <= 1) {
         return 1; // Base case: There is 1 way to reach the first or second stair
      }

      if (memo[n] != -1) {
         return memo[n]; // Return the memoized result if available
      }

      // Recursive calculation
      memo[n] = countWaysHelper(n - 1, memo) + countWaysHelper(n - 2, memo);
      return memo[n];
   }

   // -------------------------------------------
   /**
    * Example 3: Longest Increasing Subsequence using Memoization.
    *
    * @param nums The input array.
    * @return The length of the longest increasing subsequence.
    */
   public static int longestIncreasingSubsequence(int[] nums) {
      int n = nums.length;
      int[] memo = new int[n];
      Arrays.fill(memo, -1);
      return LISHelper(nums, n - 1, memo);
   }

   private static int LISHelper(int[] nums, int endIndex, int[] memo) {
      if (endIndex == 0) {
         return 1; // Base case: LIS of a single element is 1
      }

      if (memo[endIndex] != -1) {
         return memo[endIndex]; // Return the memoized result if available
      }

      int maxLIS = 1; // Minimum LIS is 1 for any element
      for (int i = 0; i < endIndex; i++) {
         if (nums[i] < nums[endIndex]) {
            maxLIS = Math.max(maxLIS, 1 + LISHelper(nums, i, memo));
         }
      }

      memo[endIndex] = maxLIS;
      return maxLIS;
   }

   // -------------------------------------------
   /**
    * Example 4: Minimum Steps to One using Memoization.
    *
    * @param n The target number.
    * @return The minimum number of steps to reduce n to 1.
    */
   public static int minStepsToOne(int n) {
      int[] memo = new int[n + 1];
      Arrays.fill(memo, -1);
      return minStepsToOneHelper(n, memo);
   }

   private static int minStepsToOneHelper(int n, int[] memo) {
      if (n == 1) {
         return 0; // Base case: Already at 1, no steps needed
      }

      if (memo[n] != -1) {
         return memo[n]; // Return the memoized result if available
      }

      int minSteps = 1 + minStepsToOneHelper(n - 1, memo); // Subtract 1
      if (n % 2 == 0) {
         minSteps = Math.min(minSteps, 1 + minStepsToOneHelper(n / 2, memo)); // Divide by 2
      }
      if (n % 3 == 0) {
         minSteps = Math.min(minSteps, 1 + minStepsToOneHelper(n / 3, memo)); // Divide by 3
      }

      memo[n] = minSteps;
      return minSteps;
   }

   // -------------------------------------------
   /**
    * Example 5: Subset Sum using Memoization.
    *
    * @param nums   The input array.
    * @param target The target sum.
    * @return True if there exists a subset with the given sum, otherwise false.
    */
   public static boolean subsetSum(int[] nums, int target) {
      int n = nums.length;
      Boolean[][] memo = new Boolean[n][target + 1];
      return subsetSumHelper(nums, n - 1, target, memo);
   }

   private static boolean subsetSumHelper(int[] nums, int endIndex, int target, Boolean[][] memo) {
      if (target == 0) {
         return true; // Base case: Subset with sum 0 always exists
      }

      if (endIndex < 0 || target < 0) {
         return false; // Base case: No more elements or negative target
      }

      if (memo[endIndex][target] != null) {
         return memo[endIndex][target]; // Return the memoized result if available
      }

      // Include or exclude the current element in the subset
      boolean include = subsetSumHelper(nums, endIndex - 1, target - nums[endIndex], memo);
      boolean exclude = subsetSumHelper(nums, endIndex - 1, target, memo);

      memo[endIndex][target] = include || exclude;
      return memo[endIndex][target];
   }

   // -------------------------------------------
   /**
    * Example 6: Edit Distance using Memoization.
    *
    * @param word1 The first string.
    * @param word2 The second string.
    * @return The minimum number of operations required to convert word1 to word2.
    */
   public static int editDistance(String word1, String word2) {
      int m = word1.length();
      int n = word2.length();
      int[][] memo = new int[m + 1][n + 1];
      for (int[] row : memo) {
         Arrays.fill(row, -1);
      }
      return editDistanceHelper(word1, word2, m, n, memo);
   }

   private static int editDistanceHelper(String word1, String word2, int m, int n, int[][] memo) {
      if (m == 0) {
         return n; // Base case: First string is empty, insert all characters from the second string
      }

      if (n == 0) {
         return m; // Base case: Second string is empty, delete all characters from the first string
      }

      if (memo[m][n] != -1) {
         return memo[m][n]; // Return the memoized result if available
      }

      int cost = (word1.charAt(m - 1) == word2.charAt(n - 1)) ? 0 : 1;

      // Min of three operations: Insert, Delete, Replace
      int minOperations = Math.min(
         Math.min(
            1 + editDistanceHelper(word1, word2, m, n - 1, memo), // Insert
            1 + editDistanceHelper(word1, word2, m - 1, n, memo)
         ), // Delete
         cost + editDistanceHelper(word1, word2, m - 1, n - 1, memo)
      ); // Replace

      memo[m][n] = minOperations;
      return minOperations;
   }

   // -------------------------------------------
   /**
    * Example 7: Coin Change Problem using Memoization.
    *
    * @param coins  The set of available coins.
    * @param amount The target amount.
    * @return The minimum number of coins needed.
    */
   public static int coinChange(int[] coins, int amount) {
      int[] memo = new int[amount + 1];
      Arrays.fill(memo, -1);
      return coinChangeHelper(coins, amount, memo);
   }

   private static int coinChangeHelper(int[] coins, int amount, int[] memo) {
      if (amount == 0) {
         return 0; // Base case: No coins needed for amount 0
      }

      if (amount < 0) {
         return -1; // Invalid case: Cannot make change for negative amount
      }

      if (memo[amount] != -1) {
         return memo[amount]; // Return the memoized result if available
      }

      int minCoins = Integer.MAX_VALUE;

      for (int coin : coins) {
         int subproblem = coinChangeHelper(coins, amount - coin, memo);
         if (subproblem != -1) {
            minCoins = Math.min(minCoins, 1 + subproblem);
         }
      }

      memo[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
      return memo[amount];
   }

   // -------------------------------------------
   /**
    * Example 8: Unique Paths in a Grid using Memoization.
    *
    * @param m The number of rows in the grid.
    * @param n The number of columns in the grid.
    * @return The total number of unique paths from the top-left to the bottom-right corner.
    */
   public static int uniquePaths(int m, int n) {
      int[][] memo = new int[m][n];
      for (int[] row : memo) {
         Arrays.fill(row, -1);
      }
      return uniquePathsHelper(m - 1, n - 1, memo);
   }

   private static int uniquePathsHelper(int row, int col, int[][] memo) {
      if (row == 0 || col == 0) {
         return 1; // Base case: Only one way to reach any cell in the first row or column
      }

      if (memo[row][col] != -1) {
         return memo[row][col]; // Return the memoized result if available
      }

      int pathsTop = uniquePathsHelper(row - 1, col, memo);
      int pathsLeft = uniquePathsHelper(row, col - 1, memo);

      memo[row][col] = pathsTop + pathsLeft;
      return memo[row][col];
   }

   /**
    * Example 11: Longest Palindromic Subsequence using Memoization.
    *
    * @param s The input string.
    * @return The length of the longest palindromic subsequence.
    */
   public static int longestPalindromeSubseq(String s) {
      int[][] memo = new int[s.length()][s.length()];
      for (int[] row : memo) {
         Arrays.fill(row, -1);
      }
      return longestPalindromeSubseqHelper(s, 0, s.length() - 1, memo);
   }

   private static int longestPalindromeSubseqHelper(String s, int start, int end, int[][] memo) {
      if (start > end) {
         return 0; // Base case: Empty subsequence has length 0
      }

      if (start == end) {
         return 1; // Base case: Single character subsequence has length 1
      }

      if (memo[start][end] != -1) {
         return memo[start][end]; // Return the memoized result if available
      }

      int maxLength;
      if (s.charAt(start) == s.charAt(end)) {
         maxLength = 2 + longestPalindromeSubseqHelper(s, start + 1, end - 1, memo);
      } else {
         int option1 = longestPalindromeSubseqHelper(s, start + 1, end, memo);
         int option2 = longestPalindromeSubseqHelper(s, start, end - 1, memo);
         maxLength = Math.max(option1, option2);
      }

      memo[start][end] = maxLength;
      return maxLength;
   }

   // -------------------------------------------
   public static void main(String[] args) {
      // Test Fibonacci
      int fibIndex = 5;
      System.out.println("Fibonacci(" + fibIndex + "): " + fibonacci(fibIndex)); // Output: 5

      // Test Count Ways to Reach Top
      int stairs = 4;
      System.out.println("Ways to Reach Top(" + stairs + "): " + countWaysToReachTop(stairs)); // Output: 5

      // Test Longest Increasing Subsequence
      int[] sequence = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
      System.out.println(
         "Longest Increasing Subsequence: " + longestIncreasingSubsequence(sequence)
      ); // Output: 6

      // Test Min Steps to One
      int stepsTarget = 10;
      System.out.println("Min Steps to One(" + stepsTarget + "): " + minStepsToOne(stepsTarget)); // Output: 3

      // Test Subset Sum
      int[] subsetSumArray = { 3, 34, 4, 12, 5, 2 };
      int subsetSumTarget = 9;
      System.out.println("Subset Sum: " + subsetSum(subsetSumArray, subsetSumTarget)); // Output: true

      // Test Edit Distance
      String editWord1 = "horse";
      String editWord2 = "ros";
      System.out.println("Edit Distance: " + editDistance(editWord1, editWord2)); // Output: 3

      // Test Coin Change Problem
      int[] coins = { 1, 2, 5 };
      int amount = 11;
      System.out.println("Coin Change: " + coinChange(coins, amount)); // Output: 3

      // Test Unique Paths in a Grid
      int gridRows = 3;
      int gridCols = 7;
      System.out.println("Unique Paths: " + uniquePaths(gridRows, gridCols)); // Output: 28

      // Test Longest Palindromic Subsequence
      String palindromicString = "bbbab";
      System.out.println(
         "Longest Palindromic Subsequence: " + longestPalindromeSubseq(palindromicString)
      ); // Output: 4
   }
}
