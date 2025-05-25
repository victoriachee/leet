package _HackerRank.Tests;

import static java.util.stream.Collectors.toList;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * @see https://www.blogoncode.com/2022/08/flipping-matrix-solution-in-java.html
 */
class Result {

   /**
    * Sean's matrix game involves a 2n * 2n matrix, where each cell contains an integer.
    * He can reverse any row or column any number of times. The goal is to maximize
    * the sum of the elements in the n * n submatrix in the upper-left quadrant.
    *
    * Given initial configurations for q matrices, this method helps Sean reverse
    * rows and columns to maximize the sum of the upper-left quadrant in each matrix.
    *
    * @param matrix The input matrix for the game.
    * @return The maximal sum of elements in the upper-left quadrant after optimizations.
    */
   public static int flippingMatrix(List<List<Integer>> matrix) {
      // Initialize the sum to zero.
      int sum = 0;
      // Get the size of the matrix (assuming it's a square matrix).
      int size = matrix.size();

      // Iterate over the top-left quadrant of the matrix.
      for (int i = 0; i < size / 2; i++) {
         for (int j = 0; j < size / 2; j++) {
            // Calculate the maximum value among the current cell and its symmetric counterparts.
            sum +=
               Math.max(
                  matrix.get(i).get(j), // Top-left cell
                  Math.max(
                     matrix.get(i).get(size - 1 - j), // Top-right cell
                     Math.max(
                        matrix.get(size - 1 - i).get(j), // Bottom-left cell
                        matrix.get(size - 1 - i).get(size - 1 - j) // Bottom-right cell
                     )
                  )
               );
         }
      }
      return sum; // Final sum
   }
}

public class D2FlippingMatrix {

   public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(
         new FileWriter(System.getenv("OUTPUT_PATH"))
      );

      int q = Integer.parseInt(bufferedReader.readLine().trim());

      IntStream
         .range(0, q)
         .forEach(qItr -> {
            try {
               int n = Integer.parseInt(bufferedReader.readLine().trim());

               List<List<Integer>> matrix = new ArrayList<>();

               IntStream
                  .range(0, 2 * n)
                  .forEach(i -> {
                     try {
                        matrix.add(
                           Stream
                              .of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                              .map(Integer::parseInt)
                              .collect(toList())
                        );
                     } catch (IOException ex) {
                        throw new RuntimeException(ex);
                     }
                  });

               int result = Result.flippingMatrix(matrix);

               bufferedWriter.write(String.valueOf(result));
               bufferedWriter.newLine();
            } catch (IOException ex) {
               throw new RuntimeException(ex);
            }
         });

      bufferedReader.close();
      bufferedWriter.close();
   }
}
