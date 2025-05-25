/** 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx
 * 
 * ! EASY
 * #Math  #BinarySearch
 * 
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 * Constraints:
 * 0 <= x <= 2^31 - 1
 */

package algos.Math;

public class SqrtX {

   /**
    * Calculates the square root of a non-negative integer x rounded down to the nearest integer.
    *
    * @param x The non-negative integer.
    * @return The square root rounded down to the nearest integer.
    */
   public static int mySqrt(int x) {
      if (x == 0 || x == 1) {
         return x;
      }

      // !Optimization: to avoid integer overflow, use long for calculations
      long left = 1, right = x, result = 0;

      while (left <= right) {
         long mid = left + (right - left) / 2; 

         if (mid * mid <= x) {
            result = mid;
            left = mid + 1;
         } else {
            right = mid - 1;
         }
      }

      return (int) result;
   }

   public static void main(String[] args) {
      // Example 1
      int x1 = 4;
      System.out.println("Example 1: " + mySqrt(x1)); // Output: 2

      // Example 2
      int x2 = 8;
      System.out.println("Example 2: " + mySqrt(x2)); // Output: 2
   }
}
