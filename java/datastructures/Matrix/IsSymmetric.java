package Matrix;

public class IsSymmetric {
    /**
     * Checks if the given matrix is symmetric.
     *
     * @param matrix The input matrix.
     * @return True if the matrix is symmetric, false otherwise.
     */
    public static boolean isSymmetricMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows != cols) {
            return false; // Non-square matrices are not symmetric
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        _MatrixPrinter.printMatrix(matrix);

        boolean isSymmetric = isSymmetricMatrix(matrix);
        System.out.println("\nIs Symmetric: " + isSymmetric);
    }
}
