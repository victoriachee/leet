package patterns.SlidingWindow;

// import java.util.Arrays;

/**
 * Class with functions to solve generic sliding window problems.
 */
public class _SlidingWindow {

   /**
    * Finds the maximum sum of a subarray of fixed size k using the sliding window technique.
    *
    * @param nums The input array.
    * @param k    The size of the sliding window.
    * @return The maximum sum of a subarray of size k.
    */
   public static int maxSumSubarrayOfSizeK(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
         throw new IllegalArgumentException("Invalid input");
      }

      // Arrays.sort(nums); // Sort 

      int maxSum = 0;
      int currSum = 0;

      // Calculate the initial sum for the first window
      for (int i = 0; i < k; i++) {
         currSum += nums[i];
      }

      // Slide the window and update the sums
      for (int i = k; i < nums.length; i++) {
         currSum = currSum + nums[i] - nums[i - k];
         maxSum = Math.max(maxSum, currSum);
      }

      return maxSum;
   }

    /**
     * Finds the minimum size of a subarray with a sum greater than or equal to a target value.
     *
     * @param target The target sum value.
     * @param nums   The input array.
     * @return The minimum size of a subarray with a sum greater than or equal to the target.
     */
    public static int minSubarraySize(int target, int[] nums) {
        if (nums == null || nums.length == 0 || target <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum >= target) {
               // end - start + 1 is the num of elems in subarray inclusive
                minSize = Math.min(minSize, end - start + 1); 
                sum -= nums[start];
                start++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

   /**
    * Finds the maximum sum of a subarray with at most k elements.
    *
    * @param array The input array.
    * @param k     The maximum number of elements in the subarray.
    * @return The maximum sum of a subarray with at most k elements.
    */
    public static int maxSumAtMostK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int maxSum = 0; // Initialize the maximum sum
        int currSum = 0; // Initialize the current sum
        int start = 0; // Initialize the start of the sliding window

        // Iterate through the array with a sliding window
        for (int end = 0; end < nums.length; end++) {
            currSum += nums[end];

            // Shrink the window until it contains at most k elements
            while (end - start + 1 > k) {
                currSum -= nums[start];
                start++;
            }

            // Update the maximum sum
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

   public static void main(String[] args) {
      // Example usage of the functions
      int[] array1 = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
      System.out.println("Max sum of subarray of size 3: " + maxSumSubarrayOfSizeK(array1, 3)); // 34

      int[] array2 = { 2, 3, 1, 2, 4, 3 };
      System.out.println("Min size of subarray with sum >= 7: " + minSubarraySize(7, array2)); // 2

      int[] array3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      System.out.println(
         "Max sum of subarray with at most 3 elements: " + maxSumAtMostK(array3, 3)
      ); // 24
   }
}
