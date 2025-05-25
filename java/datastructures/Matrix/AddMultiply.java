package Matrix;

public class AddMultiply {

    /**
     * Adds two matrices and returns the result.
     *
     * @param matrix1 The first matrix.
     * @param matrix2 The second matrix.
     * @return The sum of the matrices.
     */
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    /**
     * Multiplies two matrices and returns the result.
     *
     * @param matrix1 The first matrix.
     * @param matrix2 The second matrix.
     * @return The product of the matrices.
     */
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];

        // Columns in matrix1 must equal rows in matrix2 because:
        // - Each element in the result is a sum of products from a row in matrix1 and a column in matrix2.
        // - The number of elements in the row (matrix1's columns) must match the number in the column (matrix2's rows).

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] m2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        int[][] result = multiplyMatrices(matrix1, matrix2);

        // Print the result matrix
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        int[][] sumMatrix = addMatrices(matrix1, matrix2);
        System.out.println("\nSum of Matrices:");
        _MatrixPrinter.printMatrix(sumMatrix);

        int[][] productMatrix = multiplyMatrices(matrix1, matrix2);
        System.out.println("\nProduct of Matrices:");
        _MatrixPrinter.printMatrix(productMatrix);

        int[][] productMatrix2 = multiplyMatrices(m1, m2);
        System.out.println("\nProduct of Matrices 2:");
        _MatrixPrinter.printMatrix(productMatrix2);
    }
}
