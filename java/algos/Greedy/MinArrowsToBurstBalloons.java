/** 452. Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * !!Medium
 * #Greedy  #Intervals  #Intersect  #Sorting
 * The MinArrowsToBurstBalloons class provides a method to find the minimum number of arrows
 * required to burst a collection of balloons attached to a flat wall.
 */
package algos.Greedy;

import java.util.Arrays;

public class MinArrowsToBurstBalloons {

    /**
     * Finds the minimum number of arrows needed to burst all balloons.
     * {[3,3], [1,4], [3,5], [4,7], [9,10]}
     *   s e    s e    s e    s e    s e
     *          s1<e0  s2<=e0 s3>e0  s4>e3  -> 3 arrows
     *
     * @param points A 2D integer array where points[i] = [xstart, xend] represents a balloon
     *               with a horizontal diameter between xstart and xend.
     * @return The minimum number of arrows required to burst all balloons.
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort the balloons based on their end points
        // (Think: Find intervals that end early, to burst as many balloons as possible)
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); 

        // Iterate through the sorted balloons, starting from the second balloon
        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If curr start is more than prev end point, new arrow needed & end point updated. 
            // If curr start is less than prev end point, balloons intersect, no need new arrow.
            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }
        
        // Return the minimum number of arrows required
        return arrows;
    }

    public static void main(String[] args) {
        // Example usage
        MinArrowsToBurstBalloons solution = new MinArrowsToBurstBalloons();

        int[][] points1 = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        int result1 = solution.findMinArrowShots(points1);
        System.out.println("Output 1: " + result1); // Output: 2

        int[][] points2 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        int result2 = solution.findMinArrowShots(points2);
        System.out.println("Output 2: " + result2); // Output: 4

        int[][] points3 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        int result3 = solution.findMinArrowShots(points3);
        System.out.println("Output 3: " + result3); // Output: 2
    }
}
