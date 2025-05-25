/**
 * 572. Subtree of Another Tree
 * ! EASY
 * #DFS  #BinaryTree
 * Given roots of binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot, false otherwise.
 *
 * A subtree is a tree that consists of a node in the main tree and all
 * of its descendants. The main tree could also be considered a subtree of itself.
 *
 * Example 1: Input: root = [3,4,5,1,2], subRoot = [4,1,2],
 * Output: true
 * Example 2: Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2],
 * Output: false
 *
 * Constraints: -10^4 <= root.val <= 10^4, -10^4 <= subRoot.val <= 10^4,
 * root tree number of nodes = [1, 2000], subRoot tree number of nodes = [1, 1000]
 */

package algos.Tree.BinaryTree;

public class DFS_IsSubtree {

   public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (root == null) return false;
      if (dfs(root, subRoot)) return true;
      return isSubtree(root.left, subRoot.left) || isSubtree(root.right, subRoot.right);
   }

   private static boolean dfs(TreeNode root, TreeNode subRoot) {
      if (root == null && subRoot == null) return true;
      if (root == null ^ subRoot == null) return false;
      if (root.val != subRoot.val) return false;
      return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
   }

   public static void main(String[] args) {
      // Example 1
      TreeNode root1 = new TreeNode(3);
      root1.left = new TreeNode(4);
      root1.right = new TreeNode(5);
      root1.left.left = new TreeNode(1);
      root1.left.right = new TreeNode(2);

      TreeNode subRoot1 = new TreeNode(4);
      subRoot1.left = new TreeNode(1);
      subRoot1.right = new TreeNode(2);

      System.out.println(isSubtree(root1, subRoot1)); // Output: true

      // Example 2
      TreeNode root2 = new TreeNode(3);
      root2.left = new TreeNode(4);
      root2.right = new TreeNode(5);
      root2.left.left = new TreeNode(1);
      root2.left.right = new TreeNode(2);
      root2.right.right = new TreeNode(0);

      TreeNode subRoot2 = new TreeNode(4);
      subRoot2.left = new TreeNode(1);
      subRoot2.right = new TreeNode(2);

      System.out.println(isSubtree(root2, subRoot2)); // Output: false
   }
}
