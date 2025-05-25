package HashSet;

import java.util.HashSet;

/*
Write a function:

    class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer 
(greater than 0) that does not occur in A.

Examples:
- Given A = [1, 3, 6, 4, 1, 2], the function should return 5.
- Given A = [1, 2, 3], the function should return 4.
- Given A = [-1, -3], the function should return 1.

Assumptions:
- N is an integer within the range [1..100,000]
- Each element of array A is an integer within the range [−1,000,000..1,000,000]

HashSet vs. HashMap:
- HashSet is more space-efficient than HashMap because it only stores keys.
- Using HashSet simplifies the code since it handles only the presence of keys.
- Both offer average O(1) time complexity for insertions and lookups, but HashSet has less overhead.
*/
public class HashSetQuestion {
    public int solution(int[] A) {
        // HashSet to store unique positive integers
        HashSet<Integer> set = new HashSet<>();
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Find the smallest positive integer not in the set
        int smallestNotOccurring = 1;
        while (set.contains(smallestNotOccurring)) {
            smallestNotOccurring++;
        }

        return smallestNotOccurring;
    }

    public static void main(String[] args) {
        HashSetQuestion solution = new HashSetQuestion();

        int[] A1 = {1, 3, 6, 4, 1, 2};
        System.out.println(solution.solution(A1));  // Output: 5

        int[] A2 = {1, 2, 3};
        System.out.println(solution.solution(A2));  // Output: 4

        int[] A3 = {-1, -3};
        System.out.println(solution.solution(A3));  // Output: 1
    }
}

    

