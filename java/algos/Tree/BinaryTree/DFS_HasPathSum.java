// ! EASY
// #DFS  #BinaryTree  #Minus

package algos.Tree.BinaryTree;

public class DFS_HasPathSum {

   public boolean hasPathSum(TreeNode root, int targetSum) {
      if (root == null) return false;

      // Check if node is leaf node
      if (root.left == null && root.right == null) {
         // Check if leaf node (last node in path) has the remaining sum
         return (root.val == targetSum);
      }

      // Deduct the value of node from the total sum
      int restSum = targetSum - root.val;

      // If any paths propagate up 'true', there is a path sum matching target sum
      return hasPathSum(root.left, restSum) || hasPathSum(root.right, restSum);
   }

   public static void main(String[] args) {
      // Example 1
      TreeNode root1 = new TreeNode(
         5,
         new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
         new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
      );

      DFS_HasPathSum solution = new DFS_HasPathSum();
      int targetSum1 = 22;
      System.out.println("Example 1: " + solution.hasPathSum(root1, targetSum1)); // Output: true

      // Example 2
      TreeNode root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));

      int targetSum2 = 5;
      System.out.println("Example 2: " + solution.hasPathSum(root2, targetSum2)); // Output: false

      // Example 3
      TreeNode root3 = null;
      int targetSum3 = 0;
      System.out.println("Example 3: " + solution.hasPathSum(root3, targetSum3)); // Output: false
   }
}
