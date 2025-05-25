// #Recursion  #String

package patterns.Recursion;

public class IsPalindrone {

   public static boolean isPalindrome(String s) {
      int len = s.length();
      int end = len - 1;

      // Base case: an empty string or a string with one character is a palindrome
      if (len == 0 || len == 1) return true;

      // Recursive case: check if the substring between them is also a palindrome
      if (s.charAt(0) == s.charAt(end)) 
         return isPalindrome(s.substring(1, end)); //end = len-1 so its the correct substr
      // If the first and last characters are different, it's not a palindrome
      else return false;
   }

   public static void main(String[] args) {
      // Example usage:
      String inputString = "radar";
      boolean result = isPalindrome(inputString);
      System.out.println("Is '" + inputString + "' a palindrome? " + result);
   }
}
/**
 * !How to identify base cases:
 * 1. Understand the Problem:
 *    - Problem: Determine if a given string is a palindrome.
 *    - Inputs: String.
 *    - Output: Boolean indicating whether the string is a palindrome.
 *
 * 2. Define the Smallest Input:
 *    - Smallest Input:
 *      The smallest input for which the solution is obvious is
 *      when the string has 0 or 1 character(s).
 *    - Base Case:
 *      If the string is empty or has only one character, it is a
 *      palindrome.
 *
 * 3. Consider Trivial or Edge Cases:
 *    - Trivial Case:
 *      An empty string or a string with one character is a palindrome.
 *    - Edge Case:
 *      Consider handling cases with spaces or punctuation and decide
 *      whether they should be ignored.
 *
 * 4. Analyze Recurrence Relation:
 *    - Recurrence Relation:
 *      A string is a palindrome if and only if the first and last characters
 *      are the same, and the substring between them is also a palindrome.
 *
 * 5. Look for Patterns:
 *    - Pattern:
 *      Palindromes exhibit symmetry, so checking the first and last
 *      characters is a common pattern.
 *    - Stop Condition:
 *      The pattern naturally stops when the string has 0 or 1
 *      character.
 *
 * 6. Consider Input Constraints:
 *    - Input Constraint:
 *      Any string can be a valid input.
 *
 * 7. Think about Convergence:
 *    - Convergence:
 *      The recursion naturally converges as it approaches the base
 *      case of an empty or single-character string.
 *    - Additional Recursion:
 *      Further recursion beyond 0 or 1 characters doesn't
 *      contribute to a more refined solution.
 *
 * 8. Test and Validate:
 *    - Test Base Cases:
 *      Validate that an empty string and a string with one
 *      character are considered palindromes.
 *    - Test Small Inputs:
 *      Test with small inputs to trace recursion and verify termination.
 *
 * 9. Be Wary of Infinite Recursion:
 *    - Prevent Infinite Recursion:
 *      The base case of an empty or single-character string prevents infinite
 *      recursion.
 *
 * Example Summary:
 *    - Base Cases:
 *      An empty string and a string with one character are considered
 *      palindromes.
 *    - Recursive Relation:
 *      Check if the first and last characters are the same,
 *      and recursively check the substring between them.
 *    - Termination:
 *      Natural convergence to base cases ensures termination.
 *    - Validation:
 *      Test with base cases and small inputs to ensure correctness.
 */
