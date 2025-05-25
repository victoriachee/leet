package practice.SlidingWindow;

public class MaxSumSizeK {

    /**
     * Finds the maximum sum of a subarray with at most k elements.
     *
     * @param nums The input array.
     * @param k     The maximum number of elements in the subarray.
     * @return The maximum sum of a subarray with at most k elements.
     */
    public static int maxSumSizeK(int[] nums, int k) {
        if (k ==0 || nums.length == 0 || nums == null) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE; // best practice for max sum,
        // covers all edge cases, negative array
        int currSum = 0; // sum of current window
        int windowStart = 0; // start of window

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            currSum += nums[windowEnd];

            if (windowEnd - windowStart + 1 > k) {
                currSum -= nums[windowStart];
                windowStart++;
            }

            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // Test case 1: Normal case
        int[] nums1 = { 1, -2, 3, 4, -1 };
        int k1 = 2;
        System.out.println(
            "Max sum of subarray with at most " + k1 + " elements: " + maxSumSizeK(nums1, k1)
        ); // Expected output: 7

        // Test case 2: All negative numbers
        int[] nums2 = { -3, -2, -1 };
        int k2 = 2;
        System.out.println(
            "Max sum of subarray with at most " + k2 + " elements: " + maxSumSizeK(nums2, k2)
        ); // Expected output: -3

        // Test case 3: Single element
        int[] nums3 = { 5 };
        int k3 = 1;
        System.out.println(
            "Max sum of subarray with at most " + k3 + " elements: " + maxSumSizeK(nums3, k3)
        ); // Expected output: 5

        // Test case 4: Empty array
        int[] nums4 = {};
        int k4 = 3;
        System.out.println(
            "Max sum of subarray with at most " + k4 + " elements: " + maxSumSizeK(nums4, k4)
        ); // Expected output: 0

        // Test case 5: k larger than array length
        int[] nums5 = { 1, 2, 3 };
        int k5 = 5;
        System.out.println(
            "Max sum of subarray with at most " + k5 + " elements: " + maxSumSizeK(nums5, k5)
        ); // Expected output: 6

        // Additional test case: Larger array
        int[] nums6 = { 1, 2, 3, 4, 5, -1, -2, -3, 6 };
        int k6 = 3;
        System.out.println(
            "Max sum of subarray with at most " + k6 + " elements: " + maxSumSizeK(nums6, k6)
        ); // Expected output: 12
    }
}
