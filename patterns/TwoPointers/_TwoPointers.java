/**
 * Class with functions to solve generic two-pointer problems.
 */
package patterns.TwoPointers;

import java.util.Arrays;

public class _TwoPointers {

   /**
    * Finds the count of distinct elements in a sorted array.
    *
    * @param arr The sorted input array.
    * @return The count of distinct elements.
    */
   public static int countDistinctElements(int[] arr) {
      if (arr == null || arr.length == 0) {
         throw new IllegalArgumentException("Invalid input");
      }

      int count = 1; // At least one distinct element (the first one)
      for (int i = 1; i < arr.length; i++) {
        // Check if current elem is different from prev one
         if (arr[i] != arr[i - 1]) {
            count++; // If different, increment count
         }
      }

      return count;
   }

   /**
    * Removes duplicates from a sorted array in-place.
    *
    * @param arr The sorted input array.
    * @return The length of the array after removing duplicates.
    */
   public static int removeDuplicatesInPlace(int[] arr) {
      if (arr == null || arr.length == 0) {
         throw new IllegalArgumentException("Invalid input");
      }

      int uniqueIdx = 1;// First elem is always unique, iterate starting from second elem
      for (int i = 1; i < arr.length; i++) {
         // Check if current elem is different from prev one
         if (arr[i] != arr[i - 1]) {
             // If different, update array at unique index & increment index
            arr[uniqueIdx++] = arr[i];
         }
      }

      return uniqueIdx;
   }

   /**
    * Finds the intersection of two sorted arrays.
    *
    * @param arr1 The first sorted array.
    * @param arr2 The second sorted array.
    * @return The intersection of the two arrays.
    */
   public static int[] findIntersection(int[] arr1, int[] arr2) {
      if (arr1 == null || arr2 == null) {
         throw new IllegalArgumentException("Invalid input");
      }

      // Two pointers at start of both arrays
      int i = 0, j = 0;
      // Array to store common elements/ intersections
      int[] intersection = new int[Math.min(arr1.length, arr2.length)];
      int idx = 0; // Index to insert new intersection

      // Compare elements at the current positions of the pointers
      while (i < arr1.length && j < arr2.length) {
         if (arr1[i] < arr2[j]) { 
            // If arr1[i] is less than arr2[j], increment i
            i++; 
         } else if (arr1[i] > arr2[j]) {
            // If arr1[i] is greater than arr2[j], increment j 
            j++;
         } else {
            // If they are equal, store the intersection. Increment both pointers.
            intersection[idx++] = arr1[i];
            i++;
            j++;
         }
      }

      return Arrays.copyOfRange(intersection, 0, idx);
   }

   /**
    * Finds a pair with a given sum in a sorted array using the two-pointer technique.
    *
    * @param nums  The sorted input array.
    * @param target  The target sum.
    * @return True if a pair with the given sum is found, false otherwise.
    */
   public static boolean findPairWithSum(int[] nums, int target) {
      if (nums == null || nums.length < 2) {
         throw new IllegalArgumentException("Invalid input");
      }

      // Use two pointers, one starting from the beginning and the other from the end
      int left = 0;
      int right = nums.length - 1;

      // Adjust pointers based on the sum compared to the target
      while (left < right) {
         int sum = nums[left] + nums[right];

         if (sum == target) {
            return true; // Pair found
         } else if (sum < target) {
            left++;
         } else {
            right--;
         }
      }
      return false; // Pair not found
   }

   /**
    * Finds a triplet with a given sum in a sorted array using the two-pointer technique.
    *
    * @param arr  The sorted input array.
    * @param target  The target sum.
    * @return True if a triplet with the given sum is found, false otherwise.
    */
   public static boolean findTripletWithSum(int[] arr, int target) {
      if (arr == null || arr.length < 3) {
         throw new IllegalArgumentException("Invalid input");
      }

      for (int i = 0; i < arr.length - 2; i++) {
         int left = i + 1;
         int right = arr.length - 1;

         // Fix one element & apply two pointer on remaining array
         while (left < right) {
            int currentSum = arr[i] + arr[left] + arr[right];

            if (currentSum == target) {
               return true; // Triplet found
            } else if (currentSum < target) {
               left++;
            } else {
               right--;
            }
         }
      }
      return false; // Triplet not found
   }

   /**
    * Calculates the maximum area of water that can be trapped by vertical lines using the two-pointer technique.
    * The function iterates from both ends towards the center, adjusting pointers based on the height.
    *
    * @param height The array representing the heights of the vertical lines.
    * @return The maximum area of water that can be trapped.
    */
   public static int maxArea(int[] height) {
      int maxArea = 0;
      int left = 0, right = height.length - 1;

      while (left < right) {
         int h = Math.min(height[left], height[right]); // maxarea is the min height * width
         maxArea = Math.max(maxArea, h * (right - left)); //right - left = width

         if (height[left] < height[right]) {
            left++;
         } else {
            right--;
         }
      }

      return maxArea;
   }

   //----------------------------------------------------------------------------------------

   public static void main(String[] args) {
      int[] sortedArray = { 1, 2, 2, 3, 4, 4, 5, 5, 6, 7, 8, 8, 9 };
      System.out.println(Arrays.toString(sortedArray));

      // Example 1: Count distinct elements
      System.out.println("Count of distinct elements: " + countDistinctElements(sortedArray));

      // Example 2: Remove duplicates
      int uniqueLength = removeDuplicatesInPlace(sortedArray);
      System.out.println(
         "Unique array length: " +
         uniqueLength +
         ", Unique array: " +
         Arrays.toString(Arrays.copyOf(sortedArray, uniqueLength))
      );

      // Example 3: Find intersection of two arrays
      int[] arr1 = { 1, 2, 3, 4, 5 };
      int[] arr2 = { 3, 4, 5, 6, 7 };
      int[] intersection = findIntersection(arr1, arr2);
      System.out.println("Intersection of two arrays: " + Arrays.toString(intersection));

      int[] sortedArray2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      System.out.println(Arrays.toString(sortedArray2));

      //  2Sum:
      int pairSum = 10;
      System.out.println(
         "Pair with sum " + pairSum + " exists: " + findPairWithSum(sortedArray2, pairSum)
      );

      //  3Sum:
      int tripletSum = 15;
      System.out.println(
         "Triplet with sum " +
         tripletSum +
         " exists: " +
         findTripletWithSum(sortedArray2, tripletSum)
      );

      //  Container With Most Water:
      int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
      System.out.println("Max area of water trapped: " + maxArea(heights));
   }
}
