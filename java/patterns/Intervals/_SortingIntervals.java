package patterns.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class _SortingIntervals {

    public static void main(String[] args) {
        // Original intervals
        int[][] intervals = {
            {3, 5},
            {1, 2},
            {6, 8},
            {2, 4},
            {5, 7}
        };
        System.out.println("Original Intervals:");
        printIntervals(intervals);


        /** Sort intervals based on the first interval value **/
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        System.out.println("\nSorted by Start Value:");
        printIntervals(intervals);


        /** Sort intervals based on the end value of each interval **/
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        System.out.println("\nSorted by End Value:");
        printIntervals(intervals);


        /** Custom Comparator: Sort by end value and then start value **/
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        System.out.println("\nSorted by End Value and then Start Value:");
        printIntervals(intervals);


        /** Sort intervals in descending order based on the first interval value **/
        Arrays.sort(intervals, (a, b) -> Integer.compare(b[0], a[0]));
        System.out.println("\nSorted in Descending Order by Start Value:");
        printIntervals(intervals);

    }

    private static void printIntervals(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
