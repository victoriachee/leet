/** Problem 543: Diameter of Binary Tree
 * ! EASY
 * #DFS  #Recursion
 *
 * Given the root of a binary tree, return the length of the diameter,
 * which is the longest path between any two nodes (may or may not pass
 * through the root). Path length between two nodes is represented by the
 * number of edges between them.
 *
 * Example 1: Input: root = [1,2,3,4,5], Output: 3 (Explanation: Length
 * of path [4,2,1,3] or [5,2,1,3]).
 *
 * Example 2: Input: root = [1,2], Output: 1
 *
 * Constraints:
 * Number of tree nodes is in range [1, 104], -100 <= Node.val <= 100
 *
 */

package algos.Tree.BinaryTree;


public class DFS_FindDiameter {

   private int diameter = 0;

   public int diameterOfBinaryTree(TreeNode root) {
      computeHeight(root);
      return diameter;
   }

   private int computeHeight(TreeNode root) {
      if (root == null) return 0; // Base case

      // Goes down left tree recursively until leaf, returns max height bwt. left & right
      // sub-trees at each node (height includes adding 1 to count the current node)
      int left = computeHeight(root.left);
      int right = computeHeight(root.right);

      // Diameter is the maximum height of left & right sub-trees summed together
      diameter = Math.max(left + right, diameter);

      return Math.max(left, right) + 1;
   }

   public static void main(String[] args) {
      // Create a sample binary tree with diameter 5
      TreeNode root = new TreeNode(
         1,
         new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)),
         new TreeNode(3, new TreeNode(6), null)
      );

      // Instantiate the Solution class
      DFS_FindDiameter solution = new DFS_FindDiameter();

      // Calculate the diameter of the binary tree
      int diameter = solution.diameterOfBinaryTree(root);

      // Print the result
      System.out.println("Diameter of the binary tree: " + diameter);
   }
}
