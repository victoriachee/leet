/**
 * The {@code CalculateProductExceptSelf} class provides methods for efficiently calculating
 * the product of elements except itself in an integer array. It utilizes a Prefix-Suffix
 * approach with both forward and backward passes for optimal time and space complexity.
 * <p>
 * The main method, {@link #productExceptSelf(int[])}, performs the calculation using an
 * in-place technique, achieving a time complexity of O(n) and a space complexity of O(1).
 * Additionally, alternative approaches using prefix and suffix products, as well as a
 * brute-force method, are commented out for reference.
 * <p>
 */

package patterns.PrefixSuffix;

import java.util.Arrays;

public class CalculateProductExceptSelf {

   /**
    * Calculates the product of elements except itself in the given integer array using a
    * Prefix-Suffix approach with forward and backward passes.
    *
    * @param nums The input integer array.
    * @return An array containing the product of elements except itself for each index.
    */
   public static int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] answer = new int[n];

      // ! PrefixSuffix In-place -> Time Complexity: O(n), Space Complexity O(1)
      Arrays.fill(answer, 1);
      int product = 1;
      for (int i = 0; i < n; i++) { //Forward pass Initial State: answer = [1, 1, 1, 1]
         answer[i] *= product;   // answer[0] = 1*1, answer[1] =  1*1, 1*2, 1*6
         product *= nums[i];     // product =   1*1, product =    1*2, 2*3 (6*4)
                                 // answer = [1, 1, 2, 6]
      }
      product = 1;
      for (int i = n - 1; i >= 0; i--) { //Backward pass: calc suffix product for each elem
         answer[i] *= product;   // answer[3] = 6*1, 2*4, 1*12, 1*24
         product *= nums[i];     // product =   1*4, 4*3, 12*2 (24*1)
                                 // answer = [24, 12, 8, 6]
      }
      //This means:
      /*
         For index 0: the product of elements except nums[0] is 2 * 3 * 4 = 24
         For index 1: the product of elements except nums[1] is 1 * 3 * 4 = 12
         For index 2: the product of elements except nums[2] is 1 * 2 * 4 = 8
         For index 3: the product of elements except nums[3] is 1 * 2 * 3 = 6
       */

      // // !! PrefixSuffix -> Time Complexity: O(n), Space Complexity O(n)
      // int[] prefixProducts = new int[n];
      // int[] suffixProducts = new int[n];
      // int prefixProduct = 1;
      // for (int i = 0; i < n; i++) {
      //    prefixProducts[i] = prefixProduct;
      //    prefixProduct *= nums[i];
      // }

      // int suffixProduct = 1;
      // for (int i = n - 1; i >= 0; i--) {
      //    suffixProducts[i] = suffixProduct;
      //    suffixProduct *= nums[i];
      // }

      // for (int i = 0; i < n; i++) {
      //    answer[i] = prefixProducts[i] * suffixProducts[i];
      // }

      // E.g.
      // nums = [1, 2, 3, 4]
      // prefixProducts = [1, 1, 2, 6]
      // suffixProducts = [24, 12, 4, 1]
      // answer = [24, 12, 8, 6]

      // !! Brute Force - Time Complexity: O(n^2)
      // for (int i = 0; i < nums.length; i++) {
      //     int self = nums[i];
      //     int product = 1;
      //     for (int j = 0; j < nums.length; j++) {
      //         if (j != i) {
      //             product *= nums[j];
      //         }
      //     }
      //     answer[i] = product;
      // }

      return answer;
   }

   public static void main(String[] args) {
      int[] test1 = productExceptSelf(new int[] { 1, 2, 3, 4 });
      System.out.println(Arrays.toString(test1));

      int[] test2 = productExceptSelf(new int[] { -1, 1, 0, -3, 3 });
      System.out.println(Arrays.toString(test2));
   }
}
