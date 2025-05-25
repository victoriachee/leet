package Matrix;

import java.util.ArrayList;
import java.util.List;

public class ConvertListOf1Dto2D {

    public static int[][] convertListToArray2D(List<int[]> listOf1DArrays) {
        final int numRows = listOf1DArrays.size();
        return listOf1DArrays.toArray(new int[numRows][]);
    }

    public static int[][] convertListTo2D(List<int[]> list) {
        int numRows = list.size();
        int numCols = (numRows > 0) ? list.get(0).length : 0;

        int[][] res = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++)  
            res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
        // Example usage

        // Create a list of 1D arrays
        List<int[]> listOf1DArrays = new ArrayList<>();
        listOf1DArrays.add(new int[]{1, 2, 3});
        listOf1DArrays.add(new int[]{4, 5, 6});
        listOf1DArrays.add(new int[]{7, 8, 9});

        // Convert the list to a 2D array
        int[][] resultMatrix = convertListTo2D(listOf1DArrays);

        // Print the resulting matrix
        System.out.println("Converted 2D Matrix:");
        _MatrixPrinter.printMatrix(resultMatrix);

        // Convert the list to a 2D array using toArray
        int[][] resultArray2D = convertListToArray2D(listOf1DArrays);

        // Print the resulting matrix
        System.out.println("Converted 2D Matrix using toArray:");
        _MatrixPrinter.printMatrix(resultArray2D);
    }
}
