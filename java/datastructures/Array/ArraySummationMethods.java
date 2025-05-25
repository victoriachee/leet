/**
 * This class contains all methods for summing array values:
 *
 * Time Complexity: O(n) - Linear time complexity.
 * Space Complexity: O(1) - Constant space complexity.
 *
 * In general, all the provided methods have linear time complexity because
 * they need to visit each element in the array at least once to calculate the
 * sum. The space complexity is constant (O(1)) for most of the methods, as
 * they don't use additional data structures that scale with the input size.
 */

package Array;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ArraySummationMethods {

   // 1. Traditional For Loop
   public static int calculateSumTraditionalForLoop(int[] array) {
      int sum = 0;
      for (int i = 0; i < array.length; i++) sum += array[i];
      return sum;
   }

   // 2. Enhanced For Loop
   public static int calculateSumEnhancedForLoop(int[] array) {
      int sum = 0;
      for (int num : array) sum += num;
      return sum;
   }

   // 3. Java 8+ Streams with sum method
   public static int calculateSumWithStreamSum(int[] array) {
      return Arrays.stream(array).sum();
   }

   // 4. Java 8+ Streams with reduce (starts with 0 and sums with '+')
   public static int calculateSumWithStreamReduce(int[] array) {
      return Arrays.stream(array).reduce(0, Integer::sum);
   }

   // 5. Java 8 IntStream sum
   public static int calculateSumWithIntStreamSum(int[] array) {
      return IntStream.of(array).sum();
   }

   // 6. Stream API's forEach with AtomicInteger
   public static int calculateSumWithStreamAndForEach(int[] array) {
      AtomicInteger sum = new AtomicInteger(0);
      Arrays.stream(array).forEach(num -> sum.addAndGet(num));
      return sum.get();
   }

   public static void main(String[] args) {
      int[] numbers = { 1, 2, 3, 4, 5 };

      System.out.println("Traditional For Loop: " + calculateSumTraditionalForLoop(numbers));
      System.out.println("Enhanced For Loop: " + calculateSumEnhancedForLoop(numbers));
      System.out.println("Java 8+ Streams with sum method: " + calculateSumWithStreamSum(numbers));
      System.out.println("Java 8+ Streams with reduce: " + calculateSumWithStreamReduce(numbers));
      System.out.println("Java 8 IntStream sum: " + calculateSumWithIntStreamSum(numbers));
      System.out.println("Stream API with forEach: " + calculateSumWithStreamAndForEach(numbers));
   }
}
