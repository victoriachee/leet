/** Problem 2022: Convert 1D Array Into 2D Array
 * URL: https://leetcode.com/problems/convert-1d-array-into-2d-array/description/
 * ! EASY
 * #Arrays  #Matrix  #2DArray
 *
 * Given a 0-indexed 1D integer array, original, and two integers, m and n.
 * Create a 2D array with m rows and n columns using all elements from original.
 * Elements from indices 0 to n - 1 (inclusive) of original form the first row,
 * indices n to 2 * n - 1 form the second row, and so on.
 *
 * Return an m x n 2D array according to the above procedure or an empty 2D
 * array if impossible.
 *
 * Example 1:
 * Input: original = [1,2,3,4], m = 2, n = 2, Output: [[1,2],[3,4]]
 * Explanation: 2x2 array with elements grouped accordingly.
 *
 * Example 2:
 * Input: original = [1,2,3], m = 1, n = 3, Output: [[1,2,3]]
 * Explanation: 1x3 array with all three elements in the first row.
 *
 * Example 3:
 * Input: original = [1,2], m = 1, n = 1, Output: []
 * Explanation: Impossible to fit 2 elements in a 1x1 array, so return empty.
 *
 * Constraints: 1 <= original.length <= 5 * 10^4, 1 <= original[i] <= 10^5,
 * 1 <= m, n <= 4 * 10^4
 */

package Matrix;

public class Construct2Dfrom1D {

   public static int[][] construct2DArray(int[] original, int m, int n) {
      if (original.length != m * n) {
         return new int[0][0];
      }

      int[][] res = new int[m][n];

      for (int i = 0; i < original.length; i++) {
         // Group elements into sets of n columns, which is row idx
         int rowIndex = i / n;

         // In each row, which column idx from 0 to n-1
         int colIndex = i % n;

         res[rowIndex][colIndex] = original[i];
      }
      return res;
   }

   public static void main(String[] args) {

      int[] example4 = { 1, 2,3, 4,5,6,7,8,9, 10, 11, 12 };
      int m4 = 4, n4 = 3;
      int[][] result4 = construct2DArray(example4, m4, n4);
      printArray(result4);

      int[] example1 = { 1, 2, 3, 4 };
      int m1 = 2, n1 = 2;
      int[][] result1 = construct2DArray(example1, m1, n1);
      printArray(result1);

      int[] example2 = { 1, 2, 3 };
      int m2 = 1, n2 = 3;
      int[][] result2 = construct2DArray(example2, m2, n2);
      printArray(result2);

      int[] example3 = { 1, 2 };
      int m3 = 1, n3 = 1;
      int[][] result3 = construct2DArray(example3, m3, n3);
      printArray(result3);
   }

   // Helper method to print a 2D array
   private static void printArray(int[][] array) {
      System.out.println("2D Array:");
      System.out.print("[");
      for (int[] row : array) {
         System.out.print("[ ");
         for (int element : row) {
            System.out.print(element + " ");
         }
         System.out.print("]");
      }
      System.out.println("]");
      System.out.println();
   }
}
// Visualizing Rows and Columns:
// Imagine Rows as Groups:
// Picture the 2D array as rows where each row represents a group of n elements.
// For every n consecutive elements in the 1D array, they form a new row.
// Visualize Columns:
// Consider each row in the 2D array as having n columns.
// The goal is to place each element in the 1D array into its corresponding row
// and column.
// Understanding i / n for Rows:
// Think of Division as Grouping:
// When you divide an index i by n, it groups elements into sets of n.
// For example, when i is 0 to n - 1, i / n is 0 (first group/row).
// Understanding i % n for Columns:
// Think of Modulo as Wrapping Around:
// The modulo operation (i % n) helps with wrapping around and determining the
// position within the current row.
// It cycles through values 0 to n - 1, ensuring that when you exceed n, it
// wraps around to
// 0, 1, 2, and so on.
// Putting It Together:
// Combining Row and Column Indices:
// i / n gives you the row index, representing the group of n elements.
// i % n gives you the column index within that row, ensuring the correct
// placement.
// Visualizing the Mapping:
// Imagine walking through the 1D array and placing each element in its
// corresponding row
// and column in the 2D array.
