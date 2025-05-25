/**
 * 226. Invert Binary Tree
 * URL: https://leetcode.com/problems/invert-binary-tree/
 * ! EASY
 * #DFS  #BFS  #Recursion  #Iterative
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1: Input: root = [4,2,7,1,3,6,9], Output: [4,7,2,9,6,3,1]
 * Example 2: Input: root = [2,1,3], Output: [2,3,1]
 * Example 3: Input: root = [], Output: []
 *
 * Constraints:
 * Number of tree nodes in range [0, 100], -100 <= Node.val <= 100
 * https://leetcode.com/problems/invert-binary-tree/solutions/2463600/easy-100-fully-explained-java-c-python-js-c-python3-recursive-iterative/
 */

package algos.Tree.BinaryTree;

import java.util.LinkedList;

class DFS_BFS_InvertTree {

   /** DFS: Recursive Approach: **/
   // Runtime: 0 ms, faster than 100.00% of Java submissions
   // Time Complexity : O(n)
   // Space Complexity : O(n)
   public static TreeNode invertTreeDFS(TreeNode root) {
      // Base case: if the tree is empty...
      if (root == null) {
         return root;
      }
      // Call the function recursively for the left subtree...
      invertTreeDFS(root.left);
      // Call the function recursively for the right subtree...
      invertTreeDFS(root.right);
      // Swapping process...
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      return root; // Return the root...
   }

   /** BFS: Iterative Approach: **/
   // Runtime: 0 ms, faster than 100.00% of Java submissions
   // Time Complexity : O(n)
   // Space Complexity : O(n)
   public static TreeNode invertTreeBFS(TreeNode root) {
      LinkedList<TreeNode> q = new LinkedList<TreeNode>();
      // Base case: if the tree is empty...
      if (root == null) return null;
      if (root != null) {
         // Push the root node...
         q.add(root);
      }
      // Loop till queue is empty...
      while (!q.isEmpty()) {
         // Dequeue front node...
         TreeNode node = q.poll();
         // Enqueue left child of the popped node...
         if (node.left != null) q.add(node.left);
         // Enqueue right child of the popped node
         if (node.right != null) q.add(node.right);
         // Swapping process...
         TreeNode temp = node.left;
         node.left = node.right;
         node.right = temp;
      }
      return root; // Return the root...
   }

   public static void main(String[] args) {
      // Create a sample binary tree
      TreeNode root = new TreeNode(
         4,
         new TreeNode(2, new TreeNode(1), new TreeNode(3)),
         new TreeNode(7, new TreeNode(6), new TreeNode(9))
      );
      System.out.println("Initial Binary Tree 1: ");
      TreePrinter.printTreePreOrder(root);
      System.out.println();

      // Invert the binary tree
      TreeNode invertedRoot = invertTreeDFS(root);

      // Print the inverted binary tree (you can implement a print method for
      // TreeNode)
      System.out.println("Inverted Binary Tree 1: ");
      TreePrinter.printTreePreOrder(invertedRoot);

      // Create a sample binary tree
      TreeNode root2 = new TreeNode(
         4,
         new TreeNode(2, new TreeNode(1), new TreeNode(3)),
         new TreeNode(7, new TreeNode(6), new TreeNode(9))
      );
      
      System.out.println();
      System.out.println("Initial Binary Tree 2: ");
      TreePrinter.printTreePreOrder(root2);
      System.out.println();

      // Invert the binary tree
      TreeNode invertedRoot2 = invertTreeBFS(root2);

      // Print the inverted binary tree (you can implement a print method for
      // TreeNode)
      System.out.println("Inverted Binary Tree 2: ");
      TreePrinter.printTreePreOrder(invertedRoot2);
   }
}
