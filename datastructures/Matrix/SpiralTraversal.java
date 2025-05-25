package Matrix;

public class SpiralTraversal {

    /**
     * Traverses the matrix in spiral order.
     *
     * @param matrix The input matrix.
     * @return The elements in spiral order.
     */
    public static int[] spiralOrderTraversal(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] result = new int[rows * cols];

        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int index = 0;

        while (top <= bottom && left <= right) {
            // Traverse top row
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;

            // Traverse bottom row
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--;
            }

            // Traverse left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
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

        int[] spiralOrder = spiralOrderTraversal(matrix);
        System.out.println("\nSpiral Order Traversal:");
        _MatrixPrinter.printArray(spiralOrder);
    }
}
