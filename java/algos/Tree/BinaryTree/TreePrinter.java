package algos.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePrinter {

   /** Pre-order traversal of a binary tree **/
   // It prints the root node, then the left subtree, and finally the right subtree.
   static void printTreePreOrder(TreeNode node) {
      if (node == null) {
         return;
      }
      System.out.print(node.val + " ");
      printTreePreOrder(node.left);
      printTreePreOrder(node.right);
   }

   /** In-order traversal of a binary tree **/
   // It prints the left subtree, then the root node, and finally the right subtree.
   static void printTreeInOrder(TreeNode root) {
      if (root != null) {
         printTreeInOrder(root.left);
         System.out.print(root.val + " ");
         printTreeInOrder(root.right);
      }
   }

   /** Level-order traversal/Breadth-first traversal of a binary tree **/
   static void printTreeArray(TreeNode root) {
      System.out.println("Tree Representation as Array: " + Arrays.toString(treeToArrayLevelOrder(root)));
   }

   private static Integer[] treeToArrayLevelOrder(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
         return result.toArray(new Integer[0]);
      }

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);

      while (!queue.isEmpty()) {
         TreeNode current = queue.poll();
         if (current == null) {
            result.add(null);
         } else {
            result.add(current.val);
            queue.offer(current.left);
            queue.offer(current.right);
         }
      }

      return result.toArray(new Integer[0]);
   }

    public static void printDoublyList(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }
}
