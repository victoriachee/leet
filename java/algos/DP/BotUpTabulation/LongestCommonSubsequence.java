/**
 * Problem 1143: Longest Common Subsequence (Medium)
 * !! MEDIUM
 * #DynamicProgramming  #String
 *
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 * If none, return 0.
 *
 * Example 1: "abcde" & "ace" => Output: 3 (LCS: "ace")
 * Example 2: "abc" & "abc" => Output: 3 (LCS: "abc")
 * Example 3: "abc" & "def" => Output: 0 (No common subsequence)
 *
 * Constraints: 1 <= text1.length, text2.length <= 1000
 * text1 and text2 consist of only lowercase English characters.
 */
package algos.DP.BotUpTabulation;

public class LongestCommonSubsequence {

   public static int longestCommonSubsequence(String text1, String text2) {
      int lenC = text1.length(); // to be cols
      int lenR = text2.length(); // to be rows

      int[][] dp = new int[lenR + 1][lenC + 1]; // Each cell contains 0 by default

      // Fill array using bottom-up dynamic programming, start from dp[1][1]
      for (int c = 1; c <= lenC; c++) {
         // Explore each char of text2 first (each row) & compare it to 1st char of text1 (col 1)
         for (int r = 1; r <= lenR; r++) {
            // If the characters match, extend the LCS by 1
            if (text1.charAt(c - 1) == text2.charAt(r - 1)) {
               dp[r][c] = dp[r - 1][c - 1] + 1;
            } else {
               // If characters don't match, take the maximum length of the
               // adjacent cells to the top or left of the current cell
               dp[r][c] = Math.max(dp[r - 1][c], dp[r][c - 1]);
            }
         }
      }
      // The length of the LCS is stored in the bottom-right cell of the dp array @see below
      return dp[lenR][lenC];
   }

   public static void main(String[] args) {
      // Example Usage:
      String text1 = "abcde";
      String text2 = "ace";
      int result = longestCommonSubsequence(text1, text2);
      System.out.println("Longest Common Subsequence: " + result);
   }
}

/**
   s1 = "abcde"
   s2 = "ace"
   Initialization of the dp table:

           0   1   2   3  
         |   | a | c | e |
      ---|---|---|---|---|
   0     | 0 | 0 | 0 | 0 |
   1  a  | 0 |   |   |   |
   2  b  | 0 |   |   |   |
   3  c  | 0 |   |   |   |
   4  d  | 0 |   |   |   |
   5  e  | 0 |   |   |   |

   1. For text1.charAt(0) (which is 'a') and text2.charAt(0) (which is 'a'), the characters match. 
      So, dp[1][1] = dp[0][0] + 1 = 1.
   2. For text1.charAt(1) (which is 'b') and text2.charAt(1) (which is 'c'), the characters do not 
      match. Here, we take the maximum of the adjacent cells: dp[2][1] = max(dp[1][1], dp[2][0]) = max(1, 0) = 1.
   3. Fill in the rest of the cells in the table.

   Final dp table:

           0   1   2   3   
         |   | a | c | e |
      ---|---|---|---|---|
   0     | 0 | 0 | 0 | 0 |
   1  a  | 0 | 1 | 1 | 1 |
   2  b  | 0 | 1 | 1 | 1 |
   3  c  | 0 | 1 | 2 | 2 |
   4  d  | 0 | 1 | 2 | 2 |
   5  e  | 0 | 1 | 2 | 3 |
 */
