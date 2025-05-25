package Matrix;

public class Flatten2Dto1D {

   public static int[] flattenMatrix(int[][] mat) {
      int rows = mat.length;
      int cols = mat[0].length;
      int[] flatMat = new int[rows * cols];
      int index = 0;

      for (int i = 0; i < rows; i++) {
         for (int j = 0; j < cols; j++) {
            flatMat[index++] = mat[i][j];
         }
      }

      return flatMat;
   }

   // private static int[] flattenMatrix(int[][] mat) {
   //     int m = mat.length;
   //     int n = mat[0].length;
   //     int[] flatMat = new int[m * n];
   //     int index = 0;

   //     for (int[] row : mat) {
   //         for (int cell : row) {
   //             flatMat[index++] = cell;
   //         }
   //     }

   //     return flatMat;
   // }

   public static void main(String[] args) {
      // Example usage
      int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

      int[] flattenedArray = flattenMatrix(matrix);

      // Print the original matrix
      System.out.println("Original Matrix:");
      _MatrixPrinter.printMatrix(matrix);

      // Print the flattened array
      System.out.println("\nFlattened Array:");
      _MatrixPrinter.printArray(flattenedArray);
   }
}
