// EASY
// #Stack #String #Char

/**
 * https://leetcode.com/problems/backspace-string-compare/description/
 */
package Stack;

import java.util.Stack;

public class BackspaceCompare {

   public boolean backspaceCompare(String S, String T) {
      return getBackspacedString(S).equals(getBackspacedString(T));
   }

   public String getBackspacedString(String str) {
      Stack<Character> resStack = new Stack<Character>();
      char[] strArray = str.toCharArray();
      for (char c : strArray) {
         // If char is not a backspace
         // push char to top of stack
         if (c != '#') {
            resStack.push(c);
         } else {
            // If char is a backspace,
            // check that the current stack is not empty,
            // and pop the char at top of stack (backspace)
            if (!resStack.isEmpty()) 
               resStack.pop();
         }
      }

      return String.valueOf(resStack); // Convert stack to string
   }

   public static void main(String[] args) {
      BackspaceCompare backspaceCompare = new BackspaceCompare();

      String S1 = "ab#c";
      String T1 = "ad#c";
      System.out.println(backspaceCompare.backspaceCompare(S1, T1)); // Output: true

      String S2 = "ab##";
      String T2 = "c#d#";
      System.out.println(backspaceCompare.backspaceCompare(S2, T2)); // Output: true

      String S3 = "a##c";
      String T3 = "#a#c";
      System.out.println(backspaceCompare.backspaceCompare(S3, T3)); // Output: true

      String S4 = "a#c";
      String T4 = "b";
      System.out.println(backspaceCompare.backspaceCompare(S4, T4)); // Output: false
   }
}
