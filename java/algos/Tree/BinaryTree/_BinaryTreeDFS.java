package algos.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A class with common functions to solve generic binary tree questions using DFS.
 */
public class _BinaryTreeDFS {

   /**
    * Example 1: Depth-First Search (DFS) - Preorder Traversal.
    *
    * @param root The root of the binary tree.
    * @return List of values in preorder traversal.
    */
   public static List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      dfsPreorder(root, result);
      return result;
   }

   /**
    * DFS helper function for preorder traversal.
    *
    * @param node   Current node in the traversal.
    * @param result List to store values in preorder traversal.
    */
   private static void dfsPreorder(TreeNode node, List<Integer> result) {
      if (node == null) {
         return;
      }
      result.add(node.val); // Process current node
      dfsPreorder(node.left, result); // Recur on left subtree
      dfsPreorder(node.right, result); // Recur on right subtree
   }

   /**
    * Example 2: Depth-First Search (DFS) - Inorder Traversal.
    *
    * @param root The root of the binary tree.
    * @return List of values in inorder traversal.
    */
   public static List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      dfsInorder(root, result);
      return result;
   }

   /**
    * DFS helper function for inorder traversal.
    *
    * @param node   Current node in the traversal.
    * @param result List to store values in inorder traversal.
    */
   private static void dfsInorder(TreeNode node, List<Integer> result) {
      if (node == null) {
         return;
      }
      dfsInorder(node.left, result); // Recur on left subtree
      result.add(node.val); // Process current node
      dfsInorder(node.right, result); // Recur on right subtree
   }

   /**
    * Example 3: Depth-First Search (DFS) - Postorder Traversal.
    *
    * @param root The root of the binary tree.
    * @return List of values in postorder traversal.
    */
   public static List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      dfsPostorder(root, result);
      return result;
   }

   /**
    * DFS helper function for postorder traversal.
    *
    * @param node   Current node in the traversal.
    * @param result List to store values in postorder traversal.
    */
   private static void dfsPostorder(TreeNode node, List<Integer> result) {
      if (node == null) {
         return;
      }
      dfsPostorder(node.left, result); // Recur on left subtree
      dfsPostorder(node.right, result); // Recur on right subtree
      result.add(node.val); // Process current node
   }

   /**
    * Example 4: Depth-First Search (DFS) - Maximum Depth of Binary Tree.
    *
    * @param root The root of the binary tree.
    * @return Maximum depth of the tree.
    */
   public static int maxDepth(TreeNode root) {
      if (root == null) {
         return 0;
      }
      int leftDepth = maxDepth(root.left);
      int rightDepth = maxDepth(root.right);
      return Math.max(leftDepth, rightDepth) + 1;
   }

   /**
    * Example 5: Depth-First Search (DFS) - Validate Binary Search Tree (BST).
    *
    * @param root The root of the binary tree.
    * @return True if the tree is a valid BST; otherwise, false.
    */
   public static boolean isValidBST(TreeNode root) {
      return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
   }

   /**
    * DFS helper function to validate BST.
    *
    * @param node Current node in the traversal.
    * @param min  Minimum allowed value for the current node.
    * @param max  Maximum allowed value for the current node.
    * @return True if the subtree is a valid BST; otherwise, false.
    */
   private static boolean isValidBSTHelper(TreeNode node, long min, long max) {
      if (node == null) {
         return true;
      }
      if (node.val <= min || node.val >= max) {
         return false;
      }
      return (
         isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max)
      );
   }

   /**
    * Example 6: Depth-First Search (DFS) - Path Sum.
    *
    * @param root The root of the binary tree.
    * @param sum  The target sum.
    * @return True if there exists a root-to-leaf path such that adding up all the values equals the target sum.
    */
   public static boolean hasPathSum(TreeNode root, int sum) {
      if (root == null) {
         return false;
      }

      if (root.left == null && root.right == null) {
         return sum - root.val == 0;
      }

      return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
   }

   /**
    * Example 8: Depth-First Search (DFS) - Lowest Common Ancestor (LCA) of Binary Tree.
    *
    * @param root The root of the binary tree.
    * @param p    Node 1.
    * @param q    Node 2.
    * @return The lowest common ancestor of nodes p and q.
    */
   public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) {
         return root;
      }

      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      if (left != null && right != null) {
         return root;
      } else if (left != null) {
         return left;
      } else {
         return right;
      }
   }

   /**
    * Example 9: Depth-First Search (DFS) - Binary Tree Paths.
    *
    * @param root The root of the binary tree.
    * @return List of all root-to-leaf paths.
    */
   public static List<String> binaryTreePaths(TreeNode root) {
      List<String> result = new ArrayList<>();
      if (root != null) {
         dfsBinaryTreePaths(root, "", result);
      }
      return result;
   }

   /**
    * DFS helper function for binary tree paths.
    *
    * @param node   Current node in the traversal.
    * @param path   Current path string.
    * @param result List to store root-to-leaf paths.
    */
   private static void dfsBinaryTreePaths(TreeNode node, String path, List<String> result) {
      if (node.left == null && node.right == null) {
         result.add(path + node.val);
         return;
      }

      if (node.left != null) {
         dfsBinaryTreePaths(node.left, path + node.val + "->", result);
      }

      if (node.right != null) {
         dfsBinaryTreePaths(node.right, path + node.val + "->", result);
      }
   }

   /**
    * Example 10: Depth-First Search (DFS) - Sum of Left Leaves.
    *
    * @param root The root of the binary tree.
    * @return The sum of all left leaves in the binary tree.
    */
   public static int sumOfLeftLeaves(TreeNode root) {
      if (root == null) {
         return 0;
      }

      int sum = 0;
      if (root.left != null && root.left.left == null && root.left.right == null) {
         sum += root.left.val;
      }

      sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
      return sum;
   }

   /**
    * Example 11: Depth-First Search (DFS) - Invert Binary Tree.
    *
    * @param root The root of the binary tree.
    * @return The root of the inverted binary tree.
    */
   public static TreeNode invertTree(TreeNode root) {
      if (root == null) {
         return null;
      }

      TreeNode left = invertTree(root.left);
      TreeNode right = invertTree(root.right);

      root.left = right;
      root.right = left;

      return root;
   }

   /**
    * Example 12: Depth-First Search (DFS) - Symmetric Tree.
    *
    * @param root The root of the binary tree.
    * @return True if the binary tree is symmetric, false otherwise.
    */
   public static boolean isSymmetric(TreeNode root) {
      if (root == null) {
         return true;
      }

      return isMirror(root.left, root.right);
   }

   private static boolean isMirror(TreeNode left, TreeNode right) {
      if (left == null && right == null) {
         return true;
      }

      if (left == null || right == null) {
         return false;
      }

      return (
         (left.val == right.val) &&
         isMirror(left.left, right.right) &&
         isMirror(left.right, right.left)
      );
   }

   /**
    * Example 13: Convert a binary search tree to a sorted doubly linked list.
    *
    * @param root The root of the binary search tree.
    * @return The head of the sorted doubly linked list.
    */
   public static TreeNode treeToDoublyList(TreeNode root) {
      if (root == null) {
         return null;
      }

      TreeNode[] prev = { null };
      TreeNode[] head = { null };

      convertToDoublyList(root, prev, head);
      return head[0];
   }

   private static void convertToDoublyList(TreeNode node, TreeNode[] prev, TreeNode[] head) {
      if (node == null) {
         return;
      }

      convertToDoublyList(node.left, prev, head);

      if (prev[0] == null) {
         head[0] = node; // Set head when visiting the leftmost node
      } else {
         prev[0].right = node;
         node.left = prev[0];
      }

      prev[0] = node; // Update prev for the next iteration

      convertToDoublyList(node.right, prev, head);
   }

   /**
    * Example 14: Check if a binary tree contains a cycle.
    *
    * @param root The root of the binary tree.
    * @return True if the tree contains a cycle, false otherwise.
    */
   public static boolean hasCycle(TreeNode root) {
      Set<TreeNode> visited = new HashSet<>();
      return hasCycleDFS(root, visited);
   }

   private static boolean hasCycleDFS(TreeNode node, Set<TreeNode> visited) {
      if (node == null) {
         return false;
      }

      if (visited.contains(node)) {
         return true; // Node is visited again, indicating a cycle
      }

      visited.add(node);

      return hasCycleDFS(node.left, visited) || hasCycleDFS(node.right, visited);
   }

   /**
    * Main method to demonstrate and test the binary tree DFS functions.
    *
    * @param args Command-line arguments (not used).
    */
   public static void main(String[] args) {
      // Example usage and testing
      TreeNode root = new TreeNode(1);
      root.right = new TreeNode(2);
      root.right.left = new TreeNode(3);

      System.out.println("Preorder Traversal: " + preorderTraversal(root));
      System.out.println("Inorder Traversal: " + inorderTraversal(root));
      System.out.println("Postorder Traversal: " + postorderTraversal(root));
      System.out.println("Maximum Depth: " + maxDepth(root));

      TreeNode validBST = new TreeNode(2);
      validBST.left = new TreeNode(1);
      validBST.right = new TreeNode(3);
      System.out.println("Is Valid BST: " + isValidBST(validBST));

      TreeNode invalidBST = new TreeNode(5);
      invalidBST.left = new TreeNode(1);
      invalidBST.right = new TreeNode(4);
      invalidBST.right.left = new TreeNode(3);
      invalidBST.right.right = new TreeNode(6);
      System.out.println("Is Valid BST: " + isValidBST(invalidBST));

      // Example usage and testing
      TreeNode root2 = new TreeNode(1);
      root2.left = new TreeNode(2);
      root2.right = new TreeNode(3);
      root2.left.left = new TreeNode(4);
      root2.left.right = new TreeNode(5);

      System.out.println("Has Path Sum (sum=7): " + hasPathSum(root2, 7));
      System.out.println(
         "Lowest Common Ancestor (p=2, q=3): " +
         lowestCommonAncestor(root2, root2.left, root2.right).val
      );

      TreeNode pathsRoot = new TreeNode(1);
      pathsRoot.left = new TreeNode(2);
      pathsRoot.right = new TreeNode(3);
      pathsRoot.left.right = new TreeNode(5);

      System.out.println("Binary Tree Paths: " + binaryTreePaths(pathsRoot));

      // Example usage and testing
      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);

      System.out.println("Sum of Left Leaves: " + sumOfLeftLeaves(root));
      System.out.println("Maximum Depth: " + maxDepth(root));

      TreeNode invertRoot = new TreeNode(4);
      invertRoot.left = new TreeNode(2);
      invertRoot.right = new TreeNode(7);
      invertRoot.left.left = new TreeNode(1);
      invertRoot.left.right = new TreeNode(3);
      invertRoot.right.left = new TreeNode(6);
      invertRoot.right.right = new TreeNode(9);

      System.out.println("Inverted Binary Tree: " + invertTree(invertRoot).toString());

      TreeNode symmetricRoot = new TreeNode(1);
      symmetricRoot.left = new TreeNode(2);
      symmetricRoot.right = new TreeNode(2);
      symmetricRoot.left.left = new TreeNode(3);
      symmetricRoot.left.right = new TreeNode(4);
      symmetricRoot.right.left = new TreeNode(4);
      symmetricRoot.right.right = new TreeNode(3);

      System.out.println("Is Symmetric Tree: " + isSymmetric(symmetricRoot));

      // Example 6: Convert to Doubly List
      TreeNode bst = new TreeNode(
         4,
         new TreeNode(2, new TreeNode(1), new TreeNode(3)),
         new TreeNode(5)
      );
      TreeNode sortedList = treeToDoublyList(bst);
      System.out.print("Sorted Doubly Linked List: ");
      TreePrinter.printDoublyList(sortedList);
      // Example 9: Cyclic Tree
      TreeNode cyclicTree = new TreeNode(1);
      cyclicTree.left = new TreeNode(2);
      cyclicTree.right = new TreeNode(3);
      cyclicTree.left.left = new TreeNode(4);
      cyclicTree.left.right = cyclicTree.right; // Creating a cycle

      boolean hasCycle = hasCycle(cyclicTree);
      System.out.println("Tree Has Cycle: " + hasCycle);
   }
}
