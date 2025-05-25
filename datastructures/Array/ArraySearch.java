/**
 * This class contains search-related functions like contains, indexOf,
 * finding max value, finding frequency, and binary search operations.
 */

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraySearch {

   /**
    ** 1a. Contains (List)
    *  Use case: Array is not sorted & need to perform single search
    *  TC: O(n) SC: O(n) - uses list
    */
   public static boolean contains(int[] nums, int target) {
      List<Integer> rList = new ArrayList<>();
      IntStream.of(nums).forEach(rList::add);
      return rList.contains(target); // Using List
   }

   /**
    ** 1b. Contains (Primitive)
    *  Use case: Array is not sorted & need to perform a single search
    *  TC: O(n) SC: O(1) - uses primitive array
    */
   public static boolean contains2(int[] nums, int target) {
      for (int elem : nums) {
         if (elem == target) return true;
      }
      return false;
   }

   /**
    ** 2. Binary search
    *  Use case: Array is sorted & need to perform multiple searches
    *  TC: O(log n), SC: O(1)
    */
   public static int binarySearch(int[] nums, int key) {
      return Arrays.binarySearch(nums, key);
   }

   /**
    ** 3a. Index Of (List)
    *  TC: O(n) SC: O(1)
    */
   public static int indexOf(int[] nums, int target) {
      List<Integer> rList = new ArrayList<>();
      IntStream.of(nums).forEach(rList::add);
      return rList.indexOf(target); // Using List
   }

   /**
    ** 4b. First Index Of
    *  TC: O(n) SC: O(1)
    */
   public static int indexOfValue(int[] array, int value) {
      for (int i = 0; i < array.length; i++) {
         if (array[i] == value) return i; // Found
      }
      return -1; // Return -1 if value is not found
   }

   /**
    ** 5. Last Index Of
    *  TC: O(n) SC: O(1)
    */
   public static int lastIndexOfValue(int[] array, int value) {
      for (int i = array.length - 1; i >= 0; i--) {
         if (array[i] == value) return i; // Found
      }
      return -1; // Return -1 if value is not found
   }

   /**
    ** 6. Calculate sum
    *  TC: O(n) SC: O(1)
    */
   public static int calculateSum(int[] array) {
      return Arrays.stream(array).reduce(0, Integer::sum); // Start from 0, then +
      // return Arrays.stream(array).sum();
   }

   /**
    ** 7a. Find minimum value
    *  TC: O(n) SC: O(1)
    */
   public static int findMinValue(int[] array) {
      if (array.length == 0) throw new IllegalArgumentException("Array is empty");

      int min = array[0];
      for (int value : array) {
         if (value < min) min = value;
      }
      return min;
   }

   /**
    ** 7b. Find min value (Stream) (has overhead)
    * TC: O(n) SC: O(1)
    */
   public static int findMinValueStream(int[] array) {
      return Arrays.stream(array).min().orElseThrow();
   }

   /**
    ** 8a. Find max value
    *  TC: O(n) SC: O(1)
    */
   public static int findMaxValue(int[] array) {
      if (array.length == 0) throw new IllegalArgumentException("Array is empty");

      int max = array[0];
      for (int value : array) {
         if (value > max) max = value;
      }
      return max;
   }

   /**
    ** 8b. Find max value (Stream) (has overhead)
    *  TC: O(n) SC: O(1)
    */
   public static int findMaxValueStream(int[] array) {
      return Arrays.stream(array).max().orElseThrow();
   }

   /**
    ** 9. Calculate Average
    *  TC: O(n) SC: O(1)
    */
   public static double calculateAverage(int[] array) {
      if (array.length == 0) return 0.0;
      return (double) Arrays.stream(array).sum() / array.length;
   }

   /**
    ** 10. Is Array Sorted
    *  TC: O(n log n) SC: O(n)
    */
   public static boolean isArraySorted(int[] array) {
      int[] sortedArray = Arrays.copyOf(array, array.length);
      Arrays.sort(sortedArray);
      return Arrays.equals(array, sortedArray);
      // return Arrays.stream(array).sorted().toArray().equals(array);
   }

   /**
    ** 11. Are All Positive
    *  TC: O(n) SC: O(1)
    */
   public static boolean areAllPositive(int[] array) {
      return Arrays.stream(array).allMatch(n -> n > 0);
   }

   /**
    ** 12. Print Element Frequency
    *  TC: O(n) SC: O(n)
    */
   public static void printElementFrequency(int[] array) {
      Map<Integer, Long> frequencyMap = Arrays
         .stream(array)
         .boxed()
         .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

      frequencyMap.forEach((element, frequency) ->
         System.out.println("Element " + element + " occurs " + frequency + " times.")
      );
   }

   public static void main(String[] args) {
      int[] array = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5 };

      // Example usage of the methods
      System.out.println("1a. Contains (List): " + ArraySearch.contains(array, 4));
      System.out.println("1b. Contains (Primitive): " + ArraySearch.contains2(array, 4));

      int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      System.out.println("2. Binary Search: " + ArraySearch.binarySearch(sortedArray, 5));

      System.out.println("3a. Index Of (List): " + ArraySearch.indexOf(array, 9));
      System.out.println("4b. Index Of Value: " + ArraySearch.indexOfValue(array, 5));

      System.out.println("5. Last Index Of Value: " + ArraySearch.lastIndexOfValue(array, 5));

      System.out.println("6. Calculate Sum: " + ArraySearch.calculateSum(array));

      System.out.println("7a. Find Min Value: " + ArraySearch.findMinValue(array));
      System.out.println("7b. Find Min Value (Stream): " + ArraySearch.findMinValueStream(array));

      System.out.println("8a. Find Max Value: " + ArraySearch.findMaxValue(array));
      System.out.println("8b. Find Max Value (Stream): " + ArraySearch.findMaxValueStream(array));

      System.out.println("9. Calculate Average: " + ArraySearch.calculateAverage(array));

      System.out.println("10. Is Array Sorted: " + ArraySearch.isArraySorted(sortedArray));

      System.out.println("11. Are All Positive: " + ArraySearch.areAllPositive(array));

      System.out.println("12. Print Element Frequency:");
      ArraySearch.printElementFrequency(array);
   }
}
