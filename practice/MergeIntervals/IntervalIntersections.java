package practice.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersections {
    
    /**
     * Problem:
     * - Return a 2D array of intervals representing the intersections between 2 lists of intervals.
     * - Disjoint: Not overlapping
     * - Intersection: if max(i1, j1) <= min(i2, j2) then intersection = [maxStart, minEnd]
     * Edge cases:
     * - Empty input lists: return empty result
     * - No overlap
     * - Complete overlap
     * - Partial overlap
     * 
     * Approach:
     * 2 pointer approach: iterate thru both lists simultaneously to find intersections
     * 
     * Steps: 
     * 1. Initialize results list and pointers for each list
     * 2. while loop that ends if either list ends
     * 3. compare max of start values to min of end values, add to list
     * 4. compare end values of each interval, increment the pointer of interval that ends first
     * 
     * The function `intervalIntersection` takes in two arrays of intervals and returns their
     * intersection intervals.
     * 
     * @param firstList 
     * @param secondList
     * @return The method `intervalIntersection` is expected to return a 2D array of integers
     * representing the intersection intervals between the two input arrays `firstList` and
     * `secondList`.
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[0][];
        List<int[]> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {
            int i0 = firstList[i][0]; //start of firstList interval
            int j0 = secondList[j][0]; //start of secondList interval
            int i1 = firstList[i][1]; //end of firstList interval
            int j1= secondList[j][1]; //end of secondList interval

            int start = Math.max(i0, j0);
            int end = Math.min(i1, j1);

            if (start <= end) { //intervals overlap
                res.add(new int[] {start, end});
            }

            if (i1 < j1) { //increment pointer where interval ends first
                i++;
            } else {
                j++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
    
}
