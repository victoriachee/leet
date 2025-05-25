package patterns.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class _BacktrackingExamples {

   /**
    * Example 1: Generate all subsets of a set.
    *
    * @param nums The input set.
    * @return List of all subsets.
    */
   public static List<List<Integer>> subsets(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      backtrackSubsets(nums, 0, new ArrayList<>(), result);
      return result;
   }

   private static void backtrackSubsets(
      int[] nums,
      int start,
      List<Integer> current,
      List<List<Integer>> result
   ) {
      result.add(new ArrayList<>(current)); // Include the current subset
      for (int i = start; i < nums.length; i++) {
         current.add(nums[i]); // Include the current element
         backtrackSubsets(nums, i + 1, current, result); // Explore with the current element
         current.remove(current.size() - 1); // Backtrack (remove the last element)
      }
   }

   // -------------------------------------------------
   /**
    * Example 2: Solve the N-Queens problem to find all solutions for placing
    * N queens on an NxN chessboard.
    *
    * @param n The size of the chessboard.
    * @return List of solutions for placing N queens.
    */
   public static List<List<String>> solveNQueens(int n) {
      List<List<String>> result = new ArrayList<>();
      char[][] board = new char[n][n];
      for (char[] row : board) {
         java.util.Arrays.fill(row, '.');
      }
      backtrackNQueens(board, 0, result);
      return result;
   }

   private static void backtrackNQueens(char[][] board, int row, List<List<String>> result) {
      if (row == board.length) {
         result.add(buildSolution(board));
         return;
      }

      for (int col = 0; col < board.length; col++) {
         if (isValidPlacement(board, row, col)) {
            board[row][col] = 'Q'; // Choose: Place the queen
            backtrackNQueens(board, row + 1, result); // Explore with the queen
            board[row][col] = '.'; // Backtrack: Unchoose (remove the queen)
         }
      }
   }

   /**
    * Validates if placing a queen at a given position is valid in N-Queens.
    *
    * @param board The chessboard.
    * @param row   The current row.
    * @param col   The current column.
    * @return True if the placement is valid, false otherwise.
    */
   private static boolean isValidPlacement(char[][] board, int row, int col) {
      // Check if no queen is in the same column
      for (int i = 0; i < row; i++) {
         if (board[i][col] == 'Q') {
            return false;
         }
      }
      // Check if no queen is in the same diagonal (left-upper to right-lower)
      for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
         if (board[i][j] == 'Q') {
            return false;
         }
      }
      // Check if no queen is in the same diagonal (right-upper to left-lower)
      for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
         if (board[i][j] == 'Q') {
            return false;
         }
      }
      return true;
   }

   /**
    * Constructs a solution representation for N-Queens.
    *
    * @param board The chessboard.
    * @return List of strings representing a solution.
    */
   private static List<String> buildSolution(char[][] board) {
      List<String> solution = new ArrayList<>();
      for (char[] row : board) {
         solution.add(new String(row));
      }
      return solution;
   }

   // -------------------------------------------------
   /**
    * Example 3: Generate all permutations of an array.
    *
    * @param nums The input array.
    * @return List of all permutations.
    */
   public static List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      backtrackPermute(nums, new ArrayList<>(), new boolean[nums.length], result);
      return result;
   }

   /**
    * Backtracking helper function for generating permutations.
    *
    * @param nums    The input array.
    * @param current Current permutation being formed.
    * @param used    Boolean array to track used elements.
    * @param result  List to store permutations.
    */
   private static void backtrackPermute(
      int[] nums,
      List<Integer> current,
      boolean[] used,
      List<List<Integer>> result
   ) {
      if (current.size() == nums.length) {
         result.add(new ArrayList<>(current));
         return;
      }

      for (int i = 0; i < nums.length; i++) {
         if (!used[i]) {
            current.add(nums[i]); // Choose
            used[i] = true; // Mark as used
            backtrackPermute(nums, current, used, result); // Explore
            used[i] = false; // Backtrack: Unmark
            current.remove(current.size() - 1); // Backtrack: Remove the last element
         }
      }
   }

   // -------------------------------------------------
   /**
    * Example 4: Combination Sum.
    *
    * @param candidates The input array of candidates.
    * @param target     The target sum to achieve.
    * @return List of all combinations that sum to the target.
    */
   public static List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> result = new ArrayList<>();
      backtrackCombinationSum(candidates, target, 0, new ArrayList<>(), result);
      return result;
   }

   /**
    * Backtracking helper function for combination sum.
    *
    * @param candidates The input array of candidates.
    * @param target     The remaining target sum.
    * @param start      The starting index for candidates.
    * @param current    Current combination being formed.
    * @param result     List to store combinations.
    */
   private static void backtrackCombinationSum(
      int[] candidates,
      int target,
      int start,
      List<Integer> current,
      List<List<Integer>> result
   ) {
      if (target < 0) {
         return;
      }
      if (target == 0) {
         result.add(new ArrayList<>(current));
         return;
      }

      for (int i = start; i < candidates.length; i++) {
         current.add(candidates[i]); // Choose
         backtrackCombinationSum(candidates, target - candidates[i], i, current, result); // Explore
         current.remove(current.size() - 1); // Backtrack: Remove the last element
      }
   }

   // -------------------------------------------------
   /**
    * Example 5: Generate Parentheses.
    *
    * @param n The number of pairs of parentheses.
    * @return List of valid parentheses combinations.
    */
   public static List<String> generateParenthesis(int n) {
      List<String> result = new ArrayList<>();
      backtrackGenerateParenthesis(result, "", 0, 0, n);
      return result;
   }

   /**
    * Backtracking helper function for Generate Parentheses.
    *
    * @param result List to store valid combinations.
    * @param current Current combination.
    * @param open    Count of open parentheses.
    * @param close   Count of close parentheses.
    * @param n       The number of pairs of parentheses.
    */
   private static void backtrackGenerateParenthesis(
      List<String> result,
      String current,
      int open,
      int close,
      int n
   ) {
      if (current.length() == 2 * n) {
         result.add(current); // Add the combination to the result list if valid.
         return;
      }

      if (open < n) {
         // Add an open parenthesis if the limit is not reached, if the count is less than n.
         backtrackGenerateParenthesis(result, current + "(", open + 1, close, n);
      }

      if (close < open) {
         // Add a close parenthesis only if there are open parentheses to match, count is less than open parenthesis count.
         backtrackGenerateParenthesis(result, current + ")", open, close + 1, n);
      }
   }

   // -------------------------------------------------
   /**
    * Example 6: Letter Combinations of a Phone Number.
    *
     * @param digits The input digits (2-9) representing a phone number.
     * @return List of all possible letter combinations that the number could represent.
     */
   public static List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if (digits.length() == 0) {
         return result;
      }
      String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
      backtrackLetterCombinations(result, digits, "", mapping, 0);
      return result;
   }

   /**
    * Backtracking helper function for Letter Combinations of a Phone Number.
    *https://www.hackerrank.com/challenges/one-week-preparation-kit-balanced-brackets/forum
    * @param result   List to store combinations.
    * @param digits   The input digit string.
    * @param current  Current combination.
    * @param mapping  Mapping of digits to letters.
    * @param position Current position in the digit string.
    */
   private static void backtrackLetterCombinations(
      List<String> result,
      String digits,
      String current,
      String[] mapping,
      int position
   ) {
      if (position == digits.length()) {
        // Add the current combination to the result when we reach the end of the digits.
         result.add(current); 
         return;
      }

      String letters = mapping[digits.charAt(position) - '0'];
      for (char letter : letters.toCharArray()) {
         // Explore all possible combinations for the current digit by appending each letter.
         backtrackLetterCombinations(result, digits, current + letter, mapping, position + 1);
      }
   }

   public static void main(String[] args) {
      // Example 1: Subsets
      int[] nums = { 1, 2, 3 };
      List<List<Integer>> subsetsResult = subsets(nums);
      System.out.println("Subsets: " + subsetsResult);

      // Example 2: N-Queens
      int nQueensSize = 4;
      List<List<String>> nQueensResult = solveNQueens(nQueensSize);
      System.out.println("N-Queens Solutions: " + nQueensResult);

      // Example 3: Permutations
      int[] permuteArray = { 1, 2, 3 };
      List<List<Integer>> permuteResult = permute(permuteArray);
      System.out.println("Permutations: " + permuteResult);

      // Example 4: Combination Sum
      int[] combinationSumArray = { 2, 3, 6, 7 };
      int targetSum = 7;
      List<List<Integer>> combinationSumResult = combinationSum(combinationSumArray, targetSum);
      System.out.println("Combination Sum: " + combinationSumResult);

      // Example 5: Generate Parentheses
      int nParentheses = 3;
      List<String> generateParenthesisResult = generateParenthesis(nParentheses);
      System.out.println("Generate Parentheses: " + generateParenthesisResult);

      // Example 6: Letter Combinations of a Phone Number
      String phoneNumber = "23";
      List<String> letterCombinationsResult = letterCombinations(phoneNumber);
      System.out.println("Letter Combinations: " + letterCombinationsResult);
   }
}
