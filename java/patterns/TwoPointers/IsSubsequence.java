/**
 * Problem 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 * 
 * ! EASY
 * #TwoPointers  #String
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise. A subsequence of a string is a new string formed by deleting some 
 * (can be none) characters without disturbing the relative positions of the 
 * remaining characters (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 * Example 1: Input: s = "abc", t = "ahbgdc" | Output: true
 * Example 2: Input: s = "axc", t = "ahbgdc" | Output: false
 *
 * Constraints: - 0 <= s.length <= 100 - 0 <= t.length <= 10^4
 * s and t consist only of lowercase English letters.
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k
 * >= 10^9, and you want to check one by one to see if t has its subsequence. In this
 * scenario, how would you change your code?
 */

package patterns.TwoPointers;

public class IsSubsequence {

   public static boolean isSubsequence(String s, String t) {
      // Iterate through both strings with 2 pointers
      int sIdx = 0;
      int tIdx = 0;

      // Use while so that sIndex cannot cause StringIndexOutOfBoundsException
      // Once sIndex == s.length(), that means s is a subsequence
      while (sIdx < s.length() && tIdx < t.length()) {
         if (s.charAt(sIdx) == t.charAt(tIdx)) {
            sIdx++;
         }
         tIdx++;
      }

      return (sIdx == s.length());
   }

   public static void main(String[] args) {
      // Example 1
      String s1 = "abc";
      String t1 = "ahbgdc";
      System.out.println(isSubsequence(s1, t1)); // Output: true

      // Example 2
      String s2 = "axc";
      String t2 = "ahbgdc";
      System.out.println(isSubsequence(s2, t2)); // Output: false
   }
}
// !!BAD: Out of bounds exception
// public static boolean isSubsequence(String s, String t) {
// // Iterate through both strings with 2 pointers
// int sIndex = 0;
// // !!BAD: sIndex can cause StringIndexOutOfBoundsException !!!
// for (int i = 0; i < t.length(); i++) {
// if (s.charAt(sIndex) == t.charAt(i)) {
// sIndex++;
// }
// }
// // Return true if s is a substring of t
// return (sIndex == s.length());
// }
