/**
 ** Problem Summary:
 * Implement the counting sort algorithm for a list of integers.
 * Comparison sorting limitations are discussed, and counting sort, a non-comparison
 * sorting method,is introduced as an alternative.
 * The challenge is to count and return the frequency of each value in the input list.
 *
 * Input Format:
 * The first line contains an integer 'n', the number of items in arr.
 * Each of the next n lines contains integer arr[i] where 0 <= i <= n
 *
 * Output Format:
 * Return a frequency array, where each element represents the count of its
 * corresponding index value in the input list.
 *
 * Constraints:
 * 100 <= n < 10^6
 * 0 <= arr[i]< 100
 *
 * Returns: int[100]: a frequency array with 100 elements
 */

package _HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D2CountingSortI {
  public static List<Integer> countingSort(List<Integer> arr) {
    int[] freq = new int[100];
    Arrays.fill(freq, 0);
    for (int i = 0; i < arr.size(); i++) {
      int num = arr.get(i);
      freq[num] = freq[num] + 1;
    }
    return Arrays.stream(freq).boxed().collect(Collectors.toList());
  }

  public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(
    63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56,
    9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39,
    25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32,
    18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41,
    78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44,
    9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13,
    87, 70, 33);

    List<Integer> result = countingSort(arr);
    System.out.println(result.toString());
  }
}
