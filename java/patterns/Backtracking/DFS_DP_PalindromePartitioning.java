/**
 * Problem 131: Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 *
 * !! MEDIUM
 * #Backtracking  #DynamicProgramming
 *
 * Given a string 's', partition it such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of 's'.
 *
 * Example 1: Input: s = "aab" Output: [["a","a","b"],["aa","b"]]
 * Example 2: Input: s = "a" Output: [["a"]]
 * Example 2: Input: s = "abba" Output: [["a","b","b","a"],["a","bb","a"],
 * ;                       ["abba"]]
 *
 * Constraints: 1 <= s.length <= 16 's' contains only lowercase English letters.
 */
package patterns.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class DFS_DP_PalindromePartitioning {

   // Main method to find all possible palindrome partitions
   public List<List<String>> partition(String s) {
      List<List<String>> result = new ArrayList<>();

      // Start the backtracking process
      backtrack(0, new ArrayList<>(), result, s);

      // Return the final result
      return result;
   }

   // Helper method for backtracking
   private void backtrack(int index, List<String> currPart, List<List<String>> res, String s) {
      // If we have reached the end of the string, add the current partition to the result
      if (index == s.length()) {
         res.add(new ArrayList<>(currPart));
         return;
      }

      // Explore all possible partitions starting from the current index
      for (int end = index + 1; end <= s.length(); end++) {
         // Check if the substring from current index to end is a palindrome
         if (isPalindrome(s, index, end - 1)) {
            // If it's a palindrome, add it to the current partition
            currPart.add(s.substring(index, end));

            // Recursively continue with the next partition
            backtrack(end, currPart, res, s);

            // Backtrack: remove the last added substring to explore other possibilities
            currPart.remove(currPart.size() - 1);
         }
      }
   }

   // Helper method to check if a substring is a palindrome
   private boolean isPalindrome(String str, int left, int right) {
      // Check if characters from both ends towards the center are equal
      while (left < right) {
         if (str.charAt(left) != str.charAt(right)) {
            return false;
         }
         left++;
         right--;
      }
      // If the loop completes, the substring is a palindrome
      return true;
   }

   public static void main(String[] args) {
      // Create an instance of the PalindromePartitioning class
      DFS_DP_PalindromePartitioning pp = new DFS_DP_PalindromePartitioning();

      // Example: "aab"
      String input = "aab";

      // Call the partition method to find all possible palindrome partitions
      List<List<String>> result = pp.partition(input);

      // Print the result
      for (List<String> partition : result) {
         System.out.println(partition);
      }
   }
}
