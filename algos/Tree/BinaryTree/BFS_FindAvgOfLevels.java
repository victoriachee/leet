// ! EASY
// #BFS  #BinaryTree  #Queue

package algos.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_FindAvgOfLevels {

   public List<Double> averageOfLevels(TreeNode root) {
      ArrayList<Double> res = new ArrayList<>();
      if (root == null) return res;

      Queue<TreeNode> levelQueue = new LinkedList<>();
      levelQueue.offer(root);

      while (!levelQueue.isEmpty()) {
         int numOfLevelNodes = levelQueue.size();
         double sum = 0;

         // Loop through nodes in queue for this level
         for (int i = 0; i < numOfLevelNodes; i++) {
            TreeNode node = levelQueue.poll();
            sum += node.val;

            if (node.left != null) levelQueue.offer(node.left);
            if (node.right != null) levelQueue.offer(node.right);
         }

         double avg = sum / numOfLevelNodes;
         res.add(avg);
      }
      return res;
   }

   public static void main(String[] args) {
      // Test Case 1
      TreeNode root1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, null, null));
      root1.right.left = new TreeNode(15);
      root1.right.right = new TreeNode(7);

      BFS_FindAvgOfLevels solution = new BFS_FindAvgOfLevels();
      List<Double> result1 = solution.averageOfLevels(root1);
      System.out.println("Test Case 1: " + result1); // Expected output: [3.00000, 14.50000, 11.00000]

      // Test Case 2
      TreeNode root2 = new TreeNode(
         3,
         new TreeNode(9),
         new TreeNode(20, new TreeNode(15), new TreeNode(7))
      );
      List<Double> result2 = solution.averageOfLevels(root2);
      System.out.println("Test Case 2: " + result2); // Expected output: [3.00000, 14.50000, 11.00000]
   }
}
