package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AreMatricesEqual {

    // Function to check if two matrices are equal
    public static boolean areMatricesEqual(int[][] matrix1, int[][] matrix2) {
        return Arrays.deepEquals(matrix1, matrix2);
    }
    
    public static void main(String[] args) {

        // Create a list of 1D arrays
        List<int[]> listOf1DArrays = new ArrayList<>();
        listOf1DArrays.add(new int[]{1, 2, 3});
        listOf1DArrays.add(new int[]{4, 5, 6});
        listOf1DArrays.add(new int[]{7, 8, 9});

        // Convert the list to a 2D array
        int[][] resultMatrix = ConvertListOf1Dto2D.convertListTo2D(listOf1DArrays);
        

        // Check if two matrices are equal
        int[][] anotherMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Matrices are equal: " + areMatricesEqual(resultMatrix, anotherMatrix));
    }
}
