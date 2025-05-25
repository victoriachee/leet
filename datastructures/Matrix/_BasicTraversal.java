package Matrix;

import java.util.ArrayList;
import java.util.List;

public class _BasicTraversal {

    /**
     * Traverses the matrix in row-major order.
     *
     * @param matrix The input matrix.
     * @return List of elements traversed in row-major order.
     */
    public static List<Integer> traverseRowMajor(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.add(matrix[i][j]);
            }
        }

        return result;
    }

    /**
     * Traverses the matrix in column-major order.
     *
     * @param matrix The input matrix.
     * @return List of elements traversed in column-major order.
     */
    public static List<Integer> traverseColumnMajor(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                result.add(matrix[i][j]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Matrix in Row-Major Order: " + traverseRowMajor(matrix));
        System.out.println("Matrix in Column-Major Order: " + traverseColumnMajor(matrix));
    }
}
