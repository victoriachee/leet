/**
 * [ Bubble Sort Algorithm ]
 *
 **  Time Complexity:
 *   Worst Case:    O(n^2) - nested for loops
 *   Average Case:  O(n^2)
 *   Best Case:     O(n) - when the array is already sorted
 *
 **  Space Complexity:
 *   O(1) - Constant space usage (no additional space required)
 */

package algos.Sort;

import java.util.Arrays;

public class _BubbleSort {

   static void bubbleSort(int[] arr) {
      int n = arr.length;

      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
               // swap temp and arr[i]
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }
   }

   public static void main(String[] args) {
      int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

      System.out.println("Original Array:" + Arrays.toString(arr));

      bubbleSort(arr);

      System.out.println("\nSorted Array:" + Arrays.toString(arr));
   }
}
