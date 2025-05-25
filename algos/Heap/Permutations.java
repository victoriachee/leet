// #Permutations  #BruteForce  #Heap

package algos.Heap;

import java.util.Arrays;

public class Permutations {

   public static void main(String[] args) {
      int[] myArray = { 1, 2, 3 };
      generatePermutations(myArray, myArray.length);
   }

   /**
    * Generates all permutations of an array using Heap's algorithm.
    *
    * @param arr The array for which permutations are generated.
    */
   public static void generatePermutations(int[] arr, int size) {
      if (size == 1) {
         System.out.println(Arrays.toString(arr));
      } else {
         for (int i = 0; i < size; i++) {
            generatePermutations(arr, size - 1);

            if (size % 2 == 1) {
               // Swap first and last element when size is odd
               int temp = arr[0];
               arr[0] = arr[size - 1];
               arr[size - 1] = temp;
            } else {
               // Swap i-th and last element when size is even
               int temp = arr[i];
               arr[i] = arr[size - 1];
               arr[size - 1] = temp;
            }
         }
      }
   }
}
