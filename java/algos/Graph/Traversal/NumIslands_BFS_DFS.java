package algos.Graph.Traversal;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands_BFS_DFS {

   public int numIslands(char[][] arr) {
      int numIslands = 0;
      int rows = arr.length;
      int cols = arr[0].length;
      
      for (int r = 0; r < rows; r++) {
         for (int c = 0; c < cols; c++) {
            if (arr[r][c] == '1') {
               numIslands++;
               bfs(arr, r, c);  // Change this
            }
         }
      }
      return numIslands;
   }

   /** BFS **/
   // TC: O(rows * cols) -> Each cell is visited once, where constant work is done
   // SC: O(min(rows, cols)) -> Max number of elements in the queue is bounded by the min of the number of rows & cols
   static void bfs(char arr[][], int r, int c) {
      int numRows = arr.length;
      int numCols = arr[0].length;

      Queue<int[]> rcPairQueue = new LinkedList<>();
      rcPairQueue.offer(new int[] { r, c });

      while (!rcPairQueue.isEmpty()) {
         int[] rc = rcPairQueue.poll();
         int row = rc[0];
         int col = rc[1];

         if (arr[row][col] == '0') continue; // Break one iteration in loop

         arr[row][col] = '0'; // Set current value to zero

         if (col + 1 < numCols) rcPairQueue.offer(new int[] { row, col + 1 }); // Right
         if (row + 1 < numRows) rcPairQueue.offer(new int[] { row + 1, col }); // Down
         // Require Up and Left because matrix is "surrounded by water"
         if (col - 1 >= 0) rcPairQueue.offer(new int[] { row, col - 1 });
         if (row - 1 >= 0) rcPairQueue.offer(new int[] { row - 1, col });
      }
   }

   /** DFS **/
   // TC: O(rows * cols) -> Each cell is visited once, where constant work is done
   // SC: O(max(rows, cols)) -> Max depth of recursion is determined by the max of the number of rows & cols
   static void dfs(char arr[][], int r, int c) {
      int rows = arr.length;
      int cols = arr[0].length;

      if (r < 0 || r >= rows) return;
      if (c < 0 || c >= cols) return;
      if (arr[r][c] == '0') return;

      arr[r][c] = '0';

      // Clockwise search
      dfs(arr, r, c + 1); // Right
      dfs(arr, r - 1, c); // Down
      dfs(arr, r, c - 1); // Left
      dfs(arr, r + 1, c); // Up
   }

   public static void main(String[] args) {
      // Example usage of NumIslandsDFS
      char[][] grid = {
         { '1', '1', '0', '0', '0' },
         { '1', '1', '0', '0', '0' },
         { '0', '0', '1', '0', '0' },
         { '0', '0', '0', '1', '1' },
      };

      NumIslands_BFS_DFS sol = new NumIslands_BFS_DFS();
      int result = sol.numIslands(grid);

      System.out.println("BFS: Number of Islands: " + result);
   }
}
