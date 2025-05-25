package algos.DP.TopDownMemoization;

public class FindNthStep {

   public static int climbStairs(int n) {
      int[] dp = new int[n + 1];

      // Base cases
      dp[0] = 1; // 1st step
      dp[1] = 2; // 2nd step

      for (int i = 2; i < dp.length; i++) {
         dp[i] = dp[i - 1] + dp[i - 2];
      }

      return dp[n - 1]; // nth step
   }

   public static void main(String[] args) {
      System.out.println(climbStairs(5));
   }
}
