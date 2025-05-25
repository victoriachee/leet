/** 986. Interval List Intersections
 * https://leetcode.com/problems/interval-list-intersections/
 *
 * #Intervals  #TwoPointers  #Matrix
 *
 * You are given two lists of closed intervals, firstList & secondList,
 * where firstList[i] = [starti, endi] & secondList[j] = [startj, endj].
 * Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * Closed Interval: A closed interval [a, b] (with a <= b) denotes the set of
 * real numbers x with a <= x <= b. It includes all numbers without missing numbers
 * from the range of a to b inclusive.
 *
 * Intersection of Intervals: The intersection of two closed intervals is a set of
 * real numbers that are either empty or represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 *
 * Example:
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 *
 * Constraints:
 * - 0 <= firstList.length, secondList.length <= 1000
 * - firstList.length + secondList.length >= 1
 * - 0 <= starti < endi <= 10^9
 * - endi < starti+1
 * - 0 <= startj < endj <= 10^9
 * - endj < startj+1
 *
 */

package patterns.Intervals;

import java.util.ArrayList;
import java.util.List;

public class FindIntervalListIntersections {

   public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
      List<int[]> resList = new ArrayList<>();

      int i = 0; // Pointer for firstList
      int j = 0; // Pointer for secondList

      while (i < firstList.length && j < secondList.length) {
         // Calculate the intersection of intervals
         // firstList =     [[0,2], [5,10], [13,23], [24,25]]
         // secondList =    [[1,5], [8,12], [15,24], [25,26]]
         // Output:         [[1,2], [5,5], [8,10], [15,23], [24,24], [25,25]]
         // Interval start is max of start values
         int start = Math.max(firstList[i][0], secondList[j][0]); // 1st Iter: start = max(0, 1) = 1
                                                                  // 2nd Iter: start = max(5, 1) = 5
         // Interval end is min of end values                                                  
         int end = Math.min(firstList[i][1], secondList[j][1]); // 1st Iter: end = min(2, 5) = 2
                                                                // 2nd Iter: end = min(10, 5) = 5

         // Check if there is a valid intersection
         if (start <= end) { // start <= end, add [1, 2] to the result list
            resList.add(new int[] { start, end });
         }

         // Move pointers based on endpoint of smaller interval
         if (firstList[i][1] < secondList[j][1]) {
            i++;
         } else {
            j++;
         }
      }

      // Convert the result list to a 2D array
      return resList.toArray(new int[resList.size()][]);
   }

   public static void main(String[] args) {
      FindIntervalListIntersections solution = new FindIntervalListIntersections();

      int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
      int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };

      int[][] result = solution.intervalIntersection(firstList, secondList);

      // Print the result
      for (int[] interval : result) {
         System.out.println("[" + interval[0] + ", " + interval[1] + "]");
      }
   }
}
