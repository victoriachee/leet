/** 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number
 *
 * !EASY
 * #DP  #Iteration  #Recursion  #Memoization
 *
 * The Fibonacci numbers form a sequence, denoted F(n), where each number is the sum of the
 * two preceding ones. Starting from F(0) = 0 and F(1) = 1, the sequence is defined as:
 * F(n) = F(n - 1) + F(n - 2), for n > 1. Given 'n', calculate the value of F(n).
 *
 * Example 1: Input: n = 2 Output: 1 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2: Input: n = 3 Output: 2 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3: Input: n = 4 Output: 3 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * Constraints: 0 <= n <= 30
 */

package algos.DP.TopDownMemoization;

public class FindNthFibonacci {

   /** Recursive with Memoization (Caching of preceding results) **/
   /**
    * @param n Index of fibonacci number.
    * @return Fibonacci number at index n, where F(n) = F(n-1) + F(n-2).
    */
   public static int fib(int n) {
      int[] dp = new int[n + 1]; // Default int[] values are 0
      return fib(n, dp);
   }

   public static int fib(int n, int[] dp) {
      if (n < 2) return n; // Base cases: F(0) = 0 & F(1) = 1, return n
      if (dp[n] != 0) return dp[n]; // Check if dp[n] has been cached before
      dp[n] = fib(n - 1, dp) + fib(n - 2, dp); // Calc F(n), cache in dp[n]
      return dp[n];
   }

   //----------------------------------------------------------

   /** Iterative: The iterative approach is often more space-efficient. **/
   public static int fibIterative(int n) {
      if (n == 0 || n == 1) return n; // Base case: 0 or 1, skip iterations

      int[] dp = new int[n + 1]; // Default int[] values are 0

      dp[0] = 0; // Base case: fib at index 0 = 0
      dp[1] = 1; // Base case: fib at index 1 = 1

      for (int i = 2; i < n + 1; i++) {
         dp[i] = dp[i - 1] + dp[i - 2]; // F(n) = F(n-1) + F(n-2)
      }

      return dp[n];
   }

   public static void main(String[] args) {
      int index1 = 1;
      int index2 = 30;
      System.out.println("Without memoization & recursion:");
      System.out.println(index1 + ": " + fibIterative(index1));
      System.out.println(index2 + ": " + fibIterative(index2));
      System.out.println("With memoization & recursion:");
      System.out.println(index1 + ": " + fib(index1));
      System.out.println(index2 + ": " + fib(index2));
   }
}
