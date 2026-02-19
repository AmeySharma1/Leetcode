/*
 * Problem: 124. Binary Tree Maximum Path Sum
 *
 * Given:
 * - Root of a binary tree
 *
 * Task:
 * - Return the maximum path sum.
 *
 * Path:
 * - Can start and end at ANY node.
 * - Must follow parent-child connections.
 * - Cannot revisit nodes.
 *
 * -------------------------------------------------------
 * Key Idea:
 *
 * At every node:
 *
 * 1. Get maximum contribution from left subtree
 * 2. Get maximum contribution from right subtree
 *
 * Important:
 * - Ignore negative paths (use max(0, subtreeSum))
 *
 * Two things happen at each node:
 *
 * 1) Update global answer:
 *      root.val + left + right
 *      (path passing through current node)
 *
 * 2) Return to parent:
 *      root.val + max(left, right)
 *      (only ONE side allowed upward)
 *
 * -------------------------------------------------------
 * Why ignore negative paths?
 *
 * If a subtree gives negative sum,
 * including it would reduce total path sum.
 * So we treat it as 0.
 *
 * -------------------------------------------------------
 * Dry Run:
 *
 *        -10
 *        /  \
 *       9    20
 *           /  \
 *          15   7
 *
 * At node 15 → 15
 * At node 7  → 7
 *
 * At node 20:
 * left = 15
 * right = 7
 * maxPathSum = 20 + 15 + 7 = 42
 *
 * Final Answer = 42
 *
 * Path: 15 → 20 → 7
 *
 * -------------------------------------------------------
 * Pseudocode:
 *
 * maxPathSum = -∞
 *
 * function helper(node):
 *
 *      if node == null:
 *          return 0
 *
 *      left = max(0, helper(node.left))
 *      right = max(0, helper(node.right))
 *
 *      maxPathSum = max(maxPathSum,
 *                       node.val + left + right)
 *
 *      return node.val + max(left, right)
 *
 *
 * function maxPathSum(root):
 *      helper(root)
 *      return maxPathSum
 *
 * -------------------------------------------------------
 * Time Complexity:
 * O(n)
 *
 * Space Complexity:
 * O(h)   (recursion stack)
 *
 * Pattern:
 * Tree + DFS + Global Maximum Tracking
 *
 * -------------------------------------------------------
 * Code:
 */

class Solution {

    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxPathSum;
    }

    private int helper(TreeNode root) {

        if (root == null) return 0;

        // Ignore negative contributions
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        // Update global max (path through current node)
        maxPathSum = Math.max(maxPathSum,
                              root.val + left + right);

        // Return best single path upward
        return root.val + Math.max(left, right);
    }
}
