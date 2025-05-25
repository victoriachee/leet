// EASY
// #DFS  #BinaryTree  #Recursion

package algos.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Initializing the res list as a class member is a good approach since it
 * avoids passing it as a parameter through the recursive calls.
 *
 * You correctly handle the base case when you encounter a leaf node, and you
 * add the path to the result list.
 */

public class DFS_GetPaths {

   private List<String> res;

   public List<String> binaryTreePaths(TreeNode root) {
      res = new ArrayList<>();
      if (root != null) dfs(root, "");
      return res;
   }

   public void dfs(TreeNode node, String path) {
      // If node is a leaf node, add path to res array
      if (node.left == null && node.right == null) res.add(path + node.val);

      if (node.left != null) dfs(node.left, path + node.val + "->");
      if (node.right != null) dfs(node.right, path + node.val + "->");
   }

   public static void main(String[] args) {
      DFS_GetPaths solution = new DFS_GetPaths();
      // Example usage:
      TreeNode root1 = new TreeNode(
         1,
         new TreeNode(2, null, new TreeNode(5)),
         new TreeNode(3)
      );
      System.out.println(solution.binaryTreePaths(root1));
      // Output: ["1->2->5", "1->3"]

      TreeNode root2 = new TreeNode(1);
      System.out.println(solution.binaryTreePaths(root2));
      // Output: ["1"]
   }
}
