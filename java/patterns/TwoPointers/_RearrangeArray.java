/**
 * Class to rearrange a sorted array in non-decreasing order using the two-pointer approach.
 */
package patterns.TwoPointers;

import java.util.Arrays;

public class _RearrangeArray {
    /**
     * Rearranges a unsorted array in non-decreasing order using the two-pointer approach.
     *
     * @param arr The unsorted array to be rearranged.
     */
    public static void rearrangeUnsortedArray(int[] arr) {
        if (arr == null || arr.length <= 1) {
            // No rearrangement needed for arrays of size 0 or 1
            return;
        }

        // *Sort the array (you can use any sorting algorithm -> Bubble sort, merge sort)
        Arrays.sort(arr);

        int left = 0;  // Left pointer
        int right = arr.length - 1;  // Right pointer

        while (left < right) {
            // Swap elements at left and right pointers
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers towards each other
            left++;
            right--;
        }
    }

    /**
     * Rearranges a sorted array in non-decreasing order using the two-pointer approach.
     *
     * @param arr The sorted array to be rearranged.
     */
    public static void rearrangeSortedArray(int[] arr) {
        if (arr == null || arr.length <= 1) {
            // No rearrangement needed for arrays of size 0 or 1
            return;
        }

        int left = 0;  // Left pointer
        int right = arr.length - 1;  // Right pointer

        while (left < right) {
            // Swap elements at left and right pointers
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers towards each other
            left++;
            right--;
        }
    }
    /**
     * Main method for testing the rearrangement of a sorted array.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6};
        int[] unsortedArray = {2, 1, 6, 5, 4, 3};


        System.out.println("Original array: " + Arrays.toString(sortedArray));
        rearrangeSortedArray(sortedArray);
        System.out.println("Rearranged sorted array: " + Arrays.toString(sortedArray));
        System.out.println("Original array: " + Arrays.toString(unsortedArray));
        rearrangeUnsortedArray(unsortedArray);
        System.out.println("Rearranged unsorted array: " + Arrays.toString(unsortedArray));
    }
}
