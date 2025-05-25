/**
 * ! EASY
 * #ArrayList #Matrix
 * 
 * Given a square matrix, calculate absolute difference between diagonal sums.
 * 
 * Example:
 * Matrix:
 * 1 2 3
 * 4 5 6
 * 9 8 9  
 * 
 * Diagonal sums: Left-to-right = 1 + 5 + 9 = 15, Right-to-left = 3 + 5 + 9 = 17.
 * Absolute difference: |15 - 17| = 2.
 * 
 * Function: diagonalDifference(int arr[n][m])
 * 
 * Input: Single integer n (rows/columns). Each of next n lines has space-separated ints.
 * 
 * Output: Absolute difference between diagonal sums as single integer.
 * 
 * Sample Input:
 * 3
 * 11 2 4
 * 4 5 6
 * 10 8 -12
 * 
 * Sample Output: 15
 * 
 * Explanation:
 * Primary diagonal sum: 11 + 5 - 12 = 4
 * Secondary diagonal sum: 4 + 5 + 10 = 19
 * Absolute difference: |4 - 19| = 15
 * 
 * Note: |x| is absolute value of x.
 */

// *Time Complexity: O(n) -> Most efficient, single loop 

package _HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2FindDiagonalDiff {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int endCol = n - 1;
        int frontDiagonal = 0; 
        int backDiagonal = 0;
        
        for (int i = 0; i < n; i++) {
            // Sum front value for this row
            frontDiagonal += arr.get(i).get(i);  
            // Sum back value for this row
            backDiagonal += arr.get(i).get(endCol); 
        }
        return Math.abs(frontDiagonal - backDiagonal);
    }
    
    public static void main(String[] args) {
        // Sample input matrix
        List<List<Integer>> matrix = new ArrayList<>(Arrays.asList(
            Arrays.asList(11, 2, 4),
            Arrays.asList(4, 5, 6),
            Arrays.asList(10, 8, -12)
        ));

        // Call the diagonalDifference function and print the result
        int result = diagonalDifference(matrix);
        System.out.println("Absolute Diagonal Difference 1: " + result);
       
        // Sample input matrix
        List<List<Integer>> matrix2 = new ArrayList<>(Arrays.asList(
            Arrays.asList(-1, 2, 4, 10),
            Arrays.asList(-4, 5, 6, 2),
            Arrays.asList(-3, 1, 5, 2),
            Arrays.asList(-10, 8, 6, -12)
        ));

        // Call the diagonalDifference function and print the result
        int result2 = diagonalDifference(matrix2);
        System.out.println("Absolute Diagonal Difference 2: " + result2);
    }
}
