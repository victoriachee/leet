package _TechnicalTests.Rakuten;

public class Q2 {
    public static int solution(int[] A) {
        final int n = A.length;
        if (n <= 1) return 0;

        // Check if the array already satisfies the alternating pattern
        boolean alternating = true;
        for (int i = 1; i < n; i++) {
            if ((i % 2 == 0 && A[i] <= A[i - 1]) || (i % 2 != 0 && A[i] >= A[i - 1])) {
                alternating = false;
                break;
            }
        }

        if (alternating) return 0; // Already alternating, no adjustments needed

        int countLowHigh = 0; // low-high pattern - check for odd indices
        int countHighLow = 0; // high-low pattern - check for even indices

        // Iterate from second tree
        for (int i = 1; i < n - 1; i++) {
            if (i % 2 == 1) { // low-high 
                if (A[i] <= A[i - 1] || A[i] <= A[i + 1]) {
                    countLowHigh++;
                }
            }
            else if (A[i] >= A[i - 1] || A[i] >= A[i + 1]) { // high-low
                countHighLow++;
            }
        }

        // Check last two trees for both patterns
        if (n % 2 == 1) {
            if (A[n - 1] <= A[n - 2]) {
                countLowHigh++;
            }
        } else if (A[n - 1] >= A[n - 2]) {
            countHighLow++;
        }

        // Return min reductions needed
        return Math.min(countLowHigh, countHighLow);
    }
    
    public static void main(String[] args) {
        int[] heights0 = {4, 7, 5, 7, 4, 9};
        int[] heights1 = {8, 4, 7, 5, 7, 4, 9};
        int[] heights2 = {5, 4, 6, 3, 7};
        int[] heights3 = {3, 7, 4, 5};
        int[] heights4 = {5, 4, 3, 2, 6};

        System.out.println(solution(heights0)); // Output: 0
        System.out.println(solution(heights1)); // Output: 0
        System.out.println(solution(heights2)); // Output: 0
        System.out.println(solution(heights3)); // Output: 0
        System.out.println(solution(heights4)); // Output: 1
    }
}
