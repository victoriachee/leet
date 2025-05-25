/**
 * Class for reversing a matrix along its rows, columns, and both rows and columns to maximize
 * the sum of the top-left quadrant (n * n cells).
 */

package Matrix;

public class ReverseSortedMatrix {

    /**
     * Main method to demonstrate matrix reversal and calculate the maximum sum in the top-left quadrant.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Example input matrix
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        // Calculate the value of n
        int n = matrix.length / 2;

        // Find and print the maximum sum
        int maxSum = maximizeTopLeftSum(matrix, n);
        System.out.println("Maximum sum in top-left quadrant: " + maxSum);
    }

    /**
     * Function to maximize the sum in the top-left n * n cells by reversing rows and columns.
     *
     * @param matrix The input matrix.
     * @param n      The size of the top-left quadrant.
     * @return The maximum sum in the top-left quadrant.
     */
    private static int maximizeTopLeftSum(int[][] matrix, int n) {
        // Reverse rows and columns to maximize the sum
        reverseRows(matrix);
        reverseColumns(matrix);

        // Calculate and return the sum in the top-left n * n cells
        return calculateTopLeftSum(matrix, n);
    }

    /**
     * Function to reverse all rows of the matrix. This function iterates through each row of 
     * the matrix and calls the reverseArray function to reverse the elements in each row.
     *
     * @param matrix The input matrix.
     */
    private static void reverseRows(int[][] matrix) {
        for (int[] row : matrix) {
            reverseArray(row);
        }
    }

    /**
     * Function to reverse all columns of the matrix. This function iterates through each 
     * column of the matrix and calls the reverseColumn function to reverse the elements in 
     * each column.
     *
     * @param matrix The input matrix.
     */
    private static void reverseColumns(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            reverseColumn(matrix, i);
        }
    }

    /**
     * Function to reverse a specific array. This function reverses a given 1D array by 
     * swapping elements from both ends until the middle is reached.
     *
     * @param arr The array to be reversed.
     */
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            // Swap elements to reverse the array
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * This function reverses a specific column in the matrix by swapping elements from 
     * the top and bottom until the middle is reached.
     *
     * @param matrix The input matrix.
     * @param col    The column index to be reversed.
     */
    private static void reverseColumn(int[][] matrix, int col) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            // Swap elements to reverse the column
            int temp = matrix[start][col];
            matrix[start][col] = matrix[end][col];
            matrix[end][col] = temp;
            start++;
            end--;
        }
    }

    /**
     * This function calculates and returns the sum of the elements in the top-left quadrant
     * of the matrix (n * n cells).
     *
     * @param matrix The input matrix.
     * @param n      The size of the top-left quadrant.
     * @return The sum in the top-left n * n cells.
     */
    private static int calculateTopLeftSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
