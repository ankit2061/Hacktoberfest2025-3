// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeMaximumPathSum {
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    // Helper returns max path sum extending from this node down to one child
    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Calculate max path sum from left and right subtree
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);

        // Calculate max path sum WITH split at this node (through left + node + right)
        int currentMax = node.val + left + right;

        // Update global maxSum if current path sum is higher
        maxSum = Math.max(maxSum, currentMax);

        // Return max path sum extending down from this node to parent
        return node.val + Math.max(left, right);
    }

    // Example main to test
    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-10, 
                         new TreeNode(9), 
                         new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.maxPathSum(root));  // Output: 42
    }
}
