/** Problem 566. Reshape the Matrix
 * URL: https://leetcode.com/problems/reshape-the-matrix/
 * ! EASY
 * #Arrays  #Matrix
 * 
 * In MATLAB, there is a handy function called reshape which can reshape
 * an m x n matrix into a new one with a different size r x c keeping
 * its original data.
 * 
 * You are given an m x n matrix mat and two integers r and c representing
 * the number of rows and the number of columns of the wanted reshaped matrix.
 * 
 * The reshaped matrix should be filled with all the elements of the original
 * matrix in the same row-traversing order as they were.
 * 
 * If the reshape operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 * 
 * Example 1:
 * Input: mat = [[1,2],[3,4]], r = 1, c = 4, Output: [[1,2,3,4]]
 * 
 * Example 2:
 * Input: mat = [[1,2],[3,4]], r = 2, c = 4, Output: [[1,2],[3,4]]
 * 
 * Constraints:
 *   - m == mat.length
 *   - n == mat[i].length
 *   - 1 <= m, n <= 100
 *   - -1000 <= mat[i][j] <= 1000
 *   - 1 <= r, c <= 300
 */

package Matrix;

public class ReshapeNew2D {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        int flatMatLength = row * col;

        if (flatMatLength != r * c)
            return mat;

        int[][] newMat = new int[r][c];

        for (int i = 0; i < flatMatLength; i++) {
            newMat[i / c][i % c] = mat[i / col][i % col];
        }
        return newMat;
    }

    // How to flatten 2D array to 1D array

    // private static int[] flattenMatrix(int[][] mat) {
    //     int m = mat.length;
    //     int n = mat[0].length;
    //     int[] flatMat = new int[m * n];
    //     int index = 0;

    //     for (int[] row : mat) {
    //         for (int elem : row) {
    //             flatMat[index++] = elem;
    //         }
    //     }

    //     return flatMat;
    // }


    // private static int[] flattenMatrix(int[][] mat) {
    //     int rows = mat.length;
    //     int cols = mat[0].length;
    //     int[] flatMat = new int[rows * cols];
    //     int index = 0;

    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < cols; j++) {
    //             flatMat[index++] = mat[i][j];
    //         }
    //     }

    //     return flatMat;
    // }

    public static void main(String[] args) {

        int[][] mat1 = { { 1, 2 }, { 3, 4 } };
        int r1 = 1, c1 = 4;
        int[][] result1 = matrixReshape(mat1, r1, c1);
        printMatrix(result1);

        int[][] mat2 = { { 1, 2 }, { 3, 4 } };
        int r2 = 2, c2 = 4;
        int[][] result2 = matrixReshape(mat2, r2, c2);
        printMatrix(result2);
    }

    // Helper method to print a 2D array
    private static void printMatrix(int[][] array) {
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


// import java.util.ArrayList;
// import java.util.List;


// Using List but takes more time complexity for list.get(i)
// Use flattened matrix array better

// final List<Integer> list = new ArrayList<>();
// for (int[] row : mat) {
//     for (int elem : row) {
//         list.add(elem);
//     }
// }

// if (list.size() != r * c) {
//     return mat; // Reshape not possible, return the original matrix
// }

// int[][] new2DArray = new int[r][c];
// for (int i = 0; i < list.size(); i++) {
//     int rowIdx = i / c;
//     int colIdx = i % c;
//     new2DArray[rowIdx][colIdx] = list.get(i);
// }

// return new2DArray;
