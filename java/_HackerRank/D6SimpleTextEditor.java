/**
 * A simple text editor that processes a series of operations and maintains the state of a string.
 * Supported operations include appending characters, removing characters, printing a character at
 * a specific position, and undoing the last operation.
 *
 * Operation Format:
 *   1. Append: "1 <text>" - Appends the given text to the end of the current string.
 *   2. Remove: "2 <k>" - Removes the last k characters from the current string.
 *   3. Print: "3 <k>" - Prints the kth character of the current string (1-indexed).
 *   4. Undo: "4" - Undoes the last operation, reverting the string to its previous state.
 *
 * Example Usage:
 *   1. "1 abc" - Append "abc" to the string, resulting in "abc".
 *   2. "3 3" - Print the 3rd character of the string, which is 'c'.
 *   3. "2 3" - Remove the last 3 characters, resulting in an empty string.
 *   4. "1 xy" - Append "xy" to the string, resulting in "xy".
 *   5. "3 2" - Print the 2nd character of the string, which is 'y'.
 *   6. "4" - Undo the last operation, reverting the string to "abc".
 *   7. "4" - Undo again, reverting the string to its initial state.
 *   8. "3 1" - Print the 1st character of the string, which is 'a'.
 *
 */

package _HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D6SimpleTextEditor {

   public static void main(String[] args) throws IOException {
      Stack<String> stack = new Stack<String>();
      StringBuilder builder = new StringBuilder();
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      int numOps = Integer.parseInt(reader.readLine().trim());

      while (numOps-- > 0) {
         String s = reader.readLine().trim();
         int op = Integer.parseInt(s.substring(0, 1));

         switch (op) {
            case 1: // Append to end of string
               { // Add brackets or local vals can't be initialized with same name
                  String value = s.substring(2, s.length()); //Get second val
                  stack.push(builder.toString()); // Push state of string before this op
                  builder.append(value); 
                  break;
               }
            case 2: // Remove last k chars of the string
               {  
                  stack.push(builder.toString()); // Push state of string before this op
                  String value = s.substring(2, s.length()); 
                  int k = Integer.parseInt(value);
                  builder.delete(builder.length() - k, builder.length());
                  break;
               }
            case 3: // Print kth char of the string
               {
                  String value = s.substring(2, s.length());
                  int kth = Integer.parseInt(value);
                  System.out.println(builder.charAt(kth - 1)); // Rmb zero-indexed
                  break;
               }
            case 4: // Undo last op
               {
                  builder = new StringBuilder(stack.pop());
                  break;
               }
         }
      }
      reader.close();
   }
}

/*
   1 abc    push "" to stack , s = abc
   3 3      print c
   2 3      push "abc" to stack ,  s = ""   
   1 xy     push "" to stack , s = xy
   3 2      print y
   4        s = "" -> stack.pop()
   4        s = abc  -> stack.pop()
   3 1      print a 
 */
