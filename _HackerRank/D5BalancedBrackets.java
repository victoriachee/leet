package _HackerRank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.InputStreamReader;
// import java.util.stream.IntStream;

class BalancedBrackets {

    /**
     * Determines if a given string of brackets is balanced.
     *
     * @param s The string containing brackets.
     * @return "YES" if brackets are balanced, "NO" otherwise.
     */
    public static String isBalanced(String s) {
        char[] brackets = s.toCharArray();
        List<Character> stack = new ArrayList<>();

        // Return "NO" if the string starts with a closing bracket
        if (brackets[0] == ')' || brackets[0] == '}' || brackets[0] == ']') {
            return "NO";
        }

        for (char bracket : brackets) {
            if (bracket != ')' && bracket != '}' && bracket != ']') {
                stack.add(bracket); // Push open brackets onto the stack
            } else if (stack.isEmpty()) {
                return "NO"; // Closing bracket encountered without a corresponding open bracket
            } else {
                char lastBracket = stack.get(stack.size() - 1);
                if (
                    (lastBracket == '(' && bracket != ')') ||
                    (lastBracket == '{' && bracket != '}') ||
                    (lastBracket == '[' && bracket != ']')
                ) {
                    return "NO"; // Mismatched open and close brackets
                } else {
                    // Pop matching open bracket from the stack bottom (start of string)
                    stack.remove(stack.size() - 1);
                }
            }
        }

        return (stack.isEmpty()) ? "YES" : "NO"; // Check if all brackets are matched
    }
}

public class D5BalancedBrackets {

    public static void main(String[] args) throws IOException {
        //     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //     int t = Integer.parseInt(bufferedReader.readLine().trim());

        //     IntStream.range(0, t).forEach(tItr -> {
        //         try {
        //             String s = bufferedReader.readLine();
        //             String result = BalancedBrackets.isBalanced(s);
        //             bufferedWriter.write(result);
        //             bufferedWriter.newLine();
        //         } catch (IOException ex) {
        //             throw new RuntimeException(ex);
        //         }
        //     });

        //     bufferedReader.close();
        //     bufferedWriter.close();

        String s = "{(([])[])[]}";
        String result = BalancedBrackets.isBalanced(s); // YES
        System.out.println(s + " -> " + result);
        s = "{(([])[])[]]}";
        result = BalancedBrackets.isBalanced(s); // NO
        System.out.println(s + " -> " + result);
        s = "{(([])[])[]}[]";
        result = BalancedBrackets.isBalanced(s); // YES
        System.out.println(s + " -> " + result);
    }
}
