package Matrix;

public class RotateTransposeFlip {
    /**
     * Rotates the given matrix 90 degrees clockwise.
     *
     * @param matrix The input matrix.
     * @return The rotated matrix.
     */
    public static int[][] rotateMatrixClockwise(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Transpose the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - 1 - j];
                matrix[i][cols - 1 - j] = temp;
            }
        }

        return matrix;
    }


    /**
     * Transposes the given matrix.
     *
     * @param matrix The input matrix.
     * @return The transposed matrix.
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    /**
     * Flips the given matrix horizontally.
     *
     * @param matrix The input matrix.
     * @return The horizontally flipped matrix.
     */
    public static int[][] flipHorizontal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][cols - 1 - j];
            }
        }

        return result;
    }

    /**
     * Flips the given matrix vertically.
     *
     * @param matrix The input matrix.
     * @return The vertically flipped matrix.
     */
    public static int[][] flipVertical(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[rows - 1 - i][j];
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

        System.out.println("Original Matrix:");
        _MatrixPrinter.printMatrix(matrix);

        int[][] rotatedMatrix = rotateMatrixClockwise(matrix);
        System.out.println("\nRotated Matrix:");
        _MatrixPrinter.printMatrix(rotatedMatrix);

        int[][] transposedMatrix = transposeMatrix(matrix);
        System.out.println("\nTransposed Matrix:");
        _MatrixPrinter.printMatrix(transposedMatrix);

        int[][] horizontalFlippedMatrix = flipHorizontal(matrix);
        System.out.println("\nHorizontally Flipped Matrix:");
        _MatrixPrinter.printMatrix(horizontalFlippedMatrix);

        int[][] verticalFlippedMatrix = flipVertical(matrix);
        System.out.println("\nVertically Flipped Matrix:");
        _MatrixPrinter.printMatrix(verticalFlippedMatrix);
    }
}

