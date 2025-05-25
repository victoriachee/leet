/** 617. Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees
 * 
 * ! EASY 
 * #DFS
 * 
 * Given two binary trees root1 and root2, merge them into a new binary tree. If nodes
 * overlap, sum their values; otherwise, use the non-null node. Merging starts from the
 * root nodes. Return the merged tree.
 *
 * Example 1: mergeTrees([1,3,2,5], [2,1,3,null,4,null,7]) => [3,4,5,5,4,null,7]
 * Example 2: mergeTrees([1], [1,2]) => [2,2]
 *
 * Constraints: The number of nodes in both trees is in [0, 2000], Node.val in [-104, 104].
 */

package algos.Tree.BinaryTree;

public class DFS_MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    public TreeNode dfs(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return null;

        int sum = 0;
        if (n1 != null) {
            sum += n1.val;
        }
        if (n2 != null) {
            sum += n2.val;
        }

        TreeNode merged = new TreeNode(sum);

        merged.left = dfs(n1 == null ? null : n1.left, n2 == null ? null : n2.left);
        merged.right = dfs(n1 == null ? null : n1.right, n2 == null ? null : n2.right);

        return merged;
    }

   public static void main(String[] args) {
      DFS_MergeTrees solution = new DFS_MergeTrees();
      // Example 1
      TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
      TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

      TreeNode mergedTree1 = solution.mergeTrees(root1, root2);

      System.out.println("Tree 1:");
      TreePrinter.printTreePreOrder(root1);
      System.out.println("\nTree 2:");
      TreePrinter.printTreePreOrder(root2);
      System.out.println("\nMerged tree 1:");
      TreePrinter.printTreePreOrder(mergedTree1);

      // Example 2
      TreeNode root3 = new TreeNode(1);
      TreeNode root4 = new TreeNode(1, null, new TreeNode(2));

      TreeNode mergedTree2 = solution.mergeTrees(root3, root4);

      System.out.println("\nTree 1:");
      TreePrinter.printTreePreOrder(root3);
      System.out.println("\nTree 2:");
      TreePrinter.printTreePreOrder(root4);
      System.out.println("\nMerged tree 2:");
      TreePrinter.printTreePreOrder(mergedTree2);
   }
}
