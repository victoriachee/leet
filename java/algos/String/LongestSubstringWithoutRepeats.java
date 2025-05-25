/**
 * Problem 3: Longest Substring Without Repeating Characters
 * URL: https://leetcode.com/problems/longest-substring-without-repeating-characters
 * !! MEDIUM
 * #SlidingWindow  #String
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 *
 * Examples:
 * 1. Input: "abcabcbb", Output: 3
 *    Explanation: The answer is "abc" with a length of 3.
 *
 * 2. Input: "bbbbb", Output: 1
 *    Explanation: The answer is "b" with a length of 1.
 *
 * 3. Input: "pwwkew", Output: 3
 *    Explanation: The answer is "wke" with a length of 3.
 *    Note: "pwke" is a subsequence, not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols, and spaces.
 */

package algos.String;

import java.util.HashSet;

public class LongestSubstringWithoutRepeats {

   public static int lengthOfLongestSubstring(String s) {
      int n = s.length();
      int maxLength = 0;
      HashSet<Character> charSet = new HashSet<>();
      int left = 0;

      for (int right = 0; right < n; right++) {
         // for "pwwkew", at right = 2, it removes p at left, then w at left
         // then left = 2 & right = 2
         while (charSet.contains(s.charAt(right))) {
            charSet.remove(s.charAt(left));
            left++;
         }
         charSet.add(s.charAt(right));
         maxLength = Math.max(maxLength, right - left + 1);
      }

      return maxLength;
   }

   public static void main(String[] args) {
      var str = "pwwkew";
      System.out.println(str + " -> " + lengthOfLongestSubstring(str));
      str = "bbbbb";
      System.out.println(str + " -> " + lengthOfLongestSubstring(str));
      str = "abcabcbb";
      System.out.println(str + " -> " + lengthOfLongestSubstring(str));
   }
}
