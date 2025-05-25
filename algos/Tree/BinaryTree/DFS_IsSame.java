/**
 * The expression isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
 * will return true only if both left and right subtrees are the same for the
 * current nodes p and q. If any part of the subtrees is not equal, it will
 * propagate false up the recursive call stack.
 */

package algos.Tree.BinaryTree;

public class DFS_IsSame {

   public boolean isSameTree(TreeNode p, TreeNode q) {
      // Base cases:
      // 1. Termination condition: If p and q are both null, subtree is equal
      // 2. If either p or q is null but not both (XOR), subtree is not equal
      // 3. If values are not equal, subtree is not equal
      if (p == null && q == null) {
         return true;
      } else if (p == null ^ q == null || p.val != q.val) {
         return false;
      }
      // Recursively checks if left and right subtrees of the current
      // nodes p and q are the same
      return (isSameTree(p.left, q.left)) && isSameTree(p.right, q.right);
   }

   ///!!NOT EFFICIENT:
   // boolean isSame;
   // public boolean isSameTree(TreeNode p, TreeNode q) {
   //     isSame = true;
   //     if (p == null && q == null) {
   //         return isSame;
   //     } else if (p == null ^ q == null) {
   //         return false;
   //     }
   //     dfs(p, q);
   //     return isSame;
   // }
   // public void dfs(TreeNode n1, TreeNode n2) {
   //     // Base cases:
   //     // 1. If node values are not the same
   //     // 2. XOR: One left node is null, the other left node is not
   //     // 2. XOR: One right node is null, the other right node is not
   //     if (n1.val != n2.val
   //     || n1.left == null ^ n2.left == null
   //     || n1.right == null ^ n2.right == null) {
   //         isSame = false;
   //     }
   //     if (n1.left != null && n2.left != null) dfs(n1.left, n2.left);
   //     if (n1.right != null && n2.right != null) dfs(n1.right, n2.right);
   // }

   public static void main(String[] args) {
      DFS_IsSame solution = new DFS_IsSame();

      // Example 1
      TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
      TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
      System.out.println(solution.isSameTree(p1, q1)); // Output: true

      // Example 2
      TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
      TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
      System.out.println(solution.isSameTree(p2, q2)); // Output: false

      // Example 3
      TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
      TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
      System.out.println(solution.isSameTree(p3, q3)); // Output: false
   }
}
