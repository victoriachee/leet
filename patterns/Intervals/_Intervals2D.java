package patterns.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _Intervals2D {

   /**
    * Finds the minimum number of intervals to remove to make the remaining intervals non-overlapping.
    *
    * @param intervals The list of intervals.
    * @return The minimum number of intervals to remove.
    */
   public static int eraseOverlapIntervals(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval[1]));

      int count = 0;
      int end = intervals.get(0)[1];

      for (int i = 1; i < intervals.size(); i++) {
         int[] current = intervals.get(i);

         // If the current interval overlaps with the previous, remove the one with the larger end time
         if (current[0] < end) {
            count++;
         } else {
            end = current[1];
         }
      }

      return count;
   }

   /**
    * Finds the intersection of two lists of intervals.
    *
    * @param list1 The first list of intervals.
    * @param list2 The second list of intervals.
    * @return The list of intersection intervals.
    */
   public static List<int[]> intervalIntersection(List<int[]> list1, List<int[]> list2) {
      List<int[]> result = new ArrayList<>();
      int i = 0, j = 0;

      while (i < list1.size() && j < list2.size()) {
         int[] interval1 = list1.get(i);
         int[] interval2 = list2.get(j);

         // Check for overlap
         if (interval1[1] >= interval2[0] && interval1[0] <= interval2[1]) {
            // Calculate intersection interval
            int start = Math.max(interval1[0], interval2[0]);
            int end = Math.min(interval1[1], interval2[1]);
            result.add(new int[] { start, end });
         }

         // Move pointers based on which interval ends earlier
         if (interval1[1] < interval2[1]) {
            i++;
         } else {
            j++;
         }
      }

      return result;
   }

   /**
    * Finds the union of a list of intervals.
    *
    * @param intervals The list of intervals.
    * @return The list of union intervals.
    */
   public static List<int[]> intervalUnion(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return new ArrayList<>();
      }

      intervals.sort(Comparator.comparingInt(interval -> interval[0]));

      List<int[]> result = new ArrayList<>();
      int[] currentInterval = intervals.get(0);

      for (int i = 1; i < intervals.size(); i++) {
         int[] nextInterval = intervals.get(i);

         // If the intervals overlap, merge them
         if (currentInterval[1] >= nextInterval[0]) {
            currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
         } else {
            result.add(Arrays.copyOf(currentInterval, currentInterval.length));
            currentInterval = Arrays.copyOf(nextInterval, nextInterval.length);
         }
      }

      // Add the last merged or remaining interval
      result.add(Arrays.copyOf(currentInterval, currentInterval.length));

      return result;
   }

   /**
    * Merges overlapping intervals in a list.
    *
    * @param intervals The list of intervals.
    * @return The list of merged intervals.
    */
   public static List<int[]> mergeIntervals(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return new ArrayList<>();
      }

      // Sort intervals based on the start time
      intervals.sort(Comparator.comparingInt(interval -> interval[0]));

      List<int[]> mergedIntervals = new ArrayList<>();
      int[] currentInterval = intervals.get(0);

      for (int i = 1; i < intervals.size(); i++) {
         int[] nextInterval = intervals.get(i);

         // If the intervals overlap, merge them
         if (currentInterval[1] >= nextInterval[0]) {
            currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
         } else {
            mergedIntervals.add(Arrays.copyOf(currentInterval, currentInterval.length));
            currentInterval = Arrays.copyOf(nextInterval, nextInterval.length);
         }
      }

      // Add the last merged or remaining interval
      mergedIntervals.add(Arrays.copyOf(currentInterval, currentInterval.length));

      return mergedIntervals;
   }

   /**
    * Calculates the total length covered by all intervals.
    *
    * @param intervals The list of intervals.
    * @return The total covered length.
    */
   public static int totalCoveredLength(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval[0]));

      int totalLength = 0;
      int end = intervals.get(0)[1];

      for (int i = 1; i < intervals.size(); i++) {
         int[] current = intervals.get(i);

         // If the current interval overlaps with the previous, add the covered length
         if (current[0] <= end) {
            totalLength += Math.min(current[1], end) - current[0];
            end = Math.max(current[1], end);
         } else {
            end = current[1];
         }
      }

      return totalLength;
   }

   /**
    * Inserts a new interval into a list of non-overlapping intervals.
    *
    * @param intervals The list of non-overlapping intervals.
    * @param newInterval The new interval to insert.
    * @return The updated list of non-overlapping intervals.
    */
   public static List<int[]> insertInterval(List<int[]> intervals, int[] newInterval) {
      if (intervals == null || intervals.isEmpty()) {
         return Arrays.asList(newInterval);
      }

      List<int[]> result = new ArrayList<>();
      int i = 0;

      // Add intervals that end before the new interval starts
      while (i < intervals.size() && intervals.get(i)[1] < newInterval[0]) {
         result.add(intervals.get(i));
         i++;
      }

      // Merge overlapping intervals with the new interval
      while (i < intervals.size() && intervals.get(i)[0] <= newInterval[1]) {
         newInterval[0] = Math.min(newInterval[0], intervals.get(i)[0]);
         newInterval[1] = Math.max(newInterval[1], intervals.get(i)[1]);
         i++;
      }

      result.add(newInterval);

      // Add remaining intervals
      while (i < intervals.size()) {
         result.add(intervals.get(i));
         i++;
      }

      return result;
   }

   /**
    * Finds a non-overlapping interval in the list.
    *
    * @param intervals The list of intervals.
    * @return A non-overlapping interval, or null if none is found.
    */
   public static int[] findNonOverlappingInterval(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return null;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval[0]));

      int end = intervals.get(0)[1];

      for (int i = 1; i < intervals.size(); i++) {
         int[] current = intervals.get(i);

         // If the current interval does not overlap with the previous, return it
         if (current[0] > end) {
            return Arrays.copyOf(current, current.length);
         }

         end = Math.max(current[1], end);
      }

      return null;
   }

   /**
    * Counts the maximum number of non-overlapping intervals that can be selected.
    *
    * @param intervals The list of intervals.
    * @return The maximum number of non-overlapping intervals.
    */
   public static int maxNonOverlappingIntervals(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval[1]));

      int count = 1;
      int end = intervals.get(0)[1];

      for (int i = 1; i < intervals.size(); i++) {
         int[] current = intervals.get(i);

         // If the current interval does not overlap with the previous, select it
         if (current[0] > end) {
            count++;
            end = current[1];
         }
      }

      return count;
   }

   /**
    * Determines whether a point is covered by any of the intervals.
    *
    * @param intervals The list of intervals.
    * @param point The point to check for coverage.
    * @return True if the point is covered, false otherwise.
    */
   public static boolean isPointCovered(List<int[]> intervals, int point) {
      if (intervals == null || intervals.isEmpty()) {
         return false;
      }

      for (int[] interval : intervals) {
         if (point >= interval[0] && point <= interval[1]) {
            return true;
         }
      }

      return false;
   }

   /**
    * Finds the minimum number of arrows needed to burst all balloons.
    * Determines the fewest arrows required to intersect with all balloon intervals,
    * by strategically shooting arrows to intersect with multiple balloons.
    *
    * @param intervals The list of balloon intervals.
    * @return The minimum number of arrows needed.
    */
   public static int minArrowsToBurstBalloons(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval[1]));

      int arrows = 1;
      int end = intervals.get(0)[1];

      for (int i = 1; i < intervals.size(); i++) {
         int[] current = intervals.get(i);

         // If the current balloon does not overlap with the previous, use a new arrow
         if (current[0] > end) {
            arrows++;
            end = current[1];
         }
      }

      return arrows;
   }

   /**
    * Finds the largest gap between any two intervals.
    *
    * @param intervals The list of intervals.
    * @return The largest gap between intervals.
    */
   public static int largestGapBetweenIntervals(List<int[]> intervals) {
      if (intervals == null || intervals.size() < 2) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval[0]));

      int largestGap = 0;

      for (int i = 1; i < intervals.size(); i++) {
         int[] prev = intervals.get(i - 1);
         int[] current = intervals.get(i);

         // Calculate the gap between the current interval's start and the previous interval's end
         int gap = current[0] - prev[1];

         // Update the largest gap if the current gap is larger
         largestGap = Math.max(largestGap, gap);
      }

      return largestGap;
   }

   /**
    * Finds the minimum number of meeting rooms required.
    *
    * @param intervals The list of intervals representing meeting start and end times.
    * @return The minimum number of meeting rooms required.
    */
   public static int minMeetingRooms(List<int[]> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      int n = intervals.size();
      int[] startTimes = new int[n];
      int[] endTimes = new int[n];

      for (int i = 0; i < n; i++) {
         startTimes[i] = intervals.get(i)[0];
         endTimes[i] = intervals.get(i)[1];
      }

      Arrays.sort(startTimes);
      Arrays.sort(endTimes);

      int rooms = 0;
      int endIndex = 0;

      for (int i = 0; i < n; i++) {
         if (startTimes[i] < endTimes[endIndex]) {
            // A meeting starts before a previous meeting ends, so a new room is needed
            rooms++;
         } else {
            // A meeting ends, so we can reuse the room
            endIndex++;
         }
      }

      return rooms;
   }

   /**
    * Inserts a new interval into a list of intervals, allowing for overlapping intervals.
    *
    * @param intervals   The list of non-overlapping intervals.
    * @param newInterval The new interval to insert.
    * @return The updated list of intervals.
    */
   public static List<int[]> insertIntervalWithOverlap(List<int[]> intervals, int[] newInterval) {
      List<int[]> result = new ArrayList<>();
      int i = 0;

      // Add intervals that end before the new interval starts
      while (i < intervals.size() && intervals.get(i)[1] < newInterval[0]) {
         result.add(intervals.get(i));
         i++;
      }

      // Merge overlapping intervals with the new interval
      while (i < intervals.size() && intervals.get(i)[0] <= newInterval[1]) {
         newInterval[0] = Math.min(newInterval[0], intervals.get(i)[0]);
         newInterval[1] = Math.max(newInterval[1], intervals.get(i)[1]);
         i++;
      }

      result.add(newInterval);

      // Add remaining intervals
      while (i < intervals.size()) {
         result.add(intervals.get(i));
         i++;
      }

      return result;
   }

   /**
    * Given two lists of intervals (A and B), find the difference between A and B,
    * i.e., intervals present in A but not in B.
    *
    * @param listA The first list of intervals.
    * @param listB The second list of intervals.
    * @return The list of intervals present in A but not in B.
    */
   public static List<int[]> intervalDifference(List<int[]> listA, List<int[]> listB) {
      if (listA == null || listA.isEmpty()) {
         return new ArrayList<>();
      }

      if (listB == null || listB.isEmpty()) {
         return new ArrayList<>(listA);
      }

      List<int[]> result = new ArrayList<>();
      int i = 0, j = 0;

      while (i < listA.size() && j < listB.size()) {
         int[] intervalA = listA.get(i);
         int[] intervalB = listB.get(j);

         // If there is an overlap, skip the overlapping part
         if (intervalA[1] <= intervalB[0]) {
            result.add(intervalA);
            i++;
         } else if (intervalA[0] >= intervalB[1]) {
            j++;
         } else {
            // Split intervalA into non-overlapping parts
            if (intervalA[0] < intervalB[0]) {
               result.add(new int[] { intervalA[0], intervalB[0] });
            }
            i++;
         }
      }

      while (i < listA.size()) {
         result.add(listA.get(i));
         i++;
      }

      return result;
   }

   public static void main(String[] args) {
        // Test insertIntervalWithOverlap
        List<int[]> intervals1 = Arrays.asList(new int[]{1, 3}, new int[]{6, 9});
        int[] newInterval1 = new int[]{2, 5};
        List<int[]> result1 = insertIntervalWithOverlap(intervals1, newInterval1);
        System.out.println("Insert Interval with Overlap: " + result1);

        // Test intervalDifference
        List<int[]> listA = Arrays.asList(new int[]{1, 3}, new int[]{6, 9});
        List<int[]> listB = Arrays.asList(new int[]{2, 5});
        List<int[]> result2 = intervalDifference(listA, listB);
        System.out.println("Interval Difference: " + result2);

        // Test eraseOverlapIntervals
        List<int[]> intervals3 = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 3});
        int result3 = eraseOverlapIntervals(intervals3);
        System.out.println("Erase Overlap Intervals: " + result3);

        // Test intervalIntersection
        List<int[]> list1 = Arrays.asList(new int[]{0, 2}, new int[]{5, 10}, new int[]{13, 23}, new int[]{24, 25});
        List<int[]> list2 = Arrays.asList(new int[]{1, 5}, new int[]{8, 12}, new int[]{15, 24}, new int[]{25, 26});
        List<int[]> result4 = intervalIntersection(list1, list2);
        System.out.println("Interval Intersection: " + result4);

        // Test intervalUnion
        List<int[]> intervals5 = Arrays.asList(new int[]{1, 3}, new int[]{2, 4}, new int[]{5, 7}, new int[]{6, 8});
        List<int[]> result5 = intervalUnion(intervals5);
        System.out.println("Interval Union: " + result5);

        // Test mergeIntervals
        List<int[]> intervals6 = Arrays.asList(new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18});
        List<int[]> result6 = mergeIntervals(intervals6);
        System.out.println("Merge Intervals: " + result6);

        // Test totalCoveredLength
        List<int[]> intervals7 = Arrays.asList(new int[]{1, 3}, new int[]{2, 4}, new int[]{5, 7}, new int[]{6, 8});
        int result7 = totalCoveredLength(intervals7);
        System.out.println("Total Covered Length: " + result7);

        // Test insertInterval
        List<int[]> intervals8 = Arrays.asList(new int[]{1, 3}, new int[]{6, 9});
        int[] newInterval8 = new int[]{2, 5};
        List<int[]> result8 = insertInterval(intervals8, newInterval8);
        System.out.println("Insert Interval: " + result8);

        // Test findNonOverlappingInterval
        List<int[]> intervals9 = Arrays.asList(new int[]{1, 3}, new int[]{4, 6}, new int[]{8, 10});
        int[] result9 = findNonOverlappingInterval(intervals9);
        System.out.println("Non-overlapping Interval: " + Arrays.toString(result9));

        // Test maxNonOverlappingIntervals
        List<int[]> intervals10 = Arrays.asList(new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}, new int[]{1, 3});
        int result10 = maxNonOverlappingIntervals(intervals10);
        System.out.println("Max Non-overlapping Intervals: " + result10);

        // Test isPointCovered
        List<int[]> intervals11 = Arrays.asList(new int[]{1, 3}, new int[]{4, 6}, new int[]{8, 10});
        boolean result11 = isPointCovered(intervals11, 5);
        System.out.println("Is Point Covered: " + result11);

        // Test minArrowsToBurstBalloons
        List<int[]> intervals12 = Arrays.asList(new int[]{10, 16}, new int[]{2, 8}, new int[]{1, 6}, new int[]{7, 12});
        int result12 = minArrowsToBurstBalloons(intervals12);
        System.out.println("Min Arrows to Burst Balloons: " + result12);

        // Test largestGapBetweenIntervals
        List<int[]> intervals13 = Arrays.asList(new int[]{1, 3}, new int[]{6, 9}, new int[]{12, 15});
        int result13 = largestGapBetweenIntervals(intervals13);
        System.out.println("Largest Gap Between Intervals: " + result13);

        // Test minMeetingRooms
        List<int[]> intervals14 = Arrays.asList(new int[]{0, 30}, new int[]{5, 10}, new int[]{15, 20});
        int result14 = minMeetingRooms(intervals14);
        System.out.println("Min Meeting Rooms: " + result14);

        
        // Test 1: Insert overlapping interval in the middle
        List<int[]> intervals15 = Arrays.asList(new int[]{1, 3}, new int[]{6, 9});
        int[] newInterval15 = new int[]{2, 5};
        List<int[]> result15 = insertIntervalWithOverlap(intervals15, newInterval15);
        System.out.println("Test 1: " + result15);  // Output: [[1, 5], [6, 9]]

        // Example usage
        List<int[]> intervalsA = List.of(new int[] { 1, 3 }, new int[] { 6, 9 });
        List<int[]> intervalsB = List.of(new int[] { 2, 5 });

        List<int[]> result = intervalDifference(intervalsA, intervalsB);
        System.out.println("Intervals in A but not in B: " + result);
   }
}
