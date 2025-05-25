package Matrix;

public class IsIdentity {

    /**
     * Checks if the given matrix is an identity matrix.
     *
     * @param matrix The input matrix.
     * @return True if the matrix is an identity matrix, false otherwise.
     */
    public static boolean isIdentityMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows != cols) {
            return false; // Identity matrix must be square
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == j && matrix[i][j] != 1) || (i != j && matrix[i][j] != 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] identityMatrix = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };

        boolean isIdentity = isIdentityMatrix(identityMatrix);
        System.out.println("\nIs Identity Matrix: " + isIdentity);
    }
}
