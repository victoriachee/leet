/**
 * [ QuickSort Algorithm ]
 *
 **  Time Complexity:
 *   Worst Case:    O(n^2) (rare, but can happen with poorly chosen pivot)
 *   Average Case:  O(n log n)
 *   Best Case:     O(n log n) (with good pivot selection)
 *
 **  Space Complexity:
 *   Average Case:  O(log n) - Due to the recursive call stack.
 *   Worst Case:    O(n) - This occurs in the worst case when the recursion depth
 *                  is equal to the number of elements in the array.
 */

package algos.Sort;

import java.util.Arrays;

public class _QuickSort {

   public static void main(String[] args) {
      int[] array = { 12, 11, 13, 10, 7, 9 };
      quickSort(array, 0, array.length - 1);

      System.out.println("Sorted array: " + Arrays.toString(array));
   }

   public static void quickSort(int[] arr, int low, int high) {
      if (low < high) {
         int partitionIndex = partition(arr, low, high);
         quickSort(arr, low, partitionIndex - 1);
         quickSort(arr, partitionIndex + 1, high);
      }
   }

   public static int partition(int[] arr, int low, int high) {
      // Choose the center element as the pivot
      int pivot = arr[(low + high) / 2];

      // Move the pivot to the start
      swap(arr, low, (low + high) / 2);

      int last_small = low;

      for (int i = low + 1; i <= high; i++) {
         if (arr[i] < pivot) {
            last_small++;
            swap(arr, i, last_small);
         }
      }

      // Move the pivot back to its final position
      swap(arr, low, last_small);

      return last_small;
   }

   public static void swap(int[] arr, int i, int j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
   }
}
