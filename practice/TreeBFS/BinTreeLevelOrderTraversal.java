package practice.TreeBFS;

import java.util.*;


public class BinTreeLevelOrderTraversal {

    // Goal: Level-order traversal of a binary tree
    // Input: Root of a binary tree
    // Output: Return list of lists where each sublist contains node values 
    // at that level of the tree
    // Approach: 
    // Use a queue to store nodes at each level, iterate until queue is empty.
    // At each level, dequeue the head of queue, add its value to the list for this level.
    // Then visit and enqueue its children.
    public List<List<Integer>> levelOrder(TreeNode root) {

        
        // 1. Initialization
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res; // 2. Edge cases

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        // 3. Level-order traversal
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelIntegers = new ArrayList<Integer>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                levelIntegers.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            res.add(levelIntegers);
        }

        // 4. Return lists of integers level by level
        return res;
    }

    public static void main(String[] args) {
        BinTreeLevelOrderTraversal tree = new BinTreeLevelOrderTraversal();

        // Create a sample binary tree: [3,9,20,null,null,15,7]
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> result = tree.levelOrder(node1);
        
        System.out.println("Level-order traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
