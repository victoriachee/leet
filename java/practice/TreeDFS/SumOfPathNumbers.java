package practice.TreeDFS;

public class SumOfPathNumbers {
    /**
     * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
     * 
     * The function `sumNumbers` calculates the sum of all root-to-leaf numbers represented by a binary
     * tree.
     * 
     * @param root The `root` parameter in the `sumNumbers` method is of type `TreeNode`, which
     * represents a node in a binary tree. This parameter is the root node of the binary tree for which
     * we want to calculate the sum of numbers formed by concatenating the node values along the paths
     * from the root
     * @return The `sumNumbers` method is returning the result of calling the `dfs` method with the
     * `root` node of a binary tree and an empty string as parameters.
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, "");
    }

    public int dfs(TreeNode curr, String pathSum) {
        if (curr == null) return 0; // no number to add

        // this is more efficient, 0ms instead of 8ms (make pathSum an int):
        // pathSum = pathSum * 10 + curr.val; 
        pathSum += curr.val;

        // Handle leaf node
        if (curr.left == null && curr.right == null) {
            return Integer.parseInt(pathSum);
        }

        int leftPathSum = dfs(curr.left, pathSum);
        int rightPathSum = dfs(curr.right, pathSum);

        return leftPathSum + rightPathSum; //sum of both subtrees of a root node
    }
    

    // Main method to test the function
    public static void main(String[] args) {
        SumOfPathNumbers solution = new SumOfPathNumbers();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;

        System.out.println("Sum of root-to-leaf numbers: " + solution.sumNumbers(node1)); // Should print 25

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(5);
        TreeNode node8 = new TreeNode(1);

        node4.left = node5;
        node4.right = node6;
        node5.left = node7;
        node5.right = node8;

        System.out.println("Sum of root-to-leaf numbers: " + solution.sumNumbers(node4)); // Should print 1026
    }
}
