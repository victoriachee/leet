/** 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 *
 * !! MEDIUM
 * #Matrix  #Intervals  #Stack  #Comparator  #Sorting
 * Given an array of intervals, where each interval is represented as [start, end],
 * merge overlapping intervals and return an array of non-overlapping intervals.
 *
 * Example:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 *
 * Constraints:
 * 1 <= intervals.length <= 10^4
 * intervals[i].length == 2
 * 0 <= start <= end <= 10^4
 */

package patterns.Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

   public static int[][] merge(int[][] intervals) {
      int numInts = intervals.length; // Num of intervals

      // Sort intervals based on the first interval value
      Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

      Stack<int[]> intStack = new Stack<>();
      intStack.add(intervals[0]); // Add first interval to stack

      // Forward pass starting from second interval
      for (int i = 1; i < numInts; i++) {
         int int1first = intStack.peek()[0];
         int int1last = intStack.peek()[1];

         int int2first = intervals[i][0];
         int int2last = intervals[i][1];

         // If last of first interval > first of second interval, intervals overlap
         if (int1last >= int2first) {
            // Check which last value (interval[i][1]) is larger
            int maxLast = Math.max(int1last, int2last);
            intStack.pop();
            intStack.add(new int[] { int1first, maxLast });
         } else {
            intStack.add(new int[] { int2first, int2last });
         }
      }

      int numMerged = intStack.size();
      int[][] merged = new int[numMerged][];
      int i = 0;
      for (int[] interval : intStack) {
         merged[i] = interval; // E.g. Int array at position i is [1,6]
         i++;
      }
      /// OR: do a Backward pass for stack size and use stack.pop()
      // - This is less efficient as .pop() takes O(1) time,
      // - whereas enhanced for-loop accesses stack value directly, O(n)
      //
      // int numMerged = intStack.size();
      // int[][] merged = new int[numMerged][];
      //  for (int i = numMerged - 1; i >= 0; i ++) {
      //  merged[i] = intStack.pop();
      // }

      return merged;
   }

   public static void main(String[] args) {
      int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
      System.out.println(Arrays.deepToString(intervals1) + ": ");
      int[][] result1 = merge(intervals1);
      System.out.println(Arrays.deepToString(result1));

      int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
      System.out.println(Arrays.deepToString(intervals2) + ": ");
      int[][] result2 = merge(intervals2);
      System.out.println(Arrays.deepToString(result2));

      int[][] intervals3 = { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
      System.out.println(Arrays.deepToString(intervals3) + ": ");
      int[][] result3 = merge(intervals3);
      System.out.println(Arrays.deepToString(result3));

      int[][] intervals4 = { { 1, 4 }, { 0, 1 } };
      System.out.println(Arrays.deepToString(intervals4) + ": ");
      int[][] result4 = merge(intervals4);
      System.out.println(Arrays.deepToString(result4));

      int[][] intervals5 = { { 1, 4 }, { 0, 4 } };
      System.out.println(Arrays.deepToString(intervals5) + ": ");
      int[][] result5 = merge(intervals5);
      System.out.println(Arrays.deepToString(result5));
   }
}
