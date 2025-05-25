// EASY
// #DFS  #Recursion

package algos.Tree.BinaryTree;

public class DFS_FindMaxDepth {

   private int maxDepth;

   public int maxDepth(TreeNode root) {
      maxDepth = 0;
      if (root != null) dfs(root, 1);
      return maxDepth;
   }

   public void dfs(TreeNode node, Integer curr) {
      if (node.left == null && node.right == null) {
         maxDepth = Math.max(maxDepth, curr);
      }
      curr++;
      if (node.left != null) dfs(node.left, curr);
      if (node.right != null) dfs(node.right, curr);
   }

   public static void main(String[] args) {
      // Create an instance of the solution class
      DFS_FindMaxDepth solution = new DFS_FindMaxDepth();

      // Example 1
      TreeNode root1 = new TreeNode(
         3,
         new TreeNode(9),
         new TreeNode(20, new TreeNode(15), new TreeNode(7))
      );
      System.out.println("Example 1: " + solution.maxDepth(root1));

      // Example 2
      TreeNode root2 = new TreeNode(1, null, new TreeNode(2));
      System.out.println("Example 2: " + solution.maxDepth(root2));
   }
}
