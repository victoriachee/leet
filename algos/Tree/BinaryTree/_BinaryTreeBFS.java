package algos.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * A class with common functions for binary tree questions using Breadth-First Search (BFS).
 */
public class _BinaryTreeBFS {

   /**
    * Example 1: Breadth-First Search (BFS) - Maximum Depth of Binary Tree.
    *
    * @param root The root of the binary tree.
    * @return The maximum depth of the binary tree.
    */
   public static int maxDepth(TreeNode root) {
      // Base case: If the tree is empty, the depth is 0.
      if (root == null) {
         return 0;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Start with the root node.
      queue.offer(root);
      // Initialize the depth to 0.
      int depth = 0;

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Get the number of nodes at the current level.
         int size = queue.size();

         // Process all nodes at the current level.
         for (int i = 0; i < size; i++) {
            // Remove the current node from the queue.
            TreeNode node = queue.poll();

            // Enqueue the left child if exists.
            if (node.left != null) {
               queue.offer(node.left);
            }

            // Enqueue the right child if exists.
            if (node.right != null) {
               queue.offer(node.right);
            }
         }

         // Increment the depth after processing all nodes at the current level.
         depth++;
      }

      // The final depth represents the maximum depth of the binary tree.
      return depth;
   }

   /**
    * Example 2: Breadth-First Search (BFS) - Minimum Depth of Binary Tree.
    *
    * @param root The root of the binary tree.
    * @return The minimum depth of the binary tree.
    */
   public static int minDepth(TreeNode root) {
      // Base case: If the tree is empty, the depth is 0.
      if (root == null) {
         return 0;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Start with the root node.
      queue.offer(root);
      // Initialize the depth to 0.
      int depth = 0;

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Get the number of nodes at the current level.
         int size = queue.size();
         // Increment depth at the start of each level.
         depth++;

         // Process all nodes at the current level.
         for (int i = 0; i < size; i++) {
            // Remove the current node from the queue.
            TreeNode node = queue.poll();

            // Check if the current node is a leaf node.
            if (node.left == null && node.right == null) {
               // If it is, return the current depth as the minimum depth.
               return depth;
            }

            // Enqueue the left child if exists.
            if (node.left != null) {
               queue.offer(node.left);
            }

            // Enqueue the right child if exists.
            if (node.right != null) {
               queue.offer(node.right);
            }
         }
      }

      // The final depth represents the minimum depth of the binary tree.
      return depth;
   }

   /**
    * Example 3: Breadth-First Search (BFS) - Level Order Traversal.
    *
    * @param root The root of the binary tree.
    * @return The level order traversal of the binary tree.
    */
   public static List<List<Integer>> levelOrder(TreeNode root) {
      // Result list to store the level order traversal.
      List<List<Integer>> result = new ArrayList<>();

      // Base case: If the tree is empty, return an empty result.
      if (root == null) {
         return result;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Start with the root node.
      queue.offer(root);

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Get the number of nodes at the current level.
         int size = queue.size();
         // List to store nodes at the current level.
         List<Integer> levelNodes = new ArrayList<>();

         // Process all nodes at the current level.
         for (int i = 0; i < size; i++) {
            // Remove the current node from the queue.
            TreeNode node = queue.poll();
            // Add the value of the current node to the levelNodes list.
            levelNodes.add(node.val);

            // Enqueue the left child if exists.
            if (node.left != null) {
               queue.offer(node.left);
            }

            // Enqueue the right child if exists.
            if (node.right != null) {
               queue.offer(node.right);
            }
         }

         // Add the levelNodes list to the result list.
         result.add(levelNodes);
      }

      // The final result represents the level order traversal of the binary tree.
      return result;
   }

   /**
    * Example 4: Breadth-First Search (BFS) - Zigzag Level Order Traversal.
    *
    * @param root The root of the binary tree.
    * @return The zigzag level order traversal of the binary tree.
    */
   public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      // Result list to store the zigzag level order traversal.
      List<List<Integer>> result = new ArrayList<>();

      // Base case: If the tree is empty, return an empty result.
      if (root == null) {
         return result;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Start with the root node.
      queue.offer(root);
      // Flag to indicate the direction of traversal (left to right or right to left).
      boolean leftToRight = true;

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Get the number of nodes at the current level.
         int size = queue.size();
         // List to store nodes at the current level.
         List<Integer> levelNodes = new LinkedList<>();

         // Process all nodes at the current level.
         for (int i = 0; i < size; i++) {
            // Remove the current node from the queue.
            TreeNode node = queue.poll();

            // Add the value of the current node based on the traversal direction.
            if (leftToRight) {
               levelNodes.add(node.val);
            } else {
               levelNodes.add(0, node.val); // Add to the front for right to left traversal.
            }

            // Enqueue the left child if exists.
            if (node.left != null) {
               queue.offer(node.left);
            }

            // Enqueue the right child if exists.
            if (node.right != null) {
               queue.offer(node.right);
            }
         }

         // Switch the traversal direction for the next level.
         leftToRight = !leftToRight;
         // Add the levelNodes list to the result list.
         result.add(levelNodes);
      }

      // The final result represents the zigzag level order traversal of the binary tree.
      return result;
   }

   /**
    * Example 5: Find the Maximum Value in a Binary Tree.
    *
    * @param root The root of the binary tree.
    * @return The maximum value in the binary tree.
    */
   public static int findMaxValue(TreeNode root) {
      // Base case: If the tree is empty, return a sentinel value.
      if (root == null) {
         return Integer.MIN_VALUE;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Start with the root node.
      queue.offer(root);

      // Variable to track the maximum value found.
      int maxValue = Integer.MIN_VALUE;

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Remove the current node from the queue.
         TreeNode node = queue.poll();

         // Update the maximum value if the current node's value is greater.
         maxValue = Math.max(maxValue, node.val);

         // Enqueue the left child if exists.
         if (node.left != null) {
            queue.offer(node.left);
         }

         // Enqueue the right child if exists.
         if (node.right != null) {
            queue.offer(node.right);
         }
      }

      // The final result is the maximum value found in the binary tree.
      return maxValue;
   }

   /**
    * Example 6: Check if a Binary Tree is Symmetric.
    *
    * @param root The root of the binary tree.
    * @return True if the binary tree is symmetric, false otherwise.
    */
   public static boolean isSymmetric(TreeNode root) {
      // Base case: If the tree is empty, it is symmetric.
      if (root == null) {
         return true;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Enqueue the root's left and right children.
      queue.offer(root.left);
      queue.offer(root.right);

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Remove two nodes from the queue for comparison.
         TreeNode leftNode = queue.poll();
         TreeNode rightNode = queue.poll();

         // Check if the values of the two nodes are equal.
         if (leftNode == null && rightNode == null) {
            // Both nodes are null, continue with the next pair of nodes.
            continue;
         }

         if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            // Nodes are not symmetric, return false.
            return false;
         }

         // Enqueue the left and right children of the current nodes for further comparison.
         queue.offer(leftNode.left);
         queue.offer(rightNode.right);
         queue.offer(leftNode.right);
         queue.offer(rightNode.left);
      }

      // If the loop completes, the tree is symmetric.
      return true;
   }

   /**
    * Example 7: Check if a Binary Tree is a Complete Binary Tree.
    *         1
    *        / \
    *       2   3 Complete if level (left & right nodes) is filled.
    *        / \
    *       4   5
    *
    * @param root The root of the binary tree.
    * @return True if the binary tree is complete, false otherwise.
    */
   public static boolean isCompleteBinaryTree(TreeNode root) {
      // Base case: If the tree is empty, it is complete.
      if (root == null) {
         return true;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Enqueue the root node.
      queue.offer(root);

      // Flag to indicate whether non-full nodes have been encountered.
      boolean nonFullNodeSeen = false;

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Remove the current node from the queue.
         TreeNode node = queue.poll();

         if (node == null) {
            // Set the flag to indicate that a non-full node has been encountered.
            nonFullNodeSeen = true;
         } else {
            // If a non-full node has been encountered earlier, and the current node is not null,
            // the tree is not complete.
            if (nonFullNodeSeen) {
               return false;
            }

            // Enqueue the left and right children of the current node.
            queue.offer(node.left);
            queue.offer(node.right);
         }
      }

      // If the loop completes, the tree is complete.
      return true;
   }

   /**
    * Example 8: Find the Level of a Given Node in a Binary Tree.
    *
    * @param root The root of the binary tree.
    * @param target The value of the target node.
    * @return The level of the target node if found, -1 otherwise.
    */
   public static int findNodeLevel(TreeNode root, int target) {
      // Base case: If the tree is empty, return -1.
      if (root == null) {
         return -1;
      }

      // Create a queue to perform BFS.
      Queue<TreeNode> queue = new LinkedList<>();
      // Enqueue the root node along with its level.
      queue.offer(root);
      queue.offer(null); // Null is used as a marker for levels.

      // Variable to track the current level.
      int level = 0;

      // Continue BFS until the queue is empty.
      while (!queue.isEmpty()) {
         // Remove the current node from the queue.
         TreeNode node = queue.poll();

         if (node == null) {
            // If the current node is null, increment the level and enqueue a null marker for the next level.
            level++;
            if (!queue.isEmpty()) {
               queue.offer(null);
            }
         } else {
            // Check if the current node has the target value.
            if (node.val == target) {
               return level;
            }

            // Enqueue the left and right children of the current node.
            if (node.left != null) {
               queue.offer(node.left);
            }
            if (node.right != null) {
               queue.offer(node.right);
            }
         }
      }

      // If the loop completes and the target node is not found, return -1.
      return -1;
   }

   /**
    * Example 9: Check if a binary tree contains a cycle using BFS.
    *
    * @param root The root of the binary tree.
    * @return True if the tree contains a cycle, false otherwise.
    */
   public static boolean hasCycleBFS(TreeNode root) {
      if (root == null) {
         return false;
      }

      Set<TreeNode> visited = new HashSet<>();
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         TreeNode node = queue.poll();

         if (visited.contains(node)) {
            return true; // Node is visited again, indicating a cycle
         }

         visited.add(node);

         if (node.left != null) {
            queue.offer(node.left);
         }

         if (node.right != null) {
            queue.offer(node.right);
         }
      }

      return false;
   }

   /**
    * Main method to demonstrate and test BFS functions.
    *
    * @param args Command-line arguments (not used).
    */
   public static void main(String[] args) {
      // Example usage and testing
      TreeNode root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);

      // Maximum Depth of Binary Tree
      System.out.println("Maximum Depth of Binary Tree: " + maxDepth(root));

      // Minimum Depth of Binary Tree
      System.out.println("Minimum Depth of Binary Tree: " + minDepth(root));

      root = new TreeNode(3);
      root.left = new TreeNode(9);
      root.right = new TreeNode(20);
      root.right.left = new TreeNode(15);
      root.right.right = new TreeNode(7);

      // Level Order Traversal
      List<List<Integer>> levelOrderResult = levelOrder(root);
      System.out.println("Level Order Traversal: " + levelOrderResult);

      // Zigzag Level Order Traversal
      List<List<Integer>> zigzagLevelOrderResult = zigzagLevelOrder(root);
      System.out.println("Zigzag Level Order Traversal: " + zigzagLevelOrderResult);
      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(2);
      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);
      root.right.left = new TreeNode(4);
      root.right.right = new TreeNode(3);

      // Find Maximum Value
      int maxValue = findMaxValue(root);
      System.out.println("Maximum Value in the Binary Tree: " + maxValue);

      // Check if the Binary Tree is Symmetric
      boolean isSymmetric = isSymmetric(root);
      System.out.println("Is the Binary Tree Symmetric? " + isSymmetric);
      root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);

      // Check if the Binary Tree is a Complete Binary Tree
      boolean isComplete = isCompleteBinaryTree(root);
      System.out.println("Is the Binary Tree a Complete Binary Tree? " + isComplete);

      // Find the Level of a Given Node
      int targetNodeValue = 5;
      int nodeLevel = findNodeLevel(root, targetNodeValue);
      System.out.println("Level of Node with value " + targetNodeValue + ": " + nodeLevel);
      
      // Example 10: Cyclic Tree
      TreeNode cyclicTree = new TreeNode(1);
      cyclicTree.left = new TreeNode(2);
      cyclicTree.right = new TreeNode(3);
      cyclicTree.left.left = new TreeNode(4);
      cyclicTree.left.right = cyclicTree.right; // Creating a cycle

      boolean hasCycle = hasCycleBFS(cyclicTree);
      System.out.println("Tree Has Cycle (BFS): " + hasCycle);
   }
}
