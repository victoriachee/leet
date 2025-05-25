// EASY
// #DFS  #Recursion

package algos.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_FindMinDepth {

   /** BFS: 2 ms, beats 87.60% of users with Java **/
   public int minDepthBFS(TreeNode root) {
      return bfs(root, 0);
   }

   public int bfs(TreeNode root, Integer minDepth) {
      if (root == null) return minDepth;
      Queue<TreeNode> levelQueue = new LinkedList<>();
      levelQueue.offer(root);

      while (!levelQueue.isEmpty()) {
         int size = levelQueue.size();
         minDepth++;
         while (0 < size--) {
            TreeNode node = levelQueue.poll();
            if (node.left == null && node.right == null) {
               return minDepth;
            }
            if (node.left != null) levelQueue.offer(node.left);
            if (node.right != null) levelQueue.offer(node.right);
         }
      }
      return minDepth;
   }

   //--------------------------------------------------
   /** DFS: 4 ms, beats 73.71% of users with Java **/
   private int minDepth = Integer.MAX_VALUE; // * Initialize to a large value

   public int minDepthDFS(TreeNode root) {
      if (root != null) dfs(root, 0); // Set current depth to 0
      return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
   }

   public void dfs(TreeNode node, Integer currDepth) {
      currDepth++;

      // *** If is leaf node, set min depth to min of current depth and min depth
      if (node.left == null && node.right == null) {
         minDepth = Math.min(minDepth, currDepth);
      }

      if (node.left != null) dfs(node.left, currDepth);
      if (node.right != null) dfs(node.right, currDepth);
   }

   //--------------------------------------------------
   public static void main(String[] args) {
      BFS_DFS_FindMinDepth solution = new BFS_DFS_FindMinDepth();

      // Example 1
      TreeNode root1 = new TreeNode(
         3,
         new TreeNode(9),
         new TreeNode(20, new TreeNode(15), new TreeNode(7))
      );
      System.out.println("Example 1 BFS: " + solution.minDepthBFS(root1));
      System.out.println("Example 1 DFS: " + solution.minDepthBFS(root1));
      TreePrinter.printTreeArray(root1);
   }
}
