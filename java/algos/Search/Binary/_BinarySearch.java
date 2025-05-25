/**
 * The expression (right - left) is more likely to overflow than right / 2 because
 * (right - left) can be a large positive value, and if left is close to
 * Integer.MIN_VALUE and right is close to Integer.MAX_VALUE, the subtraction could
 * overflow.
 * By using left + (right - left) / 2, the subtraction is performed first (brackets),
 * and then the division by 2 is applied. This order of operations helps reduce the
 * risk of overflow.
 *
 * BODMAS - Brackets, Order (^, sq. root), Multiply or Divide, Addition or Subtraction
 */

package algos.Search.Binary;

public class _BinarySearch {

    /**
     * Iterative Binary Search: Finds the target in a sorted array.
     * If you are only interested in finding any occurrence of the target, you can use binarySearch
     *
     * @param arr   The sorted array.
     * @param target The target value to search for.
     * @return The index of the target in the array, or -1 if not found.
     * @throws IllegalArgumentException if the input array is not sorted.
     */
    public static int binarySearch(int[] arr, int target) {
        // Check if the array is sorted
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new IllegalArgumentException("Input array must be sorted");
            }
        }
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoids Integer overflow

            if (arr[mid] == target) {
                return mid; // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }

        return -1; // Target not found
    }

    /**
     * Performs a binary search on a sorted array to find the index of the target element recursively.
     *
     * @param arr    The sorted array to be searched.
     * @param target The target element to be searched for.
     * @param left   The leftmost index of the search range.
     * @param right  The rightmost index of the search range.
     * @return The index of the target element if found; otherwise, -1.
     * @throws IllegalArgumentException if the input array is not sorted.
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        // Check if the array is sorted
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new IllegalArgumentException("Input array must be sorted");
            }
        }
        // Perform binary search recursively
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Element found, return its index
            } else if (arr[mid] < target) {
                return binarySearchRecursive(arr, target, mid + 1, right);
            } else {
                return binarySearchRecursive(arr, target, left, mid - 1);
            }
        }

        return -1; // Element not found
    }

    /**
     * Binary Search with Equality Predicates: Finds the leftmost occurrence of the target.
     * If you need to find the leftmost occurrence of the target (in case of duplicates),
     * you should use leftmostBinarySearch
     *
     * @param nums   The sorted array.
     * @param target The target value to search for.
     * @return The leftmost index of the target in the array, or -1 if not found.
     */
    public static int leftmostBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid; // Target is in the left half or at mid
            }
        }

        return nums[left] == target ? left : -1;
    }

    /**
     * Binary Search with Inequality Predicates: Finds the rightmost occurrence of the target.
     * Useful when you need to identify the last position of a specific value.
     *
     * @param nums   The sorted array.
     * @param target The target value to search for.
     * @return The rightmost index of the target in the array, or -1 if not found.
     */
    public static int rightmostBinarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2 + 1; // Make mid biased to the right

            if (nums[mid] > target) {
                right = mid - 1; // Target is in the left half
            } else {
                left = mid; // Target is in the right half or at mid
            }
        }

        return nums[left] == target ? left : -1;
    }

    /**
     * Search in Rotated Sorted Array: Finds the target in a rotated sorted array.
     * A rotated sorted array is an array that was originally sorted in ascending
     * order, but it has been rotated at some pivot unknown to you beforehand.
     * The array might contain duplicates.
     *
     * @param nums   The rotated sorted array.
     * @param target The target value to search for.
     * @return The index of the target in the array, or -1 if not found.
     */
    public static int searchInRotatedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            }

            if (nums[left] <= nums[mid]) {
                // Left half is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left half
                } else {
                    left = mid + 1; // Target is in the right half
                }
            } else {
                // Right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Target is in the right half
                } else {
                    right = mid - 1; // Target is in the left half
                }
            }
        }

        return -1; // Target not found
    }

    /**
     * Find Minimum in Rotated Sorted Array: Finds the minimum element in a rotated sorted array.
     *
     * @param nums The rotated sorted array.
     * @return The minimum element in the array.
     */
    public static int findMinInRotatedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1; // Minimum is in the right half
            } else {
                right = mid; // Minimum is in the left half or at mid
            }
        }

        return nums[left];
    }

    /**
     * Square Root of a Number: Finds the square root of a non-negative integer.
     *
     * @param x The non-negative integer.
     * @return The square root as an integer.
     */
    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid; // Found the exact square root
            } else if (mid > x / mid) {
                right = mid - 1; // Square root is in the left half
            } else {
                left = mid + 1; // Square root is in the right half
            }
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        // Test cases
        int[] sortedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 6;

        System.out.println("Basic Binary Search: " + binarySearch(sortedArray, target));

        System.out.println("Leftmost Binary Search: " + leftmostBinarySearch(sortedArray, target));

        System.out.println(
            "Rightmost Binary Search: " + rightmostBinarySearch(sortedArray, target)
        );

        int[] rotatedSortedArray = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(
            "Search in Rotated Sorted Array: " + searchInRotatedArray(rotatedSortedArray, target)
        );

        int[] rotatedSortedArrayWithDuplicates = { 1, 1, 3, 4, 4, 5, 6, 7, 8, 8 };
        System.out.println(
            "Find Minimum in Rotated Sorted Array: " +
            findMinInRotatedArray(rotatedSortedArrayWithDuplicates)
        );

        int x = 8;
        System.out.println("Square Root of " + x + ": " + sqrt(x));
    }
}
