package Matrix;

import java.util.ArrayList;
import java.util.List;

public class _BasicFetchValues {

    /**
     * Fetches values in the specified row of the matrix.
     *
     * @param matrix The input matrix.
     * @param row    The row index.
     * @return List of values in the specified row.
     */
    public static List<Integer> getRowValues(int[][] matrix, int row) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || row < 0 || row >= matrix.length) {
            return result;
        }

        int cols = matrix[0].length;

        for (int j = 0; j < cols; j++) {
            result.add(matrix[row][j]);
        }

        return result;
    }

    /**
     * Fetches values in the specified column of the matrix.
     *
     * @param matrix The input matrix.
     * @param col    The column index.
     * @return List of values in the specified column.
     */
    public static List<Integer> getColumnValues(int[][] matrix, int col) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || col < 0 || col >= matrix[0].length) {
            return result;
        }

        int rows = matrix.length;

        for (int i = 0; i < rows; i++) {
            result.add(matrix[i][col]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int targetRow = 1;
        System.out.println("Values in Row " + targetRow + ": " + getRowValues(matrix, targetRow));

        int targetCol = 2;
        System.out.println("Values in Column " + targetCol + ": " + getColumnValues(matrix, targetCol));
    }
}
