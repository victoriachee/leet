package _TechnicalTests.Rakuten;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.HashMap;

class Solution {
    public static int solution(int D, String S) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);

        return map.get(S) * D;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(solution(3, "two"));   // Output should be 6
        System.out.println(solution(5, "four"));  // Output should be 20
        System.out.println(solution(2, "five"));  // Output should be 10
        System.out.println(solution(4, "one"));   // Output should be 4
        // Edge case: Invalid input
        System.out.println(solution(2, "six"));   // Output should be 0 or you can handle invalid input differently
    }
    
}
