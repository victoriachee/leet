package _HackerRank;

import java.util.Arrays;
import java.util.List;

/**
 * Utility class to check if a square grid of characters can be rearranged alphabetically
 * in both its rows and columns.
 */

public class D4GridChallenge {

    public static String gridChallenge(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();

        // Sort each row alphabetically
        for (int i = 0; i < rows; i++) {
            char[] rowChars = grid.get(i).toCharArray();
            Arrays.sort(rowChars);
            grid.set(i, new String(rowChars));
        }

        // Check if columns are in ascending order
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows - 1; j++) {
                if (grid.get(j).charAt(i) > grid.get(j + 1).charAt(i)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        // Example usage
        List<String> grid1 = Arrays.asList("abc", "ade", "efg");
        String result1 = gridChallenge(grid1);
        System.out.println(result1); // Output: YES

        List<String> grid2 = Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv");
        String result2 = gridChallenge(grid2);
        System.out.println(result2); // Output: YES
    }
}
