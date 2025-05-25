/**
 * The _Intervals class provides functions to solve generic interval questions.
 */

package patterns.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _Intervals {

   /**
    * Represents an interval with a start and end time.
    */
   static class Interval {

      int start;
      int end;

      Interval(int start, int end) {
         this.start = start;
         this.end = end;
      }

      @Override
      public String toString() {
         return "[" + start + ", " + end + "]";
      }
   }

   /**
    * Finds the minimum number of intervals to remove to make the remaining intervals non-overlapping.
    *
    * @param intervals The list of intervals.
    * @return The minimum number of intervals to remove.
    */
   public static int eraseOverlapIntervals(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval.end));

      int count = 0;
      int end = intervals.get(0).end;

      for (int i = 1; i < intervals.size(); i++) {
         Interval current = intervals.get(i);

         // If the current interval overlaps with the previous, remove the one with the larger end time
         if (current.start < end) {
            count++;
         } else {
            end = current.end;
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
   public static List<Interval> intervalIntersection(List<Interval> list1, List<Interval> list2) {
      List<Interval> result = new ArrayList<>();
      int i = 0, j = 0;

      while (i < list1.size() && j < list2.size()) {
         Interval interval1 = list1.get(i);
         Interval interval2 = list2.get(j);

         // Check for overlap
         if (interval1.end >= interval2.start && interval1.start <= interval2.end) {
            // Calculate intersection interval
            int start = Math.max(interval1.start, interval2.start);
            int end = Math.min(interval1.end, interval2.end);
            result.add(new Interval(start, end));
         }

         // Move pointers based on which interval ends earlier
         if (interval1.end < interval2.end) {
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
   public static List<Interval> intervalUnion(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return new ArrayList<>();
      }

      intervals.sort(Comparator.comparingInt(interval -> interval.start));

      List<Interval> result = new ArrayList<>();
      Interval currentInterval = intervals.get(0);

      for (int i = 1; i < intervals.size(); i++) {
         Interval nextInterval = intervals.get(i);

         // If the intervals overlap, merge them
         if (currentInterval.end >= nextInterval.start) {
            currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
         } else {
            result.add(currentInterval);
            currentInterval = nextInterval;
         }
      }

      // Add the last merged or remaining interval
      result.add(currentInterval);

      return result;
   }

   /**
    * Merges overlapping intervals in a list.
    *
    * @param intervals The list of intervals.
    * @return The list of merged intervals.
    */
   public static List<Interval> mergeIntervals(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return new ArrayList<>();
      }

      // Sort intervals based on the start time
      intervals.sort(Comparator.comparingInt(interval -> interval.start));

      List<Interval> mergedIntervals = new ArrayList<>();
      Interval currentInterval = intervals.get(0);

      for (int i = 1; i < intervals.size(); i++) {
         Interval nextInterval = intervals.get(i);

         // If the intervals overlap, merge them
         if (currentInterval.end >= nextInterval.start) {
            currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
         } else {
            mergedIntervals.add(currentInterval);
            currentInterval = nextInterval;
         }
      }

      // Add the last merged or remaining interval
      mergedIntervals.add(currentInterval);

      return mergedIntervals;
   }

   /**
    * Calculates the total length covered by all intervals.
    *
    * @param intervals The list of intervals.
    * @return The total covered length.
    */
   public static int totalCoveredLength(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval.start));

      int totalLength = 0;
      int end = intervals.get(0).end;

      for (int i = 1; i < intervals.size(); i++) {
         Interval current = intervals.get(i);

         // If the current interval overlaps with the previous, add the covered length
         if (current.start <= end) {
            totalLength += Math.min(current.end, end) - current.start;
            end = Math.max(current.end, end);
         } else {
            end = current.end;
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
   public static List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {
      if (intervals == null || intervals.isEmpty()) {
         return Arrays.asList(newInterval);
      }

      List<Interval> result = new ArrayList<>();
      int i = 0;

      // Add intervals that end before the new interval starts
      while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
         result.add(intervals.get(i));
         i++;
      }

      // Merge overlapping intervals with the new interval
      while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
         newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
         newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
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
   public static Interval findNonOverlappingInterval(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return null;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval.start));

      int end = intervals.get(0).end;

      for (int i = 1; i < intervals.size(); i++) {
         Interval current = intervals.get(i);

         // If the current interval does not overlap with the previous, return it
         if (current.start > end) {
            return current;
         }

         end = Math.max(current.end, end);
      }

      return null;
   }

   /**
    * Finds the maximum number of non-overlapping intervals that can be selected.
    *
    * @param intervals The list of intervals.
    * @return The maximum number of non-overlapping intervals.
    */
   public static int maxNonOverlappingIntervals(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval.end));

      int count = 1;
      int end = intervals.get(0).end;

      for (int i = 1; i < intervals.size(); i++) {
         Interval current = intervals.get(i);

         // If the current interval does not overlap with the previous, select it
         if (current.start > end) {
            count++;
            end = current.end;
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
   public static boolean isPointCovered(List<Interval> intervals, int point) {
      if (intervals == null || intervals.isEmpty()) {
         return false;
      }

      for (Interval interval : intervals) {
         if (point >= interval.start && point <= interval.end) {
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
   public static int minArrowsToBurstBalloons(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval.end));

      int arrows = 1;
      int end = intervals.get(0).end;

      for (int i = 1; i < intervals.size(); i++) {
         Interval current = intervals.get(i);

         // If the current balloon does not overlap with the previous, use a new arrow
         if (current.start > end) {
            arrows++;
            end = current.end;
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
   public static int largestGapBetweenIntervals(List<Interval> intervals) {
      if (intervals == null || intervals.size() < 2) {
         return 0;
      }

      intervals.sort(Comparator.comparingInt(interval -> interval.start));

      int largestGap = 0;

      for (int i = 1; i < intervals.size(); i++) {
         Interval prev = intervals.get(i - 1);
         Interval current = intervals.get(i);

         // Calculate the gap between the current interval's start and the previous interval's end
         int gap = current.start - prev.end;

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
   public static int minMeetingRooms(List<Interval> intervals) {
      if (intervals == null || intervals.isEmpty()) {
         return 0;
      }

      int n = intervals.size();
      int[] startTimes = new int[n];
      int[] endTimes = new int[n];

      for (int i = 0; i < n; i++) {
         startTimes[i] = intervals.get(i).start;
         endTimes[i] = intervals.get(i).end;
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
    * @param intervals The list of non-overlapping intervals.
    * @param newInterval The new interval to insert.
    * @return The updated list of intervals.
    */
   public static List<Interval> insertIntervalWithOverlap(
      List<Interval> intervals,
      Interval newInterval
   ) {
      List<Interval> result = new ArrayList<>();
      int i = 0;

      // Add intervals that end before the new interval starts
      while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
         result.add(intervals.get(i));
         i++;
      }

      // Merge overlapping intervals with the new interval
      while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
         newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
         newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
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
    public static List<Interval> intervalDifference(List<Interval> listA, List<Interval> listB) {
        if (listA == null || listA.isEmpty()) {
            return new ArrayList<>();
        }

        if (listB == null || listB.isEmpty()) {
            return new ArrayList<>(listA);
        }

        List<Interval> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < listA.size() && j < listB.size()) {
            Interval intervalA = listA.get(i);
            Interval intervalB = listB.get(j);

            // If there is an overlap, skip the overlapping part
            if (intervalA.end <= intervalB.start) {
                result.add(intervalA);
                i++;
            } else if (intervalA.start >= intervalB.end) {
                j++;
            } else {
                // Split intervalA into non-overlapping parts
                if (intervalA.start < intervalB.start) {
                    result.add(new Interval(intervalA.start, intervalB.start));
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

   /**
    * Main method for testing the IntervalSolver class.
    *
    * @param args Command-line arguments (not used).
    */
   public static void main(String[] args) {
        // Example intervals: [1, 3], [2, 6], [8, 10], [15, 18]
        List<Interval> intervals = Arrays.asList(
            new Interval(1, 3),
            new Interval(2, 6),
            new Interval(8, 10),
            new Interval(15, 18)
        );

        // Merge overlapping intervals
        List<Interval> mergedIntervals = mergeIntervals(intervals);

        // Print the merged intervals
        System.out.println("Merged Intervals: " + mergedIntervals);

      
        // Test insertIntervalWithOverlap
        List<Interval> intervals1 = Arrays.asList(new Interval(1, 3), new Interval(6, 9));
        Interval newInterval1 = new Interval(2, 5);
        List<Interval> result1 = insertIntervalWithOverlap(intervals1, newInterval1);
        System.out.println("Insert Interval with Overlap: " + result1);

        // Test intervalDifference
        List<Interval> listA = Arrays.asList(new Interval(1, 3), new Interval(6, 9));
        List<Interval> listB = Arrays.asList(new Interval(2, 5));
        List<Interval> result2 = intervalDifference(listA, listB);
        System.out.println("Interval Difference: " + result2);

        // Test eraseOverlapIntervals
        List<Interval> intervals3 = Arrays.asList(new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3));
        int result3 = eraseOverlapIntervals(intervals3);
        System.out.println("Erase Overlap Intervals: " + result3);

        // Test intervalIntersection
        List<Interval> list1 = Arrays.asList(new Interval(0, 2), new Interval(5, 10), new Interval(13, 23), new Interval(24, 25));
        List<Interval> list2 = Arrays.asList(new Interval(1, 5), new Interval(8, 12), new Interval(15, 24), new Interval(25, 26));
        List<Interval> result4 = intervalIntersection(list1, list2);
        System.out.println("Interval Intersection: " + result4);

        // Test intervalUnion
        List<Interval> intervals5 = Arrays.asList(new Interval(1, 3), new Interval(2, 4), new Interval(5, 7), new Interval(6, 8));
        List<Interval> result5 = intervalUnion(intervals5);
        System.out.println("Interval Union: " + result5);

        // Test mergeIntervals
        List<Interval> intervals6 = Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8, 10), new Interval(15, 18));
        List<Interval> result6 = mergeIntervals(intervals6);
        System.out.println("Merge Intervals: " + result6);

        // Test totalCoveredLength
        List<Interval> intervals7 = Arrays.asList(new Interval(1, 3), new Interval(2, 4), new Interval(5, 7), new Interval(6, 8));
        int result7 = totalCoveredLength(intervals7);
        System.out.println("Total Covered Length: " + result7);

        // Test insertInterval
        List<Interval> intervals8 = Arrays.asList(new Interval(1, 3), new Interval(6, 9));
        Interval newInterval8 = new Interval(2, 5);
        List<Interval> result8 = insertInterval(intervals8, newInterval8);
        System.out.println("Insert Interval: " + result8);

        // Test findNonOverlappingInterval
        List<Interval> intervals9 = Arrays.asList(new Interval(1, 3), new Interval(4, 6), new Interval(8, 10));
        Interval result9 = findNonOverlappingInterval(intervals9);
        System.out.println("Non-overlapping Interval: " + result9);

        // Test maxNonOverlappingIntervals
        List<Interval> intervals10 = Arrays.asList(new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3));
        int result10 = maxNonOverlappingIntervals(intervals10);
        System.out.println("Max Non-overlapping Intervals: " + result10);

        // Test isPointCovered
        List<Interval> intervals11 = Arrays.asList(new Interval(1, 3), new Interval(4, 6), new Interval(8, 10));
        boolean result11 = isPointCovered(intervals11, 5);
        System.out.println("Is Point Covered: " + result11);

        // Test minArrowsToBurstBalloons
        List<Interval> intervals12 = Arrays.asList(new Interval(10, 16), new Interval(2, 8), new Interval(1, 6), new Interval(7, 12));
        int result12 = minArrowsToBurstBalloons(intervals12);
        System.out.println("Min Arrows to Burst Balloons: " + result12);

        // Test largestGapBetweenIntervals
        List<Interval> intervals13 = Arrays.asList(new Interval(1, 3), new Interval(6, 9), new Interval(12, 15));
        int result13 = largestGapBetweenIntervals(intervals13);
        System.out.println("Largest Gap Between Intervals: " + result13);

        // Test minMeetingRooms
        List<Interval> intervals14 = Arrays.asList(new Interval(0, 30), new Interval(5, 10), new Interval(15, 20));
        int result14 = minMeetingRooms(intervals14);
        System.out.println("Min Meeting Rooms: " + result14);
    }
   
}
