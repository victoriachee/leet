/**
 * [ MergeSort Algorithm ]
 *
 **  Time Complexity:
 *   Worst Case:    O(n log n)
 *   Average Case:  O(n log n)
 *   Best Case:     O(n log n)
 *
 **  Space Complexity:
 *   O(n) - Additional space for merging
 */

package algos.Sort;

import java.util.Arrays;

public class _MergeSort {

   /**
    * Sorts the given array using the merge sort algorithm.
    *
    * @param arr The array to be sorted.
    */
   public static void mergeSort(int[] arr) {
      if (arr.length > 1) {
         int mid = arr.length / 2;
         int[] left = Arrays.copyOfRange(arr, 0, mid);
         int[] right = Arrays.copyOfRange(arr, mid, arr.length);

         // Recursively split arrs into left and right until they have 1 element
         mergeSort(left);
         mergeSort(right);

         // In each recursive call, merge the two arrays
         // First called when left and right have 1 element each
         merge(arr, left, right);
      }
   }

   /**
    * Merges two sorted subarrays into a single sorted array. Updates arr param
    * in-place starting with the smallest element and ending with the largest.
    *
    * @param arr   The original array to be merged into
    * @param left  The sorted left subarray
    * @param right The sorted right subarray
    */
   private static void merge(int[] arr, int[] left, int[] right) {
      int i = 0, j = 0, k = 0;

      while (i < left.length && j < right.length) {
         if (left[i] <= right[j]) {
            arr[k++] = left[i++]; // Update arr in-place
         } else {
            arr[k++] = right[j++]; // Update arr in-place
         }
      }

      while (i < left.length) {
         arr[k++] = left[i++];
      }

      while (j < right.length) {
         arr[k++] = right[j++];
      }
   }

   /**
    * Implements in-place merge sort for an array of integers.
    *
    * @param nums The input array of integers.
    */
   public static void inPlaceMergeSort(int[] nums) {
      mergeSort(nums, 0, nums.length - 1);
   }

   private static void mergeSort(int[] nums, int left, int right) {
      if (left < right) {
         int mid = left + (right - left) / 2;
         mergeSort(nums, left, mid);
         mergeSort(nums, mid + 1, right);
         merge(nums, left, mid, right);
      }
   }

   private static void merge(int[] nums, int left, int mid, int right) {
      int n1 = mid - left + 1;
      int n2 = right - mid;

      int[] leftArray = new int[n1];
      int[] rightArray = new int[n2];

      // Copy data to temporary arrays
      System.arraycopy(nums, left, leftArray, 0, n1);
      System.arraycopy(nums, mid + 1, rightArray, 0, n2);

      int i = 0, j = 0, k = left;

      // Merge the temporary arrays back into the original array
      while (i < n1 && j < n2) {
         if (leftArray[i] <= rightArray[j]) {
            nums[k++] = leftArray[i++];
         } else {
            nums[k++] = rightArray[j++];
         }
      }
      // Copy the remaining elements of leftArray, if any
      while (i < n1) {
         nums[k++] = leftArray[i++];
      }

      // Copy the remaining elements of rightArray, if any
      while (j < n2) {
         nums[k++] = rightArray[j++];
      }
   }

   public static void main(String[] args) {
      int[] array = { 12, 11, 13, 5, 6, 7 };

      System.out.println("Original Array: " + Arrays.toString(array));

      _MergeSort.mergeSort(array);

      System.out.println("Sorted Array: " + Arrays.toString(array));
   }
}
