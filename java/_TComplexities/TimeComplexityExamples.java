package _TComplexities;
import java.util.Arrays;

public class TimeComplexityExamples {

    // O(1) - Constant Time Complexity
    // This method returns the first element of the array, regardless of its size.
    // Accessing a specific index in an array takes constant time.
    public static int constantTimeExample(int[] arr) {
        return arr[0];
    }

    // O(log n) - Logarithmic Time Complexity
    // This method performs binary search on a sorted array to find the target element.
    // At each step, it reduces the search space by half, leading to a logarithmic time complexity.
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // O(n) - Linear Time Complexity
    // This method calculates the sum of all elements in the array.
    // It needs to iterate over each element in the array once, leading to a linear time complexity.
    public static int linearTimeExample(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        return total;
    }

    // O(n log n) - Linearithmic Time Complexity
    // This method performs merge sort on an array to sort it in ascending order.
    // Merge sort divides the array into halves recursively and then merges them, leading to a n log n time complexity.
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // O(n^2) - Quadratic Time Complexity
    // This method sorts the array using the bubble sort algorithm.
    // Bubble sort compares adjacent elements and swaps them if they are in the wrong order, leading to a n^2 time complexity.
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // O(2^n) - Exponential Time Complexity
    // This method calculates the nth Fibonacci number using recursion.
    // It recursively calculates Fibonacci numbers by branching into two recursive calls for each number, leading to an exponential time complexity.
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        // Example usage of each method with explanations
        int[] arr = {5, 2, 9, 1, 6};
        
        // O(1) - Constant Time Complexity
        System.out.println("Constant Time Example: " + constantTimeExample(arr) + " (always returns the first element)");
        
        // O(log n) - Logarithmic Time Complexity
        System.out.println("Binary Search Result: " + binarySearch(arr, 9) + " (index of target element)");
        
        // O(n) - Linear Time Complexity
        System.out.println("Linear Time Example: " + linearTimeExample(arr) + " (sum of all elements)");
        
        // O(n log n) - Linearithmic Time Complexity
        mergeSort(arr);
        System.out.println("Merge Sorted Array: " + Arrays.toString(arr) + " (sorted in ascending order)");
        
        // O(n^2) - Quadratic Time Complexity
        bubbleSort(arr);
        System.out.println("Bubble Sorted Array: " + Arrays.toString(arr) + " (sorted in ascending order)");
        
        // O(2^n) - Exponential Time Complexity
        int n = 5;
        System.out.println("Fibonacci of " + n + ": " + fibonacci(n) + " (recursive calculation)");
    }
}
