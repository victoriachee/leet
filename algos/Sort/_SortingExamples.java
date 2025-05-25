package algos.Sort;

import java.util.Arrays;

public class _SortingExamples {

   /**
    * Sorts an array with duplicate elements without using extra space.
    *
    * @param nums The input array with duplicate elements.
    */
   public static void sortArrayWithDuplicates(int[] nums) {
      Arrays.sort(nums);
   }

   /**
    * Finds the Kth smallest element in an array using sorting.
    *
    * @param nums The input array.
    * @param k    The value of K.
    * @return The Kth smallest element.
    */
   public static int findKthSmallest(int[] nums, int k) {
      // Sort the array in ascending order
      Arrays.sort(nums);

      // The Kth smallest element is at index (k-1) in the sorted array
      return nums[k - 1];
   }

   /**
    * Checks if an array is sorted in non-decreasing order.
    *
    * @param nums The input array.
    * @return True if the array is sorted, false otherwise.
    */
   public static boolean isSorted(int[] nums) {
      for (int i = 1; i < nums.length; i++) {
         if (nums[i - 1] > nums[i]) {
            return false;
         }
      }
      return true;
   }

   /**
    * Finds the Kth largest element in an array using sorting.
    *
    * @param nums The input array.
    * @param k    The value of K.
    * @return The Kth largest element.
    */
   public static int findKthLargest(int[] nums, int k) {
      // Sort the array in descending order
      Arrays.sort(nums);

      // The Kth largest element is at index (k-1) in the sorted array
      return nums[nums.length - k];
   }

   /**
    * Merges two sorted arrays into a single sorted array.
    *
    * @param nums1 The first sorted array.
    * @param nums2 The second sorted array.
    * @return The merged sorted array.
    */
   public static int[] mergeSortedArrays(int[] nums1, int[] nums2) {
      int[] result = new int[nums1.length + nums2.length];

      int i = 0, j = 0, k = 0;

      while (i < nums1.length && j < nums2.length) {
         if (nums1[i] <= nums2[j]) {
            result[k++] = nums1[i++];
         } else {
            result[k++] = nums2[j++];
         }
      }

      // add in remaining singular nums1 or nums2 elems
      while (i < nums1.length) {
         result[k++] = nums1[i++];
      }

      while (j < nums2.length) {
         result[k++] = nums2[j++];
      }

      return result;
   }

   /**
    * Example: Finding Kth Largest Element.
    */
   public static void main(String[] args) {
      int[] nums = { 3, 1, 4, 4, 2, 2, 1, 3, 5 };
      int k = 3;

      System.out.println("Original Array: " + Arrays.toString(nums));
      System.out.println("Kth Smallest Element (K = " + k + "): " + findKthSmallest(nums, k));

      System.out.println("Is the array sorted? " + isSorted(nums));

      System.out.println("Original Array: " + Arrays.toString(nums));
      System.out.println("Kth Largest Element (K = " + k + "): " + findKthLargest(nums, k));

      // Example usage of mergeSortedArrays
      int[] nums1 = { 1, 3, 5, 7 };
      int[] nums2 = { 2, 4, 6, 8 };
      int[] mergedArray = mergeSortedArrays(nums1, nums2);
      System.out.println("Merged Sorted Array: " + Arrays.toString(mergedArray));
   }
}
