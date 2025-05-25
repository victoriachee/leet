// #Permutations  #BruteForce  #Heap

package algos.BruteForce;

import java.util.Arrays;

public class Permutations {

   public static void main(String[] args) {
      int[] myArray = { 1, 2, 3 };
      generatePermutations(myArray, 0);
   }

   /**
    * Generates all permutations of an array using Brute Force approach.
    *
    * @param arr The array for which permutations are generated.
    */
   public static void generatePermutations(int[] arr, int start) {
     /*
      * If the starting index is at the end of the array, a permutation has been completed,
      * and the array is printed as a result.
      */
      if (start == arr.length - 1) {
         System.out.println(Arrays.toString(arr));
      } else {
         /*
         * For each index i from the starting index to the end of the array,
         * swap elements to generate permutations and recursively generate permutations
         * for the rest of the array. Backtrack by swapping elements back to their original positions.
         */
         for (int i = start; i < arr.length; i++) {
            // Swap elements to generate permutations
            int temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;

            // Recursively generate permutations for the rest of the array
            generatePermutations(arr, start + 1);

            // Backtrack by swapping elements back to their original positions
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
         }
      }
   }
}
