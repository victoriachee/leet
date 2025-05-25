/** 79. Word Search
 * URL: https://leetcode.com/problems/word-search
 * !!Medium
 * #Backtracking  #DFS  #Matrix  
 *
 * Given an m x n grid board and a string word, return true if word exists in the
 * grid.The word can be constructed from letters of sequentially adjacent cells,
 * horizontally or vertically. The same letter cell may not be used more than once.
 *
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * Constraints:
 * m, n: 1 to 6
 * 1 <= word.length <= 15
 * board and word consist only of lowercase and uppercase English letters.
 *
 * Follow up: Could you use search pruning to make your solution faster with a larger
 * board?
 */

/** Important context for backtracking:
 * !Backtracking:
 * When exploring from a cell, the algorithm temporarily marks the cell as visited by
 * changing its value.
 * If the current path doesn’t lead to finding the word, it backtracks by restoring
 * the cell’s original value.
 * This ensures that the same cell can be considered for other possible paths in
 * subsequent recursive calls.
 * The algorithm evaluates whether the current path leads to a solution or meets the
 * conditions specified by the problem.
 * If the current path doesn’t lead to the desired outcome (e.g., finding the word),
 * the algorithm needs to backtrack.
 * !Backtracking involves:
 * Undoing the temporary changes made during the exploration of the current path.
 * Restoring the cell to its original state, allowing the algorithm to explore other
 * possible paths.
 * The found variable is assigned the result of the logical OR (||) of multiple
 * recursive calls.
 * The dfs method returns true if a valid word is found along the path explored by the
 * recursive call and false if the path does not lead to a solution.
 * The logical OR ensures that if any of the recursive calls returns true, the overall
 * found variable becomes true.
 * If found is false, it means that none of the recursive calls found a solution.
 * Regardless of whether the found variable is true or false, the algorithm proceeds
 * to backtracking.
 * !Purpose of backtracking:
 * Undo the changes made during the exploration of the current path.
 * The line board[r][c] = cellCopy; is where this backtracking happens.
 */

package patterns.Backtracking;

public class DFS_DP_WordSearch_DFS_DP {

   public boolean exist(char[][] board, String word) {
      int numOfRows = board.length;
      int numOfCols = board[0].length;
      char[] wordArr = word.toCharArray();
      char firstChar = wordArr[0];

      for (int r = 0; r < numOfRows; r++) {
         for (int c = 0; c < numOfCols; c++) {
            if (board[r][c] == firstChar) {
               if (dfs(board, wordArr, 0, r, c)) return true;
            }
         }
      }
      return false;
   }

   public boolean dfs(char[][] board, char[] word, int i, int r, int c) {
      // Base cases:
      if (i == word.length) return true; // Word matches word array
      if (r < 0 || r >= board.length) return false; // Cell out of bounds
      if (c < 0 || c >= board[0].length) return false; // Cell out of bounds
      if (board[r][c] != word[i]) return false; // Board char == word char

      char cellCopy = board[r][c];
      board[r][c] = '1'; // Mark char as visited in this path

      // Recursively calls dfs, OR returns true if found in any path, false otherwise
      // It goes down one path at a time until returns false -> backtracking starts
      boolean found =
         dfs(board, word, i + 1, r + 1, c) || // Right
         dfs(board, word, i + 1, r, c + 1) || // Down
         dfs(board, word, i + 1, r - 1, c) || // Left
         dfs(board, word, i + 1, r, c - 1); // Up

      // In each recursive call to dfs, it goes down one path at a time.
      // At the end of each path, it backtracks out of the path, cell by cell,
      // restoring the original cell value, regardless of if found or not.
      board[r][c] = cellCopy;

      return found;
   }

   public static void main(String[] args) {
      DFS_DP_WordSearch_DFS_DP wordSearch = new DFS_DP_WordSearch_DFS_DP();

      char[][] board = {
         { 'A', 'B', 'C', 'E' },
         { 'S', 'F', 'C', 'S' },
         { 'A', 'D', 'E', 'E' },
      };

      String word1 = "ABCCED";
      System.out.println("Word " + word1 + " exists: " + wordSearch.exist(board, word1));

      String word2 = "SEE";
      System.out.println("Word " + word2 + " exists: " + wordSearch.exist(board, word2));

      String word3 = "ABCB";
      System.out.println("Word " + word3 + " exists: " + wordSearch.exist(board, word3));
   }
}
