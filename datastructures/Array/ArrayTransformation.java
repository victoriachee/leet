/**
 * This class includes update-related functions like sorting, reversing,
 * removing duplicates, rotating, doubling, and filtering.
 */
package Array;

import java.util.Arrays;

public class ArrayTransformation {

   //  [ COMMON ]

   /**
    ** 1. Convert to string
    *  TC: O(n), SC: O(n)
    */
   public static String arrayToString(int[] arr) {
      return Arrays.toString(arr);
   }

   /**
    ** 2. Copy array
    *  TC: O(n), SC: O(n)
    */
   public static int[] copyArray(int[] arr) {
      return Arrays.copyOf(arr, arr.length);
   }

   /**
    ** 3. Copy array range
    *  TC: O(n), SC: O(n)
    */
   public static int[] copyArrayRange(int[] arr, int from, int to) {
      return Arrays.copyOfRange(arr, from, to);
   }

   //  [ SORTING ]
   /**  @see MergeSort & QuickSort */

   /**
    ** 1. Sort
    *  TC: O(n log n), SC: O(1) - In-place sorting
    */
   public static void sortArray(int[] arr) {
      Arrays.sort(arr);
   }

   /**
    ** 2. Parallel sort
    *  TC: O(n log n), SC: O(log n) - Stack space for recursion
    *  Use case: Better for large datasets but has overhead of parallelization
    */
   public static void parallelSortArray(int[] array) {
      Arrays.parallelSort(array);
   }

   /**
    ** 3. Descending sort
    */
   public static void sortDescending(int[] array) {
      int n = array.length;

      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - 1 - i; j++) {
            // Swap elements if they are in the wrong order
            if (array[j] < array[j + 1]) {
               int temp = array[j];
               array[j] = array[j + 1];
               array[j + 1] = temp;
            }
         }
      }
   }

   // [ TRANSFORMATION ]

   /**
    ** 1. Concatenate two arrays
    *  TC: O(m + n) SC: O(m + n)
    */
   public static int[] concatenateArrays(int[] arr1, int[] arr2) {
      int[] result = Arrays.copyOf(arr1, arr1.length + arr2.length);
      System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
      /** System.arraycopy
       * Copies elements from the source array to the destination array.
       *
       * @param src     The source array from which to copy elements.
       * @param srcPos  The starting position in the source array.
       * @param dest    The destination array to which elements will be copied.
       * @param destPos The starting position in the destination array.
       * @param length  The number of elements to copy.
       */
      return result;
   }

   /**
    ** 2. Double array elements
    *  TC: O(n), SC: O(n) - Creation of new array
    */
   public static int[] doubleElements(int[] array) {
      return Arrays.stream(array).map(n -> n * 2).toArray();
   }

   /**
    ** 3. Filter even numbers
    *  TC: O(n), SC: O(n) - Creation of new array
    */
   public static int[] filterEvenNumbers(int[] array) {
      return Arrays.stream(array).filter(n -> n % 2 == 0).toArray();
   }

   /**
    ** 4. Remove duplicates
    *  TC: O(n), SC: O(n) - Creation of new array
    */
   public static int[] removeDuplicates(int[] array) {
      return Arrays.stream(array).distinct().toArray();
   }


   // [ REVERSING (Iterates through half the array - n/2) ]

   /**
    ** 1. Reverse array into new array
    *  TC: O(n), SC: O(n) - Creation of new array
    */
   public static int[] reverseArray(int[] array) {
      int[] reversedArray = Arrays.copyOf(array, array.length);
      for (int i = 0, j = array.length - 1; i < j; i++, j--) {
         swap(reversedArray, i, j);
      }
      return reversedArray;
   }

    /**
    ** 2. Reverse range of elements in-place
    *  TC: O(n), SC: O(1) - Reversal done in-place
    */
   public static void reverseWhile(int[] array) {
      int n = array.length;

      int start = 0, end = n - 1;
      while (start < end) {
         int temp = array[start];
         array[start] = array[end];
         array[end] = temp;
         start++;
         end--;
      }
   }

   /**
    ** 2a. Reverse range of elements in-place
    *  TC: O(n), SC: O(1) - Reversal done in-place
    */
   public static void reverseArray(int[] array, int start, int end) {
      while (start < end) {
         swap(array, start, end);
         start++;
         end--;
      }
   }

   /**
    **  2b. Swap elements in-place
    */
   public static void swap(int[] array, int s, int e) {
      int temp = array[s];
      array[s] = array[e];
      array[e] = temp;
   }

   // [ ROTATION ]

   /**
    ** 1. Rotate elements to right by a distance
    *  TC: O(n), SC: O(1) - Reversal done in-place 
    */
   public static void rotateRight(int[] array, int distance) {
      int n = array.length;
      reverseArray(array, 0, n - 1);          // Step 1: Reverse entire array 
      reverseArray(array, 0, distance - 1);   // Step 2: Reverse first 'distance'elements 
      reverseArray(array, distance, n - 1);   // Step 3: Reverse remaining elements 
   }

   /**
    ** 2. Rotate elements to left by a distance
    *  TC: O(n), SC: O(1) - Reversal done in-place  //  Original array: [1, 2, 3, 4, 5], distance = 2
    */
   public static void rotateLeft(int[] array, int distance) {
      int n = array.length;
      reverseArray(array, 0, n - 1);                  // Step 1: Reverse entire array [5, 4, 3, 2, 1] 
      reverseArray(array, 0, n - distance - 1);       // Step 2: Reverse first 'n - distance' (3) elements [3, 4, 5, 2, 1]
      reverseArray(array, n - distance, n - 1);       // Step 3: Reverse remaining elements [3, 4, 5, 1, 2]
   }

   public static void main(String[] args) {
      int[] numbers = { 5, 2, 8, 1, 7, 3 };

      System.out.println("Original Array: " + Arrays.toString(numbers));

      // Sort the array
      ArrayTransformation.sortArray(numbers);
      System.out.println("Sorted Array: " + Arrays.toString(numbers));

      // Sort the array desc
      ArrayTransformation.reverseWhile(numbers);
      System.out.println("Sorted Array (Desc): " + Arrays.toString(numbers));

      // Reverse the array
      int[] reversedArray = ArrayTransformation.reverseArray(numbers);
      System.out.println("Reversed Array: " + Arrays.toString(reversedArray));

      // Double each element
      int[] doubledArray = ArrayTransformation.doubleElements(numbers);
      System.out.println("Doubled Array: " + Arrays.toString(doubledArray));

      // Filter even numbers
      int[] evenNumbers = ArrayTransformation.filterEvenNumbers(numbers);
      System.out.println("Even Numbers: " + Arrays.toString(evenNumbers));

      // Remove duplicates
      int[] uniqueNumbers = ArrayTransformation.removeDuplicates(numbers);
      System.out.println("Array without Duplicates: " + Arrays.toString(uniqueNumbers));

      // Rotate the array to the right by 2 positions
      ArrayTransformation.rotateRight(numbers, 2);
      System.out.println("Array after Right Rotation: " + Arrays.toString(numbers));

      // Rotate the array to the left by 3 positions
      ArrayTransformation.rotateLeft(numbers, 3);
      System.out.println("Array after Left Rotation: " + Arrays.toString(numbers));
   }
}
