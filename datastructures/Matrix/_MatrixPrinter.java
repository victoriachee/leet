package Matrix;

import java.util.Arrays;

public class _MatrixPrinter {

   // Function to print a 2D matrix
   public static void printMatrix(int[][] matrix) {
      for (int[] row : matrix) {
         System.out.println(Arrays.toString(row));
      }
   }
   
   static void printMatrixV2(int[][] matrix) {
      for (int[] row : matrix) {
         for (int elem : row) {
            System.out.print(elem + " ");
         }
         System.out.println();
      }
   }

   static void printArray(int[] arr) {
      for (int elem : arr) {
         System.out.print(elem + " ");
      }
      System.out.println();
   }
}
