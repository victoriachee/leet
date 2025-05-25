package _TechnicalTests.IBM;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);       // Max consecutive count: 5
        List<Integer> numbers2 = Arrays.asList(4, 2, 1, 5, 3, 8, 7); // Max consecutive count: 5
        List<Integer> numbers3 = Arrays.asList(1, 2, 4, 5);          // Max consecutive count: 2

        System.out.println("Max consecutive count + 1 for numbers 1: " + getMaxHeightOrWidth(numbers1));
        System.out.println("Max consecutive count + 1 for numbers 2: " + getMaxHeightOrWidth(numbers2));
        System.out.println("Max consecutive count + 1  for numbers 3: " + getMaxHeightOrWidth(numbers3));
    
        int n = 1000;
        int m = 1000;
        List<Integer> horizontalBars = new ArrayList<>(List.of(1000, 1002, 1001, 1, 2, 3, 4, 5, 100, 101));
        List<Integer> verticalBars = new ArrayList<>(List.of(4, 2, 1, 5, 3, 8, 7));

        long result = sewers(n, m, horizontalBars, verticalBars);
        System.out.println("Maximum Area: " + result);
    }

    /**
     * Calculates the maximum area given the dimensions and lists of horizontal and vertical bars.
     *
     * @param n The number of horizontal bars at the start.
     * @param m The number of vertical bars at the start.
     * @param h The list of horizontal bars to remove.
     * @param v The list of vertical bars to remove.
     * @return The maximum area of the hole.
     */
    public static long sewers(int n, int m, List<Integer> h, List<Integer> v) {
      Collections.sort(h); // Sort so that id of the horizontal bars removed are in order
      Collections.sort(v);
      long maxWidth = getMaxHeightOrWidth(h);
      long maxHeight = getMaxHeightOrWidth(v);
      
      return maxWidth * maxHeight;
    }
    
    
   /**
     * Finds the maximum consecutive count of numbers + 1, which would be the maximum
     * height (given arr of vertical bars) or width (given arr of horizontal bars).
     *
     *    1 2 3 4 
     * 1|_|_|_|_|_|
     * 2|_|_|_|_|_|
     * 3|_|_|_|_|_|
     * 4|_|_|_|_|_|
     *  | | | | | |
     *
     *    1 2 3 4
     * 1|___|_|___|
     * 2|___|_|___|
     * 3|   | |   |
     * 4|   | |   |
     *  |   | |   |
     *
     * Max width of hole  = max consecutive vertical bars removed  + 1
     * Max height of hole = max consecutive horizonal bars removed + 1
     * Max area of hole   = max width * max height
     *
     * @param arr The list of integers
     * @return The maximum consecutive count + 1
     */
    public static long getMaxHeightOrWidth(List<Integer> arr) {
        long max = 1; // Min consecutive count will be 1, assuming arr is not empty
        long currConsec = 1;

        for (int i = 1; i < arr.size(); i++) {
            
            if (arr.get(i) == arr.get(i - 1) + 1) currConsec++; // Curr & prev are consecutive
            else currConsec = 1; // Reset consecutive count

            // Update max consecutive count
            max = Math.max(max, currConsec);
        }

        return (long) max + 1;
    }

}
